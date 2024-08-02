package swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;


public class JListSelectionEx1 extends JFrame{
	  private String[] exampleText = {"Some example text without any color changes",
		        "Some more example text without color changes",
		        "Even more plain text!", 
		        "<html>Uncolored Text! <font color=orange>Now some example Text with color!</font> more Uncolored Text!</html>", 
		        "<html>Uncolored Text! <font color=green>And some more example text with color! Text, Text, Text!</font> more Uncolored Text!</html>",
		        "<html>Uncolored Text! <font color=red>A string with red color, Text Text Text!</font> more Uncolored Text!</html>",
		        "<html>Uncolored Text! <font color=blue>And finally a string with blue color, Text Text Text!</font> more Uncolored Text!</html>",
		        "<html>Uncolored Text! <font color=purple><selection color=white>Testing if some html can turn the selection color white!</selection></font> more Uncolored Text!</html>"};
	
	 public JListSelectionEx1() {
		 super("JList Selection Example");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 JList<String> list = new JList<String>(exampleText);
		 list.setSelectionForeground(Color.white);
		 list.setSelectionBackground(Color.DARK_GRAY);
		 add(list);
		 pack();
		 setVisible(true);
	}
	  public static void main(String[] args) {
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new JListSelectionEx1();
	            }
	        });
	}
}
