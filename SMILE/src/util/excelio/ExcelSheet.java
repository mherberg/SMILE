package util.excelio;

import java.util.TreeSet;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * An ExcelSheet reads and writes ExcelEntrys to an Excel file
 * 
 * An ExcelSheet populates its list of entries by creating an empty set. It then
 * reads line by line until it reaches the end of the file These entries are
 * ordered based on ID. If ID's match, then Sessions break ties.
 * 
 * This class will find ExcelEntries for a given ID and Session, allowing the
 * entry to be manipulated.
 * 
 * *
 * 
 * @author Luke
 * 
 */
public abstract class ExcelSheet {

	public static final int idLoc = 0;
	public static final int sessionLoc = 1;

	protected final TreeSet<ExcelEntry> entries = new TreeSet<ExcelEntry>();

	/**
	 * Basic initialization, all ExcelSheets need to add columns for ID and
	 * Session information
	 * 
	 * @param sheet
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void initSheet(WritableSheet sheet)
			throws RowsExceededException, WriteException {

		Label id = new Label(idLoc, 0, "ID");
		Label session = new Label(sessionLoc, 0, "Session");

		sheet.addCell(id);
		sheet.addCell(session);
	}

	/**
	 * Function adds an new entry to the set of entries
	 * 
	 * @param entry
	 */
	public void addEntry(ExcelEntry entry) {
		this.entries.add(entry);
	}

	/**
	 * Write the current set of entries to an Excel file
	 * 
	 * @param sheet
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public void updateSheet(WritableSheet sheet) throws RowsExceededException,
			WriteException {

		// Start at line 1 because line 0 is label information
		int line = 1;

		for (ExcelEntry e : entries) {
			e.updateSheet(sheet, line);
			line++;
		}

	}

	/**
	 * Check if the given entry is in the set of entries, if it is return it
	 * else return back original entry
	 * 
	 * 
	 * @param entry
	 * @return
	 */
	protected ExcelEntry getEntry(ExcelEntry entry) {

		// This function is used to find previous entries
		//
		// the class will be asked to find an entry for a given ID and Session
		// it will create an empty class then check if the ID and Session exists
		// if it does, it will update the old entry
		// else it will update the new empty entry

		for (ExcelEntry e : this.entries) {			
			if (e.equals(entry)) {
				this.entries.remove(e);
				entry = e;
				break;
			}
		}

		return entry;
	}

}
