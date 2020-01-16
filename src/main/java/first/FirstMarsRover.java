package first;

import java.util.Arrays;

import static first.FirstDirection.values;

public class FirstMarsRover {

  private int x;
  private int y;
  private FirstDirection direction;

  public FirstMarsRover(int x, int y, FirstDirection direction) {

    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public FirstDirection getDirection() {
    return direction;
  }

  public FirstMarsRover turnLeft() {

    int originalIndex = Arrays.asList(values()).indexOf(direction);
    int indexOfLeft = originalIndex == 0 ? 3 : originalIndex - 1;
    return new FirstMarsRover(x, y, values()[indexOfLeft]);
  }

  public FirstMarsRover turnRight() {
    int originalIndex = Arrays.asList(values()).indexOf(direction);
    int indexOfRight = originalIndex == 3 ? 0 : originalIndex + 1;
    return new FirstMarsRover(x, y, values()[indexOfRight]);
  }

  public FirstMarsRover goForward() {
    return direction.getGoForward().apply(this);
  }

}
