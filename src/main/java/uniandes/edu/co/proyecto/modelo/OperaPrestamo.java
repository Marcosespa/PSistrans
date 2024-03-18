package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operan")
public class OperaPrestamo {
    @EmbeddedId
    private OperaPrestamoPK pk;

    public OperaPrestamo() {
        ;
    }

    public OperaPrestamo(Prestamo id_Prestamo, OperaPrestamo id_Opera_Prestamo) {
        this.pk = new OperaPrestamoPK(id_Prestamo, id_Opera_Prestamo);
    }

    public OperaPrestamoPK getPk() {
        return pk;
    }

    public void setPk(OperaPrestamoPK pk) {
        this.pk = pk;
    }

}
