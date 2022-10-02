package notes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

public class Input {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		String headline = "Java";
		String path = ".\\text.txt";
		String text = Text.fileReader(path);
		String filteredText = Text.getFilteredText(path, text, headline);
					
		String[] choices = {
				"1 - Lägg till text\n", 
				"2 - Visa all text\n", 
				"3 - Filtrera text"
				};
		
	    Object selectionObject = JOptionPane.showInputDialog(null, "Välj alternativ", "Meny för anteckningar", JOptionPane.CLOSED_OPTION, null, choices, choices[0]);	
	    
	    if (selectionObject != null) {
	    	String choice = selectionObject.toString(); 
	    	        
			switch (choice) {
					case "1 - Lägg till text\n": 	
						textInput(path);
					break;
					case "2 - Visa all text\n":
						textOutput(text); 
			        break;
					case "3 - Filtrera text":
						textOutput(filteredText);
			}
		}	
	}
	
	public static void textInput(String path) {
		JFrame textInput = new JFrame();
		textInput.setTitle("Skriv anteckning");
		JPanel mainPanel = new JPanel();
		JPanel headingPanel = new JPanel();
		JLabel headingLabel = new JLabel("Ange text som ska sparas i filen text.txt");
		headingPanel.add(headingLabel);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();
		constr.insets = new Insets(5, 5, 5, 5);
		JLabel headLabel		= new JLabel("Ange Rubrik:");
		JLabel subHeadLabel		= new JLabel("Ange Underrubrik:");
		JLabel newTextLabel		= new JLabel("Ange text:");
		JTextField headInput    = new JTextField(20);
		JTextField subHeadInput = new JTextField(20);
		JTextArea newTextArea	= new JTextArea(7, 20);
		panel.add(headLabel, constr);
		constr.gridx=1;
		panel.add(headInput, constr);
		constr.gridx=0; constr.gridy=1;
		panel.add(subHeadLabel, constr);
		constr.gridx=1;
		panel.add(subHeadInput, constr);
		constr.gridx=0; constr.gridy=2;
		panel.add(newTextLabel, constr);
		constr.gridx=1;
		panel.add(newTextArea, constr);
		constr.gridx=0; constr.gridy=4;
		constr.gridwidth = 2;
		constr.anchor = GridBagConstraints.CENTER;
		newTextArea.setLineWrap(true);
		newTextArea.setWrapStyleWord(true);
		
		JButton button = new JButton("Spara");
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (headInput.getText().length() != 0 && newTextArea.getText().length() != 0) {
					Text.textHandler(headInput.getText(), subHeadInput.getText(), newTextArea.getText(), path);
					headingLabel.setText("Texten är nu sparad i filen text.txt");
			}
			headInput.setText("");
			subHeadInput.setText("");
			newTextArea.setText("");
			}
		});
		
		panel.add(button, constr);
		mainPanel.add(headingPanel);
		mainPanel.add(panel);
		textInput.add(mainPanel);
		textInput.pack();
		textInput.setSize(400, 300);
		textInput.setLocationRelativeTo(null);
		textInput.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		textInput.setVisible(true);
		
		onClose(textInput);
	}
	
	public static void textOutput(String text) {
		JFrame textOutput = new JFrame();  
        Container cp = textOutput.getContentPane();  
        JTextPane pane = new JTextPane();  
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();  
        
        Document doc = pane.getStyledDocument();  
        try {
			doc.insertString(doc.getLength(), text, attributeSet);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} 
        
        JScrollPane scrollPane = new JScrollPane(pane);  
        cp.add(scrollPane, BorderLayout.CENTER);  
       
        textOutput.setSize(600, 400);
        textOutput.setLocationRelativeTo(null);
        textOutput.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textOutput.setVisible(true);
        
        onClose(textOutput);
	}
	
	public static void onClose(JFrame Frame) {
		Frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                menu();
            }
        });
	}
}
	