package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

  String name;
  String surname;

  @Enumerated(EnumType.STRING)
  EmploymentType employmentType;

  LocalDate hireDate;

  Long branchId;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "employee_id")
  List<EmployeeSkill> skills;

}
