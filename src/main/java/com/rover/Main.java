package com.rover;

import com.rover.app.Application;
import com.rover.app.Direction;
import com.rover.app.Rover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Application application = new Application();

        int fileLineIndex = 0;
        File inputFile = new File(Application.class.getClassLoader().getResource("exampleInput.txt").getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (fileLineIndex == 0) {
                    application.addPlateau(Integer.parseInt(line.split(" ")[0]),
                            Integer.parseInt(line.split(" ")[1]));
                }

                if (fileLineIndex != 0 && fileLineIndex % 2 == 1) {
                    application.addRover(Integer.parseInt(line.split(" ")[0]),
                            Integer.parseInt(line.split(" ")[1]), Direction.valueOf(line.split(" ")[2]));
                }

                if (fileLineIndex != 0 && fileLineIndex % 2 == 0) {
                    char[] chars = line.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        application.addInstruction(String.valueOf(chars[i]),
                                application.getRovers().get((fileLineIndex - 1) / 2));
                    }
                }


                fileLineIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        application.execute();

        for (Rover rover : application.getRovers()) {
            rover.printCoordinates();
        }
    }
}
