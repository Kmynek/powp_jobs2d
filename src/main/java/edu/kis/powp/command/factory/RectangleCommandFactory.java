package edu.kis.powp.command.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleCommandFactory {
    public static DriverCommand createRectangleCommand(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand rectangleCommand = new ComplexCommand();
        rectangleCommand.addCommand(new SetPositionCommand(driver, x, y));
        rectangleCommand.addCommand(new OperateToCommand(driver, x + width, y));
        rectangleCommand.addCommand(new OperateToCommand(driver, x + width, y + height));
        rectangleCommand.addCommand(new OperateToCommand(driver, x, y + height));
        rectangleCommand.addCommand(new OperateToCommand(driver, x, y));
        return rectangleCommand;
    }
}
