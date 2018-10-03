package gev.xml.processor.automatic.parser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.json.XML;

/**
 * Created by Monzer Masri on 10.4.2018.
 */
public abstract class IXmlToJsonParser {
    public abstract String prepareForPunchOfData(int start, int max, List xmlElementlist) throws IOException;

    protected String convertNodeToJson(Element node) throws IOException {
        XMLOutputter outp = new XMLOutputter();
        String objAsXml = outp.outputString(node);
        return XML.toJSONObject(objAsXml).toString();


/*
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode myNode = xmlMapper.readTree(objAsXml.getBytes());

        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(myNode);
        return json;*/
    }
}
