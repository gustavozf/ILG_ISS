package com.silverdev.ilg.model.enums;

public enum Role {
    ROLE_SECRETARIA("Secretário(a)"),
    ROLE_PROFESSOR("Professor(a)"),
    ROLE_INGRESSANTE("Ingressante"),
    ROLE_ALUNO("Aluno"),
    ROLE_ADMIN("Admin");

    private String acesso;

    public String getAcesso() {
        return acesso;
    }

    Role(String acesso){
        this.acesso=acesso;
    }

}
