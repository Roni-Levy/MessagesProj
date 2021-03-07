package parsers;

import MessagesSchemas.NewMessage;

import static utils.Constants.HANDLER_NAME;

public class ParserA extends AbstractParser{
    private static ParserA parserA = null;

    private ParserA() {
        super("ParserA");
    }

    public static ParserA getInstance() {
        if(parserA == null) {
            parserA = new ParserA();
        }

        return parserA;
    }

    @Override
    public void handleMessage(NewMessage newMessage) {
        System.out.println("Accepted message to parse in Parser A");
        newMessage.getMessageDetails().setParsed(setParsedData());
        newMessage.getMessageDetails().setServiceId(SERVICE_ID);
        sendMessageBack(newMessage);
    }

    @Override
    String setParsedData() {
        return "Parser A in " + HANDLER_NAME;
    }
}
