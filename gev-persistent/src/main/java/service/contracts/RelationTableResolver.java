package service.contracts;

import java.util.List;

/**
 * Created by Monzer Masri on 18.4.2018.
 */
public interface RelationTableResolver {
    void prepareRelationList(List objectList) throws Exception;
}
