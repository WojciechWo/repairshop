package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Branch extends BaseEntity {

  Long parentBranchId;

  String name;

  Address address;

  @Enumerated(EnumType.STRING)
  ActivityType activityType;

}
