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

    public static Response responsePost(Map<String, String> entity){
        response = given.contentType("application/json").body(entity).when().post(url);
        return response;
    }

    public static Response resposeGet(){
        response = given.contentType("application/json").when().get(url);
        return response;
    }

    public static Response getResponse() {
        return response;
    }

    private String getKey(String key){
        if(key.equalsIgnoreCase("write permission")){
            return PropertiesHelper.getKeyReadWrite();
        }else {
            return PropertiesHelper.getKeyReadOnly();
        }
    }
}
