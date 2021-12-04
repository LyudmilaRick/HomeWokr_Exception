package pro.sky.java.course2.homewokr_exception;

import org.springframework.stereotype.Service;

/**
 * имплементация
 */
@Service
public class EmployeeServiceImpl implements iEmployeeService {
    // Массив, выполняющий роль хранилища для записей о сотрудниках.
    private final Employee[] employees = new Employee[5];

    public EmployeeServiceImpl() {
        employees[0] = new Employee("Ivanov", "Ivan");
        employees[1] = new Employee("Guuchat", "Diego");
        employees[2] = new Employee("Schild", "Herbert");
        employees[3] = new Employee("Schneier", "Bruce");
        employees[4] = new Employee("Fowler", "Martin");

    }

    /**
     * метод добавления сотрудника
     * @param lastName
     * @param firstName
     * @return строку как итог успешного добавления
     */
    public String addEmployee(String lastName, String firstName) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(lastName, firstName);
                return "<i  style=\"color:#0000FF\"> Сотрудник " + employees[i].getFullName() + " успешно создан<i>";
            }
        }
        throw new ArrayOverflowException();
    }

    /**
     * поиск сотрудника по имени и фвмилии
     * @param lastName
     * @param firstName
     * @return должен вернуться объект !!! ( согласно ДЗ )
     * @throws ValueNotFoundException
     */
    public Employee findEmployee(String lastName, String firstName) throws ValueNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        int index = searchRecord(employee);
        return employees[index];
    }

    /**
     *
     * @param fullName
     * @return индекс в массиве
     * @throws ValueNotFoundException если такой сотрудник отсутствует
     */
    private int searchRecord(Employee fullName) throws ValueNotFoundException {
        //поиск по индексу
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName.getFullName())) {
                return i;
            }
        }
        throw new ValueNotFoundException();
    }

    /**
     *
     * @param lastName
     * @param firstName
     * @return строка сообщения об удаление
     * @throws ValueNotFoundException если такой сотрудник отсутствует
     */
    public String removeEmployee(String lastName, String firstName) throws ValueNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        int index = searchRecord(employee);
        String name = employees[index].getFullName();
        employees[index] = null;
        return "<i  style=\"color:#0000FF\"> Сотрудник " + name + " удален<i>";
    }
}