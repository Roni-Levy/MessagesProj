package ClientDataTypes;

public class NewMessageRequest {
    private String handlerName;
    private String messageContent;

    public NewMessageRequest(String name, String type) {
        handlerName = name;
        messageContent = type;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getHandlerName() {
        return handlerName;
    }
}
