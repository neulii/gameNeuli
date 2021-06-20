package neuli;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas {


    final boolean PRINT_OUT_RENDER_COUNTER = false;
    final boolean PRINT_OUT_UPDATE_COUNTER = false;


    JFrame gameWindow;
    Dimension gameWindowSize;


    BufferStrategy bs;
    Graphics graphics;

    boolean gameIsRunning;

    int renderCounter = 0;
    int updateCounter = 0;


    public Game() {

        initializeWindow();

        gameIsRunning = true;

        //game loop
        while(gameIsRunning){

            //processInput();

            final int FPS = 60;

            long startTime = System.nanoTime();
            long deltaTime = 0;
            //long frameCounterTime;
            double timePerFrame = 1000000000.0 / FPS;

            int frames = 0;

            //frameCounterTime = System.currentTimeMillis();

            while (gameIsRunning) {
                deltaTime = System.nanoTime() - startTime;

                if (deltaTime >= timePerFrame) {

                    //update Methode
                    updateGameLogic();

                    frames++;
                    deltaTime = 0;
                    startTime = System.nanoTime();
                }


                //rendering as fast as can
                renderScreen();

            }





            //System.out.println("loop Duration: " + gameLoopDuration + " ns = " + gameLoopDuration/1000000.0 + " ms");

        }
    }

    public void renderScreen(){
        renderCounter++;

        //Debugging output to console
        if(PRINT_OUT_RENDER_COUNTER)
            System.out.println("rendering Screen: " + renderCounter);

        bs = this.getBufferStrategy();

        if(bs==null){
            createBufferStrategy(3);
            return;

        }

        graphics = bs.getDrawGraphics();
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        //==========================drawing stuff just here=================

        graphics.setColor(Color.blue);
        graphics.drawLine(100,100,200,100);





        //=========================end of drawing============================


        graphics.dispose();
        bs.show();

    }

    public void updateGameLogic(){
        updateCounter++;

        //Debugging output
        if(PRINT_OUT_UPDATE_COUNTER)
            System.out.println("update Logic: " + updateCounter);

        /*
        for(long  i = 0; i<=1000000000; i++){

        }

         */
    }


    public void initializeWindow(){
        gameWindow = new JFrame("gameWindow");
        gameWindowSize = new Dimension(800,600);


        gameWindow.setSize(gameWindowSize);
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setPreferredSize(gameWindowSize);

        gameWindow.add(this);
        gameWindow.setVisible(true);

    }

}
