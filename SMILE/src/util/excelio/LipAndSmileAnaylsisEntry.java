package util.excelio;

import jxl.Sheet;
import jxl.write.Number;

/**
 * LipAndSmileAnaylsisEntry is an ExcelEntry which contains data for the Lip and
 * Smile FACE function
 * 
 * @author Luke
 * 
 */
public class LipAndSmileAnaylsisEntry extends ExcelEntry {

	private final Number upperPreRestLipDeviation;
	private final Number cornerPreRestMouthDeviation;
	private final Number lowerPreRestLipDeviation;
	private final Number upperPostRestLipDeviation;
	private final Number cornerPostRestMouthDeviation;
	private final Number lowerPostRestLipDeviation;
	private final Number upperPostGestureLipDeviation;
	private final Number cornerPostGestureMouthDeviation;
	private final Number lowerPostGestureLipDeviation;
	private final Number upperPreGestureLipDeviation;
	private final Number cornerPreGestureMouthDeviation;
	private final Number lowerPreGestureLipDeviation;
	
	public final Number aPreHealthy;
	public final Number bPreHealthy;
	public final Number cPreHealthy;
	public final Number thetaPreHealthy;

	public final Number aPostHealthy;
	public final Number bPostHealthy;
	public final Number cPostHealthy;
	public final Number thetaPostHealthy;

	public final Number aPreAffected;
	public final Number bPreAffected;
	public final Number cPreAffected;
	public final Number thetaPreAffected;

	public final Number aPostAffected;
	public final Number bPostAffected;
	public final Number cPostAffected;
	public final Number thetaPostAffected;

