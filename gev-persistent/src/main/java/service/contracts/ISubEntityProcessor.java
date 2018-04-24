package service.contracts;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Monzer Masri on 24.4.2018.
 */
public interface ISubEntityProcessor{
    public void processSubEntity(Field subEntityField, List objectList) throws Exception ;
}
