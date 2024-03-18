package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TienenCuentaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id")
    private Prestamo idPrestamo;


    @ManyToOne
    @JoinColumn(name = "numero_documnto", referencedColumnName = "id")
    private Cliente numero_documento;

    public TienenCuentaPK()
    {
        super();
    }

    public TienenCuentaPK(Prestamo idPrestamo, Cliente numero_documento) {
        this.idPrestamo = idPrestamo;
        this.numero_documento = numero_documento;
    }

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Cliente getNumeroDocumento() {
        return numero_documento;
    }

    public void setNumeroDocumento(Cliente numero_documento) {
        this.numero_documento = numero_documento;
    }

    

}
