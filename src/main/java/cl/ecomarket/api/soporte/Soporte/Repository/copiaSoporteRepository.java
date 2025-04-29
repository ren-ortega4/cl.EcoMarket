package cl.ecomarket.api.soporte.Soporte.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.ecomarket.api.soporte.Soporte.Model.CopiaMonitoreo;

@Repository
public class copiaSoporteRepository {
    //Lista que guardara las copias
    private List<CopiaMonitoreo> listaCopias = new ArrayList<>();

    //Retorna la lista de las copias
    public List<CopiaMonitoreo> obtenerCopias(){
        return listaCopias;
    }

    //Busca por el ID la copia
    public CopiaMonitoreo buscarPorId(int id){
        for(CopiaMonitoreo cm : listaCopias){
            if (cm.getId() == id) {
                return cm;
            }
        }
        return null;
    }

    //Guarda la copia
    public CopiaMonitoreo guardar(CopiaMonitoreo cm){
        listaCopias.add(cm);
        return cm;
    }

    //Actualizar buscando por su ID
    public CopiaMonitoreo actualizar(CopiaMonitoreo cm){
        int id = 0;
        int idPosicion = 0;

        for(int i = 0; i < listaCopias.size(); i++){
            if (listaCopias.get(i).getId() == cm.getId()) {
                id = cm.getId();
                idPosicion = 1;
            }
        }

        CopiaMonitoreo cm1 = new CopiaMonitoreo();
        cm1.setId(id);
        cm1.setVaucher(cm.getVaucher());

        listaCopias.set(idPosicion, cm1);
        return cm1;
    }

    //Eliminar por ID
    public void eliminar(int id){
        CopiaMonitoreo cm = buscarPorId(id);
        if (cm != null) {
            listaCopias.remove(cm);
        }
    }
}
