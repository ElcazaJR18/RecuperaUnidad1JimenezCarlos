package mx.edu.utez.recuperau1.services.viaje;

import mx.edu.utez.recuperau1.models.user.Usuario;
import mx.edu.utez.recuperau1.models.user.UsuarioRepository;
import mx.edu.utez.recuperau1.models.viaje.Viaje;
import mx.edu.utez.recuperau1.models.viaje.ViajeRepository;
import mx.edu.utez.recuperau1.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ViajeService {
    @Autowired
    private ViajeRepository viajeRepository;

    @Transactional(readOnly = true)
    public Response<List<Viaje>> obtenerTodosLosViajes() {
        return new Response<>(
                this.viajeRepository.findAll(), false, 200, "ok"
        );
    }

  /*  public Viaje guardarViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }*/

 /*   @Transactional(readOnly = true)
    public Response<List<Viaje>> guardarViajes(Viaje viaje) {
        return  new Response<>(
                this.viajeRepository.save(viaje),false, 200, "ok"
        );
    }*/

    @Transactional(rollbackFor = {SQLException.class})
    public  Response<Viaje> insert(Viaje viaje){
        Optional<Viaje> exist = this.viajeRepository.findById(viaje.getId());
        if (exist.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "La categoria ya se encuentra registrada"
            );
        return new Response<>(
                this.viajeRepository.saveAndFlush(viaje),
                false,
                200,"categoria registrada correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public  Response<Viaje> update(Viaje viaje){
        Optional<Viaje> exist = this.viajeRepository.findById(viaje.getId());
        if (exist.isPresent())
            return new Response<>(
                    this.viajeRepository.saveAndFlush(viaje),
                    true,
                    200,
                    "La actualización fue correcta"
            );
        return new Response<>(
                null,
                false,
                400,"No se pudo actualizar"
        );
    }

 /*   public void eliminarViaje(Long id) {
        viajeRepository.deleteById(id);
    }*/
 @Transactional(rollbackFor = {SQLException.class})
 public  Response<Viaje> eliminarViaje(Long id) {
     Optional<Viaje> exist = this.viajeRepository.findById(id);
     if (exist.isPresent()) {
         this.viajeRepository.deleteById(id);
         return new Response<>(
                 null,
                 true,
                 400,
                 "El viaje se elimino"
         );
     }
     return new Response<>(
             null,
             false,
             200,"No se encontro el viaje"
     );
 }

}
