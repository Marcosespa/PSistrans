package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TienenCuenta")
public class TienenCuenta {
    @EmbeddedId
    private TienenCuentaPK pk;

    public TienenCuenta() {
        ;
    }

    public TienenCuenta(Prestamo id_Prestamo, Cliente numero_documento) {
        this.pk = new TienenCuentaPK(id_Prestamo, numero_documento);
    }

    public TienenCuentaPK getPk() {
        return pk;
    }

    public void setPk(TienenCuentaPK pk) {
        this.pk = pk;
    }

}
