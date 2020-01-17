package first;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static first.Command.B;
import static first.Command.L;
import static first.Command.M;
import static first.Command.R;
import static first.FirstDirection.EAST;
import static first.FirstDirection.NORTH;
import static first.FirstDirection.SOUTH;
import static first.FirstDirection.WEST;

public class FirstMarsRover {

  private FirstRoverState state;


  public FirstRoverState getState() {
    return state;

  }

  private final Function<FirstRoverState, FirstRoverState> SUB_Y_FUNCTION =
      state -> new FirstRoverState(state.getX(), state.getY() - 1, state.getDirection());
  private final Function<FirstRoverState, FirstRoverState> SUB_X_FUNCTION =
      state -> new FirstRoverState(state.getX() - 1, state.getY(), state.getDirection());

  private final Function<FirstRoverState, FirstRoverState> ADD_X_FUNCTION =
      state -> new FirstRoverState(state.getX() + 1, state.getY(), state.getDirection());

  private final Function<FirstRoverState, FirstRoverState> ADD_Y_FUNCTION =
      state -> new FirstRoverState(state.getX(), state.getY() + 1, state.getDirection());

  private Map<FirstDirection, Function<FirstRoverState, FirstRoverState>> moveFunctionMap = new HashMap<FirstDirection, Function<FirstRoverState, FirstRoverState>>() {{
    put(NORTH, ADD_Y_FUNCTION);
    put(EAST, ADD_X_FUNCTION);
    put(SOUTH, SUB_Y_FUNCTION);
    put(WEST, SUB_X_FUNCTION);
  }};

  private final Function<FirstRoverState, FirstRoverState> MOVE_COMMAND =
      state -> moveFunctionMap.get(state.getDirection()).apply(state);

  private final Function<FirstRoverState, FirstRoverState> TURN_LEFT_COMMAND =
      state -> new FirstRoverState(this.state.getX(), state.getY(), FirstDirection.from((state.getDirection().getIndex() + 3) % 4));

  private final Function<FirstRoverState, FirstRoverState> TURN_RIGHT_COMMAND =
      state -> new FirstRoverState(this.state.getX(), state.getY(), FirstDirection.from((state.getDirection().getIndex() + 1) % 4));

  private Map<Command, Function<FirstRoverState, FirstRoverState>> commandFunctionMap = new HashMap<>();

  public FirstMarsRover(int x, int y, FirstDirection direction) {

    this.state = new FirstRoverState(x, y, direction);
    commandFunctionMap. put(M, MOVE_COMMAND);
    commandFunctionMap.put(L, TURN_LEFT_COMMAND);
    commandFunctionMap.put(R, TURN_RIGHT_COMMAND);
    commandFunctionMap.put(B, state -> state);
  }

  public void executeCommand(Command command) {
    if (command == B) {
      commandFunctionMap.put(M, state -> moveFunctionMap.get(FirstDirection.from((state.getDirection().getIndex() + 2) % 4)).apply(state));
    }
    this.state = commandFunctionMap.get(command).apply(this.state);
  }

}
