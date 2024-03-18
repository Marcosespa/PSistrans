package uniandes.edu.co.proyecto.modelo;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import oracle.net.aso.l;

@Entity
@Table(name = "prestamos")
public class Prestamo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String estadoPrestamo;

  private String tipoPrestamo;

  private double monto;

  private double interes;

  private int numeroCuotas;

  private String fechaPagoCuota;

  private double valorCuota;

  private double saldoPendiente;

  private String gerente;

  public Prestamo() {
    ;
  }

  public Prestamo(String estadoPrestamo, String tipoPrestamo, double monto, double interes,
      int numeroCuotas, String fechaPagoCuota, double valorCuota, double saldoPendiente, String gerente,
      Persona cliente) {
    this.estadoPrestamo = estadoPrestamo;
    this.tipoPrestamo = tipoPrestamo;
    this.monto = monto;
    this.interes = interes;
    this.numeroCuotas = numeroCuotas;
    this.fechaPagoCuota = fechaPagoCuota;
    this.valorCuota = valorCuota;
    this.saldoPendiente = saldoPendiente;
    this.gerente = gerente;
  }

  public Integer getId() {
    return id;
  }

  public String getEstadoPrestamo() {
    return estadoPrestamo;
  }

  public String getTipoPrestamo() {
    return tipoPrestamo;
  }

  public double getMonto() {
    return monto;
  }

  public double getInteres() {
    return interes;
  }

  public int getNumeroCuotas() {
    return numeroCuotas;
  }

  public String getFechaPagoCuota() {
    return fechaPagoCuota;
  }

  public double getValorCuota() {
    return valorCuota;
  }

  public double getSaldoPendiente() {
    return saldoPendiente;
  }

  public String getGerente() {
    return gerente;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setEstadoPrestamo(String estadoPrestamo) {
    this.estadoPrestamo = estadoPrestamo;
  }

  public void setTipoPrestamo(String tipoPrestamo) {
    this.tipoPrestamo = tipoPrestamo;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public void setInteres(double interes) {
    this.interes = interes;
  }

  public void setNumeroCuotas(int numeroCuotas) {
    this.numeroCuotas = numeroCuotas;
  }

  public void setFechaPagoCuota(String fechaPagoCuota) {
    this.fechaPagoCuota = fechaPagoCuota;
  }

  public void setValorCuota(double valorCuota) {
    this.valorCuota = valorCuota;
  }

  public void setSaldoPendiente(double saldoPendiente) {
    this.saldoPendiente = saldoPendiente;
  }

  public void setGerente(String gerente) {
    this.gerente = gerente;
  }

}
