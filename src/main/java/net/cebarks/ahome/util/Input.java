package net.cebarks.ahome.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Input implements KeyListener, MouseListener {

	public HashMap<Integer, Boolean> key = new HashMap<Integer, Boolean>();
	public HashMap<Integer, Boolean> mouse = new HashMap<Integer, Boolean>();
	private ArrayList<InputHandler> inputHandlers = new ArrayList<InputHandler>();

	public boolean isKeyDown(int i) {
		if (key.containsKey(i))
			return true;
		return false;
	}

	public boolean isMouseDown(int i) {
		if (mouse.containsKey(i))
			return true;
		return false;
	}

	public void keyPressed(KeyEvent e) {
		key.put(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		key.remove(e.getKeyCode());
	}

	public void mousePressed(MouseEvent e) {
		key.put(e.getButton(), true);
	}

	public void mouseReleased(MouseEvent e) {
		key.remove(e.getButton());
	}
	
	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void registerInputHandler(InputHandler ih) {
		inputHandlers.add(ih);
	}
	
	public ArrayList<InputHandler> getInputHandlers() {
		return inputHandlers;
	}
}
