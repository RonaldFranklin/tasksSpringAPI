package br.com.five.tasks.service;

import br.com.five.tasks.orm.Tasks;
import br.com.five.tasks.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudTaskService {

    private final TasksRepository tasksRepository;
    private Boolean system = true;

    public CrudTaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Tasks update(Tasks tasks) {
        Integer id = tasks.getId();
        Tasks tasksBank = tasksRepository.findById(id).orElseThrow(()-> new RuntimeException("task not found"));
        tasksBank.setTitle(tasks.getTitle());
        tasksBank.setItsComplete(tasks.getItsComplete());
        tasksBank.setDate(tasks.getDate());
        return tasksRepository.save(tasksBank);
    }

    public Tasks getById(Integer id){
        return tasksRepository.findById(id).orElse(null);
    }

    public List<Tasks> getAll(){return tasksRepository.findAll();}

    public void deletar(Integer id){
        tasksRepository.deleteById(id);
    }

    public Tasks save(Tasks tasks){return tasksRepository.save(tasks);}
}
