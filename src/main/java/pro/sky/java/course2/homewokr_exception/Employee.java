package pro.sky.java.course2.homewokr_exception;

public class Employee {
    private final String lastName;       // Фамилия
    private final String firstName;      // Имя

    private final int hash;            // Хэш-сумма ФИО
    private final String name;         // Строка полного имени

    /**
     * Конструктор нового экземпляра класса  Полное имя (Ф.И.).
     *
     * @param lastName  // Фамилия
     * @param firstName // Имя
     */
    public Employee(String lastName, String firstName) {
        this.firstName = normalize(firstName);
        this.lastName = normalize(lastName);
        // Переменные класса неизменяемые,
        // можно сразу вычислить следующие значения.
        name = String.join(" ", this.lastName, this.firstName).trim();
        hash = name.hashCode();
    }
    /**
     * Нормализовать строку имени.
     * Значение {@code null} заменяестся на пустую строку.
     * Убираются лишние пробелы из имени.
     * Все символы, кроме первого, преобразуются в нижний регистр.
     * Первый символ имени преобразуется верхний регистр.
     *
     * @param str Исходная строка имени.
     * @return Нормализованная строка имени.
     */
    protected final String normalize(String str) {
        if (str == null || str.isEmpty()) {
            return " ";
        }
        if (str.length() == 1){
            return str.toUpperCase();
        }
        String res = str.replace(" ", "");
        return Character.toUpperCase(res.charAt(0)) + res.substring(1).toLowerCase();
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getFullName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

    /**
     * Возвращает хэш-код для полного имени (Ф.И.О.).
     * @return значение хэш-кода для этого объекта.
     */
    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Employee ){
            return hash == obj.hashCode();
        }
        return false;
    }
}
