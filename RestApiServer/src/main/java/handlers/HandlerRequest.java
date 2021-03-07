package handlers;

import MessagesSchemas.MessageDetails;
import MessagesSchemas.NewMessage;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.LongDeserializer;
import ClientDataTypes.NewMessageRequest;

import java.util.*;

public class HandlerRequest {
    private final static String KAFKA_ADDRESS =
            System.getenv().getOrDefault("KAFKA_ADDRESS", "http://localhost:9092");
    private final static String SCHEMA_REGISTRY_ADDRESS =
            System.getenv().getOrDefault("SCHEMA_REGISTRY_ADDRESS", "http://localhost:8081");
    public final static String PARSED_MESSAGES_TOPIC = "PARSED-MESSAGES-TOPIC";

    private HashMap<String, AbstractHandler> handlers = initializeHandlersMap();
    private HashMap<String, NewMessage> parsedMessages = new HashMap<>();

    public HandlerRequest() {

    }

    public NewMessage getResource (String id) {
        final Consumer<Long, NewMessage> consumer = createConsumer();
        consumer.subscribe(Collections.singletonList(PARSED_MESSAGES_TOPIC));

        ConsumerRecords<Long, NewMessage> records = consumer.poll(100);
        for (ConsumerRecord<Long, NewMessage> record : records) {
            parsedMessages.put(record.value().getMessageId(), record.value());
        }

        consumer.close();

        return parsedMessages.get(id);
    }

    public String sendNewMessage(NewMessageRequest newMessageRequest) {
        NewMessage newMessage = newMessageRequestToAvroNewMessage(newMessageRequest);
        return handlers.get(newMessage.getHandlerName()).sendRecord(newMessage);
    }

    private HashMap<String, AbstractHandler> initializeHandlersMap() {
        HashMap<String, AbstractHandler> newHandlersMap = new HashMap<>();
        newHandlersMap.put(new String("TYPE-B"), TypeBHandler.getInstance());
        newHandlersMap.put(new String("TYPE-A"), TypeAHandler.getInstance());

        return newHandlersMap;
    }

    private NewMessage newMessageRequestToAvroNewMessage(NewMessageRequest newMessageRequest) {
        String[] handlerProperties = newMessageRequest.getHandlerName().split(" ");

        return NewMessage.newBuilder()
                .setMessageId(generateUuid())
                .setHandlerName(handlerProperties[0])
                .setParserName(handlerProperties[1])
                .setMessageDetails(creteMessageDetails(newMessageRequest))
                .build();
    }

    public MessageDetails creteMessageDetails(NewMessageRequest newMessageRequest) {
        return MessageDetails.newBuilder()
                .setMessageContent(newMessageRequest.getMessageContent())
                .setSendingTime(new Date().getTime())
                .build();
    }

    private String generateUuid() {
        return UUID.randomUUID().toString();
    }

    private static Consumer<Long, NewMessage> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_ADDRESS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "Messages");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_ADDRESS);
        return new KafkaConsumer<>(props);
    }
}