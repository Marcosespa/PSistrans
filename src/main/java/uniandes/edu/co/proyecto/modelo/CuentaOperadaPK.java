package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class CuentaOperadaPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "id_operacion", referencedColumnName = "id")
    private OperacionCuenta idOperacion;

    @OneToOne
    @JoinColumn(name = "numeroCuenta", referencedColumnName = "numero_cuenta")
    private Cuenta numeroCuenta;

    public CuentaOperadaPK() {
        super();
    }

    public CuentaOperadaPK(OperacionCuenta idOperacion, Cuenta numeroCuenta) {
        this.idOperacion = idOperacion;
        this.numeroCuenta = numeroCuenta;
    }

    public OperacionCuenta getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(OperacionCuenta idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Cuenta getIdCuenta() {
        return numeroCuenta;
    }

    public void setIdCuenta(Cuenta numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

}
