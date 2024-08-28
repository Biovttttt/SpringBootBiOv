package repository;

import entity.Task;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
@Registered
public interface TaskRepository extends JpaRepository<Task, Long> {
}
