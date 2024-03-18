package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "operacionesPrestamoRealiazdas")
public class OperacionPrestamoRealizada {
    @EmbeddedId
    private OperacionPrestamoRealizadaPK pk;

    public OperacionPrestamoRealizada() {
        ;
    }

    public OperacionPrestamoRealizada(OperacionPrestamo id_Operacion_Prestamo, PuntoAtencion id_Punto_Atencion) {
        this.pk = new OperacionPrestamoRealizadaPK(id_Operacion_Prestamo, id_Punto_Atencion);
    }

    public OperacionPrestamoRealizadaPK getPk() {
        return pk;
    }

    public void setPk(OperacionPrestamoRealizadaPK pk) {
        this.pk = pk;
    }

}
