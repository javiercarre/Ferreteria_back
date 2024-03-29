package com.ferreteria_back.controller;

import com.ferreteria_back.entity.*;
import com.ferreteria_back.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListasController {

    @Autowired
    private RolService rolService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private TipoService tipoService;

    @GetMapping(value = "roles")
    public List<Rol> listarTodosLosRoles() {
        return rolService.findAll();
    }

    @GetMapping(value = "estados")
    public List<Estado> listarTodosLosEstados() {
        return estadoService.findAll();
    }

    @GetMapping(value = "marcas")
    public List<Marca> listarTodasLasMarcas() {
        return marcaService.findAll();
    }

    @GetMapping(value = "proveedores")
    public List<Proveedor> listarTodosLosProveedores() {
        return proveedorService.findAll();
    }

    @GetMapping(value = "tipos")
    public List<Tipo> listarTodosLosTipos() {
        return tipoService.findAll();
    }
}
