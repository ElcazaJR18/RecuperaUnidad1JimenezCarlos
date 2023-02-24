package mx.edu.utez.recuperau1.controller.viaje.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recuperau1.models.destino.Destino;
import mx.edu.utez.recuperau1.models.user.Usuario;
import mx.edu.utez.recuperau1.models.viaje.Viaje;

import javax.persistence.*;
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
public class ViajeDto {
    private Long id;
    private Usuario usuario;
    private Destino destino;
    private String fechaSalida;
    private String fechaRegreso;

    public Viaje getViaje() {
        return new Viaje(getId(), getUsuario(), getDestino(), getFechaSalida(), getFechaRegreso());
    }
}