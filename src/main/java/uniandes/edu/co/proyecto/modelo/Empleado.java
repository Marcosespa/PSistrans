package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String numero_documento;

  private String tipo; // Este se refiere a tipo de personas natural o juridica
  private String tipoDocumento;
  private String nombre;
  private String nacionalidad;
  private String direccionFisica;
  private String direccionElectronica;
  private String telefono;
  private String codigoPostal;
  private String ciudad;
  private String departamento;
  private String cargo;

  public Empleado() {
    ;
  }

  public Empleado(String numero_documento,String tipo, String tipoDocumento, String nombre, String nacionalidad,
      String direccionFisica, String direccionElectronica, String telefono, String codigoPostal, String ciudad,
      String departamento, String cargo) {
    this.numero_documento= numero_documento;
    this.tipo = tipo;
    this.tipoDocumento = tipoDocumento;
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
    this.direccionFisica = direccionFisica;
    this.direccionElectronica = direccionElectronica;
    this.telefono = telefono;
    this.codigoPostal = codigoPostal;
    this.ciudad = ciudad;
    this.departamento = departamento;
    this.cargo = cargo;
  }

  public String getNumeroDocumento() {
    return numero_documento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numero_documento = numeroDocumento;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getDireccionFisica() {
    return direccionFisica;
  }

  public void setDireccionFisica(String direccionFisica) {
    this.direccionFisica = direccionFisica;
  }

  public String getDireccionElectronica() {
    return direccionElectronica;
  }

  public void setDireccionElectronica(String direccionElectronica) {
    this.direccionElectronica = direccionElectronica;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

}
