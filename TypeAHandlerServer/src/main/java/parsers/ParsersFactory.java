package parsers;

import java.util.HashMap;

public class ParsersFactory {
    private static HashMap<String, AbstractParser> factory = setUpParsersMap();

    public static AbstractParser getParser(String parserName) {
        return factory.get(parserName);
    }

    private static  HashMap<String, AbstractParser> setUpParsersMap() {
        HashMap<String, AbstractParser> parserHashMap = new HashMap<>();

        parserHashMap.put("ParserA", ParserA.getInstance());
        parserHashMap.put("ParserB", ParserB.getInstance());
        parserHashMap.put("ParserC", ParserC.getInstance());
        parserHashMap.put("ParserD", ParserD.getInstance());

        return parserHashMap;
    }

    private ParsersFactory() {

    }
}
