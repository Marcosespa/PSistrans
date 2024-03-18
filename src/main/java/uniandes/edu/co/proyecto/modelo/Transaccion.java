package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacciones")
public class Transaccion {
    @EmbeddedId
    private TransaccionPK pk;

    public Transaccion() {
        ;
    }

    public Transaccion(OperacionCuenta idOperacionCuenta, Cuenta numeroCuenta) {
        this.pk = new TransaccionPK(idOperacionCuenta, numeroCuenta);
    }

    public TransaccionPK getPk() {
        return pk;
    }

    public void setPk(TransaccionPK pk) {
        this.pk = pk;
    }

}
