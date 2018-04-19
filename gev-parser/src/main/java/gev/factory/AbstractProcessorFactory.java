package gev.factory;

import gev.writer.IGevObjectSaver;
import gev.xml.processor.automatic.parser.IXmlToJsonParser;

/**
 * Created by monzer masri on 11.4.2018.
 */
public abstract class AbstractProcessorFactory {
    public String entityName;

    public abstract IXmlToJsonParser produceXmlToJsonParser();
    public abstract  IGevObjectSaver produceGevObjectSaver() throws Exception;
}
