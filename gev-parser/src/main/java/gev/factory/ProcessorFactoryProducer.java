package gev.factory;

/**
 * Created by Monzer Masri on 12.4.2018.
 */
public class ProcessorFactoryProducer {
    public static AbstractProcessorFactory getFactory(String entityName){
        return new PersistPocessorFactory(entityName);
//        return new ApiProcessorFactory(entityName);
    }
}
