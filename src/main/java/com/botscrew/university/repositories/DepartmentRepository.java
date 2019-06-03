package com.botscrew.university.repositories;

import com.botscrew.university.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {
    Department findByNameIgnoreCase(String departmentName);
}
