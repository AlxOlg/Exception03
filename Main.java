package Exception03;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите [Фамилия Имя Отчество дата_рождения номер_телефона пол] через пробел:");
            String input = scanner.nextLine();
            PersonalData PersonalData = new PersonalData(input.split(" "));
            //System.out.println(data);
            Writer.writeFile(PersonalData);
        }
    }
}
