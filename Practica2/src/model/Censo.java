package model;

public class Censo {

    private Integer id;
    private Persona censador;
    private Persona cesado;
    private String tipo;
    private String motivo;
    private String fechaDivorsio;
    private String estadoEmosional; // could be an enum. ask for this attribute

    public Censo() {
    }

    public Censo(Persona censador, Persona cesado, String tipo, String motivo, String fechaDivorsio, String estadoEmosional) {
        this.censador = censador;
        this.cesado = cesado;
        this.tipo = tipo;
        this.motivo = motivo;
        this.fechaDivorsio = fechaDivorsio;
        this.estadoEmosional = estadoEmosional;
    }

    public Persona getCensador() {
        return censador;
    }

    public void setCensador(Persona censador) {
        this.censador = censador;
    }

    public Persona getCesado() {
        return cesado;
    }

    public void setCesado(Persona cesado) {
        this.cesado = cesado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaDivorsio() {
        return fechaDivorsio;
    }

    public void setFechaDivorsio(String fechaDivorsio) {
        this.fechaDivorsio = fechaDivorsio;
    }

    public String getEstadoEmosional() {
        return estadoEmosional;
    }

    public void setEstadoEmosional(String estadoEmosional) {
        this.estadoEmosional = estadoEmosional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
