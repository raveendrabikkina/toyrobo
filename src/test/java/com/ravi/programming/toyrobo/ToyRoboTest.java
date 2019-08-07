package com.ravi.programming.toyrobo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToyRoboTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream systemOutStream = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void performCommandInitialiseBoard() {

        ToyRobo toyRobo = new ToyRobo();
        toyRobo.setSizeOfBoard(5);
        toyRobo.performCommand("PLACE 1,2,EAST");
        toyRobo.performCommand("MOVE");
        toyRobo.performCommand("MOVE");
        toyRobo.performCommand("LEFT");
        toyRobo.performCommand("MOVE");
        toyRobo.performCommand("REPORT");
        assertEquals("3,3,NORTH\n", outputStream.toString());
    }

    @Test
    public void performCommandPositionRobo() {
        ToyRobo toyRobo = new ToyRobo();
        toyRobo.setSizeOfBoard(5);
        toyRobo.performCommand("PLACE 0,0,EAST");
        toyRobo.performCommand("REPORT");
        assertEquals("0,0,EAST\n", outputStream.toString());
    }

    @Test
    public void performCommandMove() {

        ToyRobo toyRobo = new ToyRobo();
        toyRobo.setSizeOfBoard(5);
        toyRobo.performCommand("PLACE 1,2,EAST");
        toyRobo.performCommand("MOVE");
        toyRobo.performCommand("REPORT");
        assertEquals("2,2,EAST\n", outputStream.toString());
    }

    @Test
    public void performCommandChangeDirection() {
        ToyRobo toyRobo = new ToyRobo();
        toyRobo.setSizeOfBoard(5);
        toyRobo.performCommand("PLACE 1,2,EAST");
        toyRobo.performCommand("LEFT");
        toyRobo.performCommand("REPORT");
        assertEquals("1,2,NORTH\n", outputStream.toString());
    }

    @Test
    public void performCommandReport() {
        ToyRobo toyRobo = new ToyRobo();
        toyRobo.setSizeOfBoard(5);
        toyRobo.performCommand("PLACE 1,2,EAST");
        toyRobo.performCommand("REPORT");
        assertEquals("1,2,EAST\n", outputStream.toString());
    }

    @Test
    public void performCommandInvalidInput() {
        ToyRobo toyRobo = new ToyRobo();
        toyRobo.setSizeOfBoard(0);
        toyRobo.performCommand("PLACE 1,2,EAST");
        assertEquals("Invalid Syntax, only numbers are allowed.\n", outputStream.toString());
    }
}