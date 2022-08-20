package com.wsiiz.repairshop.enterprise.domain.branch;

import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {

  String country;
  String town;
  String street;
  String apartmentNo;
  String postalCode;
}
