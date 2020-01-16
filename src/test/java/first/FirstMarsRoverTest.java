package first;

import org.junit.jupiter.api.Test;

import static first.FirstDirection.EAST;
import static first.FirstDirection.NORTH;
import static first.FirstDirection.SOUTH;
import static first.FirstDirection.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstMarsRoverTest {
  @Test
  void should_return_west_x_1_y_1_when_turn_left_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);
    FirstMarsRover finalMarsRover = marsRover.turnLeft();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(WEST, finalMarsRover.getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_turn_left_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);
    FirstMarsRover finalMarsRover = marsRover.turnLeft();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(EAST, finalMarsRover.getDirection());
  }

  @Test
  void should_return_north_x_1_y_1_when_turn_left_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);
    FirstMarsRover finalMarsRover = marsRover.turnLeft();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(NORTH, finalMarsRover.getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_turn_left_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);
    FirstMarsRover finalMarsRover = marsRover.turnLeft();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(SOUTH, finalMarsRover.getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_turn_right_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);
    FirstMarsRover finalMarsRover = marsRover.turnRight();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(EAST, finalMarsRover.getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_turn_right_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);
    FirstMarsRover finalMarsRover = marsRover.turnRight();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(SOUTH, finalMarsRover.getDirection());
  }

  @Test
  void should_return_west_x_1_y_1_when_turn_right_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);
    FirstMarsRover finalMarsRover = marsRover.turnRight();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(WEST, finalMarsRover.getDirection());
  }

  @Test
  void should_return_north_x_1_y_1_when_turn_right_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);
    FirstMarsRover finalMarsRover = marsRover.turnRight();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(NORTH, finalMarsRover.getDirection());
  }

  @Test
  void should_return_north_x_1_y_2_when_go_forward_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);
    FirstMarsRover finalMarsRover = marsRover.goForward();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(2, finalMarsRover.getY());
    assertEquals(NORTH, finalMarsRover.getDirection());
  }

  @Test
  void should_return_east_x_2_y_1_when_go_forward_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);
    FirstMarsRover finalMarsRover = marsRover.goForward();

    assertEquals(2, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(EAST, finalMarsRover.getDirection());
  }

  @Test
  void should_return_south_x_1_y_0_when_go_forward_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);
    FirstMarsRover finalMarsRover = marsRover.goForward();

    assertEquals(1, finalMarsRover.getX());
    assertEquals(0, finalMarsRover.getY());
    assertEquals(SOUTH, finalMarsRover.getDirection());
  }

  @Test
  void should_return_west_x_0_y_1_when_go_forward_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);
    FirstMarsRover finalMarsRover = marsRover.goForward();

    assertEquals(0, finalMarsRover.getX());
    assertEquals(1, finalMarsRover.getY());
    assertEquals(WEST, finalMarsRover.getDirection());
  }
}