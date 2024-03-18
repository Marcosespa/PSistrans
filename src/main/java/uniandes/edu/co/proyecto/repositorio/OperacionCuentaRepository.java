package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta, Integer> {

        @Query(value = "SELECT * FROM operaciones_cuentas", nativeQuery = true)
        Collection<OperacionCuenta> darOperacionesCuentas();

        @Query(value = "SELECT * FROM operaciones_cuentas WHERE id= :id", nativeQuery = true)
        OperacionCuenta darOperacionCuenta(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM operaciones_cuentas WHERE id = :id", nativeQuery = true)
        void eliminarBebedor(@Param("id") long id);

        @Query(value = "INSERT INTO operaciones_cuentas (id, tipo_operacion, fecha,cuenta_salida, monto_operacion , cliente, punto_atencion,cuenta_llegada) VALUEs(proyecto_sequence.nextval) ", nativeQuery = true)
        void insertarOperacionCuenta(@Param("tipo_operacion") String tipoOperacion,
                        @Param("fecha") Date fecha,
                        @Param("cuenta_salida") String cuentaSalida,
                        @Param("monto_operacion") String montoOperacion,
                        @Param("cliente") Date cliente,
                        @Param("punto_atencion") String puntoAtencion,
                        @Param("cuenta_llegada") String cuentaLlegada);

        @Modifying
        @Transactional
        @Query(value = "UPDATE operaciones_cuentas SET tipo_operacion = :tipo_operacion, fecha = :fecha, cuenta_salida = :cuenta_salida, monto_operacion=: monto_operacion,cliente=: cliente,punto_atencion :=punto_atencion, cuenta_llegada:=cuenta_llegada WHERE id = :id", nativeQuery = true)
        void actualizarOperacionCuenta(
                        @Param("id") long id,
                        @Param("tipo_operacion") String tipoOperacion,
                        @Param("fecha") Date fecha,
                        @Param("cuenta_salida") String cuentaSalida,
                        @Param("monto_operacion") String montoOperacion,
                        @Param("cliente") Date cliente,
                        @Param("punto_atencion") String puntoAtencion,
                        @Param("cuenta_llegada") String cuentaLlegada);

}
