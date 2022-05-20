package filosofoscomensales;

import java.util.Random;

/**
 * @author Raul Santos Palomino
 * 30 sept. 2019
 */
public class Filosofo implements Runnable{

    Random generadorAleatorio;
    GestorPalillos gestor;
    int numFilosofo, numPalilloL, numPalilloR;

    public Filosofo(int numFilosofo, int numPalilloL, int numPalilloR, GestorPalillos gestor) {
        this.numFilosofo = numFilosofo;
        this.numPalilloL = numPalilloL;
        this.numPalilloR = numPalilloR;
        this.generadorAleatorio = new Random();
        this.gestor = gestor;
    }
    
    
    @Override
    public void run() {
        while (true) {
            comer();
            pensar();
        }
    }

    private void esperaTiempoAlAzar(int msMaximos){
        try {
            int ms = generadorAleatorio.nextInt(msMaximos);
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void comer() {
        boolean tem;
        do {            
            tem = gestor.cogerPalillos(numPalilloL, numPalilloR);
        } while (!tem);
        
        System.out.println(Thread.currentThread().getName() +"\tFilosofo comiendo...");
        esperaTiempoAlAzar(2);
        gestor.soltarPalillos(numPalilloL, numPalilloR);
        System.out.println(Thread.currentThread().getName() + " ...termino de comer");
    }

    private void pensar() {
        System.out.println(Thread.currentThread().getName() + "\tFilosofo pensando...");
        esperaTiempoAlAzar(3);
        System.out.println(Thread.currentThread().getName() + " ...termino de pensar");
    }

    

}
