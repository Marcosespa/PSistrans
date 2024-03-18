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
import uniandes.edu.co.proyecto.modelo.TrabajaEn;
import uniandes.edu.co.proyecto.modelo.TrabajaEnPK;

import java.sql.Date;
import java.util.Collection;

public interface TrabajaEnRepository extends JpaRepository<TrabajaEn, TrabajaEnPK> {
        @Query(value = "SELECT * FROM trabajan", nativeQuery = true)
        Collection<Pertenece> darPertenecen();

        @Query(value = "SELECT * FROM trabajan WHERE id_Oficina = :id_Oficina AND id_Empleado = :id_Empleado", nativeQuery = true)
        Pertenece darPertenecePorId(@Param("id_Oficina") String id_Oficina,
                        @Param("id_Empleado") String id_Empleado);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM trabajan WHERE id_Oficina = :id_Oficina AND id_Empleado = :id_Empleado", nativeQuery = true)
        void elimnarPertenece(@Param("id_Oficina") String id_Oficina,
                        @Param("id_Empleado") String id_Empleado);

        @Modifying
        @Transactional
        @Query(value = "UPDATE trabajan SET id_Oficina = :id_Oficina_actualizado, id_Empleado = :id_Empleado_actualizado WHERE id_Oficina = :id_Oficina AND id_Empleado = :id_Empleado", nativeQuery = true)
        void actualizarFrecuentan(
                        @Param("id_Oficina") String id_Oficina, @Param("id_Empleado") String id_Empleado,
                        @Param("id_Oficina_actualizado") String id_Oficina_actualizado,
                        @Param("id_Empleado_actualizado") String id_Empleado_actualizado);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO trabaja (id_Oficina, id_Empleado) VALUES (:id_Oficina, :id_Empleado)", nativeQuery = true)
        void insertarFrecuentan(@Param("id_Oficina") String id_Oficina,
                        @Param("id_Empleado") String id_Empleado);

}
