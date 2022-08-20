package com.wsiiz.repairshop.payments.application;

import com.wsiiz.repairshop.payments.domain.bill.Bill;
import com.wsiiz.repairshop.payments.domain.bill.BillRepository;
import com.wsiiz.repairshop.payments.domain.bill.Payment;
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
@RequestMapping("/payments/bills")
public class BillController {

  @Autowired
  BillRepository billRepository;

  @GetMapping
  public ResponseEntity<List<Bill>> getMany(
      @RequestParam(value = "accountId", required = false) Long accountId) {

    return ResponseEntity.ok(
        accountId == null ?
            billRepository.findAll() :
            billRepository.findByAccountId(accountId));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Bill> getOne(@PathVariable("id") Long id) {

    Optional<Bill> bill = billRepository.findById(id);

    return bill.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Bill> addNew(@RequestBody Bill bill) {
    return ResponseEntity.created(null).body(billRepository.save(bill));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Bill> remove(@PathVariable("id") Long id) {

    Optional<Bill> bill = billRepository.findById(id);

    if (bill.isPresent()) {
      billRepository.deleteById(id);
      return ResponseEntity.ok(bill.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{id}/payments")
  public ResponseEntity<Bill> addPayment(@PathVariable("id") Long id, @RequestBody Payment payment) {

    Optional<Bill> bill = billRepository.findById(id);

    return bill
        .map(b -> {
          b.addPayment(payment);
          billRepository.save(b);
          return b;
        })
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
