package ru.dinz.coding;

import ru.dinz.coding.utils.CodeDecode;
import ru.dinz.coding.utils.InputLines;
import ru.dinz.coding.utils.Mode;

public class Vernama implements CodeDecode {
    @Override
    public void encryption(Mode mode) {
        if (mode == Mode.MANUAL) {
            System.out.println("Ведите текст для шифровки");
            String text = InputLines.getText();
            System.out.println("Введите ключ для шифровки");
            String key = InputLines.getText();             enc(text, key);
        } else if (mode == Mode.AUTO) {
            System.out.println("Ведите текст для шифровки");
            String text = InputLines.getText();
            System.out.println("Введите ключ для шифровки");             String key = InputLines.autoCreateKey(text.length());             enc(text, key);
        } else {
            System.out.println("Режим выбран не корректно!");
        }
    }

    public void enc(String plainText, String key) {
        //Убедитесь, что ключ и открытый текст имеют одинаковую длину
        if (plainText.length() != key.length()) {
            System.out.println("Ключ и сообщение должны совпадать по длине");
            return;
        }
        byte[] plainTextBytes = plainText.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] encryptedText = new byte[plainTextBytes.length];
        for(int i = 0; i < plainTextBytes.length; i++){
            encryptedText[i] = (byte) (keyBytes[i] ^ plainTextBytes[i]);
        }
        System.out.printf(""" 
                Сообщение для зашифровки %s 
                Ключ для зашифровки %s 
                Расшифрованное сообщение %s 
                """, plainText, key, new String(encryptedText));
    }

    @Override
    public void decryption() {
        System.out.println("Ведите текст для расшифровки");
        String text = InputLines.getText();
        System.out.println("Введите ключ для расшифровки");
        String key = InputLines.getText();
        if (text.length() != key.length()) {
            System.out.println("Ключ и сообщение должны совпадать по длине");
            return;
        }
        byte[] cipherTextBytes = text.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] decryptedText = new byte[cipherTextBytes.length];
        for(int i = 0; i < cipherTextBytes.length; i++){
            decryptedText[i] = (byte) (keyBytes[i] ^ cipherTextBytes[i]);
        }
        System.out.printf(""" 
                Сообщение для расшифровки %s 
                Ключ для расшифровки %s 
                Расшифрованное сообщение %s 
                """, text, key, new String(decryptedText));
    }
}
