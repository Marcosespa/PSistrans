package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TieneUsuarioClientePK  implements Serializable {

    @ManyToOne
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    private Cliente numero_documento;


    @ManyToOne
    @JoinColumn(name = "login", referencedColumnName = "login")
    private UsuarioCliente login;


    

    public TieneUsuarioClientePK(Cliente numero_documento, UsuarioCliente login) {
        super();
        this.numero_documento = numero_documento;
        this.login = login;
    }


    public Cliente getNumero_documento() {
        return numero_documento;
    }


    public void setNumero_documento(Cliente numero_documento) {
        this.numero_documento = numero_documento;
    }


    public UsuarioCliente getLogin() {
        return login;
    }


    public void setLogin(UsuarioCliente login) {
        this.login = login;
    }

    

    
}
