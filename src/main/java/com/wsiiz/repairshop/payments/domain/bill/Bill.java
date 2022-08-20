package com.wsiiz.repairshop.payments.domain.bill;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.shared.currency.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Bill extends BaseEntity {

  Long accountId;
  Long serviceId;

  BigDecimal totalNetAmount;
  BigDecimal totalGrossAmount;
  BigDecimal totalTax;

  Currency currency;

  LocalDateTime registrationTime;

  Long employeeId;

  LocalDate dueDate;

  Boolean isPaid;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "bill_id")
  List<Payment> payments;

  public Bill addPayment(Payment payment) {
    if (payments == null) {
      payments = new ArrayList<>();
    }
    payments.add(payment);
    return this;
  }
}
