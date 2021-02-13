package encryptdecrypt.algorithms;

public class Unicode implements Algorithm {
    @Override
    public String encrypt(String input, int key) {
        char[] messageArr = input.toCharArray();

        for (int i = 0; i < messageArr.length; i++) {
            char x = messageArr[i];
            for (int j = 0; j < key; j++) {
                x++;
                messageArr[i] = x;
            }
        }
        return new String(messageArr);
    }

    @Override
    public String decrypt(String input, int key) {
        char[] messageArr = input.toCharArray();
        for (int i = 0; i < messageArr.length; i++) {
            char x = messageArr[i];

            for (int j = 0; j < key; j++) {
                x--;
            }
            messageArr[i] = x;
        }
        return new String(messageArr);
    }
}
