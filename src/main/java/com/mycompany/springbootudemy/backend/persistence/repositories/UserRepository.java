package com.mycompany.springbootudemy.backend.persistence.repositories;

import com.mycompany.springbootudemy.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
}
