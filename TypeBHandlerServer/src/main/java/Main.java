
import MessagesSchemas.NewMessage;
import org.apache.kafka.clients.consumer.*;
import parsers.ParsersFactory;
import java.util.Collections;
import static utils.Constants.CONSUMER_TOPIC;
import static utils.GlobalMethods.createConsumer;

public class Main {
    public static void main(String... args) {
        final Consumer<Long, NewMessage> consumer = createConsumer();
        consumer.subscribe(Collections.singletonList(CONSUMER_TOPIC));

        while (true) {
            ConsumerRecords<Long, NewMessage> records = consumer.poll(100);
            for (ConsumerRecord<Long, NewMessage> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
                ParsersFactory.getParser(record.value().getParserName()).handleMessage(record.value());
                consumer.commitSync();
            }
        }
    }
}
