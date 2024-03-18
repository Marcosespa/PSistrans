package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tienen_usuario_clientes")
public class TieneUsuarioCliente {
    @EmbeddedId
    private TieneUsuarioClientePK pk;

    public TieneUsuarioCliente(TieneUsuarioClientePK pk) {
        this.pk = pk;
    }

    public TieneUsuarioCliente() {;}

    public TieneUsuarioClientePK getPk() {
        return pk;
    }

    public void setPk(TieneUsuarioClientePK pk) {
        this.pk = pk;
    }

    
    
    
}
