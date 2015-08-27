package com.hackhalo2.libhack.ashley.component;

import com.badlogic.ashley.core.Component;

/**
 * Represents a simple position component that uses Integers for the Ashley ECS.
 * @author Jacob HACKhalo2 Litewski
 *
 */
public class SimpleIntPosition implements Component {
	/**
	 * The X position of the Entity
	 */
	public int x;
	
	/**
	 * The Y Position of the Entity
	 */
	public int y;

	/**
	 * Constructs a new SimpleIntPosition Component with the defined X and Y coordinates
	 */
	public SimpleIntPosition() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructs a new SimpleIntPosition Component with the defined X and Y coordinates
	 * @param x
	 * @param y
	 */
	public SimpleIntPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
