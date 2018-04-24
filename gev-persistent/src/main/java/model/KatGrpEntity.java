package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.delegation.DateWithoutTimeDeserializer;
import model.annotation.ColumnName;
import model.annotation.TableName;

import java.util.Date;

/**
 * Created by Monzer Masri on 12.4.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_kat_grp")
public class KatGrpEntity extends BaseGrpEntity{
    @JsonProperty("no")
    @ColumnName("nesne_sira_no")
    public Long nesneSiraNo;

    @JsonProperty("htr")
    @ColumnName("gecerlilik_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date gecerlilikTarihi;

    @JsonProperty("smn")
    @ColumnName("sirket_musteri_no")
    public String sirketMusteriNo;

    @JsonProperty("ks")
    @ColumnName("katilimci_sicil_kodu")
    public String katilimciSicilKodu;

    @JsonProperty("sks")
    @ColumnName("saklayici_kurum_kat_sicil_kodu")
//    @JsonIgnore
    public String saklayiciKurumKatSicilKodu;

    @JsonProperty("ad")
    @ColumnName("adi")
    public String adi;

    @JsonProperty("sad")
    @ColumnName("soyadi")
    public String soyadi;

    @JsonProperty("aad")
    @ColumnName("ana_adi")
//    @JsonIgnore
    public String anaAdi;

    @JsonProperty("bad")
    @ColumnName("baba_adi")
    public String babaAdi;

    @JsonProperty("dt")
    @ColumnName("dogum_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date dogumTarihi;

    @JsonProperty("dy")
    @ColumnName("dogum_yeri")
//    @JsonIgnore
    public String dogumYeri;

    @JsonProperty("cn")
    @ColumnName("cinsiyeti")
    public String cinsiyeti;

    @JsonProperty("md")
    @ColumnName("medeni_durumu")
//    @JsonIgnore
    public Integer medeniDurumu;

    @JsonProperty("ga")
    @ColumnName("gelir_araligi")
//    @JsonIgnore
    public Integer gelirAraligi;

    @JsonProperty("mk")
    @ColumnName("meslek")
//    @JsonIgnore
    public Integer meslek;

    @JsonProperty("ek")
    @ColumnName("egitim_durumu")
//    @JsonIgnore
    public Integer egitimDurumu;

    @JsonProperty("ya")
    @ColumnName("yazisma_adres_tipi")
    public String yazismaAdresTipi;

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
//    @JsonIgnore
    public String ilAdi;

    @JsonProperty("ilc")
    @ColumnName("ilce_adi")
//    @JsonIgnore
    public String ilceAdi;

    @JsonProperty("pk")
    @ColumnName("posta_kodu")
//    @JsonIgnore
    public Long postaKodu;

    @JsonProperty("t1")
    @ColumnName("first_telefon")
//    @JsonIgnore
    public String firstTelefon;

    @JsonProperty("t2")
    @ColumnName("second_telefon")
//    @JsonIgnore
    public String secondTelefon;

    @JsonProperty("mt")
    @ColumnName("mobil_telefonu")
//    @JsonIgnore
    public String mobilTelefonu;

    @JsonProperty("fk")
    @ColumnName("faks")
//    @JsonIgnore
    public String faks;

    @JsonProperty("ep")
    @ColumnName("e_posta_adresi")
//    @JsonIgnore
    public String ePostaAdresi;

    @JsonProperty("uy")
    @ColumnName("uyruk")
//    @JsonIgnore
    public Integer uyruk;

    public Long getNesneSiraNo() {
        return nesneSiraNo;
    }

    public void setNesneSiraNo(Long nesneSiraNo) {
        this.nesneSiraNo = nesneSiraNo;
    }

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

    public String getKatilimciSicilKodu() {
        return katilimciSicilKodu;
    }

    public void setKatilimciSicilKodu(String katilimciSicilKodu) {
        this.katilimciSicilKodu = katilimciSicilKodu;
    }

    public String getSaklayiciKurumKatSicilKodu() {
        return saklayiciKurumKatSicilKodu;
    }

    public void setSaklayiciKurumKatSicilKodu(String saklayiciKurumKatSicilKodu) {
        this.saklayiciKurumKatSicilKodu = saklayiciKurumKatSicilKodu;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getAnaAdi() {
        return anaAdi;
    }

    public void setAnaAdi(String anaAdi) {
        this.anaAdi = anaAdi;
    }

    public String getBabaAdi() {
        return babaAdi;
    }

    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getCinsiyeti() {
        return cinsiyeti;
    }

    public void setCinsiyeti(String cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public Integer getMedeniDurumu() {
        return medeniDurumu;
    }

    public void setMedeniDurumu(Integer medeniDurumu) {
        this.medeniDurumu = medeniDurumu;
    }

    public Integer getGelirAraligi() {
        return gelirAraligi;
    }

    public void setGelirAraligi(Integer gelirAraligi) {
        this.gelirAraligi = gelirAraligi;
    }

    public Integer getMeslek() {
        return meslek;
    }

    public void setMeslek(Integer meslek) {
        this.meslek = meslek;
    }

    public Integer getEgitimDurumu() {
        return egitimDurumu;
    }

    public void setEgitimDurumu(Integer egitimDurumu) {
        this.egitimDurumu = egitimDurumu;
    }

    public String getYazismaAdresTipi() {
        return yazismaAdresTipi;
    }

    public void setYazismaAdresTipi(String yazismaAdresTipi) {
        this.yazismaAdresTipi = yazismaAdresTipi;
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

    public String getMobilTelefonu() {
        return mobilTelefonu;
    }

    public void setMobilTelefonu(String mobilTelefonu) {
        this.mobilTelefonu = mobilTelefonu;
    }

    public String getFaks() {
        return faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
    }

    public String getePostaAdresi() {
        return ePostaAdresi;
    }

    public void setePostaAdresi(String ePostaAdresi) {
        this.ePostaAdresi = ePostaAdresi;
    }

    public Integer getUyruk() {
        return uyruk;
    }

    public void setUyruk(Integer uyruk) {
        this.uyruk = uyruk;
    }
}
