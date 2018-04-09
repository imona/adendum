package gev.writer.database;

import gev.writer.IGevObjectSaver;
import org.springframework.stereotype.Service;
import utils.ConstantUtils;
import utils.PropertyReader;

import java.sql.*;

/**
 * Created by Monzer Masri  on 6.4.2018.
 */
@Service(value = "MySqlObjectSaverBean")
public class MySqlSaver implements IGevObjectSaver {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = PropertyReader.getAppProperty(ConstantUtils.JDBC_URL); //"jdbc:mysql://localhost:3306/"; //
    static final String DB_NAME = PropertyReader.getAppProperty(ConstantUtils.JDBC_DATABASE_NAME); //"d6d51eac55f047198ae2e8d2fdaa23d6";//
    static final String USER = PropertyReader.getAppProperty(ConstantUtils.JDBC_USER_NAME); //"root";//
    static final String PASS = PropertyReader.getAppProperty(ConstantUtils.JDBC_PASSWORD); //"12345"; //
    final Integer STEP = Integer.valueOf(PropertyReader.getAppProperty(ConstantUtils.DATA_BATCH_SIZE)); // 50;//

    public static void main(String[] args) {
        MySqlSaver ms = new MySqlSaver();
        ms.insertDummy(10);
    }

    @Override
    public String saveObject(String entityName, String sirkretNo, String veriTarihi, String objAsJson) throws Exception {
        insertDummy(STEP);
        return "";
    }

    private void insertDummy(int rowCount) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection((DB_URL + DB_NAME), USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO  eyf_hes_grp (`imona_version`, `ceza_isleminin_gerekcesi`, `fon_kodu`, `nominal_tutar`, `hareket_tipi`, `ek_fayda_numarasi`, `nesne_sira_no`, `referans_no`, `odeme_araci`, `fon_emir_tarihi`, `para_birimi`, `sirket_numarasi`, `okm`, `soz_no`, `odeyen_tipi`, `fon_pay_adedi`, `sertifika_no`, `fon_isleminin_gerekcesi`, `tl_tutar`, `mtl`, `valor_tarihi`, `hareket_tarihi`, `tahsilat_iade_alt_kodu`, `pb_tutar`, `tahakkuk_tarihi`, `hak_kazanma_orani`, `veri_tarihi`, `otomatik_katilim_donemi`, `odeme_dosya_referans_no`, `hostts`, `userid`, `wsid`, `apprvd`, `latitude`, `longitude`, `waitingforapproval`, `rejectionreason`) VALUES ";
            String datarow = "(0, NULL, NULL, 0, '18', NULL, 437875, NULL, 3, NULL, 'USD', 111, NULL, '33001554-0', 1, NULL, '0', NULL, -5.81, NULL, '2003-12-9 19:20:29', '2003-12-8 19:20:29', NULL, -4, NULL, NULL, '2018-2-13 00:00:00', NULL, NULL, '2018-3-20 12:05:04', NULL, NULL, 1, NULL, NULL, 0, NULL)";
            StringBuilder sb = new StringBuilder(sql);
            sb.append(datarow);

            for (int i = 1; i < rowCount; i++) {
                sb.append(",").append(datarow);
            }

            stmt.executeUpdate(sb.toString());
            System.out.println("insertDummy >> "  + rowCount);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
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
