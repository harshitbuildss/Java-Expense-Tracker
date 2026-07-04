package com.harshit.expensetracker.service;

import com.harshit.expensetracker.model.Expense;
import com.harshit.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        if (expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid amount.");
        }
        if (expense.getDate() == null) {
            expense.setDate(LocalDate.now());
        }
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void deleteExpense(int id) {
        if (!expenseRepository.existsById(id)) {
            throw new NoSuchElementException("Expense record not found.");
        }
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(int id, Expense updatedDetails) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Expense record not found."));
        
        if (updatedDetails.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid amount. Edit cancelled.");
        }

        existing.setCategory(updatedDetails.getCategory());
        existing.setAmount(updatedDetails.getAmount());
        existing.setDate(updatedDetails.getDate());
        return expenseRepository.save(existing);
    }

    public List<Expense> searchByCategory(String category) {
        return expenseRepository.findByCategoryIgnoreCase(category);
    }

    public List<Expense> getExpensesSortedByAmount() {
        List<Expense> list = expenseRepository.findAll();
        list.sort((e1, e2) -> Double.compare(e1.getAmount(), e2.getAmount()));
        return list;
    }

    public Map<String, Double> getCategorySummary() {
        return expenseRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }
    public Expense getExpenseById(int id) {
    return expenseRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Expense not found."));
    }
}