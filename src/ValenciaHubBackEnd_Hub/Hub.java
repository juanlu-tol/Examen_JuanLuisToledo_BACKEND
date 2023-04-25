// Juan Luis Toledo Gómez
package ValenciaHubBackEnd_Hub;
import java.util.Objects;
import java.io.Serializable;
public class Hub implements Serializable{

    private contenedor[][] hubC;

    public contenedor[][] getHubC() {
        return hubC;
    }


    //CONSTRUCTOR
    public Hub(){
        this.hubC=new contenedor[10][12]; //10 FILAS 12 COLUMNAS
        for (int i = 0; i < hubC.length; i++) {
            for (int j = 0; j < hubC[0].length; j++) {
               hubC[i][j]=null;
            }
        }
    }

    public String toString(){
        String s = new String();

        for(int i=0 ; i<hubC.length ; i++){
            for(int j=0 ; j<hubC[i].length ; j++){
                if(hubC[i][j] == null) s += "[L]";
                else s += "[O]";
            }
            s += "\n";
        }
        s += "\n";

        return s;
    }

    public boolean Ocupado(){
        for (int i = 0; i < hubC.length; i++) {
            for (int j = 0; j < hubC[0].length; j++) {
                if(hubC[i][j]==null){
                    return false;
                }
            }

        }
        return true;
    }

  public boolean apilarConPrioridad(contenedor C){
      int prioridadCont = C.getPrioridad();
      for (int j = prioridadCont-1; j < hubC[0].length; j++) {
          for (int i = hubC.length-1; i >= 0 ; i--) {
              if(hubC[i][j]==null){
                  hubC[i][j]=C;
                  return true;
              }
          }

      }
      return false;
  }

    public boolean desapilar(int col){
        if(col < 0 || col >= hubC[0].length) return false; //SI EL NÚMERO DE COLUMNA ES ILEGAL, DEVUELVE NULO

        for (int i = 0; i < hubC.length; i++) {
            if(hubC[i][col-1] != null){
                hubC[i][col-1] = null; //QUITAMOS EL CONTENEDOR DEL HUB
                return true;
            }
        }
        return false; //SI NO ENCUENTRA CONTENEDOR
    }

    public contenedor datosAPartirdeID(int ID){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(hubC[i][j]!=null && hubC[i][j].getId()==ID){ //BUSCA QUE EL CONTENEDOR TENGA LA MISMA ID
                    return hubC[i][j]; //DEVUELVE EL CONTENEDOR
                }
            }

        }
        return null;

    }

    public int contadorPaises(String pais){
        int contador=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(hubC[i][j]!=null&&hubC[i][j].getPais().equals(pais)){ //BUSCA QUE EL CONTENEDOR SEA DEL PAÍS INDICADO
                    contador++; //SUMA AL CONTADOR UNO SI EL PAÍS DEL CONTENEDOR COINCIDE CON EL INDICADO
                }
            }

        }
        return contador; //DEVUELVE EL CONTADOR
    }

    public String contenedoreselegibles(int peso){
        String s = "";
        for (int i = 0; i <hubC.length ; i++) {
            for (int j = 0; j <hubC[0].length ; j++) {
                if (hubC[i][j] != null && hubC[i][j].getPeso()>=peso){
                    hubC[i][j].setAduanas(true);
                    s = "Id Contenedor:" + hubC[i][j].getId() + "Empresa: " + hubC[i][j].getEmisor() + "\n" + " Peso: " + hubC[i][j].getPeso() + "\n" + " Inspeccionado en aduanas: " + hubC[i][j].isAduanas();
                }
            }
        }
        return s;

    }
}

