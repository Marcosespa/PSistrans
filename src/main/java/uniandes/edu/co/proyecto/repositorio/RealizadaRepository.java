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
import uniandes.edu.co.proyecto.modelo.Realizada;
import uniandes.edu.co.proyecto.modelo.RealizadaPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;

public interface RealizadaRepository extends JpaRepository<Realizada, RealizadaPK> {
        @Query(value = "SELECT * FROM realizadas", nativeQuery = true)
        Collection<Realizada> darPertenecen();

        @Query(value = "SELECT * FROM realizadas WHERE idOperacionCuenta = :idOperacionCuenta AND idPuntoAtencion = :idPuntoAtencion", nativeQuery = true)
        Pertenece darPertenecePorId(@Param("idOperacionCuenta") String idOperacionCuenta,
                        @Param("idPuntoAtencion") String idPuntoAtencion);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM realizadas WHERE idOperacionCuenta = :idOperacionCuenta AND id_PuntoAtencion = :id_PuntoAtencion", nativeQuery = true)
        void elimnarPertenece(@Param("idOperacionCuenta") String idOperacionCuenta,
                        @Param("id_PuntoAtencion") String id_PuntoAtencion);

        @Modifying
        @Transactional
        @Query(value = "UPDATE realizadas SET idOperacionCuenta = :idOperacionCuenta_actualizado, id_PuntoAtencion = :id_PuntoAtencion_actualizado WHERE idOperacionCuenta = :idOperacionCuenta AND id_PuntoAtencion = :id_PuntoAtencion", nativeQuery = true)
        void actualizarFrecuentan(
                        @Param("idOperacionCuenta") String idOperacionCuenta,
                        @Param("id_PuntoAtencion") String id_PuntoAtencion,
                        @Param("idOperacionCuenta_actualizado") String idOperacionCuenta_actualizado,
                        @Param("id_PuntoAtencion_actualizado") String id_PuntoAtencion_actualizado);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO pertenecen (idOperacionCuenta, id_PuntoAtencion) VALUES (:idOperacionCuenta, :id_PuntoAtencion)", nativeQuery = true)
        void insertarFrecuentan(@Param("idOperacionCuenta") String idOperacionCuenta,
                        @Param("id_PuntoAtencion") String id_PuntoAtencion);

}
