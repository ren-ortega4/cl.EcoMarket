package cl.ecomarket.api.soporte.Soporte.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ecomarket.api.soporte.Soporte.Model.CopiaMonitoreo;
import cl.ecomarket.api.soporte.Soporte.Model.Monitoreo;
import cl.ecomarket.api.soporte.Soporte.Repository.copiaSoporteRepository;

@Service
public class copiaSoporteService {
    @Autowired
    private soporteService ss;
    private copiaSoporteRepository csr;

    public List<CopiaMonitoreo> getCopia(){
        return csr.obtenerCopias();
    }

    public CopiaMonitoreo saveCopia(CopiaMonitoreo cm){
        return csr.guardar(cm);
    }

    public CopiaMonitoreo getCopiaId(int id){
        return csr.buscarPorId(id);
    }

    public CopiaMonitoreo updateCopia(CopiaMonitoreo cm){
        return csr.actualizar(cm);
    }

    public String deleteCopia(int id){
        csr.eliminar(id);
        return "Copia Eliminada";
    }

    /*Realizar un respaldo a la copia por ID
    public CopiaMonitoreo respaldarCopiaId(int id){
        Monitoreo mon = ss.getMonitoreoId(id);
        CopiaMonitoreo cm = new CopiaMonitoreo();
        cm.setVaucher(ss.solicitarSoporte(id));
        return cm;
    }
    */
    //Realizar un respaldo a la copia por ID
    public CopiaMonitoreo respaldarCopiaId(int id){
        Monitoreo mon = ss.getMonitoreoId(id);
        if (mon == null) {
            return null; // o lanzar una excepción si lo prefieres
        } else {
            CopiaMonitoreo cm = new CopiaMonitoreo();
            cm.setVaucher(ss.solicitarSoporte(id));
            return csr.guardar(cm); // Guardar la copia en el repositorio
        }
    }
    
}
