
Application Execution:
To run the application, execute the following command in your terminal:
1. Open Terminal/Command Prompt
2. Navigate to the folder where your Main.java is saved
3. Compile the Java file:
   ```
   javac Main.java
   ```
4. Run the compiled Java program:
   ```java Main```
5. Type desired input and get the output

Assumptions Made:
1. Robots Boundary
   Robots should stop at plateau boundaries

2. Coordinate System
   The plateau uses a standard Cartesian coordinate system where:
    (0,0) is bottom-left
    North increases Y-coordinate
    East increases X-coordinate
    Boundaries are inclusive (robots can occupy positions 0 through maxX/maxY)

3. Robot Collision
    Multiple robots can occupy the same grid square simultaneously. 

4. Error Handling
   The program should continue processing rather than crash on edge cases.
   I added boundary checks but made no provisions for:
    Invalid input formats
    Missing data
    Malformed commands

