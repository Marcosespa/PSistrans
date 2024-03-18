package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficinas")
public class Oficina {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String nombre;

  private String direccion;

  private Integer numPuntosAtencion;

  private String ciudad;

  private Empleado gerente;

  public Oficina() {
    ;
  }

  public Oficina(String nombre, String direccion, Integer numPuntosAtencion, String ciudad, Empleado gerente) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.numPuntosAtencion = numPuntosAtencion;
    this.ciudad = ciudad;
    this.gerente = gerente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Integer getNumPuntosAtencion() {
    return numPuntosAtencion;
  }

  public void setNumPuntosAtencion(Integer numPuntosAtencion) {
    this.numPuntosAtencion = numPuntosAtencion;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Empleado getGerente() {
    return gerente;
  }

  public void setGerente(Empleado gerente) {
    this.gerente = gerente;
  }

}
