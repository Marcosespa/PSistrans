package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "operacionesPrestamo")
public abstract class OperacionPrestamo {

  
  private String tipoOperacion;

  private Date fecha;

  private String cuentaPrestamo;
  private String montoOperacion;
  private String cliente;

  public OperacionPrestamo() {
    ;
  }

  public OperacionPrestamo(String tipoOperacion, Date fecha, String cuentaPrestamo, String montoOperacion, String cliente) {
    this.tipoOperacion = tipoOperacion;
    this.fecha = fecha;
    this.cuentaPrestamo = cuentaPrestamo;
    this.montoOperacion = montoOperacion;
    this.cliente = cliente;
  }


public String getTipoOperacion() {
    return tipoOperacion;
  }

public Date getFecha() {
    return fecha;
  }

public String getCuentaPrestamo() {
    return cuentaPrestamo;
  }  

public String getMontoOperacion() {
    return montoOperacion;
  } 

public String getCliente() {
    return cliente;
  } 
}