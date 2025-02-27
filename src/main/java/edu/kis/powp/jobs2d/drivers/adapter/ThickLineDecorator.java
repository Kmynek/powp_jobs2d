package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;

import java.awt.*;

public class ThickLineDecorator implements ILine {
    private ILine decoratedLine;
    private int thickness;

    public ThickLineDecorator(ILine decoratedLine, int thickness) {
        this.decoratedLine = decoratedLine;
        this.thickness = thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return decoratedLine.clone();
    }

    @Override
    public Color getColor() {
        // delegate or set color
        return (decoratedLine != null) ? decoratedLine.getColor() : Color.BLACK;
    }

    @Override
    public float getThickness() {
        // returns thickness
        return thickness *10.0f;
    }

    @Override
    public boolean isDotted() {
        return (decoratedLine != null) ? decoratedLine.isDotted() : false;
    }

    @Override
    public int getStartCoordinateX() {
        return (decoratedLine != null) ? decoratedLine.getStartCoordinateX() : 0;
    }

    @Override
    public int getEndCoordinateX() {
        return (decoratedLine != null) ? decoratedLine.getEndCoordinateX() : 0;
    }

    @Override
    public int getStartCoordinateY() {
        return (decoratedLine != null) ? decoratedLine.getStartCoordinateY() : 0;
    }

    @Override
    public int getEndCoordinateY() {
        return (decoratedLine != null) ? decoratedLine.getEndCoordinateY() : 0;
    }

    @Override
    public void setStartCoordinates(int x, int y) {
        if(decoratedLine != null)
            decoratedLine.setStartCoordinates(x, y);
    }

    @Override
    public void setEndCoordinates(int x, int y) {
        if(decoratedLine != null)
            decoratedLine.setEndCoordinates(x, y);
    }
}
