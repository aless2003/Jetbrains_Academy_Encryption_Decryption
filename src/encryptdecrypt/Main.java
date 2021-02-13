package encryptdecrypt;

import encryptdecrypt.algorithms.Algorithm;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String method = "enc";
        String message = "";
        String outFile = "";
        String inFile = "";
        String algorithm = "shift";
        int key = 0;

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    method = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    message = args[i + 1];
                    break;
                case "-in":
                    inFile = args[i + 1];
                    break;
                case "-out":
                    outFile = args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
            }
        }

        if (message.isEmpty()) {
            if (!inFile.isEmpty()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inFile))) {
                    message = reader.lines().collect(Collectors.joining());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Algorithm alg = Algorithm.getAlgorithm(algorithm);
        if (method.equals("enc")) {
            message = alg.encrypt(message, key);
        } else if (method.equals("dec")) {
            message = alg.decrypt(message, key);
        }

        if (outFile.isEmpty()) {
            System.out.println(message);
        } else {
            File file = new File(outFile);

            if (!file.exists()) {
                try {
                    if (!file.createNewFile()) {
                        System.out.println("File couldn't be created");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                writer.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
