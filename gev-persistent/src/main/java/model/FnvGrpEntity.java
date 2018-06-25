package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.annotation.ColumnName;
import model.annotation.SubEntityList;
import model.annotation.TableName;
import model.delegation.DateWithoutTimeDeserializer;
import model.delegation.FnvPdbRelationSaver;
import model.delegation.PdbDeserializer;

import java.util.Date;
import java.util.List;

/**
 * Created by Monzer Masri on 13.4.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_fnv_grp")
public class FnvGrpEntity extends BaseGrpEntity{
    @JsonProperty("no")
    @ColumnName("nesne_sira_no")
    public Long nesneSiraNo;

    @JsonProperty("htr")
    @ColumnName("hareket_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date hareketTarihi;

    @JsonProperty("fk")
    @ColumnName("fon_kodu")
    public Integer fonKodu;

    @JsonProperty("nv")
    @ColumnName("fon_net_varlik_degeri")
    public Double fonNetVarlikDegeri;


    @JsonProperty("nk")
    @ColumnName("nakit")
    public Double nakit;

    @JsonProperty("fa")
    @ColumnName("fon_alacaklari")
    public String fonAlacaklari;

    @JsonProperty("fb")
    @ColumnName("fon_borclari")
    public Double fonBorclari;

    @JsonProperty("bp")
    @ColumnName("fon_birim_pay_degeri")
    public Double fonBirimPayDegeri;

    @JsonProperty("ka")
    @ColumnName("kurucu_avansi")
    public Double kurucuAvansi;

    @JsonProperty("tap")
    @ColumnName("alinan_pay_adedi")
    public Double alinanPayAdedi;

    @JsonProperty("tsp")
    @ColumnName("satilan_pay_adedi")
    public Double satilanPayAdedi;

    @JsonProperty("eap")
    @ColumnName("emanet_fonda_alinan_pay_adedi")
//    @JsonIgnore
    public Double emanetFondaAlinanPayAdedi;

    @JsonProperty("esp")
    @ColumnName("emanet_fonda_satilan_pay_adedi")
//    @JsonIgnore
    public Double emanetFondaRatilanPayAdedi;


    @JsonProperty("tpa")
    @ColumnName("tedavuldeki_pay_adedi")
    public Double tedavuldekiPayAdedi;

    @JsonProperty("fpd")
    @ColumnName("portfoy_degeri")
    public Double portfoyDegeri;

    @JsonProperty("tfg")
    @ColumnName("figk_toplami")
    public Double figkToplami;

    @JsonProperty("gfg")
    @ColumnName("gunluk_ftgk_tutari")
    public Double gunlukFtgkTutari;

    @JsonProperty("ffg")
    @ColumnName("fazla_yapilan_ftgk_iade_tutari")
    public Double fazlaYapilanFtgkIadeTutari;

//    @JsonIgnore
    @JsonProperty("pdblst")
    @SubEntityList(value = PdbEntity.class, relationResolver = FnvPdbRelationSaver.class)
    public List<PdbEntity> pdbList;

    public List<PdbEntity> getPdbList() {
        return pdbList;
    }

    @JsonDeserialize(using = PdbDeserializer.class)
    public void setPdbList(List<PdbEntity> pdbList) {
        this.pdbList = pdbList;
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

    public Integer getFonKodu() {
        return fonKodu;
    }

    public void setFonKodu(Integer fonKodu) {
        this.fonKodu = fonKodu;
    }

    public Double getFonNetVarlikDegeri() {
        return fonNetVarlikDegeri;
    }

    public void setFonNetVarlikDegeri(Double fonNetVarlikDegeri) {
        this.fonNetVarlikDegeri = fonNetVarlikDegeri;
    }

    public Double getNakit() {
        return nakit;
    }

    public void setNakit(Double nakit) {
        this.nakit = nakit;
    }

    public String getFonAlacaklari() {
        return fonAlacaklari;
    }

    public void setFonAlacaklari(String fonAlacaklari) {
        this.fonAlacaklari = fonAlacaklari;
    }

    public Double getFonBorclari() {
        return fonBorclari;
    }

    public void setFonBorclari(Double fonBorclari) {
        this.fonBorclari = fonBorclari;
    }

    public Double getFonBirimPayDegeri() {
        return fonBirimPayDegeri;
    }

    public void setFonBirimPayDegeri(Double fonBirimPayDegeri) {
        this.fonBirimPayDegeri = fonBirimPayDegeri;
    }

    public Double getKurucuAvansi() {
        return kurucuAvansi;
    }

    public void setKurucuAvansi(Double kurucuAvansi) {
        this.kurucuAvansi = kurucuAvansi;
    }

    public Double getAlinanPayAdedi() {
        return alinanPayAdedi;
    }

    public void setAlinanPayAdedi(Double alinanPayAdedi) {
        this.alinanPayAdedi = alinanPayAdedi;
    }

    public Double getSatilanPayAdedi() {
        return satilanPayAdedi;
    }

    public void setSatilanPayAdedi(Double satilanPayAdedi) {
        this.satilanPayAdedi = satilanPayAdedi;
    }

    public Double getEmanetFondaAlinanPayAdedi() {
        return emanetFondaAlinanPayAdedi;
    }

    public void setEmanetFondaAlinanPayAdedi(Double emanetFondaAlinanPayAdedi) {
        this.emanetFondaAlinanPayAdedi = emanetFondaAlinanPayAdedi;
    }

    public Double getEmanetFondaRatilanPayAdedi() {
        return emanetFondaRatilanPayAdedi;
    }

    public void setEmanetFondaRatilanPayAdedi(Double emanetFondaRatilanPayAdedi) {
        this.emanetFondaRatilanPayAdedi = emanetFondaRatilanPayAdedi;
    }

    public Double getTedavuldekiPayAdedi() {
        return tedavuldekiPayAdedi;
    }

    public void setTedavuldekiPayAdedi(Double tedavuldekiPayAdedi) {
        this.tedavuldekiPayAdedi = tedavuldekiPayAdedi;
    }

    public Double getPortfoyDegeri() {
        return portfoyDegeri;
    }

    public void setPortfoyDegeri(Double portfoyDegeri) {
        this.portfoyDegeri = portfoyDegeri;
    }

    public Double getFigkToplami() {
        return figkToplami;
    }

    public void setFigkToplami(Double figkToplami) {
        this.figkToplami = figkToplami;
    }

    public Double getGunlukFtgkTutari() {
        return gunlukFtgkTutari;
    }

    public void setGunlukFtgkTutari(Double gunlukFtgkTutari) {
        this.gunlukFtgkTutari = gunlukFtgkTutari;
    }

    public Double getFazlaYapilanFtgkIadeTutari() {
        return fazlaYapilanFtgkIadeTutari;
    }

    public void setFazlaYapilanFtgkIadeTutari(Double fazlaYapilanFtgkIadeTutari) {
        this.fazlaYapilanFtgkIadeTutari = fazlaYapilanFtgkIadeTutari;
    }

/*

 if (input.fnv_grp.fnv.get(i).containsKey("pdblst") && !input.fnv_grp.fnv.get(i).pdblst.equals("")) {
  if (input.fnv_grp.fnv.get(i).pdblst.pdb.getClass().getName().equals("java.util.ArrayList")) {
   for (var j = 0; j < input.fnv_grp.fnv.get(i).pdblst.size(); j++) {
    var subObj = entityUtils().create("pdb");
    if (input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).containsKey("isin") && !input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).isin.equals("")) {
         subObj.menkul_kiymet_isin_kodu = input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).isin;
    }
    subObj.menkul_kiymet_tipi = java.lang.Integer.parseInt(input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).kt);
    subObj.menkul_kiymet_tutari = Double.parseDouble(input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).ktt);
    subObj.nesne_sira_no = java.lang.Integer.parseInt(input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).no);
    obj._pdb_list.add(subObj);
   }
  } else {
   var subObj = entityUtils().create("pdb");
    if (input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).containsKey("isin") && !input.fnv_grp.fnv.get(i).pdblst.pdb.get(j).isin.equals("")) {
   subObj.menkul_kiymet_isin_kodu = input.fnv_grp.fnv.get(i).pdblst.pdb.isin;
  }
   subObj.menkul_kiymet_tipi = java.lang.Integer.parseInt(input.fnv_grp.fnv.get(i).pdblst.pdb.kt);
   subObj.menkul_kiymet_tutari = Double.parseDouble(input.fnv_grp.fnv.get(i).pdblst.pdb.ktt);
   subObj.nesne_sira_no = java.lang.Integer.parseInt(input.fnv_grp.fnv.get(i).pdblst.pdb.no);
   obj._pdb_list.add(subObj);
  }
 }

 entityUtils().save(obj);
}
return true;
*/
}
