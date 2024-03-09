package com.example.expensetrackerapi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetrackerapi.entity.Expense;
import com.example.expensetrackerapi.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page).toList();
	}

	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable(name = "id") Long id) {
		return expenseService.getExpenseById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam(name = "id") Long id) {
		expenseService.deleteById(id);

	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpenseDEtails(expense);
	}

	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@PathVariable Long id, @RequestBody Expense expense) {
		return expenseService.updateExpenseDetails(id, expense);
	}

	@GetMapping("/expenses/category")
	public List<Expense> getExpensesByCategory(@RequestParam String category, Pageable page) {
		return expenseService.readyByCategory(category, page);
	}

	@GetMapping("/expenses/name")
	public List<Expense> getExpensesByName(@RequestParam String name, Pageable page) {
		return expenseService.readyByName(name, page);
	}

	@GetMapping("/expenses/date")
	public List<Expense> getExpensesInBetween(@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate, Pageable page) {
		return expenseService.readByDateBetween(startDate, endDate, page);
	}

}
