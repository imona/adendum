package service.iptal;

import model.iptal.IptalFnvEntity;
import model.iptal.IptalSozEntity;
import service.iptal.exceptions.IptalNesneNotFoundException;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Monzer Masri on 12.7.2018.
 */
public class FnvIptalExecutor implements IptalExecutor {
    private IptalFnvEntity iptalFnvEntity;

    public FnvIptalExecutor(IptalFnvEntity iptalFnvEntity) {
        this.iptalFnvEntity = iptalFnvEntity;
    }

    @Override
    public void execute() throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if(!checkIfExist(conn)){
                throw new IptalNesneNotFoundException();
            }

            StringBuilder sqlStatement = new StringBuilder("UPDATE eyf_fnv_grp SET transaction_status = false, transaction_cancel_date = ? WHERE hareket_tarihi = ?");

            if(iptalFnvEntity.getFonKodu() != null){
                sqlStatement.append(" AND fon_kodu = ?");
            }

            preparedStatement = conn.prepareStatement(sqlStatement.toString());
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(iptalFnvEntity.getHareketTarihi().getTime()));

            if(iptalFnvEntity.getFonKodu() != null) {
                preparedStatement.setInt(3, iptalFnvEntity.getFonKodu());
            }

            preparedStatement.executeUpdate();
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


    private Boolean checkIfExist(Connection conn) throws SQLException {
        StringBuilder sqlStatement = new StringBuilder("SELECT * FROM  eyf_fnv_grp WHERE hareket_tarihi = ? ");

        if(iptalFnvEntity.getFonKodu() != null){
            sqlStatement.append(" AND fon_kodu = ?");
        }

        PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement.toString());
        preparedStatement.setTimestamp(1, new java.sql.Timestamp(iptalFnvEntity.getHareketTarihi().getTime()));

        if(iptalFnvEntity.getFonKodu() != null) {
            preparedStatement.setInt(2, iptalFnvEntity.getFonKodu());
        }

        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }
}
