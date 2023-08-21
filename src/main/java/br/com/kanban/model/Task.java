package br.com.kanban.model;

public class Task {
    private StatusTask statusTaskEnum;
    private String name;

    public Task(String name){
        this.name = name;
        this.statusTaskEnum = StatusTask.PARA_FAZER;
    }

    public String getName(){
        return this.name;
    }

    public StatusTask getStatusTaskEnum(){
        return this.statusTaskEnum;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStatusTaskEnum(StatusTask status){
        this.statusTaskEnum = status;
    }

    public void avancarStatus(){
        if(this.statusTaskEnum == StatusTask.PARA_FAZER) this.statusTaskEnum = StatusTask.TRABALHANDO;
        else if(this.statusTaskEnum == StatusTask.TRABALHANDO) this.statusTaskEnum = StatusTask.ESPERANDO;
        else this.statusTaskEnum = StatusTask.FEITO;
    }

    public void regredirStatus(){
        if(this.statusTaskEnum == StatusTask.TRABALHANDO) this.statusTaskEnum = StatusTask.PARA_FAZER;
        else if(this.statusTaskEnum == StatusTask.ESPERANDO) this.statusTaskEnum = StatusTask.TRABALHANDO;
        else this.statusTaskEnum = StatusTask.ESPERANDO;

    }

    public String toString(){
        return "Task [name="+this.name+", statusTaskEnum="+statusTaskEnum.toString()+"]";
    }
}