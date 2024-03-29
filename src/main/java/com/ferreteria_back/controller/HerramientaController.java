package com.ferreteria_back.controller;

import com.ferreteria_back.dto.HerramientaDTO;
import com.ferreteria_back.entity.Herramienta;
import com.ferreteria_back.service.HerramientaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

    @PostMapping(value = "guardar")
    public ResponseEntity<Boolean> crearHerramienta(@RequestBody HerramientaDTO herramientaDTO) {
        Herramienta herramienta = herramientaService.convertDtoToEntity(herramientaDTO);
        herramientaService.guardarHerramienta(herramienta);
        return ResponseEntity.ok(true);
    }

    @GetMapping(value = "consultaTodos")
    public List<Herramienta> consultarHerramientas(){
        return herramientaService.consultaHerramientas();
    }

    @GetMapping(value = "consultaUna/{id}")
    public Optional<Herramienta> consultarHerramienta(@PathVariable Integer id){
        return herramientaService.consultaHerramienta(id);
    }

    @PutMapping(value = "actualizar/{id}")
    public ResponseEntity<Boolean> actualizarHerramienta(@PathVariable Integer id, @RequestBody HerramientaDTO herramientaDTO) {
        Herramienta herramienta = herramientaService.convertDtoToEntity(herramientaDTO);
        herramienta.setId(id);
        if (herramienta.getId() == null || !herramienta.getId().equals(id)) {
            return ResponseEntity.badRequest().body(false);
        }
        herramientaService.guardarHerramienta(herramienta);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Boolean> eliminarHerramienta(@PathVariable Integer id) {
        return ResponseEntity.ok(herramientaService.eliminarHerramienta(id));
    }


}
