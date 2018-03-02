package com.mycompany.springbootudemy.test.integration;

import com.mycompany.springbootudemy.SpringBootUdemyApplication;
import com.mycompany.springbootudemy.backend.persistence.domain.backend.Role;
import com.mycompany.springbootudemy.backend.persistence.domain.backend.User;
import com.mycompany.springbootudemy.backend.persistence.domain.backend.UserRole;
import com.mycompany.springbootudemy.backend.service.UserService;
import com.mycompany.springbootudemy.enums.PlansEnum;
import com.mycompany.springbootudemy.enums.RolesEnum;
import com.mycompany.springbootudemy.utils.UsersUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootUdemyApplication.class)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateNewUser() throws Exception {

        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UsersUtils.createBasicUser();
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

    }
}
