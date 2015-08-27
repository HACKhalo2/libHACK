package com.hackhalo2.libhack.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.hackhalo2.libhack.util.Screen;

/**
 * An Abstract {@link Screen} Implementation that depends on LibGDX methods.
 * @author Jacob HACKhalo2 Litewski
 */
public abstract class GDXAbstractScreen implements Screen {
	/** The Name of the Screen */
	private final String name;
	
	/** The camera for the Screen (Not used with the Stage) */
	protected OrthographicCamera camera;
	
	/** The Stage for the UI elements */
	protected Stage uiStage;

	public GDXAbstractScreen(String name) {
		this.name = name;
		this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.uiStage = new Stage();
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Renders the Stage used for the UI elements
	 * @param delta
	 */
	protected void renderUI(float delta) {
		this.uiStage.act(delta);
		this.uiStage.draw();
	}
	
	/**
	 * Sets up the GLState to begin rendering. Sets the clear color to black, sets up alpha blending,
	 * and clears the color buffer bit
	 */
	protected void beginRender() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	/**
	 * Sets up the GLState to begin rendering. Sets the clear color to the rgba inputs,
	 * sets up alpha blending, and clears the color buffer bit
	 * @param r Red, between 0.0f and 1.0f
	 * @param g Green, between 0.0f and 1.0f
	 * @param b Blue, between 0.0f and 1.0f
	 * @param a Alpha, between 0.0f and 1.0f
	 */
	protected void beginRender(float r, float g, float b, float a) {
		Gdx.gl.glClearColor(r, g, b, a);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	/**
	 * Called before the end of the Render loop to clean up any GLState that needs to be cleaned up before
	 * the beginning of the next render loop
	 */
	protected void endRender() { }

	@Override
	public void resize(int width, int height) {
		//Update the Stage
		this.uiStage.getViewport().update(width, width);
		
		//Update the camera
		this.camera.viewportHeight = height;
		this.camera.viewportWidth = width;
		this.camera.update();

	}
	
	@Override
	public void dispose() {
		this.uiStage.dispose();
	}

}
