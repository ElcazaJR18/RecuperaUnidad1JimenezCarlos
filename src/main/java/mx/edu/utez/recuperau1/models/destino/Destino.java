package mx.edu.utez.recuperau1.models.destino;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recuperau1.models.user.Usuario;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "destino")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private double calificacion;

    private boolean disponibilidad;




}
