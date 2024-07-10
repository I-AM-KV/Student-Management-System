package itm.goi.StudentManagementSystemDB.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import itm.goi.StudentManagementSystemDB.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value="select grade, count(*) from student group by(grade)", nativeQuery = true)
	public List<Object[]> groupByGrade();

	@Query(value="select * from student where name=?1", nativeQuery = true)
	List<Student> getStudentByName(String name);
	
	

}
