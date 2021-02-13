package encryptdecrypt.algorithms;

public interface Algorithm {
    public String encrypt(String input, int key);

    public String decrypt(String input, int key);

    public static Algorithm getAlgorithm(String x) {
        switch (x) {
            case "shift":
                return new Shift();
            case "unicode":
                return new Unicode();
            default:
                return new Shift();
        }
    }
}
