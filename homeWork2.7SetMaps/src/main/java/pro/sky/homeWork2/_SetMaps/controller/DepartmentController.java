package pro.sky.homeWork2._SetMaps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homeWork2._SetMaps.Employee;
import pro.sky.homeWork2._SetMaps.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee getMin(int departmentId) {
        return departmentService.getEmpWithMinSalary(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee getMax(int departmentId) {
        return departmentService.getEmpWithMaxSalary(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAll(Integer departmentId) {
        return departmentService.getEmployee(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>>getAll() {
        return departmentService.getEmployeeGroupedByDepart();
    }

}
