package mx.edu.utez.recuperau1.models.viaje;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recuperau1.models.destino.Destino;
import mx.edu.utez.recuperau1.models.user.Usuario;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "viaje")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Viaje {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")

    private String fechaSalida;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")

    private String fechaRegreso;



}
