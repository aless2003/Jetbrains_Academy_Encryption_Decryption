package encryptdecrypt.algorithms;

import java.util.regex.Matcher;

public class Shift implements Algorithm {
    @Override
    public String encrypt(String input, int key) {
        char[] messageArr = input.toCharArray();
        for (int i = 0; i < messageArr.length; i++) {
            char x = messageArr[i];

            if (x != ' ') {
                for (int j = 0; j < key; j++) {
                    x++;
                    if (x > 'Z' && x < 'a') {
                        x = 'A';
                    } else if (x > 'z') {
                        x = 'a';
                    }
                    messageArr[i] = x;
                }
            }
        }
        return new String(messageArr);
    }

    @Override
    public String decrypt(String input, int key) {
        char[] messageArr = input.toCharArray();
        for (int i = 0; i < messageArr.length; i++) {
            char x = messageArr[i];
            if (x != ' ') {
                for (int j = 0; j < key; j++) {
                    x--;
                    if (x < 'A') {
                        x = 'Z';
                    }
                    if (x < 'a' && x > 'Z') {
                        x = 'z';
                    }
                }
            }
            messageArr[i] = x;
        }
        return new String(messageArr);
    }
}
