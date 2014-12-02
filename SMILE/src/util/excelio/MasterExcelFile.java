package util.excelio;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * The MasterExcelFile contains all the ExcelSheets for the FACE program It will
 * create a new Excel file if one does not already exist
 * 
 * Use this to write all entries to file
 * 
 * @author Luke
 * 
 */
public class MasterExcelFile {
	private static final String userName = System.getProperty("user.name");
//	private static final String windowsFileLocation = "C:\\Documents and Settings\\"+userName+"\\My Documents\\SMILE.xls";
	private static final String windowsFileLocation = "~\\Documents\\SMILE.xls";
	private static final String macFileLocation = "~\\Documents\\SMILE.xls";
	
	public static final String browPosition = "Brow Position Analysis";
	public static final String eyelid = "Eye Lid Analysis";
	public static final String nasalBase = "Nasal Base Analysis";
	public static final String philtralDeviation = "Philtral Deviation Analysis";
	public static final String lipAndSmile = "Lip and Smile Analysis";
	private WritableWorkbook book;

	private BrowPositionAnalysisSheet browPositionAnalysisSheet;
	private EyeLidAnalysisSheet eyeLidAnalysisSheet;
	private NasalBaseAnalysisSheet nasalBaseAnalysisSheet;
	private PhiltralDeviationAnalysisSheet philtralDeviationAnalysisSheet;
	private LipAndSmileAnaylsisSheet lipAndSmileAnaylsisSheet;

	public MasterExcelFile() {
		this.createMasterExcelFile();
		this.browPositionAnalysisSheet = new BrowPositionAnalysisSheet(this);
		this.eyeLidAnalysisSheet = new EyeLidAnalysisSheet(this);
		this.nasalBaseAnalysisSheet = new NasalBaseAnalysisSheet(this);
		this.philtralDeviationAnalysisSheet = new PhiltralDeviationAnalysisSheet(
				this);
		this.lipAndSmileAnaylsisSheet = new LipAndSmileAnaylsisSheet(this);
	}

	/**
	 * Either read in the old Excel file or create a new one

	 */
	private void createMasterExcelFile()  {

		File windowsFile = new File(windowsFileLocation);
		File macFile = new File(macFileLocation);
		
		WritableWorkbook workbook = null;
		// If file does not exist, create it
		
		if (!windowsFile.exists() && !macFile.exists()) {
			
			try {
				workbook = Workbook.createWorkbook(windowsFile);
				
			} catch (IOException e) {
				
				try {
					workbook = Workbook.createWorkbook(windowsFile);
					
				}
				catch (IOException e1) {
				e1.printStackTrace();
				}
			}


			WritableSheet browPositionAnalysis = workbook.createSheet(
					browPosition, 0);
			WritableSheet eyeLidAnalysis = workbook.createSheet(eyelid, 1);
			WritableSheet nasalBaseAnalysis = workbook.createSheet(
					nasalBase, 2);
			WritableSheet philtralDeviationAnalysis = workbook.createSheet(
					philtralDeviation, 3);
			WritableSheet lipAndSmileAnalysis = workbook.createSheet(
					lipAndSmile, 4);

			try {
				BrowPositionAnalysisSheet.initSheet(browPositionAnalysis);
				EyeLidAnalysisSheet.initSheet(eyeLidAnalysis);
				NasalBaseAnalysisSheet.initSheet(nasalBaseAnalysis);
				PhiltralDeviationAnalysisSheet
						.initSheet(philtralDeviationAnalysis);
				LipAndSmileAnaylsisSheet.initSheet(lipAndSmileAnalysis);

				workbook.write();
				workbook.close();
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		
			windowsFile = new File(windowsFileLocation);
		}

		try {
			Workbook readbook = Workbook.getWorkbook(windowsFile);
			this.book = Workbook.createWorkbook(windowsFile, readbook);

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This function allows ExcelSheet objects to find their sheet in the Excel
	 * file
	 * 
	 * @param name
	 * @return
	 */
	public Sheet getSheet(String name) {
		return this.book.getSheet(name);
	}

	/**
	 * This function must be the last action done on the MasterFile object, else
	 * all the data will be corrupted
	 */
	public void closeBook() {
		try {

			this.book.write();
			this.book.close();

		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Write all sheets to the Excel file
	 */
	public void updateSheets() {
		try {
			this.browPositionAnalysisSheet.updateSheet(book
					.getSheet(browPosition));
			this.eyeLidAnalysisSheet.updateSheet(book.getSheet(eyelid));
			this.lipAndSmileAnaylsisSheet.updateSheet(book
					.getSheet(lipAndSmile));
			this.nasalBaseAnalysisSheet.updateSheet(book.getSheet(nasalBase));
			this.philtralDeviationAnalysisSheet.updateSheet(book
					.getSheet(philtralDeviation));

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters
	public BrowPositionAnalysisSheet getBrowPositionAnalysisSheet() {
		return this.browPositionAnalysisSheet;
	}

	public EyeLidAnalysisSheet getEyeLidAnalysisSheet() {
		return this.eyeLidAnalysisSheet;
	}

	public NasalBaseAnalysisSheet getNasalBaseAnalysisSheet() {
		return this.nasalBaseAnalysisSheet;
	}

	public LipAndSmileAnaylsisSheet getLipAndSmileAnaylsisSheet() {
		return this.lipAndSmileAnaylsisSheet;
	}

	public PhiltralDeviationAnalysisSheet getPhiltralDeviationAnalysisSheet() {
		return this.philtralDeviationAnalysisSheet;
	}

	public static void main(String[] args) {
		MasterExcelFile file = new MasterExcelFile();
		NasalBaseAnalysisSheet sheet = file.getNasalBaseAnalysisSheet();
		NasalBaseAnalysisEntry entry = sheet.getEntry(68104,45);

		entry.setDeviation(1,true);
		sheet.addEntry(entry);

		file.updateSheets();
		file.closeBook();
		}

}
