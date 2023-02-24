package mx.edu.utez.recuperau1.controller.destino;

import mx.edu.utez.recuperau1.models.destino.Destino;
import mx.edu.utez.recuperau1.services.destino.DestinoService;
import mx.edu.utez.recuperau1.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
@CrossOrigin(origins = {"*"})
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Destino>>> obtenerTodosLosDestinos(){
        return new ResponseEntity<>(
                this.destinoService.obtenerTodosLosDestinos(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Destino obtenerDestinoPorId(@PathVariable Long id) {
        return destinoService.obtenerDestinoPorId(id);
    }

    // otros métodos para crear, actualizar y eliminar destinos
}

