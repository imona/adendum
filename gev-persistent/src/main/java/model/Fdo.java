package model;

import com.fasterxml.jackson.annotation.*;
import model.annotation.ColumnName;
import model.annotation.TableName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Monzer Masri on 16.4.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("eyf_fdo")
public class Fdo extends BaseEntity {
    @JsonProperty("fk")
    @ColumnName("fon_kodu")
    private Integer fk;

    @JsonProperty("fo")
    @ColumnName("fon_oran")
    private Double fo;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fk")
    public Integer getFk() {
        return fk;
    }

    @JsonProperty("fk")
    public void setFk(Integer fk) {
        this.fk = fk;
    }

    @JsonProperty("fo")
    public Double getFo() {
        return fo;
    }

    @JsonProperty("fo")
    public void setFo(Double fo) {
        this.fo = fo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}