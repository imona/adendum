package model;

import model.annotation.ColumnName;
import model.annotation.TableName;

/**
 * Created by Monzer Masri on 19.4.2018.
 */
@TableName("eyf_fnv_grp__pdb_list")
public class FnvPdbRelationEntity {

    public FnvPdbRelationEntity(Long fnvGrpId, Long pdbId) {
        this.fnvGrpId = fnvGrpId;
        this.pdbId = pdbId;
    }

    @ColumnName("fnv_grp_id")
    private Long fnvGrpId;

    @ColumnName("_pdb_list_id")
    private Long pdbId;

    public Long getFnvGrpId() {
        return fnvGrpId;
    }

    public void setFnvGrpId(Long fnvGrpId) {
        this.fnvGrpId = fnvGrpId;
    }

    public Long getPdbId() {
        return pdbId;
    }

    public void setPdbId(Long pdbId) {
        this.pdbId = pdbId;
    }
}
