package handlers;

import MessagesSchemas.NewMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TypeBHandler extends AbstractHandler {
    private static TypeBHandler typeBHandler;
    private KafkaProducer<String, NewMessage> producer;
    private final String HANDLER_NAME = "TYPE-B";

    private TypeBHandler() {
        producer = createProducer();
    }

    public static TypeBHandler getInstance() {
        if(typeBHandler == null) {
            typeBHandler =  new TypeBHandler();
        }

        return typeBHandler;
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
