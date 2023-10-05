package Exception03;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void writeFile(PersonalData data) {
        try (FileWriter fileWriter = new FileWriter(data.getSurname() + ".txt", true)) {
            fileWriter.write(data.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи файла.");
            throw new RuntimeException(e.getMessage());
        }
    }
}
