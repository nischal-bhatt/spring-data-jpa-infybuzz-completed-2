package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.request.CreateStudentRequest;
import com.request.PersonClass;
import com.request.UpdateStudentRequest;
import com.response.StudentResponse;
import com.service.PersonService;
import com.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	PersonService personService;
	
	@Value("${app.name}")
	//@Value only works with spring managed beans
	private String appName;
	
	 @GetMapping("/getStudent")
	 public String getStudent()
	 {
		 System.out.println("after aspect stuff - look at aspect config");
		 return this.appName;
	 }
	 
	
	 
	 @GetMapping("/getAllStudentsJson")
	 public List<StudentResponse> getAllStudents()
	 {
		 logger.error("ratlam ki gali mein kyun aana haana hai?");
		 logger.warn("inside warn");
		 logger.info("inside info");
		 logger.debug("inside debug");
		 logger.trace("inside trace");
		 
		 List<StudentResponse> students = new ArrayList<StudentResponse>();
		 
		 List<Student> studentsEntities = this.studentService.getAllStudents();
		 
		 for (int i =0; i<studentsEntities.size(); i++)
		 {
			 StudentResponse res = new StudentResponse();
			 BeanUtils.copyProperties(studentsEntities.get(i), res);
			 students.add(res);
		 }
		 
		 return students;
	 }
	 
	 @PostMapping("/createStudent")
	 public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest)
	 {
		 Student student = this.studentService.createStudent(createStudentRequest);
	     StudentResponse stures = new StudentResponse();
	     BeanUtils.copyProperties(student,stures);
	     stures.setCity(student.getAddress().getCity());
	     stures.setStreet(student.getAddress().getStreet());
	     return stures;
	 }
	 
	 @PutMapping("/updateStudent")
	 public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest)
	 {
		 Student student = this.studentService.updateStudent(updateStudentRequest);
		 StudentResponse stures = new StudentResponse();
	     BeanUtils.copyProperties(student,stures);
	     return stures;
		 
	 }
	 
	 @DeleteMapping("/delete")//?id=4
	 public String deleteStudent(@RequestParam long id)
	 {
		 return this.studentService.deleteStudent(id);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public String deleteStudentPath(@PathVariable long id)
	 {
		 return studentService.deleteStudent(id);
	 }
	 
	 @GetMapping("/getByFirstName/{firstName}")
	 public List<StudentResponse> getByFirstName(@PathVariable String firstName)
	 {
		 List<Student> students = this.studentService.getByFirstName(firstName);
	     
		 
		 List<StudentResponse> studentRes = new ArrayList<>();
		 
		 for (int i =0; i<students.size(); i++)
		 {
			 StudentResponse res= new StudentResponse();
			 res.setEmail(students.get(i).getEmail());
			 res.setFirstName(students.get(i).getFirstName());
			 res.setLastName(students.get(i).getLastName());
			 res.setId(students.get(i).getId());
			 
			 studentRes.add(res);
		 }
		 
		 return studentRes;
	 }
	 
	 
	 @GetMapping("getFirstNameAndLastName/{firstName}/{lastName}")
	 public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName)
	 {
		 Student student = this.studentService.getByFirstNameAndLastName(firstName, lastName);
		 
		 StudentResponse str = new StudentResponse();
		 str.setEmail(student.getEmail());
		 str.setFirstName(student.getFirstName());
		 str.setLastName(student.getLastName());
		 str.setId(student.getId());
		 
		 return str;
	 }
	 
	 @PostMapping("savePersonWithHobbies")
	 public String savePerson(@RequestBody PersonClass person)
	 {
		// System.out.println(person);
		String x = this.personService.persistPersonWithHobbies(person);
	    return x;
	 }
}
