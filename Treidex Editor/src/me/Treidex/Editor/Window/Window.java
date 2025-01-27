package me.Treidex.Editor.Window;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public String name;
	public int width, height;
	
	public final boolean resizable;
	
	public Window(String name, int width, int height, final boolean resizable) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.resizable = resizable;
		
		setName(name);
		setSize(width, height);
		setResizable(resizable);
		getContentPane().setBackground(Color.decode("#333232"));
		
		if (resizable)
			addComponentListener(new ComponentAdapter() 
			{
				@Override
				public void componentResized(ComponentEvent e) {
				    Component c = (Component) e.getSource();
				    super.componentResized(e);
				    resizeWindow(c.getWidth(), c.getHeight());
				}
			});
	}
	
	public void Create() {
		setLocationRelativeTo(null);
		setVisible(true);
		setJMenuBar(MenuBar.$this);
	}
	
	public void resizeWindow(int width, int height) {
		this.width = width;
		this.height = height;
	}
}