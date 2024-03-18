package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.PuntoAtencion;

public interface PuntoAtencionRepository extends JpaRepository<PuntoAtencion, Integer> {

    @Query(value = "SELECT * FROM puntos_Atencion", nativeQuery = true)
    Collection<PuntoAtencion> darPuntosAtencion();

    @Query(value = "SELECT * FROM puntos_Atencion WHERE id = :id", nativeQuery = true)
    PuntoAtencion darPuntoAtencion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM puntos_Atencion WHERE id = :id", nativeQuery = true)
    void eliminarPuntoAtencion(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_Atencion (id, tipo, ciudad, horarioAtencion, direccion) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
    void insertarPuntoAtencion(
            @Param("tipo") String tipo,
            @Param("ciudad") String ciudad,
            @Param("horarioAtencion") String horarioAtencion,
            @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE puntos_Atencion SET tipo = :tipo, ciudad = :ciudad, horarioAtencion = :horarioAtencion, direccion = :direccion  WHERE id = :id", nativeQuery = true)
    void actualizarBebedor(@Param("id") long id, @Param("tipo") String tipo,
            @Param("ciudad") String ciudad,
            @Param("horarioAtencion") String horarioAtencion,
            @Param("direccion") String direccion);

}