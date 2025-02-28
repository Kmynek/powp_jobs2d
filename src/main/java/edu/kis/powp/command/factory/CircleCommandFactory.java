package edu.kis.powp.command.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class CircleCommandFactory {
    public static DriverCommand createCircleCommand(Job2dDriver driver, int centerX, int centerY, int radius) {
        ComplexCommand circleCommand = new ComplexCommand();
        int segments = 12; // setting circle to segments to draw easier - more segments ->better circle
        double angleStep = 2 * Math.PI / segments;
        //first point set
        int startX = centerX + radius;
        int startY = centerY;
        SetPositionCommand setPosCommand = new SetPositionCommand(driver, 0, 0);
        setPosCommand.setX(startX);
        setPosCommand.setY(startY);
        circleCommand.addCommand(setPosCommand);

        for (int i = 1; i <= segments; i++) {
            double angle = i * angleStep;
            int x = centerX + (int)Math.round(radius * Math.cos(angle));
            int y = centerY + (int)Math.round(radius * Math.sin(angle));
            OperateToCommand opCommand = new OperateToCommand(driver, 0, 0);
            opCommand.setX(x);
            opCommand.setY(y);
            circleCommand.addCommand(opCommand);
        }
        return circleCommand;
    }
}
