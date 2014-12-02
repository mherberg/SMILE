package util.math;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CircleComputer {

	public static final int requiredNumberOfPointsToFindCircle = 4;
	
	public static Circle findBestCircleFromFourPoints(
			Set<Point2D.Double> points) {
		assert (points.size() == CircleComputer.requiredNumberOfPointsToFindCircle);

		double x = 0;
		double y = 0;
		double r = 0;

		Set<Point2D.Double> copy = new HashSet<Point2D.Double>(points);

		int numberOfValidCircles = 0;
		for (Point2D.Double mouseLocation : points) {
			copy.remove(mouseLocation);
			Circle iris = CircleComputer
					.findRadiusFromThreePointsOnTheCircle(copy);
			if (iris.isCircle()) {
				x = x + iris.getCenter().getX();
				y = y + iris.getCenter().getY();
				r = r + iris.getRadius();
				numberOfValidCircles++;
			}
			copy.add(mouseLocation);
		}

		Circle iris;
		if (numberOfValidCircles != 0) {
			x = x / numberOfValidCircles;
			y = y / numberOfValidCircles;
			r = r / numberOfValidCircles;
			
			Point2D.Double center = new Point2D.Double(x,y);			
			iris = new Circle(center, r);
		} else {
			iris = Circle.notCircle;
		}

		return iris;
	}

	public static Circle findRadiusFromThreePointsOnTheCircle(
			Set<Point2D.Double> points) {

		assert (points.size() == 3);

		Iterator<Point2D.Double> iter = points.iterator();
		Point2D.Double[] locations = new Point2D.Double[3];
		int currentLocation = 0;

		while (iter.hasNext()) {
			locations[currentLocation] = iter.next();
			currentLocation++;
		}

		/* We need to take the determinate of the following matrix */

		double[][] subMatrix1 = new double[3][3];
		double[][] subMatrix2 = new double[3][3];
		double[][] subMatrix3 = new double[3][3];
		double[][] subMatrix4 = new double[3][3];

		for (int i = 0; i < 3; i++) {

			double x = locations[i].getX();
			double y = locations[i].getY();
			double r = Math.pow(x, 2) + Math.pow(y, 2);

			subMatrix1[i][0] = x;
			subMatrix1[i][1] = y;
			subMatrix1[i][2] = 1;

			subMatrix2[i][0] = r;
			subMatrix2[i][1] = y;
			subMatrix2[i][2] = 1;

			subMatrix3[i][0] = r;
			subMatrix3[i][1] = x;
			subMatrix3[i][2] = 1;

			subMatrix4[i][0] = r;
			subMatrix4[i][1] = x;
			subMatrix4[i][2] = y;
		}

		double det1 = getDeterminateFor3x3(subMatrix1);
		if (det1 == 0) {
			return Circle.notCircle;
		}

		double det2 = getDeterminateFor3x3(subMatrix2);
		double det3 = getDeterminateFor3x3(subMatrix3);
		double det4 = getDeterminateFor3x3(subMatrix4);

		double x = .5 * det2 / det1;
		double y = -.5 * det3 / det1;
		double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + det4 / det1);
		
		Point2D.Double center = new Point2D.Double(x,y);			
		Circle circle = new Circle(center, r);
		
		return circle;
	}

	/**
	 * Code for computing the determinate of a 3x3 matrix
	 * 
	 * @param matrix
	 * @return
	 */
	private static double getDeterminateFor3x3(double[][] matrix) {

		double det = matrix[0][0]
				* getDeterminateFor2x2(matrix[1][1], matrix[1][2],
						matrix[2][1], matrix[2][2])
				- matrix[0][1]
				* getDeterminateFor2x2(matrix[1][0], matrix[1][2],
						matrix[2][0], matrix[2][2])
				+ matrix[0][2]
				* getDeterminateFor2x2(matrix[1][0], matrix[1][1],
						matrix[2][0], matrix[2][1]);

		return det;
	}

	/**
	 * To compute a 3x3 we can break it down into the determinate of a few 2x2
	 * matrix (much easier and clearer i feel)
	 * 
	 * Matrix is as follows: | a b | | c d |
	 * 
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
	private static double getDeterminateFor2x2(double a, double b, double c,
			double d) {
		return a * d - b * c;
	}
}
