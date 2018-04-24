package service;

import model.annotation.ColumnName;
import model.annotation.TableName;
import service.contracts.IInsertStatementGenerator;

import java.lang.reflect.Field;

public class InsertStatementGenerator implements IInsertStatementGenerator {

    @Override
    public String generateInsertStatement(Class forClazz, Integer rowCount, Field[] columnFields) {
        StringBuilder insertGenerator = new StringBuilder("INSERT INTO ");
        StringBuilder rowValuesMarkBuilder = new StringBuilder("(");
        TableName tableName = (TableName) forClazz.getAnnotation(TableName.class);

        insertGenerator.append(tableName.value()).append("(");

        boolean firstColumn = true;
        for (Field f : columnFields) {
            ColumnName columnNameAnnotation = f.getAnnotation(ColumnName.class);
            if (firstColumn) {
                rowValuesMarkBuilder.append("?");
                insertGenerator.append(columnNameAnnotation.value());
                firstColumn = false;
            } else {
                rowValuesMarkBuilder.append(", ?");
                insertGenerator.append(",").append(columnNameAnnotation.value());
            }
        }
        rowValuesMarkBuilder.append(") ");
        insertGenerator.append(")");
        insertGenerator.append(" VALUES ");

        for (int i = 0; i < rowCount; i++) {
            if (i == 0) {
                insertGenerator.append(rowValuesMarkBuilder.toString());
            } else {
                insertGenerator.append(", ").append(rowValuesMarkBuilder.toString());
            }
        }

        return insertGenerator.toString();
    }
}
