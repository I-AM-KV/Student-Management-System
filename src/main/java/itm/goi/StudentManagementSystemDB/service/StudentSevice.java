package itm.goi.StudentManagementSystemDB.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import itm.goi.StudentManagementSystemDB.entity.Student;

@Service
public interface StudentSevice {

	public boolean addStudent(Student s);
	public Student getStudentById(int id);
	public Student updateMarks(int id, double marks);
	public Student deleteStudent(int id);
	public List<Student> getAllStudents();
	public List<Student> getAllStudentByGender(String gender);
	public List<Student> getStudentByName(String name);
	public Student updateStudentName(int id, String name);
	public Student deleteStudentById(int id);
	public List<Object[]> getStudentByGrade();
	public List<Student>sort();
	public List<Student> sort(String property);
	public Student addStdToBr(int id,int bid);
	
	
	
	
	
}
