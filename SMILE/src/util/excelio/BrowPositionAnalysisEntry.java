package util.excelio;

import jxl.Sheet;
import jxl.write.Number;

/**
 * BrowPositionAnalysisEntry is an ExcelEntry which contains data for the Brow
 * Position FACE function
 * 
 * @author Luke
 * 
 */
public class BrowPositionAnalysisEntry extends ExcelEntry {

	private final Number browHealthyRestPre;
	private final Number browAffectedRestPre;
	private final Number browHealthyBrowRaisedPre;
	private final Number browAffectedBrowRaisedPre;

	private final Number browHealthyRestPost;
	private final Number browAffectedRestPost;
	private final Number browHealthyBrowRaisedPost;
	private final Number browAffectedBrowRaisedPost;


	/**
	 * Constructor which reads from Excel file
	 * 
	 * @param sheet
	 * @param line
	 */
	public BrowPositionAnalysisEntry(Sheet sheet, int line) {
		super(sheet, line);

		browHealthyRestPre = readInCell(
				BrowPositionAnalysisSheet.browHealthyRestPreLoc, sheet, line);
		browAffectedRestPre = readInCell(
				BrowPositionAnalysisSheet.browAffectedRestPreLoc, sheet, line);
		browHealthyBrowRaisedPre = readInCell(
				BrowPositionAnalysisSheet.browHealthyBrowRaisedPreLoc, sheet,
				line);
		browAffectedBrowRaisedPre = readInCell(
				BrowPositionAnalysisSheet.browAffectedBrowRaisedPreLoc, sheet,
				line);

		browHealthyRestPost = readInCell(
				BrowPositionAnalysisSheet.browHealthyRestPostLoc, sheet, line);
		browAffectedRestPost = readInCell(
				BrowPositionAnalysisSheet.browAffectedRestPostLoc, sheet, line);
		browHealthyBrowRaisedPost = readInCell(
				BrowPositionAnalysisSheet.browHealthyBrowRaisedPostLoc, sheet,
				line);
		browAffectedBrowRaisedPost = readInCell(
				BrowPositionAnalysisSheet.browAffectedBrowRaisedPostLoc, sheet,
				line);


	}

	/**
	 * Constructor which creates a new blank entry
	 * 
	 * @param id
	 * @param session
	 */
	public BrowPositionAnalysisEntry(int id, int session) {
		super(id, session);

		browHealthyRestPre = this
				.intializeCell(BrowPositionAnalysisSheet.browHealthyRestPreLoc);
		browAffectedRestPre = this
				.intializeCell(BrowPositionAnalysisSheet.browAffectedRestPreLoc);
		browHealthyBrowRaisedPre = this
				.intializeCell(BrowPositionAnalysisSheet.browHealthyBrowRaisedPreLoc);
		browAffectedBrowRaisedPre = this
				.intializeCell(BrowPositionAnalysisSheet.browAffectedBrowRaisedPreLoc);

		browHealthyRestPost = this
				.intializeCell(BrowPositionAnalysisSheet.browHealthyRestPostLoc);
		browAffectedRestPost = this
				.intializeCell(BrowPositionAnalysisSheet.browAffectedRestPostLoc);
		browHealthyBrowRaisedPost = this
				.intializeCell(BrowPositionAnalysisSheet.browHealthyBrowRaisedPostLoc);
		browAffectedBrowRaisedPost = this
				.intializeCell(BrowPositionAnalysisSheet.browAffectedBrowRaisedPostLoc);


	}

	// Setters
	public void setBrowExcursion(double val, boolean preIntervention,
			boolean healthySide, boolean rest) {
		System.out.println(healthySide+" "+rest+" "+preIntervention);
		if (rest) {
			if (preIntervention) {
				if (healthySide)
					this.browHealthyRestPre.setValue(val);
				else
					this.browAffectedRestPre.setValue(val);
			} else {
				if (healthySide)
					this.browHealthyRestPost.setValue(val);
				else
					this.browAffectedRestPost.setValue(val);
			}
		} else {
			if (preIntervention) {
				if (healthySide)
					this.browHealthyBrowRaisedPre.setValue(val);
				else
					this.browAffectedBrowRaisedPre.setValue(val);
			} else {
				if (healthySide)
					this.browHealthyBrowRaisedPost.setValue(val);
				else
					this.browAffectedBrowRaisedPost.setValue(val);
			}
		}
	}


}
