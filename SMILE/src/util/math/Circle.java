package util.math;

import java.awt.geom.Point2D;
/**
 *  For some reason I had trouble finding a good standard circle class, so I wrote one
 *  If you care to google for 10 minutes to find a better one, please replace
 *  
 *  A circle contains center point and a radius
 * 
 * @author Luke
 *
 */
public class Circle {

	private final Point2D.Double center;
	private final double radius;

	public static final Circle notCircle = new Circle(new Point2D.Double(0,0), 0);

	public Circle(Point2D.Double center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public boolean isCircle() {
		return (this.radius > 0);
	}

	public Point2D.Double getCenter() {
		return this.center;
	}

	public double getRadius() {
		return this.radius;
	}

	public String toString() {
		return "Circle: Center ["+ this.center+ "] Radius["
				+ this.radius + "]";
	}
}
