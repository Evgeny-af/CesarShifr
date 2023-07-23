
public class Cesar {

    private static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    // Метод для шифрования текста с использованием шифра Цезаря
    public static String encrypt(String plainText, int shift) {
        return shiftText(plainText, shift, true);
    }

    // Метод для дешифрования текста с использованием шифра Цезаря
    public static String decrypt(String cipherText, int shift) {
        return shiftText(cipherText, shift, false);
    }

    // Вспомогательный метод для сдвига символов в тексте
    private static String shiftText(String text, int shift, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                String alphabet;

                if (ENGLISH_ALPHABET.indexOf(Character.toLowerCase(ch)) != -1) {
                    alphabet = ENGLISH_ALPHABET;
                } else {
                    alphabet = RUSSIAN_ALPHABET;
                }

                int index = alphabet.indexOf(Character.toLowerCase(ch));

                if (encrypt) {
                    index = (index + shift) % alphabet.length();
                } else {
                    index = (index - shift + alphabet.length()) % alphabet.length();
                }

                char shiftedChar = Character.isUpperCase(ch) ? Character.toUpperCase(alphabet.charAt(index)) : alphabet.charAt(index);
                result.append(shiftedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
