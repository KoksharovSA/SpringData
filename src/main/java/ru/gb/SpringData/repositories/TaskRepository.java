package ru.gb.SpringData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.SpringData.models.Task;
import ru.gb.SpringData.models.TaskStatus;

import java.util.List;

/**
 * Класс JPA репозитория для общения с базой данных
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * @param status Статус задачи из перечисления TaskStatus
     * @return
     */
    List<Task> findAllByStatus(TaskStatus status);
}
