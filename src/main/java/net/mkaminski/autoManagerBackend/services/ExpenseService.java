package net.mkaminski.autoManagerBackend.services;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.Expense;
import net.mkaminski.autoManagerBackend.model.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepo expenseRepo;
    private final CarService carService;

    public List<Expense> getExpenses() {
        return expenseRepo.findAll();
    }

    public void add(Expense expense) {
            expense.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            expenseRepo.save(expense);
    }

    public boolean existById(Long id) {
        return expenseRepo.existsById(id);
    }

    public void deleteById(Long id) {
        expenseRepo.deleteById(id);
    }
}