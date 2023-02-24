package mx.edu.utez.recuperau1.controller.viaje;


import mx.edu.utez.recuperau1.controller.viaje.dto.ViajeDto;
import mx.edu.utez.recuperau1.models.user.Usuario;
import mx.edu.utez.recuperau1.models.viaje.Viaje;
import mx.edu.utez.recuperau1.services.usuario.UsuarioService;
import mx.edu.utez.recuperau1.services.viaje.ViajeService;
import mx.edu.utez.recuperau1.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")
@CrossOrigin(origins = {"*"})
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Viaje>>> obtenerTodosLosViajes(){
        return new ResponseEntity<>(
                this.viajeService.obtenerTodosLosViajes(),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Viaje>> insert(
        @RequestBody ViajeDto viaje
    ){
        return new ResponseEntity<>(
                this.viajeService.insert(viaje.getViaje()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Viaje>> update(
            @RequestBody ViajeDto viaje
    ){
        return new ResponseEntity<>(
                this.viajeService.update(viaje.getViaje()),
                HttpStatus.OK
        );
    }

 /*   @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        viajeService.eliminarViaje(id);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Viaje>> eliminarUsuario(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                this.viajeService.eliminarViaje(id),
                HttpStatus.OK
                );
    }

}
