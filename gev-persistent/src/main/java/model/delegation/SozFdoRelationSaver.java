package model.delegation;

import model.Fdo;
import model.SozFdoRelationEntity;
import model.SozGrpEntity;
import service.ModelNativeSaver;
import service.contracts.RelationTableResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monzer Masri on 18.4.2018.
 */
public class SozFdoRelationSaver implements RelationTableResolver {
    @Override
    public void prepareRelationList(List objectList) throws Exception {
        List<SozFdoRelationEntity> sozFdoEntities = new ArrayList<>();
        for (Object object : objectList) {
            SozGrpEntity mySozGrpEntity = (SozGrpEntity) object;
            if (mySozGrpEntity != null && mySozGrpEntity.getFdoList() != null) {
                for (Fdo fdo : mySozGrpEntity.getFdoList()) {
                    sozFdoEntities.add(new SozFdoRelationEntity(mySozGrpEntity.getId(), fdo.getId()));
                }
            }
        }

        ModelNativeSaver relationModelSaver = new ModelNativeSaver(SozFdoRelationEntity.class);
        relationModelSaver.persist(sozFdoEntities);
    }
}
