package pro.sky.homeWork2._SetMaps.service;

import pro.sky.homeWork2._SetMaps.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add (String firstName, String lastName);

    Employee remove (String firstName, String lastName);

    Employee find (String firstName, String lastName);

    Collection<Employee> findAll();
}
