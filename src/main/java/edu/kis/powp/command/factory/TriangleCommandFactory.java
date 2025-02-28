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
        SetPositionCommand setPosCommand = new SetPositionCommand(driver, 0, 0);
        setPosCommand.setX(x);
        setPosCommand.setY(y);
        triangleCommand.addCommand(setPosCommand);

        OperateToCommand opCommand1 = new OperateToCommand(driver, 0, 0);
        opCommand1.setX(x + width / 2);
        opCommand1.setY(y - height);
        triangleCommand.addCommand(opCommand1);

        OperateToCommand opCommand2 = new OperateToCommand(driver, 0, 0);
        opCommand2.setX(x + width);
        opCommand2.setY(y);
        triangleCommand.addCommand(opCommand2);

        OperateToCommand opCommand3 = new OperateToCommand(driver, 0, 0);
        opCommand3.setX(x);
        opCommand3.setY(y);
        triangleCommand.addCommand(opCommand3);
        return triangleCommand;
    }
}
