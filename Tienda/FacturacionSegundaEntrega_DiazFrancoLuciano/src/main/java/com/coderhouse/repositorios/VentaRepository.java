package com.coderhouse.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.modelos.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
