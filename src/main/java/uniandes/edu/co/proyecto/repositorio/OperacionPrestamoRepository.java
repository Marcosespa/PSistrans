package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamo, String> {

    @Query(value = "SELECT * FROM tienen", nativeQuery = true)
    Collection<OperacionPrestamo> darOperacionCuenta();

    @Query(value = "SELECT * FROM tienen WHERE numeroCuenta= :numeroCuenta", nativeQuery = true)
    OperacionPrestamo darOperacionPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id = :id", nativeQuery = true)
    void eliminarOperacionPrestamo(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (id_Prestamo, id_Cliente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
    OperacionPrestamo insertarOperacionPrestamo(
        @Param("tipo_Operacion") String tipoOperacion,
        @Param("fecha") Date fecha,
        @Param("cuentaPrestamo") String cuentaPrestamo,
        @Param("montoOperacion") String montoOperacion,
        @Param("cliente") String cliente);


}
