package service.iptal;

import model.iptal.IptalSozEntity;
import service.iptal.exceptions.IptalNesneNotFoundException;
import utils.ConnectionUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * Created by Monzer Masri on 12.7.2018.
 */
public class SozIptalExecutor implements IptalExecutor {
    private IptalSozEntity iptalSozEntity;

    public SozIptalExecutor(IptalSozEntity iptalSozEntity) {
        iptalSozEntity.setSozNo(iptalSozEntity.getSozNo() + "-" + iptalSozEntity.getSertifikaNo());
        this.iptalSozEntity = iptalSozEntity;
    }

    @Override
    public void execute() throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if(!checkIfExist(conn)){
                throw new IptalNesneNotFoundException();
            }

            String sqlStatement = "UPDATE eyf_soz_grp s SET transaction_status = false, transaction_cancel_date = ? WHERE s.hareket_tarihi = ? AND s.hareket_tanzim_tarihi = ? AND soz_no = ? AND s.hareket_tipi = ?";
            preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(iptalSozEntity.getHareketTarihi().getTime()));
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(iptalSozEntity.getHareketTanzimTarihi().getTime()));
            preparedStatement.setString(4, iptalSozEntity.getSozNo());
            preparedStatement.setInt(5, iptalSozEntity.getHareketTipi());

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
        String sqlStatement = "select * from  eyf_soz_grp s WHERE s.hareket_tarihi = ? AND s.hareket_tanzim_tarihi = ? AND soz_no = ? AND s.hareket_tipi = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
        preparedStatement.setTimestamp(1, new java.sql.Timestamp(iptalSozEntity.getHareketTarihi().getTime()));
        preparedStatement.setTimestamp(2, new java.sql.Timestamp(iptalSozEntity.getHareketTanzimTarihi().getTime()));
        preparedStatement.setString(3, iptalSozEntity.getSozNo());
        preparedStatement.setInt(4, iptalSozEntity.getHareketTipi());

        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }
}
