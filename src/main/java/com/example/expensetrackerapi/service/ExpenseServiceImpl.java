package com.example.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.expensetrackerapi.entity.Expense;
import com.example.expensetrackerapi.exceptions.ResourceNotFoundException;
import com.example.expensetrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
//	@Autowired
//	private UserService userService;

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepository.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {

		Optional<Expense> expense = expenseRepository.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Expense id is not present " + id);
	}

	@Override
	public void deleteById(Long id) {
       
		Expense expense = getExpenseById(id);
		expenseRepository.delete(expense);
	}

	@Override
	public Expense saveExpenseDEtails(Expense expense) {
//         expense.setUser(userService.getLoggedInUser());
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense = getExpenseById(id);

		if (expense.getName() != null) {
			existingExpense.setName(expense.getName());
		}

		if (expense.getCategory() != null) {
			existingExpense.setCategory(expense.getCategory());
		}

		if (expense.getDescription() != null) {
			existingExpense.setDescription(expense.getDescription());
		}

		if (expense.getDate() != null) {
			existingExpense.setDate(expense.getDate());
		}

		if (expense.getAmount() != null) {
			existingExpense.setAmount(expense.getAmount());
		}
		return saveExpenseDEtails(existingExpense);
	}

	@Override
	public List<Expense> readyByCategory(String category, Pageable page) {

		return expenseRepository.findByCategory(category, page).toList();
	}

	@Override
	public List<Expense> readyByName(String name, Pageable page) {
		return expenseRepository.findByNameContaining(name, page).toList();
	}

	@Override
	public List<Expense> readByDateBetween(Date startDate, Date endDate, Pageable page) {

		if(startDate == null) {
			startDate = new Date(0);
		}
		
		if(endDate == null) {
			endDate = new Date(System.currentTimeMillis());
		}
		return expenseRepository.findByDateBetween(startDate, endDate, page).toList();
	}

}
