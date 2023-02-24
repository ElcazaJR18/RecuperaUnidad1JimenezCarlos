package mx.edu.utez.recuperau1.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import mx.edu.utez.recuperau1.models.destino.Destino;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correoElectronico;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")

    private String fechaNacimiento;



}
