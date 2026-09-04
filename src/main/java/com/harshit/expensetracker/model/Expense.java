package com.harshit.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Category is required")
    @Column(name = "category", nullable = false)
    private String category;

    @Positive(message = "Amount must be greater than zero")
    @Column(name = "amount", nullable = false)
    private double amount;

    // Not annotated @NotNull on purpose: the service defaults this to today
    // when a client omits it, so bean validation must not reject it first.
    @Column(name = "expense_date", nullable = false)
    private LocalDate date;

    // Optional free-text note, e.g. "Swiggy order" or "September salary"
    @Column(name = "description")
    private String description;

    // EXPENSE or INCOME. Column default keeps existing rows valid as EXPENSE
    // once this column is added to an already-populated table.
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'EXPENSE'")
    private TransactionType type;

    // Default const
    public Expense() {}

    public Expense(String category, double amount, LocalDate date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.type = TransactionType.EXPENSE;
    }

    public Expense(String category, double amount, LocalDate date, String description, TransactionType type) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }
}

