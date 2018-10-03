package service.iptal;

import model.iptal.IptalFnvEntity;
import model.iptal.IptalHesEntity;
import model.iptal.IptalKatEntity;
import model.iptal.IptalSozEntity;
import service.contracts.IModelInvalidatorGateway;

import java.util.List;

/**
 * Created by Monzer Masri on 12.7.2018.
 */
public class ModelInvalidatorGateway implements IModelInvalidatorGateway {

    @Override
    public void cancel(List iptalGrpEntityList) throws Exception {
        for(Object grp : iptalGrpEntityList){
            if(grp instanceof IptalSozEntity){
                new SozIptalExecutor((IptalSozEntity)grp).execute();
            } else  if(grp instanceof IptalHesEntity){
                new HesIptalExecutor((IptalHesEntity)grp).execute();
            } else  if(grp instanceof IptalKatEntity){
                new KatIptalExecutor((IptalKatEntity)grp).execute();
            } else  if(grp instanceof IptalFnvEntity){
                new FnvIptalExecutor((IptalFnvEntity)grp).execute();
            }
        }
    }
}
