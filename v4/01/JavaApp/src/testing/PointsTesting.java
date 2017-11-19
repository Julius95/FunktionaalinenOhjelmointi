package testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import testing.Debugging.Point;

public class PointsTesting {

	@Test
	public void test() {
		List<Point> points = Arrays.asList(new
		Point(5,5), new Point(10,5));
		List<Point> expectedPoints =
		Arrays.asList(new Point(15,5),
		new Point(20,5));
		List<Point> newPoints = Point.
		moveAllPointsRightBy(points, 10);
		//points.stream().forEach(e -> System.out.println(e.getX() + " " + e.getY()));
		expectedPoints.stream().forEach(e -> System.out.println(e.getX() + " " + e.getY()));
		newPoints.stream().forEach(e -> System.out.println(e.getX() + " " + e.getY()));
		assertEquals(expectedPoints, newPoints);
	}

}
