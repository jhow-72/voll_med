package med.voll.api.controller;

import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroMedico> dadosCadastroMedicoJson;
    @Autowired
    private JacksonTester<DadosDetalhamentoMedico> dadosDetalhamentoMedicoJson;

    @MockBean
    private MedicoRepository medicoRepository;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(post("/medicos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        DadosCadastroMedico dadosCadastroMedico = dadosCadastroMedico();
        DadosDetalhamentoMedico dadosDetalhamentoMedico = dadosDetalhamentoMedico(dadosCadastroMedico);

        when(medicoRepository.save(any())).thenReturn(new Medico(dadosCadastroMedico));

        var response = mvc.perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastroMedico).getJson()))
                .andReturn().getResponse();

        var jsonEsperado = dadosDetalhamentoMedicoJson.write(
                dadosDetalhamentoMedico
        ).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }



    private DadosEndereco dadosEndereco(){
        return new DadosEndereco(
                "logradouro",
                "bairro",
                "99999999",
                "Sao Paulo",
                "SP",
                "complemento",
                "1"
        );
    }

    private DadosCadastroMedico dadosCadastroMedico() {
        return new DadosCadastroMedico("nome",
                "email@voll.med",
                "123456",
                "11999999999",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );
    }

    private DadosDetalhamentoMedico dadosDetalhamentoMedico(DadosCadastroMedico dadosCadastroMedico) {
        return new DadosDetalhamentoMedico(null,
                dadosCadastroMedico.nome(),
                dadosCadastroMedico.email(),
                dadosCadastroMedico.crm(),
                dadosCadastroMedico.telefone(),
                dadosCadastroMedico.especialidade(),
                new Endereco(dadosEndereco())
        );
    }
}