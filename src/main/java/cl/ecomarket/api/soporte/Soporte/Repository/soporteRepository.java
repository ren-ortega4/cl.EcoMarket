package cl.ecomarket.api.soporte.Soporte.Repository;
//Metodo CRUD
import cl.ecomarket.api.soporte.Soporte.Model.Monitoreo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class soporteRepository {
    //Lista que guardara los monitoreos
    private List<Monitoreo> listamonitoreos = new ArrayList<>();

    //Retorna el listado de monitoreo
    public List<Monitoreo> obtenerMonitoreos(){
        return listamonitoreos;
    }

    //Buscar por ID el monitoreo
    public Monitoreo buscarPorId(int id){
        for(Monitoreo mon : listamonitoreos){
            if (mon.getId() == id) {
                return mon;
            }
        }
        return null;
    }

    //Guardar el monitoreo
    public Monitoreo guardar(Monitoreo mon){
        listamonitoreos.add(mon);
        return mon;
    }

    //Actualizar el monitoreo por el ID
    public Monitoreo actualizar(Monitoreo mon){
        int id = 0;
        int idPosicion = 0;

        for(int i = 0; i < listamonitoreos.size(); i++){
            if (listamonitoreos.get(i).getId() == mon.getId()) {
                id = mon.getId();
                idPosicion = 1;
            }
        }

        Monitoreo mon1 = new Monitoreo();
        mon1.setId(id);
        mon1.setEstado(mon.isEstado());
        mon1.setDescripcion(mon.getDescripcion());

        listamonitoreos.set(idPosicion, mon1);
        return mon1;
    }

    //Eliminar buscando por el ID
    public void eliminar(int id){
        Monitoreo mon = buscarPorId(id);
        if (mon != null) {
            listamonitoreos.remove(mon);
        }
    }
}
