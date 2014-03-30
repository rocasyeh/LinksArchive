import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$
	public static String Main_0;
	public static String Main_txtMntmAbout;
	public static String Main_txtMntmFile;
	public static String Main_txtMntmFile_Exit;
	public static String Main_txtMntmFile_New;
	public static String Main_txtMntmFile_Open;
	public static String Main_txtMntmFile_Save;
	public static String Main_txtMntmFile_SaveAndNew;
	public static String Main_txtMntmFile_SaveAs;
	public static String Main_txtMntmTools;
	public static String Main_mntmOption_text;
	public static String Main_mntmAboutLinkarchive_text;
	public static String Main_btnSavenew_text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
