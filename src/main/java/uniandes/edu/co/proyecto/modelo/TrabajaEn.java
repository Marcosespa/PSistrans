package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trabajan_en")
public class TrabajaEn {

    @EmbeddedId
    private TrabajaEnPK pk;

    public TrabajaEn() {
        ;
    }

    public TrabajaEn(Empleado numeroDocumento, Oficina id) {
        this.pk = new TrabajaEnPK(numeroDocumento, id);
    }

    public TrabajaEnPK getPk() {
        return pk;
    }

    public void setPk(TrabajaEnPK pk) {
        this.pk = pk;
    }

}
