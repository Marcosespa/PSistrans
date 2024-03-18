package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

    @Query(value = "SELECT * FROM empleados", nativeQuery = true)
    Collection<Empleado> darEmpleado();

    @Query(value = "SELECT * FROM empleados WHERE numero_documento = :numero_documento AND login = :login AND cargo = :cargo", nativeQuery = true)
    Empleado darEmpleadoPorId(@Param("numero_documento") String numero_documento, @Param("login") String login,@Param("cargo") String cargo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE numero_documento = :numero_documento AND login = :login AND cargo = :cargo", nativeQuery = true)
    void eliminarEmpleado(@Param("numero_documento") String numero_documento, @Param("login") String login,@Param("cargo") String cargo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET numero_documento = :numero_documento_actualizado AND login = :login_actualizado AND cargo = :cargo_actualizado WHERE numero_documento = :numero_documento AND login = :login AND cargo = :cargo", nativeQuery = true)
    void actualizarEmpleado(@Param("numero_documento") String numero_documento, @Param("login") String login,@Param("cargo") String cargo, 
                            @Param("numero_documento_actualizado") String numero_documento_actualizado, @Param("login_actualizado") String login_actualizado,@Param("cargo_actualizado") String cargo_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (numero_documento, login,cargo) VALUES (:numero_documento, :login, :cargo)", nativeQuery = true)
    void insertarEmpleado(@Param("numero_documento") String numero_documento, @Param("login") String login,@Param("cargo") String cargo);

    
}
