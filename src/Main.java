
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int maxX = parsePositiveInt(input[0], "Plateau X coordinate must be a positive integer");
        int maxY = parsePositiveInt(input[1], "Plateau Y coordinate must be a positive integer");

        while(sc.hasNextLine()){
            String positionLine = sc.nextLine();
            if (positionLine.isEmpty()) {
                break;
            }

            String[] position = positionLine.split(" ");
            if (position.length != 3) {
                throw new IllegalArgumentException("Invalid rover position format. Expected: X Y D");
            }

            int x = parsePositiveInt(position[0], "Rover X coordinate must be an integer");
            int y = parsePositiveInt(position[1], "Rover Y coordinate must be an integer");

            char dir = position[2].charAt(0);

            if ("NESW".indexOf(dir) == -1) {
                throw new IllegalArgumentException("Invalid direction: " + dir + ". Must be N, E, S, or W.");
            }

            if (x < 0 || x > maxX || y < 0 || y > maxY) {
                throw new IllegalArgumentException(
                        String.format("Initial position (%d,%d) is outside plateau boundaries (0,0) to (%d,%d)",
                                x, y, maxX, maxY)
                );
            }

            if(!sc.hasNextLine())
                break;
            String commands = sc.nextLine().trim();
            if (commands.isEmpty()) {
                throw new IllegalArgumentException("Command string cannot be empty.");
            }

            for (char command : commands.toCharArray()) {

                if ("LRM".indexOf(command) == -1) {
                    throw new IllegalArgumentException("Invalid command: " + command + ". Allowed: L, R, M.");
                }

                switch (command) {
                    case 'L':
                        dir = turnLeft(dir);
                        break;
                    case 'R':
                        dir = turnRight(dir);
                        break;
                    case 'M':
                        int[] newPos = moveForward(x, y, dir, maxX, maxY);
                        x = newPos[0];
                        y = newPos[1];
                        break;
                }}
            System.out.println(x + " " + y + " " + dir);
        }
        sc.close();
    }

    private static int parsePositiveInt(String value, String errorMsg) {
        try {
            int num = Integer.parseInt(value);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private static char turnLeft(char direction) {
        switch (direction) {
            case 'N':
                return 'W';
            case 'W':
                return 'S';
            case 'S':
                return 'E';
            case 'E':
                return 'N';
            default:
                return direction;
        }
    }

    private static char turnRight(char direction) {
        switch (direction) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
            default:
                return direction;
        }
    }

    private static int[] moveForward(int x, int y, char direction, int maxX, int maxY) {
        switch (direction) {
            case 'N':
                if (y < maxY)
                    y++;
                break;
            case 'E':
                if (x < maxX)
                    x++;
                break;
            case 'S':
                if (y > 0)
                    y--;
                break;
            case 'W':
                if (x > 0)
                    x--;
                break;
        }
        return new int[]{x, y};
    }
}