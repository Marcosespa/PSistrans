package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darCliente();

    @Query(value = "SELECT * FROM clientes WHERE numero_documento=:numero_documento AND login = :login", nativeQuery = true)
    Cliente darClientePorId(@Param("numero_documento") String numero_documento, @Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE numero_documento=:numero_documento AND login = :login", nativeQuery = true)
    void eliminarCliente(@Param("numero_documento") String numero_documento, @Param("login") String login);

    @Modifying  
    @Transactional
    @Query(value = "UPDATE clientes SET numero_documento = :numero_documento_actualizado, login = :login_actualizado WHERE numero_documento = :numero_documento AND login = :login", nativeQuery = true)
    void actualizarCliente(@Param("numero_documento") String numero_documento, @Param("login") String login,@Param("numero_documento_actualizado") String numero_documento_actualizado, @Param("login_actualizado") String login_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (numero_documento, login) VALUES (:numero_documento, :login)", nativeQuery = true)
    void insertarCliente(@Param("numero_documento") String numero_documento, @Param("login") String login);

}
