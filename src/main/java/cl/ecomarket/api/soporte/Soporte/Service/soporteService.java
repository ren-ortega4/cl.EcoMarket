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

    public Monitoreo saveMonitoreo(Monitoreo monitoreo){
        return sr.guardar(monitoreo);
    }

    public Monitoreo getMonitoreoId(int id){
        return sr.buscarPorId(id);
    }

    public Monitoreo updateMonitoreo(Monitoreo mon, int id){
        return sr.actualizar(id, mon);
    }

    public String deleteMonitoreo(int id){
        sr.eliminar(id);
        return "Monitoreo Eliminado";
    }

    //Validar accion de mostrar el estado actual del sistema
    public String mostrarEstado(int id){
        Monitoreo mon = sr.buscarPorId(id);
        if (mon != null) {
            return "ID: " + mon.getId() + 
                   "Estado Actual: " + mon.isEstado();
        } else {
            return "ID no existente, intente nuevamente";
        }
    }

    //cambiar el estado del sistema por ID
    public String cambiarEstado(int id, boolean nuevoEstado){
        Monitoreo mon = sr.buscarPorId(id);
        if (mon != null) {
            mon.setEstado(nuevoEstado);
            return "Estado del soporte con ID " + id + " cambiado a: " + nuevoEstado;
        } else {
            return "ID no existente, intente nuevamente";
        }
    }

    //Solicitar una documentación del soporte por ID
    public String solicitarSoporte(int id){
        Monitoreo mon = sr.buscarPorId(id);
        if (mon != null) {
            return "ID: " + mon.getId() + 
                   "\nEstado Actual: "+ mon.isEstado() +
                   "\nDescripcion: " + mon.getDescripcion() +
                   "\nSolicitud de soporte enviada";
        } else {
            return "ID no existente, intente nuevamente";
        }
    }
        

}
