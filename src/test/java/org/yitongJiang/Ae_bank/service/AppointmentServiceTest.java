package org.yitongJiang.Ae_bank.service;

import org.yitongJiang.Ae_bank.model.Appointment;
import org.yitongJiang.Ae_bank.repositories.AppointmentBookRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class AppointmentServiceTest {

    @MockBean
    private AppointmentBookRepo appointmentBookRepo;
@Autowired
    private AppointmentBookService appointmentBookService;

    @Test
    public void testAppointment() {
        Appointment appointment = new Appointment(1,"09/09/2022");
        // Setup our mock repository
        doReturn(Optional.empty()).when(appointmentBookRepo).findById(1);

        // Execute the service call
        Optional<Appointment> returnedWidget = appointmentBookRepo.findById(1);

        // Assert the response
        Assertions.assertThat(returnedWidget.isPresent());

    }


}