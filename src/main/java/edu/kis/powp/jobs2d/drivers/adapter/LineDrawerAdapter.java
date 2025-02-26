package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter implements Job2dDriver {
    public enum LineMode { BASIC, SPECIAL }
    
    private int startX = 0, startY = 0;
    private DrawPanelController drawer;
    private LineMode mode;
    private int lineThickness = 1; 

    public LineDrawerAdapter(LineMode mode) {
        this.mode = mode;
        this.drawer = DrawerFeature.getDrawerController();
    }

    public void setLineThickness(int thickness) {
        this.lineThickness = thickness;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line;
        if(mode == LineMode.SPECIAL) {
            line = LineFactory.getSpecialLine();
        } else {
            line = LineFactory.getBasicLine();
        }
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        drawer.drawLine(line);
    
        this.startX = x;
        this.startY = y;
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter (" + mode + ")";
    }
}
