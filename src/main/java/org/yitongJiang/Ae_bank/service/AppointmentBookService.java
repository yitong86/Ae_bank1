package org.yitongJiang.Ae_bank.service;

import org.yitongJiang.Ae_bank.model.Appointment;
import org.yitongJiang.Ae_bank.repositories.AppointmentBookRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;
//appontment book service
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentBookService {
    @Autowired
    private AppointmentBookRepo appointmentBookRepo;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentBookRepo.save(appointment);
    }

    public Iterable<Appointment> getAllAppointments() {
        return appointmentBookRepo.findAll();
    }
//    public void deleteTicket(Integer appointmentId) {
//        appointmentBookRepo.delete(appointmentId);
//    }

    public Appointment getAppointById(Integer id) {
        Optional<Appointment> optionalAppointment = appointmentBookRepo.findById(id);
        return optionalAppointment.orElse(null);
    }
}
