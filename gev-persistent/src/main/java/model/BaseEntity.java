package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.annotation.ColumnName;

import java.util.Date;

/**
 * Created by Monzer Masri on 11.4.2018.
 */
public class BaseEntity{
    public Long id;

    @ColumnName("imona_version")
    @JsonIgnore
    public Long imonaVersion = Long.valueOf(0);

    @ColumnName("userid")
    @JsonIgnore
    public String useriId = "xml_loader";

    @ColumnName("apprvd")
    @JsonIgnore
    public Boolean apprvd = true;


    @ColumnName("hostts")
    @JsonIgnore
    public Date hostts = new Date();

    public Date getHostts() {
        return hostts;
    }

    public void setHostts(Date hostts) {
        this.hostts = hostts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImonaVersion() {
        return imonaVersion;
    }

    public void setImonaVersion(Long imonaVersion) {
        this.imonaVersion = imonaVersion;
    }

    public String getUseriId() {
        return useriId;
    }

    public void setUseriId(String useriId) {
        this.useriId = useriId;
    }

    public Boolean getApprvd() {
        return apprvd;
    }

    public void setApprvd(Boolean apprvd) {
        this.apprvd = apprvd;
    }
}
