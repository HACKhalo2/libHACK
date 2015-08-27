package com.hackhalo2.libhack.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * A Simple LibGDX Sprite Component for the Ashley ECS<br/>
 * <b><i>This class uses LibGDX!</i></b> 
 * @author Jacob HACKhalo2 Litewski
 *
 */
public class SimpleGDXSprite implements Component {
	/**
	 * The LibGDX {@link Sprite} this Component manages
	 */
	public Sprite sprite;
	
	/**
	 * Constructs a new SimpleGDXSprite Component with the Sprite set to its defaults
	 */
	public SimpleGDXSprite() {
		this.sprite = new Sprite();
	}
	
	/**
	 * Constructs a new SimpleGDXSprite Component with the supplied  LibGDX {@link Sprite}
	 * @param sprite The Sprite to copy
	 */
	public SimpleGDXSprite(Sprite sprite) {
		this.sprite = new Sprite(sprite);
	}
	
	/**
	 * Constructs a new SimpleGDXSprite with the supplied LibGDX {@link Texture}
	 * @param texture The Texture to make the Sprite from
	 */
	public SimpleGDXSprite(Texture texture) {
		this.sprite = new Sprite(texture);
	}
	
	/**
	 * Constructs a new SimpleGDXSprite with the supplied LibGDX {@link TextureRegion}
	 * @param region The TextureRegion to make the Sprite from
	 */
	public SimpleGDXSprite(TextureRegion region) {
		this.sprite = new Sprite(region);
	}

}
