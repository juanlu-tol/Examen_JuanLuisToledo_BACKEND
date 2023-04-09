package ValenciaHubBackEnd_Hub;

import java.util.Arrays;

public class puerto  {
    private Hub[] P;


    // CONSTRUCTORES
    public puerto(){

        P = new Hub[3];
        for (int i = 0; i < P.length; i++) {
            Hub aux = new Hub();
            P[i]=aux;
        }

    }

    // OTROS MÉTODOS

    public boolean Ocupado (int hub){
        return P[hub].Ocupado();
    }

    /*LA SIGUIENTE FUNCIÓN DEVUELVE:
    TRUE SI EL HUB TIENE HUECO Y LO HA PODIDO APILAR
    FALSE SI EL HUB ESTÁ LLENO
     */
    public boolean apilarContenedor (contenedor C, int hub){
        if (Ocupado(hub)==true){
            return false; //HUB LLENO
        }
        else return P[hub].apilarConPrioridad(C);


    }

    public void desapilar (int hub, int col){
        P[hub].desapilar(col);

    }

    public String toString(int hub) {
     return P[hub].toString();
    }

    public contenedor datosAPartirDeId(int hub, int id){
        return P[hub].datosAPartirdeID(id);
    }

    public int contadorPaises(int hub, String país){
        return P[hub].contadorPaises(país);
    }
}