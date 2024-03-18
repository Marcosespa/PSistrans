package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_empleados")
public class UsuarioEmpleado {
  @Id
  private String login;

  private String passwordEmpleado;

  public UsuarioEmpleado(String login, String passwordEmpleado) {
    this.login = login;
    this.passwordEmpleado = passwordEmpleado;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPasswordEmpleado() {
    return passwordEmpleado;
  }

  public void setPasswordEmpleado(String passwordEmpleado) {
    this.passwordEmpleado = passwordEmpleado;
  }

}
