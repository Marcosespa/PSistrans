package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "puntos_Atencion")
public class PuntoAtencion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String tipo;

  private String ciudad;

  private String horarioAtencion;

  private String direccion;

  public PuntoAtencion() {
    ;
  }

  public PuntoAtencion(String tipo, String ciudad, String horarioAtencion, String direccion) {
    this.tipo = tipo;
    this.ciudad = ciudad;
    this.horarioAtencion = horarioAtencion;
    this.direccion = direccion;
  }

}
