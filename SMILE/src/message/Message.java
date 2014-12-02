package message;

public class Message {

	public final static int SCALE_SET = 0;
	public final static int LOAD = 1;

	public final static int IRIS_MEASUREMENT_RESET = 2;
	public final static int IRIS_MEASUREMENT_SCALED_FOUND = 3;

	public final static int INTERCANTHAL_MEASURED = 4;
	public final static int BOTTOM_LIP_LOCATED = 5;
	public final static int MOUTH_CORNER_LOCATED = 6;

	public final static int RESTART_ENTIRE_MEASUREMENT = 7;
	public final static int IRIS_CALCULATED = 8;

	public final static int MEASUREMENT_SELECTED = 9;
	public final static int IRIS_NOT_CALCULATED = 10;
	public final static int INTERCANTHAL_RESET = 11;

	public final static int EYE_MEASURED = 12;
	public final static int EYE_NOT_MEASURED = 13;

	public final static String[] names = { "SCALE_SET", "LOAD",
			"IRIS_MEASUREMENT_RESET", "IRIS_MEASUREMENT_SCALED_FOUND",
			"INTERCANTHAL_MEASURED", "BOTTOM_LIP_LOCATED",
			"MOUTH_CORNER_LOCATED", "RESTART_ENTIRE_MEASUREMENT",
			"IRIS_CALCULATED", "MEASUREMENT_SELECTED", "IRIS_NOT_CALCULATED",
			"INTERCANTHAL_RESET", "EYE_MEASURED", "EYE_NOT_MEASURED", };

	public final Object source;
	public final int type;

	public Message(Object arg0, int arg1) {
		this.source = arg0;
		this.type = arg1;
	}

	public Object getSource() {
		return this.source;
	}

	public int getType() {
		return this.type;
	}

	public String toString() {
		String string = names[this.type];
		return string;
	}
}
