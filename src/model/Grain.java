package model;

import javafx.scene.paint.Color;

public class Grain {
    int id;
    Color color;

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

    public void checkNeighbourhood(Grain[] matrix, int x, int y)
    {


    }

}
