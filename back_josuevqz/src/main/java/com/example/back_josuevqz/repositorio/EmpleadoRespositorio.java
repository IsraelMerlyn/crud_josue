package com.example.back_josuevqz.repositorio;

import com.example.back_josuevqz.modelo.empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRespositorio extends JpaRepository<empleado, Long> {
}
