package com.harshit.expensetracker.controller;

import com.harshit.expensetracker.dto.DashboardSummaryDto;
import com.harshit.expensetracker.model.Expense;
import com.harshit.expensetracker.model.TransactionType;
import com.harshit.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Create an expense. Existing clients that don't send "type" keep working exactly as before.
    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) {
        Expense created = expenseService.addExpense(expense);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Create an income entry.
    @PostMapping("/income")
    public ResponseEntity<Expense> createIncome(@Valid @RequestBody Expense income) {
        Expense created = expenseService.addIncome(income);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable int id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> editExpense(@PathVariable int id, @Valid @RequestBody Expense updatedDetails) {
        return ResponseEntity.ok(expenseService.updateExpense(id, updatedDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense removed successfully.");
    }

    // Category-wise EXPENSE totals only (unchanged from before income support existed).
    @GetMapping("/summary")
    public ResponseEntity<Map<String, Double>> viewCategorySummary() {
        return ResponseEntity.ok(expenseService.getCategorySummary());
    }

    // Full dashboard stats: totals, balance, savings, averages, category + monthly breakdowns.
    @GetMapping("/dashboard")
    public ResponseEntity<DashboardSummaryDto> viewDashboard() {
        return ResponseEntity.ok(expenseService.getDashboardSummary());
    }

    // category alone behaves exactly like the old endpoint; type/keyword are optional additions.
    @GetMapping("/search")
    public ResponseEntity<List<Expense>> searchTransactions(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) TransactionType type,
            @RequestParam(required = false) String keyword) {
        return ResponseEntity.ok(expenseService.searchTransactions(category, type, keyword));
    }

    // Defaults (by=amount, order=asc) reproduce the old /sorted behavior exactly.
    @GetMapping("/sorted")
    public ResponseEntity<List<Expense>> viewSortedExpenses(
            @RequestParam(defaultValue = "amount") String by,
            @RequestParam(defaultValue = "asc") String order) {
        return ResponseEntity.ok(expenseService.getSortedTransactions(by, order));
    }

    // Get all transactions. With no query params this returns everything, same as before.
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam(required = false) TransactionType type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok(
                expenseService.getTransactions(type, category, keyword, startDate, endDate, sortBy, order));
    }
}
