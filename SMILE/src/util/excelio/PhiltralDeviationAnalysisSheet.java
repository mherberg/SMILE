package util.excelio;

import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * PhiltralDeviationAnalysisSheet is the ExcelSheet for the Philtral Deviation
 * FACE function
 * 
 * @author Luke
 * 
 */
public class PhiltralDeviationAnalysisSheet extends ExcelSheet {

	public static final int restPreLoc = 3;
	public static final int restPostLoc = 4;

	public static final int smilePreLoc = 6;
	public static final int smilePostLoc = 7;


	public PhiltralDeviationAnalysisSheet(MasterExcelFile file) {
		this.readInEntries(file);
	}

	/**
	 * Look for entry with given ID and Session If no previous entry exists,
	 * return a new empty entry
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	public PhiltralDeviationAnalysisEntry getEntry(int id, int session) {
		PhiltralDeviationAnalysisEntry entry = (PhiltralDeviationAnalysisEntry) this
				.getEntry(new PhiltralDeviationAnalysisEntry(id, session));
		return entry;
	}

	/**
	 * Read in all entries from Excel file
	 * 
	 * @param file
	 */
	private void readInEntries(MasterExcelFile file) {

		Sheet sheet = file.getSheet(MasterExcelFile.philtralDeviation);

		int line = 1;
		boolean valid = true;

		while (valid) {

			PhiltralDeviationAnalysisEntry entry = new PhiltralDeviationAnalysisEntry(
					sheet, line);
			valid = entry.isValid();

			if (valid)
				this.entries.add(entry);

			line++;
		}

	}

	public static void initSheet(WritableSheet sheet)
			throws RowsExceededException, WriteException {

		ExcelSheet.initSheet(sheet);

		Label a = new Label(
				restPreLoc,
				0,
				"Horizontal Distance From Upper Lip Center Defining Point to The Computer Generated Vertical Lines Intersection With Pink Upper Lip / Rest / Pre");
		Label b = new Label(
				restPostLoc,
				0,
				"Horizontal Distance From Upper Lip Center Defining Point to The Computer Generated Vertical Lines Intersection With Pink Upper Lip / Rest / Post");

		Label aPrime = new Label(
				smilePreLoc,
				0,
				"Horizontal Distance From Upper Lip Center Defining Point to The Computer Generated Vertical Lines Intersection With Pink Upper Lip / Smile / Pre");
		Label bPrime = new Label(
				smilePostLoc,
				0,
				"Horizontal Distance From Upper Lip Center Defining Point to The Computer Generated Vertical Lines Intersection With Pink Upper Lip / Smile / Post");


		sheet.addCell(a);
		sheet.addCell(b);

		sheet.addCell(aPrime);
		sheet.addCell(bPrime);
	}

}
