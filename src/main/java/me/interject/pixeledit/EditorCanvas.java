package me.interject.pixeledit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

import me.interject.gamma.Pixel;
import me.interject.math.Intersection;


/**
 * Created by mshau on 03.09.2016.
 */
/* TODO: implement layering */
/* TODO: remove overlapping Pixels */
public class EditorCanvas extends me.interject.gamma.Canvas {
	private List<Pixel> pixels;
	private Dimension boundingBox;
	private int scale;
	private int gridSize;
	private ScriptEngine shaderScript;
	private List<Point> mouseHistory = new ArrayList<Point>();
	private Map<String, Boolean> settings = new HashMap<String, Boolean>();
	private long renderOptions = 0x0l;
	private String[] toggles = new String[] {
			"grid",
			"snap",
			"clear"
	};

	public EditorCanvas(){
		super();
		pixels = new LinkedList<Pixel>();
		boundingBox = new Dimension(30, 30);
		gridSize = 50;

		/* initialize settings to their default value */
		/* TODO: find out: is a tradional or enhanced for loop faster? */
		Arrays.asList(toggles).forEach(e -> settings.put(e, false));
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1)
					paint(new Pixel(new Color((int)Math.floor(255 * Math.random() % 256),
							(int)Math.floor(255 * Math.random() % 256), (int)Math.floor(255 * Math.random() % 256)),
							e.getX() - (pixelSize / 2), e.getY() - (pixelSize / 2)));
				else {
					/* TODO: optimize */
					pixels.forEach(p -> {
						if(Intersection.intersect(p.getX(), boundingBox.width, e.getX(), boundingBox.width) && Intersection.intersect(p.getY(), boundingBox.width, e.getY(), boundingBox.width)) pixels.remove(p);
						/* probably should only repaint on change */
						repaint();
					});
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/* retrieve current mouse position */
				addMouseMotionListener(new MouseMotionListener() {
					/* TODO: figure out which event fires on dragging how often */
					/* TODO: don't paint if we aren't dragging */
					@Override
					public void mouseDragged(MouseEvent e) {
						//mouseHistory.add(e.getPoint());
						paint(new Pixel(Color.GREEN, (int)e.getX(), (int)e.getY()));
						repaint();
					}

					@Override
					public void mouseMoved(MouseEvent e) {

					}
				});
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				//mouseHistory.add(e.getPoint());
				//mouseHistory.forEach(p -> {
				//	paint(new Pixel(Color.GREEN, (int)p.getX(), (int)p.getY()));
				//});
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});

		/* initialize the shading language */
		//shaderScript = new ScriptEngineManager().getEngineByName("nashorn");
		//try {
			//shaderScript.eval("var Shader = Java.type('javax.swing.JOptionPane'); Shader.showMessageDialog(null, 'Hier meldet sich der JS Shader')");
		//} catch (ScriptException e) {
			//e.printStackTrace();
		//g}
	}

	public void setGridSize(int size){
		gridSize = size;
	}

	private void clear() {
		pixels.removeAll(pixels);
		toggle("clear");
		repaint();
	}

	@Override
	public void paint(Pixel p){
		Pixel pixel = settings.get("snap") ? new Pixel(p.getColor(), clampToGrid(p.getX(), true),
				clampToGrid(p.getY(), false)) : p;
		pixels.add(pixel);
		repaint();
	}


	@Deprecated
	public void toggleGrid() {
		settings.put("grid", !settings.get("grid"));
		repaint();
	}

	public void toggle(String parameter) {
		settings.put(parameter, !settings.get(parameter));
		/* TODO: only repaint if necessary */
		repaint();
	}

	private void drawGrid(Graphics g, Color color){
		g.setColor(color);
		/* draw horizontal lines */
		/* TODO: merge loops (avoid stack setup overhead) */
		for(int i = 0; i < Math.ceil(height / gridSize) + 1; i++){
			g.drawLine(0, gridSize * i, width, gridSize * i);
		}

		for(int i = 0; i < Math.ceil(width / gridSize) + 1; i++){
			g.drawLine(i * gridSize, 0, i * gridSize, height);
		}
	}

	/* calculate the closest grid boundary */
	/* TODO: move into math package */
	private int clampToGrid(int pos, boolean toWidth) {
		/* TODO: optimize */
		for(int i = 0; i < (int)Math.ceil(toWidth ? width: height/gridSize); i++) if(i * gridSize > pos) return (i - 1) * gridSize;
		return -1;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/* painting routine */
		/* paint background */
		/* draw raster */
		g.setColor(colors[0]);
		g.fillRect(0,0, getSize().width, getSize().height);
		g.setColor(colors[1]);
		/* TODO: rewrite so that we dont clog up the renderloop (via bitmasking) */
		//settings.forEach((String s, Boolean b) -> {
		//});
		if(settings.get("grid")) drawGrid(g, Color.YELLOW);
		if(settings.get("clear")) clear();
		//if(settings.get("snap")) pixels = pixels.forEach(e -> alignToGrid(pixels));
		pixels.forEach(p -> {
			g.setColor(p.getColor());
			g.fillRect(p.getX(), p.getY(), pixelSize + scale, pixelSize + scale);
		});
	}
}
