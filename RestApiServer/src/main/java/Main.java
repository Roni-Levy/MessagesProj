import com.google.gson.Gson;
import handlers.HandlerRequest;
import responses.NewMessageResponse;
import responses.StatusResponse;
import ClientDataTypes.NewMessageRequest;

import static spark.Spark.*;

public class Main {
    private static HandlerRequest handlerRequest = new HandlerRequest();

    public static void main(String[] args) {
        Integer portNumber = Integer.parseInt(
                System.getenv().getOrDefault("REST_API_SERVER_PORT", String.valueOf(1234)));
        port(portNumber);

        post(("/api/resource"), (req, res) -> {
            res.type("application/json");
            NewMessageRequest newMessageRequest = new Gson().fromJson(req.body(), NewMessageRequest.class);
            return new Gson().toJson(new NewMessageResponse(
                    StatusResponse.SUCCESS, handlerRequest.sendNewMessage(newMessageRequest)));
        });

        get(("/api/resource/:id"), (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(handlerRequest.getResource(req.params(":id")));
        });
    }
}
