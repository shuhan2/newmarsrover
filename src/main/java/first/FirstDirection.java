package first;

import java.util.stream.Stream;

public enum FirstDirection {
  NORTH(0),
  EAST(1),
  SOUTH(2),
  WEST(3);

  private final int index;

  public int getIndex() {
    return index;
  }

  FirstDirection(int index) {
    this.index = index;
  }

  public static FirstDirection from(int index) {
    return Stream.of(FirstDirection.values())
        .filter(topic -> topic.index == index)
        .findAny()
        .orElseThrow(() -> new RuntimeException("Invalid direction index"));
  }

}
