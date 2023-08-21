import br.com.kanban.model.Task;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Tarefa 1 do Kanban");
        System.out.println(task.toString());

        task.avancarStatus();
        task.avancarStatus();
        System.out.println(task.toString());

        task.regredirStatus();
        System.out.println(task.toString());

    }
}