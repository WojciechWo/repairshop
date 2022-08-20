package com.wsiiz.repairshop.enterprise.domain.employee;


import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkill extends BaseEntity {

  Long skillId;

}
