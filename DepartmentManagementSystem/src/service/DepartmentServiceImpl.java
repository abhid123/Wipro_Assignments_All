package service;

import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import model.Department;
import exception.DepartmentNotFoundException;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDAO dao = new DepartmentDAOImpl();

    @Override
    public void addDepartment(Department dept) {
        dao.addDepartment(dept);
    }

    @Override
    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
        return dao.getDepartmentById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }

    @Override
    public void updateDepartment(Department dept) throws DepartmentNotFoundException {
        dao.updateDepartment(dept);
    }

    @Override
    public void deleteDepartment(int id) throws DepartmentNotFoundException {
        dao.deleteDepartment(id);
    }
}
