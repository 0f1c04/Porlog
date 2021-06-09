package com.kosta.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, String>, JpaRepository<UserDTO, String>{

}
