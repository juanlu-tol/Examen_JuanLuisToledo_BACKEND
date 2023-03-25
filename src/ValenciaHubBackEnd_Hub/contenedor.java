package ValenciaHubBackEnd_Hub;
public class contenedor {
    private final int id;
    private int peso, prioridad;
    private String pais,contenido,emisor,receptor;
    private boolean aduanas;

    //CONSTRUCTOR

    public contenedor(int id, int peso, int prioridad, String pais, String contenido, String emisor,String receptor, boolean aduanas) {
        this.id = id;
        this.peso = (peso);
        this.prioridad = (prioridad);
        this.pais = pais;
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
        this.aduanas = aduanas;
    }

    //GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public boolean isAduanas() {
        return aduanas;
    }

    public void setAduanas(boolean aduanas) {
        this.aduanas = aduanas;
    }

    //OTROS MÉTODOS

    public String toString(){
        String s = new String();
        s="ID: " + this.id + "\n" + "Peso: " + this.peso + "\n" + "País de procedencia: " + this.pais + "\n" + "Inspeccionado en aduanas: " + this.aduanas + "\n" + "Prioridad: " + this.prioridad + "\n" + "Descripción del contenido: " + this.contenido + "\n" + "Empresa emisora: " + this.emisor + "\n" + "Empresa receptora: " + this.receptor + "\n";
        return s;
    }
}
