package com.te.homedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.homedelivery.pojo.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

}
