package com.example.expensetrackerapi.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expensetrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	Page<Expense>findByCategory(String category, Pageable page);
	
	Page<Expense>findByNameContaining(String keyword,Pageable page);
	
	Page<Expense> findByDateBetween(Date startDate, Date endDate,Pageable page);
}
