package com.tuyo.agendamentopaciente;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.tuyo.agendamentopaciente.entities.Agendamento;
import com.tuyo.agendamentopaciente.entities.Medico;
import com.tuyo.agendamentopaciente.entities.SeguroSaude;
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
        Medico medico = new Medico();
        medico.setFirstName("Barros");
        medico.setLastName("Silva");
        medico.setSpeciality("All");

        medicoRepository.save(medico);

        /*List<Medico> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Medico medico = new Medico();
            // medico.setId(4L);
            medico.setFirstName("Barros");
            medico.setLastName("Silva");
            medico.setSpeciality("All");

            list.add(medico);
        }*/
       /* List<Medico> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Medico medico2 = new Medico();
            // medico2.setId(4L);
            medico2.setFirstName("Bharath2");
            medico2.setLastName("Thippireddy2");
            medico2.setSpeciality("All2");

            list.add(medico2);
        }*/

       // medicoRepository.saveAll(list);
    }

    @Test
    public void testCreatePatient() {

        Paciente paciente = new Paciente();
        paciente.setFirstName("Doug");
        paciente.setLastName("Bailey");
        paciente.setPhone("123456");

        SeguroSaude seguroSaude = new SeguroSaude();
        seguroSaude.setProviderName("Blue Cross Blue Shield");
        seguroSaude.setCopay(20d);

        paciente.setInsurance(seguroSaude);

        Medico medico = medicoRepository.findById(1L).get();
        List<Medico> medicos = Arrays.asList(medico);
        paciente.setDoctors(medicos);

        pacienteRepository.save(paciente);

    }

    @Test
    public void testCreateAppointment() {

        Agendamento agendamento = new Agendamento();
        Timestamp agendamento_time = new Timestamp(new Date().getTime());
        agendamento.setAppointmentTime(agendamento_time);
        agendamento.setReason("I have a problem");
        agendamento.setStarted(true);

        agendamento.setPatient(pacienteRepository.findById(1l).get());
        agendamento.setDoctor(medicoRepository.findById(1L).get());

        agendamentoRepository.save(agendamento);
    }

}