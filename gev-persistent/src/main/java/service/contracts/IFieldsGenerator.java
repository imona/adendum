package service.contracts;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Monzer Masri on 17.4.2018.
 */
public interface IFieldsGenerator {
    public List<Field> retrieveFieldsToBeInserted(Class forClazz);
    public List<Field> getSubEntityListTypeOfFields(Class forClazz);
}
