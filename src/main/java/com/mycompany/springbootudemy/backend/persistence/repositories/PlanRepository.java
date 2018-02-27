package com.mycompany.springbootudemy.backend.persistence.repositories;

import com.mycompany.springbootudemy.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository extends CrudRepository<Plan,Integer>{
}
