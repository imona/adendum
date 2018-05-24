package service.insert.generator;

import service.contracts.IInsertStatementGenerator;

import java.lang.reflect.Field;

/**
 * Created by Monzer Masri on 22.5.2018.
 */
public class MsSQLInsertStatementGeneratorWithId implements IInsertStatementGenerator{
    @Override
    public String generateInsertStatement(Class forClazz, Integer rowCount, Field[] columnFields) {
        InsertStatementBuilder builder = new InsertStatementBuilder(forClazz, columnFields, rowCount);
        return  builder.initiateStatement().buildTableName().buildColumnNames().inject(" OUTPUT Inserted.ID ").buildValuesPart().build();
    }
}
