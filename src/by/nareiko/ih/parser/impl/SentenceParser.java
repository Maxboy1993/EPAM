package by.nareiko.ih.parser.impl;

import by.nareiko.ih.composite.Component;
import by.nareiko.ih.composite.impl.TextComponent;
import by.nareiko.ih.composite.impl.Type;
import by.nareiko.ih.parser.TextParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {
    private static final String SENTENCE_DELIMETER = "[\\.?!]\\s? | [\\.{3}]\\s?";
    private static  SentenceParser instance;
    private static LexemeParser wordParser;
    private Component componentParagraph;
    private Component component;

    public static SentenceParser getInstance(){
        if (instance == null){
            instance = new SentenceParser();
        }
        return instance;
    }

    @Override
        public Component parse(String value) {
        componentParagraph = new TextComponent(Type.PARAGRAPH);
        List<String> sentences = new ArrayList<>();
        Pattern patternSentence = Pattern.compile(SENTENCE_DELIMETER);
        Matcher matcherSentence = patternSentence.matcher(value);
        int indexStartingOfSentence = 0, indexEndingOfSentence;
        while (matcherSentence.find()) {
            indexEndingOfSentence = matcherSentence.end();
            String sentence = value.substring(indexStartingOfSentence, indexEndingOfSentence).trim();
            indexStartingOfSentence = indexEndingOfSentence;
            sentences.add(sentence);
        }
        for (String element : sentences){
            wordParser = LexemeParser.getInstance();
            component = wordParser.parse(element);
            componentParagraph.add(component);
        }
            return componentParagraph;
    }
}
