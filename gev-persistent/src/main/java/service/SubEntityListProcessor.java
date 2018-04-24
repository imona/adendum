package service;

import model.annotation.SubEntityList;
import service.contracts.ISubEntityProcessor;

import java.lang.reflect.Field;
import java.util.List;

public class SubEntityListProcessor implements ISubEntityProcessor {
    public void processSubEntity(Field subEntityField, List objectList) throws Exception {
        for (Object object : objectList) {
            subEntityField.setAccessible(true);
            SubEntityList subEntityListAnnotation = subEntityField.getAnnotation(SubEntityList.class);

            List subDataList = (List) subEntityField.get(object);
            if (subDataList != null && subDataList.size() > 0) {
                ModelNativeSaver subModelSaver = new ModelNativeSaver(subEntityListAnnotation.value());
                subModelSaver.persist(subDataList);
            }
        }

    }
}
