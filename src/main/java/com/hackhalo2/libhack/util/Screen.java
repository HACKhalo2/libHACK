package com.hackhalo2.libhack.util;

/**
 * Represents a Application Screen. Much like the LibGDX Screen, but without the LibGDX dependency
 * @author Jacob HACKhalo2 Litewski
 */
public interface Screen {
	
	/**
	 * Sets up any resources the Screen may use.
	 */
	public void setup();
	
	/**
	 * Tears down any resources the screen has set up
	 */
	public void teardown();
	
	/**
	 * Resizes the Screen.
	 * 
	 * @param width The width to resize to
	 * @param height The height to resize to
	 */
	public void resize(int width, int height);
	
	/**
	 * Renders the Screen.
	 * 
	 * @param delta The time between frames
	 */
	public void render(float delta);
	
	/**
	 * Start showing the Screen. This should be called after {@link Screen#setup()}
	 */
	public void show();
	
	/**
	 * Hide the Screen. This should be called before {@link Screen#teardown()}
	 */
	public void hide();
	
	/**
	 * Disposes of any resources the Screen may not of disposed of in {@link Screen#teardown()}
	 */
	public void dispose();

}
