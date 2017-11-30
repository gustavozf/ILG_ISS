package com.silverdev.ilg;

import com.silverdev.ilg.controller.AdminTurmaController;
import com.silverdev.ilg.model.Turma;
import com.silverdev.ilg.repository.TurmaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTurmaControllerTest {
    @Autowired
    private AdminTurmaController controller;

    @Test
    public void casoTesteTurma1() throws Exception{
        Turma turma = new Turma();
        RedirectAttributes ra = null;

        turma.setId(-1);
        turma.setProfessor("João Carlos");
        turma.setCurso_id(10001);
        turma.setNum_vagas(12);
        turma.setDias("Segunda/Sexta");
        turma.setHorarios("17:30 às 19h20");
        turma.setData_criacao("9/2016");
        turma.setDisponivel(false);
        turma.setAtivo(false);
        controller.registroTurma(turma, new RedirectAttributesModelMap());

    }

    @Test
    public void casoTesteTurma2() throws Exception{
        Turma turma = new Turma();
        turma.setId(2);
        turma.setProfessor("Paulinho23");
        turma.setCurso_id(-1);
        turma.setNum_vagas(21);
        turma.setDias("Segunda/Quarta");
        turma.setHorarios("16:32 às 19:20");
        turma.setData_criacao("11/2017");
        turma.setDisponivel(false);
        turma.setAtivo(true);
        controller.registroTurma(turma, new RedirectAttributesModelMap());

    }


    @Test
    public void casoTesteTurma3() throws Exception{
        Turma turma = new Turma();
        turma.setId(10001);
        turma.setProfessor("Johny_Ferreira");
        turma.setCurso_id(2);
        turma.setNum_vagas(-1);
        turma.setDias("Terça/Sexta");
        turma.setHorarios("15:20 às 16h50");
        turma.setData_criacao("8/2019");
        turma.setDisponivel(true);
        turma.setAtivo(true);
        controller.registroTurma(turma, new RedirectAttributesModelMap());

    }

    @Test
    public void casoTesteTurma4() throws Exception{
        Turma turma = new Turma();
        turma.setId(2);
        turma.setProfessor("Pedro Augusto");
        turma.setCurso_id(7);
        turma.setNum_vagas(16);
        turma.setDias("Terça/Quinta");
        turma.setHorarios("13:30 às 15:10");
        turma.setData_criacao("11/2017");
        turma.setDisponivel(true);
        turma.setAtivo(true);
        controller.registroTurma(turma, new RedirectAttributesModelMap());

    }

}
