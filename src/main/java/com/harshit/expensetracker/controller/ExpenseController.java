package com.harshit.expensetracker.controller;

import com.harshit.expensetracker.model.Expense;
import com.harshit.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense created = expenseService.addExpense(expense);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable int id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> editExpense(@PathVariable int id, @RequestBody Expense updatedDetails) {
        return ResponseEntity.ok(expenseService.updateExpense(id, updatedDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense removed successfully.");
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Double>> viewCategorySummary() {
        return ResponseEntity.ok(expenseService.getCategorySummary());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Expense>> filterByCategory(@RequestParam String category) {
        return ResponseEntity.ok(expenseService.searchByCategory(category));
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Expense>> viewSortedExpenses() {
        return ResponseEntity.ok(expenseService.getExpensesSortedByAmount());
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
}