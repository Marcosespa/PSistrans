package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

  @Query(value = "SELECT * FROM prestamos", nativeQuery = true)
  Collection<Prestamo> darPrestamos();

  @Query(value = "SELECT * FROM prestamos WHERE id = :id", nativeQuery = true)
  Prestamo darPrestamo(@Param("id") int id);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery = true)
  void eliminaPrestamo(@Param("id") long id);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO prestamos (id, estado, tipo, monto,interes,numero_cuotas,dia_mes_pagar_cuota, valor_cuota, gerente_creador, saldo_pendiente)  \r\n" + //
                "VALUES(proyecto_sequence.nextval, :estado, :tipo, :monto,:interes,:numero_cuotas,:dia_mes_pagar_cuota, :valor_cuota, :gerente_creador, :saldo_pendiente) ", nativeQuery = true)
  void  insertarOficina(@Param("estado") String estado,
      @Param("tipo") String tipo,
      @Param("monto") double monto,
      @Param("interes") double interes,
      @Param("numero_cuotas") int numero_cuotas,
      @Param("dia_mes_pagar_cuota") String dia_mes_pagar_cuota,
      @Param("valor_cuota") double valor_cuota,
      @Param("gerente_creador") String gerente_creador,
      @Param("saldo_pendiente") double saldo_pendiente);

  @Modifying
  @Transactional
  @Query(value = "UPDATE prestamos SET estado= :estado , tipo= :tipo, monto =:monto,interes=:interes,numero_cuotas =:numero_cuotas ,dia_mes_pagar_cuota =:dia_mes_pagar_cuota,valor_cuota=:valor_cuota,gerente_creador =:gerente_creador,saldo_pendiente =:saldo_pendiente WHERE id = :id", nativeQuery = true)
  void  actualizarOficina(@Param("id") long id,@Param("estado") String estado,
      @Param("tipo") String tipo,
      @Param("monto") Integer monto,
      @Param("interes") Empleado interes,
      @Param("numero_cuotas") String numero_cuotas,
      @Param("dia_mes_pagar_cuota") String dia_mes_pagar_cuota,
      @Param("valor_cuota") Integer valor_cuota,
      @Param("gerente_creador") Empleado gerente_creador,
      @Param("saldo_pendiente") String saldo_pendiente);


  
  
}