package gev.xml.processor;

import gev.xml.processor.automatic.AutoGevXMLProcessor;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Imona Andoid on 24.11.2017.
 */
@Component
public class ManualTester {
    private GevXmlProcessorAbstract gevXmlProcessorAbstract = new AutoGevXMLProcessor();

    public void goIt(String filePath) {
        try {
            File xmlFile = new File(filePath);
            gevXmlProcessorAbstract.processXmlFile(xmlFile);
        }catch (Exception e){

        }
    }
}
