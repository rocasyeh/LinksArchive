package com.linksarchive;
import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$
	public static String MainTxt_title;
	public static String MainTxt_mntmFile;
	public static String MainTxt_mntmFileExit;
	public static String MainTxt_mntmFileNew;
	public static String MainTxt_mntmFileOpen;
	public static String MainTxt_mntmFileSave;
	public static String MainTxt_mntmFileSaveAs;
	public static String MainTxt_mntmFileSaveNew;
	public static String MainTxt_mntmHelp;
	public static String MainTxt_mntmHelpAbout;
	public static String MainTxt_mntmTools;
	public static String MainTxt_mntmToolsOptions;
	public static String MainTxt_btnSaveNew;
	public static String MainTxt_btnSave;
	public static String MainTxt_btnNew;
	public static String MainTxt_tltmSavenew;
	public static String MainTxt_tltmSave;
	public static String MainTxt_tltmNew;
	public static String MainTxt_lblArchiveSn;
	public static String MainTxt_lblArchiveName;
	public static String MainTxt_lblLinks;
	public static String OptionsTxt_title;
	public static String OptionsTxt_lblDefFilePath;
	public static String OptionsTxt_btnDefFilePath;
	public static String OptionsTxt_btnApply;
	public static String OptionsTxt_btnOk;
	public static String OptionsTxt_btnCancel;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
