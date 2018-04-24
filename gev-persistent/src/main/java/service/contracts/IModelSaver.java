package service.contracts;

import java.util.List;

/**
 * Created by Monzer Masri  on 6.4.2018.
 */
public interface IModelSaver<T>{
  public int persist(List<T> objectList)  throws Exception;
}
