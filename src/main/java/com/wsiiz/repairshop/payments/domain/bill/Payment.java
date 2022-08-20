package com.wsiiz.repairshop.payments.domain.bill;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Payment extends BaseEntity {

  BigDecimal amount;
  LocalDate bookingDate;
  LocalDateTime registrationTime;
  Long employeeId;
  String title;

}
