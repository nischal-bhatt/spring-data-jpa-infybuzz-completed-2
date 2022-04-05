package com.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.entity.Address;
import com.entity.Student;
import com.repository.AddressRepository;
import com.repository.StudentRepository;
import com.request.CreateStudentRequest;
import com.request.UpdateStudentRequest;



@Service
public class StudentService {

	@Autowired
	AddressRepository addressRepository;
	
	 @Autowired
	 StudentRepository studentRepository;
	 
	 public List<Student> getAllStudents()
	 {
		 Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
		 List<Student> students = studentRepository.findAll(sort);
	     return students;
	 }
	 
	 public Student createStudent(CreateStudentRequest createStudentRequest)
	 {
		 Student student = new Student();
		 student.setAddress(new Address());
		 BeanUtils.copyProperties(createStudentRequest, student);
		 student.getAddress().setCity(createStudentRequest.getCity());
		 student.getAddress().setStreet(createStudentRequest.getStreet());
		 Student stu = this.studentRepository.save(student);
	     return stu; 
	 }
	 
	 public Student updateStudent(UpdateStudentRequest updateStudentRequest)
	 {
		Student student= studentRepository.findById(updateStudentRequest.getId()).get();
	     
		if (student == null) throw new RuntimeException("student not found");
		
		student.setId(updateStudentRequest.getId());
		student.setEmail(updateStudentRequest.getEmail());
		student.setFirstName(updateStudentRequest.getFirstName());
		student.setLastName(updateStudentRequest.getLastName());
		
		Student studentreturn = this.studentRepository.save(student);
	    return studentreturn;
	 }
	 
	 
	 public String deleteStudent(long id)
	 {
		
		 studentRepository.deleteById(id);
		 
		 
		 return "Student has been deleted successfully";
	 }
	 
	 public List<Student> getByFirstName(String firstName)
	 {
		 List<Student> students= studentRepository.findByFirstName(firstName);
		 
		 if (students != null)
		 {
			 return students;
		 }else
		 {
			 throw new RuntimeException("no student found with this name");
		 }
		 
	 }
	 
	 public Student getByFirstNameAndLastName (String firstName,String lastName)
	 {
		 return this.studentRepository.findByFirstNameAndLastName(firstName, lastName);
	 }
}
