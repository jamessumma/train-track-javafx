package wsu.edu.traintrackjavafx.model;

public class OrderedPair implements Comparable<OrderedPair>{
    private int x;
    private int y;

    public OrderedPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(OrderedPair op){
        return op.getX() == this.getX() && op.getY() == this.getY();
    }

    @Override
    public int compareTo(OrderedPair op) {
        if (this.x < op.getX()) {
            return -1;
        } else if (this.x > op.getX()) {
            return 1;
        } else {
            return Integer.compare(this.y, op.getY());
        }
    }
}
