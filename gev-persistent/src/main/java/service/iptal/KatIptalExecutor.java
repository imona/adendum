package service.iptal;

import model.iptal.IptalKatEntity;
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
public class KatIptalExecutor implements IptalExecutor {
    private IptalKatEntity iptalKatEntity;

    public KatIptalExecutor(IptalKatEntity iptalKatEntity) {
        this.iptalKatEntity = iptalKatEntity;
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
    @Override
    public void execute() throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (!checkIfExist(conn)) {
                throw new IptalNesneNotFoundException();
            }

            StringBuilder sqlStatement = new StringBuilder("UPDATE eyf_kat_grp SET transaction_status = false, transaction_cancel_date = ? WHERE gecerlilik_tarihi = ? AND sirket_musteri_no = ?");

            preparedStatement = conn.prepareStatement(sqlStatement.toString());
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(iptalKatEntity.getGecerlilikTarihi().getTime()));
            preparedStatement.setString(3, iptalKatEntity.getSirketMusteriNo());

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
        StringBuilder sqlStatement = new StringBuilder("SELECT * FROM  eyf_kat_grp WHERE gecerlilik_tarihi = ? AND sirket_musteri_no = ? ");
        PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement.toString());

        preparedStatement.setTimestamp(1, new java.sql.Timestamp(iptalKatEntity.getGecerlilikTarihi().getTime()));
        preparedStatement.setString(2, iptalKatEntity.getSirketMusteriNo());

        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }
}
