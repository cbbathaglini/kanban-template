package br.com.kanban;

import br.com.kanban.model.StatusTask;
import br.com.kanban.model.Task;


import org.junit.Assert;
import org.junit.Test;

public class TaskTest{

    @Test
    public void test_task_PARA_FAZER_avancando_para_TRABALHANDO(){
        Task task = new Task("tarefa 1");
        task.avancarStatus();
        Assert.assertEquals(task.getStatusTaskEnum(), StatusTask.TRABALHANDO);
    }

    @Test
    public void test_task_TRABALHANDO_avancando_para_EM_ESPERA(){
        Task task = new Task("tarefa 2");
        task.setStatusTaskEnum(StatusTask.TRABALHANDO);
        task.avancarStatus();
        Assert.assertEquals(task.getStatusTaskEnum(), StatusTask.ESPERANDO);
    }

    @Test
    public void test_task_EM_ESPERA_avancando_para_FEITO(){
        Task task = new Task("tarefa 3");
        task.setStatusTaskEnum(StatusTask.ESPERANDO);
        task.avancarStatus();
        Assert.assertEquals(task.getStatusTaskEnum(), StatusTask.FEITO);
    }

    @Test
    public void test_task_TRABALHANDO_regredindo_para_PARA_FAZER(){
        Task task = new Task("tarefa 4");
        task.setStatusTaskEnum(StatusTask.TRABALHANDO);
        task.regredirStatus();
        Assert.assertEquals(task.getStatusTaskEnum(), StatusTask.PARA_FAZER);
    }

    @Test
    public void test_task_ESPERANDO_regredindo_para_TRABALHANDO(){
        Task task = new Task("tarefa 5");
        task.setStatusTaskEnum(StatusTask.ESPERANDO);
        task.regredirStatus();
        Assert.assertEquals(task.getStatusTaskEnum(), StatusTask.TRABALHANDO);
    }

    @Test
    public void test_task_FEITO_regredindo_para_ESPERANDO(){
        Task task = new Task("tarefa 6");
        task.setStatusTaskEnum(StatusTask.FEITO);
        task.regredirStatus();
        Assert.assertEquals(task.getStatusTaskEnum(), StatusTask.ESPERANDO);
    }

}
