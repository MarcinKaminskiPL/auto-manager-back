package net.mkaminski.autoManagerBackend.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
}
