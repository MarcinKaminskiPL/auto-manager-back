package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.entities.Expense;
import net.mkaminski.autoManagerBackend.model.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final CarService carService;

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public void add(Expense expense) {
            expense.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            expenseRepository.save(expense);
    }

    public boolean existById(Long id) {
        return expenseRepository.existsById(id);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    public double getSumOfExpenses() {
        return expenseRepository.findAll().stream().mapToDouble(Expense::getValue).sum();
    }

    public double getAverageValueOfExpense() {
        if(expenseRepository.count()>0){
            return expenseRepository.findAll().stream().mapToDouble(Expense::getValue).average().getAsDouble();
        } else{
            return 0;
        }

    }
}
