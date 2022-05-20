package filosofoscomensales;

/**
 *
 * @author Raul Santos Palomino 
 * 30 sept. 2019
 *
 */
public class FilosofosComensales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        final int NUM_FILOSOFOS = 5;
        GestorPalillos gestor = new GestorPalillos(NUM_FILOSOFOS);
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];
        Thread[] hilos = new Thread[NUM_FILOSOFOS];
        
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            if (i<NUM_FILOSOFOS-1) {
                filosofos[i] = new Filosofo(i, i, i+1, gestor);
            }else{
                filosofos[i] = new Filosofo(i, i, 0, gestor);
            }
            hilos[i] = new Thread(filosofos[i]);
            hilos[i].setName("Filosofo " + (i+1));
            hilos[i].start();
        }
        
        for (Thread hilo : hilos) {
            hilo.join();
        }
    }

}
