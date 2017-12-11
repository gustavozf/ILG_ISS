package com.silverdev.ilg;

import com.silverdev.ilg.controller.IngressoController;
import com.silverdev.ilg.model.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngressoControllerTest {
    @Autowired
    private IngressoController controller;

    //@Test
    /*public void caso1() throws Exception{
        Usuario user = new Usuario();
        RedirectAttributes ra = null;

        user.setNome("Raimundo");
        user.setSobrenome("Peixoto#$");
        user.setCEP("870402341");
        user.setCpf("06463841986");
        user.setAtivo(false);
        user.setPassword("1234");
        user.setBairro("zona 7");
        user.setUsername("alou");
        user.setCidade("Maringa");
        user.setData_nascimento("10121997");
        user.setEmail("Raimundojose@uem,br");
        user.setNumero("123");
        user.setRua("Rua cuba");

        controller.registraIngressante(user, new RedirectAttributesModelMap());
    }
    @Test
    public void caso2() throws Exception{
        Usuario user = new Usuario();
        RedirectAttributes ra = null;

        user.setNome("Narcizo");
        user.setSobrenome("Gabriel");
        user.setCEP("870402341");
        user.setCpf("06463841986");
        user.setAtivo(false);
        user.setPassword("1234");
        user.setBairro("Vila Morangueira");
        user.setUsername("narci016");
        user.setCidade("Maringa");
        user.setData_nascimento("10121997");
        user.setEmail("narcizogabriel@yahoo.com.br");
        user.setNumero("102");
        user.setRua("Rua managua");

        controller.registraIngressante(user, new RedirectAttributesModelMap());
    }*/
}
