package model.iptal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.annotation.ColumnName;
import model.annotation.TableName;
import model.delegation.DateTimeDeserializer;
import model.delegation.DateWithoutTimeDeserializer;

import java.util.Date;

/**
 * Created by Monzer Masri on 12.7.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_fnv_grp")
public class IptalFnvEntity extends IptalGrpEntity {

    @JsonProperty("htr")
    @ColumnName("hareket_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date hareketTarihi;


    @JsonProperty("fk")
    @ColumnName("fon_kodu")
    public Integer fonKodu;

    public Integer getFonKodu() {
        return fonKodu;
    }

    public void setFonKodu(Integer fonKodu) {
        this.fonKodu = fonKodu;
    }

    public Date getHareketTarihi() {
        return hareketTarihi;
    }

    public void setHareketTarihi(Date hareketTarihi) {
        this.hareketTarihi = hareketTarihi;
    }
}
