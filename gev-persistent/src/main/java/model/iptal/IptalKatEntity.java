package model.iptal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.annotation.ColumnName;
import model.annotation.TableName;
import model.delegation.DateWithoutTimeDeserializer;

import java.util.Date;

/**
 * Created by Monzer Masri on 12.7.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_kat_grp")
public class IptalKatEntity extends IptalGrpEntity {

    @JsonProperty("htr")
    @ColumnName("gecerlilik_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date gecerlilikTarihi;

    @JsonProperty("smn")
    @ColumnName("sirket_musteri_no")
    public String sirketMusteriNo;


    public Date getGecerlilikTarihi() {
        return gecerlilikTarihi;
    }

    public void setGecerlilikTarihi(Date gecerlilikTarihi) {
        this.gecerlilikTarihi = gecerlilikTarihi;
    }

    public String getSirketMusteriNo() {
        return sirketMusteriNo;
    }

    public void setSirketMusteriNo(String sirketMusteriNo) {
        this.sirketMusteriNo = sirketMusteriNo;
    }
}
