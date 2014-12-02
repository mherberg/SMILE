package util.math;

import java.awt.geom.Point2D;

public class Line {

	private final Point2D.Double start;
	private final Point2D.Double end;

	public Line(Point2D.Double start, Point2D.Double end) {
		if (start.getX() < end.getX()) {
			this.start = start;
			this.end = end;
		} else {
			this.start = end;
			this.end = start;
		}
	}

	public Point2D.Double getStart() {
		return this.start;
	}

	public Point2D.Double getEnd() {
		return this.end;
	}

	public double getSlope() {
		// Rise over run
		double slope = (end.getY() - start.getY())
				/ (end.getX() - start.getX());
		return slope;
	}

	public double getLength() {
		// Euclidean distance
		double length = Math.sqrt(Math.pow(start.getX() - end.getX(), 2)
				+ Math.pow(start.getY() - end.getY(), 2));
		return length;
	}

	public Point2D.Double getClosestPointOnLine(Point2D.Double point) {
		double x;
		double y;

		double slope = this.getSlope();

		if (Double.isInfinite(slope)) {
			x = this.start.getX();
			y = point.getY();
		} else {
			// EQUATIONS -------------
			// y = m*x+b1
			// y = m^(-1)*x+b2

			// Two equations, two unknowns (solvable)
			// b1 = y-m*x
			// b2 = y - m^(-1)*x
			
			
			double b1 = this.start.getY() - slope * this.start.getX();
			double b2 = point.getY() + 1 / slope * point.getX();

			x = (b2 - b1) / (slope + 1 / (slope));
			y = slope * x + b1;
		}

		Point2D.Double closest = new Point2D.Double(x, y);
		return closest;
	}

	public double getDegrees() {
		// Swing like to operate in degrees, who am I to judge
            // meh: i assume he was going for theta = arctan (opposite / adjacent) and converting to Degree
		double degrees = Math.atan(this.getSlope()) * 180 / Math.PI;
		return degrees;
	}

	public String toString() {
		return "Line-  Beginning:" + this.start + " End:" + this.end
				+ " Slope: " + this.getSlope();
	}
}
