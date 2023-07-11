package com.upc.proyectofinal.repository;

import com.upc.proyectofinal.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity,Integer> {
}
