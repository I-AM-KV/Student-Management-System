package itm.goi.StudentManagementSystemDB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import itm.goi.StudentManagementSystemDB.entity.Branch;

@Service
public interface BranchService {

	public boolean addBranch(Branch b);
	public Branch getBranchById(int id);
	public Branch deleteBranchById(int id);
	public List<Branch> getall();
}
