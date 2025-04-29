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
}
