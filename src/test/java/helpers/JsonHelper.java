package helpers;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;

public class JsonHelper {

    public static JsonObject getJsonObjectFromResponse(Response response) {
        String jsonString = response.then().extract().response().body().print();
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static JsonArray getJsonObjectListFromResponse(Response response) {
        String jsonString = response.then().extract().response().body().print();
        return new JsonParser().parse(jsonString).getAsJsonArray();
    }

    public static JsonSchemaFactory schemaFactory(){
        return JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(DRAFTV4).freeze()).freeze();
    }
}
