package com.wsiiz.repairshop.payments.domain.account;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.shared.currency.Currency;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Account extends BaseEntity {

  Long customerId;

  String accountNo;

  BigDecimal balance;

  @Enumerated(EnumType.STRING)
  Currency currency;

  LocalDateTime registrationTime;

}
