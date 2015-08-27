package com.hackhalo2.libhack.ashley.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * A somewhat complex {@link EntitySystem} used for Rendering Entities using LibGDX Batches. 
 * This System Iterates over the entities it manages, calling processEntity() on them each time
 * the System is updated. This System also allows the underlying {@link Entity} Array to be updated
 * as Entities get added and removed from the {@link Engine}.
 * <br/>
 * <b><i>This Class uses LibGDX!</i></b>
 * @author hackhalo2
 */
public abstract class BatchEntitySystem extends EntitySystem implements EntityListener, Disposable {
	private Family family;
	private Array<Entity> entities;
	private Batch batch;
	private boolean ownsBatch;
	
	/**
	 * Constructs a new BatchEntitySystem with the provided Family. This System will use an internal Batch
	 * with a priority of 0. <b>Remember to call dispose() after you are done with this class!</b>
	 * @param family
	 */
	public BatchEntitySystem(Family family) {
		this(family, new SpriteBatch(), 0, true);
	}

	/**
	 * Constructs a new BatchEntitySystem with the provided Family. This System will use an internal Batch
	 * with the provided priority. <b>Remember to call dispose() after you are done with this class!</b>
	 * @param family
	 * @param priority The priority this System should have
	 */
	public BatchEntitySystem(Family family, int priority) {
		this(family, new SpriteBatch(), priority, true);
	}
	
	/**
	 * Constructs a new BatchEntitySystem with the provided Family and LibGDX Batch.
	 * This System will use a priority of 0.
	 * @param family
	 * @param batch The LibGDX Batch to use for rendering
	 */
	public BatchEntitySystem(Family family, Batch batch) {
		this(family, batch, 0, false);
	}
	
	/**
	 * Constructs a new BatchEntitySystem with the provided Family and LibGDX Batch.
	 * This System will use the provided priority.
	 * @param family
	 * @param batch The LibGDX Batch to use for rendering
	 * @param priority The priority this System should have
	 */
	public BatchEntitySystem(Family family, Batch batch, int priority) {
		this(family, batch, priority, false);
	}
	
	private BatchEntitySystem(Family family, Batch batch, int priority, boolean ownsBatch) {
		super(priority);
		this.family = family;
		this.batch = batch;
		this.ownsBatch = ownsBatch;
		
		this.entities = new Array<>();
	}
	
	@Override
	public void update (float delta) {
		this.batch.begin();
		for(Entity entity : this.entities) {
			this.processEntity(entity, this.batch, delta);
		}
		this.batch.end();
	}
	
	/**
	 * Processes an Entity from the internal entity array
	 * @param entity The Entity to process
	 * @param batch The Batch to draw to
	 * @param delta The time between frames
	 */
	protected abstract void processEntity(Entity entity, Batch batch, float delta);
	
	@Override
	public void addedToEngine(Engine engine) {
		ImmutableArray<Entity> engineEntities = engine.getEntitiesFor(this.family);
		this.entities.clear();
		
		for(Entity e : engineEntities) this.entities.add(e);
		
		this.entities.shrink();
		engine.addEntityListener(this.family, this);
	}
	
	@Override
	public void removedFromEngine(Engine engine) {
		engine.removeEntityListener(this);
		this.entities.clear();
	}
	
	@Override
	public void entityAdded(Entity entity) {
		this.entities.add(entity);
	}

	@Override
	public void entityRemoved(Entity entity) {
		this.entities.removeValue(entity, true);
		this.entities.shrink();
	}
	
	/**
	 * Gets the {@link Family} this System manages
	 * @return The underlying family
	 */
	public Family getFamily() {
		return this.family;
	}

	/**
	 * Gets the {@link ImmutableArray} of the underlying {@link Entity} Array. This Array <b>CANNOT</b> be changed
	 * using this method
	 * @return An ImmutableArray of the Entities this System Manages
	 */
	public ImmutableArray<Entity> getEntities() {
		return new ImmutableArray<Entity>(this.entities);
	}
	
	@Override
	public void dispose() {
		if(this.ownsBatch) {
			this.batch.dispose();
		}
	}

}
