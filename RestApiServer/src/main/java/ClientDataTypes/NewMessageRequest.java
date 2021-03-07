package ClientDataTypes;

public class NewMessageRequest {
    private String handlerName;
    private String handlerType;

    public NewMessageRequest(String name, String type) {
        handlerName = name;
        handlerType = type;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public String getHandlerName() {
        return handlerName;
    }
}
