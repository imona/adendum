package gev.xml.processor;

import gev.factory.ProcessorFactoryProducer;
import gev.writer.IGevObjectSaver;
import gev.xml.processor.automatic.parser.IXmlToJsonParser;
import gev.xml.processor.automatic.parser.XmlToJsonParserForPersist;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utils.LogUtils;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monzer Masri on 11.7.2018.
 */
@Service(value = "IptalXmlProcessor")
public class IptalXmlProcessor implements IGevXmlProcessor {
    private IXmlToJsonParser xmlToJsonParser = new XmlToJsonParserForPersist();

    @Inject
    @Qualifier(value = "GevThreadPoolSaver")
    private IGevObjectSaver iGevObjectSaver;

    @Override
    public void processXmlFile(File xmlFile) throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            Element rootNode = parseXmlFile(xmlFile);
            String veriTarihi = rootNode.getAttributeValue("vt");
            String sirkretNo = rootNode.getAttributeValue("sir");

            List<Element> elementList = rootNode.getChildren();
            for (Element e : elementList){
                String entityName = parseEntityName(e);
                String resultJsonString = prepareForPunchOfData(e);
                iGevObjectSaver.cancelObject("ipt_" + entityName, sirkretNo, veriTarihi, resultJsonString);
            }

        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.warning("Error : Processing IptalXmlFile" + xmlFile.getName() + ">" + e.getMessage(), xmlFile.getName());
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("totalTime >>> " + totalTime);
    }

    private Element parseXmlFile(File xmlFile) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        return rootNode;
    }

    private String parseEntityName(Element anyElement) throws Exception {
        String elementName = anyElement.getName();
        return elementName.substring(0, elementName.indexOf("_"));
    }

    private  String prepareForPunchOfData(Element element) throws IOException {
        List<Element> elementInList = new ArrayList<Element>();
        elementInList.add(element);
        String resultJsonString = xmlToJsonParser.prepareForPunchOfData(0, 1, elementInList);
        return resultJsonString;
    }

}
