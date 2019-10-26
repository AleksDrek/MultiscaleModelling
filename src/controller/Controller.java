package controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import model.Grain;

import java.util.Random;

public class Controller {

    public static int xSize;
    public static int ySize;
    public static int numberOfGrains;
    public static Grain [][] matrixOfGrains1;
    //public Canvas grainCanvas;
    public TextField xSizeTextBox;
    public TextField ySizeTextBox;
    public TextField nmbOfGrainsTextBox;
    public Canvas GrainsCanvas;
    public StackPane holderStackPane;


    public void init(){

        xSize = Integer.parseInt(xSizeTextBox.getText());
        ySize = Integer.parseInt(ySizeTextBox.getText());
        numberOfGrains = Integer.parseInt(nmbOfGrainsTextBox.getText());

        int size = xSize * ySize;

        matrixOfGrains1 = new Grain [xSize][ySize];

        Grain[] matrixOfGrains2 = new Grain [size];
       // matrixOfGrains2 = matrixOfGrains1;
        holderStackPane.setStyle("-fx-background-color: white");

        GrainsCanvas.setHeight(ySize);
        GrainsCanvas.setWidth(xSize);
        GrainsCanvas.setVisible(true);

        //GraphicsContext gc = GrainsCanvas.getGraphicsContext2D();

       // gc.setFill(Color.WHITE);


        //set Canvas on layout x=14, y=14

        //randomGrains(numberOfGrains);






    }

    public void startSimulation(){



    }

    public void randomGrains(int numberOfGrains)
    {
        int x, y, r,g,b;
        Random rand = new Random();
        Color color;

        for(int i = 0; i < numberOfGrains; i++)
        {
            x = rand.nextInt(xSize);
            y = rand.nextInt(ySize);

            r = rand.nextInt(255);
            g = rand.nextInt(255);
            b = rand.nextInt(255);
            color = Color.rgb(r, g, b);

            matrixOfGrains1[x][y].setId(i+1);
            matrixOfGrains1[x][y].setColor(color);
        }
    }

    public void drawOnCanvas(){
        

    }


    public void GenerateOnAction(ActionEvent actionEvent) {
    }

    public void StartSimulationOnAction(ActionEvent actionEvent) {
    }
}
