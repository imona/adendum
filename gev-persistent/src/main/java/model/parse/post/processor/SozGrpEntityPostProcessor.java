package model.parse.post.processor;

import model.BaseGrpEntity;
import model.SozGrpEntity;

/**
 * Created by Monzer Masri on 24.4.2018.
 */
public class SozGrpEntityPostProcessor implements IParsePostProcessor{
    @Override
    public void processObj(BaseGrpEntity baseGrpEntity) {
        ((SozGrpEntity)baseGrpEntity).sozNo = ((SozGrpEntity)baseGrpEntity).sozNo + "-" + ((SozGrpEntity)baseGrpEntity).sertifikaNo;
    }
}
