package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "opera_prestamo")
public class OperaPrestamo {
    @EmbeddedId
    private OperaPrestamoPK pk;

    public OperaPrestamo() {
        ;
    }

    public OperaPrestamo(Prestamo id_prestamo, OperacionPrestamo id_Operacion) {
        this.pk = new OperaPrestamoPK(id_prestamo, id_Operacion);
    }

    public OperaPrestamoPK getPk() {
        return pk;
    }

    public void setPk(OperaPrestamoPK pk) {
        this.pk = pk;
    }

}
