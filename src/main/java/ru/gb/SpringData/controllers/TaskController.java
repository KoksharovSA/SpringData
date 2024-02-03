package ru.gb.SpringData.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringData.models.Task;
import ru.gb.SpringData.models.TaskStatus;
import ru.gb.SpringData.services.TaskServiceImpl;

import java.util.List;

/**
 * Класс контроллера задач
 */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
@Log
public class TaskController {
    /**
     * Сервис задач
     */
    private final TaskServiceImpl taskService;

    /**
     * Метод получения всех задач
     * @return Возвращает все задачи в формате List
     */
    @GetMapping
    public List<Task> getAllTasks(){
        log.info("Run TaskController.getAllTasks");
        return taskService.getAllTasks();
    }

    /**
     * Метод создания новой задачи
     * @param task Новая задача
     * @return Строку "Created"
     */
    @PostMapping
    public String createTask(@RequestBody Task task){
        log.info("Run TaskController.createTask");
        taskService.createTask(task);
        return "Created";
    }

    /**
     * Метод получения задач по статусу
     * @param status Статус задачи из перечисления TaskStatus
     * @return Возвращает все задачи с переданым статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        log.info("Run TaskController.getTaskByStatus");
        return taskService.getTasksByStatus(status);
    }

    /**
     * Метод обновляющий задачу
     * @param id ID задачи
     * @param task Изменённая задача
     * @return Возвращает изменённую задачу
     */
    @PutMapping("/update/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        log.info("Run TaskController.updateTaskStatus");
        return taskService.updateTask(id, task);
    }

    /**
     * Метод удаления задачи
     * @param id ID задачи для удаления
     */
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id){
        log.info("Run TaskController.deleteTask");
        taskService.deleteTask(id);
    }
}
