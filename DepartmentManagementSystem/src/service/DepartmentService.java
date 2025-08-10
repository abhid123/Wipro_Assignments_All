package service;

import model.Department;
import java.util.List;
import exception.DepartmentNotFoundException;

public interface DepartmentService {
    void addDepartment(Department dept);
    Department getDepartmentById(int id) throws DepartmentNotFoundException;
    List<Department> getAllDepartments();
    void updateDepartment(Department dept) throws DepartmentNotFoundException;
    void deleteDepartment(int id) throws DepartmentNotFoundException;
}
