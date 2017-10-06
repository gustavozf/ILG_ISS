package com.silverdev.ilg.model.enums;

public enum Acesso {
    S("Secretaria"),
    P("Professor"),
    I("Ingressante"),
    A("Aluno"),
    M("Admin");

    private String acesso;

    public String getAcesso() {
        return acesso;
    }

    Acesso(String acesso){
        this.acesso=acesso;
    }

}
