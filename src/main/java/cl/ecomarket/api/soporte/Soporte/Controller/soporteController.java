package cl.ecomarket.api.soporte.Soporte.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.ecomarket.api.soporte.Soporte.Model.Monitoreo;
import cl.ecomarket.api.soporte.Soporte.Service.soporteService;

@RestController
@RequestMapping("/api/v1/soporte")
public class soporteController {
    @Autowired
    private soporteService ss;

    @GetMapping
    public List<Monitoreo> listarMonitoreos(){
        return ss.getMonitoreo();
    }

    @PostMapping
    public Monitoreo agregarMonitoreo(@RequestBody Monitoreo mon){
        return ss.saveMonitoreo(mon);
    }

    @GetMapping("{id}")
    public Monitoreo buscarMonitoreo(@PathVariable int id){
        return ss.getMonitoreoId(id);
    }

    @PutMapping("{id}")
    public Monitoreo actualizarMonitoreo(@PathVariable int id, @RequestBody Monitoreo mon){
        return ss.updateMonitoreo(mon, id);
    }

    @DeleteMapping("{id}")
    public String eliminarMonitoreo(@PathVariable int id){
        return ss.deleteMonitoreo(id);
    }

    @GetMapping("/{id}/estado")
    public String mostrarEstado(@PathVariable int id){
        return ss.mostrarEstado(id);
    }

    @PutMapping("/cambiarEstado/{id}")
    public String cambiarEstadoId(@PathVariable int id, @RequestParam boolean nuevoEstado){
        return ss.cambiarEstado(id, nuevoEstado);
    }

    @GetMapping("/{id}/solicitud")
    public String solicitarSoporte(@PathVariable int id){
        return ss.solicitarSoporte(id);
    }
    
    

}
