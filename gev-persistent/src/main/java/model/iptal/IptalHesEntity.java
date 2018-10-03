package model.iptal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.annotation.ColumnName;
import model.annotation.TableName;
import model.delegation.DateTimeDeserializer;

import java.util.Date;

/**
 * Created by Monzer Masri on 12.7.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_hes_grp")
public class IptalHesEntity extends IptalGrpEntity {

    @JsonProperty("htr")
    @ColumnName("hareket_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date hareketTarihi;

    @JsonProperty("rf")
    @ColumnName("referans_no")
    public Long referansNo;

    @JsonProperty("sn")
    @ColumnName("soz_no")
    public String sozNo;

    @JsonProperty("sfn")
    @ColumnName("sertifika_no")
    public String sertifikaNo;

    @JsonProperty("ht")
    @ColumnName("hareket_tipi")
    @JsonRawValue
    public Integer hareketTipi;


    @JsonProperty("fk")
    @ColumnName("fon_kodu")
    public Integer fonKodu;


    public Date getHareketTarihi() {
        return hareketTarihi;
    }

    public void setHareketTarihi(Date hareketTarihi) {
        this.hareketTarihi = hareketTarihi;
    }


    public String getSozNo() {
        return sozNo;
    }

    public void setSozNo(String sozNo) {
        this.sozNo = sozNo;
    }

    public String getSertifikaNo() {
        return sertifikaNo;
    }

    public void setSertifikaNo(String sertifikaNo) {
        this.sertifikaNo = sertifikaNo;
    }

    public Integer getHareketTipi() {
        return hareketTipi;
    }

    public void setHareketTipi(Integer hareketTipi) {
        this.hareketTipi = hareketTipi;
    }

    public Integer getFonKodu() {
        return fonKodu;
    }

    public void setFonKodu(Integer fonKodu) {
        this.fonKodu = fonKodu;
    }

    public Long getReferansNo() {
        return referansNo;
    }

    public void setReferansNo(Long referansNo) {
        this.referansNo = referansNo;
    }
}
