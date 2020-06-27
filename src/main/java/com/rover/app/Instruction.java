package com.rover.app;

import lombok.Getter;

@Getter
public class Instruction {

    private String command;

    private Rover rover;

    public static Instruction from(String command, Rover rover) {
        return new Instruction(command, rover);
    }

    private Instruction(String command, Rover rover) {
        this.command = command;
        this.rover = rover;
    }

    public void execute() {
        switch (command) {
            case "L":
                rover.turnLeft();
                return;
            case "R":
                rover.turnRight();
                return;
            case "M":
                rover.move();
                return;
            default:
                throw new RuntimeException("Not valid Instruction");
        }
    }
}
