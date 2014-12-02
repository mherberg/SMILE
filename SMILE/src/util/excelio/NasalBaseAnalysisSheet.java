package util.excelio;

import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * NasalBaseAnalysisSheet is the ExcelSheet for the Nasal Base FACE function
 * 
 * @author Luke
 * 
 */
public class NasalBaseAnalysisSheet extends ExcelSheet {

	public static final int preLoc = 3;
	public static final int postLoc = 4;

	public NasalBaseAnalysisSheet(MasterExcelFile file) {
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
	public NasalBaseAnalysisEntry getEntry(int id, int session) {
		NasalBaseAnalysisEntry entry = (NasalBaseAnalysisEntry) this
				.getEntry(new NasalBaseAnalysisEntry(id, session));
		return entry;
	}

	/**
	 * Read in all entries from Excel file
	 * 
	 * @param file
	 */
	private void readInEntries(MasterExcelFile file) {

		Sheet sheet = file.getSheet(MasterExcelFile.nasalBase);

		int line = 1;
		boolean valid = true;

		while (valid) {
			NasalBaseAnalysisEntry entry = new NasalBaseAnalysisEntry(sheet,
					line);
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
				preLoc,
				0,
				"Vertical Distance in mm Between Horizonal Line Corresponding to Healthy Nasal Base and Horizontal Line Corresponding to Afflected Nasal Base / Pre");
		Label aPrime = new Label(
				postLoc,
				0,
				"Vertical Distance in mm Between Horizonal Line Corresponding to Healthy Nasal Base and Horizontal Line Corresponding to Afflected Nasal Base / Post");

		sheet.addCell(a);
		sheet.addCell(aPrime);

	}

}
