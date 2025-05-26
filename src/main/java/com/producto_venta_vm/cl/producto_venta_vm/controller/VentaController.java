package com.producto_venta_vm.cl.producto_venta_vm.controller;

import com.producto_venta_vm.cl.producto_venta_vm.model.Venta;
import com.producto_venta_vm.cl.producto_venta_vm.service.UsuarioService;
import com.producto_venta_vm.cl.producto_venta_vm.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestHeader("Authorization") String token,@RequestBody Venta venta){
        try{
            UsuarioDTO usuario = usuarioService.validarToken(token);
            venta.setIdUsuario(usuario.getId());
            
        }
    }

}
