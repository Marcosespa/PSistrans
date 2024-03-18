package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoController {

  @Autowired
  private EmpleadoRepository empleadoRepository;

  @GetMapping("/empleados")
  public String cuentas(Model model) {
    model.addAttribute("empleados", empleadoRepository.darEmpleados());
    return "empleados";

  }

  @GetMapping("/empleados/new")
  public String empleadosForm(Model model) {
    model.addAttribute("empleado", new Empleado());
    return "empleadoNuevo";
  }

  @PostMapping("/empleados/new/save")
  public String cuentaGuardar(@ModelAttribute Empleado empleado) {
    empleadoRepository.insertarEmpleado(empleado.getTipo(), empleado.getTipoDocumento(), empleado.getNombre(),
        empleado.getNacionalidad(), empleado.getDireccionFisica(), empleado.getDireccionElectronica(),
        empleado.getCodigoPostal(), empleado.getCiudad(), empleado.getDepartamento(), empleado.getCargo());
    return "redirect:/empleados";
  }

  @GetMapping("/empleados/{numeroDocumento}/edit")
  public String cuentaEditarForm(@PathVariable("numeroDocumento") int numeroDocumento, Model model) {
    Empleado empleado = empleadoRepository.darEmpleado(numeroDocumento);
    if (cuenta != null) {
      model.addAttribute("cuenta", cuenta);
      return "cuentaEditar";
    } else {
      return "redirect:/cuentas";
    }
  }

  @PostMapping("/cuentas/{numeroCuenta}/edit/save")
  public String cuentaEditarGuardar(@PathVariable("numeroCuenta") long numeroCuenta, @ModelAttribute Cuenta cuenta) {
    cuentaRepository.actualizarCuenta(((long) numeroCuenta), cuenta.getEstado(), cuenta.getSaldo(), cuenta.getTipo(),
        cuenta.getUltimaTransaccion(), cuenta.getFechaCreacion(), cuenta.getGerente());
    return "redirect:/cuentas";
  }

  @GetMapping("/cuentas/{numeroCuenta}/delete")
  public String cuentaEliminar(@PathVariable("numeroCuenta") long numeroCuenta) {
    cuentaRepository.eliminarCuenta(numeroCuenta);
    return "redirect:/cuentas";
  }
}
