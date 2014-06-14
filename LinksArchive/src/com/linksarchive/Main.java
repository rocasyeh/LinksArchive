package com.linksarchive;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;


public class Main {

	protected Shell shell;
	private Text txtArchiveSn;
	private Text txtArchiveName;
	private Text txtLinks;

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
	/**
	 * 
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(535, 426);
		shell.setText(Messages.Main_0);
		FormLayout fl_shell = new FormLayout();
		shell.setLayout(fl_shell);
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);
		
		/**
		 * Create a menu set "File" 
		 */
		MenuItem mntmFile = new MenuItem(menuBar, SWT.CASCADE);
		mntmFile.setText(Messages.Main_MntmFile_text);
		
		Menu mnFile = new Menu(mntmFile);
		mntmFile.setMenu(mnFile);
		
		// create a menu item "File->New"
		MenuItem mntmFile_New = new MenuItem(mnFile, SWT.NONE);
		mntmFile_New.setText(Messages.Main_MntmFileNew_text);

		// create a menu item "File->Open..."
		MenuItem mntmFile_Open = new MenuItem(mnFile, SWT.NONE);
		mntmFile_Open.setText(Messages.Main_MntmFileOpen_text);

		// create a menu item "File->Save"
		MenuItem mntmFile_Save = new MenuItem(mnFile, SWT.NONE);
		mntmFile_Save.setText(Messages.Main_MntmFileSave_text);

		// create a menu item "File->Save and New"
		MenuItem mntmFile_SaveNew = new MenuItem(mnFile, SWT.NONE);
		mntmFile_SaveNew.setText(Messages.Main_MntmFileSaveNew_text);

		// create a menu item "File->Save As..."
		MenuItem mntmFile_SaveAs = new MenuItem(mnFile, SWT.NONE);
		mntmFile_SaveAs.setText(Messages.Main_MntmFileSaveAs_text);

		// create a menu item "File->Exit"
		MenuItem mntmFile_Exit = new MenuItem(mnFile, SWT.NONE);
		mntmFile_Exit.setText(Messages.Main_MntmFileExit_text);

		/**
		 * Create a menu set "Tools" 
		 */
		MenuItem mntmTools = new MenuItem(menuBar, SWT.CASCADE);
		mntmTools.setText(Messages.Main_MntmTools_text);
		
		Menu mnTools = new Menu(mntmTools);
		mntmTools.setMenu(mnTools);

		// create a menu item "Tools->Options"
		MenuItem mntmTools_Options = new MenuItem(mnTools, SWT.NONE);
		mntmTools_Options.setText(Messages.Main_MntmToolsOptions_text);


		/**
		 * Create a menu set "Help" 
		 */
		MenuItem mntmHelp = new MenuItem(menuBar, SWT.CASCADE);
		mntmHelp.setText(Messages.Main_MntmHelp_text);
		
		Menu mnHelp = new Menu(mntmHelp);
		mntmHelp.setMenu(mnHelp);

		// create a menu item "Help->About"
		MenuItem mntmHelp_About = new MenuItem(mnHelp, SWT.NONE);
		mntmHelp_About.setText(Messages.Main_MntmHelpAbout_text);
		
		/**
		 * Create a toolBar for MenuItem's shortcut
		 */
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		FormData fd_toolBar = new FormData();
		fd_toolBar.right = new FormAttachment(0, 517);
		fd_toolBar.top = new FormAttachment(0);
		fd_toolBar.left = new FormAttachment(0);
		toolBar.setLayoutData(fd_toolBar);

		// create a tool item "SaveNew"
		ToolItem tltmSavenew = new ToolItem(toolBar, SWT.NONE);
		tltmSavenew.setSelection(true);
		tltmSavenew.setText(Messages.Main_tltmSavenew_text);

		// create a tool item "Save"
		ToolItem tltmSave = new ToolItem(toolBar, SWT.NONE);
		tltmSave.setWidth(24);
		tltmSave.setSelection(true);
		tltmSave.setText(Messages.Main_tltmSave_text);

		// create a tool item "New"
		ToolItem tltmNew = new ToolItem(toolBar, SWT.NONE);
		tltmNew.setWidth(24);
		tltmNew.setSelection(true);
		tltmNew.setText(Messages.Main_tltmNew_text);

		/**
		 * Create Labels and Texts
		 */
		// create Archive Serial Number's Label and Text 
		Label lblArchiveSn = new Label(shell, SWT.NONE);
		FormData fd_lblArchiveSn = new FormData();
		fd_lblArchiveSn.top = new FormAttachment(0, 33);
		fd_lblArchiveSn.left = new FormAttachment(0, 10);
		fd_lblArchiveSn.right = new FormAttachment(0, 120);
		lblArchiveSn.setLayoutData(fd_lblArchiveSn);
		lblArchiveSn.setText(Messages.Main_lblArchiveSn_text);
		
		txtArchiveSn = new Text(shell, SWT.BORDER);
		FormData fd_txtArchiveSn = new FormData();
		fd_txtArchiveSn.top = new FormAttachment(0, 33);
		fd_txtArchiveSn.left = new FormAttachment(0, 125);
		fd_txtArchiveSn.right = new FormAttachment(100, -10);
		txtArchiveSn.setLayoutData(fd_txtArchiveSn);
		txtArchiveSn.setText("");

		// create Archive Name's Label and Text 
		Label lblArchiveName = new Label(shell, SWT.NONE);
		FormData fd_lblArchiveName = new FormData();
		fd_lblArchiveName.top = new FormAttachment(txtArchiveSn, 10);
		fd_lblArchiveName.left = new FormAttachment(0, 10);
		fd_lblArchiveName.right = new FormAttachment(0, 120);
		lblArchiveName.setLayoutData(fd_lblArchiveName);
		lblArchiveName.setText(Messages.Main_lblArchiveName_text);

		txtArchiveName = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		FormData fd_txtArchiveName = new FormData();
		fd_txtArchiveName.height = 50;
		fd_txtArchiveName.top = new FormAttachment(txtArchiveSn, 10);
		fd_txtArchiveName.right = new FormAttachment(100, -10);
		fd_txtArchiveName.left = new FormAttachment(0, 125);
		txtArchiveName.setLayoutData(fd_txtArchiveName);
		txtArchiveName.setText("");

		// create Links's Label and Text 
		Label lblLinks = new Label(shell, SWT.NONE);
		FormData fd_lblLinks = new FormData();
		fd_lblLinks.top = new FormAttachment(txtArchiveName, 10);
		fd_lblLinks.left = new FormAttachment(0, 10);
		fd_lblLinks.right = new FormAttachment(0, 120);
		lblLinks.setLayoutData(fd_lblLinks);
		lblLinks.setText(Messages.Main_lblLinks_text);
		
		txtLinks = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		FormData fd_txtLinks = new FormData();
		fd_txtLinks.top = new FormAttachment(txtArchiveName, 10);
		fd_txtLinks.bottom = new FormAttachment(100, -10);
		fd_txtLinks.left = new FormAttachment(0, 125);
		fd_txtLinks.right = new FormAttachment(100, -10);
		txtLinks.setLayoutData(fd_txtLinks);
		txtLinks.setText("");

	}
}
