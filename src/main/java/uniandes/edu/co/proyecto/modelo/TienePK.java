package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TienePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id")
    private Prestamo id_prestamo;


    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "numero_documento")
    private Cliente id_cliente;

    public TienePK()
    {
        super();
    }

    public TienePK(Prestamo id_prestamo, Cliente id_cliente) {
        this.id_prestamo = id_prestamo;
        this.id_cliente = id_cliente;
    }

    public Prestamo getIdPrestamo() {
        return id_prestamo;
    }

    public void setIdPrestamo(Prestamo id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Cliente getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    

}
