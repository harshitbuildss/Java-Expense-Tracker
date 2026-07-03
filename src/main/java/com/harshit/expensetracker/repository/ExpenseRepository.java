package com.harshit.expensetracker.repository;

import com.harshit.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    
    // SELECT * FROM expenses WHERE LOWER(category) 
    List<Expense> findByCategoryIgnoreCase(String category);
    //SELECT * FROM expnses ORDER BY amount ASC
    List<Expense> findAllByOrderByAmountAsc();
}