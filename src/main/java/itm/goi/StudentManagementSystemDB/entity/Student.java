package itm.goi.StudentManagementSystemDB.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Student implements Comparable<Student> {
	@Id
	private int id;
	private String name;
	
	
	private String gender;
	private double marks;
	private char grade;
	@ManyToOne
	private Branch branch;
	@Override
	public int compareTo(Student ob) {
		// TODO Auto-generated method stub
		return this.id - ob.id;
	}
	
}
