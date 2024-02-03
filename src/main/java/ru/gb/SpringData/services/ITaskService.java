package ru.gb.SpringData.services;


import ru.gb.SpringData.models.Task;
import ru.gb.SpringData.models.TaskStatus;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса задач
 */
public interface ITaskService {
    /**
     * Метод получения всех задач
     * @return Все задачи в формате List
     */
    List<Task> getAllTasks();


    /**
     * Метод получения всех задач по статусу
     * @param status Статус из перечисления TaskStatus
     * @return Все задачи со статусом из параметра в формате List
     */
    List<Task> getTasksByStatus(TaskStatus status);

    /**
     * Метод поиска задачи по ID
     * @param id ID задачи
     * @return Возвращает задачу по её ID в формате Optional
     */
    Optional<Task> getTaskById(Long id);

    /**
     * Метод создания задачи
     * @param task Задача для создания
     * @return Созданную задачу
     */
    Task createTask(Task task);

    /**
     * Метод изменения задачи
     * @param id ID задачи для изменения
     * @param task Изменённая задача
     * @return Возвращает изменённую задачу
     */
    Task updateTask(Long id, Task task);

    /**
     * Метод для удаления задачи по её ID
     * @param id ID задачи для удаления
     */
    void deleteTask(Long id);
}
