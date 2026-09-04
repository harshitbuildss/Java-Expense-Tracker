package com.harshit.expensetracker.dto;

import java.util.List;
import java.util.Map;

public class DashboardSummaryDto {

    private double totalIncome;
    private double totalExpense;
    private double balance;      // totalIncome - totalExpense
    private double netSavings;   // same formula as balance in this simple model
    private int totalTransactions;
    private double averageExpense; // totalExpense / number of EXPENSE transactions
    private Map<String, Double> categoryWiseExpense;
    private List<MonthlySummaryDto> monthlyBreakdown;

    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }
    public double getTotalExpense() { return totalExpense; }
    public void setTotalExpense(double totalExpense) { this.totalExpense = totalExpense; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public double getNetSavings() { return netSavings; }
    public void setNetSavings(double netSavings) { this.netSavings = netSavings; }
    public int getTotalTransactions() { return totalTransactions; }
    public void setTotalTransactions(int totalTransactions) { this.totalTransactions = totalTransactions; }
    public double getAverageExpense() { return averageExpense; }
    public void setAverageExpense(double averageExpense) { this.averageExpense = averageExpense; }
    public Map<String, Double> getCategoryWiseExpense() { return categoryWiseExpense; }
    public void setCategoryWiseExpense(Map<String, Double> categoryWiseExpense) { this.categoryWiseExpense = categoryWiseExpense; }
    public List<MonthlySummaryDto> getMonthlyBreakdown() { return monthlyBreakdown; }
    public void setMonthlyBreakdown(List<MonthlySummaryDto> monthlyBreakdown) { this.monthlyBreakdown = monthlyBreakdown; }
}
