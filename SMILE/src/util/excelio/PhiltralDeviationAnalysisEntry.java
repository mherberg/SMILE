package util.excelio;

import jxl.Sheet;
import jxl.write.Number;

/**
 * PhiltralDeviationAnalysisEntry is an ExcelEntry which contains data for the
 * Philtral Deviation FACE function
 * 
 * @author Luke
 * 
 */
public class PhiltralDeviationAnalysisEntry extends ExcelEntry {

	private final Number restPre;
	private final Number restPost;

	private final Number smilePre;
	private final Number smilePost;


	/**
	 * Constructor which reads from Excel file
	 * 
	 * @param sheet
	 * @param line
	 */
	public PhiltralDeviationAnalysisEntry(Sheet sheet, int line) {
		super(sheet, line);

		this.restPre = this.readInCell(
				PhiltralDeviationAnalysisSheet.restPreLoc, sheet, line);
		this.restPost = this.readInCell(
				PhiltralDeviationAnalysisSheet.restPostLoc, sheet, line);

		this.smilePre = this.readInCell(
				PhiltralDeviationAnalysisSheet.smilePreLoc, sheet, line);
		this.smilePost = this.readInCell(
				PhiltralDeviationAnalysisSheet.smilePostLoc, sheet, line);

	}

	/**
	 * Constructor which creates a new blank entry
	 * 
	 * @param id
	 * @param session
	 */
	public PhiltralDeviationAnalysisEntry(int id, int session) {
		super(id, session);

		this.restPre = this
				.intializeCell(PhiltralDeviationAnalysisSheet.restPreLoc);
		this.restPost = this
				.intializeCell(PhiltralDeviationAnalysisSheet.restPostLoc);

		this.smilePre = this
				.intializeCell(PhiltralDeviationAnalysisSheet.smilePreLoc);
		this.smilePost = this
				.intializeCell(PhiltralDeviationAnalysisSheet.smilePostLoc);

	}

	public void setPhiltralDeviation(double val, boolean pre, boolean rest) {
	
		if(pre) {
			if(rest) {
				this.restPre.setValue(val);
			} else {
				this.smilePre.setValue(val);
			}
		} else {
			if(rest) {
				this.restPost.setValue(val);
			} else {
				this.smilePost.setValue(val);
			}
		}
	}
	



}
