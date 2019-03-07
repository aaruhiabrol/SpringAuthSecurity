package com.jwt.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.security.domain.User;

//todo
@Repository
//extends CrudRepository<User,Long>
public interface UserRepository extends CrudRepository<User,Long> {

	User findByEmailIgnoreCase(String username);

	User save(User user);

}
