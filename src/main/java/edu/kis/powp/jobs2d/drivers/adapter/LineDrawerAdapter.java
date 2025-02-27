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
        int x1 = startX;
        int y1 = startY;
        int x2 = x;
        int y2 = y;

        // line thickness 1 - set basic
        if(lineThickness <= 1) {
            ILine line = createLine(x1, y1, x2, y2);
            drawer.drawLine(line);
        } else {
            //
            //vector calculate
            int dx = x2 - x1;
            int dy = y2 - y1;
            double length = Math.sqrt(dx * dx + dy * dy);
            double perpX = 0;
            double perpY = 0;
            if(length != 0) {
                perpX = -dy / length;
                perpY = dx / length;
            }


            //thickness for 2 and 3 its just copying number of lines to simulate thickness
            double[] offsets;
            if(lineThickness == 2) {
                offsets = new double[] { -0.5, 0.5 };
            } else if(lineThickness == 3) {
                offsets = new double[] { -1.0, 0.0, 1.0 };
            } else {
                offsets = new double[] { 0.0 };
            }

            // able to change spacing var to set the exact thickness simulation needed.
            double spacing = 5.0;

            for(double off : offsets) {
                int newX1 = (int)Math.round(x1 + perpX * off * spacing);
                int newY1 = (int)Math.round(y1 + perpY * off * spacing);
                int newX2 = (int)Math.round(x2 + perpX * off * spacing);
                int newY2 = (int)Math.round(y2 + perpY * off * spacing);
                ILine line = createLine(newX1, newY1, newX2, newY2);
                drawer.drawLine(line);
            }
        }
        // Aktualizujemy pozycję początkową
        startX = x;
        startY = y;
    }

    private ILine createLine(int x1, int y1, int x2, int y2) {
        ILine line;
        if(mode == LineMode.SPECIAL) {
            line = LineFactory.getSpecialLine();
        } else {
            line = LineFactory.getBasicLine();
        }
        line.setStartCoordinates(x1, y1);
        line.setEndCoordinates(x2, y2);
        return line;
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter (" + mode + ")";
    }
}
