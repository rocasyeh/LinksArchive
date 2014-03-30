import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Button;


public class Main {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(535, 426);
		shell.setText(Messages.Main_0);

		/**
		 * Create a menu bar 
		 */
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);
		
		/**
		 * Create a menu set "File" 
		 */
		MenuItem mntmFile = new MenuItem(menuBar, SWT.CASCADE);
		mntmFile.setText(Messages.Main_txtMntmFile);
		
		Menu mncmFile = new Menu(mntmFile);
		mntmFile.setMenu(mncmFile);
		
		// create a menu item "File->New"
		MenuItem mntmFile_New = new MenuItem(mncmFile, SWT.NONE);
		mntmFile_New.setText(Messages.Main_txtMntmFile_New);

		// create a menu item "File->Open..."
		MenuItem mntmFile_Open = new MenuItem(mncmFile, SWT.NONE);
		mntmFile_Open.setText(Messages.Main_txtMntmFile_Open);

		// create a menu item "File->Save"
		MenuItem mntmFile_Save = new MenuItem(mncmFile, SWT.NONE);
		mntmFile_Save.setText(Messages.Main_txtMntmFile_Save);

		// create a menu item "File->Save and New"
		MenuItem mntmFile_SaveNew = new MenuItem(mncmFile, SWT.NONE);
		mntmFile_SaveNew.setText(Messages.Main_txtMntmFile_SaveAndNew);

		// create a menu item "File->Save As..."
		MenuItem mntmFile_SaveAs = new MenuItem(mncmFile, SWT.NONE);
		mntmFile_SaveAs.setText(Messages.Main_txtMntmFile_SaveAs);

		// create a menu item "File->Exit"
		MenuItem mntmFile_Exit = new MenuItem(mncmFile, SWT.NONE);
		mntmFile_Exit.setText(Messages.Main_txtMntmFile_Exit);

		/**
		 * Create a menu set "Tools" 
		 */
		MenuItem mntmTools = new MenuItem(menuBar, SWT.CASCADE);
		mntmTools.setText(Messages.Main_txtMntmTools);
		
		Menu mncmTools = new Menu(mntmTools);
		mntmTools.setMenu(mncmTools);
		
		MenuItem mntmTools_Options = new MenuItem(mncmTools, SWT.NONE);
		mntmTools_Options.setText(Messages.Main_mntmOption_text);


		/**
		 * Create a menu set "Help" 
		 */
		MenuItem mntmHelp = new MenuItem(menuBar, SWT.CASCADE);
		mntmHelp.setText(Messages.Main_txtMntmAbout);
		
		Menu mncmHelp = new Menu(mntmHelp);
		mntmHelp.setMenu(mncmHelp);
		
		MenuItem mntmHelp_About = new MenuItem(mncmHelp, SWT.NONE);
		mntmHelp_About.setText(Messages.Main_mntmAboutLinkarchive_text);
		
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(0, 0, 517, 41);

	}
}
