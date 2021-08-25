package net.mkaminski.autoManagerBackend.model.repositories;

import net.mkaminski.autoManagerBackend.model.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
}
