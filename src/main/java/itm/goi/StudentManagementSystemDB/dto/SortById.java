package itm.goi.StudentManagementSystemDB.dto;

import java.util.Comparator;

import itm.goi.StudentManagementSystemDB.entity.Student;

public class SortById  implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId() - o2.getId();
	}

}
