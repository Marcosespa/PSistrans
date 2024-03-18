package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamoRealizadaPK;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface OperacionPrestamoRealizadaRepository extends JpaRepository<OperacionPrestamoRealizadaPK, String> {

    @Query(value = "SELECT * FROM tienen", nativeQuery = true)
    Collection<OperacionPrestamoRealizadaPK> darOperacionPrestamoRealizada();

    @Query(value = "SELECT * FROM tienen WHERE numeroCuenta= :numeroCuenta", nativeQuery = true)
    OperacionPrestamoRealizadaPK darOperacionPrestamoRealizada(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id = :id", nativeQuery = true)
    void eliminarOperacionPrestamoRealizada(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (id_Prestamo, id_Cliente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
    OperacionPrestamoRealizadaPK insertarOperacionPrestamoRealizada(
        @Param("id_operacion_prestamo") String idOperacionPrestamo,
        @Param("id_punto_atencion") String idPuntoAtencion
    );

}
