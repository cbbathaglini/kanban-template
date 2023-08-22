package br.com.kanban.service;

import br.com.kanban.model.Task;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateTask {

    public static void create(TaskService taskService, Scanner in) throws SQLException {
        System.out.println("Informe o nome da tarefa: ");
        String taskName = in.nextLine();
        taskService.createTask(new Task(taskName));

    }
}
