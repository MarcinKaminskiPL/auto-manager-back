package net.mkaminski.autoManagerBackend.api;

import lombok.RequiredArgsConstructor;
import net.mkaminski.autoManagerBackend.model.Expense;
import net.mkaminski.autoManagerBackend.services.CarService;
import net.mkaminski.autoManagerBackend.services.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseApi {

    private final ExpenseService expenseService;
    private final CarService carService;

    @GetMapping
    ResponseEntity<List<Expense>> getExpenses() {
        return ResponseEntity.ok(expenseService.getExpenses());
    }

    @PostMapping
    ResponseEntity addExpense(@RequestBody Expense expense) {
        if(carService.existsById(expense.getCarId())) {
            expenseService.add(expense);
            return ResponseEntity.created(URI.create("/" + expense.getId())).body(expense);
        } else {
           return ResponseEntity.badRequest().body("car with id \"" + expense.getCarId() + "\" does not exist in the database");
        }
    }
    @DeleteMapping("{id}")
    ResponseEntity deleteExpense(@PathVariable Long id){
        if(expenseService.existById(id)){
            expenseService.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
