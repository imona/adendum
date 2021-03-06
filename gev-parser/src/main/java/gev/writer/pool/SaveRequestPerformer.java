package gev.writer.pool;

import core.SessionProp;
import gev.factory.ProcessorFactoryProducer;
import gev.writer.IGevObjectSaver;
import utils.LogUtils;

/**
 * Created by Monzer Masri on 12.12.2017.
 */
public class SaveRequestPerformer implements Runnable {
    private GevRequestInput gevRequestInput;
    private IGevObjectSaver gevObjectSaver;// = new ImonaGevObjectSaverBean();

    public SaveRequestPerformer(GevRequestInput gevRequestInput) throws Exception {
        this.gevRequestInput = gevRequestInput;

        gevObjectSaver = ProcessorFactoryProducer.getFactory(gevRequestInput.getEntityName()).produceGevObjectSaver();
    }

    @Override
    public void run() {
        try {
            String result = gevObjectSaver.saveObject(gevRequestInput.getEntityName(), gevRequestInput.getSirketNo(), gevRequestInput.getVeriTarihi(), gevRequestInput.getObjAsJson());
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.error(e);
            SessionProp.setValue("FAILED_BATCHES", SessionProp.getValue("FAILED_BATCHES") + 1);
        }
    }
}