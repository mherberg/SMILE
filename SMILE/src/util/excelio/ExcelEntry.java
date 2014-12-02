package util.excelio;

import java.util.HashSet;

import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * An ExcelEntry an object which contains data saved from the FACE program for
 * one subject during one session An ExcelEntry can either be read from and
 * Excel file or created brand new.
 * 
 * The way the list of entries in the sheet will be populated is an ExcelSheet
 * object will read in a specific Excel file and go line by line trying to
 * create ExcelEntry. Each time it creates an ExcelEntry it will check to see if
 * the ExcelEntry is valid (has a valid ID and Session). Once it finds an entry
 * without an ID or session we assume that the function has reached the end of
 * the file and it will be done reading in the entries.
 * 
 * This is why we have the isValid() function
 * 
 * 
 * 
 * @author Luke
 * 
 */

public abstract class ExcelEntry implements Comparable<ExcelEntry> {

	protected final static int DEFAULT_VALUE = -1;

	protected final HashSet<Number> cells = new HashSet<Number>();
	protected final Number id;
	protected final Number session;

	/**
	 * Constructor that reads in an ExcelEntry object from a sheet
	 * 
	 * @param sheet
	 *            Sheet to read
	 * @param line
	 *            line in the sheet to read
	 */
	public ExcelEntry(Sheet sheet, int line) {
			
		this.id = readInCell(ExcelSheet.idLoc, sheet, line);		
		this.session = readInCell(ExcelSheet.sessionLoc, sheet, line);

	}

	/**
	 * Constructor that creates an new empty ExcelEntry object
	 * 
	 * @param id
	 * @param session
	 */
	public ExcelEntry(int id, int session) {

		this.id = setCell(ExcelSheet.idLoc, id);
		this.session = setCell(ExcelSheet.sessionLoc, session);
	}

	/**
	 * Function which reads in an ExcelSheet and spits back the cell value
	 * 
	 * @param loc
	 * @param sheet
	 * @param line
	 * @return
	 */
	protected Number readInCell(int loc, Sheet sheet, int line) {
		Number cell = new Number(loc, line, ExcelEntry.DEFAULT_VALUE);

		try {
			Cell temp = sheet.getCell(loc, line);

			if (temp.getType() == CellType.NUMBER)
				cell.setValue(((NumberCell) temp).getValue());

			this.cells.add(cell);
		} catch (Exception e) {
			// If there is a failure here, do nothing
			e.printStackTrace();
		}
		return cell;
	}

	/**
	 * Create an empty cell for a given position Default value of a cell is
	 * 'ExcelEntry.DEFAULT_VALUE;
	 * 
	 * @param loc
	 *            Location on ExcelSheet where this cell should be saved
	 * @return
	 */
	protected Number intializeCell(int loc) {
		return this.setCell(loc, ExcelEntry.DEFAULT_VALUE);
	}

	private Number setCell(int loc, int value) {
		Number cell = new Number(loc, 0, value);
		cells.add(cell);
		return cell;
	}

	/**
	 * Function which writes the current ExcelEntry object to a sheet
	 * 
	 * @param sheet
	 * @param line
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public void updateSheet(WritableSheet sheet, int line)
			throws RowsExceededException, WriteException {
		for (Number cell : cells) {
			if (cell.getValue() != ExcelEntry.DEFAULT_VALUE)
				sheet.addCell(cell.copyTo(cell.getColumn(), line));
		}
	}

	public Double getID() {
		return this.id.getValue();
	}

	public Double getSession() {
		return this.session.getValue();
	}

	/**
	 * A ExcelEntry is valid if it has an non-default ID and Session
	 * 
	 * @return
	 */
	public boolean isValid() {
		boolean valid = id.getValue() != ExcelEntry.DEFAULT_VALUE
				&& session.getValue() != ExcelEntry.DEFAULT_VALUE;

		return valid;
	}

	/**
	 * Comparison function Rank based on ID. If IDs tie, rank based on Session
	 * 
	 */
	public int compareTo(ExcelEntry entry) {

		int comparison = this.getID().compareTo(entry.getID());
		if (comparison == 0) {
			comparison = this.getSession().compareTo(entry.getSession());
		}

		return comparison;
	}

	/**
	 * Two ExcelEntries are equal if they have the same ID and Session
	 * 
	 * @param e
	 * @return
	 */
	public boolean equals(ExcelEntry e) {

		return this.getID().equals(e.getID())
				&& this.getSession().equals(e.getSession());
	}

	public String toString() {
		String output = "("+this.id.getContents() + " "+this.session.getContents()+")";

		for (Number cell : this.cells) {
			String value;

			if (cell.getValue() != ExcelEntry.DEFAULT_VALUE)
				value = "x";
			else
				value = cell.getContents();

			output = output.concat(value + " ");
		}

		return output;
	}

}
