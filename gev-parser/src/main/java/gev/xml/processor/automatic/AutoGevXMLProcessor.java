package gev.xml.processor.automatic;

import gev.factory.AbstractProcessorFactory;
import gev.factory.PersistPocessorFactory;
import gev.factory.ProcessorFactoryProducer;
import gev.writer.IGevObjectSaver;
import gev.xml.processor.GevXmlProcessorAbstract;
import gev.xml.processor.automatic.parser.IXmlToJsonParser;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utils.ConstantUtils;
import utils.LogUtils;
import utils.PropertyReader;

import javax.inject.Inject;
import java.io.File;
import java.util.List;
/**
 * Created by Monzer Masri on 23.11.2017.
 */
@Service(value = "AutoGevXMLProcessor")
public class AutoGevXMLProcessor extends GevXmlProcessorAbstract {
    @Inject
    @Qualifier(value = "GevThreadPoolSaver")
    private IGevObjectSaver iGevObjectSaver;

    private AbstractProcessorFactory processorFactory;
    private IXmlToJsonParser xmlToJsonParser;

    final Integer STEP =  Integer.valueOf(PropertyReader.getAppProperty(ConstantUtils.DATA_BATCH_SIZE));

    @Override
    public void processXmlFile(File xmlFile) throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            Element rootNode = parseXmlFile(xmlFile);
            String entityName = parseEntityNameFromFileName(xmlFile.getName());
            String veriTarihi = parseVeriTarihiFromFileName(xmlFile.getName());
            String sirkretNo = rootNode.getAttributeValue("sir");

            this.processorFactory = ProcessorFactoryProducer.getFactory(entityName);
            setXmlToJsonParser(processorFactory.produceXmlToJsonParser());
            List list = rootNode.getChildren(entityName);
            Boolean done = true;
            for (int i = 0; i + STEP <= list.size(); i = i + STEP) {
                String resultJsonString = xmlToJsonParser.prepareForPunchOfData(i, STEP, list);
                String response = iGevObjectSaver.saveObject(entityName, sirkretNo, veriTarihi, resultJsonString);
                if (!response.equals("true")) {
                    done = false;
//                    throw new Exception("response error");
                }
            }


            int max = (list.size() % STEP);
            int start = (list.size() / STEP) * STEP;
            String resultJsonString = xmlToJsonParser.prepareForPunchOfData(start, max, list);
            String response = iGevObjectSaver.saveObject(entityName, sirkretNo, veriTarihi, resultJsonString);

            if (done) {
                //xmlFile.renameTo(new File(utils.ConstantUtils.BACKUP_GEV_FILES_PATH + xmlFile.getName()));
            } else {
                //TODO : CALL ROLL BACLL

            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.warning("Error : Processing xmlFile" + xmlFile.getName() + ">" + e.getMessage(), xmlFile.getName());
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("totalTime >>> " + totalTime);
    }

    private static Element parseXmlFile(File xmlFile) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        return rootNode;
    }

    public IXmlToJsonParser getXmlToJsonParser() {
        return xmlToJsonParser;
    }

    public void setXmlToJsonParser(IXmlToJsonParser xmlToJsonParser) {
        this.xmlToJsonParser = xmlToJsonParser;
    }

    /*  private static String convertNodeToJson(Element node) {
        XMLOutputter outp = new XMLOutputter();
        String objAsXml = outp.outputString(node);
        // System.out.println(objAsXml);
        String objAsJson = XML.toJSONObject(objAsXml).toString();
        return objAsJson;
    }

    private static String prepareForPunchOfData(int start, int max, List list, String entityName) {
//        StringBuilder resultJsonString = new StringBuilder("{\"" + entityName + "_grp\":{\"" + entityName + "\":[");
        StringBuilder resultJsonString = new StringBuilder("[");
        for (int j = start; j < start + max; j++) {
            String objAsJson = convertNodeToJson((Element) list.get(j));
            objAsJson = objAsJson.substring(objAsJson.indexOf(":{") + 1, objAsJson.length() - 1);
            if (j == start) {
                resultJsonString.append(objAsJson);
            } else {
                resultJsonString.append(",").append(objAsJson);
            }
        }
//        resultJsonString.append("],\"sir\":0,\"vt\":20170517}}");
        resultJsonString.append("]");
        return resultJsonString.toString();
    }*/
}
