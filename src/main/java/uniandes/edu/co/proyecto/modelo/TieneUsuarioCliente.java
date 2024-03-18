package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tienen_usuario_clientes")
public class TieneUsuarioCliente {
    @EmbeddedId
    private TieneUsuarioClientePK pk;

    public TieneUsuarioCliente(Cliente numero_documento, UsuarioCliente login) {
        this.pk = new TieneUsuarioClientePK(numero_documento, login);
    }

    public TieneUsuarioCliente() {;}

    public TieneUsuarioClientePK getPk() {
        return pk;
    }

    public void setPk(TieneUsuarioClientePK pk) {
        this.pk = pk;
    }

    
    
    
}
