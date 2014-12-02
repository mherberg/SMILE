package util.excelio;

import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * BrowPositionAnalysisSheet is the ExcelSheet for the Brow Position FACE
 * function
 * 
 * @author Luke
 * 
 */
public class BrowPositionAnalysisSheet extends ExcelSheet {

	public static final int browHealthyRestPreLoc = 3;
	public static final int browAffectedRestPreLoc = 4;
	public static final int browHealthyBrowRaisedPreLoc = 5;
	public static final int browAffectedBrowRaisedPreLoc = 6;

	public static final int browHealthyRestPostLoc = 8;
	public static final int browAffectedRestPostLoc = 9;
	public static final int browHealthyBrowRaisedPostLoc = 10;
	public static final int browAffectedBrowRaisedPostLoc = 11;


	public BrowPositionAnalysisSheet(MasterExcelFile file) {
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
	public BrowPositionAnalysisEntry getEntry(int id, int session) {
		BrowPositionAnalysisEntry entry = (BrowPositionAnalysisEntry) this
				.getEntry(new BrowPositionAnalysisEntry(id, session));
		return entry;
	}

	/**
	 * Read in all entries from Excel file
	 * 
	 * @param file
	 */
	private void readInEntries(MasterExcelFile file) {

		Sheet sheet = file.getSheet(MasterExcelFile.browPosition);

		// Start at line 1 because line 0 contains label information
		int line = 1;
		boolean valid = true;

		while (valid) {

			BrowPositionAnalysisEntry entry = new BrowPositionAnalysisEntry(
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

		// Before Recovery
		Label a = new Label(browHealthyRestPreLoc, 0,
				"Pupil - Top of Brow / Healthy / Rest / Pre");
		Label b = new Label(browAffectedRestPreLoc, 0,
				"Pupil - Top of Brow / Affected / Rest / Pre ");
		Label c = new Label(browHealthyBrowRaisedPreLoc, 0,
				"Pupil - Top of Brow / Healthy / Brow Raise / Pre ");
		Label d = new Label(browAffectedBrowRaisedPreLoc, 0,
				"Pupil - Top of Brow / Affected / Brow Raise / Pre ");

		// After Recover or Manipulation
		Label aPrime = new Label(browHealthyRestPostLoc, 0,
				"Pupil - Top of Brow / Healthy / Rest / Post");
		Label bPrime = new Label(browAffectedRestPostLoc, 0,
				"Pupil - Top of Brow / Affected / Rest / Post");
		Label cPrime = new Label(browHealthyBrowRaisedPostLoc, 0,
				"Pupil - Top of Brow / Healthy / Brow Raise / Post");
		Label dPrime = new Label(browAffectedBrowRaisedPostLoc, 0,
				"Pupil - Top of Brow / Affected / Brow Raise / Post");


		sheet.addCell(a);
		sheet.addCell(b);
		sheet.addCell(c);
		sheet.addCell(d);

		sheet.addCell(aPrime);
		sheet.addCell(bPrime);
		sheet.addCell(cPrime);
		sheet.addCell(dPrime);


	}

}
