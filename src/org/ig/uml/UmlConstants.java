package org.ig.uml;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;

public interface UmlConstants {
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
	public static final String NEW_CLASS_KEY= "new_class"; 
	public static final String NEW_ASSOCIATION_KEY  = "new_association";
	public static final String NEW_UNI_ASSOCIATION_KEY  = "new_uni_association";
	public static final String NEW_AGGREGATION_KEY = "new_aggregation";
	public static final String NEW_GENERALIZATION_KEY = "new_generalization";
	public static final String NEW_COMPOSITION_KEY = "new_composition";
	public static final String NEW_INTERFACE_KEY = "new_interface";
	public static final String NEW_REALIZATION_KEY = "new_realization";
	public static final String NEW_DEPENDENCY_KEY = "new_dependency";
	public static final String NEW_ATTRIBUTE_KEY = "new_attribute";
	public static final String NEW_OPERATION_KEY = "new_operation";
	public static final String ABOUT_TITLE_KEY = "about_title";
	public static final String VERSION_KEY = "version";
	public static final String LANGUAGE_KEY = "language";
	public static final String CLOSE_KEY = "close";
	public static final String DESCRIPTION_KEY = "description";
	public static final String COPYRIGHT_KEY = "copyright";
	public static final String SAVE_QUIT_KEY = "save_quit";
	public static final String NO_SAVE_QUIT_KEY = "no_save_quit";
	public static final String CANCEL_KEY = "cancel";
	public static final String UNSAVED_CHANGE_KEY = "unsaved_change";
	public static final String CHOOSE_FOLDER_KEY = "choose_folder";
	public static final String WARNING_KEY = "warning";
	public static final String EXPORT_IMAGE_KEY = "export_image";
	public static final String UNSAVED_FILE_KEY = "unsaved_file";
	public static final String SAVE_NEW_KEY = "save_new";
	public static final String NO_SAVE_NEW_KEY = "no_save_new";
	public static final String UNSAVED_CHANGE_NEW_KEY = "unsaved_change_new";
	
	
	public static Locale currentLocale = new Locale(LOCALE);
	public static ResourceBundle rs = ResourceBundle.getBundle(RS_NAME,
			currentLocale);

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
	public static final String EXPORT_GRAPHIC = rs
			.getString(EXPORT_GRAPHIC_KEY);
	public static final String PREFERENCES = rs.getString(PREFERENCES_KEY);
	public static final String NEW_CLASS= rs.getString(NEW_CLASS_KEY); 
	public static final String NEW_ASSOCIATION  = rs.getString(NEW_ASSOCIATION_KEY);
	public static final String NEW_UNI_ASSOCIATION  = rs.getString(NEW_UNI_ASSOCIATION_KEY); public static final String NEW_AGGREGATION = rs.getString(NEW_AGGREGATION_KEY);
	public static final String NEW_GENELIZATION = rs.getString(NEW_GENERALIZATION_KEY);
	public static final String NEW_COMPOSITION = rs.getString(NEW_COMPOSITION_KEY);
	public static final String NEW_INTERFACE = rs.getString(NEW_INTERFACE_KEY);
	public static final String NEW_REALIZATION = rs.getString(NEW_REALIZATION_KEY);
	public static final String NEW_DEPENDENCY = rs.getString(NEW_DEPENDENCY_KEY);
	public static final String NEW_ATTRIBUTE = rs.getString(NEW_ATTRIBUTE_KEY);
	public static final String NEW_OPERATION = rs.getString(NEW_OPERATION_KEY);
	public static final String ABOUT_TITLE = rs.getString(ABOUT_TITLE_KEY);
	public static final String VERSION = rs.getString(VERSION_KEY);
	public static final String LANGUAGE = rs.getString(LANGUAGE_KEY);
	public static final String CLOSE = rs.getString(CLOSE_KEY);
	public static final String DESCRIPTION = rs.getString(DESCRIPTION_KEY);
	public static final String COPYRIGHT = rs.getString(COPYRIGHT_KEY);
	public static final String SAVE_QUIT = rs.getString(SAVE_QUIT_KEY);
	public static final String NO_SAVE_QUIT = rs.getString(NO_SAVE_QUIT_KEY);
	public static final String CANCEL = rs.getString(CANCEL_KEY);
	public static final String UNSAVED_CHANGE = rs.getString(UNSAVED_CHANGE_KEY);
	public static final String CHOOSE_FOLDER = rs.getString(CHOOSE_FOLDER_KEY);
	public static final String WARNING = rs.getString(WARNING_KEY);
	public static final String EXPORT_IMAGE = rs.getString(EXPORT_IMAGE_KEY);
	public static final String UNSAVED_FILE = rs.getString(UNSAVED_FILE_KEY);
	public static final String SAVE_NEW = rs.getString(SAVE_NEW_KEY);
	public static final String NO_SAVE_NEW = rs.getString(NO_SAVE_NEW_KEY);
	public static final String UNSAVED_CHANGE_NEW = rs.getString(UNSAVED_CHANGE_NEW_KEY);
	
	public static final int WIDTH_FRAME = 700;
	public static final int HEIGHT_FRAME = 700;
	public static final int WIDTH_MIN_FRAME = 200;
	public static final int HEIGHT_MIN_FRAME = 200;
	public static final ImageIcon ICON_NEW_CLASS = new ImageIcon(
			"res/drawable/Class.gif");
	public static final ImageIcon ICON_NEW_ASSOCIATION = new ImageIcon(
			"res/drawable/Association.gif");
	public static final ImageIcon ICON_NEW_UNI_ASSOCIATION = new ImageIcon(
			"res/drawable/UniAssociation.gif");
	public static final ImageIcon ICON_NEW_AGGREGATION = new ImageIcon(
			"res/drawable/Aggregation.gif");
	public static final ImageIcon ICON_NEW_GENERALIZATION = new ImageIcon(
			"res/drawable/Generalization.gif");
	public static final ImageIcon ICON_NEW_COMPOSITION = new ImageIcon(
			"res/drawable/Composition.gif");
	public static final ImageIcon ICON_NEW_INTERFACE = new ImageIcon(
			"res/drawable/Interface.gif");
	public static final ImageIcon ICON_NEW_REALIZATION = new ImageIcon(
			"res/drawable/Realization.gif");
	public static final ImageIcon ICON_NEW_DEPENDENCY = new ImageIcon(
			"res/drawable/Dependency.gif");
	public static final ImageIcon ICON_NEW_ATTRIBUTE = new ImageIcon(
			"res/drawable/Attribute.gif");
	public static final ImageIcon ICON_NEW_OPERATION = new ImageIcon(
			"res/drawable/AddOperation.gif");
	public static final ImageIcon ICON_NEW_FILE = new ImageIcon(
			"res/drawable/New.gif");
	public static final ImageIcon ICON_OPEN = new ImageIcon(
			"res/drawable/Open.gif");
	public static final ImageIcon ICON_SAVE = new ImageIcon(
			"res/drawable/Save.gif");
	public static final ImageIcon ICON_SAVE_AS = new ImageIcon(
			"res/drawable/SaveAs.gif");
}
