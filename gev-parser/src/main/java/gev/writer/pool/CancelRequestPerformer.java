package gev.writer.pool;

import core.SessionProp;
import gev.factory.ProcessorFactoryProducer;
import gev.writer.IGevObjectSaver;
import gev.writer.database.DatabaseSaver;
import utils.LogUtils;

/**
 * Created by Monzer Masri on 13.7.2018.
 */
public class CancelRequestPerformer implements Runnable {
    private GevRequestInput gevRequestInput;
    private IGevObjectSaver gevObjectSaver;

    public CancelRequestPerformer(GevRequestInput gevRequestInput) throws Exception {
        this.gevRequestInput = gevRequestInput;

        gevObjectSaver = ProcessorFactoryProducer.getFactory(gevRequestInput.getEntityName()).produceGevObjectSaver();
    }

    @Override
    public void run() {
        try {
             gevObjectSaver.cancelObject(gevRequestInput.getEntityName(), gevRequestInput.getSirketNo(), gevRequestInput.getVeriTarihi(), gevRequestInput.getObjAsJson());
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "CancelObject Failed :" + gevRequestInput.getObjAsJson();
            LogUtils.error(msg, e);
            SessionProp.setValue("FAILED_BATCHES", SessionProp.getValue("FAILED_BATCHES") + 1);
        }
    }
}