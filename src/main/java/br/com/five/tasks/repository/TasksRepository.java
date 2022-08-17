package br.com.five.tasks.repository;

import br.com.five.tasks.orm.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {

}
