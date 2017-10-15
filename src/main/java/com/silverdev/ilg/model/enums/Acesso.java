package com.silverdev.ilg.model.enums;

public enum Acesso {
    ROLE_SECRETARIA("Secretaria"),
    ROLE_PROFESSOR("Professor"),
    ROLE_INGRESSANTE("Ingressante"),
    ROLE_ALUNO("Aluno"),
    ROLE_ADMIN("Admin");

    private String acesso;

    public String getAcesso() {
        return acesso;
    }

    Acesso(String acesso){
        this.acesso=acesso;
    }

}
