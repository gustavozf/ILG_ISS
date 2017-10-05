package com.silverdev.ilg.model.enums;

public enum Acesso {
    S("Secretaria"), P("Professor");

    private String acesso;

    public String getAcesso() {
        return acesso;
    }

    Acesso(String acesso){
        this.acesso=acesso;
    }

}
