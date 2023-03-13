package org.yitongJiang.Ae_bank.repositories;

import org.yitongJiang.Ae_bank.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
//appointment repo work with database
public interface AppointmentBookRepo extends JpaRepository<Appointment,Integer> {

    Appointment getAppointById(int i);
}
