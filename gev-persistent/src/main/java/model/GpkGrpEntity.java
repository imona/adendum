package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.annotation.ColumnName;
import model.annotation.TableName;
import model.delegation.DateTimeDeserializer;
import model.delegation.DateWithoutTimeDeserializer;

import java.util.Date;

/**
 * Created by Monzer Masri on 26.4.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_gpk_grp")
public class GpkGrpEntity extends BaseGrpEntity{

    @JsonProperty("no")
    @ColumnName("nesne_sira_no")
    public Long nesneSiraNo;

    @JsonProperty("htr")
    @ColumnName("guncelleme_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date guncellemeTarihi;

    @JsonProperty("fk")
    @ColumnName("faks")
    public String faks;

    @JsonProperty("gpn")
    @ColumnName("grup_no")
    public String grupNo;

    @JsonProperty("unv")
    @ColumnName("unvan")
    public String unvan;

    @JsonProperty("yt1")
    @ColumnName("first_yetkili")
    public String firstYetkili;


    @JsonProperty("yt2")
    @ColumnName("second_yetkili")
    public String secondYetkili;

    @JsonProperty("yt3")
    @ColumnName("third_yetkili")
    public String thirdYetkili;

    @JsonProperty("vdr")
    @ColumnName("vergi_dairesi")
    public String vergiDairesi;

    @JsonProperty("vno")
    @ColumnName("vergi_kimlik_no")
    public Long vergiKimlikNo;

    @JsonProperty("adr")
    @ColumnName("adres")
    public String adres;

    @JsonProperty("uk")
    @ColumnName("ulke_kodu")
    public String ulkeKodu;

    @JsonProperty("ilk")
    @ColumnName("il_kodu")
    public Integer ilKodu;

    @JsonProperty("il")
    @ColumnName("il_adi")
    public String ilAdi;

    @JsonProperty("ilc")
    @ColumnName("ilce_adi")
    public String ilceAdi;

    @JsonProperty("pk")
    @ColumnName("posta_kodu")
    public Long postaKodu;

    @JsonProperty("t1")
    @ColumnName("first_telefon")
    public String firstTelefon;

    @JsonProperty("t2")
    @ColumnName("second_telefon")
    public String secondTelefon;

    @JsonProperty("ep")
    @ColumnName("e_posta_adresi")
    public String ePostaAdresi;

    public Long getNesneSiraNo() {
        return nesneSiraNo;
    }

    public void setNesneSiraNo(Long nesneSiraNo) {
        this.nesneSiraNo = nesneSiraNo;
    }

    public Date getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(Date guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }

    public String getFaks() {
        return faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
    }

    public String getGrupNo() {
        return grupNo;
    }

    public void setGrupNo(String grupNo) {
        this.grupNo = grupNo;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getFirstYetkili() {
        return firstYetkili;
    }

    public void setFirstYetkili(String firstYetkili) {
        this.firstYetkili = firstYetkili;
    }

    public String getSecondYetkili() {
        return secondYetkili;
    }

    public void setSecondYetkili(String secondYetkili) {
        this.secondYetkili = secondYetkili;
    }

    public String getThirdYetkili() {
        return thirdYetkili;
    }

    public void setThirdYetkili(String thirdYetkili) {
        this.thirdYetkili = thirdYetkili;
    }

    public String getVergiDairesi() {
        return vergiDairesi;
    }

    public void setVergiDairesi(String vergiDairesi) {
        this.vergiDairesi = vergiDairesi;
    }

    public Long getVergiKimlikNo() {
        return vergiKimlikNo;
    }

    public void setVergiKimlikNo(Long vergiKimlikNo) {
        this.vergiKimlikNo = vergiKimlikNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getUlkeKodu() {
        return ulkeKodu;
    }

    public void setUlkeKodu(String ulkeKodu) {
        this.ulkeKodu = ulkeKodu;
    }

    public Integer getIlKodu() {
        return ilKodu;
    }

    public void setIlKodu(Integer ilKodu) {
        this.ilKodu = ilKodu;
    }

    public String getIlAdi() {
        return ilAdi;
    }

    public void setIlAdi(String ilAdi) {
        this.ilAdi = ilAdi;
    }

    public String getIlceAdi() {
        return ilceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        this.ilceAdi = ilceAdi;
    }

    public Long getPostaKodu() {
        return postaKodu;
    }

    public void setPostaKodu(Long postaKodu) {
        this.postaKodu = postaKodu;
    }

    public String getFirstTelefon() {
        return firstTelefon;
    }

    public void setFirstTelefon(String firstTelefon) {
        this.firstTelefon = firstTelefon;
    }

    public String getSecondTelefon() {
        return secondTelefon;
    }

    public void setSecondTelefon(String secondTelefon) {
        this.secondTelefon = secondTelefon;
    }

    public String getePostaAdresi() {
        return ePostaAdresi;
    }

    public void setePostaAdresi(String ePostaAdresi) {
        this.ePostaAdresi = ePostaAdresi;
    }
}
