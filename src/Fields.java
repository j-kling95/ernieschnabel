import java.awt.*;

public class Fields {

    private Point coordinate;
    private boolean hasPlatypus = false;

    public Fields(Point coordinate){
        setCoordinate(coordinate);
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void printCoordinate() {
        System.out.println("Coordinate: " + (int)Math.round(coordinate.getX()) + "/" + (int)Math.round(coordinate.getY()));
    }

    public void setCoordinate(Point coordinate){
       this.coordinate = coordinate;
    }

    public int getY(){
       return (int) this.coordinate.getY();
    }

    public int getX(){
        return (int) this.coordinate.getX();
    }

    public void setHasPlatypus(boolean hasPlatypus) {
        this.hasPlatypus = hasPlatypus;
    }
    
    public boolean isHasPlatypus() {
        return hasPlatypus;
    }
}
