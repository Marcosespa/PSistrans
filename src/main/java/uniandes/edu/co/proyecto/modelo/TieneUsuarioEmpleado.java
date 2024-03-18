package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tienen_usuario_empleados")
public class TieneUsuarioEmpleado {
    @EmbeddedId
    private TieneUsuarioEmpleadoPK pk;

    public TieneUsuarioEmpleado(TieneUsuarioEmpleadoPK pk) {
        this.pk = pk;
    }

    public TieneUsuarioEmpleadoPK getPk() {
        return pk;
    }

    public void setPk(TieneUsuarioEmpleadoPK pk) {
        this.pk = pk;
    }

    
    
}
