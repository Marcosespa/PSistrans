package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TrabajaEnPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "numeroDocumento", referencedColumnName = "numeroDocumento")
    private Empleado numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "id_Oficina", referencedColumnName = "id")
    private Oficina idOficina;

    public TrabajaEnPK() {
        super();
    }

    public TrabajaEnPK(Empleado numeroDocumento, Oficina idOficina) {
        this.numeroDocumento = numeroDocumento;
        this.idOficina = idOficina;
    }

    public Empleado getIdEmpleado() {
        return numeroDocumento;
    }

    public void setIdEmpleado(Empleado numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Oficina getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Oficina idOficina) {
        this.idOficina = idOficina;
    }

}
