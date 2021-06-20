package neuli;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;

public class Game extends Canvas {


    final boolean PRINT_OUT_FRAME_COUNTER = false;
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

        long gameLoopDuration;
        long actualTime = 0;
        long timeBeginningGameLoop;
        long timeEndOfGameLoop;



        while(gameIsRunning){
            timeBeginningGameLoop = System.nanoTime();

            //processInput();

            updateGameLogic();
            renderScreen();

            timeEndOfGameLoop = System.nanoTime();

            gameLoopDuration = timeEndOfGameLoop-timeBeginningGameLoop;

            System.out.println("loop Duration: " + gameLoopDuration + " ns = " + gameLoopDuration/1000000.0 + " ms");

        }
    }

    public void renderScreen(){
        renderCounter++;

        //Debugging output to console
        if(PRINT_OUT_FRAME_COUNTER)
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


        for(long  i = 0; i<=1000000000; i++){

        }
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
