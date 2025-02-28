package edu.kis.powp.command.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleCommandFactory {
    public static DriverCommand createRectangleCommand(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand rectangleCommand = new ComplexCommand();

        SetPositionCommand setPosCommand = new SetPositionCommand(driver, 0, 0);
        setPosCommand.setX(x);
        setPosCommand.setY(y);
        rectangleCommand.addCommand(setPosCommand);


        OperateToCommand opCommand1 = new OperateToCommand(driver, 0, 0);
        opCommand1.setX(x + width);
        opCommand1.setY(y);
        rectangleCommand.addCommand(opCommand1);

        OperateToCommand opCommand2 = new OperateToCommand(driver, 0, 0);
        opCommand2.setX(x + width);
        opCommand2.setY(y + height);
        rectangleCommand.addCommand(opCommand2);

        OperateToCommand opCommand3 = new OperateToCommand(driver, 0, 0);
        opCommand3.setX(x);
        opCommand3.setY(y + height);
        rectangleCommand.addCommand(opCommand3);

        OperateToCommand opCommand4 = new OperateToCommand(driver, 0, 0);
        opCommand4.setX(x);
        opCommand4.setY(y);
        rectangleCommand.addCommand(opCommand4);

        return rectangleCommand;
    }
}
