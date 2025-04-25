package cl.ecomarket.api.soporte.Soporte.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.ecomarket.api.soporte.Soporte.Model.CopiaMonitoreo;

@Repository
public class copiaSoporteRepository {

    private List<CopiaMonitoreo> listaCopiasMonitoreo = new ArrayList<>();

    public List<CopiaMonitoreo> obtenerCopias() {
        return listaCopiasMonitoreo;
    }

}
