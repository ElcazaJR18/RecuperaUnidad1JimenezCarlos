package mx.edu.utez.recuperau1.controller.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recuperau1.models.user.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String fechaNacimiento;
    public Usuario getUsuario() {
        return new Usuario(getId(),getNombre(),getCorreoElectronico(),getFechaNacimiento() );
    }
}
