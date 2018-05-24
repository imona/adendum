package service.insert.generator;

import model.annotation.ColumnName;
import model.annotation.TableName;

import java.lang.reflect.Field;

/**
 * Created by Monzer Masri on 23.5.2018.
 */
public  class InsertStatementBuilder {
    Class forClazz;
    Field[] columnFields;
    Integer rowCount;

    StringBuilder insertGenerator;
    StringBuilder rowValuesMarkBuilder;

    public InsertStatementBuilder(Class forClazz, Field[] columnFields, Integer rowCount){
        this.forClazz = forClazz;
        this.columnFields = columnFields;
        this.rowCount = rowCount;
    }

    public InsertStatementBuilder initiateStatement(){
        insertGenerator = new StringBuilder("INSERT INTO ");
        return this;
    }

    public InsertStatementBuilder buildTableName(){
        TableName tableName = (TableName) forClazz.getAnnotation(TableName.class);
        insertGenerator.append(tableName.value());
        return this;
    }

    public InsertStatementBuilder buildColumnNames(){
        rowValuesMarkBuilder = new StringBuilder("(");
        insertGenerator.append("(");

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
        insertGenerator.append(" ) ");
        return this;
    }

    public InsertStatementBuilder buildValuesPart(){
        insertGenerator.append(" VALUES ");

        for (int i = 0; i < rowCount; i++) {
            if (i == 0) {
                insertGenerator.append(rowValuesMarkBuilder.toString());
            } else {
                insertGenerator.append(", ").append(rowValuesMarkBuilder.toString());
            }
        }
        return this;
    }

    public InsertStatementBuilder inject(String injectedStatement){
        insertGenerator.append(" ").append(injectedStatement).append(" ");
        return this;
    }

    public String build(){
        return  insertGenerator.toString();
    }
}
