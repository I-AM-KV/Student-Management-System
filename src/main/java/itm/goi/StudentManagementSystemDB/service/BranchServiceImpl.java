package itm.goi.StudentManagementSystemDB.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itm.goi.StudentManagementSystemDB.entity.Branch;

import itm.goi.StudentManagementSystemDB.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {

	
	@Autowired
	BranchRepository qrepository;
	
	@Override
	public boolean addBranch(Branch b) {
		Optional<Branch> br = qrepository.findById(b.getBid());
		if(br.isPresent()) {
			return false;
			
		}
		qrepository.save(b);
		return true;
	}

	@Override
	public Branch getBranchById(int id) {
		Optional<Branch> br = qrepository.findById(id);
		if(br.isPresent()) {
			return br.get();
			
		}
		return null;
		
	}

	@Override
	public Branch deleteBranchById(int id) {
		Optional<Branch> br = qrepository.findById(id);
		if(br.isPresent()) {
			qrepository.deleteById(id);
			return br.get();
			
		}
		return null;
	}

	@Override
	public List<Branch> getall() {
		
		return qrepository.findAll();
	}

}
