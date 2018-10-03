package service.insert;

import model.BaseEntity;
import service.contracts.IInsertStatementGenerator;
import service.contracts.INativeInsertExecuter;
import service.insert.executor.MsSqlNativeInsertExecuter;
import service.insert.executor.MsSqlNativeInsertExecuterReturningId;
import service.insert.executor.NativeInsertExecuter;
import service.insert.generator.*;
import utils.ConstantUtils;
import utils.PropertyReader;

/**
 * Created by Monzer Masri on 22.5.2018.
 */
public class InsertServiceFactory {
    public static IInsertStatementGenerator getInsertStatementGeneratorInstance(Class forClass){
        String dbType = PropertyReader.getAppProperty(ConstantUtils.JDBC_TYPE);
        if("MSSQL".equals(dbType) && BaseEntity.class.isAssignableFrom(forClass)){
            return new MsSQLInsertStatementGeneratorWithId();
        } else {
            return new NativeInsertStatementGenerator();
        }
    }

    public static INativeInsertExecuter getINativeInsertExecuterInstance(Class forClass){
        String dbType = PropertyReader.getAppProperty(ConstantUtils.JDBC_TYPE);
        if("MSSQL".equals(dbType) && BaseEntity.class.isAssignableFrom(forClass)){
            return new MsSqlNativeInsertExecuterReturningId();
        } else if("MSSQL".equals(dbType)){
            return new MsSqlNativeInsertExecuter();
        } else if ("MYSQL".equals(dbType) ){
            return new NativeInsertExecuter();

        } else{
            return null;
        }
    }
}
