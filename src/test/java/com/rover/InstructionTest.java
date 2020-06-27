package com.rover;

import com.rover.app.Instruction;
import com.rover.app.Rover;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InstructionTest {

    @Test
    public void givenLInstruction_execute_roverShouldTurnLeft() {
        Rover rover = Mockito.mock(Rover.class);
        Instruction instruction = Instruction.from("L", rover);

        instruction.execute();

        Mockito.verify(rover).turnLeft();
    }

    @Test
    public void givenRInstruction_execute_roverShouldTurnRight() {
        Rover rover = Mockito.mock(Rover.class);
        Instruction instruction = Instruction.from("R", rover);

        instruction.execute();

        Mockito.verify(rover).turnRight();
    }

    @Test
    public void givenMInstruction_execute_roverShouldMove() {
        Rover rover = Mockito.mock(Rover.class);
        Instruction instruction = Instruction.from("M", rover);

        instruction.execute();

        Mockito.verify(rover).move();
    }

    @Test(expected = Exception.class)
    public void givenInvalidInstruction_execute_shouldThrowExcetion() {
        Rover rover = Mockito.mock(Rover.class);
        Instruction instruction = Instruction.from("Invalid", rover);

        instruction.execute();
    }

}