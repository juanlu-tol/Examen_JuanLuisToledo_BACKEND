package ValenciaHubBackEnd_Hub;

public class puerto  {
    private Hub[] P;


    // CONSTRUCTORES
    public puerto(){
        P = new Hub[3];
    }

    // OTROS MÉTODOS

    public boolean Ocupado (int hub){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if(P[hub].getHubC()[i][j]==null){
                    return false;
                }
            }
        }
        return true;
    }

    /*LA SIGUIENTE FUNCIÓN DEVUELVE:
    TRUE SI EL HUB TIENE HUECO Y LO HA PODIDO APILAR
    FALSE SI EL HUB ESTÁ LLENO
     */
    public boolean apilarContenedor (contenedor C, int hub){
        if (Ocupado(hub)==true){
            return false;
        }
        else{
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 10; j++) {
                    if(P[hub].getHubC()[i][j]==null){
                        P[hub].setContenedor(C, i, j);
                    }
                }
            }
            return true;
        }

    }

    public void desapilar (int hub, int idCont){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if(P[hub].getHubC()[i][j].getId()==idCont){
                    P[hub].setContenedor(null, i, j);
                }
            }

        }
    }

}