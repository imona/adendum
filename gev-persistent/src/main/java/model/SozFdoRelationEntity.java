package model;

import model.annotation.ColumnName;
import model.annotation.TableName;

/**
 * Created by Monzer Masri on 18.4.2018.
 */
@TableName("eyf_soz_grp__fdo_list")
public class SozFdoRelationEntity {

    @ColumnName("soz_grp_id")
    private Long sozGrpId;

    @ColumnName("_fdo_list_id")
    private Long fdoId;

    public SozFdoRelationEntity(Long sozGrpId, Long fdoId) {
        this.sozGrpId = sozGrpId;
        this.fdoId = fdoId;
    }

    public Long getSozGrpId() {
        return sozGrpId;
    }

    public void setSozGrpId(Long sozGrpId) {
        this.sozGrpId = sozGrpId;
    }

    public Long getFdoId() {
        return fdoId;
    }

    public void setFdoId(Long fdoId) {
        this.fdoId = fdoId;
    }
}
