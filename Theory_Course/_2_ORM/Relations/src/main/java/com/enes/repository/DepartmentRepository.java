package com.enes.repository;

import com.enes.repository.entity.Department;
import com.enes.utility.MyRepositoryFactory;

public class DepartmentRepository extends MyRepositoryFactory<Department, Long> {
    public DepartmentRepository() {
        super(Department.class);
    }
}
