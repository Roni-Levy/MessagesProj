package handlers;

import MessagesSchemas.NewMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TypeAHandler extends AbstractHandler{
    private static TypeAHandler typeAHandler = null;
    private KafkaProducer<String, NewMessage> producer;
    private final String HANDLER_NAME = "TYPE-A";

    private TypeAHandler() {
        producer = createProducer();
    }

    public static TypeAHandler getInstance() {
        if(typeAHandler == null) {
            typeAHandler =  new TypeAHandler();
        }

        return typeAHandler;
    }

    @Override
    KafkaProducer<String, NewMessage> createProducer() {
        return new KafkaProducer<>(getProperties(HANDLER_NAME));
    }

    @Override
    public String sendRecord(NewMessage newMessage) {
        ProducerRecord<String, NewMessage> record = new ProducerRecord<>(
                HANDLER_NAME + TOPIC_ENDING, newMessage);
        producer.send(record);

        return newMessage.getMessageId();
    }
}
