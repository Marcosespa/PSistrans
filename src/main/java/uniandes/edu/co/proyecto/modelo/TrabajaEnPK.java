package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class TrabajaEnPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    private Empleado numero_documento;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Oficina id;

    public TrabajaEnPK() {
        super();
    }

    public TrabajaEnPK(Empleado numero_documento, Oficina id) {
        this.numero_documento = numero_documento;
        this.id = id;
    }

    public Empleado getIdEmpleado() {
        return numero_documento;
    }

    public void setIdEmpleado(Empleado numero_documento) {
        this.numero_documento = numero_documento;
    }

    public Oficina getIdOficina() {
        return id;
    }

    public void setIdOficina(Oficina id) {
        this.id = id;
    }

}
