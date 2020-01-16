package first;

import java.util.function.Function;

public enum FirstDirection {
  NORTH(Constants.ADD_Y_FUNCTION),
  EAST(Constants.ADD_X_FUNCTION),
  SOUTH(Constants.SUB_Y_FUNCTION),
  WEST(Constants.SUB_X_FUNCTION);

  private Function<FirstMarsRover, FirstMarsRover> goForward;

  public Function<FirstMarsRover, FirstMarsRover> getGoForward() {
    return goForward;
  }

  FirstDirection(Function<FirstMarsRover, FirstMarsRover> goForward) {
    this.goForward = goForward;
  }

  private static class Constants {

    static final Function<FirstMarsRover, FirstMarsRover> SUB_Y_FUNCTION = marsOVer -> new FirstMarsRover(marsOVer.getX(), marsOVer.getY() - 1, marsOVer.getDirection());
    static final Function<FirstMarsRover, FirstMarsRover> SUB_X_FUNCTION = marsOVer -> new FirstMarsRover(marsOVer.getX() - 1, marsOVer.getY(), marsOVer.getDirection());
    static final Function<FirstMarsRover, FirstMarsRover> ADD_X_FUNCTION = marsOVer -> new FirstMarsRover(marsOVer.getX() + 1, marsOVer.getY(), marsOVer.getDirection());
    static final Function<FirstMarsRover, FirstMarsRover> ADD_Y_FUNCTION = marsOVer -> new FirstMarsRover(marsOVer.getX(), marsOVer.getY() + 1, marsOVer.getDirection());
  }
}
