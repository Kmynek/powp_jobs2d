//package edu.kis.powp.jobs2d.drivers.adapter;
//
//import edu.kis.powp.jobs2d.AbstractDriver;
//import edu.kis.powp.jobs2d.Job2dDriver;
//import edu.kis.powp.jobs2d.features.DriverFeature;
//
//public class DriverAdapterForFiguresJane extends AbstractDriver {


package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class DriverAdapterForFiguresJane implements Job2dDriver {
	

    @Override
    public void setPosition(int x, int y) {
        Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        currentDriver.setPosition(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        currentDriver.operateTo(x, y);
    }

    @Override
    public String toString() {
        return "DriverAdapterForFiguresJane";
    }
}

