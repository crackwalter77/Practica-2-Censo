package controlador;

import controlador.dao.DataAccessObject;
import controlador.sd.linkedlist.LinkedList;
import model.Censo;
import model.Persona;
import model.Tipo;

public class ControladorCenso extends DataAccessObject<Censo>{

    private Censo censo;
    private Persona censador, censado;
    
    public ControladorCenso () {
        super(Censo.class);
    }

    public void guardarPersonas(String nCdor, String aCdor, Integer eCdor, String nCdo, String aCdo, Integer eCdo){
        
        censador = new Persona(nCdor, aCdor, eCdor);
        
        censado = new Persona(nCdo, aCdo, eCdo);
        
    }
    
    public void guardarCenso(String tipo, String motivo, String fecha, String estado){
        
        censo = new Censo(censador,
                censado, 
                tipo,
                motivo, 
                fecha,
                estado);
        
        censo.setId(generated_id());
        
        save(censo);
        
        censo = null;
        
        censador = censado = null;
        
    }
    
    public void editarPersonas(String nCdor, String aCdor, Integer eCdor, String nCdo, String aCdo, Integer eCdo){
        
        censador.setNombre(nCdor);
        censador.setApellido(aCdor);
        censador.setEdad(eCdor);
        
        censado.setNombre(nCdo);
        censado.setApellido(aCdo);
        censado.setEdad(eCdo);
        
    }
    
    public void editarCenso(String tipo, String motivo, String fecha, String estado){
        
        censo.setTipo(tipo);
        censo.setMotivo(motivo);
        censo.setFechaDivorsio(fecha);
        censo.setEstadoEmosional(estado);
        
        update(censo, censo.getId() - 1);
        
        censo = null;
        
        censador = censado = null;
        
    }
    
    public void cargarCenso(Integer censo){
        
        this.censo = listAll().get(censo);
        
        censador = this.censo.getCensador();
        
        censado = this.censo.getCesado();
        
    }
    
    public String estadistica(){
        
        LinkedList<Censo> list = listAll();
        
        int total = list.getSize();
        
        int separados = 0, divorciados = 0;
        
        for(int i = 0; i < total ; i++){
            
            if(list.get(i).getTipo().equals(Tipo.SEPARADO.toString())){
                separados++;
            } else {
                divorciados++;
            }
            
        }
        
        return "Personas Separadas("+ separados +") \n Personas Divorciadas("+ divorciados +")";
    }

    public Censo getCenso() {
        return censo;
    }

    public void setCenso(Censo censo) {
        this.censo = censo;
    }

    public Persona getCensador() {
        return censador;
    }

    public void setCensador(Persona censador) {
        this.censador = censador;
    }

    public Persona getCensado() {
        return censado;
    }

    public void setCensado(Persona censado) {
        this.censado = censado;
    }
    
    
}
