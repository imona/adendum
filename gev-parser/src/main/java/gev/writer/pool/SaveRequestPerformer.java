package gev.writer.pool;

import core.Main;
import core.SessionProp;
import gev.factory.ProcessorFactoryProducer;
import gev.writer.IGevObjectSaver;

/**
 * Created by Monzer Masri on 12.12.2017.
 */
public class SaveRequestPerformer implements Runnable {
    private GevSaveRequestInput gevSaveRequestInput;
    private IGevObjectSaver gevObjectSaver;// = new ImonaGevObjectSaverBean();

    public SaveRequestPerformer(GevSaveRequestInput gevSaveRequestInput) throws Exception {
        this.gevSaveRequestInput = gevSaveRequestInput;

        gevObjectSaver = ProcessorFactoryProducer.getFactory(gevSaveRequestInput.getEntityName()).produceGevObjectSaver();
    }

    @Override
    public void run() {
        try {
            String result = gevObjectSaver.saveObject(gevSaveRequestInput.getEntityName(), gevSaveRequestInput.getSirketNo(), gevSaveRequestInput.getVeriTarihi(), gevSaveRequestInput.getObjAsJson());
        } catch (Exception e) {
            e.printStackTrace();
            //todo : increase
            SessionProp.setValue("FAILED_BATCHES", SessionProp.getValue("FAILED_BATCHES") + 1);
        }
    }
}