package service.insert.executor;

import service.contracts.INativeInsertExecuter;
import utils.ConnectionUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imona Andoid on 22.5.2018.
 */
public class MsSqlNativeInsertExecuterReturningId  extends INativeInsertExecuter {
    @Override
    public void executeInsertStatement(String sqlStatement, List objectParamList, Field[] columnFields) throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sqlStatement);
            int paramIndex = 1;
            for (Object object : objectParamList) {
                for (Field myField : columnFields) {
                    myField.setAccessible(true);
                    preparedStatement.setObject(paramIndex, myField.get(object));
                    paramIndex++;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
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
}
