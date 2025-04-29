package cl.ecomarket.api.soporte.Soporte.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ecomarket.api.soporte.Soporte.Model.Monitoreo;
import cl.ecomarket.api.soporte.Soporte.Repository.soporteRepository;

@Service
public class soporteService {
    @Autowired
    private soporteRepository sr;

    public List<Monitoreo> getMonitoreo(){
        return sr.obtenerMonitoreos();
    }

    public Monitoreo saveLibro(Monitoreo monitoreo){
        return sr.guardar(monitoreo);
    }

    public Monitoreo getMonitoreoId(int id){
        return sr.buscarPorId(id);
    }

    public Monitoreo updateMonitoreo(Monitoreo mon){
        return sr.actualizar(mon);
    }

    public String deleteMonitoreo(int id){
        sr.eliminar(id);
        return "Monitoreo Eliminado";
    }

    //Validar accion de mostrar el estado actual del sistema
    public boolean monitorearEstado(Monitoreo mon){
        if (mon.isEstado() == true) {
            return true;
        }
        return false;
    }

    //Solicitar una documentación del soporte por ID
    public String solicitarSoporte(Monitoreo mon, int id){
        if (mon.getId() == id) {
            return "Vaucher: " + mon.getId() + 
                   "Solicita Soporte al sistema por " + mon.getDescripcion() + 
                   "Estado Actual: " + mon.isEstado();
        }else{
            return "ID no existente, intente nuevamente";
        }
    }

    
}
