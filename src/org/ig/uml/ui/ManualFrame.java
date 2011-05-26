package org.ig.uml.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class ManualFrame extends JFrame {
	private static final long serialVersionUID = 5496019428422122301L;
    private JEditorPane textArea;

    public ManualFrame() {
        setTitle("Manuel d'utilisation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JEditorPane();
        textArea.setEditable(false);
        Font f = new Font("Helvetica.Italic", Font.PLAIN, 13); 
        //textArea.setFont(f);
        textArea.setContentType("text/html");
        textArea.setText(getManualFileContent());
        JScrollPane scrollPane = new JScrollPane(textArea);
        setPreferredSize(new Dimension(600, 500));
        textArea.setCaretPosition(0);
        getContentPane().add(scrollPane);
        
        pack();
        setVisible(true);
    }

	private String getManualFileContent() {
		String str = "";
		String res = "";
		try {
		    BufferedReader in = new BufferedReader(new FileReader("manual.html"));
		    while ((str = in.readLine()) != null) {
		    	res += str;
		    }
		    in.close();
		} catch (IOException e) {
			System.out.println("File problem.");
		}
		return res;
	}
}
