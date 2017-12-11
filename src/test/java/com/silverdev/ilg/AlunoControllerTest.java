package com.silverdev.ilg;

import com.silverdev.ilg.controller.AlunoController;
import com.silverdev.ilg.model.Aluno;
import com.silverdev.ilg.model.enums.PosicaoUEM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlunoControllerTest {
    @Autowired
    private AlunoController controller;

    @Test
    public void teste1() throws Exception {
        List<Aluno> alunos = null;
        controller.encontraAprovacao(alunos);

    }

    @Test
    public void teste2() throws Exception {
        List<Aluno> alunos = null;
        Aluno aluno = new Aluno();

        aluno.setFaltas(26);
        aluno.setMedia(8.0);

        alunos.add(aluno);

        controller.encontraAprovacao(alunos);

    }

    @Test
    public void teste3() throws Exception {
        List<Aluno> alunos = null;
        Aluno aluno = new Aluno();

        aluno.setFaltas(22);
        aluno.setMedia(9.4);

        alunos.add(aluno);

        controller.encontraAprovacao(alunos);

    }
}
