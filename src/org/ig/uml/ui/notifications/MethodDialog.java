package org.ig.uml.ui.notifications;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.ig.uml.ui.SwingUmlView;

public class MethodDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 4913896455890642934L;

	private JPanel mainPanel;
	private JPanel buttonsPanel;
	private JPanel methods;
	private JScrollPane methodsPanel;
	private JButton addMethod;
	private JButton validate;
	private List<MethodBox> methodBoxList;
	private Box mainBox;
	
	private SwingUmlView view;
	
	public MethodDialog(SwingUmlView view) {
		mainPanel = new JPanel(new BorderLayout());
		buttonsPanel = new JPanel(new BorderLayout());
		methods = new JPanel(new GridLayout());
		methodBoxList = new ArrayList<MethodBox>();
		addMethod = new JButton("Ajouter méthode");
		validate = new JButton("Valider");
		this.view = view;
		
		addMethod.setActionCommand("AddMethod");
		addMethod.addActionListener(this);
		validate.setActionCommand("Validate");
		validate.addActionListener(this);
		 
		buildComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		setTitle("Méthodes");
		setContentPane(mainPanel);
		setModal(true);
		pack();
		setDialogLocation(view.getJframe());
		setVisible(true);
	}
	
	private void setDialogLocation(Frame f) {
		Rectangle r = f.getBounds();
		int x = r.x + (r.width - getSize().width)/2;
		int y = r.y + (r.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	public void buildComponents() {
		JLabel label = new JLabel("<html><h3>Définition des méthodes de classe</h3></html>",
				JLabel.CENTER);
		
		methodsPanel = new JScrollPane(methods,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		methodsPanel.getVerticalScrollBar().setUnitIncrement(20);

		mainBox = Box.createVerticalBox();
		mainBox.add(Box.createVerticalStrut(10));
		
		MethodBox box = new MethodBox("Méthode 1 :", view);
		mainBox.add(box.getBox());
		methodBoxList.add(box);
		
		methods.add(mainBox);
		mainBox.add(Box.createVerticalStrut(10));
		
		Box buttonsBox = Box.createHorizontalBox();
		buttonsBox.add(addMethod, Box.CENTER_ALIGNMENT);
		buttonsBox.add(Box.createHorizontalStrut(10));
		buttonsBox.add(validate, Box.CENTER_ALIGNMENT);
		buttonsPanel.add(buttonsBox, BorderLayout.CENTER);
		
		mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(methodsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "AddMethod") {
			int num = methodBoxList.size()+1;	// numéro de la méthode
			MethodBox box = new MethodBox("Méthode "+num+" :", view);
			mainBox.add(box.getBox());
			mainBox.add(Box.createVerticalStrut(10));
			methodBoxList.add(box);
			
			this.setSize(getWidth(), getHeight()+25);
			mainPanel.validate();
			mainPanel.repaint();
		}
		else if (e.getActionCommand() == "Validate") {
			this.dispose();
		}
	}
	
	public List<MethodBox> getMethodBoxList() {
		return methodBoxList;
	}
}
