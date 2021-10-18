/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

/**
 *
 * @author Asus
 */

public class PingPong extends Thread {

    private String word;


    public PingPong(String s) {
        word = s;
    }

    public void run() {
        synchronized (getClass()) {
            for (int i = 0; i < 3000; i++) {
                System.out.print(word);
                System.out.flush();
                getClass().notifyAll();
                try {
                    getClass().wait();
                } catch (java.lang.InterruptedException e) {
                }
            }
            getClass().notifyAll();
        }
    }

    public static void main(String[] args) {
        PingPong tP = new PingPong("P");
        PingPong tp = new PingPong("p");
        tp.start();
        tP.start();
    }
}

