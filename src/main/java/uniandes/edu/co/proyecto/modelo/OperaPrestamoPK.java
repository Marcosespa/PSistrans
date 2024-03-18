package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OperaPrestamoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id")
    private Prestamo idPrestamo;


    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private OperaPrestamo idOperaPrestamo;

    public OperaPrestamoPK()
    {
        super();
    }

    public OperaPrestamoPK(Prestamo idPrestamo, OperaPrestamo idOperaPrestamo) {
        this.idPrestamo = idPrestamo;
        this.idOperaPrestamo = idOperaPrestamo;
    }

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public OperaPrestamo getIdOperaPrestamo() {
        return idOperaPrestamo;
    }

    public void setIdOperaPrestamo(OperaPrestamo idOperaPrestamo) {
        this.idOperaPrestamo = idOperaPrestamo;
    }

    

}
