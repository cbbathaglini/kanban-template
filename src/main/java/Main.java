import br.com.kanban.model.StatusTask;
import br.com.kanban.model.Task;
import br.com.kanban.repository.TaskRepository;
import br.com.kanban.service.CreateTask;
import br.com.kanban.service.ListTask;
import br.com.kanban.service.TaskService;
import br.com.kanban.service.UpdateTask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        options();
    }

    public static void options() throws SQLException {
        TaskService taskService = new TaskService();
        Scanner in = new Scanner(System.in);
        String option = "-1";

        while(!"4".equals(option)){
            text_about_options();
            System.out.println("Informe uma opção: ");
            option = in.nextLine();
            switch (option) {
                case "1":
                    CreateTask.create(taskService,in);
                    break;
                case "2":
                    UpdateTask.update(taskService,in);
                    break;
                case "3":
                    ListTask.list(taskService,in);
                    break;
                case "4":
                    System.out.println("Finalizando...");
                    System.exit(1);
                    break;
            }
        }
    }

    public static void text_about_options(){
        System.out.println("------------------------------------------");
        System.out.println(" 1 - Cadastrar uma tarefa");
        System.out.println(" 2 - Atualizar o status da tarefa");
        System.out.println(" 3 - Listar as tarefas");
        System.out.println(" 4 - Sair");
        System.out.println("------------------------------------------");
    }
}