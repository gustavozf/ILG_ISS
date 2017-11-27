package com.silverdev.ilg.model.enums;

public enum PosicaoUEM {
    DESC_00("Não possui vínculo à UEM", "-", 0.00),
    DESC_01("Servidor da UEM matriculado em curso de pós-graduação",
            "Declaração ou cópia do R.A.", 0.55),
    DESC_02("Acadêmico de pós-graduação STRICTU SENSU na UEM",
            "Declaração ou cópia do R.A", 0.55),
    DESC_03("Acadêmico de graduação participante de PET",
            "Declaração da PEN", 0.55),
    DESC_04("Acadêmico de graduação participante de iniciação científica",
            "Desnecessário", 0.55),
    DESC_05("Acadêmico de graduação participante de projeto de pesquisa",
            "Desnecessário", 0.55),
    DESC_06("Acadêmico de graduação participante de projeto de ensino",
            "Declaração da DEG", 0.55),
    DESC_07("Acadêmico de graduação participante de projeto de extensão",
            "DEX", 0.55),
    DESC_08("Participantes de todos os programas de bolsas oferecidos pela UEM",
            "Declaração ou documento que comprove", 0.55),
    DESC_09("Acadêmico da UEM não vinculado a projeto ou programa",
            "Desnecessário", 0.38),
    DESC_10("Servidor da UEM não matriculado em curso de pós-graduação",
            "Desnecessário", 0.38),
    DESC_11("Filho de servidor da UEM",
            "Desnecessário", 0.38),
    DESC_12("Servidor da UEM aposentado",
            "Desnecessário", 0.38),
    DESC_13("Dependente de servidor da UEM aposentado",
            "Desnecessário", 0.38);

    private final String posicaoUem;
    private final String documentacao;
    private final Double Desconto;

    PosicaoUEM(String posicao_uem, String documentacao, Double desconto) {
        this.posicaoUem = posicao_uem;
        this.documentacao = documentacao;
        this.Desconto = desconto;
    }

    public String getPosicaoUem() {
        return posicaoUem;
    }

    public String getDocumentacao() {
        return documentacao;
    }

    public Double getDesconto() {
        return Desconto;
    }
}
