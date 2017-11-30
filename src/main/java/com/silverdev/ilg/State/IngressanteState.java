package com.silverdev.ilg.State;

public class IngressanteState implements Matricula {
    @Override
    public Matricula efetivada() {
        //Ingressante -> Aluno
        return null;
    }

    @Override
    public Matricula naoEfetivada() {
        //Ingressante desistente
        return null;
    }
}
