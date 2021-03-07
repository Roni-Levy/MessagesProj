package parsers;

import MessagesSchemas.NewMessage;

import static utils.Constants.HANDLER_NAME;

public class ParserB extends AbstractParser{
    private static ParserB parserB = null;

    private ParserB() {
        super("ParserB");
    }

    public static ParserB getInstance() {
        if(parserB == null) {
            parserB = new ParserB();
        }

        return parserB;
    }

    @Override
    public void handleMessage(NewMessage newMessage) {
        System.out.println("Accepted message to parse in Parser B");
        newMessage.getMessageDetails().setParsed(setParsedData());
        newMessage.getMessageDetails().setServiceId(SERVICE_ID);
        sendMessageBack(newMessage);
    }

    @Override
    String setParsedData() {
        return "Parser B in " + HANDLER_NAME;
    }
}
