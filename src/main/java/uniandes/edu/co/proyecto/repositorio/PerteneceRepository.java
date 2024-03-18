package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.Pertenece;
import uniandes.edu.co.proyecto.modelo.PertenecePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;

public interface PerteneceRepository extends JpaRepository<Pertenece, PertenecePK> {
    @Query(value = "SELECT * FROM pertenecen", nativeQuery = true)
    Collection<Pertenece> darPertenecen();

    @Query(value = "SELECT * FROM pertenecen WHERE id_Oficina = :id_Oficina AND id_PuntoAtencion = :id_PuntoAtencion", nativeQuery = true)
    Pertenece darPertenecePorId(@Param("id_Oficina") String id_Oficina,
            @Param("id_PuntoAtencion") String id_PuntoAtencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pertenecen WHERE id_Oficina = :id_Oficina AND id_PuntoAtencion = :id_PuntoAtencion", nativeQuery = true)
    void elimnarPertenece(@Param("id_Oficina") String id_Oficina, @Param("id_PuntoAtencion") String id_PuntoAtencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE pertenecen SET id_Oficina = :id_Oficina_actualizado, id_PuntoAtencion = :id_PuntoAtencion_actualizado WHERE id_Oficina = :id_Oficina AND id_PuntoAtencion = :id_PuntoAtencion", nativeQuery = true)
    void actualizarFrecuentan(
            @Param("id_Oficina") String id_Oficina, @Param("id_PuntoAtencion") String id_PuntoAtencion,
            @Param("id_Oficina_actualizado") String id_Oficina_actualizado,
            @Param("id_PuntoAtencion_actualizado") String id_PuntoAtencion_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pertenecen (id_Oficina, id_PuntoAtencion) VALUES (:id_Oficina, :id_PuntoAtencion)", nativeQuery = true)
    void insertarFrecuentan(@Param("id_Oficina") String id_Oficina, @Param("id_PuntoAtencion") String id_PuntoAtencion);

}
