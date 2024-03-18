package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.PuntoAtencion;
import uniandes.edu.co.proyecto.repositorio.OficinaRepository;
import uniandes.edu.co.proyecto.repositorio.PuntoAtencionRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OficinaController {

  @Autowired
  private OficinaRepository oficinaRepository;

  @GetMapping("/oficinas")
  public String oficinas(Model model) {
    model.addAttribute("oficinas", oficinaRepository.darOficinas());
    return "oficinas";

  }

  @GetMapping("/oficinas/new")
  public String puntos_AtencionForm(Model model) {
    model.addAttribute("punto_Atencion", new PuntoAtencion());
    return "punto_AtencionNueva";
  }

  @PostMapping("/puntos_Atencion/new/save")
  public String punto_AtencionGuardar(@ModelAttribute PuntoAtencion puntoAtencion) {
    puntoAtencionRepository.insertarPuntoAtencion(puntoAtencion.getTipo(), puntoAtencion.getCiudad(),
        puntoAtencion.getHorarioAtencion(), puntoAtencion.getDireccion());
    return "redirect:/puntos_Atencion";
  }

  @GetMapping("/puntos_Atencion/{id}/edit")
  public String punto_AtencionEditarForm(@PathVariable("id") int id, Model model) {
    PuntoAtencion puntoAtencion = puntoAtencionRepository.darPuntoAtencion(id);
    if (puntoAtencion != null) {
      model.addAttribute("punto_Atencion", puntoAtencion);
      return "punto_AtencionEditar";
    } else {
      return "redirect:/puntos_Atencion";
    }
  }

  @PostMapping("/puntos_Atencion/{id}/edit/save")
  public String cuentaEditarGuardar(@PathVariable("id") long id, @ModelAttribute PuntoAtencion puntoAtencion) {
    puntoAtencionRepository.actualizarPuntoAtencion(((long) id), puntoAtencion.getTipo(), puntoAtencion.getCiudad(),
        puntoAtencion.getHorarioAtencion(), puntoAtencion.getDireccion());

    return "redirect:/puntos_Atencion";
  }

  @GetMapping("/puntos_Atencion/{id}/delete")
  public String cuentaEliminar(@PathVariable("id") long id) {
    puntoAtencionRepository.eliminarPuntoAtencion(id);
    return "redirect:/puntos_Atencion";
  }
}
