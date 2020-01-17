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

    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(WEST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_turn_left_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);

    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(EAST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_north_x_1_y_1_when_turn_left_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);

    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(NORTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_turn_left_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);

    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(SOUTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_turn_right_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);

    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(EAST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_turn_right_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);

    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(SOUTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_west_x_1_y_1_when_turn_right_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);

    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(WEST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_north_x_1_y_1_when_turn_right_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);

    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(NORTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_north_x_1_y_2_when_go_forward_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);

    marsRover.executeCommand(M);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(2, marsRover.getState().getY());
    assertEquals(NORTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_2_y_1_when_go_forward_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);

    marsRover.executeCommand(M);

    assertEquals(2, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(EAST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_0_when_go_forward_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);

    marsRover.executeCommand(M);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(0, marsRover.getState().getY());
    assertEquals(SOUTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_west_x_0_y_1_when_go_forward_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);

    marsRover.executeCommand(M);

    assertEquals(0, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(WEST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_back_and_turn_right_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);

    marsRover.executeCommand(B);
    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(EAST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_west_x_1_y_1_when_back_and_turn_right_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);

    marsRover.executeCommand(B);
    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(WEST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_north_x_1_y_1_when_back_and_turn_right_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);

    marsRover.executeCommand(B);
    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(NORTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_back_and_turn_left_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);

    marsRover.executeCommand(B);
    marsRover.executeCommand(R);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(SOUTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_west_x_1_y_1_when_back_and_turn_left_given_north_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, NORTH);

    marsRover.executeCommand(B);
    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(WEST, marsRover.getState().getDirection());
  }

  @Test
  void should_return_east_x_1_y_1_when_back_and_turn_left_given_south_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, SOUTH);

    marsRover.executeCommand(B);
    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(EAST, marsRover.getState().getDirection());
  }



  @Test
  void should_return_north_x_1_y_1_when_back_and_turn_left_given_east_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, EAST);

    marsRover.executeCommand(B);
    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(NORTH, marsRover.getState().getDirection());
  }

  @Test
  void should_return_south_x_1_y_1_when_back_and_turn_left_given_west_x_1_y_1() {
    FirstMarsRover marsRover = new FirstMarsRover(1, 1, WEST);

    marsRover.executeCommand(B);
    marsRover.executeCommand(L);

    assertEquals(1, marsRover.getState().getX());
    assertEquals(1, marsRover.getState().getY());
    assertEquals(SOUTH, marsRover.getState().getDirection());
  }
}