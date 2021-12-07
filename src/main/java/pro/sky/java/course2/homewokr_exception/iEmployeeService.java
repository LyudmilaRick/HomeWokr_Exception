package pro.sky.java.course2.homewokr_exception;

    public interface IEmployeeService {

        Employee addEmployee(String lastName, String firstName);

        Employee findEmployee(String lastName, String firstName);

        Employee removeEmployee(String lastName, String firstName);
}
