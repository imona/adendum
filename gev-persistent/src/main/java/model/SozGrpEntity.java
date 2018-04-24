package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.delegation.DateTimeDeserializer;
import model.delegation.FdoDeserializer;
import model.delegation.DateWithoutTimeDeserializer;
import model.delegation.SozFdoRelationSaver;
import model.annotation.ColumnName;
import model.annotation.SubEntityList;
import model.annotation.TableName;

import java.util.Date;
import java.util.List;

/**
 * Created by Monzer Masri on 16.4.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_soz_grp")
public class SozGrpEntity extends BaseGrpEntity {

    @JsonProperty("no")
    @ColumnName("nesne_sira_no")
    public Long nesneSiraNo;

    @JsonProperty("htr")
    @ColumnName("hareket_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date hareketTarihi;

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

    @JsonProperty("bt")
    @ColumnName("basvuru_tipi")
    @JsonRawValue
    public Integer basvuruTipi;

    @JsonProperty("sc")
    @ColumnName("sozlesme_cinsi")
    public Integer sozlesmeCinsi;

    @JsonProperty("gpn")
    @ColumnName("grup_no_ref")
//    @JsonIgnore
    public String grupNoRef;

    @JsonProperty("pb")
    @ColumnName("para_birimi")
    public String paraBirimi;

    @JsonProperty("op")
    @ColumnName("odeme_periyodu")
    public Integer odemePeriyodu;

    @JsonProperty("gs")
    @ColumnName("gecici_araci_sicil_no")
    public Long geciciAraciSicilNo;

    @JsonProperty("bs")
    @ColumnName("bes_araci_sicil_no")
    public Long besAraciSicilNo;

    @JsonProperty("tka")
    @ColumnName("tuzel_kisi_araci_numarasi")
    public String tuzelKisiAraciNumarasi;

    @JsonProperty("ks")
    @ColumnName("katilimci_sicil_kodu")
    public String katilimciSicilKodu;

    @JsonProperty("dkp")
    @ColumnName("duzenli_katki_payi_tutari")
    public Double duzenliKatkiPayiTutari;

    @JsonProperty("dkf")
    @ColumnName("devlet_katkisi_fon_kodu")
    public Integer devletKatkisiFonKodu;

    @JsonProperty("dkn")
    @ColumnName("dagitim_kanali")
    public Integer dagitimKanali;

    @JsonProperty("pn")
    @ColumnName("plan_numarasi")
    public Integer planNumarasi;

    @JsonProperty("tkn")
    @ColumnName("teklif_numarasi")
    public String teklifNumarasi;

    @JsonProperty("tkt")
    @ColumnName("talebi_kullanan_taraf")
    public Integer talebiKullananTaraf;

    @JsonProperty("esr")
    @ColumnName("emeklilik_taleb_sirket_no")
    public Integer emeklilikTalebSirketNo;

    @JsonProperty("igt")
    @ColumnName("ise_giris_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date iseGirisTarihi;

    @JsonProperty("avt")
    @ColumnName("odemeye_ara_verme_bitis_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date odemeyeAraVermeBitisTarihi;

    @JsonProperty("ttr")
    @ColumnName("hareket_tanzim_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date hareketTanzimTarihi;

    @JsonProperty("fdolst")
    @SubEntityList(value = Fdo.class, relationResolver = SozFdoRelationSaver.class)
    public List<Fdo> fdoList;

    public List<Fdo> getFdoList() {
        return fdoList;
    }

    @JsonDeserialize(using = FdoDeserializer.class)
    public void setFdoList(List<Fdo> fdoList) {
        this.fdoList = fdoList;
    }

    public void setHostts(Date hostts) {
        this.hostts = hostts;
    }

    public Long getNesneSiraNo() {
        return nesneSiraNo;
    }

    public void setNesneSiraNo(Long nesneSiraNo) {
        this.nesneSiraNo = nesneSiraNo;
    }

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

    public Integer getBasvuruTipi() {
        return basvuruTipi;
    }

    public void setBasvuruTipi(Integer basvuruTipi) {
        this.basvuruTipi = basvuruTipi;
    }

    public Integer getSozlesmeCinsi() {
        return sozlesmeCinsi;
    }

    public void setSozlesmeCinsi(Integer sozlesmeCinsi) {
        this.sozlesmeCinsi = sozlesmeCinsi;
    }

    public String getGrupNoRef() {
        return grupNoRef;
    }

    public void setGrupNoRef(String grupNoRef) {
        this.grupNoRef = grupNoRef;
    }

    public String getParaBirimi() {
        return paraBirimi;
    }

    public void setParaBirimi(String paraBirimi) {
        this.paraBirimi = paraBirimi;
    }

    public Integer getOdemePeriyodu() {
        return odemePeriyodu;
    }

    public void setOdemePeriyodu(Integer odemePeriyodu) {
        this.odemePeriyodu = odemePeriyodu;
    }

    public Long getGeciciAraciSicilNo() {
        return geciciAraciSicilNo;
    }

    public void setGeciciAraciSicilNo(Long geciciAraciSicilNo) {
        this.geciciAraciSicilNo = geciciAraciSicilNo;
    }

    public Long getBesAraciSicilNo() {
        return besAraciSicilNo;
    }

    public void setBesAraciSicilNo(Long besAraciSicilNo) {
        this.besAraciSicilNo = besAraciSicilNo;
    }

    public String getTuzelKisiAraciNumarasi() {
        return tuzelKisiAraciNumarasi;
    }

    public void setTuzelKisiAraciNumarasi(String tuzelKisiAraciNumarasi) {
        this.tuzelKisiAraciNumarasi = tuzelKisiAraciNumarasi;
    }

    public String getKatilimciSicilKodu() {
        return katilimciSicilKodu;
    }

    public void setKatilimciSicilKodu(String katilimciSicilKodu) {
        this.katilimciSicilKodu = katilimciSicilKodu;
    }

    public Double getDuzenliKatkiPayiTutari() {
        return duzenliKatkiPayiTutari;
    }

    public void setDuzenliKatkiPayiTutari(Double duzenliKatkiPayiTutari) {
        this.duzenliKatkiPayiTutari = duzenliKatkiPayiTutari;
    }

    public Integer getDevletKatkisiFonKodu() {
        return devletKatkisiFonKodu;
    }

    public void setDevletKatkisiFonKodu(Integer devletKatkisiFonKodu) {
        this.devletKatkisiFonKodu = devletKatkisiFonKodu;
    }

    public Integer getDagitimKanali() {
        return dagitimKanali;
    }

    public void setDagitimKanali(Integer dagitimKanali) {
        this.dagitimKanali = dagitimKanali;
    }

    public Integer getPlanNumarasi() {
        return planNumarasi;
    }

    public void setPlanNumarasi(Integer planNumarasi) {
        this.planNumarasi = planNumarasi;
    }

    public String getTeklifNumarasi() {
        return teklifNumarasi;
    }

    public void setTeklifNumarasi(String teklifNumarasi) {
        this.teklifNumarasi = teklifNumarasi;
    }

    public Integer getTalebiKullananTaraf() {
        return talebiKullananTaraf;
    }

    public void setTalebiKullananTaraf(Integer talebiKullananTaraf) {
        this.talebiKullananTaraf = talebiKullananTaraf;
    }

    public Integer getEmeklilikTalebSirketNo() {
        return emeklilikTalebSirketNo;
    }

    public void setEmeklilikTalebSirketNo(Integer emeklilikTalebSirketNo) {
        this.emeklilikTalebSirketNo = emeklilikTalebSirketNo;
    }

    public Date getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(Date iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public Date getOdemeyeAraVermeBitisTarihi() {
        return odemeyeAraVermeBitisTarihi;
    }

    public void setOdemeyeAraVermeBitisTarihi(Date odemeyeAraVermeBitisTarihi) {
        this.odemeyeAraVermeBitisTarihi = odemeyeAraVermeBitisTarihi;
    }

    public Date getHareketTanzimTarihi() {
        return hareketTanzimTarihi;
    }

    public void setHareketTanzimTarihi(Date hareketTanzimTarihi) {
        this.hareketTanzimTarihi = hareketTanzimTarihi;
    }

    public Date getHostts() {
        return hostts;
    }

}
