package Framework.Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class RestClient {
    public void SetBaseUrl(String url){
        RestAssured.baseURI = url;
    }

    public Response GetRequest(String routePrefix){
        return RestAssured.get(routePrefix)
                .thenReturn();
    }

    public Response GetRequest(String routePrefix, HashMap<String, String> queryParams){
        return RestAssured.get(routePrefix, queryParams)
                .thenReturn();
    }

    public Response PostRequest(String routePrefix, Class pojo){
        return RestAssured.post(routePrefix, pojo);
    }

    public Response PutRequest(String routePrefix, Class pojo){
        return RestAssured.put(routePrefix, pojo);
    }

    public Response DeleteRequest(String routePrefix, Class pojo){
        return RestAssured.delete(routePrefix, pojo);
    }
}
