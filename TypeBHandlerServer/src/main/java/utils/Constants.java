package utils;

public class Constants {
    public final static String HANDLER_NAME = "TYPE-B";
    public final static String ENDING_CONSUMER_TOPIC =
            System.getenv().getOrDefault("ENDING_CONSUMER_TOPIC", "-HANDLER-TOPIC");
    public final static String CONSUMER_TOPIC = HANDLER_NAME + ENDING_CONSUMER_TOPIC;
    public final static String PARSED_MESSAGES_TOPIC =
            System.getenv().getOrDefault("PARSED_MESSAGES_TOPIC", "PARSED-MESSAGES-TOPIC");
    public final static String KAFKA_ADDRESS = "http://localhost:9092";
    public final static String SCHEMA_REGISTRY_ADDRESS = "http://localhost:8081";

    private Constants() {

    }
}
