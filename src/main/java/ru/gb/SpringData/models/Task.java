package ru.gb.SpringData.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


/**
 * Класс задачи
 */
@Entity
@Table(name = "task")
@Data
public class Task {
    /**
     * ID задачи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    /**
     * Текст задачи
     */
    @Column(nullable = false, length = 2000)
    private String description;

    /**
     * Статус задачи из перечисления TaskStatus
     */
    @Column(nullable = false)
    @Enumeraed(EnumType.STRING)
    private TaskStatus status;

    /**
     * Дата создания задачи, генерируется автоматически
     */
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreate;
}
