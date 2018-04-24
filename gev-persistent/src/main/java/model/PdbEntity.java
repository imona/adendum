package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import model.annotation.ColumnName;
import model.annotation.TableName;

/**
 * Created by Monzer Masri on 19.4.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_pdb")
public class PdbEntity extends BaseEntity{
//    @JsonIgnore
    @JsonProperty("isin")
    @ColumnName("menkul_kiymet_isin_kodu")
    private String menkulKiymetIsinKodu;


    @JsonProperty("kt")
    @ColumnName("menkul_kiymet_tipi")
    private Integer menkulKiymetTipi;

    @JsonProperty("ktt")
    @ColumnName("menkul_kiymet_tutari")
    private Double menkulKiymetTutari;

    @JsonProperty("no")
    @ColumnName("nesne_sira_no")
    private Integer nesneSiraNo;

    public String getMenkulKiymetIsinKodu() {
        return menkulKiymetIsinKodu;
    }

    public void setMenkulKiymetIsinKodu(String menkulKiymetIsinKodu) {
        this.menkulKiymetIsinKodu = menkulKiymetIsinKodu;
    }

    public Integer getMenkulKiymetTipi() {
        return menkulKiymetTipi;
    }

    public void setMenkulKiymetTipi(Integer menkulKiymetTipi) {
        this.menkulKiymetTipi = menkulKiymetTipi;
    }

    public Double getMenkulKiymetTutari() {
        return menkulKiymetTutari;
    }

    public void setMenkulKiymetTutari(Double menkulKiymetTutari) {
        this.menkulKiymetTutari = menkulKiymetTutari;
    }

    public Integer getNesneSiraNo() {
        return nesneSiraNo;
    }

    public void setNesneSiraNo(Integer nesneSiraNo) {
        this.nesneSiraNo = nesneSiraNo;
    }
}
