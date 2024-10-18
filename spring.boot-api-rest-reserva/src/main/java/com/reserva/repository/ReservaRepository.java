package com.reserva.repository;

import org.springframework.data.repository.CrudRepository;

import com.reserva.modelo.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

}
