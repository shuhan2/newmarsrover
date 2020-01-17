package first;

import org.junit.jupiter.api.Test;

import static first.Command.*;
import static first.FirstDirection.EAST;
import static first.FirstDirection.NORTH;
import static first.FirstDirection.SOUTH;
import static first.FirstDirection.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstMarsRoverTest {
  @Test
  void should_return_west_x_1_y_1_when_turn_left_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(L);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(WEST, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_turn_left_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(L);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(EAST, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_north_x_1_y_1_when_turn_left_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(L);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(NORTH, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_turn_left_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(L);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(SOUTH, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_turn_right_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(R);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(EAST, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_turn_right_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(R);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(SOUTH, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_west_x_1_y_1_when_turn_right_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(R);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(WEST, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_north_x_1_y_1_when_turn_right_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(R);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(NORTH, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_north_x_1_y_2_when_go_forward_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(M);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(2, finalMarsRover.getState().getY());
    assertEquals(NORTH, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_2_y_1_when_go_forward_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(M);

    assertEquals(2, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(EAST, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_0_when_go_forward_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(M);

    assertEquals(1, finalMarsRover.getState().getX());
    assertEquals(0, finalMarsRover.getState().getY());
    assertEquals(SOUTH, finalMarsRover.getState().getDirection());
  }

  @Test
  void should_return_west_x_0_y_1_when_go_forward_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);
    FirstMarsRover finalMarsRover = marsRover.executeCommand(M);

    assertEquals(0, finalMarsRover.getState().getX());
    assertEquals(1, finalMarsRover.getState().getY());
    assertEquals(WEST, finalMarsRover.getState().getDirection());
  }
}