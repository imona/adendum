package model.delegation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.Fdo;
import model.PdbEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monzer Masri on 18.4.2018.
 */
public class PdbDeserializer extends JsonDeserializer<List<PdbEntity>> {
    @Override
    public List<PdbEntity> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        List<PdbEntity> deserializedPdbList = new ArrayList<>();
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode pdblstNode = oc.readTree(jsonParser);
        JsonNode pdbNode = pdblstNode.get("pdb");

        if(pdbNode instanceof ArrayNode){
            JavaType pdbClassCollection =  ((ObjectMapper) oc).getTypeFactory().constructCollectionType(List.class, PdbEntity.class);
            deserializedPdbList = ((ObjectMapper) oc).readValue(pdbNode.toString() ,  pdbClassCollection);
        } else if(pdbNode instanceof ObjectNode){
            PdbEntity pdbObj = ((ObjectMapper) oc).readValue(pdbNode.toString(), PdbEntity.class);
            deserializedPdbList.add(pdbObj);
        }

        return deserializedPdbList;
    }
}
