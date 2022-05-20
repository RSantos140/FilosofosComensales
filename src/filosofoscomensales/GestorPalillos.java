package filosofoscomensales;

/**
 * @author Raul Santos Palomino
 * 30 sept. 2019
 */
public class GestorPalillos {

    int numPalillos;
    boolean[] estados;

    public GestorPalillos(int numPalillos) {
        this.numPalillos = numPalillos;
        this.estados = new boolean[this.numPalillos];
        for (int i=0; i<numPalillos; i++) {
            estados[i] = true;
        }
    }
    
    public synchronized boolean cogerPalillos(int numPalillo1, int numPalillo2){
        boolean asignado = false;
        
        if (estados[numPalillo1] && estados[numPalillo2]) {
            estados[numPalillo1] = false;
            estados[numPalillo2] = false;
            asignado = true;
            
        }
        return asignado;
    }
    
    public void soltarPalillos(int numPalillo1, int numPalillo2){
        estados[numPalillo1] = true;
        estados[numPalillo2] = true;
    }

}
