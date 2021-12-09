package pro.sky.java.course2.homewokr_exception;

import org.springframework.stereotype.Service;

/**
 * имплементация
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
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
     *
     * @param lastName
     * @param firstName
     * @return строку как итог успешного добавления
     */
    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return employees[i];
            }
        }
        throw new ArrayOverflowException("Department is full");
    }

    /**
     * поиск сотрудника по имени и фвмилии
     *
     * @param lastName
     * @param firstName
     * @return должен вернуться объект !!! ( согласно ДЗ )
     * @throws EmployeeNotFoundException
     */
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int index = searchRecord(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException("Employee not found...today");
        } else {
            return employee;
        }
    }

    /**
     * @param fullName
     * @return индекс в массиве
     * @throws EmployeeNotFoundException если такой сотрудник отсутствует
     */
    private int searchRecord(Employee fullName) throws EmployeeNotFoundException {
        //поиск по индексу
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName.getFullName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param lastName
     * @param firstName
     * @return строка сообщения об удаление
     * @throws EmployeeNotFoundException если такой сотрудник отсутствует
     */
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int index = searchRecord(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException("Employee not found for deleting");
        } else {
            employees[index] = null;
            return employee;
        }
    }
}