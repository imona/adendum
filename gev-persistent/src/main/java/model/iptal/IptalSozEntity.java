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
@TableName("eyf_soz_grp")
public class IptalSozEntity extends IptalGrpEntity {

    @JsonProperty("htr")
    @ColumnName("hareket_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date hareketTarihi;

    @JsonProperty("ttr")
    @ColumnName("hareket_tanzim_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date hareketTanzimTarihi;

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

    public Date getHareketTarihi() {
        return hareketTarihi;
    }

    public void setHareketTarihi(Date hareketTarihi) {
        this.hareketTarihi = hareketTarihi;
    }

    public Date getHareketTanzimTarihi() {
        return hareketTanzimTarihi;
    }

    public void setHareketTanzimTarihi(Date hareketTanzimTarihi) {
        this.hareketTanzimTarihi = hareketTanzimTarihi;
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
}
