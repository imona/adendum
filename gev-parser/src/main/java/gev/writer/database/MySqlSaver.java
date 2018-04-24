package gev.writer.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import gev.writer.IGevObjectSaver;
import model.BaseGrpEntity;
import model.HesGrpEntity;
import model.SozGrpEntity;
import model.parse.post.processor.IParsePostProcessor;
import service.contracts.IModelSaver;
import service.ModelNativeSaver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by Monzer Masri  on 6.4.2018.
 * This class Works as proxy to gev-persist Module.
 */

public class MySqlSaver<T extends BaseGrpEntity> implements IGevObjectSaver {
    private IModelSaver iModelSaver;
    private Class<T[]> forArrayClazz;
    private IParsePostProcessor postProcessor;

    public MySqlSaver(Class<T> forClazz, Class<T[]> forArrayClazz, IParsePostProcessor postProcessor) throws ClassNotFoundException {
        this.forArrayClazz = forArrayClazz;
        this.iModelSaver = new ModelNativeSaver(forClazz);
        this.postProcessor = postProcessor;
    }

    @Override
    public String saveObject(String entityName, String sirkretNo, String veriTarihi, String objAsJson) throws Exception {
        //TODO : parse json to object list.
        T[] baseGrpEntities = processJsonToObject(objAsJson);
        fillUnparsableProperties(baseGrpEntities, sirkretNo, veriTarihi);
        callPostProcess(baseGrpEntities);
        //TODO : call service
        iModelSaver.persist(Arrays.asList(baseGrpEntities));

        return "";
    }

    private T[] processJsonToObject(String objAsJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(objAsJson, forArrayClazz);
    }

    private void fillUnparsableProperties(T[] baseGrpEntities, String sirkretNo, String veriTarihi) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        for (BaseGrpEntity hesGrpEntity : baseGrpEntities) {
            hesGrpEntity.setSirketNumarasi(Integer.valueOf(sirkretNo));
            hesGrpEntity.setVeriTarihi(df.parse(veriTarihi));
        }
    }

    private void callPostProcess(T[] baseGrpEntities) {
        if(postProcessor != null){
            for (BaseGrpEntity baseGrpEntity: baseGrpEntities) {
                postProcessor.processObj(baseGrpEntity);
            }
        }
    }
}
