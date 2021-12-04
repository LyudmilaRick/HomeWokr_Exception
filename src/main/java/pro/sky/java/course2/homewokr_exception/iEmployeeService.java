package pro.sky.java.course2.homewokr_exception;

public interface iEmployeeService {
    String addEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName) throws ValueNotFoundException;

    String removeEmployee(String lastName, String firstName) throws ValueNotFoundException;
}
