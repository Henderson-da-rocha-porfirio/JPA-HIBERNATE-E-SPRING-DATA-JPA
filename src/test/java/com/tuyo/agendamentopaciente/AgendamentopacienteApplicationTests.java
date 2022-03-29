package com.tuyo.agendamentopaciente;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.tuyo.agendamentopaciente.entities.Agendamento;
import com.tuyo.agendamentopaciente.entities.Medico;
import com.tuyo.agendamentopaciente.entities.Seguranca;
import com.tuyo.agendamentopaciente.entities.Paciente;
import com.tuyo.agendamentopaciente.repos.AgendamentoRepository;
import com.tuyo.agendamentopaciente.repos.MedicoRepository;
import com.tuyo.agendamentopaciente.repos.PacienteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendamentopacienteApplicationTests {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Test
    public void testCreateDoctor() {

        List<Medico> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Medico medico2 = new Medico();
            // medico2.setId(4L);
            medico2.setFirstName("Bharath2");
            medico2.setLastName("Thippireddy2");
            medico2.setSpeciality("All2");

            list.add(medico2);
        }

        medicoRepository.saveAll(list);
    }

    @Test
    public void testCreatePatient() {

        Paciente paciente = new Paciente();
        paciente.setFirstName("Doug");
        paciente.setLastName("Bailey");
        paciente.setPhone("123456");

        Seguranca seguranca = new Seguranca();
        seguranca.setProviderName("Blue Cross Blue Shield");
        seguranca.setCopay(20d);

        paciente.setInsurance(seguranca);

        Medico medico = medicoRepository.findById(1L).get();
        List<Medico> medicos = Arrays.asList(medico);
        paciente.setDoctors(medicos);

        pacienteRepository.save(paciente);

    }

    @Test
    public void testCreateAppointment() {

        Agendamento agendamento = new Agendamento();
        Timestamp appointmentTime = new Timestamp(new Date().getTime());
        agendamento.setAppointmentTime(appointmentTime);
        agendamento.setReason("I have a problem");
        agendamento.setStarted(true);

        agendamento.setPatient(pacienteRepository.findById(1l).get());
        agendamento.setDoctor(medicoRepository.findById(1L).get());

        agendamentoRepository.save(agendamento);
    }

}