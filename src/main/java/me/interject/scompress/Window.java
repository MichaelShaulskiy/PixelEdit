package me.interject.scompress;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;

/**
 * Created by mshau on 04.09.2016.
 */
public class Window extends JFrame {
	private JButton compressButton = new JButton("compress");
	private static boolean commandLine = false;
	public Window() {
		super("SCompress");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		Window window;
		if(args.length > 0) Window.commandLine = true;
		window = Window.commandLine ? null: new Window();
		System.out.println(args.length);
	}
}
