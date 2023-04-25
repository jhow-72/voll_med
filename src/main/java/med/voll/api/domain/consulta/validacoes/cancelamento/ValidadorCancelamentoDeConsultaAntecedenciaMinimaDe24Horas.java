package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoDeConsultaAntecedenciaMinimaDe24Horas implements ValidadorCancelamentoDeConsulta{

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {

        Consulta consulta = consultaRepository.getReferenceById(dados.idConsulta());

        if (Duration.between(LocalDateTime.now(), consulta.getData()).toHours() < 24){
            throw new ValidacaoException("uma consulta somente podera ser cancelada com antecedencia minima de 24 horas");
        }

    }
}
