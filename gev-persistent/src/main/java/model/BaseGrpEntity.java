package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.delegation.DateWithoutTimeDeserializer;
import model.annotation.ColumnName;

import java.util.Date;

public class BaseGrpEntity extends BaseEntity{

    @ColumnName("veri_tarihi")
    @JsonDeserialize(using = DateWithoutTimeDeserializer.class)
    public Date veriTarihi;

    @ColumnName("sirket_numarasi")
    public Integer sirketNumarasi;

    @ColumnName("transaction_status")
    public Boolean transactionStatus = true;

    public Date getVeriTarihi() {
        return veriTarihi;
    }

    public void setVeriTarihi(Date veriTarihi) {
        this.veriTarihi = veriTarihi;
    }

    public Integer getSirketNumarasi() {
        return sirketNumarasi;
    }

    public void setSirketNumarasi(Integer sirketNumarasi) {
        this.sirketNumarasi = sirketNumarasi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
