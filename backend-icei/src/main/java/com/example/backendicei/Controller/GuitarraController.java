package com.example.backendicei.Controller;



import com.example.backendicei.Entity.GuitarraEntity;
import com.example.backendicei.Service.GuitarraService;
import com.example.backendicei.dto.ResponsePruebaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/guitarra")
public class GuitarraController {

    @Autowired
    private GuitarraService guitarraPruebaService;

    @PostMapping(path = "/registrar")
    public ResponseEntity<?> registrar(@RequestBody GuitarraEntity guitarraPruebaEntity){
        ResponsePruebaDto re =  guitarraPruebaService.registrar(guitarraPruebaEntity);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
    @PutMapping(path = "/modificar")
    public ResponseEntity<?> modificar(@RequestBody GuitarraEntity guitarraPruebaEntity){
        ResponsePruebaDto re =  guitarraPruebaService.modificar(guitarraPruebaEntity);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id){
        ResponsePruebaDto re =  guitarraPruebaService.eliminar(id);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }

    @GetMapping(path = "/obtener-todos")
    public ResponseEntity<?> modificar(){
        ResponsePruebaDto re =  guitarraPruebaService.obtenerTodos();
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
}
