package mx.edu.utez.recuperau1.services.usuario;

import mx.edu.utez.recuperau1.models.destino.Destino;
import mx.edu.utez.recuperau1.models.user.Usuario;
import mx.edu.utez.recuperau1.models.user.UsuarioRepository;
import mx.edu.utez.recuperau1.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Response<List<Usuario>> obtenerTodosLosUsuarios() {
        return new Response<>(
                this.usuarioRepository.findAll(), false, 200, "ok"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public  Response<Usuario> insert(Usuario user){
        Optional<Usuario> exist = this.usuarioRepository.findById(user.getId());
        if (exist.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "El usuario ya se encuentra registrado"
            );
        return new Response<>(
                this.usuarioRepository.saveAndFlush(user),
                false,
                200,"Usuario registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public  Response<Usuario> update(Usuario user){
        Optional<Usuario> exist = this.usuarioRepository.findById(user.getId());
        if (exist.isPresent())
            return new Response<>(
                    this.usuarioRepository.saveAndFlush(user),
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

    /*   public void eliminarUsuario(Long id) {
           UsuarioRepository.deleteById(id);
       }*/
    @Transactional(rollbackFor = {SQLException.class})
    public  Response<Usuario> eliminarUsuario(Long id) {
        Optional<Usuario> exist = this.usuarioRepository.findById(id);
        if (exist.isPresent()) {
            this.usuarioRepository.deleteById(id);
            return new Response<>(
                    null,
                    true,
                    400,
                    "El Usuario se elimino"
            );
        }
        return new Response<>(
                null,
                false,
                200,"No se encontro el Usuario"
        );
    }



    // otros métodos para crear, actualizar y eliminar usuarios
}

