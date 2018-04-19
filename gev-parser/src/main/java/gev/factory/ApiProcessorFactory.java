package gev.factory;

import gev.writer.IGevObjectSaver;
import gev.writer.api.ImonaGevObjectSaverBean;
import gev.xml.processor.automatic.parser.IXmlToJsonParser;
import gev.xml.processor.automatic.parser.XmlToJsonParserForAPI;

/**
 * Created by Monzer Masri on 11.4.2018.
 */
public class ApiProcessorFactory extends AbstractProcessorFactory {

    public ApiProcessorFactory(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public IXmlToJsonParser produceXmlToJsonParser() {
        return new XmlToJsonParserForAPI(this.entityName);
    }

    @Override
    public IGevObjectSaver produceGevObjectSaver() {
        return new ImonaGevObjectSaverBean();
    }
}
