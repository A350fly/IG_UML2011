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

import org.ig.uml.ui.SwingUmlView;

public class MethodDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 4913896455890642934L;

	private JPanel panel;
	private GridLayout layout;
	private JButton addMethod;
	private JButton addParameter;
	private List<MethodBox> methodBoxList;
	
	private SwingUmlView view;
	
	public MethodDialog(SwingUmlView view) {
		layout = new GridLayout();
		panel = new JPanel();
		methodBoxList = new ArrayList<MethodBox>();
		this.view = view;

		buildComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Méthodes");
		setLayout(layout);
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
		add(new JLabel("<html><h3>Définition des méthodes de classe</h3></html>",
				JLabel.CENTER), BorderLayout.NORTH);
		
		MethodBox method = new MethodBox("Méthode 1 :");
		methodBoxList.add(method);
		
		layout.addLayoutComponent("methode", method.getBox());
	}
	
	public Box addParameterBox() {
		Box box = Box.createHorizontalBox();
		
		return null;
	}

	public void actionPerformed(ActionEvent e) {

	}
}
