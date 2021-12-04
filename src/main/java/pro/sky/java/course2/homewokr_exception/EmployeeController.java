package pro.sky.java.course2.homewokr_exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * контроллер
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws ValueNotFoundException {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws ValueNotFoundException {
        return employeeService.removeEmployee(lastName, firstName);
    }
}