package cl.ecomarket.api.soporte.Soporte.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monitoreo {
    private int id;
    private String descripcion;
    private boolean estado;
}
