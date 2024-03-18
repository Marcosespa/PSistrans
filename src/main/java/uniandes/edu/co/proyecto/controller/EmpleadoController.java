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
  public String empleados(Model model) {
    model.addAttribute("empleados", empleadoRepository.darEmpleados());
    return "empleados";

  }

  @GetMapping("/empleados/new")
  public String empleadosForm(Model model) {
    model.addAttribute("empleado", new Empleado());
    return "empleadoNuevo";
  }

  @PostMapping("/empleados/new/save")
  public String empleadoGuardar(@ModelAttribute Empleado empleado) {
    empleadoRepository.insertarEmpleado(empleado.getTipo(), empleado.getTipoDocumento(), empleado.getNombre(),
        empleado.getNacionalidad(), empleado.getDireccionFisica(), empleado.getDireccionElectronica(),
        empleado.getCodigoPostal(), empleado.getCiudad(), empleado.getDepartamento(), empleado.getCargo());
    return "redirect:/empleados";
  }

  @GetMapping("/empleados/{numeroDocumento}/edit")
  public String empleadoEditarForm(@PathVariable("numeroDocumento") long numeroDocumento, Model model) {
    Empleado empleado = empleadoRepository.darEmpleado(numeroDocumento);
    if (empleado != null) {
      model.addAttribute("empleado", empleado);
      return "empleadoEditar";
    } else {
      return "redirect:/empleados";
    }
  }

  @PostMapping("/empleados/{numeroDocumento}/edit/save")
  public String empleadoEditarGuardar(@PathVariable("numeroDocumento") long numeroDocumento,
      @ModelAttribute Empleado empleado) {
    empleadoRepository.actualizarEmpleado(((long) numeroDocumento), empleado.getTipo(), empleado.getTipoDocumento(),
        empleado.getNombre(),
        empleado.getNacionalidad(), empleado.getDireccionFisica(), empleado.getDireccionElectronica(),
        empleado.getCodigoPostal(), empleado.getCiudad(), empleado.getDepartamento(), empleado.getCargo());
    return "redirect:/empleados";
  }

  @GetMapping("/empleados/{numeroDocumento}/delete")
  public String empleadoEliminar(@PathVariable("numeroDocumento") long numeroDocumento) {
    empleadoRepository.eliminarEmpleado(numeroDocumento);
    return "redirect:/empleados";
  }
}
