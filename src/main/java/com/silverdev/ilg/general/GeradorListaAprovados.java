package com.silverdev.ilg.general;

import com.itextpdf.text.Document;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.lowagie.text.pdf.PdfTable;
import com.silverdev.ilg.model.Disputa;
import com.silverdev.ilg.model.Turma;
import com.silverdev.ilg.repository.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GeradorListaAprovados {
    private final Integer id_inscricao;
    public final TurmaRepository turmaRepository;
    public final DisputaRepository disputaRepository;
    public final IngressanteRepository ingressanteRepository;
    public final CursoRepository cursoRepository;
    public final UsuarioRepository usuarioRepository;

    public GeradorListaAprovados(Integer id_inscricao,
                                 TurmaRepository turmaRepository,
                                 DisputaRepository disputaRepository,
                                 IngressanteRepository ingressanteRepository,
                                 CursoRepository cursoRepository,
                                 UsuarioRepository usuarioRepository) {
        this.id_inscricao = id_inscricao;
        this.turmaRepository = turmaRepository;
        this.disputaRepository = disputaRepository;
        this.ingressanteRepository = ingressanteRepository;
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void GeraLista(){
        String caminho1 = "src/main/resources/static/PDFs/Selecao/"+ id_inscricao +".pdf";
        String caminho2 = "target/classes/static/PDFs/Selecao/"+ id_inscricao +".pdf";
        Document document1 = new Document(PageSize.A4.rotate());
        Document document2 = new Document(PageSize.A4.rotate());
    }

    public void createPdf(Document document, String caminho, List<Disputa> candidatos) throws DocumentException {
        Integer turma = 0;
        String nome = "";
        String CPF = "";

        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminho));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();

        for (Disputa candidato : candidatos){
            nome = usuarioRepository.getOneByCpf(ingressanteRepository.getOne(candidato.getIdIngressante()).getCpf()).getNome();

            if(turma != candidato.getIdTurma()){
                turma = candidato.getIdTurma();
                document.add(new Paragraph(
                        "Curso: "+ cursoRepository.findOne(turmaRepository.getOne(turma).getCurso_id()).getNome() +
                                " Turma: " + turmaRepository.getOne(turma).getCurso_id() + " "+
                                turmaRepository.getOne(turma).getDias() + " " + turmaRepository.getOne(turma).getHorarios()
                ));
               /* document.add(new Phrase("#" + candidato.getPosicao() +
                        ": " + ingressanteRepository.getOne(candidato.getIdIngressante()).getNo

                ));*/


            }
        }

        /*
        float[] columnWidths = {1, 3, 3, 3};
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(100);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, GrayColor.GRAYWHITE);
        PdfPCell cell = new PdfPCell(new Phrase("This is a header", f));
        cell.setBackgroundColor(GrayColor.BLUE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(3);
        table.addCell(cell);
        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
        for (int i = 0; i < 2; i++) {
            table.addCell("#");
            table.addCell("Key");
            table.addCell("Value");
        }
        table.setHeaderRows(3);
        table.setFooterRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        for (int counter = 1; counter < 101; counter++) {
            table.addCell(String.valueOf(counter));
            table.addCell("key " + counter);
            table.addCell("value " + counter);
        }
        document.add(table);*/
        document.close();
    }
}
