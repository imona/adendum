package service;

import model.annotation.ColumnName;
import model.annotation.SubEntityList;
import service.contracts.IFieldsGenerator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FieldsGenerator implements IFieldsGenerator {
    public List<Field> retrieveFieldsToBeInserted(Class forClazz) {
        List<Field> allFieldList = new ArrayList<Field>();

        Class<?> current = forClazz;
        while(current.getSuperclass()!=null){
            Collections.addAll(allFieldList, current.getDeclaredFields());
            current = current.getSuperclass();
        }

        return filterFieldsList(allFieldList);
    }

    private List<Field> filterFieldsList( List<Field> allFieldList ){
        List<Field> filteredFieldList = new ArrayList<>();
        for (Field f : allFieldList) {
            ColumnName columnNameAnnotation = f.getAnnotation(ColumnName.class);
            if (columnNameAnnotation == null) {
                continue;
            }
            filteredFieldList.add(f);
        }

        return filteredFieldList;
    }

    public List<Field> getSubEntityListTypeOfFields(Class forClazz) {
        Field[] allFields = forClazz.getDeclaredFields();
        List<Field> subEntityFields = new ArrayList<>();
        for (Field f : allFields) {
            if (f.isAnnotationPresent(SubEntityList.class)) {
                subEntityFields.add(f);
            }
        }
        return subEntityFields;
    }
}
