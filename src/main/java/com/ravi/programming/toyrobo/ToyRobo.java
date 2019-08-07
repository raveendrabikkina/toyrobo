package com.ravi.programming.toyrobo;

import static com.ravi.programming.toyrobo.Directions.*;

public class ToyRobo {

    private int row = 0;
    private int column = 0;
    private int sizeOfBoard = 0;
    private boolean roboPositioned = false;
    private Directions direction = null;

    public void performCommand(String command) {

        if (sizeOfBoard == 0) {
            initialiseBoardSize(command);
        } else {
            if (!roboPositioned) {
                placeRobo(command);
            } else if (roboPositioned) {
                if ("MOVE".equals(command)) {
                    move();
                } else if ("REPORT".equals(command)) {
                    report();
                } else if ("RIGHT".equals(command) || "LEFT".equals(command)) {
                    changeDirection(command);
                } else {
                    System.out.println("Invalid Syntax.");
                }
            }
        }
    }

    public void placeRobo(String command) {

        if (command.contains("PLACE")) {
            try {
                command = command.replace("PLACE ", "");
                String[] inputs = command.split(",");
                int rowStart = Integer.parseInt(inputs[0]);
                int colStart = Integer.parseInt(inputs[1]);

                if (rowStart < sizeOfBoard && rowStart >= 0 && colStart < sizeOfBoard && colStart >= 0) {
                    row = rowStart;
                    column = colStart;
                    direction = Directions.valueOf(inputs[2]);
                }
                roboPositioned = true;

            } catch (Exception e) {
                System.out.println("Invalid Syntax.");
            }
        } else {
            System.out.println("Please place the Robot on the board.");
        }
    }

    public void initialiseBoardSize(String command) {
        try {
            sizeOfBoard = Integer.parseInt(command);
            System.out.println("Please enter your commands");
        } catch (Exception e) {
            System.out.println("Invalid Syntax, only numbers are allowed.");
        }
    }

    public void changeDirection(String directionStr) {

        if ("LEFT".equals(directionStr)) {
            if (NORTH == direction) {
                direction = WEST;
            } else if (WEST == direction) {
                direction = SOUTH;
            } else if (SOUTH == direction) {
                direction = EAST;
            } else if (EAST == direction) {
                direction = NORTH;
            }
        } else if ("RIGHT".equals(directionStr)) {
            if (NORTH == direction) {
                direction = EAST;
            } else if (EAST == direction) {
                direction = SOUTH;
            } else if (SOUTH == direction) {
                direction = WEST;
            } else if (WEST == direction) {
                direction = NORTH;
            }
        }
    }


    public void move() {
        switch (direction) {
            case NORTH:
                if (column < sizeOfBoard) {
                    column++;
                }
                break;
            case EAST:
                if (row < sizeOfBoard) {
                    row++;
                }
                break;
            case SOUTH:
                if (column > 0) {
                    column--;
                }
                break;
            case WEST:
                if (row > 0) {
                    row--;
                }
                break;
            default:
                System.out.println("Move Ignored!");
                break;
        }

    }

    public void report() {
        System.out.println(row + "," + column + "," + direction);

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    public void setSizeOfBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }

    public boolean isRoboPositioned() {
        return roboPositioned;
    }

    public void setRoboPositioned(boolean roboPositioned) {
        this.roboPositioned = roboPositioned;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }
}