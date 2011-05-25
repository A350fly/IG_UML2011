package org.ig.uml.ui.notifications;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.events.GenerateCode;

public class LanguageChoiceDialog extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 2694509099452311948L;
	private JLabel nameLabel;
	private JComboBox languageComboBox;
	private JButton validate;
	private SwingUmlView view;
	private String language;

	public LanguageChoiceDialog(SwingUmlView view) {
		this.view = view;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Nouvelle classe");
		String [] languageList = { "Java", "C++", "SQL" };
		language = languageList[0];
		nameLabel = new JLabel("Language : ");
		languageComboBox = new JComboBox(languageList);
		languageComboBox.addActionListener(this);
		this.setContentPane(buildComponent());
		this.setPreferredSize(new Dimension(300, 115));
		this.setDialogLocation(view.getJframe());
		this.pack();
		this.setVisible(true);		
	}

	private void setDialogLocation(Frame f) {
		Rectangle r = f.getBounds();
		int x = r.x + (r.width - getSize().width)/2;
		int y = r.y + (r.height - getSize().height)/2;
		setLocation(x, y);
	}

	private JPanel buildComponent() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel("<html><h3>Choix du langage de programmation :</h3></html>",
				JLabel.CENTER), BorderLayout.NORTH);

		nameLabel = new JLabel("Langage :");
		validate = new JButton("Ok");
		validate.addActionListener(new GenerateCode(this, view));
		
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(10));
		
		Box hbox = Box.createHorizontalBox();
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameLabel);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(languageComboBox);
		hbox.add(Box.createHorizontalStrut(50));
		vbox.add(hbox);
		
		hbox = Box.createHorizontalBox();
		hbox.add(validate);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(hbox);
		vbox.add(Box.createVerticalStrut(10));
		
		panel.add(vbox, BorderLayout.CENTER);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		language = languageComboBox.getSelectedItem().toString();
		view.getController().notifyCurrentLanguage(language);
	}
	
}
