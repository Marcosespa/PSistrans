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
import uniandes.edu.co.proyecto.modelo.Transaccion;
import uniandes.edu.co.proyecto.modelo.TransaccionPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
        @Query(value = "SELECT * FROM transacciones", nativeQuery = true)
        Collection<Transaccion> darTransacciones();

        @Query(value = "SELECT * FROM transacciones WHERE idOperacionCuenta = :idOperacionCuenta AND id_Cuenta = :id_Cuenta", nativeQuery = true)
        Pertenece darTransaccion(@Param("idOperacionCuenta") long idOperacionCuenta,
                        @Param("id_Cuenta") long id_Cuenta);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM transacciones WHERE idOtransaccionesperacionCuenta = :idOperacionCuenta AND id_Cuenta = :id_Cuenta", nativeQuery = true)
        void eliminarTransaccion(@Param("idOperacionCuenta") long idOperacionCuenta,
                        @Param("id_Cuenta") long id_Cuenta);

        @Modifying
        @Transactional
        @Query(value = "UPDATE transacciones SET idOperacionCuenta = :idOperacionCuenta_actualizado, id_Cuenta = :id_Cuenta_actualizado WHERE idOperacionCuenta = :idOperacionCuenta AND id_Cuenta = :id_Cuenta", nativeQuery = true)
        void actualizarTransaccion(
                        @Param("idOperacionCuenta") long idOperacionCuenta,
                        @Param("id_Cuenta") long id_Cuenta,
                        @Param("idOperacionCuenta_actualizado") long idOperacionCuenta_actualizado,
                        @Param("id_Cuenta_actualizado") long id_Cuenta_actualizado);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO pertenecen (idOperacionCuenta, id_Cuenta) VALUES (:idOperacionCuenta, :id_Cuenta)", nativeQuery = true)
        void insertaTransaccion(@Param("idOperacionCuenta") long idOperacionCuenta,
                        @Param("id_Cuenta") long id_Cuenta);

}
