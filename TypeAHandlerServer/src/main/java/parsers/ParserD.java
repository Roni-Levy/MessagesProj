package parsers;

import MessagesSchemas.NewMessage;

import static utils.Constants.HANDLER_NAME;

public class ParserD extends AbstractParser{
    private static ParserD parserD = null;

    private ParserD() {
        super("ParserD");
    }

    public static ParserD getInstance() {
        if(parserD == null) {
            parserD = new ParserD();
        }

        return parserD;
    }

    @Override
    public void handleMessage(NewMessage newMessage) {
        System.out.println("Accepted message to parse in Parser D");
        newMessage.getMessageDetails().setParsed(setParsedData());
        newMessage.getMessageDetails().setServiceId(SERVICE_ID);
        sendMessageBack(newMessage);
    }

    @Override
    String setParsedData() {
        return "Parser D in " + HANDLER_NAME;
    }
}
