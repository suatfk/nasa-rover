package com.rover.app;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Application {

    private Plateau plateau;

    private List<Rover> rovers = new ArrayList<>();

    private List<Instruction> instructions = new ArrayList<>();

    public void addPlateau(int max_X, int max_Y) {
        this.plateau = Plateau.from(max_X, max_Y);
    }

    public void addRover(int x, int y, Direction heading) {
        assert plateau != null;
        rovers.add(Rover.from(x, y, heading, getPlateau()));
    }

    public void addInstruction(String command, Rover rover) {
        assert rover != null;

        instructions.add(Instruction.from(command, rover));
    }

    public void execute() {
        instructions.forEach(Instruction::execute);
    }
}
