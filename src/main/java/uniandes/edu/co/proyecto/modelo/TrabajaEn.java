package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trabajanEn")
public class TrabajaEn {

    @EmbeddedId
    private TrabajaEnPK pk;

    public TrabajaEn() {
        ;
    }

    public TrabajaEn(Empleado numeroDocumento, Oficina id_Oficina) {
        this.pk = new TrabajaEnPK(numeroDocumento, id_Oficina);
    }

    public TrabajaEnPK getPk() {
        return pk;
    }

    public void setPk(TrabajaEnPK pk) {
        this.pk = pk;
    }

}
