package prova.plugin.handlers;



import java.sql.SQLException;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import dialogs.MyTitleAreaDialogCont;
import dialogs.MyTitleAreaDialogCrit;
import dialogs.MyTitleAreaDialogFixTitle;
import dialogs.MyTitleAreaDialogMessage;
import dialogs.MyTitleAreaDialogNewProject;
import model.BinaryPredicateOperator;
import model.Check;
import model.Constraint;
import model.Container;
import model.Context;
import model.Critique;
import model.Do;
import model.Evl;
import model.Fix;
import model.GuardOperator;
import model.Message;
import model.Operation;
import model.Title;
import model.F;
import model.Db;

public class Gui {
	private Menu menu, menu2;

	private MenuItem removeContextMenuItem, removeCheckMenuItem, removeDoMenuItem, removeFixItem, removeCritiqueItem,
			removeMessageItem, removeTitleItem;
	private MenuItem addTitleMenuItem, addCritiqueMenuItem, addFixMenuItem, addMessageMenuItem, addCheckMenuItem,
			addDoMenuItem, addContextMenuItem;

	private Evl evl;

	public void createGui(Composite s) {
		Shell shell = (Shell) s;

		s.setLayout(new FormLayout());
		s.setSize(800, 600);
		

		FormLayout fLayout = new FormLayout();
		fLayout.marginHeight = 5;
		fLayout.marginWidth = 5;
		fLayout.marginTop = 15;
		fLayout.marginBottom = 5;
		s.setLayout(fLayout);

		Composite outer = new Composite(s, SWT.BORDER);

		FormLayout formLayout = new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		formLayout.spacing = 5;
		formLayout.marginTop = 5;
		outer.setLayout(formLayout);

		Composite innerLeft = new Composite(outer, SWT.BORDER);
		innerLeft.setLayout(new FormLayout());

		FormData fData = new FormData();
		fData.top = new FormAttachment(0);
		fData.left = new FormAttachment(0);
		fData.right = new FormAttachment(40); // Locks on 40% of the view
		fData.bottom = new FormAttachment(80);
		innerLeft.setLayoutData(fData);

		Tree tree = new Tree(innerLeft, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
		FormData fdTree = new FormData();
		fdTree.top = new FormAttachment(0);
		fdTree.left = new FormAttachment(0);
		fdTree.right = new FormAttachment(90);
		fdTree.bottom = new FormAttachment(100);
		tree.setLayoutData(fdTree);

		evl = new Evl();
		tree.setData(evl);

		tree.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				Tree tempTree = (Tree) e.getSource();
				if (tempTree.getItem(new Point(e.x, e.y)) != null) {
					// an item was clicked.
				} else {
					tree.deselectAll();
				}
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Composite buttonsComp = new Composite(innerLeft, SWT.NONE);
		buttonsComp.setLayout(new FormLayout());

		FormData fdButtons = new FormData();
		fdButtons.top = new FormAttachment(0);
		fdButtons.left = new FormAttachment(tree, 10);
		fdButtons.right = new FormAttachment(100);
		fdButtons.bottom = new FormAttachment(30);
		buttonsComp.setLayoutData(fdButtons);

		Button button1 = new Button(buttonsComp, SWT.PUSH);
		button1.setText("+");
		Button button2 = new Button(buttonsComp, SWT.PUSH);
		button2.setText("-");
		Button button3 = new Button(buttonsComp, SWT.PUSH);
		button3.setText("<");
		button3.setEnabled(false);
		Button button4 = new Button(buttonsComp, SWT.PUSH);
		button4.setText(">");
		button4.setEnabled(false);
		
		FormData f1 = new FormData();
		f1.height = 20;
		f1.width = 20;

		FormData f2 = new FormData();

		f2.top = new FormAttachment(button1, 5);
		f2.height = 20;
		f2.width = 20;
		
		FormData f3 = new FormData();
		f3.top = new FormAttachment(button2,5);
		f3.height = 20;
		f3.width = 20;
		
		FormData f4 = new FormData();
		f4.top = new FormAttachment(button3,5);
		f4.height = 20;
		f4.width = 20;
				
		
		button1.setLayoutData(f1);
		button2.setLayoutData(f2);
		button3.setLayoutData(f3);
		button4.setLayoutData(f4);

		Composite innerRight = new Composite(outer, SWT.BORDER);
		innerRight.setLayout(new FormLayout());

		FormData fData2 = new FormData();
		fData2.top = new FormAttachment(0);
		fData2.left = new FormAttachment(innerLeft);
		fData2.right = new FormAttachment(100);
		fData2.bottom = new FormAttachment(80);
		innerRight.setLayoutData(fData2);

		Composite right1 = new Composite(innerRight, SWT.BORDER);
		right1.setLayout(new FormLayout());
		// right1.setBackground(new Color(null, 0, 255, 0));
		FormData formDatar1 = new FormData();
		formDatar1.top = new FormAttachment(0);
		formDatar1.left = new FormAttachment(0);
		formDatar1.right = new FormAttachment(100);
		formDatar1.bottom = new FormAttachment(100);
		right1.setLayoutData(formDatar1);

		Composite checkComp = new Composite(right1, SWT.BORDER);
		checkComp.setLayout(new FormLayout());
		//checkComp.setBackground(new Color(null, 255, 113, 4));
		FormData checkFormData = new FormData();
		checkFormData.top = new FormAttachment(0);
		checkFormData.left = new FormAttachment(0);
		checkFormData.right = new FormAttachment(100);
		checkFormData.bottom = new FormAttachment(45);
		checkComp.setLayoutData(checkFormData);
		
		Composite fComposite = new Composite(checkComp, SWT.NONE);
		FormData fCompositeFormData = new FormData();
		fCompositeFormData.top = new FormAttachment(0);
		fCompositeFormData.left = new FormAttachment(1);
		fCompositeFormData.right = new FormAttachment(39);
		fCompositeFormData.bottom = new FormAttachment(100);
		fComposite.setLayoutData(fCompositeFormData);
		
		fComposite.setLayoutData(fCompositeFormData);
		
		fComposite.setLayout(new FormLayout());
		
		
	    Label fLabel =new Label(fComposite, SWT.NULL);
	    fLabel.setText("F");
	    List fList = new List(fComposite, SWT.BORDER | SWT.V_SCROLL );
	    
	    FormData fListFormData = new FormData();
	    fListFormData.top = new FormAttachment(10);
		fListFormData.left = new FormAttachment(1);
		fListFormData.right = new FormAttachment(99);
		fListFormData.bottom = new FormAttachment(99);
		fList.setLayoutData(fListFormData);
		
		fList.add("f1");
		
		
		
		tree.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] selected = tree.getSelection();
				TreeItem temp = selected[0];
				if(temp.getData().toString().toLowerCase().contains("check")){
					/*try {
						for(F f : Db.getFList()){
							fList.add(f.toString());
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	    FormData fLabelFormData = new FormData();
	    fLabelFormData.left = new FormAttachment(5);
	    fLabelFormData.bottom = new FormAttachment(fList);
	    
	    fLabel.setLayoutData(fLabelFormData);
	    
	    //F List
	    
	    Composite opComposite = new Composite(checkComp, SWT.NONE);
		FormData opCompositeFormData = new FormData();
		opCompositeFormData.top = new FormAttachment(0);
		opCompositeFormData.left = new FormAttachment(fComposite);
		opCompositeFormData.right = new FormAttachment(60);
		opCompositeFormData.bottom = new FormAttachment(100);
		opComposite.setLayoutData(opCompositeFormData);
		
		opComposite.setLayoutData(opCompositeFormData);
		
		opComposite.setLayout(new FormLayout());
	    List opList = new List(opComposite, SWT.BORDER | SWT.V_SCROLL );
	    Label opLabel = new Label(opComposite, SWT.NULL);
	    opLabel.setText("Op");
	    
	    FormData opListFormData = new FormData();
	    opListFormData.top = new FormAttachment(10);
		opListFormData.left = new FormAttachment(1);
		opListFormData.right = new FormAttachment(99);
		opListFormData.bottom = new FormAttachment(99);
		opList.setLayoutData(opListFormData);
		opList.add(BinaryPredicateOperator.EMPTY.toString());
		opList.add(BinaryPredicateOperator.EQUAL.toString());
		
		
		
	    FormData opLabelFormData = new FormData();
	    opLabelFormData.bottom = new FormAttachment(opList);
	    opLabelFormData.left = new FormAttachment(5);
	    opLabel.setLayoutData(opLabelFormData);

	    //opList
	    
	    Composite thComposite = new Composite(checkComp, SWT.NONE);
		FormData thCompositeFormData = new FormData();
		thCompositeFormData.top = new FormAttachment(0);
		thCompositeFormData.left = new FormAttachment(opComposite);
		thCompositeFormData.right = new FormAttachment(100);
		thCompositeFormData.bottom = new FormAttachment(100);
		thComposite.setLayoutData(thCompositeFormData);
		
		thComposite.setLayoutData(thCompositeFormData);
		
		thComposite.setLayout(new FormLayout());
	    
	    Label thLabel = new Label(thComposite, SWT.NULL);
	    thLabel.setText("Thresholds");
	    List thList = new List(thComposite, SWT.BORDER | SWT.V_SCROLL | DND.DROP_COPY);
	    FormData thListFormData = new FormData();
	    thListFormData.top = new FormAttachment(10);
		thListFormData.left = new FormAttachment(1);
		thListFormData.right = new FormAttachment(99);
		thListFormData.bottom = new FormAttachment(99);
		thList.setLayoutData(thListFormData);
		
	    FormData thLabelFormData = new FormData();
	    thLabelFormData.left = new FormAttachment(5);
	    thLabelFormData.bottom = new FormAttachment(thList);
	    thLabel.setLayoutData(thLabelFormData);
	    
	    //thList
	    
		Composite doComp = new Composite(right1, SWT.BORDER);
		doComp.setLayout(new FormLayout());
		
		FormData doFormData = new FormData();
		doFormData.top = new FormAttachment(checkComp, 10);
		doFormData.left = new FormAttachment(0);
		doFormData.right = new FormAttachment(100);
		doFormData.bottom = new FormAttachment(100);
		doComp.setLayoutData(doFormData);
		
		List doList = new List(doComp, SWT.BORDER | SWT.V_SCROLL);
		Label doLabel = new Label(doComp, SWT.NONE);
		doLabel.setText("Do");
		
		FormData doListFormData = new FormData();
		doListFormData.top = new FormAttachment(10);
		doListFormData.left = new FormAttachment(5);
		doListFormData.right = new FormAttachment(95);
		doListFormData.bottom = new FormAttachment(95);
		doList.setLayoutData(doListFormData);
		doList.setVisible(false);
		
		FormData doLabelFormData = new FormData();
		doLabelFormData.left = new FormAttachment(20);
		doLabelFormData.bottom = new FormAttachment(doList);
		doLabel.setLayoutData(doLabelFormData);
		
		Composite innerBottom = new Composite(outer, SWT.BORDER);
		innerBottom.setLayout(new FormLayout());

		FormData fData3 = new FormData();

		fData3.top = new FormAttachment(innerLeft, 5);
		fData3.bottom = new FormAttachment(100);

		fData3.right = new FormAttachment(100);
		fData3.left = new FormAttachment(0);

		innerBottom.setLayoutData(fData3);

		Button save = new Button(innerBottom, SWT.CENTER);
		save.setText("Save");
		FormData fdBottomButton = new FormData();
		fdBottomButton.top = new FormAttachment(40);
		fdBottomButton.left = new FormAttachment(45);
		fdBottomButton.right = new FormAttachment(55);
		fdBottomButton.bottom = new FormAttachment(65);
		save.setLayoutData(fdBottomButton);

		save.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(evl.toString());

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		button1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stubsuper.widgetSelected(e);

				TreeItem[] selected = tree.getSelection();
				// TreeItem itemSelected = selected[0];
				String string = "";
				for (TreeItem t : selected) {
					string += t;
				}
				menu = new Menu(innerLeft);

				if ((string.toLowerCase().contains("critique")) || ((string.toLowerCase().contains("constraint")))) {

					addCheckMenuItem = new MenuItem(menu, SWT.PUSH);
					addCheckMenuItem.setText("Set Check");
					addCheckMenuItem.addSelectionListener(new SelectionAdapter() {

						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];

							Container cSelected = (Container) temp.getData();

							Check checkNew = new Check(cSelected);
							

							// set Check to critique
							evl.setCheckToContainer(cSelected.getParent(), cSelected, checkNew);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

					addMessageMenuItem = new MenuItem(menu, SWT.PUSH);
					addMessageMenuItem.setText("Add Message");
					addMessageMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];

							Container cSelected = (Container) temp.getData();

							String txtMsg = "";
							MyTitleAreaDialogMessage dialogMessage = new MyTitleAreaDialogMessage(shell);
							dialogMessage.create();
							if (dialogMessage.open() == Window.OK) {
								txtMsg = dialogMessage.getName();

							} else {
								return;
							}

							Message msg = new Message(txtMsg, cSelected);

							evl.setCMessage(cSelected.getParent(), cSelected, msg);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

					addFixMenuItem = new MenuItem(menu, SWT.PUSH);
					addFixMenuItem.setText("Add Fix");
					addFixMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];

							Container cSelected = (Container) temp.getData();

							Fix fixNew = new Fix(cSelected);

							evl.addFix2C(cSelected.getParent(), cSelected, fixNew);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

				}
				if (string.toLowerCase().contains("fix")) {
					addTitleMenuItem = new MenuItem(menu, SWT.PUSH);
					addTitleMenuItem.setText("Set fix title");
					addTitleMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];

							Fix fixSelected = (Fix) temp.getData();
							String title = "";
							MyTitleAreaDialogFixTitle fixTitleDialog = new MyTitleAreaDialogFixTitle(shell);
							fixTitleDialog.create();
							if (fixTitleDialog.open() == Window.OK) {
								title = fixTitleDialog.getName();

							} else {
								return;
							}
							Title titleNew = new Title(title, fixSelected);
							fixSelected.setTitle(titleNew);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

					addDoMenuItem = new MenuItem(menu, SWT.PUSH);
					addDoMenuItem.setText("Add Do");
					addDoMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem temp = selected[0];

							Fix fixSelected = (Fix) temp.getData();

							Do d = new Do(fixSelected);

							Container fpar = fixSelected.getParent();
							evl.addDotoFix(fpar.getParent(), fpar, fixSelected, d);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				if ((string.toLowerCase().contains("context"))) {
					addCritiqueMenuItem = new MenuItem(menu, SWT.PUSH);
					addCritiqueMenuItem.setText("Set Critique/Constraint");
					addCritiqueMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							String contName = "";
							String type = "";
							MyTitleAreaDialogCrit dialog2 = new MyTitleAreaDialogCrit(shell);
							dialog2.create();
							if (dialog2.open() == Window.OK) {
								contName = dialog2.getName();
								type = dialog2.getType();

							} else {
								return;
							}

							TreeItem temp = selected[0];
							Context contToAddParent = (Context) temp.getData();
							tree.removeAll();
							Container cont2add = null;
							if (type.equals("critique")) {
								cont2add = new Critique(contName, contToAddParent);
							}else if (type.equals("constraint")) {
								cont2add = new Constraint(contName, contToAddParent);
							}
							

							evl.setContainer(contToAddParent, cont2add);

							fillTreeModel2(tree, evl);

						}
					});

				}
				if (string.toLowerCase().isEmpty()) {
					addContextMenuItem = new MenuItem(menu, SWT.PUSH);
					addContextMenuItem.setText("Add Context");
					addContextMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							String contextName = "";
							MyTitleAreaDialogCont dialog = new MyTitleAreaDialogCont(shell);
							dialog.create();
							if (dialog.open() == Window.OK) {
								contextName = dialog.getName();

							} else {
								return;
							}

							tree.removeAll();

							Context cNew = new Context(contextName, evl);

							evl.addContext(cNew);

							fillTreeModel2(tree, evl);

						}
					});
				}

				Point loc = button1.getLocation();
				Rectangle rect = button1.getBounds();

				Point mLoc = new Point(loc.x - 1, loc.y + rect.height);

				menu.setLocation(shell.getDisplay().map(button1.getParent(), null, mLoc));

				menu.setVisible(true);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		button2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] selected = tree.getSelection();
				String string = "";
				for (TreeItem t : selected) {
					string += t;
				}

				menu2 = new Menu(innerLeft);
				if (string.toLowerCase().contains("context")) {
					removeContextMenuItem = new MenuItem(menu2, SWT.PUSH);
					removeContextMenuItem.setText("Remove Context");
					removeContextMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							Context contextTemp2 = (Context) temp.getData();
							evl.removeContext(contextTemp2);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				if (string.toLowerCase().contains("check")) {
					removeCheckMenuItem = new MenuItem(menu2, SWT.PUSH);
					removeCheckMenuItem.setText("Remove Check");
					removeCheckMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							Check checkTemp2 = (Check) temp.getData();
							Container contTtemp2 = checkTemp2.getParent();

							evl.removeCheck(contTtemp2.getParent(), contTtemp2, checkTemp2);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				if (string.toLowerCase().contains("do")) {
					removeDoMenuItem = new MenuItem(menu2, SWT.PUSH);
					removeDoMenuItem.setText("Remove Do");
					removeDoMenuItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							Do DoTemp2 = (Do) temp.getData();
							Fix fixTemp = DoTemp2.getParent();
							Container cTemp = fixTemp.getParent();
							evl.removeDoFromFix(cTemp.getParent(), cTemp, fixTemp, DoTemp2);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				if (string.toLowerCase().contains("fix")) {
					removeFixItem = new MenuItem(menu2, SWT.PUSH);
					removeFixItem.setText("Remove Fix");
					removeFixItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							Fix fixToDel = (Fix) temp.getData();
							Container critTemp = fixToDel.getParent();
							Context contTemp = critTemp.getParent();

							evl.removeFixFromC(contTemp, critTemp, fixToDel);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}

					});

				}
				if ((string.toLowerCase().contains("critique")) || ((string.toLowerCase().contains("constraint")))) {
					removeCritiqueItem = new MenuItem(menu2, SWT.PUSH);
					removeCritiqueItem.setText("Remove Critique/Constraint");
					removeCritiqueItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							Container critToDel = (Container) temp.getData();
							Context contTemp = critToDel.getParent();
							evl.removeContainer(contTemp, critToDel);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});

				}
				if (string.toLowerCase().contains("message")) {
					removeMessageItem = new MenuItem(menu2, SWT.PUSH);
					removeMessageItem.setText("Remove Message");
					removeMessageItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];
							Message messageTemp = (Message) temp.getData();
							Container critTemp = messageTemp.getParent();

							evl.removeCMessage(critTemp.getParent(), critTemp);
							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});
				}
				if (string.toLowerCase().contains("title")) {
					removeTitleItem = new MenuItem(menu2, SWT.PUSH);
					removeTitleItem.setText("Remove Title");
					removeTitleItem.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							TreeItem temp = selected[0];

							Title titleTemp = (Title) temp.getData();
							Fix fixTemp = titleTemp.getParent();
							Container critTemp = fixTemp.getParent();
							evl.removeTitleFromFix(critTemp.getParent(), critTemp, fixTemp);

							tree.removeAll();
							tree.setData(evl);
							fillTreeModel2(tree, evl);

						}
					});
				}

				Point loc2 = button2.getLocation();
				Rectangle rect2 = button2.getBounds();

				Point mLoc2 = new Point(loc2.x - 1, loc2.y + rect2.height);

				menu2.setLocation(s.getDisplay().map(button2.getParent(), null, mLoc2));

				menu2.setVisible(true);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Menu menuBar = new Menu(shell, SWT.BAR);
		MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu.setText("&File");

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);
		
		MenuItem newProjectMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		newProjectMenuItem.setText("&New Evl Project");
		newProjectMenuItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				MyTitleAreaDialogNewProject dialog = new MyTitleAreaDialogNewProject(shell);
				dialog.create();
				boolean confirm = false;
				if (dialog.open() == Window.OK) {
					confirm = dialog.getConfirm();

				} else {
					return;
				}

				
				if(confirm){
					tree.removeAll();
					evl = new Evl();
					fillTreeModel2(tree, evl);
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		MenuItem saveItem = new MenuItem(fileMenu,SWT.PUSH);
		saveItem.setText("&Save Project");
		saveItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			    dialog.setFilterNames(new String[] {  "All Files (*.*)" });
			    dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); // Windows
			    dialog.setFilterPath("c:\\"); // Windows path
			    dialog.setFileName("");
			    String dir = dialog.open();
			    ProjectManagment.Save(evl,dir);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			    dialog.setFilterNames(new String[] {  "All Files (*.*)" });
			    dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); // Windows
			    dialog.setFilterPath("c:\\"); // Windows path
			    dialog.setFileName("");
			    String dir = dialog.open();
			    ProjectManagment.Save(evl,dir);
				
			}
		});
		MenuItem openProjectItem = new MenuItem(fileMenu, SWT.PUSH);
		openProjectItem.setText("&Open existing Project");
		openProjectItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(shell);
				dlg.setText("Open Project...");
				dlg.setFilterPath("C:/");
			    String[] filterExt = { "*.*" };
			    dlg.setFilterExtensions(filterExt);
		        String dir = dlg.open();
		        evl = ProjectManagment.Open(dir);
		        tree.removeAll();
		        fillTreeModel2(tree, evl);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(shell);
				dlg.setText("Open Project...");
				dlg.setFilterPath("C:/");
			    String[] filterExt = { "*.*" };
			    dlg.setFilterExtensions(filterExt);
		        String dir = dlg.open();
		        Evl evlTemp = ProjectManagment.Open(dir);
		        tree.removeAll();
		        fillTreeModel2(tree, evlTemp);
				
			}
		});		
		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("&Exit");
		exitItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		shell.setMenuBar(menuBar);

		s.pack();

	}

	
	private static void fillTreeModel2(Tree tree, Evl evl) {
		tree.setRedraw(false);
		for (Context c : evl.getContextList()) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("context " + c.getName());
			item.setData(c);
			Container cont = c.getContainer();
			if (cont == null) {

				tree.setRedraw(true);
				continue;
			}
			TreeItem contItem = new TreeItem(item, SWT.NONE);
			contItem.setText(cont.getType()+" " + cont.getName());
			contItem.setData(cont);
			
			Check check = cont.getCheck();
			if (check != null) {
				TreeItem checkItem = new TreeItem(contItem, SWT.NONE);
				checkItem.setText("check");
				checkItem.setData(check);
				checkItem.setExpanded(true);
				for (Operation op : check.getOperations()) {
					
					TreeItem checkChild1 = new TreeItem(checkItem, SWT.NONE);
					checkChild1.setText(op.getPredicate().toString());
					checkChild1.setData(op.getPredicate());
					if(op.getOp()==GuardOperator.EMPTY){
						TreeItem checkChild2 = new TreeItem(checkItem, SWT.NONE);
						checkChild2.setText(op.getOp().toString());
						checkChild2.setData(op.getOp());
					}
				}
			}
			Message message = cont.getMessage();
			if (message != null) {
				TreeItem messageItem = new TreeItem(contItem, SWT.NONE);
				messageItem.setText("message : " + message.getName());
				messageItem.setData(message);
			}

			for (Fix fix : cont.getFixList()) {
				TreeItem fixItem = new TreeItem(contItem, SWT.NONE);
				fixItem.setText("fix");
				fixItem.setData(fix);
				
				Title title = fix.getTitle();
				if (title != null) {
					TreeItem titleItem = new TreeItem(fixItem, SWT.NONE);
					titleItem.setText("title : " + title.getText());
					titleItem.setData(fix.getTitle());

				}
				for (Do d : fix.getDoList()) {
					TreeItem doItem = new TreeItem(fixItem, SWT.NONE);
					doItem.setText("do");
					doItem.setData(d);
					
					for (String doFun : d.getFunctions()) {
						TreeItem doChildItem = new TreeItem(doItem, SWT.NONE);
						doChildItem.setText(doFun);
						doChildItem.setData(doFun);

					}
					doItem.setExpanded(true);
				}
				fixItem.setExpanded(true);
			}
			item.setExpanded(true);
			contItem.setExpanded(true);
		}
		tree.setRedraw(true);

	}
	
	public static void fillTree2(Tree tree) {
		// Turn off drawing to avoid flicker
		tree.setRedraw(false);

		// Create five root items
		for (int i = 0; i < 5; i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("Root Item " + i);

			// Create three children below the root
			for (int j = 0; j < 3; j++) {
				TreeItem child = new TreeItem(item, SWT.NONE);
				child.setText("Child Item " + i + " - " + j);

				// Create three grandchildren under the child
				for (int k = 0; k < 3; k++) {
					TreeItem grandChild = new TreeItem(child, SWT.NONE);
					grandChild.setText("Grandchild Item " + i + " - " + j + " - " + k);
				}
			}
		}
		// Turn drawing back on!
		tree.setRedraw(true);
	}

}
