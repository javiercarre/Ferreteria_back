package com.ferreteria_back.repository;

import com.ferreteria_back.entity.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {
}
