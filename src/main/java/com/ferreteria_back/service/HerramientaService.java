package com.ferreteria_back.service;

import com.ferreteria_back.dto.HerramientaDTO;
import com.ferreteria_back.entity.*;
import com.ferreteria_back.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HerramientaService {

    @Autowired
    HerramientaRepository herramientaRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    TipoRepository tipoRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    public Herramienta convertDtoToEntity(HerramientaDTO herramientaDTO) {
        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(herramientaDTO.getNombre());
        herramienta.setCantidad(herramientaDTO.getCantidad());

        Marca marca = marcaRepository.findById(Integer.parseInt(herramientaDTO.getMarca()))
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
        herramienta.setIdMarca(marca);

        Tipo tipo = tipoRepository.findById(Integer.parseInt(herramientaDTO.getTipo()))
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
        herramienta.setIdTipo(tipo);

        Estado estado = estadoRepository.findById(Integer.parseInt(herramientaDTO.getEstado()))
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        herramienta.setIdEstado(estado);

        Proveedor proveedor = proveedorRepository.findById(Integer.parseInt(herramientaDTO.getProveedor()))
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        herramienta.setIdProveedor(proveedor);

        return herramienta;
    }

    public void guardarHerramienta(Herramienta herramienta) {
        herramientaRepository.save(herramienta);
    }

    public List<Herramienta> consultaHerramientas() {
        return herramientaRepository.findAll();
    }

    public Optional<Herramienta> consultaHerramienta(int id) {
        return herramientaRepository.findById(id);
    }

    public Boolean eliminarHerramienta(int id){
        try {
            herramientaRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
