package util.excelio;

import jxl.Sheet;
import jxl.write.Number;

/**
 * EyeLidAnalysisEntry is an ExcelEntry which contains data for the Eye Lid FACE
 * function
 * 
 * @author Luke
 * 
 */
public class EyeLidAnalysisEntry extends ExcelEntry {

	private final Number upperLidHealthyRestPre;
	private final Number lowerLidHealthyRestPre;
	private final Number upperLidAffectedRestPre;
	private final Number lowerLidAffectedRestPre;

	private final Number upper2lowerHealthyEyePre;
	private final Number upper2lowerAffectedEyePre;
	private final Number upper2lowerHealthySmilePre;
	private final Number upper2lowerAffectedSmilePre;

	private final Number upperLidHealthyRestPost;
	private final Number lowerLidHealthyRestPost;
	private final Number upperLidAffectedRestPost;
	private final Number lowerLidAffectedRestPost;

	private final Number upper2lowerHealthyEyePost;
	private final Number upper2lowerAffectedEyePost;
	private final Number upper2lowerHealthySmilePost;
	private final Number upper2lowerAffectedSmilePost;

	private final Number superiorLidMalposition;
	private final Number inferiorLidMalposition;
	private final Number palpebralWidthExcess;
	private final Number lagophthalmosPre;
	private final Number synkineticPre;
	private final Number lagophthalmosPost;
	private final Number synkineticPost;

	/**
	 * Constructor which reads from Excel file
	 * 
	 * @param sheet
	 * @param line
	 */
	public EyeLidAnalysisEntry(Sheet sheet, int line) {
		super(sheet, line);

		upperLidHealthyRestPre = super.readInCell(
				EyeLidAnalysisSheet.upperLidHealthyRestPreLoc, sheet, line);
		lowerLidHealthyRestPre = super.readInCell(
				EyeLidAnalysisSheet.lowerLidHealthyRestPreLoc, sheet, line);
		upperLidAffectedRestPre = super.readInCell(
				EyeLidAnalysisSheet.upperLidAffectedRestPreLoc, sheet, line);
		lowerLidAffectedRestPre = super.readInCell(
				EyeLidAnalysisSheet.lowerLidAffectedRestPreLoc, sheet, line);

		upper2lowerHealthyEyePre = super.readInCell(
				EyeLidAnalysisSheet.upper2lowerHealthyEyePreLoc, sheet, line);
		upper2lowerAffectedEyePre = super.readInCell(
				EyeLidAnalysisSheet.upper2lowerAffectedEyePreLoc, sheet, line);
		upper2lowerHealthySmilePre = super.readInCell(
				EyeLidAnalysisSheet.upper2lowerHealthySmilePreLoc, sheet, line);
		upper2lowerAffectedSmilePre = super
				.readInCell(EyeLidAnalysisSheet.upper2lowerAffectedSmilePreLoc,
						sheet, line);

		upperLidHealthyRestPost = super.readInCell(
				EyeLidAnalysisSheet.upperLidHealthyRestPostLoc, sheet, line);
		lowerLidHealthyRestPost = super.readInCell(
				EyeLidAnalysisSheet.lowerLidHealthyRestPostLoc, sheet, line);
		upperLidAffectedRestPost = super.readInCell(
				EyeLidAnalysisSheet.upperLidAffectedRestPostLoc, sheet, line);
		lowerLidAffectedRestPost = super.readInCell(
				EyeLidAnalysisSheet.lowerLidAffectedRestPostLoc, sheet, line);

		upper2lowerHealthyEyePost = super.readInCell(
				EyeLidAnalysisSheet.upper2lowerHealthyEyePostLoc, sheet, line);
		upper2lowerAffectedEyePost = super.readInCell(
				EyeLidAnalysisSheet.upper2lowerAffectedEyePostLoc, sheet, line);
		upper2lowerHealthySmilePost = super
				.readInCell(EyeLidAnalysisSheet.upper2lowerHealthySmilePostLoc,
						sheet, line);
		upper2lowerAffectedSmilePost = super.readInCell(
				EyeLidAnalysisSheet.upper2lowerAffectedSmilePostLoc, sheet,
				line);

		superiorLidMalposition = super.readInCell(
				EyeLidAnalysisSheet.superiorLidMalpositionLoc, sheet, line);
		inferiorLidMalposition = super.readInCell(
				EyeLidAnalysisSheet.inferiorLidMalpositionLoc, sheet, line);
		palpebralWidthExcess = super.readInCell(
				EyeLidAnalysisSheet.palpebralWidthExcessLoc, sheet, line);
		lagophthalmosPre = super.readInCell(
				EyeLidAnalysisSheet.lagophthalmosPreLoc, sheet, line);
		synkineticPre = super.readInCell(EyeLidAnalysisSheet.synkineticPreLoc,
				sheet, line);
		lagophthalmosPost = super.readInCell(
				EyeLidAnalysisSheet.lagophthalmosPostLoc, sheet, line);
		synkineticPost = super.readInCell(
				EyeLidAnalysisSheet.synkineticPostLoc, sheet, line);

	}

