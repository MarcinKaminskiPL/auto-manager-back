package net.mkaminski.autoManagerBackend.thymeleafControllers;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.entities.Expense;
import net.mkaminski.autoManagerBackend.services.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    public String get(Model model){
        model.addAttribute("expenses", expenseService.getExpenses());
        model.addAttribute("newExpense", new Expense());
        model.addAttribute("sumOfExpenses", expenseService.getSumOfExpenses());
        model.addAttribute("averageValueOfExpense", expenseService.getAverageValueOfExpense());
        return "expenses";
    }

    @PostMapping("/add-expense")
    public String addExpense(@ModelAttribute Expense expense){
        expenseService.add(expense);
        return "redirect:/expenses";
    }
}
