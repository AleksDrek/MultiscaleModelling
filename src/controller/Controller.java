package controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import model.Change;
import model.Grain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private static int xSize;
    private static int ySize;
    private static int numberOfGrains;
    private static int xSizeOfGrain;
    private static int ySizeOfGrain;
    private static Grain[][] matrixOfGrains1;
    //public Canvas grainCanvas;
    public TextField xSizeTextBox;
    public TextField ySizeTextBox;
    public TextField nmbOfGrainsTextBox;
    public Canvas GrainsCanvas;
    public StackPane holderStackPane;
    private GraphicsContext gc;


    private void init() {

        xSize = Integer.parseInt(xSizeTextBox.getText());
        ySize = Integer.parseInt(ySizeTextBox.getText());
        numberOfGrains = Integer.parseInt(nmbOfGrainsTextBox.getText());

        int size = xSize * ySize;

        matrixOfGrains1 = new Grain[xSize][ySize];

        for (int i = 0; i < xSize; i++)
            for (int j = 0; j < ySize; j++)
                matrixOfGrains1[i][j] = new Grain();


        holderStackPane.setStyle("-fx-background-color: white");
        xSizeOfGrain = 500 / xSize;
        ySizeOfGrain = 500 / ySize;


        //max Canvas - 500 x 580 (wxh)
        //GrainsCanvas.setHeight(ySize);
        //GrainsCanvas.setWidth(xSize);
        //GrainsCanvas.setVisible(true);
        gc = GrainsCanvas.getGraphicsContext2D();


        //set Canvas on layout x=14, y=14

        //randomGrains(numberOfGrains);


    }


    private void randomGrains(int numberOfGrains) {
        int x, y, r, g, b;
        Random rand = new Random();
        Color color;

        for (int i = 1; i <= numberOfGrains; i++) {
            x = rand.nextInt(xSize);
            y = rand.nextInt(ySize);

            r = rand.nextInt(255);
            g = rand.nextInt(255);
            b = rand.nextInt(255);
            color = Color.rgb(r, g, b);

            matrixOfGrains1[x][y].setId(i);
            matrixOfGrains1[x][y].setColor(color);
            drawOnCanvas(x, y);
        }
    }

    private void drawOnCanvas(int x, int y) {
        gc.setFill(matrixOfGrains1[x][y].getColor());
        gc.fillRect(x * xSizeOfGrain, y * ySizeOfGrain, xSizeOfGrain, ySizeOfGrain);

    }


    public void GenerateOnAction(ActionEvent actionEvent) {
        init();
        randomGrains(numberOfGrains);
    }

    public void NewMatrixGrain(Grain first, Grain second) {
        second.setId(first.getId());
        second.setColor(first.getColor());
    }


    public void StartSimulationOnAction(ActionEvent actionEvent) {
        List<Change> listOfChanges = new ArrayList<>();


        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (matrixOfGrains1[i][j].getId() != 0) {
                    if (i != 0) {
                        if (matrixOfGrains1[i - 1][j].getId() == 0) {
                            Change change = new Change(i - 1, j, matrixOfGrains1[i][j]);
                            listOfChanges.add(change);
                        }
                    }
                    if (j != 0) {
                        if (matrixOfGrains1[i][j - 1].getId() == 0) {
                            Change change = new Change(i, j - 1, matrixOfGrains1[i][j]);
                            listOfChanges.add(change);
                        }
                    }
                    if (i != xSize-1) {
                        if (matrixOfGrains1[i + 1][j].getId() == 0) {
                            Change change = new Change(i + 1, j, matrixOfGrains1[i][j]);
                            listOfChanges.add(change);
                        }
                    }
                    if (j != ySize-1) {
                        if (matrixOfGrains1[i][j + 1].getId() == 0) {
                            Change change = new Change(i, j + 1, matrixOfGrains1[i][j]);
                            listOfChanges.add(change);
                        }
                    }
                }


            }
        }


        for (Change change : listOfChanges) {
            int id = change.getGrain().getId();
            int x = change.getX();
            int y = change.getY();
            Color color = change.getGrain().getColor();
            matrixOfGrains1[x][y].setId(id);
            matrixOfGrains1[x][y].setColor(color);
            drawOnCanvas(x, y);
        }

        listOfChanges.clear();

    }

    private void setNeighbours() {

    }

}
