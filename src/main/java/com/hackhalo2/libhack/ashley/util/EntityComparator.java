package com.hackhalo2.libhack.ashley.util;

import java.util.Comparator;

import com.badlogic.ashley.core.Entity;

/**
 * Utility Class for Comparing Ashley Entities. It's literally just an abstract class that implements
 * {@link Comparator}<{@link Entity}>.
 * @author Jacob HACKhalo2 Litewski
 */
public abstract class EntityComparator implements Comparator<Entity> {

	protected EntityComparator() { }

}
