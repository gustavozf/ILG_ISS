package com.silverdev.ilg.controller;

import com.silverdev.ilg.model.Aluno;
import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.repository.AlunoRepository;
import com.silverdev.ilg.repository.IngressanteRepository;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/aluno/{id}")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository,
                           UsuarioRepository usuarioRepository){
        this.alunoRepository = alunoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String abreTelaAluno(@PathVariable("id") Integer id, Model model){
        Usuario usuario =  usuarioRepository.getOne(id);
        List<Aluno> alunoLista = alunoRepository.findByCpf(usuario.getCpf());

        Aluno aluno = alunoLista.get(0);

        String posicao = aluno.getPosicao_uem().getPosicaoUem();

        model.addAttribute("aluno", usuario);
        model.addAttribute("posicao", posicao);

        return "/aluno/aluno";
    }

    @GetMapping("/notas/{id}")
    public String visuaNotas(@PathVariable("id") Integer id, Model model){
        Usuario aluno = usuarioRepository.getOne(id);
        String cpf = aluno.getCpf();

        model.addAttribute("aluno", aluno);
        model.addAttribute("notas", alunoRepository.findByCpf(cpf));

        return  "/aluno/notas";
    }

    @GetMapping("/aprovacao/{id}")
    public String visuaAprov(@PathVariable("id") Integer id, Model model){
        Usuario aluno = usuarioRepository.getOne(id);

        String cpf = aluno.getCpf();

        List<Aluno> alunos = alunoRepository.findByCpf(cpf);

        encontraAprovacao(alunos);

        model.addAttribute("aluno", aluno);
        model.addAttribute("alunos", alunos);

        return  "/aluno/aprovacao";
    }

    public void encontraAprovacao(List<Aluno> alunos){
        for(Aluno x: alunos){
            if((x.getMedia()) >= verificaFaltas(x.getFaltas())){
                x.setAprovacao(true);
                alunoRepository.saveAndFlush(x);
            }else{
                x.setAprovacao(false);
            }
        }
    }

    public double verificaFaltas(Integer faltas){
        if(faltas > 24){
            return 100.0;
        }else if(faltas >= 21){
            return 9.0;
        }else if(faltas >=17){
            return 8.0;
        }else{
            return 7.0;
        }
    }
}
