package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.delegation.DateTimeDeserializer;
import model.annotation.ColumnName;
import model.annotation.TableName;

import java.util.Date;

/**
 * Created by Monzer Masri on 9.4.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_hes_grp")
public class HesGrpEntity extends BaseGrpEntity{
    @JsonProperty("no")
    @ColumnName("nesne_sira_no")
    public Long nesneSiraNo;

    @JsonProperty("rf")
    @ColumnName("referans_no")
    @JsonIgnore
    public Long referansNo;

    @JsonProperty("htr")
    @ColumnName("hareket_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date hareketTarihi;

    @JsonProperty("vtr")
    @ColumnName("valor_tarihi")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date valorTarihi;

    @JsonProperty("sn")
    @ColumnName("soz_no")
    public String sozNo;

    @JsonProperty("sfn")
    @ColumnName("sertifika_no")
    public String sertifikaNo;

    @JsonProperty("ht")
    @ColumnName("hareket_tipi")
    public String hareketTipi;

    @JsonProperty("ot")
    @ColumnName("odeyen_tipi")
    public Integer odeyenTipi;

    @JsonProperty("oa")
    @ColumnName("odeme_araci")
//    @JsonIgnore
    public Integer odemeAraci;

    @JsonProperty("pb")
    @ColumnName("para_birimi")
    public String paraBirimi;

    @JsonProperty("pt")
    @ColumnName("pb_tutar")
    public Double pbTutar;

    @JsonProperty("tl")
    @ColumnName("tl_tutar")
    public Double tlTutar;

    @JsonProperty("ntl")
    @ColumnName("nominal_tutar")
//    @JsonIgnore
    public Double nominalTutar;

    @JsonProperty("fet")
    @ColumnName("fon_emir_tarihi")
//    @JsonIgnore
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date fonEmirTarihi;

    @JsonProperty("ef")
    @ColumnName("ek_fayda_numarasi")
//    @JsonIgnore
    public String ekFaydaNumarasi;

    @JsonProperty("cig")
    @ColumnName("ceza_isleminin_gerekcesi")
//    @JsonIgnore
    public Integer cezaIslemininGerekcesi;

//    @JsonIgnore
    @JsonProperty("fk")
    @ColumnName("fon_kodu")
    public Integer fonKodu;

    @JsonProperty("fp")
    @ColumnName("fon_pay_adedi")
//    @JsonIgnore
    public Double fonPayAdedi;

    @JsonProperty("fig")
    @ColumnName("fon_isleminin_gerekcesi")
//    @JsonIgnore
    public Integer fonIslemininGerekcesi;

    @JsonProperty("iak")
    @ColumnName("tahsilat_iade_alt_kodu")
//    @JsonIgnore
    public Integer tahilatsIadeAltKodu;

    public Date getHostts() {
        return hostts;
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

    public Long getReferansNo() {
        return referansNo;
    }

    public void setReferansNo(Long referansNo) {
        this.referansNo = referansNo;
    }

    public Date getHareketTarihi() {
        return hareketTarihi;
    }

    public void setHareketTarihi(Date hareketTarihi) {
        this.hareketTarihi = hareketTarihi;
    }

    public Date getValorTarihi() {
        return valorTarihi;
    }

    public void setValorTarihi(Date valorTarihi) {
        this.valorTarihi = valorTarihi;
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

    public String getHareketTipi() {
        return hareketTipi;
    }

    public void setHareketTipi(String hareketTipi) {
        this.hareketTipi = hareketTipi;
    }

    public Integer getOdeyenTipi() {
        return odeyenTipi;
    }

    public void setOdeyenTipi(Integer odeyenTipi) {
        this.odeyenTipi = odeyenTipi;
    }

    public Integer getOdemeAraci() {
        return odemeAraci;
    }

    public void setOdemeAraci(Integer odemeAraci) {
        this.odemeAraci = odemeAraci;
    }

    public String getParaBirimi() {
        return paraBirimi;
    }

    public void setParaBirimi(String paraBirimi) {
        this.paraBirimi = paraBirimi;
    }

    public Double getPbTutar() {
        return pbTutar;
    }

    public void setPbTutar(Double pbTutar) {
        this.pbTutar = pbTutar;
    }

    public Double getTlTutar() {
        return tlTutar;
    }

    public void setTlTutar(Double tlTutar) {
        this.tlTutar = tlTutar;
    }

    public Double getNominalTutar() {
        return nominalTutar;
    }

    public void setNominalTutar(Double nominalTutar) {
        this.nominalTutar = nominalTutar;
    }

    public Date getFonEmirTarihi() {
        return fonEmirTarihi;
    }

    public void setFonEmirTarihi(Date fonEmirTarihi) {
        this.fonEmirTarihi = fonEmirTarihi;
    }

    public String getEkFaydaNumarasi() {
        return ekFaydaNumarasi;
    }

    public void setEkFaydaNumarasi(String ekFaydaNumarasi) {
        this.ekFaydaNumarasi = ekFaydaNumarasi;
    }


    public Integer getCezaIslemininGerekcesi() {
        return cezaIslemininGerekcesi;
    }

    public void setCezaIslemininGerekcesi(Integer cezaIslemininGerekcesi) {
        this.cezaIslemininGerekcesi = cezaIslemininGerekcesi;
    }

    public Integer getFonKodu() {
        return fonKodu;
    }

    public void setFonKodu(Integer fonKodu) {
        this.fonKodu = fonKodu;
    }

    public Double getFonPayAdedi() {
        return fonPayAdedi;
    }

    public void setFonPayAdedi(Double fonPayAdedi) {
        this.fonPayAdedi = fonPayAdedi;
    }

    public Integer getFonIslemininGerekcesi() {
        return fonIslemininGerekcesi;
    }

    public void setFonIslemininGerekcesi(Integer fonIslemininGerekcesi) {
        this.fonIslemininGerekcesi = fonIslemininGerekcesi;
    }

    public Integer getTahilatsIadeAltKodu() {
        return tahilatsIadeAltKodu;
    }

    public void setTahilatsIadeAltKodu(Integer tahilatsIadeAltKodu) {
        this.tahilatsIadeAltKodu = tahilatsIadeAltKodu;
    }
}