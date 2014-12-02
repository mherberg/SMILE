package util.math;

import java.awt.geom.Point2D;

public class LineComputer {

	public static Line getLineThroughPointWithGivenSlope(double slope,
			Point2D.Double point, double yBegin, double yEnd) {

		// An assumption about the face structure is made
		// The distance between the inner part of the eyes is about 5 times the
		// distance from the midpoint of that line to the chin
		double x = point.getX();
		double y = point.getY();

		double y1 = y + yEnd;
		double x1 = x - (y - y1) / slope;

		double y2 = y - yBegin;
		double x2 = x - (y - y2) / slope;

		Point2D.Double startPerpedicularBisectingLine = new Point2D.Double(x1,
				y1);
		Point2D.Double endPerpedicularBisectingLine = new Point2D.Double(x2, y2);

		Line perpendicularBisector = new Line(startPerpedicularBisectingLine,
				endPerpedicularBisectingLine);

		return perpendicularBisector;
	}
}
