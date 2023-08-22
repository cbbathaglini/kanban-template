package br.com.kanban.service;

import br.com.kanban.model.StatusTask;
import br.com.kanban.model.Task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateTask {

    public static void update(TaskService taskService, Scanner in) throws SQLException {
        System.out.println("Informe o identificador da tarefa: ");
        String id = in.nextLine();
        Task task = taskService.getTaskById(Integer.parseInt(id));

        System.out.println("Informe o novo status: ");
        List<StatusTask> statusTasks = listOfPossibilities(task);

        String statusOption = in.nextLine();

        taskService.changeTaskStatus(task,statusTasks.get(Integer.parseInt(statusOption)-1));
        Task updatedTask = taskService.getTaskById(task.getId());
        System.out.println("Task original: " + task.toString());
        System.out.println("Task atualizada: " + updatedTask.toString());

    }

    private static List<StatusTask> listOfPossibilities(Task task){
        List<StatusTask> statusTasks = new ArrayList<>();
        statusTasks.add(StatusTask.regredir(task.getStatusTaskEnum()));
        statusTasks.add(StatusTask.avancar(task.getStatusTaskEnum()));

        System.out.print("1 - " + statusTasks.get(0).toString()+"\n");
        System.out.print("2 - " + statusTasks.get(1).toString()+"\n");
        return statusTasks;
    }
}
