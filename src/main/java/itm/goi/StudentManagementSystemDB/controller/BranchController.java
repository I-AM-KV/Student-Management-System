package itm.goi.StudentManagementSystemDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import itm.goi.StudentManagementSystemDB.entity.Branch;
import itm.goi.StudentManagementSystemDB.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	BranchService branchservice;
	
	@RequestMapping(path="/branch/add", method=RequestMethod.POST)
	public boolean addBranch(@RequestBody Branch b) {
	return branchservice.addBranch(b);
}
	@RequestMapping(path="/branch/get/{id}", method=RequestMethod.GET)
	public Branch getBranchById(@PathVariable int id) {
		return branchservice.getBranchById(id);
	}
	@RequestMapping(path="/branch/delete/{id}", method=RequestMethod.DELETE)
	public Branch deleteBranch(@PathVariable int id) {
		return branchservice.deleteBranchById(id);
	}
	
	@RequestMapping(path="/branch/getall", method=RequestMethod.GET)
	public List<Branch> getBranchById() {
		return branchservice.getall();
	}
	
}