package med.voll.api.domain.consulta;

public record DadosDetalhamentoCancelamentoConsulta(SituacaoConsulta situacao, MotivoCancelamento motivoCancelamento) {
    public DadosDetalhamentoCancelamentoConsulta(Consulta consulta){
        this(consulta.getSituacao(), consulta.getMotivoCancelamento());
    }
}
