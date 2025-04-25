package cl.ecomarket.api.soporte.Soporte.Repository;


import cl.ecomarket.api.soporte.Soporte.Model.Monitoreo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class soporteRepository {

    private List<Monitoreo> listaMonitoreo =new ArrayList<>();

    public List<Monitoreo> obtenerMonitoreos(){
        return listaMonitoreo;
    }

    public Monitoreo guardar(Monitoreo monitoreo){
        listaMonitoreo.add(monitoreo);
        return monitoreo;
    }

    public boolean monitorearEstado(Monitoreo monitoreo) {
        if (monitoreo.isEstado() == true) {
            return true;
        }
        return false;
    }

    public String solicitarSoporte(Monitoreo monitoreo, int id){
        if(monitoreo.getId() == id){
            return "Vaucher: "+ monitoreo.getId() +
                    "Solicita Soporte al sistema por "+ monitoreo.getDescripcion() +
                    "Estado actual: " + monitoreo.isEstado();
        }else {
            return "ID no existente, intente nuevamente";
        }

    }




}
