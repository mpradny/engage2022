package app;

import java.io.Serializable;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.extlib.util.ExtLibUtil;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.NoteCollection;
import lotus.domino.NotesException;

public class Settings implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String databaseVersion = null;
	
	public String getDatabaseVersion() {
		if (databaseVersion == null) {
			databaseVersion = "dev";
			try {
				Database database = ExtLibUtil.getCurrentDatabase();
				NoteCollection nc = database.createNoteCollection(false);
				nc.setSelectSharedFields(true);
				nc.buildCollection();
				String strNoteID = nc.getFirstNoteID();
				while (StringUtil.isNotEmpty(strNoteID)) {
					String tmpid = nc.getNextNoteID(strNoteID);
					Document doc = database.getDocumentByID(strNoteID);
					if (doc.hasItem("$TemplateBuild")) {
						databaseVersion = doc.getItemValueString("$TemplateBuild");
					}

					doc.recycle();
					strNoteID = tmpid;
				}
			} catch (NotesException e) {
				e.printStackTrace();
			}
		}

		return databaseVersion;
	}
}
