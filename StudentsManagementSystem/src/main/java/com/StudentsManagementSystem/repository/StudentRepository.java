package com.StudentsManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentsManagementSystem.entity.student;
@Repository
public interface StudentRepository extends JpaRepository<student, Integer>{

}
