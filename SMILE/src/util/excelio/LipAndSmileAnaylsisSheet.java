package util.excelio;

import java.util.TreeSet;

import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * LipAndSmileAnaylsisSheet is the ExcelSheet for the Lip Smile FACE function
 * 
 * @author Luke
 * 
 */
public class LipAndSmileAnaylsisSheet extends ExcelSheet {

	public static final int upperPreRestLipDeviationLoc = 3;
	public static final int cornerPreRestMouthDeviationLoc = 4;
	public static final int lowerPreRestLipDeviationLoc = 5;

	
	public static final int upperPreGestureLipDeviationLoc = 7;
	public static final int cornerPreGestureMouthDeviationLoc = 8;
	public static final int lowerPreGestureLipDeviationLoc = 9;
	
	public static final int upperPostRestLipDeviationLoc = 11;
	public static final int cornerPostRestMouthDeviationLoc = 12;
	public static final int lowerPostRestLipDeviationLoc = 13;
	
	public static final int upperPostGestureLipDeviationLoc = 15;
	public static final int cornerPostGestureMouthDeviationLoc = 16;
	public static final int lowerPostGestureLipDeviationLoc = 17;

	public static final int aPreHealthy = 20;
	public static final int bPreHealthy = 21;
	public static final int cPreHealthy = 22;
	public static final int thetaPreHealthy = 23;

	public static final int aPostHealthy = 25;
	public static final int bPostHealthy = 26;
	public static final int cPostHealthy = 27;
	public static final int thetaPostHealthy = 28;

	public static final int aPreAffected = 30;
	public static final int bPreAffected = 31;
	public static final int cPreAffected = 32;
	public static final int thetaPreAffected = 33;

	public static final int aPostAffected = 35;
	public static final int bPostAffected = 36;
	public static final int cPostAffected = 37;
	public static final int thetaPostAffected = 38;

