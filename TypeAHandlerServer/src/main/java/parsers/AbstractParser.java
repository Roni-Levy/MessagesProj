package parsers;

import MessagesSchemas.NewMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import static utils.Constants.HANDLER_NAME;
import static utils.Constants.PARSED_MESSAGES_TOPIC;
import static utils.GlobalMethods.getProducer;

public abstract class AbstractParser {
    protected static final String SERVICE_ID =
            System.getenv().getOrDefault(HANDLER_NAME, HANDLER_NAME + "-SERVICE-ID");
    private static KafkaProducer<String, NewMessage> producer;

    private String parserName;

    protected AbstractParser(String parserName) {
        this.parserName = parserName;
    }

    public abstract void handleMessage(NewMessage newMessage);

    abstract String setParsedData();

    protected static void sendMessageBack(NewMessage message) {
        producer = getProducer();
        ProducerRecord<String, NewMessage> record = new ProducerRecord<>(
                PARSED_MESSAGES_TOPIC, message);
        producer.send(record);
    }
}
