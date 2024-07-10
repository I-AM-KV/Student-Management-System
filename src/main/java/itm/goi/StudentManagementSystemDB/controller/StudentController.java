package itm.goi.StudentManagementSystemDB.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import itm.goi.StudentManagementSystemDB.entity.Student;
import itm.goi.StudentManagementSystemDB.service.StudentServiceImpl;
import itm.goi.StudentManagementSystemDB.service.StudentSevice;

@RestController
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	StudentSevice service;
	
	@RequestMapping(path="/student/add", method=RequestMethod.POST)
	public boolean addStudent(@RequestBody Student s) {
		logger.info("Implementation");
		return service.addStudent(s);
	}
	@RequestMapping(path="/student/get/{id}", method=RequestMethod.GET )
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	@CrossOrigin
	@RequestMapping(path="/student/getAll", method=RequestMethod.GET)
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	@RequestMapping(path="/student/updateName/{id}", method=RequestMethod.PUT)
	public Student update(@PathVariable int id, @RequestBody String name) {
		return service.updateStudentName(id, name);
	}
	@RequestMapping(path="/student/delete/{id}", method=RequestMethod.DELETE)
	public Student delete(@PathVariable int id) {
		return service.deleteStudentById(id);
	}
	@RequestMapping(path="/student/updatemarks/{id}", method=RequestMethod.PUT)
	public Student updatemarks(@PathVariable int id,@RequestBody String marks) {
		double marks1 = Double.parseDouble(marks); 
		return service.updateMarks(id, marks1);
	}
	@GetMapping("/student/getbygrade")
	public List<Object[]> getStudentCountByGrade(){
		return service.getStudentByGrade();
	}
	@RequestMapping(path="/student/updatestdbranch/{sid}", method=RequestMethod.PUT)
	public Student updatestdBranch(@PathVariable int sid, @RequestBody String bid) {
		int bbid = Integer.parseInt(bid);
		return service.addStdToBr(sid, bbid);
		
	}
	@RequestMapping(path="/student/sort", method = RequestMethod.GET)
	public List<Student> sortStudent(@Param(value = "") String property) {
		if(property.isEmpty()) {
			return service.sort();
		}
		else {
			return service.sort(property);
		}
	}
	
	}
	

