package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TransaccionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_OperacionCuenta", referencedColumnName = "id")
    private OperacionCuenta id_OperacionCuenta;

    @ManyToOne
    @JoinColumn(name = "numeroCuenta", referencedColumnName = "numeroCuenta")
    private Cuenta numeroCuenta;

    public TransaccionPK() {
        super();
    }

    public TransaccionPK(OperacionCuenta id_OperacionCuenta, Cuenta numeroCuenta) {
        this.id_OperacionCuenta = id_OperacionCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    public OperacionCuenta getId_OperacionCuenta() {
        return id_OperacionCuenta;
    }

    public void setId_OperacionCuenta(OperacionCuenta id_OperacionCuenta) {
        this.id_OperacionCuenta = id_OperacionCuenta;
    }

    public Cuenta getId_Cuenta() {
        return numeroCuenta;
    }

    public void setId_Cuenta(Cuenta numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

}
