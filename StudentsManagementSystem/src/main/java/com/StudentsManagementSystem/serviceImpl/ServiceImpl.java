package com.StudentsManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentsManagementSystem.entity.student;
import com.StudentsManagementSystem.service.StudentService;
@Service
public class ServiceImpl implements StudentService {
	@Autowired		
	com.StudentsManagementSystem.repository.StudentRepository StudentRepository;

	@Override
	public List<student> getAllStudents() {
		// TODO Auto-generated method stub
		List<student> list=StudentRepository.findAll();
		 return list;
	}
	
	@Override
	public student  saveStudent(student student) {
		return StudentRepository.save(student);
	}

	@Override
	public student getById(int id) {

		return StudentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		StudentRepository.deleteById(id);
		
	}

}