	/**
	 * Constructor which creates a new blank entry
	 * 
	 * @param id
	 * @param session
	 */
	public EyeLidAnalysisEntry(int id, int session) {
		super(id, session);

		upperLidHealthyRestPre = super
				.intializeCell(EyeLidAnalysisSheet.upperLidHealthyRestPreLoc);
		lowerLidHealthyRestPre = super
				.intializeCell(EyeLidAnalysisSheet.lowerLidHealthyRestPreLoc);
		upperLidAffectedRestPre = super
				.intializeCell(EyeLidAnalysisSheet.upperLidAffectedRestPreLoc);
		lowerLidAffectedRestPre = super
				.intializeCell(EyeLidAnalysisSheet.lowerLidAffectedRestPreLoc);

		upper2lowerHealthyEyePre = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerHealthyEyePreLoc);
		upper2lowerAffectedEyePre = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerAffectedEyePreLoc);
		upper2lowerHealthySmilePre = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerHealthySmilePreLoc);
		upper2lowerAffectedSmilePre = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerAffectedSmilePreLoc);

		upperLidHealthyRestPost = super
				.intializeCell(EyeLidAnalysisSheet.upperLidHealthyRestPostLoc);
		lowerLidHealthyRestPost = super
				.intializeCell(EyeLidAnalysisSheet.lowerLidHealthyRestPostLoc);
		upperLidAffectedRestPost = super
				.intializeCell(EyeLidAnalysisSheet.upperLidAffectedRestPostLoc);
		lowerLidAffectedRestPost = super
				.intializeCell(EyeLidAnalysisSheet.lowerLidAffectedRestPostLoc);

		upper2lowerHealthyEyePost = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerHealthyEyePostLoc);
		upper2lowerAffectedEyePost = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerAffectedEyePostLoc);
		upper2lowerHealthySmilePost = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerHealthySmilePostLoc);
		upper2lowerAffectedSmilePost = super
				.intializeCell(EyeLidAnalysisSheet.upper2lowerAffectedSmilePostLoc);

		superiorLidMalposition = super
				.intializeCell(EyeLidAnalysisSheet.superiorLidMalpositionLoc);
		inferiorLidMalposition = super
				.intializeCell(EyeLidAnalysisSheet.inferiorLidMalpositionLoc);
		palpebralWidthExcess = super
				.intializeCell(EyeLidAnalysisSheet.palpebralWidthExcessLoc);
		lagophthalmosPre = super
				.intializeCell(EyeLidAnalysisSheet.lagophthalmosPreLoc);
		synkineticPre = super
				.intializeCell(EyeLidAnalysisSheet.synkineticPreLoc);
		lagophthalmosPost = super
				.intializeCell(EyeLidAnalysisSheet.lagophthalmosPostLoc);
		synkineticPost = super
				.intializeCell(EyeLidAnalysisSheet.synkineticPostLoc);

	}

	// Setters

	public void setUpperLid(double val, boolean preIntervention,
			boolean healthySide, boolean rest) {

		if (rest) {
			if (healthySide) {
				if (preIntervention) {
					this.upperLidHealthyRestPre.setValue(val);
				} else {
					this.upperLidHealthyRestPost.setValue(val);
				}
			} else {
				if (preIntervention) {
					this.upperLidAffectedRestPre.setValue(val);
				} else {
					this.upperLidAffectedRestPost.setValue(val);
				}
			}
		}
	}

	public void setLowerLid(double val, boolean preIntervention,
			boolean healthySide, boolean rest) {

		if (rest) {
			if (healthySide) {
				if (preIntervention) {
					this.lowerLidHealthyRestPre.setValue(val);
				} else {
					this.lowerLidHealthyRestPost.setValue(val);
				}
			} else {
				if (preIntervention) {
					this.lowerLidAffectedRestPre.setValue(val);
				} else {
					this.lowerLidAffectedRestPost.setValue(val);
				}
			}
		}
	}

	public void setUpperToLower(double val, boolean preIntervention,
			boolean healthySide, boolean rest) {

		if (rest) {
			if (healthySide) {
				if (preIntervention) {
					this.upper2lowerHealthyEyePre.setValue(val);
				} else {
					this.upper2lowerHealthyEyePost.setValue(val);
				}
			} else {
				if (preIntervention) {
					this.upper2lowerAffectedEyePre.setValue(val);
				} else {
					this.upper2lowerAffectedEyePost.setValue(val);
				}
			}
		} else {
			if (healthySide) {
				if (preIntervention) {
					this.upper2lowerHealthySmilePre.setValue(val);
				} else {
					this.upper2lowerHealthySmilePost.setValue(val);
				}
			} else {
				if (preIntervention) {
					this.upper2lowerAffectedSmilePre.setValue(val);
				} else {
					this.upper2lowerAffectedSmilePost.setValue(val);
				}
			}
		}

	}

	public void setOthers() {

		if (this.upperLidAffectedRestPre.getValue() != ExcelEntry.DEFAULT_VALUE
				&& this.upperLidHealthyRestPre.getValue() != ExcelEntry.DEFAULT_VALUE) {

			double val = this.upperLidAffectedRestPre.getValue()
					- this.upperLidHealthyRestPre.getValue();
			this.superiorLidMalposition.setValue(val);
		}

		if (this.lowerLidAffectedRestPre.getValue() != ExcelEntry.DEFAULT_VALUE
				&& this.lowerLidHealthyRestPre.getValue() != ExcelEntry.DEFAULT_VALUE) {

			double val = this.lowerLidAffectedRestPre.getValue()
					- this.lowerLidHealthyRestPre.getValue();
			this.inferiorLidMalposition.setValue(val);
		}

		if (this.superiorLidMalposition.getValue() != ExcelEntry.DEFAULT_VALUE
				&& this.inferiorLidMalposition.getValue() != ExcelEntry.DEFAULT_VALUE) {
			double val = this.superiorLidMalposition.getValue()
					+ this.inferiorLidMalposition.getValue();
			this.palpebralWidthExcess.setValue(val);
		}

		if (this.upper2lowerAffectedEyePre.getValue() != ExcelEntry.DEFAULT_VALUE) {
			this.lagophthalmosPre.setValue(this.upper2lowerAffectedEyePre
					.getValue());
		}

		if (this.upper2lowerHealthySmilePre.getValue() != ExcelEntry.DEFAULT_VALUE
				&& this.upper2lowerAffectedSmilePre.getValue() != ExcelEntry.DEFAULT_VALUE) {
			double val = this.upper2lowerHealthySmilePre.getValue()
					- this.upper2lowerAffectedSmilePre.getValue();
			this.synkineticPre.setValue(val);
		}

		if (this.upper2lowerAffectedEyePre.getValue() != ExcelEntry.DEFAULT_VALUE
				&& this.upper2lowerAffectedEyePost.getValue() != ExcelEntry.DEFAULT_VALUE) {
			double val = this.upper2lowerAffectedEyePost.getValue()
					- this.upper2lowerAffectedEyePre.getValue();
			this.lagophthalmosPost.setValue(val);
		}

		if (this.upper2lowerAffectedSmilePre.getValue() != ExcelEntry.DEFAULT_VALUE
				&& this.upper2lowerAffectedSmilePost.getValue() != ExcelEntry.DEFAULT_VALUE) {
			double val = this.upper2lowerAffectedSmilePre.getValue()
					- this.upper2lowerAffectedSmilePost.getValue();
			this.synkineticPost.setValue(val);
		}
	}
}
