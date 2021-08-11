package org.rptp.java.Robot.Connection.Interfaces;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}
