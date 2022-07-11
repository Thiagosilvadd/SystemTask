package dev.thiagod.systemtask.config;

import dev.thiagod.systemtask.entities.Task;
import dev.thiagod.systemtask.entities.enums.TaskStatus;
import dev.thiagod.systemtask.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        Task task1 = new Task(null, Instant.parse("2022-02-20T19:53:07Z"), "Tarefa 1", TaskStatus.PENDENTE, "URL_AQUI", null);
        Task task2 = new Task(null, Instant.parse("2022-04-22T19:53:07Z"), "Tarefa 2", TaskStatus.CANCELADA, "URL_AQUI", null);
        Task task3 = new Task(null, Instant.parse("2022-06-25T19:53:07Z"), "Tarefa 3", TaskStatus.PENDENTE, "URL_AQUI", null);
        Task task4 = new Task(null, Instant.parse("2022-07-26T19:53:07Z"), "Tarefa 4", TaskStatus.CANCELADA, "URL_AQUI", null);
        Task task5 = new Task(null, Instant.parse("2022-10-28T19:53:07Z"), "Tarefa 5", TaskStatus.CONCLUIDA, "URL_AQUI", null);

        taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4, task5));
    }
}
