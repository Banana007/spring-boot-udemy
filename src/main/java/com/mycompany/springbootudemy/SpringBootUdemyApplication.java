package com.mycompany.springbootudemy;

import com.mycompany.springbootudemy.backend.persistence.domain.backend.Role;
import com.mycompany.springbootudemy.backend.persistence.domain.backend.User;
import com.mycompany.springbootudemy.backend.persistence.domain.backend.UserRole;
import com.mycompany.springbootudemy.backend.service.UserService;
import com.mycompany.springbootudemy.enums.PlansEnum;
import com.mycompany.springbootudemy.enums.RolesEnum;
import com.mycompany.springbootudemy.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mycompany.springbootudemy.backend.persistence.repositories")
public class SpringBootUdemyApplication implements CommandLineRunner {

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootUdemyApplication.class);

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUdemyApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		String username = "proUser";
		String email = "proUser@gmail.com";

		User user = UserUtils.createBasicUser(username,email);
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
		LOG.debug("1---Creating user with username {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO, userRoles);
		LOG.info("2---User {} created", user.getUsername());
	}
}
