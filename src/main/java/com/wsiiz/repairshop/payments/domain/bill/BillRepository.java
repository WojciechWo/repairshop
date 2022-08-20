package com.wsiiz.repairshop.payments.domain.bill;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

  List<Bill> findByAccountId(Long accountId);
}
