package com.silverdev.ilg.model.enums;

/**
 * Created by gustavozf on 04/10/17.
 */
public enum Sexo {
    M("Masculino"), F("Feminino"), O("Outro");

    private String sexo;

    public String getSexo(){
        return sexo;
    }

    Sexo(String sexo){
        this.sexo = sexo;
    }

}
