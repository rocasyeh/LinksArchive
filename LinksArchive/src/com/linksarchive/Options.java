package com.linksarchive;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;

public class Options extends Dialog {

	protected Object result;
	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtDefFilePath;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Options(Shell parent, int style) {
		super(parent, style);
		setText("Options Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/*
	 * Read the configuration file.
	 */
	private void readConfig() {
		
	}

	/*
	 * Write current configuration to the configuration file.
	 */
	private void writeConfig() {
		// show a msgBox for debugging
		MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
        mb.setText("Info");
        mb.setMessage("Write current configuration to the configuration file.");
        mb.open();
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.SHELL_TRIM | SWT.BORDER | SWT.PRIMARY_MODAL);
		shell.setSize(600, 400);
		shell.setText(Messages.OptionsTxt_title);
		shell.setLayout(new FormLayout());

		
		/*
		 * Initial Default File Path Composite
		 */
		Composite compDefFilePath = new Composite(shell, SWT.NO_BACKGROUND);
		compDefFilePath.setLayout(new FormLayout());
		FormData fd_compDefFilePath = new FormData();
		fd_compDefFilePath.bottom = new FormAttachment(0, 39);
		fd_compDefFilePath.right = new FormAttachment(100, -10);
		fd_compDefFilePath.top = new FormAttachment(0, 10);
		fd_compDefFilePath.left = new FormAttachment(0, 10);
		compDefFilePath.setLayoutData(fd_compDefFilePath);
		
		Label lblDefFilePath = new Label(compDefFilePath, SWT.NONE);
		FormData fd_lblDefFilePath = new FormData();
		fd_lblDefFilePath.top = new FormAttachment(0, 5);
		lblDefFilePath.setLayoutData(fd_lblDefFilePath);
		lblDefFilePath.setText(Messages.OptionsTxt_lblDefFilePath);
		
		txtDefFilePath = new Text(compDefFilePath, SWT.BORDER);
		FormData fd_txtDefFilePath = new FormData();
		fd_txtDefFilePath.top = new FormAttachment(0, 2);
		fd_txtDefFilePath.left = new FormAttachment(lblDefFilePath, 5);
		fd_txtDefFilePath.right = new FormAttachment(100, -80);
		txtDefFilePath.setLayoutData(fd_txtDefFilePath);
		
		Button btnDefFilePath = new Button(compDefFilePath, SWT.NONE);
		FormData fd_btnDefFilePath = new FormData();
		fd_btnDefFilePath.width = 80;
		fd_btnDefFilePath.right = new FormAttachment(100);
		btnDefFilePath.setLayoutData(fd_btnDefFilePath);
		btnDefFilePath.setText(Messages.OptionsTxt_btnDefFilePath);
		btnDefFilePath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// show a DirectoryDialog for selecting
				DirectoryDialog dirDialog = new DirectoryDialog(shell);
				dirDialog.getFilterPath();
				String path = dirDialog.open();
				txtDefFilePath.setText(path);
			}
		});
		
		/*
		 * Initial Window Action Composite
		 */
		Composite compWindowAction = new Composite(shell, SWT.NO_BACKGROUND);
		compWindowAction.setLayout(new FormLayout());
		FormData fd_compWindowAction = new FormData();
		fd_compWindowAction.left = new FormAttachment(0, 10);
		fd_compWindowAction.right = new FormAttachment(100, -10);
		fd_compWindowAction.bottom = new FormAttachment(100, -10);
		compWindowAction.setLayoutData(fd_compWindowAction);
		
		Button btnApply = new Button(compWindowAction, SWT.NONE);
		FormData fd_btnApply = new FormData();
		fd_btnApply.width = 70;
		fd_btnApply.right = new FormAttachment(100, -160);
		btnApply.setLayoutData(fd_btnApply);
		btnApply.setText(Messages.OptionsTxt_btnApply);
		btnApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/* show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [btnApply] is clicked");
                mb.open();
                */
                
				// write configuration to file
				writeConfig();
			}
		});
		
		Button btnOk = new Button(compWindowAction, SWT.NONE);
		FormData fd_btnOk = new FormData();
		fd_btnOk.width = 70;
		fd_btnOk.right = new FormAttachment(100, -80);
		btnOk.setLayoutData(fd_btnOk);
		btnOk.setText(Messages.OptionsTxt_btnOk);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/* show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [btnOk] is clicked");
                mb.open();
                */
				
				// write configuration to file and close Options dialog
				writeConfig();
				shell.close();
			}
		});
		
		Button btnCancel = new Button(compWindowAction, SWT.NONE);
		FormData fd_btnCancel = new FormData();
		fd_btnCancel.width = 70;
		fd_btnCancel.right = new FormAttachment(100, 0);
		btnCancel.setLayoutData(fd_btnCancel);
		btnCancel.setText(Messages.OptionsTxt_btnCancel);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/* show a msgBox for debugging
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK);
                mb.setText("Info");
                mb.setMessage("The button [btnCancel] is clicked");
                mb.open();
                */
				
				// close Options dialog
				shell.close();
			}
		});
		
	}
}
