package steps;

import javax.swing.JPanel;

import util.math.Circle;
import util.math.Line;


public interface Steps {

	public static String NO_SELECTION = "Select Measurement";
	public static String SMILE = "Smile";
	public static String EYE_MEASUREMENTS = "Eye Measurements";
	public static String NASAL_BASE = "Nasal Deviation";
	public static String PHILTRAL_DEVIATION = "Philtral Deviation";
	public static String LIP_MEASUREMENT = "Lip Measurements";

	public JPanel getInstructions();

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pixelsDividedByMM);

	public void unfocus();
}
