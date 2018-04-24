package model.delegation;

import model.*;
import service.ModelNativeSaver;
import service.contracts.RelationTableResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monzer Masri on 19.4.2018.
 */
public class FnvPdbRelationSaver implements RelationTableResolver {
    @Override
    public void prepareRelationList(List objectList) throws Exception {
        List<FnvPdbRelationEntity> fnvPdbRelationEntities = new ArrayList<>();
        for (Object object : objectList) {
            FnvGrpEntity myFnvGrpEntity = (FnvGrpEntity) object;
            for (PdbEntity pdbEntity : myFnvGrpEntity.getPdbList()) {
                fnvPdbRelationEntities.add(new FnvPdbRelationEntity(myFnvGrpEntity.getId(), pdbEntity.getId()));
            }
        }

        ModelNativeSaver relationModelSaver = new ModelNativeSaver(FnvPdbRelationEntity.class);
        relationModelSaver.persist(fnvPdbRelationEntities);
    }
}
