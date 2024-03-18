package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TrabajaEnPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    private Empleado numero_documento;

    @ManyToOne
    @JoinColumn(name = "id_Oficina", referencedColumnName = "id")
    private Oficina id_Oficina;

    public TrabajaEnPK() {
        super();
    }

    public TrabajaEnPK(Empleado numero_documento, Oficina id_Oficina) {
        this.numero_documento = numero_documento;
        this.id_Oficina = id_Oficina;
    }

    public Empleado getIdEmpleado() {
        return numero_documento;
    }

    public void setIdEmpleado(Empleado numero_documento) {
        this.numero_documento = numero_documento;
    }

    public Oficina getIdOficina() {
        return id_Oficina;
    }

    public void setIdOficina(Oficina id_Oficina) {
        this.id_Oficina = id_Oficina;
    }

}
