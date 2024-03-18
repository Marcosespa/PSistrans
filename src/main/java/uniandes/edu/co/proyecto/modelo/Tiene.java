package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tienen")
public class Tiene {
    @EmbeddedId
    private TienePK pk;

    public Tiene() {
        ;
    }

    public Tiene(Prestamo id_Prestamo, Cliente id_Cliente) {
        this.pk = new TienePK(id_Prestamo, id_Cliente);
    }

    public TienePK getPk() {
        return pk;
    }

    public void setPk(TienePK pk) {
        this.pk = pk;
    }

}
