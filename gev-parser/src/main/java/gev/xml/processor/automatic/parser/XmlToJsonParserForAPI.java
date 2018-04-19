package gev.xml.processor.automatic.parser;

import org.jdom2.Element;

import java.util.List;


/**
 * Created by Monzer Masri on 10.4.2018.
 */
public class XmlToJsonParserForAPI extends IXmlToJsonParser {
    private String entityName;

    public XmlToJsonParserForAPI(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String prepareForPunchOfData(int start, int max, List xmlElementlist) {
        StringBuilder resultJsonString = new StringBuilder("{\"" + entityName + "_grp\":{\"" + entityName + "\":[");
        for (int j = start; j < start + max; j++) {
            String objAsJson = super.convertNodeToJson((Element) xmlElementlist.get(j));
            objAsJson = objAsJson.substring(objAsJson.indexOf(":{") + 1, objAsJson.length() - 1);
            if (j == start) {
                resultJsonString.append(objAsJson);
            } else {
                resultJsonString.append(",").append(objAsJson);
            }
        }
        resultJsonString.append("],\"sir\":0,\"vt\":20170517}}");
        return resultJsonString.toString();
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
