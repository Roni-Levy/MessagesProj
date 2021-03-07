package handlers;

import MessagesSchemas.NewMessage;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import java.util.Properties;

public abstract class AbstractHandler {
    private final static String KAFKA_ADDRESS =
            System.getenv().getOrDefault("KAFKA_ADDRESS", "http://localhost:9092");
    private final static String SCHEMA_REGISTRY_ADDRESS =
            System.getenv().getOrDefault("SCHEMA_REGISTRY_ADDRESS", "http://localhost:8081");
    public final static String TOPIC_ENDING = "-HANDLER-TOPIC";

    abstract KafkaProducer<String, NewMessage> createProducer();

    public abstract String sendRecord(NewMessage newMessage);

    protected static Properties getProperties(String handlerName) {
        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_ADDRESS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, handlerName + TOPIC_ENDING);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_ADDRESS);
        return props;
    }

}
