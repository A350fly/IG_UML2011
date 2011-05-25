package org.ig.uml.ui.notifications;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.SwingUmlView;

public class AboutJFrame extends JFrame implements ActionListener, UmlConstants {
	
	private static final long serialVersionUID = 2694509099452311948L;
	private JLabel description;
	private JLabel copyright;
	private JLabel version;
	private JButton close;
	private SwingUmlView view;

	public AboutJFrame(SwingUmlView view) {
		this.view = view;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle(ABOUT_TITLE);
		this.setContentPane(buildComponent());
		this.setPreferredSize(new Dimension(420, 130));
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
		version = new JLabel("<html><h2>" + VERSION + "</h2></html>",
				JLabel.CENTER);
		panel.add(version, BorderLayout.NORTH);

		description = new JLabel(DESCRIPTION);
		description.setAlignmentX(Component.CENTER_ALIGNMENT);
		copyright = new JLabel(COPYRIGHT);
		copyright.setAlignmentX(Component.CENTER_ALIGNMENT);
		close = new JButton(CLOSE);
		close.setAlignmentX(Component.CENTER_ALIGNMENT);
		close.addActionListener(this);
		
		JPanel vbox = new JPanel();
		vbox.setLayout(new BoxLayout(vbox,
				BoxLayout.Y_AXIS));
		vbox.add(description);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(copyright);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(close);
		vbox.add(Box.createVerticalStrut(10));
		
		panel.add(vbox, BorderLayout.CENTER);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
}