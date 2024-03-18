package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_empleados")
public class UsuarioEmpleado {
    @Id
    private String login;
    private String password;
    
    public UsuarioEmpleado(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UsuarioEmpleado() {;}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    



}
