package model.delegation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.Fdo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monzer Masri on 18.4.2018.
 */
public class FdoDeserializer extends JsonDeserializer<List<Fdo>> {
    @Override
    public List<Fdo> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        List<Fdo> deserializedFdoList = new ArrayList<>();
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode fdolstNode = oc.readTree(jsonParser);
        JsonNode fdoNode = fdolstNode.get("fdo");

        if(fdoNode instanceof ArrayNode){
            JavaType fdoClassCollection =  ((ObjectMapper) oc).getTypeFactory().constructCollectionType(List.class, Fdo.class);
            deserializedFdoList = ((ObjectMapper) oc).readValue(fdoNode.toString() ,  fdoClassCollection);
        } else if(fdoNode instanceof ObjectNode){
            Fdo fdoObj = ((ObjectMapper) oc).readValue(fdoNode.toString(), Fdo.class);
            deserializedFdoList.add(fdoObj);
        }

        return deserializedFdoList;
    }
}
