package com.hackhalo2.libhack.util;

/**
 * An Abstract {@link Screen} implementation without any dependencies on LibGDX or LWJGL
 * @author Jacob HACKhalo2 Litewski
 *
 */
public abstract class SimpleAbstractScreen implements Screen {
	private final String name;

	protected SimpleAbstractScreen(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
