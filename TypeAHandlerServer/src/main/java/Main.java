import MessagesSchemas.NewMessage;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;

import java.util.Collections;
import java.util.Properties;

public class Main {
    private final static String TOPIC = "TYPE-A-HANDLER-TOPIC";
    private final static String PARSED_MESSAGES_TOPIC = "PARSED-MESSAGES-TOPIC";
    private final static String KAFKA_ADDRESS = "http://localhost:9092";
    private final static String SCHEMA_REGISTRY_ADDRESS = "http://localhost:8081";
    private static KafkaProducer<String, NewMessage> producer;

    private static Consumer<Long, NewMessage> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_ADDRESS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "NewMessages");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_ADDRESS);
        return new KafkaConsumer<>(props);
    }

    public static void main(String... args) {

        final Consumer<Long, NewMessage> consumer = createConsumer();
        consumer.subscribe(Collections.singletonList(TOPIC));

        while (true) {
            ConsumerRecords<Long, NewMessage> records = consumer.poll(100);
            for (ConsumerRecord<Long, NewMessage> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
                handleNewMessage(record.value());
                consumer.commitSync();
            }
        }
    }

    private static void handleNewMessage(NewMessage newMessage){
        producer = new KafkaProducer<>(getProperties());
        newMessage.getMessageDetails().setParsed("Type A parser");
        newMessage.getMessageDetails().setServiceId("Type A service");
        ProducerRecord<String, NewMessage> record = new ProducerRecord<>(
                PARSED_MESSAGES_TOPIC, newMessage);
        producer.send(record);
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_ADDRESS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, PARSED_MESSAGES_TOPIC);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_ADDRESS);
        return props;
    }
}
