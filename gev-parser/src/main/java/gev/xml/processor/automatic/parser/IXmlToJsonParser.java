package gev.xml.processor.automatic.parser;

import java.util.List;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.json.XML;

/**
 * Created by Monzer Masri on 10.4.2018.
 */
public abstract class IXmlToJsonParser {
    public abstract String prepareForPunchOfData(int start, int max, List xmlElementlist);

    protected String convertNodeToJson(Element node) {
        XMLOutputter outp = new XMLOutputter();
        String objAsXml = outp.outputString(node);
        return XML.toJSONObject(objAsXml).toString();
    }
}
