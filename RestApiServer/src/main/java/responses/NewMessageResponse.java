package responses;

public class NewMessageResponse {
    private StatusResponse status;
    private String id;

    public NewMessageResponse(StatusResponse status, String messageId) {
        this.status = status;
        id = messageId;
    }
}
