package com.harshit.expensetracker.dto;

public class MonthlySummaryDto {

    private String month; // format: yyyy-MM, e.g. "2026-09"
    private double totalIncome;
    private double totalExpense;

    public MonthlySummaryDto() {}

    public MonthlySummaryDto(String month, double totalIncome, double totalExpense) {
        this.month = month;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
    }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }
    public double getTotalExpense() { return totalExpense; }
    public void setTotalExpense(double totalExpense) { this.totalExpense = totalExpense; }
}
