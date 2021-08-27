package java_erp.dao;

import java.util.ArrayList;

import java_erp.dto.Department;

public interface DepartmentDao {
	ArrayList<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department department);
	
	int insertTitle(Department department);
	int updateTitle(Department department);
	int deleteTitle(Department department);
}
