package com.hackhalo2.libhack.ashley.component;

import com.badlogic.ashley.core.Component;

/**
 * Represents a simple position component that uses Floats for the Ashley ECS.
 * @author Jacob HACKhalo2 Litewski
 *
 */
public class SimpleFloatPosition implements Component {
	/**
	 * The X Position of the Entity
	 */
	public float x;
	
	/**
	 * The Y Position of the Entity
	 */
	public float y;

	/**
	 * Constructs a new SimpleFloatPosition Component with the X and Y coordinates defaulted to 0
	 */
	public SimpleFloatPosition() {
		this.x = 0f;
		this.y = 0f;
	}
	
	/**
	 * Constructs a new SimpleFloatPosition Component  with the defined X and Y coordinates
	 * @param x
	 * @param y
	 */
	public SimpleFloatPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

}
