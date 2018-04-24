package service;

import model.BaseEntity;
import model.BaseGrpEntity;
import model.Fdo;
import org.apache.commons.beanutils.PropertyUtils;
import service.contracts.INativeInsertExecuter;
import utils.ConnectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class NativeInsertExecuter  implements INativeInsertExecuter {
    @Override
    public void executeInsertStatement(String sqlStatement, List objectParamList, Field[] columnFields) throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            int paramIndex = 1;
            for (Object object : objectParamList) {
                for (Field myField : columnFields) {
                    myField.setAccessible(true);
                    preparedStatement.setObject(paramIndex, myField.get(object));
                    paramIndex++;
                }
            }

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            List<Long> generatedIdList = new ArrayList<>();
            while (rs.next()) {
                generatedIdList.add(rs.getLong(1));
            }

            fillGeneratedIdValues(generatedIdList, objectParamList);


            System.out.println("inserted Count >> " + objectParamList.size());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    private void fillGeneratedIdValues(List<Long> generatedIdList, List<Object> objectList) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        if ((objectList.size() > 0) && (objectList.get(0) instanceof BaseEntity)) {
            for (int i = 0; i < generatedIdList.size(); i++) {
                PropertyUtils.setProperty(objectList.get(i), "id", Long.valueOf(generatedIdList.get(i)));
            }
        }
    }

}
