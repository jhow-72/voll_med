package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorAgendamentoDeConsultaHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDoHorarioDeAbertura = dataConsulta.getHour() < 7;
        var depoinDoHorarioDeEncerramento = dataConsulta.getHour() > 18;

        if(domingo || antesDoHorarioDeAbertura || depoinDoHorarioDeEncerramento){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }
    }
}
