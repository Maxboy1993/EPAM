package by.nareiko.ih.parser.impl;

import by.nareiko.ih.composite.Component;
import by.nareiko.ih.composite.impl.TextComponent;
import by.nareiko.ih.composite.impl.Leaf;
import by.nareiko.ih.composite.impl.Type;
import by.nareiko.ih.parser.TextParser;

import java.util.regex.Pattern;

public class SymbolParser implements TextParser {
    private static final String LETTER_REGEX = "";
    private static final String PUNCTUATION_REGEX = "\\.{3}|[\\.,?!]";
    private static SymbolParser instance;
    private Component componentLexeme;
    private Component component;

    public static SymbolParser getInstance(){
        if (instance == null){
            instance = new SymbolParser();
        }
        return instance;
    }

    @Override
    public Component parse(String value) {
        componentLexeme = new TextComponent(Type.LEXEME);
        String[] symbols = value.split(LETTER_REGEX);
        for (String element : symbols){
            if (Pattern.matches(PUNCTUATION_REGEX, element)){
                component = new Leaf(element, Type.PUNCTUATION);
            }else {
                component = new Leaf(element, Type.LETTER);
            }
            componentLexeme.add(component);
        }
        return componentLexeme;
    }
}
