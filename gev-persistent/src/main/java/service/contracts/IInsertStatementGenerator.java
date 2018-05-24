package service.contracts;

import model.annotation.ColumnName;
import model.annotation.TableName;

import java.lang.reflect.Field;

/**
 * Created by Monzer Masri on 17.4.2018.
 */
public interface IInsertStatementGenerator{
    public String generateInsertStatement(Class forClazz, Integer rowCount, Field[] columnFields) ;
}
