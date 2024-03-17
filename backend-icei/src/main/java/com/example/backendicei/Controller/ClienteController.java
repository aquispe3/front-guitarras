package com.example.backendicei.Controller;


import com.example.backendicei.Entity.ClienteEntity;
import com.example.backendicei.Service.ClienteService;
import com.example.backendicei.dto.ResponsePruebaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clientePruebaService;

    @PostMapping(path = "/registrar")
    public ResponseEntity<?> registrar(@RequestBody ClienteEntity clientePruebaEntity){
        ResponsePruebaDto re =  clientePruebaService.registrar(clientePruebaEntity);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
    @PutMapping(path = "/modificar")
    public ResponseEntity<?> modificar(@RequestBody ClienteEntity clientePruebaEntity){
        ResponsePruebaDto re =  clientePruebaService.modificar(clientePruebaEntity);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id){
        ResponsePruebaDto re =  clientePruebaService.eliminar(id);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
    @GetMapping(path = "/obtener-todos")
    public ResponseEntity<?> modificar(){
        ResponsePruebaDto re =  clientePruebaService.obtenerTodos();
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
}
