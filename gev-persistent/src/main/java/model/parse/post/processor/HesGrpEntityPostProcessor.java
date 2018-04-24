package model.parse.post.processor;

import model.BaseGrpEntity;
import model.HesGrpEntity;
import model.SozGrpEntity;

/**
 * Created by Monzer Masri on 24.4.2018.
 */
public class HesGrpEntityPostProcessor implements IParsePostProcessor{
    @Override
    public void processObj(BaseGrpEntity baseGrpEntity) {
        ((HesGrpEntity)baseGrpEntity).sozNo = ((HesGrpEntity)baseGrpEntity).sozNo + "-" + ((HesGrpEntity)baseGrpEntity).sertifikaNo;
    }
}
