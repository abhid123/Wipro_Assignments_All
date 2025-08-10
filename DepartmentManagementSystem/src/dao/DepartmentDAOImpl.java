package dao;

import model.Department;
import util.DBUtil;
import exception.DepartmentNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void addDepartment(Department dept) {
        String query = "INSERT INTO department VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, dept.getDeptId());
            ps.setString(2, dept.getDeptName());
            ps.setString(3, dept.getLocation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
        String query = "SELECT * FROM department WHERE deptId = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Department(rs.getInt("deptId"), rs.getString("deptName"), rs.getString("location"));
            } else {
                throw new DepartmentNotFoundException("Department with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DepartmentNotFoundException("Error accessing DB.");
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String query = "SELECT * FROM department";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Department(rs.getInt("deptId"), rs.getString("deptName"), rs.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateDepartment(Department dept) throws DepartmentNotFoundException {
        String query = "UPDATE department SET deptName = ?, location = ? WHERE deptId = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, dept.getDeptName());
            ps.setString(2, dept.getLocation());
            ps.setInt(3, dept.getDeptId());
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DepartmentNotFoundException("Department with ID " + dept.getDeptId() + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(int id) throws DepartmentNotFoundException {
        String query = "DELETE FROM department WHERE deptId = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DepartmentNotFoundException("Department with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
