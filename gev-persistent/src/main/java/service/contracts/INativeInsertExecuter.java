package service.contracts;

import model.BaseGrpEntity;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Monzer Masri on 17.4.2018.
 */
public interface INativeInsertExecuter<T> {
    void executeInsertStatement(String sqlStatement, List<BaseGrpEntity> objectParamList, Field[] columnFields) throws Exception;
}
