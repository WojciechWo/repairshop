package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise/branches")
public class BranchController {

  @Autowired
  BranchRepository branchRepository;

  @GetMapping
  public ResponseEntity<List<Branch>> getMany(
      @RequestParam(value = "parentBranchId", required = false) Long parentBranchId,
      @RequestParam(value = "town", required = false) String town) {

    return ResponseEntity.ok(branchRepository.findByCriteria(parentBranchId, town));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Branch> getOne(@PathVariable("id") Long id) {

    Optional<Branch> branch = branchRepository.findById(id);

    return branch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Branch> addNew(@RequestBody Branch branch) {
    return ResponseEntity.created(null).body(branchRepository.save(branch));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Branch> remove(@PathVariable("id") Long id) {

    Optional<Branch> branch = branchRepository.findById(id);

    if (branch.isPresent()) {
      branchRepository.deleteById(id);
      return ResponseEntity.ok(branch.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
