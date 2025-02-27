package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThicknessFeature {

    public static void setupThicknessFeature(Application application) {
        application.addComponentMenu(ThicknessFeature.class, "Line Thickness");
        application.addComponentMenuElement(ThicknessFeature.class, "Thickness 1", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLineThickness(1);
            }
        });
        application.addComponentMenuElement(ThicknessFeature.class, "Thickness 2", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLineThickness(2);
            }
        });
        application.addComponentMenuElement(ThicknessFeature.class, "Thickness 3", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLineThickness(3);
            }
        });
    }

    private static void setLineThickness(int thickness) {
        Object currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        if (currentDriver instanceof LineDrawerAdapter) {
            ((LineDrawerAdapter) currentDriver).setLineThickness(thickness);
        }
    }
}
