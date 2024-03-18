package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "puntos_atencion")
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getHorarioAtencion() {
    return horarioAtencion;
  }

  public void setHorarioAtencion(String horarioAtencion) {
    this.horarioAtencion = horarioAtencion;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

}
