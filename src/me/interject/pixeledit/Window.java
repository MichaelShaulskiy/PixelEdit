package me.interject.pixeledit;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.LinkedList;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;


/* TODO: rewrite completely */
public class Window extends JFrame {
	private Dimension minimumSize = new Dimension(800, 600);
	EditorCanvas canvas = new EditorCanvas();
	private JMenuBar menuBar;
	private Map<String, JMenu> menu = new HashMap<String, JMenu>();
	private Map<JMenu, ArrayList<JMenuItem>> menuItems;
	private LinkedList<Map<String, JPanel>> components = new LinkedList<Map<String, JPanel>>();
	private JPanel container = new JPanel();
	private JPanel toolBar = new JPanel();
	private JPanel layerBar = new JPanel();
	private List<String> menues = new ArrayList<String>();
	private Map<String, JCheckBox> checkBoxes = new HashMap<String, JCheckBox>();
	private List<String> check = new ArrayList<String>();
	private String[] menueNames = new String[]{
		"Datei",
		"Hilfe"
	};
	/* TODO: refactor */
	private JButton clearButton = new JButton("Clear");

	/* Because Java doesn't support neither function callbacks or function pointers */
	interface Shortcut {
		Object action(Object args);
	}

	public Window() {
		super("PixelEdit");
		setupInterface();
		setSize(minimumSize);
		setResizable(true);
		setMinimumSize(minimumSize);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		/* initialize every component */
		//components.add((new HashMap<String, JPanel>()).put("root", container));

		/* REMEMBER: recast into JPanel on retrieval */
	}

	private void setupCheckBoxes() {
		check.add("Snap");
		check.add("Grid");
		check.add("IntelliScale");
		check.forEach(e -> checkBoxes.put(e, new JCheckBox(e)));
	}

	private void setupInterface(){
		setupCheckBoxes();

		add(container);
		container.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		setupMenu(menueNames);
		menues.forEach(e -> menu.put(e, new JMenu(e)));

		menuItems = new HashMap<JMenu, ArrayList<JMenuItem>>();
		//menuItems.put((JMenu)menu.get("Datei"), (new ArrayList<JMenuItem>().add(new JMenuItem("Öffnen"))));

		menu.values().forEach(e -> menuBar.add(e));

		addComponentListener(new ComponentListener() {
			public void componentResized(ComponentEvent e){
				canvas.windowSizeChanged(new Dimension(getComponentAt(e.getComponent().getWidth() / 2, e.getComponent().getHeight() / 2).getWidth(), getComponentAt(e.getComponent().getWidth() / 2, e.getComponent().getHeight() / 2).getHeight()));
			}

			@Override
			public void componentMoved(ComponentEvent e) {

			}

			@Override
			public void componentShown(ComponentEvent e) {

			}

			@Override
			public void componentHidden(ComponentEvent e) {

			}
		});

		/* shortcuts are defined in a seperate structure, however they are bound here */
		addKeyListener(new KeyBoardManager());

		container.add(menuBar, BorderLayout.NORTH);
		container.add(layerBar, BorderLayout.EAST);
		container.add(canvas, BorderLayout.CENTER);
		toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.Y_AXIS));

		/* TODO: refactor */
		canvas.setPixelSize(100);

		/* TODO: refactor */
		clearButton.addActionListener(e -> canvas.toggle("clear"));

		/* TODO: replace with PictureButton */
		/* TODO: refactor */
		toolBar.add(new JToggleButton("Brush"));
		toolBar.add(new JToggleButton("Eraser"));
		toolBar.add(new JToggleButton("Zoom"));
		toolBar.add(new JToggleButton("Select"));
		toolBar.add(new Ruler());
		toolBar.add(clearButton);
		checkBoxes.forEach((String s, JCheckBox c) -> c.addItemListener(e -> canvas.toggle(s.toLowerCase())));
		//checkBoxes.get("Grid").addItemListener(e -> canvas.toggle("grid"));
		checkBoxes.forEach((String s, JCheckBox e) -> toolBar.add(e));
		container.add(toolBar, BorderLayout.WEST);

		layerBar.setLayout(new BoxLayout(layerBar, BoxLayout.Y_AXIS));
		layerBar.add(new JButton("Platzhalter"));
		pack();
	}


	private void setupMenu(String item){
		menues.add(item);
	}

	@Deprecated
	private JButton createButton(String label) {
		return new JButton(label);
	}

	private void setupMenu(String[] items){

		for(String s : items){
			menues.add(s);
		}
	}
}