	public LipAndSmileAnaylsisSheet(MasterExcelFile file) {
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
	public LipAndSmileAnaylsisEntry getEntry(int id, int session) {
		LipAndSmileAnaylsisEntry entry = (LipAndSmileAnaylsisEntry) this
				.getEntry(new LipAndSmileAnaylsisEntry(id, session));
		return entry;
	}

	/**
	 * Read in all entries from Excel file
	 * 
	 * @param file
	 */
	private void readInEntries(MasterExcelFile file) {

		Sheet sheet = file.getSheet(MasterExcelFile.lipAndSmile);

		int line = 1;
		boolean valid = true;

		while (valid) {

			LipAndSmileAnaylsisEntry entry = new LipAndSmileAnaylsisEntry(
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

		Label aPreRest = new Label(
				upperPreRestLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Upper Lip And The Other Through Affected Mid Upper Lip) / Pre / Rest");
		Label bPreRest = new Label(
				cornerPreRestMouthDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Corner of Mouth And The Other Through Affected Corner of Mouth) / Pre / Rest");
		Label cPreRest = new Label(
				lowerPreRestLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Lower Lip And The Other Through Affected Mid Lower Lip) / Pre / Rest");

		Label aPostRest = new Label(
				upperPostRestLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Upper Lip And The Other Through Affected Mid Upper Lip) / Post / Rest");
		Label bPostRest = new Label(
				cornerPostRestMouthDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Corner of Mouth And The Other Through Affected Corner of Mouth) / Post / Rest");
		Label cPostRest = new Label(
				lowerPostRestLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Lower Lip And The Other Through Affected Mid Lower Lip) / Post / Rest");

		Label aPostGesture = new Label(
				upperPostGestureLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Upper Lip And The Other Through Affected Mid Upper Lip) / Post / Gesture");
		Label bPostGesture = new Label(
				cornerPostGestureMouthDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Corner of Mouth And The Other Through Affected Corner of Mouth) / Post / Gesture");
		Label cPostGesture = new Label(
				lowerPostGestureLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Lower Lip And The Other Through Affected Mid Lower Lip) / Post / Gesture");

		Label aPreGesture = new Label(
				upperPreGestureLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Upper Lip And The Other Through Affected Mid Upper Lip) / Pre / Gesture");
		Label bPreGesture = new Label(
				cornerPreGestureMouthDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Corner of Mouth And The Other Through Affected Corner of Mouth) / Pre / Gesture");
		Label cPreGesture = new Label(
				lowerPreGestureLipDeviationLoc,
				0,
				"Vertical Distance Between Two Horizontal Lines (One Passing Through Healthy Mid Lower Lip And The Other Through Affected Mid Lower Lip) / Pre / Gesture");

		
		
		
		
		Label aPreHealthy = new Label(
				LipAndSmileAnaylsisSheet.aPreHealthy,
				0,
				"Side a - Pre - Healthy");	
		
		Label bPreHealthy = new Label(
				LipAndSmileAnaylsisSheet.bPreHealthy,
				0,
				"Side b - Pre - Healthy");

		Label cPreHealthy = new Label(
				LipAndSmileAnaylsisSheet.cPreHealthy,
				0,
				"Side c - Pre - Healthy");
		
		Label thetaPreHealthy = new Label(
				LipAndSmileAnaylsisSheet.thetaPreHealthy,
				0,
				"theta - Pre - Healthy");
		
		Label aPostHealthy = new Label(
				LipAndSmileAnaylsisSheet.aPostHealthy,
				0,
				"Side a - Post - Healthy");	
		
		Label bPostHealthy = new Label(
				LipAndSmileAnaylsisSheet.bPostHealthy,
				0,
				"Side b - Post - Healthy");

		Label cPostHealthy = new Label(
				LipAndSmileAnaylsisSheet.cPreHealthy,
				0,
				"Side c - Post - Healthy");
		
		Label thetaPostHealthy = new Label(
				LipAndSmileAnaylsisSheet.thetaPostHealthy,
				0,
				"theta - Post - Healthy");		
		
		Label aPreAffected = new Label(
				LipAndSmileAnaylsisSheet.aPreAffected,
				0,
				"Side a - Pre - Affected");	
		
		Label bPreAffected = new Label(
				LipAndSmileAnaylsisSheet.bPreAffected,
				0,
				"Side b - Pre - Affected");

		Label cPreAffected = new Label(
				LipAndSmileAnaylsisSheet.cPreAffected,
				0,
				"Side c - Pre - Affected");
		
		Label thetaPreAffected = new Label(
				LipAndSmileAnaylsisSheet.thetaPreAffected,
				0,
				"theta - Pre - Affected");
		
		Label aPostAffected = new Label(
				LipAndSmileAnaylsisSheet.aPostAffected,
				0,
				"Side a - Post - Affected");	
		
		Label bPostAffected = new Label(
				LipAndSmileAnaylsisSheet.bPostAffected,
				0,
				"Side b - Post - Affected");

		Label cPostAffected = new Label(
				LipAndSmileAnaylsisSheet.cPreAffected,
				0,
				"Side c - Post - Affected");
		
		Label thetaPostAffected = new Label(
				LipAndSmileAnaylsisSheet.thetaPostAffected,
				0,
				"theta - Post - Affected");
	
		
		sheet.addCell(aPreGesture);
		sheet.addCell(bPreGesture);
		sheet.addCell(cPreGesture);
		
		sheet.addCell(aPostGesture);
		sheet.addCell(bPostGesture);
		sheet.addCell(cPostGesture);

		sheet.addCell(aPostRest);
		sheet.addCell(bPostRest);
		sheet.addCell(cPostRest);
		
		sheet.addCell(aPreRest);
		sheet.addCell(bPreRest);
		sheet.addCell(cPreRest);
		
		sheet.addCell(aPostAffected);
		sheet.addCell(bPostAffected);
		sheet.addCell(cPostAffected);
		sheet.addCell(thetaPostAffected);
		
		sheet.addCell(aPreAffected);
		sheet.addCell(bPreAffected);
		sheet.addCell(cPreAffected);
		sheet.addCell(thetaPreAffected);
		
		sheet.addCell(aPreHealthy);
		sheet.addCell(bPreHealthy);
		sheet.addCell(cPreHealthy);
		sheet.addCell(thetaPreHealthy);
		
		sheet.addCell(aPostHealthy);
		sheet.addCell(bPostHealthy);
		sheet.addCell(cPostHealthy);
		sheet.addCell(thetaPostHealthy);

	}

	public static TreeSet<LipAndSmileAnaylsisEntry> readInEntries(Sheet sheet) {

		TreeSet<LipAndSmileAnaylsisEntry> entries = new TreeSet<LipAndSmileAnaylsisEntry>();

		int line = 1;
		boolean valid = true;

		while (valid) {

			LipAndSmileAnaylsisEntry entry = new LipAndSmileAnaylsisEntry(
					sheet, line);
			valid = entry.isValid();

			if (valid)
				entries.add(entry);

			line++;
		}
		return entries;
	}
}
