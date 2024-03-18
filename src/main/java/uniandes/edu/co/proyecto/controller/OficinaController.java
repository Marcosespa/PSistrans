package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Oficina;
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
  public String oficinasForm(Model model) {
    model.addAttribute("punto_Atencion", new PuntoAtencion());
    return "oficinaNueva";
  }

  @PostMapping("/oficinas/new/save")
  public String oficinasGuardar(@ModelAttribute Oficina oficina) {
    oficinaRepository.insertarOficina(oficina.getNombre(), oficina.getDireccion(), oficina.getNumPuntosAtencion(),
        oficina.getGerente(), oficina.getCiudad());
    return "redirect:/oficinas";
  }

  @GetMapping("/oficinas/{id}/edit")
  public String oficinasEditarForm(@PathVariable("id") int id, Model model) {
    Oficina oficina = oficinaRepository.darOficina(id);
    if (oficina != null) {
      model.addAttribute("oficina", oficina);
      return "oficinaEditar";
    } else {
      return "redirect:/oficinas";
    }
  }

  @PostMapping("/oficinas/{id}/edit/save")
  public String oficinaEditarGuardar(@PathVariable("id") long id, @ModelAttribute Oficina oficina) {
    oficinaRepository.actualizarOficina(((long) id), oficina.getNombre(), oficina.getDireccion(),
        oficina.getNumPuntosAtencion(), oficina.getCiudad(),
        oficina.getGerente());
    return "redirect:/puntos_Atencion";
  }

  @GetMapping("/oficinas/{id}/delete")
  public String oficinaEliminar(@PathVariable("id") long id) {
    oficinaRepository.eliminarOficina(id);
    return "redirect:/oficinas";
  }
}
