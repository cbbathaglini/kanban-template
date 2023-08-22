package br.com.kanban.model;

public enum Filter {
    ALFABETICAMENTE("Alfabeticamente"),
    STATUS("Por status"),
    SEM("Sem Ordem");

    private String descricao;

    private Filter(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
