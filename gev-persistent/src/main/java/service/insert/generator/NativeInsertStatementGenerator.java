package service.insert.generator;

import model.annotation.ColumnName;
import model.annotation.TableName;
import service.contracts.IInsertStatementGenerator;

import java.lang.reflect.Field;

public class NativeInsertStatementGenerator implements IInsertStatementGenerator {

    @Override
    public String generateInsertStatement(Class forClazz, Integer rowCount, Field[] columnFields) {
        InsertStatementBuilder builder = new InsertStatementBuilder(forClazz, columnFields, rowCount);
        return  builder.initiateStatement().buildTableName().buildColumnNames().buildValuesPart().build();
    }
}
