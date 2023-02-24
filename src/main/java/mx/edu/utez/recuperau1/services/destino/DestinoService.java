package mx.edu.utez.recuperau1.services.destino;

import mx.edu.utez.recuperau1.models.destino.Destino;
import mx.edu.utez.recuperau1.models.destino.DestinoRepository;
import mx.edu.utez.recuperau1.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

   /* public List<Destino> obtenerTodosLosDestinos() {
        return destinoRepository.findAll();
    }*/
    @Transactional(readOnly = true)
    public Response<List<Destino>> obtenerTodosLosDestinos() {
        return new Response<>(
                this.destinoRepository.findAll(), false, 200, "ok"
        );
    }

    public Destino obtenerDestinoPorId(Long id) {
        return destinoRepository.findById(id).orElse(null);
    }

    // otros métodos para crear, actualizar y eliminar destinos
}
