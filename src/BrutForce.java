
public class BrutForce {

    // Метод для дешифровки текста с использованием шифра Цезаря
    public static String decrypt(String cipherText) {
        StringBuilder decryptedText = new StringBuilder();

        for (int shift = 0; shift < 26; shift++) {
            decryptedText.setLength(0); // Очистка предыдущего расшифрованного текста

            for (int i = 0; i < cipherText.length(); i++) {
                char ch = cipherText.charAt(i);

                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    char decryptedChar = (char) ((ch - base - shift + 26) % 26 + base);
                    decryptedText.append(decryptedChar);
                } else {
                    decryptedText.append(ch);
                }
            }

            if (decryptedText.indexOf(" ") != -1) {
                // Найден пробел, считаем текст расшифрованным
                break;
            }
        }

        return decryptedText.toString();
    }

}
