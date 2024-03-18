package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OperaPrestamoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id")
    private Prestamo id_prestamo;


    @ManyToOne
    @JoinColumn(name = "id_Operacion", referencedColumnName = "id")
    private OperacionPrestamo id_Operacion;

    public OperaPrestamoPK()
    {
        super();
    }

    public OperaPrestamoPK(Prestamo id_prestamo, OperacionPrestamo id_Operacion) {
        this.id_prestamo = id_prestamo;
        this.id_Operacion = id_Operacion;
    }

    public Prestamo getIdPrestamo() {
        return id_prestamo;
    }

    public void setIdPrestamo(Prestamo id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public OperacionPrestamo getIdOperaPrestamo() {
        return id_Operacion;
    }

    public void setIdOperaPrestamo(OperacionPrestamo id_Operacion) {
        this.id_Operacion = id_Operacion;
    }

    

}
