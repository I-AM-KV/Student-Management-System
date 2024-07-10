package itm.goi.StudentManagementSystemDB.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import itm.goi.StudentManagementSystemDB.dto.CountOfGrade;
import itm.goi.StudentManagementSystemDB.dto.StudentBranchIds;
import itm.goi.StudentManagementSystemDB.entity.Branch;
import itm.goi.StudentManagementSystemDB.entity.Student;
import itm.goi.StudentManagementSystemDB.repository.BranchRepository;
import itm.goi.StudentManagementSystemDB.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentSevice {

	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	StudentRepository repository;
	@Autowired
	BranchRepository brrepository;
	@Override
	public boolean addStudent(Student s) {
		logger.info("add student api");
		Optional<Student> std = repository.findById(s.getId());
		if(std.isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"student with id "+s.getId()+ "not found");
		}
		repository.save(s);
		return true;
	}

	@Override
	public Student getStudentById(int id) {
		logger.info("getStudentById api");
		Optional<Student> std = repository.findById(id);
		if(std.isPresent()) {
			return std.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student with id "+id+ "not found");
	}
	
	public List<Student> getStudentsByName(String name) {
		
		return null;
	}

	@Override
	public Student updateMarks(int id, double marks) {
		Optional<Student> std = repository.findById(id);
		if(std.isPresent()) {
			Student s = std.get();
			s.setMarks(marks);
			repository.save(s);
			return std.get();
		}
	
		return null;
		
		
	}

	@Override
	public Student deleteStudent(int id) {
		logger.info("deleteStudent api");
		Optional<Student> std = repository.findById(id);
		if(std.isPresent()) {
			repository.deleteById(id);
			return std.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		logger.info("getAllStudents api");
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Student> getAllStudentByGender(String gender) {
		
		return null;
	}

	@Override
	public Student updateStudentName(int id, String name) {
		Optional<Student> std = repository.findById(id);
		if(std.isPresent()) {
			Student s = std.get();
			s.setName(name);
			repository.save(s);
			return std.get();
		}
	
		return null;
	}

	@Override
	public Student deleteStudentById(int id) {
		logger.info("deleteStudent api");
		Optional<Student> std = repository.findById(id);
		if(std.isPresent()) {
			repository.deleteById(id);
			return std.get();
		}
		return null;
	
		
	}

	@Override
	public List<Student> getStudentByName(String name) {
		return repository.getStudentByName(name);
	}

	@Override
	public List<Object[]> getStudentByGrade() {
		logger.info("getStudentByGrade api");
		List<Object[]> obj = repository.groupByGrade();
		List<CountOfGrade> list = new ArrayList();
		
		for(Object[] ob:obj) {
			Character c = (Character) ob[0];
			Long i = (Long) ob[1];
			list.add(new CountOfGrade(c,i));
		}
		return obj;
	}

	@Override
	public List<Student> sort() {
		logger.info("sort student api");
		List<Student> students = repository.findAll();
		Collections.sort(students);
				return students;
	}

	@Override
	public List<Student> sort(String property) {
		logger.info("sortThroughPropert student api");
		List<Student> students = repository.findAll();
		if(property.equals("id")) {
			
			Comparator<Student> sortById = new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o1.getId() - o2.getId();
				}
				
			};
			
			Collections.sort(students, sortById);
			
		}else if(property.equals("gender")) {
			
		}else if(property.equals("marks")) {
			
		}else if(property.equals("name")) {
			
		}else if(property.equals("grade")) {
			
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "property invalid");
		}
		return students;
	}

	@Override
	public Student addStdToBr(int id, int bid) {
		Optional<Student> std =repository.findById(id);
		if(!std.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"property invalid");
		}
		Student s= std.get();
		Optional<Branch> br =brrepository.findById(bid);
		if(!br.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"property invalid");
		}
		
		if(s.getBranch() instanceof Branch) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Student already has branch");
			
		}
	
		s.setBranch(br.get());
		repository.save(s);
		throw new ResponseStatusException(HttpStatus.ACCEPTED,"asssigned branch to student");
	}
	

}
