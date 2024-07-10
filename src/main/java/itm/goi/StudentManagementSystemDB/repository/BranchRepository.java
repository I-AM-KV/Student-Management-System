package itm.goi.StudentManagementSystemDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itm.goi.StudentManagementSystemDB.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
