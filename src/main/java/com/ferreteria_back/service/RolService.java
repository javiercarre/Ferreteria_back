package com.ferreteria_back.service;

import com.ferreteria_back.entity.Rol;
import com.ferreteria_back.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
}
