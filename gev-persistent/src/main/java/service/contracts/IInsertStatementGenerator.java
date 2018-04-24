package service.contracts;

import java.lang.reflect.Field;

/**
 * Created by Monzer Masri on 17.4.2018.
 */
public interface IInsertStatementGenerator<T>{
    public String generateInsertStatement(Class<T> forClazz, Integer rowCount, Field[] columnFields);
}
