package ValenciaHubBackEnd_Hub;
import java.util.Objects;

public class Hub {

    private contenedor[][] hubC;

    public contenedor[][] getHubC() {
        return hubC;
    }


    //CONSTRUCTOR
    public Hub(){
        this.hubC=new contenedor[10][12]; //10 FILAS 12 COLUMNAS
    }

    public String toString(){
        String s = new String();

        for(int i=0 ; i<hubC.length ; i++){
            for(int j=0 ; j<hubC[i].length ; j++){
                if(hubC[i][j] == null) s += "[N]";
                else s += "["+ hubC[i][j].getId() +"]";
            }
            s += "\n";
        }
        s += "\n";

        return s;
    }

    public void setContenedor(contenedor C, int i, int j){
        hubC[i][j]=C;
    }

    /*
    IMPORTANTE
    En el método apilarConPrioridad hemos empleado la siguiente lógica:
    Si no hay hueco en la columna asignada a la prioridad solicitada, se intentará buscar
    en la siguiente prioridad, así hasta encontrar un hueco.

    Se ha implementado un sistema que returnea un entero dependiendo del resultado de la operación.
    1 = se ha colocado el contenedor en la primera columna
    2 = se ha colocado el contenedor en la segunda columna
    3 = se ha colocado el contenedor en el resto de columnas
    -1 = Hub lleno
    -2 = Número de prioridad ilegal
     */
    public int apilarConPrioridad(contenedor aApilar){
        int prioridadCont = aApilar.getPrioridad(); //OBTENEMOS PRIORIDAD DEL CONTENEDOR
        if (prioridadCont==1){ //EN CASO DE QUE PRIORIDAD SEA 1
            for (int i = 0; i < 10; i++) {
                if (hubC[i][0]==null){
                    hubC[i][0]=aApilar; //SI ENCUENTRA UN HUECO EN LA 1a COLUMNA, LO PONE
                    return 1; //SI DEVUELVE 1, LO HA ENCONTRADO EN LA 1ª COLUMNA
                }
            } //NO SE ENCUENTRA HUECO EN LA 1a COLUMNA
            System.out.println("No se ha encontrado hueco en la 1ª columna. Buscando un hueco en la segunda");
            for (int i = 0; i < 10; i++) {
                if (hubC[i][1]==null){
                    hubC[i][1]=aApilar; //SI ENCUENTRA UN HUECO EN LA 2a COLUMNA, LO PONE
                    return 2; //SI DEVUELVE 2, LO HA ENCONTRADO EN LA 2ª COLUMNA
                }
            }
            System.out.println("No se ha encontrado hueco en la 2º columna. Buscando un hueco en el resto del hub");
            for (int i = 0; i < 10; i++) {
                for (int j = 2; j < 12; j++) {
                    if (hubC[i][j]==null){
                        hubC[i][j]=aApilar; //SI ENCUENTRA UN HUECO EN LA 3a COLUMNA, LO PONE
                        return 3; //SI DEVUELVE 3, LO HA ENCONTRADO EN LA 3ª COLUMNA
                    }
                }

            }
            System.out.println("Hub lleno");
            return -1; //SI DEVUELVE -1, HUB LLENO
        }


        else if(prioridadCont==2){
            for (int i = 0; i < 10; i++) {
                if (hubC[i][1]==null){
                    hubC[i][1]=aApilar; //SI ENCUENTRA UN HUECO EN LA 2a COLUMNA, LO PONE
                    return 2; //SI DEVUELVE 2, LO HA ENCONTRADO EN LA 2ª COLUMNA
                }
            }
            System.out.println("No se ha encontrado hueco en la 2º columna. Buscando un hueco en el resto del hub");
            for (int i = 0; i < 10; i++) {
                for (int j = 2; j < 12; j++) {
                    if (hubC[i][j]==null){
                        hubC[i][j]=aApilar; //SI ENCUENTRA UN HUECO EN LA 3a COLUMNA, LO PONE
                        return 3; //SI DEVUELVE 3, LO HA ENCONTRADO EN LA 3ª COLUMNA
                    }
                }

            }
            System.out.println("Hub lleno");
            return -1; //SI DEVUELVE -1, HUB LLENO
        }

        else if(prioridadCont==3){
            for (int i = 0; i < 10; i++) {
                for (int j = 2; j < 12; j++) {
                    if (hubC[i][j]==null){
                        hubC[i][j]=aApilar; //SI ENCUENTRA UN HUECO EN LA 3a COLUMNA, LO PONE
                        return 3; //SI DEVUELVE 3, LO HA ENCONTRADO EN LA 3ª COLUMNA
                    }
                }

            }
            System.out.println("Hub lleno");
            return -1; //SI DEVUELVE -1, HUB LLENO
        }

        else{
            return -2; //SI DEVUELVE -2, LA PRIORIDAD ESTÁ MAL ESTABLECIDA
        }
    }

    public contenedor desapilar(int col){
        if(col < 0 || col >= hubC[0].length) return null; //SI EL NÚMERO DE COLUMNA ES ILEGAL, DEVUELVE NULO

        for (int i = 0; i < hubC.length; i++) {
            if(hubC[i][col] != null){
                contenedor aux = hubC[i][col]; //GUARDAMOS EL CONTENEDORA A APILAR EN UN AUXILIAR PARA DEVOLVERLO
                hubC[i][col] = null; //QUITAMOS EL CONTENEDOR DEL HUB
                return aux; // LO DEVOLVEMOS
            }
        }
        return null; //SI NO ENCUENTRA CONTENEDOR
    }

    public void datosAPartirdeID(int ID){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(hubC[i][j].getId()==ID){ //BUSCA QUE EL CONTENEDOR TENGA LA MISMA ID
                    hubC[i][j].toString(); //LLAMA AL TOSTRING DE DICHO CONTENEDOR
                }
            }

        }
        System.out.println("No existe contenedor con tal ID");
        /* JOptionPane.showMessageDialog(null, "No existe contenedor con tal ID");
            Esto mostrará el mensaje en pantalla cuando vinculemos los métodos a la interfaz gráfica de usuario
         */
    }

    public int contadorPaises(String pais){
        int contador=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(Objects.equals(hubC[i][j].getPais(), pais)){ //BUSCA QUE EL CONTENEDOR SEA DEL PAÍS INDICADO
                    contador++; //SUMA AL CONTADOR UNO SI EL PAÍS DEL CONTENEDOR COINCIDE CON EL INDICADO
                }
            }

        }
        return contador; //DEVUELVE EL CONTADOR
    }
}

