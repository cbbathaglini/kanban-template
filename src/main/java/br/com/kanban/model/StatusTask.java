package br.com.kanban.model;

public enum StatusTask {
    PARA_FAZER,
    TRABALHANDO,
    ESPERANDO,
    FEITO;

    public static StatusTask avancar(StatusTask taskStatus){
        if(taskStatus == StatusTask.PARA_FAZER) return StatusTask.TRABALHANDO;
        else if(taskStatus == StatusTask.TRABALHANDO) return StatusTask.ESPERANDO;
        else if(taskStatus == StatusTask.ESPERANDO) return StatusTask.FEITO;
        return FEITO;
    }

    public static StatusTask regredir(StatusTask taskStatus){
        if(taskStatus == StatusTask.TRABALHANDO) return StatusTask.PARA_FAZER;
        else if(taskStatus == StatusTask.ESPERANDO) return StatusTask.TRABALHANDO;
        else if(taskStatus == StatusTask.FEITO) return StatusTask.ESPERANDO;
        return PARA_FAZER;
    }

    public static StatusTask convert(String status) {
        return StatusTask.valueOf(status);
    }

}
