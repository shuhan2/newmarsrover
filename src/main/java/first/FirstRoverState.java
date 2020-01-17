package first;

import lombok.Getter;

@Getter
public class FirstRoverState {
  private int x;
  private int y;
  private FirstDirection direction;

  public FirstRoverState(int x, int y, FirstDirection direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }
}
