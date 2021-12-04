package pro.sky.java.course2.homewokr_exception;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * main
 * нужно перенести из курсовой работу с массивом сотрудников в сервис на базе веб-приложения на Spring.
 * Заменить сообщения об ошибках выбросом исключений с определенными HTTP-статусами.
 */
@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}
