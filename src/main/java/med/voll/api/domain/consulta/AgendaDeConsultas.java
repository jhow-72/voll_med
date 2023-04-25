package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadoresAgendamento;
    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public AgendaDeConsultas() {
    }

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){
        if(!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado nao existe");
        }
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico informado nao existe");
        }

        validadoresAgendamento.forEach(v -> v.validar(dados));

        Paciente paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        Medico medico = escolherMedico(dados);
        if(medico==null){
            throw new ValidacaoException("Nao existe medico disponivel nessa data");
        }
        Consulta consulta = new Consulta(null, medico, paciente, dados.data(), SituacaoConsulta.AGENDADA, MotivoCancelamento.NA);

        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    public DadosDetalhamentoCancelamentoConsulta cancelar(DadosCancelamentoConsulta dados) {
        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoException("id da Consulta informada nao existe");
        }

        System.out.println("entrou no metodo cancelar apos o controller");

        Consulta consulta = consultaRepository.getReferenceById(dados.idConsulta());

        System.out.println("usou o repository para buscar a consulta");

        validadoresCancelamento.forEach(v -> v.validar(dados));

        System.out.println("fez as validacoes para o cancelamento da consulta");

        consulta.cancelaConsulta(dados);
        return new DadosDetalhamentoCancelamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico()!=null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if(dados.especialidade()==null){
            throw new ValidacaoException("especialidade eh obrigatoria quando medico nao for selecionado");
        }

        return medicoRepository.escolherMedicoAleatorioPorEspecialidadeLivreNaData(dados.especialidade(), dados.data());
    }
}
