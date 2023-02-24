package mx.edu.utez.recuperau1.controller.usuario;

import mx.edu.utez.recuperau1.controller.usuario.dto.UsuarioDto;
import mx.edu.utez.recuperau1.models.user.Usuario;
import mx.edu.utez.recuperau1.services.usuario.UsuarioService;
import mx.edu.utez.recuperau1.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = {"*"})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Usuario>>> obtenerTodosLosUsuarios(){
        return new ResponseEntity<>(
                this.usuarioService.obtenerTodosLosUsuarios(),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Usuario>> insert(
            @RequestBody UsuarioDto user
            ){
        return new ResponseEntity<>(
                this.usuarioService.insert(user.getUsuario()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Usuario>> update(
            @RequestBody UsuarioDto user
    ){
        return new ResponseEntity<>(
                this.usuarioService.update(user.getUsuario()),
                HttpStatus.OK
        );
    }

 /*   @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        viajeService.eliminarViaje(id);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Usuario>> eliminarUsuario(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                this.usuarioService.eliminarUsuario(id),
                HttpStatus.OK
        );
    }



}
