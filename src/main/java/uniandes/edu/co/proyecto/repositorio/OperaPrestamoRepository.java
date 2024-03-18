package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.modelo.OperacionPrestamoRealizada;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperaPrestamoPK;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface OperaPrestamoRepository extends JpaRepository< OperaPrestamo, OperaPrestamoPK> {

    @Query(value = "SELECT * FROM operacionesPrestamoRealizada", nativeQuery = true)
    Collection<OperacionPrestamo> darOperacionPrestamo();

    @Query(value = "SELECT * FROM operacionesPrestamoRealizada WHERE numeroCuenta= :numeroCuenta", nativeQuery = true)
    OperacionPrestamo darOperacionPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operacionesPrestamoRealizada WHERE id = :id", nativeQuery = true)
    void eliminarOperacionPrestamo(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operacionesPrestamoRealizada (id_Prestamo, id_Cliente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
    OperacionCuenta insertarOperacionPrestamo(
            @Param("id_prestamo") String id_Prestamo,
            @Param("id_cliente") String id_Operacion_Cliente);

}
