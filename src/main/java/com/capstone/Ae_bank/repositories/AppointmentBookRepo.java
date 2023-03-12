package com.capstone.Ae_bank.repositories;

import com.capstone.Ae_bank.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentBookRepo extends JpaRepository<Appointment,Integer> {

    Appointment getAppointById(int i);
}
