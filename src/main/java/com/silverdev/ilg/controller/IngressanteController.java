package com.silverdev.ilg.controller;

import com.silverdev.ilg.general.IngressoBoleto;
import com.silverdev.ilg.model.Aluno;
import com.silverdev.ilg.model.Ingressante;
import com.silverdev.ilg.model.Turma;
import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by narcizo on 23/10/17.
 */
@Controller
@RequestMapping("/ingressante/{id}")
public class IngressanteController {

    private final IngressanteRepository ingressanteRepository;
    private final UsuarioRepository usuarioRepository;
    private final TurmaRepository turmaRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public IngressanteController(IngressanteRepository ingressanteRepository,
                                 UsuarioRepository usuarioRepository,
                                 TurmaRepository turmaRepository,
                                 CursoRepository cursoRepository){
        this.ingressanteRepository = ingressanteRepository;
        this.usuarioRepository = usuarioRepository;
        this.turmaRepository = turmaRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public String abreTelaIngressante(@PathVariable("id") Integer id, Model model){
        findIngressanteByUsuarioID(id);
        model.addAttribute("ingressante", usuarioRepository.getOne(id));

        return "/ingressante/pessoal";
    }

    @GetMapping("pessoal/{id}")
    public String infoPessoal(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ingressante", usuarioRepository.getOne(id));

        return"/ingressante/pessoal";
    }

    @GetMapping("matricula/{id}")
    public String infoMatricula(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ingressante", usuarioRepository.getOne(id));

        return"/ingressante/matricula";
    }

    @GetMapping("/ingressante/{id}")
    public String telaReadMore(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ingressante", usuarioRepository.getOne(id));

        return "/ingressante/ingressante";
    }

    @GetMapping("/registro/{id}")
    public String getRegistraFuncionario(@PathVariable("id") Integer id, Model model){
        model.addAttribute("turmas", turmaRepository.findByDisponivel(true));
        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("ingressante", new Ingressante());
        Usuario user = usuarioRepository.findUsuarioById(id);

        return "/ingressante/registroCurso";
    }

    //@PostMapping("/registro/{id}")
    //@ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/registro/{id}", method = RequestMethod.POST)
    public @ResponseBody String registraFuncionario(@PathVariable("id") Integer id, @Valid Ingressante usuario, RedirectAttributes ra) {
        System.out.println("\nfalei cuzao");
        String redirecionamento = "redirect:/ingressante/{id}";
        Usuario user = usuarioRepository.findUsuarioById(id);
        Ingressante ingressante = new Ingressante();

        usuario.setCpf(user.getCpf());
        usuario.setId(user.getId());
        //boolean condicao1 = existeCpf(usuario.getCpf());
        //Checa se existe um mesmo usuario inativo
        //boolean condicao2 = false;
        //if (condicao1){
        //    condicao2 = usuarioRepository.getOneByCpf(usuario.getCpf()).isAtivo();
        //}

        //usuario.setId(user.getId());
        //usuario.setCpf(user.getCpf());
        //usuario.setPosUem(user.getPosUEM());
        //if(condicao1 && !condicao2) {
        //    ra.addFlashAttribute("sucesso", "Ingressante registrado com sucesso!");
        //}
        System.out.println("falei cuzao");
        return redirecionamento;
    }

    @GetMapping("/boleto/{id}")
    public String visualizaBoleto(@PathVariable("id") Integer id, Model model){
        Usuario usuario = usuarioRepository.getOne(id);
        IngressoBoleto ingressoBoleto = null;

        List<Ingressante> ingressantes = findIngressanteByUsuarioID(id);

        for(Ingressante ing: ingressantes){
            ingressoBoleto = new IngressoBoleto(ing, usuario);
            ingressoBoleto.geraBoleto();
        }



        model.addAttribute("ingressante", ingressantes);
        model.addAttribute("id", id);

        return  "/ingressante/boleto";
    }

    private List<Ingressante> findIngressanteByUsuarioID(Integer id){
        Usuario usuario =  usuarioRepository.getOne(id);
        List<Ingressante> ingressanteLista = ingressanteRepository.findByCpf(usuario.getCpf());

        return ingressanteLista;
    }
    private boolean existeCpf(String cpf){
        return usuarioRepository.findByCpf(cpf).isPresent();
    }

    private boolean existeUsername(String username){
        return usuarioRepository.findByUsername(username).isPresent();
    }

}