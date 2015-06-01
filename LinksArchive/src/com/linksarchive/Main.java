package com.linksarchive;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;


public class Main {

	public static ConfigModel configMdl;
	protected Shell shell;
	private Text txtArchiveSn;
	private Text txtArchiveName;
	private Text txtLinks;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

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
	 * Open the Main window.
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
	 * Exit the application.
	 */
	public void appExit() {
		// check whether there is unsave data
		Boolean fileUnsave = !( txtArchiveSn.getText().isEmpty() && txtArchiveName.getText().isEmpty() && txtLinks.getText().isEmpty() );
		
		// if there is an unsave file, ask user to save or not, and then exit.
		if(fileUnsave) {
			MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.YES | SWT.NO);
	        mb.setText("Confirm");
	        mb.setMessage("There is an unsave file, save before exit?");
	        if( mb.open() == SWT.YES ) {
	        	saveFileAs();
	    		shell.close();
	        }
		} else { // show a confirm dialog before exit
			MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.YES | SWT.NO);
	        mb.setText("Confirm");
	        mb.setMessage("Sure to exit?");
	        if( mb.open() == SWT.YES ) {
	    		shell.close();
	        }
		}
	}

	/**
	 * Create a new file
	 */
	private void newFile() {
		// show a msgBox for debugging
		MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
        mb.setText("Info");
        mb.setMessage("Create a new file");
        mb.open();
        
		// TODO Create a new file
	}
	/**
	 * Open an exist file
	 */
	private void openFile() {
		// show a msgBox for debugging
		MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
        mb.setText("Info");
        mb.setMessage("Open an exist file");
        mb.open();

		// TODO Open an exist file
	}
	/**
	 * Save the file
	 */
	private void saveFile() {
		// show a msgBox for debugging
		MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
        mb.setText("Info");
        mb.setMessage("Save the file");
        mb.open();

		// TODO Save the file
	}
	/**
	 * Save the file as a specific name
	 */
	private void saveFileAs() {
		// show a msgBox for debugging
		MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
        mb.setText("Info");
        mb.setMessage("Save the file as a specific name");
        mb.open();
        
		// TODO Save the file as a specific name
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(535, 426);
		shell.setText(Messages.MainTxt_title);
		FormLayout fl_shell = new FormLayout();
		shell.setLayout(fl_shell);
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);
		
		/**
		 * Create a menu set "File" 
		 */
		MenuItem mntmFile = new MenuItem(menuBar, SWT.CASCADE);
		mntmFile.setText(Messages.MainTxt_mntmFile);
		
		Menu mnFile = new Menu(mntmFile);
		mntmFile.setMenu(mnFile);
		
		// create a menu item "File->New"
		MenuItem mntmFile_New = new MenuItem(mnFile, SWT.NONE);
		mntmFile_New.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [mntmFile_New] is clicked");
                mb.open();
                
                newFile();
			}
		});
		mntmFile_New.setText(Messages.MainTxt_mntmFileNew);

		// create a menu item "File->Open..."
		MenuItem mntmFile_Open = new MenuItem(mnFile, SWT.NONE);
		mntmFile_Open.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [mntmFile_Open] is clicked");
                mb.open();
                
                openFile();
			}
		});
		mntmFile_Open.setText(Messages.MainTxt_mntmFileOpen);

		// create a menu item "File->Save"
		MenuItem mntmFile_Save = new MenuItem(mnFile, SWT.NONE);
		mntmFile_Save.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [mntmFile_Save] is clicked");
                mb.open();
                
                saveFile();
			}
		});
		mntmFile_Save.setText(Messages.MainTxt_mntmFileSave);

		// create a menu item "File->Save and New"
		MenuItem mntmFile_SaveNew = new MenuItem(mnFile, SWT.NONE);
		mntmFile_SaveNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [mntmFile_SaveNew] is clicked");
                mb.open();
                
                saveFile();
                newFile();
			}
		});
		mntmFile_SaveNew.setText(Messages.MainTxt_mntmFileSaveNew);

		// create a menu item "File->Save As..."
		MenuItem mntmFile_SaveAs = new MenuItem(mnFile, SWT.NONE);
		mntmFile_SaveAs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [mntmFile_SaveAs] is clicked");
                mb.open();
                
                saveFileAs();
			}
		});
		mntmFile_SaveAs.setText(Messages.MainTxt_mntmFileSaveAs);

		// create a menu item "File->Exit"
		MenuItem mntmFile_Exit = new MenuItem(mnFile, SWT.NONE);
		mntmFile_Exit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                appExit();
			}
		});
		mntmFile_Exit.setText(Messages.MainTxt_mntmFileExit);

		/**
		 * Create a menu set "Tools" 
		 */
		MenuItem mntmTools = new MenuItem(menuBar, SWT.CASCADE);
		mntmTools.setText(Messages.MainTxt_mntmTools);
		
		Menu mnTools = new Menu(mntmTools);
		mntmTools.setMenu(mnTools);

		// create a menu item "Tools->Options"
		MenuItem mntmTools_Options = new MenuItem(mnTools, SWT.NONE);
		mntmTools_Options.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/* show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [mntmTools_Options] is clicked");
                mb.open();
                */
				
                // show options window
                Options opt = new Options(shell, 0);
                opt.open();
			}
		});
		mntmTools_Options.setText(Messages.MainTxt_mntmToolsOptions);


		/**
		 * Create a menu set "Help" 
		 */
		MenuItem mntmHelp = new MenuItem(menuBar, SWT.CASCADE);
		mntmHelp.setText(Messages.MainTxt_mntmHelp);
		
		Menu mnHelp = new Menu(mntmHelp);
		mntmHelp.setMenu(mnHelp);

		// create a menu item "Help->About"
		MenuItem mntmHelp_About = new MenuItem(mnHelp, SWT.NONE);
		mntmHelp_About.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [mntmHelp_About] is clicked");
                mb.open();
                
                // TODO show about inf window
			}
		});
		mntmHelp_About.setText(Messages.MainTxt_mntmHelpAbout);
		
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
		tltmSavenew.setText(Messages.MainTxt_tltmSavenew);
		tltmSavenew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [tltmSavenew] is clicked");
                mb.open();
                
                saveFile();
                newFile();
			}
		});

		// create a tool item "Save"
		ToolItem tltmSave = new ToolItem(toolBar, SWT.NONE);
		tltmSave.setWidth(24);
		tltmSave.setSelection(true);
		tltmSave.setText(Messages.MainTxt_tltmSave);
		tltmSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [tltmSave] is clicked");
                mb.open();
                
                saveFile();
			}
		});

		// create a tool item "New"
		ToolItem tltmNew = new ToolItem(toolBar, SWT.NONE);
		tltmNew.setWidth(24);
		tltmNew.setSelection(true);
		tltmNew.setText(Messages.MainTxt_tltmNew);
		tltmNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [tltmNew] is clicked");
                mb.open();
                
                newFile();
			}
		});

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
		lblArchiveSn.setText(Messages.MainTxt_lblArchiveSn);
		
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
		lblArchiveName.setText(Messages.MainTxt_lblArchiveName);

		txtArchiveName = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		FormData fd_txtArchiveName = new FormData();
		fd_txtArchiveName.height = 65;
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
		lblLinks.setText(Messages.MainTxt_lblLinks);
		
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