	/**
	 * Constructor which reads from Excel file
	 * 
	 * @param sheet
	 * @param line
	 */
	public LipAndSmileAnaylsisEntry(Sheet sheet, int line) {
		super(sheet, line);


		upperPreRestLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.upperPreRestLipDeviationLoc, sheet, line);
		cornerPreRestMouthDeviation = readInCell(
				LipAndSmileAnaylsisSheet.cornerPreRestMouthDeviationLoc, sheet, line);
		lowerPreRestLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.lowerPreRestLipDeviationLoc, sheet, line);
		
		
		upperPostRestLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.upperPostRestLipDeviationLoc, sheet, line);
		cornerPostRestMouthDeviation = readInCell(
				LipAndSmileAnaylsisSheet.cornerPostRestMouthDeviationLoc, sheet, line);
		lowerPostRestLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.lowerPostRestLipDeviationLoc, sheet, line);
		

		upperPostGestureLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.upperPostGestureLipDeviationLoc, sheet, line);
		cornerPostGestureMouthDeviation = readInCell(
				LipAndSmileAnaylsisSheet.cornerPostGestureMouthDeviationLoc, sheet, line);
		lowerPostGestureLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.lowerPostGestureLipDeviationLoc, sheet, line);

		
		upperPreGestureLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.upperPreGestureLipDeviationLoc, sheet, line);
		cornerPreGestureMouthDeviation = readInCell(
				LipAndSmileAnaylsisSheet.cornerPreGestureMouthDeviationLoc, sheet, line);
		lowerPreGestureLipDeviation = readInCell(
				LipAndSmileAnaylsisSheet.lowerPreGestureLipDeviationLoc, sheet, line);
		
		
		aPreHealthy= readInCell(LipAndSmileAnaylsisSheet.aPreHealthy , sheet, line);
		bPreHealthy= readInCell(LipAndSmileAnaylsisSheet.bPreHealthy , sheet, line);
		cPreHealthy= readInCell(LipAndSmileAnaylsisSheet.cPreHealthy , sheet, line);
		thetaPreHealthy= readInCell(LipAndSmileAnaylsisSheet.thetaPreHealthy , sheet, line);

		aPostHealthy= readInCell(LipAndSmileAnaylsisSheet.aPostHealthy , sheet, line);
		bPostHealthy= readInCell(LipAndSmileAnaylsisSheet.bPostHealthy , sheet, line);		
		cPostHealthy= readInCell(LipAndSmileAnaylsisSheet.cPostHealthy , sheet, line);
		thetaPostHealthy= readInCell(LipAndSmileAnaylsisSheet.thetaPostHealthy , sheet, line);
		
		aPreAffected= readInCell(LipAndSmileAnaylsisSheet.aPreAffected , sheet, line);
		bPreAffected= readInCell(LipAndSmileAnaylsisSheet.bPreAffected , sheet, line);
		cPreAffected= readInCell(LipAndSmileAnaylsisSheet.cPreAffected , sheet, line);
		thetaPreAffected= readInCell(LipAndSmileAnaylsisSheet.thetaPreAffected , sheet, line);

		aPostAffected= readInCell(LipAndSmileAnaylsisSheet.aPostAffected , sheet, line);
		bPostAffected= readInCell(LipAndSmileAnaylsisSheet.bPostAffected , sheet, line);
		cPostAffected= readInCell(LipAndSmileAnaylsisSheet.cPostAffected , sheet, line);
		thetaPostAffected= readInCell(LipAndSmileAnaylsisSheet.thetaPostAffected , sheet, line);
		
	}

	/**
	 * Constructor which creates a new blank entry
	 * 
	 * @param id
	 * @param session
	 */
	public LipAndSmileAnaylsisEntry(int id, int session) {
		super(id, session);

		upperPreRestLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.upperPreRestLipDeviationLoc);
		cornerPreRestMouthDeviation = intializeCell(LipAndSmileAnaylsisSheet.cornerPreRestMouthDeviationLoc);
		lowerPreRestLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.lowerPreRestLipDeviationLoc);

		upperPostRestLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.upperPostRestLipDeviationLoc);
		cornerPostRestMouthDeviation = intializeCell(LipAndSmileAnaylsisSheet.cornerPostRestMouthDeviationLoc);
		lowerPostRestLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.lowerPostRestLipDeviationLoc);
		
		upperPostGestureLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.upperPostGestureLipDeviationLoc);
		cornerPostGestureMouthDeviation = intializeCell(LipAndSmileAnaylsisSheet.cornerPostGestureMouthDeviationLoc);
		lowerPostGestureLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.lowerPostGestureLipDeviationLoc);

		upperPreGestureLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.upperPreGestureLipDeviationLoc);
		cornerPreGestureMouthDeviation = intializeCell(LipAndSmileAnaylsisSheet.cornerPreGestureMouthDeviationLoc);
		lowerPreGestureLipDeviation = intializeCell(LipAndSmileAnaylsisSheet.lowerPreGestureLipDeviationLoc);
		

		aPreHealthy= intializeCell(LipAndSmileAnaylsisSheet.aPreHealthy);
		bPreHealthy= intializeCell(LipAndSmileAnaylsisSheet.bPreHealthy);
		cPreHealthy= intializeCell(LipAndSmileAnaylsisSheet.cPreHealthy);
		thetaPreHealthy= intializeCell(LipAndSmileAnaylsisSheet.thetaPreHealthy);

		aPostHealthy= intializeCell(LipAndSmileAnaylsisSheet.aPostHealthy);
		bPostHealthy= intializeCell(LipAndSmileAnaylsisSheet.bPostHealthy);		
		cPostHealthy= intializeCell(LipAndSmileAnaylsisSheet.cPostHealthy);
		thetaPostHealthy= intializeCell(LipAndSmileAnaylsisSheet.thetaPostHealthy);
		
		aPreAffected= intializeCell(LipAndSmileAnaylsisSheet.aPreAffected);
		bPreAffected= intializeCell(LipAndSmileAnaylsisSheet.bPreAffected);
		cPreAffected= intializeCell(LipAndSmileAnaylsisSheet.cPreAffected);
		thetaPreAffected= intializeCell(LipAndSmileAnaylsisSheet.thetaPreAffected);

		aPostAffected= intializeCell(LipAndSmileAnaylsisSheet.aPostAffected);
		bPostAffected= intializeCell(LipAndSmileAnaylsisSheet.bPostAffected);
		cPostAffected= intializeCell(LipAndSmileAnaylsisSheet.cPostAffected);
		thetaPostAffected= intializeCell(LipAndSmileAnaylsisSheet.thetaPostAffected);
		
	}


	
	public void setLipDeviations(double lower, double upper, double corner, boolean pre, boolean rest) {
		if(pre) {
			if(rest) {
				this.upperPreRestLipDeviation.setValue(upper);
				this.lowerPreRestLipDeviation.setValue(lower);
				this.cornerPreRestMouthDeviation.setValue(corner);
				
			} else {
				this.upperPreGestureLipDeviation.setValue(upper);
				this.lowerPreGestureLipDeviation.setValue(lower);
				this.cornerPreGestureMouthDeviation.setValue(corner);
				
			}
		} else {
			if(rest) {
				this.upperPostRestLipDeviation.setValue(upper);
				this.lowerPostRestLipDeviation.setValue(lower);
				this.cornerPostRestMouthDeviation.setValue(corner);
	
			} else {
				this.upperPostGestureLipDeviation.setValue(upper);	
				this.lowerPostGestureLipDeviation.setValue(lower);	
				this.cornerPostGestureMouthDeviation.setValue(corner);	
			}
		}
	}
	
	public void setABCTheta(double a, double b, double c, double theta, boolean pre, boolean healthy) {
		if(pre)
			if(healthy) {
				this.aPreHealthy.setValue(a);
				this.bPreHealthy.setValue(b);
				this.cPreHealthy.setValue(c);
				this.thetaPreHealthy.setValue(theta);
			}
			else {

				this.aPreAffected.setValue(a);
				this.bPreAffected.setValue(b);
				this.cPreAffected.setValue(c);
				this.thetaPreAffected.setValue(theta);
			}
		else {
			if(healthy) {

				this.aPostHealthy.setValue(a);
				this.bPostHealthy.setValue(b);
				this.cPostHealthy.setValue(c);
				this.thetaPostHealthy.setValue(theta);
			}
			else {

				this.aPostAffected.setValue(a);
				this.bPostAffected.setValue(b);
				this.cPostAffected.setValue(c);
				this.thetaPostAffected.setValue(theta);
			}
		}
	}
	
}
