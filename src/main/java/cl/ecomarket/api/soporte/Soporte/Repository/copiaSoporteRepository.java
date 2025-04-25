package cl.ecomarket.api.soporte.Soporte.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.ecomarket.api.soporte.Soporte.Model.CopiaMonitoreo;
import cl.ecomarket.api.soporte.Soporte.Model.Monitoreo;

@Repository
public class copiaSoporteRepository {

    private soporteRepository sp;
    private List<CopiaMonitoreo> listaCopiasMonitoreo = new ArrayList<>();

    public List<CopiaMonitoreo> obtenerCopias() {
        return listaCopiasMonitoreo;
    }

    public CopiaMonitoreo respaldarCopia(Monitoreo monitoreo){
        CopiaMonitoreo copy = new CopiaMonitoreo();
        copy.setVaucher(sp.solicitarSoporte(monitoreo, monitoreo.getId()));
        return copy;
    }
}
