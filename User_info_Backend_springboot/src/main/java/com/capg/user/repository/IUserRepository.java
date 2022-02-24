package com.capg.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.user.bean.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

}
