package parsers;

import MessagesSchemas.NewMessage;

import static utils.Constants.HANDLER_NAME;

public class ParserC extends AbstractParser{
    private static ParserC parserC = null;

    private ParserC() {
        super("ParserC");
    }

    public static ParserC getInstance() {
        if(parserC == null) {
            parserC = new ParserC();
        }

        return parserC;
    }

    @Override
    public void handleMessage(NewMessage newMessage) {
        System.out.println("Accepted message to parse in Parser C");
        newMessage.getMessageDetails().setParsed(setParsedData());
        newMessage.getMessageDetails().setServiceId(SERVICE_ID);
        sendMessageBack(newMessage);
    }

    @Override
    String setParsedData() {
        return "Parser C in " + HANDLER_NAME;
    }
}
