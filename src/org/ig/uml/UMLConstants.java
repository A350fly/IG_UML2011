package org.ig.uml;

import java.util.Locale;
import java.util.ResourceBundle;

public interface UMLConstants { 
	public static final String TITLE_KEY = "title";
	public static final String RS_NAME = "rs";
	public static final String LOCALE = "fr";
	public static final String FILE_KEY = "file";
	public static final String EDIT_KEY = "edit";
	public static final String HELP_KEY = "help";
	public static final String GENERATION_KEY = "generation";
	public static final String NEW_KEY = "new";
	public static final String OPEN_KEY = "open";
	public static final String SAVE_KEY = "save";
	public static final String SAVE_AS_KEY = "saveas";
	public static final String QUIT_KEY = "quit";
	public static final String UNDO_KEY = "undo";
	public static final String REDO_KEY = "redo";
	public static final String CUT_KEY = "cut";
	public static final String COPY_KEY = "copy";
	public static final String PASTE_KEY = "paste";
	public static final String GENERATE_CODE_KEY = "generate_code";
	public static final String A_PROPOS_KEY = "about";
	public static final String EXPORT_GRAPHIC_KEY = "export_graphic";
	public static final String PREFERENCES_KEY = "preferences";
	
	public static Locale currentLocale  = new Locale(LOCALE);
	public static ResourceBundle rs = ResourceBundle.getBundle(RS_NAME, currentLocale);
	
	public static final String TITLE = rs.getString(TITLE_KEY);
	public static final String FILE = rs.getString(FILE_KEY);
	public static final String EDIT = rs.getString(EDIT_KEY);
	public static final String HELP = rs.getString(HELP_KEY);
	public static final String GENERATION = rs.getString(GENERATION_KEY);
	public static final String NEW = rs.getString(NEW_KEY);
	public static final String OPEN = rs.getString(OPEN_KEY);
	public static final String SAVE = rs.getString(SAVE_KEY);
	public static final String SAVE_AS = rs.getString(SAVE_AS_KEY);
	public static final String QUIT = rs.getString(QUIT_KEY);
	public static final String REDO = rs.getString(REDO_KEY);
	public static final String UNDO = rs.getString(UNDO_KEY);
	public static final String CUT = rs.getString(CUT_KEY);
	public static final String COPY = rs.getString(COPY_KEY);
	public static final String PASTE = rs.getString(PASTE_KEY);
	public static final String GENERATE_CODE = rs.getString(GENERATE_CODE_KEY);
	public static final String A_PROPOS = rs.getString(A_PROPOS_KEY);
	public static final String EXPORT_GRAPHIC = rs.getString(EXPORT_GRAPHIC_KEY);
	public static final String PREFERENCES = rs.getString(PREFERENCES_KEY);
	
	public static final int WIDTH_FRAME = 500;
	public static final int HEIGHT_FRAME = 500;
	public static final int WIDTH_MIN_FRAME = 200;
	public static final int HEIGHT_MIN_FRAME = 200;
}
