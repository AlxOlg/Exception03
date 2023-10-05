package Exception03;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonalData {

    private String surname;
    private String name;
    private String patronymic;
    private String dateOfBirth;
    private String phoneNumber;
    private String sex;

    // Конструктор.
    public PersonalData(String[] input) {

        if (input.length < 6) {
            throw new InvalidAmountElementsException("Ошибка: Количество введенных элементов менее 6.");
        }
        if (input.length > 6) {
            throw new InvalidAmountElementsException("Ошибка: Количество введенных элементов более 6.");
        }

        try {
            this.surname = parseName(input[0]);
            this.name = parseName(input[1]);
            this.patronymic = parseName(input[2]);
            this.dateOfBirth = parseDate(input[3]);
            this.phoneNumber = parsePhoneNumber(input[4]);
            this.sex = parseSex(input[5]);
        } catch (InvalidInputNameException e) {
            throw e;
        } catch (InvalidPhoneNumberException e) {
            throw e;
        } catch (InvalidSexException e) {
            throw e;
        }
    }

    // Парсинг имени.
    private String parseName(String name) throws InvalidInputNameException {
        // Допустимы только русские или только английские буквы.
        if (name.matches("[a-zA-Z]+") | name.matches("[а-яёА-ЯЁ]+")) {
            // Возвращает имя с большой буквы.
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        } else {
            throw new InvalidInputNameException("Недопустимое имя.");
        }
    }

    // Парсинг даты.
    private String parseDate(String dateStr) {
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
        date.setLenient(false);
        try {
           date.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Дата не соответствует формату dd.MM.yyyy.");
        }
        return dateStr;
    }

    // Парсинг номера телефона.
    private String parsePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber.length() < 4) {
            throw new InvalidPhoneNumberException("Ошибка: Номер телефона менее 4 символов.");
        } else if (phoneNumber.length() > 14) {
            throw new InvalidPhoneNumberException("Ошибка: Номер телефона более 14 символов.");
        } else if (!phoneNumber.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Ошибка: Недопустимые символы в номере телефона.");
        } else {
        // Можно добавить еще условия.
            return phoneNumber;
        }
    }

    // Парсинг пола.
    private String parseSex(String sex) throws InvalidSexException {
        if (sex.equals("m") | sex.equals("f")) {
            return sex;
        } else {
            throw new InvalidSexException("Пол не соответствует формату m или f");
        }
    }

    // Геттер фамилии.
    public String getSurname() {
        return this.surname;
    }

    // toString.
    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>",
            this.surname, this.name, this.patronymic, this.dateOfBirth, this.phoneNumber, this.sex);
    }
}
