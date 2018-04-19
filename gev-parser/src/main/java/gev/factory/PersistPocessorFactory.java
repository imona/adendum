package gev.factory;

import gev.writer.IGevObjectSaver;
import gev.writer.database.MySqlSaver;
import gev.xml.processor.automatic.parser.IXmlToJsonParser;
import gev.xml.processor.automatic.parser.XmlToJsonParserForPersist;
import model.*;

/**
 * Created by Monzer Masri on 11.4.2018.
 */
public class PersistPocessorFactory extends AbstractProcessorFactory {

    public PersistPocessorFactory(String entityName) {
        this.entityName = entityName;
    }


    @Override
    public IXmlToJsonParser produceXmlToJsonParser() {
        return new XmlToJsonParserForPersist();
    }

    @Override
    public IGevObjectSaver produceGevObjectSaver() throws Exception {
        //TODO : shouldnt be executed so much . to be investigated .
        switch (entityName) {
            case "hes":
                return new MySqlSaver<HesGrpEntity>(HesGrpEntity.class, HesGrpEntity[].class);
            case "soz":
                return new MySqlSaver<SozGrpEntity>(SozGrpEntity.class, SozGrpEntity[].class);
            case "kat":
                return new MySqlSaver<KatGrpEntity>(KatGrpEntity.class, KatGrpEntity[].class);
            case "fnv":
                return new MySqlSaver<FnvGrpEntity>(FnvGrpEntity.class, FnvGrpEntity[].class);
            default:
                return null;
        }
    }
}
