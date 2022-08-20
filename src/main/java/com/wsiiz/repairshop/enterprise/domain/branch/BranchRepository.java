package com.wsiiz.repairshop.enterprise.domain.branch;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BranchRepository extends JpaRepository<Branch, Long> {

  @Query("select b from Branch b where (:parentBranchId = null or b.parentBranchId = :parentBranchId) and (:town = null or b.address.town = :town)")
  List<Branch> findByCriteria(@Param("parentBranchId") Long parentBranchId, @Param("town") String town);

}
