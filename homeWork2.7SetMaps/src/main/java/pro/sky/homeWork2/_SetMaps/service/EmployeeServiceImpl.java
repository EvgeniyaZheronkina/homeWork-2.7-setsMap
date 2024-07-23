package pro.sky.homeWork2._SetMaps.service;

import org.springframework.stereotype.Service;
import pro.sky.homeWork2._SetMaps.Employee;
import pro.sky.homeWork2._SetMaps.exception.EmployeeAlreadyAddedException;
import pro.sky.homeWork2._SetMaps.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map <String, Employee> employees;
    private static final int STORAGE_SIZE = 5;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в коллекции");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в коллекции");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException ("Такого сотрудника нет в коллекции");
    }

    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableCollection(employees.values());
    }
}

