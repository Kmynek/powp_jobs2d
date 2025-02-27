package edu.kis.powp.command.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class TriangleCommandFactory {
    public static DriverCommand createTriangleCommand(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand triangleCommand = new ComplexCommand();
        //start point - left corner
        triangleCommand.addCommand(new SetPositionCommand(driver, x, y));
        triangleCommand.addCommand(new OperateToCommand(driver, x + width / 2, y - height));
        triangleCommand.addCommand(new OperateToCommand(driver, x + width, y));
        triangleCommand.addCommand(new OperateToCommand(driver, x, y));
        return triangleCommand;
    }
}
