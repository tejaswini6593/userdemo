package com.UserCrud.User.repository;

import com.UserCrud.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
//    void delete(Long id);
}
