package ru.dinz.coding;

import ru.dinz.coding.utils.CodeDecode;
import ru.dinz.coding.utils.InputLines;
import ru.dinz.coding.utils.Mode;

public class Vijiner implements CodeDecode {

    @Override
    public void encryption(Mode mode) {
        if (mode == Mode.MANUAL) {
            System.out.println("Введите текст для зашифрования");
            String msg = InputLines.getText();
            System.out.println("Введите ключ для зашифровки");
            String key = InputLines.getText();
            enc(msg, key);
        } else if (mode == Mode.AUTO) {
            System.out.println("Введите текст для зашифрования");
            String msg = InputLines.getText();
            System.out.println("Введите ключ для зашифровки");
            String key = InputLines.autoCreateKey(msg.length());
            enc(msg, key);
        } else {
            System.out.println("Режим выбран некорректно!");
        }
    }

    public static void enc(String plaintext, String key) {
        String encryptedText = "";
        for (int i = 0, j = 0; i < plaintext.length(); i++, j++) {
            if (j == key.length()) {                 j = 0;             }
            encryptedText += plaintext.charAt(i) == ' ' ? ' ' : (char)
                    ((plaintext.charAt(i) + key.charAt(j) - 130) % 26 + 65);         }
        System.out.printf(""" 
                Сообщение для зашифровки %s 
                Ключ для зашифровки %s 
                Защифрованное сообщение %s 
                """, plaintext, key, encryptedText);
    }

    @Override
    public void decryption() {
        System.out.println("Введите текст для расшифрования");
        String plaintext = InputLines.getText();
        System.out.println("Введите ключ для расшифровки");
        String key = InputLines.getText();         String encryptedText = "";
        for (int i = 0, j = 0; i < plaintext.length(); i++, j++) {
            if (j == key.length()) {
                j = 0;
            }
            encryptedText += plaintext.charAt(i) == ' ' ? ' ' : (char)
                    ((plaintext.charAt(i) - key.charAt(j) + 130) % 26 + 65);
        }
        System.out.printf(""" 
                Сообщение для расшифровки %s 
                Ключ для расшифровки %s 
                Расшифрованное сообщение %s 
                """, plaintext, key, encryptedText);
    }
}
