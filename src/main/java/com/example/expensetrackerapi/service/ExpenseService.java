package com.example.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.expensetrackerapi.entity.Expense;

public interface ExpenseService {

	Page<Expense> getAllExpenses(Pageable page);

	Expense getExpenseById(Long id);

	void deleteById(Long id);

	Expense saveExpenseDEtails(Expense expense);

	Expense updateExpenseDetails(Long id, Expense expense);

	List<Expense> readyByCategory(String category, Pageable page);
	
	List<Expense> readyByName(String name, Pageable page);
	
	List<Expense> readByDateBetween(Date startDate, Date endDate, Pageable page);
}
