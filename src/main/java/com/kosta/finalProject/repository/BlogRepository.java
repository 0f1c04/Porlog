package com.kosta.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.BlogDTO;

public interface BlogRepository extends CrudRepository<BlogDTO, Long>, JpaRepository<BlogDTO, Long>, QuerydslPredicateExecutor<BlogDTO>{
	
}
