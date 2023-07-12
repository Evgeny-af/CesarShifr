import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileInputOutput {
    public static void saveStringToFile(String data, String filePath) {
        try {
            Path path = Path.of(filePath);
            Files.writeString(path, data, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadStringFromFile(String filePath) {
        try {
            Path path = Path.of(filePath);
            String data = Files.readString(path, StandardCharsets.UTF_8);
            System.out.println("Данные успешно загружены из файла.");
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
