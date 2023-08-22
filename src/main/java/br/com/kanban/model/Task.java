package br.com.kanban.model;

public class Task {

    private Integer id;
    private StatusTask statusTaskEnum;
    private String name;

    public  Task(){
    }
    public Task(Integer id, String name, StatusTask statusTask){
        this.id = id;
        this.name = name;
        this.statusTaskEnum = statusTask;
    }
    public Task(String name){
        this.id = null;
        this.name = name;
        this.statusTaskEnum = StatusTask.PARA_FAZER;
    }

    public Integer getId(){
        return this.id;
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
        this.statusTaskEnum = StatusTask.avancar(this.statusTaskEnum);
    }

    public void regredirStatus(){
        this.statusTaskEnum = StatusTask.regredir(this.statusTaskEnum);

    }

    public String toString(){
        return "Task [id="+this.id+", name="+this.name+", statusTaskEnum="+statusTaskEnum.toString()+"] \n";
    }
}