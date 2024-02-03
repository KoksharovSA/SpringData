package ru.gb.SpringData.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.SpringData.models.Task;
import ru.gb.SpringData.models.TaskStatus;
import ru.gb.SpringData.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

/**
 * Класс сервиса задач
 */
@Service
@AllArgsConstructor
public class TaskServiceImpl implements ITaskService{
    /**
     * Репозиторий задач
     */
    private final TaskRepository repository;

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findAllByStatus(status);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task newTask) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(newTask.getDescription());
            task.setStatus(newTask.getStatus());
            task.setDateCreate(newTask.getDateCreate());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
