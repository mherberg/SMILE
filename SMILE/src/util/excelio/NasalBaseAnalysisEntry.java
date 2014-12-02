package util.excelio;

import jxl.Sheet;
import jxl.write.Number;

/**
 * NasalBaseAnalysisEntry is an ExcelEntry which contains data for the Nasal
 * Base FACE function
 * 
 * @author Luke
 * 
 */
public class NasalBaseAnalysisEntry extends ExcelEntry {

	private final Number pre;
	private final Number post;

	/**
	 * Constructor which reads from Excel file
	 * 
	 * @param sheet
	 * @param line
	 */
	public NasalBaseAnalysisEntry(Sheet sheet, int line) {
		super(sheet, line);

		this.pre = this.readInCell(NasalBaseAnalysisSheet.preLoc, sheet, line);
		this.post = this
				.readInCell(NasalBaseAnalysisSheet.postLoc, sheet, line);

	}

	/**
	 * Constructor which creates a new blank entry
	 * 
	 * @param id
	 * @param session
	 */
	public NasalBaseAnalysisEntry(int id, int session) {
		super(id, session);

		this.pre = this.intializeCell(NasalBaseAnalysisSheet.preLoc);
		this.post = this.intializeCell(NasalBaseAnalysisSheet.postLoc);
	}

	// Setters
	public void setDeviation(double val, boolean preIntervention) {

		if (preIntervention)
			this.pre.setValue(val);
		else
			this.post.setValue(val);

	}

}
