package com.gotprint.nms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gotprint.nms.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
