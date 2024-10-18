package com.reserva.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserva.modelo.Reserva;
import com.reserva.repository.ReservaRepository;



@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping({ "reservas" })
public class ReservaController {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	//http://localhost:7575/reservas/listar
	@GetMapping("listar")
	public List<Reserva> listarReservas(){
		List<Reserva> reservas = (List<Reserva>) reservaRepository.findAll();
		return reservas;
	}
	
	//http://localhost:7575/reservas
	@PostMapping
	public Reserva addReserva(@RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	@GetMapping("/{id}")
	public Optional<Reserva> getReservaById(@PathVariable int id){
		return reservaRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	public Reserva updateReserva(@RequestBody Reserva reserva, @PathVariable int id) {
		reserva.setId(id);
		return reservaRepository.save(reserva);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReserva(@PathVariable int id) {
		reservaRepository.deleteById(id);
	}
}
