package br.com.five.tasks.controller;

import br.com.five.tasks.orm.Tasks;
import br.com.five.tasks.service.CrudTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class HomeController {

    private CrudTaskService crudTaskService;
    @PersistenceContext
    private EntityManager entityManager;

    public HomeController(CrudTaskService crudTaskService){
        this.crudTaskService = crudTaskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getById(@PathVariable Integer id){
        return new ResponseEntity<>(crudTaskService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAll(){
        return new ResponseEntity<>(crudTaskService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam Integer id){
        crudTaskService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Tasks> update(@RequestBody Tasks tasks){
        return new ResponseEntity<>(crudTaskService.update(tasks), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tasks> post(@RequestBody Tasks tasks){
        return new ResponseEntity<>(crudTaskService.save(tasks), HttpStatus.CREATED);
    }
}