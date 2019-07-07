package sda.cryptography.core;

import java.util.ArrayList;
import java.util.List;

public class CesarCrypt implements ICryptography {

    private static final String CHAR_SET = "abcdefghijklmnopqrstuwxyz,.?! -1234567890=+ABCDEFGHIJKLMNOPQRSTUWXYZ";
    private final char[] text;
    private final int shift;
    private final List<Character> letters;


    public CesarCrypt(String text, int shift) {
        this.text = text.toCharArray();
        this.shift = shift;
        this.letters = getLetters();
    }


    @Override
    public String encrypt() {
        return getMagicText(true);
    }


    @Override
    public String decrypt() {
        return getMagicText(false);
    }


    private List<Character> getLetters(){
        List<Character> result = new ArrayList<>();
        char[] l = CHAR_SET.toCharArray();
        for (char x : l)
            result.add(x);

        return result;
    }


    private String getMagicText(boolean encrypt) {
        char[] enc = new char[text.length];

        for (int i = 0; i < text.length; i++)
            enc[i] = getMagicChar(text[i], encrypt);

        return String.valueOf(enc);
    }


    private char getMagicChar(char c, boolean encrypt) {
        if (letters.contains(c)) {
            int currentCharIndex = getCurrentCharIndex(encrypt, letters.indexOf(c));
            return letters.get(currentCharIndex);
        } else {
            return c;
        }
    }


    private int getCurrentCharIndex(boolean encrypt, int currentCharIndex) {
        if (encrypt)
            currentCharIndex += shift;
        else
            currentCharIndex -= shift;
        currentCharIndex %= letters.size();

        if (currentCharIndex < 0)
            currentCharIndex += letters.size();

        return currentCharIndex;
    }
}
