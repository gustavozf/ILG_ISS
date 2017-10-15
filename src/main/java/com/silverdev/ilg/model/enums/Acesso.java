package com.silverdev.ilg.model.enums;

public enum Acesso {
    S("SECRETARIA"),
    P("PROFESSOR"),
    I("INGRESSANTE"),
    A("ALUNO"),
    M("ADMIN");

    private String acesso;

    public String getAcesso() {
        return acesso;
    }

    Acesso(String acesso){
        this.acesso=acesso;
    }

}
