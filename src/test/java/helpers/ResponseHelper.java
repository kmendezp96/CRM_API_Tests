package helpers;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;


public class ResponseHelper {
    private static Response response;
    private static RequestSpecification given;
    private static String url;

    public ResponseHelper(String serviceName, String typeKey) {
        url = PropertiesHelper.getUrl() + serviceName;
        given = RestAssured.given();
        Header header = new Header("x-endpoint-key", this.getKey(typeKey));
        given = given.header(header);
    }


    public static Response responsePut(String id, String entity){
        response = given.pathParam("id", id).body(entity).contentType("application/json").when().put(url+"/{id}");
        return response;
    }

    public static Response responsePost(String entity){
        response = given.contentType("application/json").body(entity).post(url);
        return response;
    }

    public static Response responseGetAll(){
        response = given.contentType("application/json").when().get(url);
        return response;
    }

    public static Response responseGet(){
        response = given.contentType("application/json").when().get(url);
        return response;
    }

    public static Response responseGetOne(String id){
            response = given.pathParam("id", id).contentType("application/json").when().get(url + "/{id}");
            return response;
    }
    public static Response responseGet(String id){
        response = given.contentType("application/json").when().get(url+"/"+id);
        return response;
    }

    public static Response responseDelete(String id){
        response = given.pathParam("id", id).when().delete(url+"/{id}");
        return response;
    }

    public static Response getResponse() {
        return response;
    }

    private String getKey(String key){
        if(key.equalsIgnoreCase("write permission")){
            return PropertiesHelper.getKeyReadWrite();
        } else if(key.equalsIgnoreCase("only read permission") || key.equalsIgnoreCase("read permission")) {
            return PropertiesHelper.getKeyReadOnly();
        }else{
            return PropertiesHelper.getKeyAll();
        }
    }
}
