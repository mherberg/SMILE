package util.excelio;

import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * EyeLidAnalysisSheet is the ExcelSheet for the Eye Lid FACE function
 * 
 * @author Luke
 * 
 */
public class EyeLidAnalysisSheet extends ExcelSheet {

	public static final int upperLidHealthyRestPreLoc = 3;
	public static final int lowerLidHealthyRestPreLoc = 4;
	public static final int upperLidAffectedRestPreLoc = 5;
	public static final int lowerLidAffectedRestPreLoc = 6;

	public static final int upper2lowerHealthyEyePreLoc = 8;
	public static final int upper2lowerAffectedEyePreLoc = 9;
	public static final int upper2lowerHealthySmilePreLoc = 10;
	public static final int upper2lowerAffectedSmilePreLoc = 11;

	public static final int upperLidHealthyRestPostLoc = 13;
	public static final int lowerLidHealthyRestPostLoc = 14;
	public static final int upperLidAffectedRestPostLoc = 15;
	public static final int lowerLidAffectedRestPostLoc = 16;

	public static final int upper2lowerHealthyEyePostLoc = 18;
	public static final int upper2lowerAffectedEyePostLoc = 19;
	public static final int upper2lowerHealthySmilePostLoc = 20;
	public static final int upper2lowerAffectedSmilePostLoc = 21;

	public static final int superiorLidMalpositionLoc = 23;
	public static final int inferiorLidMalpositionLoc = 24;
	public static final int palpebralWidthExcessLoc = 25;
	public static final int lagophthalmosPreLoc = 26;
	public static final int synkineticPreLoc = 27;
	public static final int lagophthalmosPostLoc = 28;
	public static final int synkineticPostLoc = 29;

	public EyeLidAnalysisSheet(MasterExcelFile file) {
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
	public EyeLidAnalysisEntry getEntry(int id, int session) {
		EyeLidAnalysisEntry entry = (EyeLidAnalysisEntry) this
				.getEntry(new EyeLidAnalysisEntry(id, session));
		return entry;
	}

	/**
	 * Read in all entries from Excel file
	 * 
	 * @param file
	 */
	private void readInEntries(MasterExcelFile file) {

		Sheet sheet = file.getSheet(MasterExcelFile.eyelid);

		int line = 1;
		boolean valid = true;

		while (valid) {

			EyeLidAnalysisEntry entry = new EyeLidAnalysisEntry(sheet, line);
			valid = entry.isValid();

			if (valid)
				this.entries.add(entry);

			line++;
		}

	}

	public static void initSheet(WritableSheet sheet)
			throws RowsExceededException, WriteException {

		ExcelSheet.initSheet(sheet);

		Label a = new Label(upperLidHealthyRestPreLoc, 0,
				"Pupil - Upper Lid Distance / Healthy / Rest / Pre");
		Label b = new Label(lowerLidHealthyRestPreLoc, 0,
				"Pupil - Lower Lid Distance / Healthy / Rest / Pre");
		Label c = new Label(upperLidAffectedRestPreLoc, 0,
				"Pupil - Upper Lid Distance / Affected / Rest / Pre");
		Label d = new Label(lowerLidAffectedRestPreLoc, 0,
				"Pupil - Lower Lid Distance / Affected / Rest / Pre");

		Label e = new Label(upper2lowerHealthyEyePreLoc, 0,
				"Pupil - Upper Lid to Lower Lid Distance / Healthy / Eye Closure / Pre");
		Label f = new Label(upper2lowerAffectedEyePreLoc, 0,
				"Pupil - Upper Lid to Lower Lid Distance / Affected / Eye Closure / Pre");
		Label g = new Label(upper2lowerHealthySmilePreLoc, 0,
				"Pupil - Upper Lid to Lower Lid Distance / Healthy / Smiling / Pre");
		Label h = new Label(upper2lowerAffectedSmilePreLoc, 0,
				"Pupil - Upper Lid to Lower Lid Distance / Affected / Smiling / Pre");

		Label aPrime = new Label(upperLidHealthyRestPostLoc, 0,
				"Pupil - Upper Lid Distance / Healthy / Rest / Post");
		Label bPrime = new Label(lowerLidHealthyRestPostLoc, 0,
				"Pupil - Lower Lid Distance / Healthy / Rest / Post");
		Label cPrime = new Label(upperLidAffectedRestPostLoc, 0,
				"Pupil - Upper Lid Distance / Affected / Rest / Post");
		Label dPrime = new Label(lowerLidAffectedRestPostLoc, 0,
				"Pupil - Lower Lid Distance / Affected / Rest / Post");

		Label ePrime = new Label(upper2lowerHealthyEyePostLoc, 0,
				"Pupil - Upper Lid to Lower Lid Distance / Healthy / Rest / Post / Eye Closure");
		Label fPrime = new Label(
				upper2lowerAffectedEyePostLoc,
				0,
				"Pupil - Upper Lid to Lower Lid Distance / Affected / Rest / Post / Eye Closure");
		Label gPrime = new Label(upper2lowerHealthySmilePostLoc, 0,
				"Pupil - Upper Lid to Lower Lid Distance / Healthy / Rest / Post / Smiling");
		Label hPrime = new Label(upper2lowerAffectedSmilePostLoc, 0,
				"Pupil - Upper Lid to Lower Lid Distance / Affected / Rest / Post / Smiling");

		Label rslm = new Label(superiorLidMalpositionLoc, 0,
				"Resting Superior Lid Malposition");
		Label rilm = new Label(inferiorLidMalpositionLoc, 0,
				"Resting Inferior Lid Malposition");
		Label pwe = new Label(palpebralWidthExcessLoc, 0,
				"Palpebral Width Excess");
		Label mmol = new Label(lagophthalmosPreLoc, 0, "mm of Lagophthalmos");
		Label ec = new Label(synkineticPreLoc, 0,
				"mm of Inappropriate  Synkinetic Eye Closure");
		Label milp = new Label(lagophthalmosPostLoc, 0,
				"mm of Improvement in Lagophtalmos Post Intervention");
		Label sinf = new Label(synkineticPostLoc, 0,
				"mm of Improvement in Ocular Synkintsis Post Intervention");

		sheet.addCell(a);
		sheet.addCell(b);
		sheet.addCell(c);
		sheet.addCell(d);
		sheet.addCell(e);
		sheet.addCell(f);
		sheet.addCell(g);
		sheet.addCell(h);

		sheet.addCell(aPrime);
		sheet.addCell(bPrime);
		sheet.addCell(cPrime);
		sheet.addCell(dPrime);
		sheet.addCell(ePrime);
		sheet.addCell(fPrime);
		sheet.addCell(gPrime);
		sheet.addCell(hPrime);

		sheet.addCell(rslm);
		sheet.addCell(rilm);
		sheet.addCell(pwe);
		sheet.addCell(mmol);
		sheet.addCell(ec);
		sheet.addCell(milp);
		sheet.addCell(sinf);

	}

}
