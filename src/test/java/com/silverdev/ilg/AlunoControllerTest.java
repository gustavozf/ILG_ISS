package com.silverdev.ilg;

import com.silverdev.ilg.controller.AdminTurmaController;
import com.silverdev.ilg.controller.AlunoController;
import com.silverdev.ilg.model.Aluno;
import com.silverdev.ilg.model.Turma;
import com.silverdev.ilg.model.enums.PosicaoUEM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

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

        aluno.setId(1);
        aluno.setFaltas(22);
        aluno.setMedia(9.4);
        aluno.setAprovacao(false);
        aluno.setCod_curso(111);
        aluno.setCod_turma(11);
        aluno.setCpf("059.234.123-12");
        aluno.setNome_curso("Ingles");
        aluno.setPosicao_uem(PosicaoUEM.DESC_00);
        aluno.setProva1(7.1);
        aluno.setProva2(0.0);

        alunos.add(aluno);

        controller.encontraAprovacao(alunos);

    }
}
