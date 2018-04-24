package gev.xml.processor.automatic.parser;

import org.jdom2.Element;

import java.io.IOException;
import java.util.List;

/**
 * Created by Monzer Masri on 10.4.2018.
 */
public class XmlToJsonParserForPersist extends IXmlToJsonParser {

    @Override
    public String prepareForPunchOfData(int start, int max, List xmlElementlist) throws IOException {
        StringBuilder resultJsonString = new StringBuilder("[");
        for (int j = start; j < start + max; j++) {
            String objAsJson = convertNodeToJson((Element) xmlElementlist.get(j));
            objAsJson = objAsJson.substring(objAsJson.indexOf(":{") + 1, objAsJson.length() - 1);
            if (j == start) {
                resultJsonString.append(objAsJson);
            } else {
                resultJsonString.append(",").append(objAsJson);
            }
        }
        resultJsonString.append("]");
        return resultJsonString.toString();
    }
}
