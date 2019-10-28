package model;

import javafx.scene.paint.Color;

public class Grain {
    private int id;
    private Color color;

    public Grain() {
        this.id = 0;
        this.color = Color.WHITE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void checkNeighbourhood(Grain[] matrix, int x, int y)
    {


    }

}
