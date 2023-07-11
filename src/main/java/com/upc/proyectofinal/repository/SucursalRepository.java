package com.upc.proyectofinal.repository;

import com.upc.proyectofinal.entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity,Integer> {
}
