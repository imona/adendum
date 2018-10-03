package service.insert;

import model.annotation.SubEntityList;
import service.contracts.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

public class ModelNativeSaver implements IModelSaver {
    private Class forClazz;
    private IFieldsGenerator fieldsListGenerator = new FieldsGenerator();
    private INativeInsertExecuter nativeInsertExecuter;
    private ISubEntityProcessor subEntityProcessor = new SubEntityListProcessor();
    private IInsertStatementGenerator insertStatementGenerator;

    public ModelNativeSaver(Class forClazz) throws ClassNotFoundException {
        this.forClazz = forClazz;
        InsertServiceFactory.getInsertStatementGeneratorInstance(forClazz);
        this.insertStatementGenerator = InsertServiceFactory.getInsertStatementGeneratorInstance(forClazz);
        this.nativeInsertExecuter = InsertServiceFactory.getINativeInsertExecuterInstance(forClazz);
    }

    @Override
    public int persist(List objectList) throws Exception {
        try {
            if (objectList.size() == 0) {
                return 0;
            }

            List<Field> columnFields = this.fieldsListGenerator.retrieveFieldsToBeInserted(forClazz);
            Field[] fieldsArr = columnFields.toArray(new Field[columnFields.size()]);
            String sql = insertStatementGenerator.generateInsertStatement(forClazz, objectList.size(), fieldsArr);
            nativeInsertExecuter.executeInsertStatement(sql, objectList, fieldsArr);

            //DO : 1- get SubEntityList.
            List<Field> subEntityFields = this.fieldsListGenerator.getSubEntityListTypeOfFields(forClazz);
            for (Field f : subEntityFields) {
                //DO : 2- Recusive Save.
                subEntityProcessor.processSubEntity(f, objectList);
            }
            //DO : 3- Save relation.
            for (Field f : subEntityFields) {
                SubEntityList subEntityList = f.getAnnotation(SubEntityList.class);
                Class<? extends RelationTableResolver> resolverClzz = subEntityList.relationResolver();
                Constructor<? extends RelationTableResolver> constructor = resolverClzz.getConstructor();
                RelationTableResolver relationTableResolver = constructor.newInstance();
                relationTableResolver.prepareRelationList(objectList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 1;
    }
}
