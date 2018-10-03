package service.contracts;


import java.util.List;

/**
 * Created by Monzer Masri on 12.7.2018.
 */
public interface IModelInvalidatorGateway<T> {
    void cancel(List<Object> iptalGrpEntity) throws Exception;
}
