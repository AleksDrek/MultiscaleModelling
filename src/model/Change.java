package model;

public class Change {
    private Grain grain;
    private int x,y;

    public Change(int x, int y, Grain grain) {
        this.grain = grain;
        this.x = x;
        this.y = y;
    }

    public Grain getGrain() {
        return grain;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
