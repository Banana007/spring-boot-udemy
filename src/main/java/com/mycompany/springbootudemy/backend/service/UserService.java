package com.mycompany.springbootudemy.backend.service;

import com.mycompany.springbootudemy.backend.persistence.domain.backend.Plan;
import com.mycompany.springbootudemy.backend.persistence.domain.backend.User;
import com.mycompany.springbootudemy.backend.persistence.domain.backend.UserRole;
import com.mycompany.springbootudemy.backend.persistence.repositories.PlanRepository;
import com.mycompany.springbootudemy.backend.persistence.repositories.RoleRepository;
import com.mycompany.springbootudemy.backend.persistence.repositories.UserRepository;
import com.mycompany.springbootudemy.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {

        Plan plan = new Plan(plansEnum);
        // It makes sure the plans exist in the database
        if (!planRepository.exists(plansEnum.getId())) {
            plan = planRepository.save(plan);
        }

        user.setPlan(plan);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);

        user = userRepository.save(user);

        return user;

    }
}
