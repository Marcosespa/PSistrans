package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TienePK;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface TieneRepository extends JpaRepository<TienePK, String> {

    @Query(value = "SELECT * FROM tienen", nativeQuery = true)
    Collection<TienePK> darTienen();

    @Query(value = "SELECT * FROM tienen WHERE numeroCuenta= :numeroCuenta", nativeQuery = true)
    TienePK darTienen(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id = :id", nativeQuery = true)
    void eliminarTienen(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (id_Prestamo, id_Cliente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
    OperacionCuenta insertarTienen(
            @Param("id_prestamo") String id_Prestamo,
            @Param("id_cliente") String id_Cliente);


}
