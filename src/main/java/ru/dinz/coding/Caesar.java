package ru.dinz.coding;

import ru.dinz.coding.utils.CodeDecode;
import ru.dinz.coding.utils.InputLines;
import ru.dinz.coding.utils.Mode;

import java.util.Random;

public class Caesar implements CodeDecode {

    private static final Random random = new Random();

    @Override
    public void encryption(Mode mode) {
        System.out.println("Введите текст для шифрования");
        String line = InputLines.getText();         if (mode == Mode.MANUAL) {
            int offsetManual = InputLines.returnInt();             String message = crypt(line, offsetManual);
            System.out.printf(""" 
                ШИФРОВАНИЕ В РУЧНОМ РЕЖИМЕ 
                Ваше сообщение: %s 
                Зашифрованное сообщение: %s 
                Ключ: %d 
                %n""", line, message, offsetManual);
        } else if (mode == Mode.AUTO) {
            int offsetManual2 = random.nextInt(25);             String messageNew = crypt(line, offsetManual2);
            System.out.printf(""" 
                ШИФРОВАНИЕ В АВТОМАТИЧЕСКОМ РЕЖИМЕ 
                Ваше сообщение: %s 
                Зашифрованное сообщение: %s 
                Ключ: %d 
                %n""", line, messageNew, offsetManual2);
        } else {
            System.out.println("Режим выбран некорректно!");
        }
    }

    @Override
    public void decryption() {
        System.out.println("Введите текст для расшифрования");
        String line = InputLines.getText();
        System.out.println("Введите ключ для расшифровки");         int key = InputLines.returnInt();
        System.out.printf(""" 
                Ваше закодированное сообщение: %s 
                Расшифрованное сообщение: %s 
                Ключ: %d 
                %n""", line, crypt(line, 26 - (key % 26)), key);
    }

    public String crypt(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);                 result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
