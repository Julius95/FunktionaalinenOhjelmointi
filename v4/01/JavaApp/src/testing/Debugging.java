package testing;


import java.util.*;
import java.util.stream.Collectors;

import testing.Debugging.Point;

public class Debugging{
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }


    public static class Point{
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public Point moveRightBy(int x) {
            return new Point(this.x + x, this.y);
        }

        @Override
        public boolean equals(Object obj) {
        	if(obj != null && obj instanceof Point){
        		Point p = (Point)obj;
        		if(p.x == this.x && p.y == this.y)
        			return true;
        	}
        	return false;
        }

		public static List<Point> moveAllPointsRightBy(List<Point> points, int i) {
			return points.stream().map(p -> p.moveRightBy(i))
					.collect(Collectors.toList());
		}
    }
}
