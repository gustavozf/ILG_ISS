package com.silverdev.ilg;

import com.silverdev.ilg.controller.SelecaoController;
import com.silverdev.ilg.model.Disputa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelecaoControllerTest {
    @Autowired
    private SelecaoController controller;

    @Test
    public void caminho1() throws Exception{
        List<Disputa> disputas = null;


        //controller.ordenaMelhores(disputas,1,1,1,1);
    }

    @Test
    public void caminho2() throws Exception{
        List<Disputa> disputas = null;


        //controller.ordenaMelhores(disputas, 1,1,1,1);
    }

    @Test
    public void caminho3() throws Exception{
        List<Disputa> disputas = null;


        //controller.ordenaMelhores(disputas, 1, 0, 1,1);
    }

    @Test
    public void caminho4() throws Exception{
        List<Disputa> disputas = null;


       // controller.ordenaMelhores(disputas, );
    }

    @Test
    public void caminho5() throws Exception{
        List<Disputa> disputas = null;


        //controller.ordenaMelhores();
    }

}
