package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "operaciones_prestamos")
public abstract class OperacionPrestamo {
  @Id
  private Integer id;
  private String tipoOperacion;

  private Date fecha;

  private String cuentaPrestamo;
  private double montoOperacion;
  private String cliente;

  public OperacionPrestamo() {
    ;
  }

  public OperacionPrestamo(String tipoOperacion, Date fecha, String cuentaPrestamo, double montoOperacion, String cliente) {
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

public double getMontoOperacion() {
    return montoOperacion;
  } 

public String getCliente() {
    return cliente;
  } 
}