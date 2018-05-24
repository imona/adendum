package service.contracts;

import model.BaseEntity;
import model.BaseGrpEntity;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Monzer Masri on 17.4.2018.
 */
public abstract  class  INativeInsertExecuter<T> {
    public abstract void executeInsertStatement(String sqlStatement, List<BaseGrpEntity> objectParamList, Field[] columnFields) throws Exception;

    protected void fillGeneratedIdValues(List<Long> generatedIdList, List<Object> objectList) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        if ((objectList.size() > 0) && (objectList.get(0) instanceof BaseEntity)) {
            for (int i = 0; i < generatedIdList.size(); i++) {
                PropertyUtils.setProperty(objectList.get(i), "id", Long.valueOf(generatedIdList.get(i)));
            }
        }
    }
}
