package by.nareiko.ih.action;


import by.nareiko.ih.composite.Component;
import by.nareiko.ih.composite.impl.TextComponent;
import by.nareiko.ih.composite.impl.Type;

import java.util.*;

public class TextAction {
    public void sortParagraphsByNumberSentences(TextComponent textComponent) {
        textComponent.getComponents().sort(Comparator.comparingInt(a -> a.getComponents().size()));
    }

    public List<TextComponent> findSentencesWithLongestWord(TextComponent textComponent) {
        int maxWordLength = -1;
        List<TextComponent> sentencesWithTheMostLongestWord = new ArrayList<>();

        List<Component> paragraphs = textComponent.getComponents();

        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();

            for (Component sentence : sentences) {
                List<Component> words = sentence.getComponents();

                for (Component word : words) {
                    if (word.getComponents().size() > maxWordLength) {

                        maxWordLength = word.getComponents().size();
                        sentencesWithTheMostLongestWord.clear();
                        sentencesWithTheMostLongestWord.add((TextComponent) sentence);
                    } else if (word.getComponents().size() == maxWordLength) {
                        sentencesWithTheMostLongestWord.add((TextComponent) sentence);
                    }
                }
            }
        }
        return sentencesWithTheMostLongestWord;
    }

    public void deleteSentencesWhereNumberOfWordsLessThanSpecifiedValue(TextComponent textComponent, int specifiedValue) {
        List<Component> paragraphs = textComponent.getComponents();

        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            sentences.removeIf(componentLambda -> componentLambda.getComponents().size() < specifiedValue);
        }
        textComponent.getComponents().removeIf(nextParagraph -> nextParagraph.getComponents().isEmpty());
    }

    public long numberOfIdenticalWords(TextComponent textComponent) {

        Map<String, Integer> identicalWordsInText = new HashMap<>();
        List<Component> paragraphs = textComponent.getComponents();

        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();

            for (Component sentence : sentences) {
                List<Component> words = sentence.getComponents();

                for (Component word : words) {
                    String strWord;

                    if (hasPunctuation((TextComponent) word)) {
                        StringBuilder builderWord = new StringBuilder();
                        for (Component textComponentBuilder : word.getComponents()) {
                            if (textComponentBuilder.getType() != Type.PUNCTUATION) {
                                builderWord.append(textComponentBuilder);
                            }
                        }
                        strWord = builderWord.toString();
                    } else {
                        strWord = word.toString();
                    }

                    if (identicalWordsInText.containsKey(strWord)) {

                        identicalWordsInText.put(strWord, identicalWordsInText.get(strWord) + 1);
                    } else {

                        identicalWordsInText.put(strWord, 1);
                    }
                }
            }
        }
        return identicalWordsInText.values().stream().filter(a -> a > 1).count();
    }

    private boolean hasPunctuation(TextComponent word) {
        return word.getComponent(word.getComponents().size() - 1).getType() == Type.PUNCTUATION;
    }
}
