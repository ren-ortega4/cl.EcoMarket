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
import org.springframework.web.bind.annotation.RestController;

import cl.ecomarket.api.soporte.Soporte.Model.CopiaMonitoreo;
import cl.ecomarket.api.soporte.Soporte.Service.copiaSoporteService;

@RestController
@RequestMapping("/api/v1/copia")
public class copiaSoporteController {
    @Autowired
    private copiaSoporteService css;

    @GetMapping
    public List<CopiaMonitoreo> listarCopias(){
        return css.getCopia();
    }

    @PostMapping
    public CopiaMonitoreo agregarCopia(@RequestBody CopiaMonitoreo cm){
        return css.saveCopia(cm);
    }

    @GetMapping("{id}")
    public CopiaMonitoreo buscarMonitoreo(@PathVariable int id){
        return css.getCopiaId(id);
    }

    @PutMapping("{id}")
    public CopiaMonitoreo actualizarCopia(@PathVariable int id, @RequestBody CopiaMonitoreo cm){
        return css.updateCopia(cm);
    }

    @DeleteMapping("{id}")
    public String eliminarCopia(@PathVariable int id){
        return css.deleteCopia(id);
    }

    @GetMapping("/{id}/respaldo")
    public CopiaMonitoreo respaldarCopiaId(@PathVariable int id){
        return css.respaldarCopiaId(id);
    }
}
