package com.hackhalo2.libhack.nbt.tags;

import java.io.IOException;

import com.hackhalo2.libhack.nbt.IAnonymousTagContainer;
import com.hackhalo2.libhack.nbt.INamedTagContainer;
import com.hackhalo2.libhack.nbt.ITag;
import com.hackhalo2.libhack.nbt.ITagContainer;
import com.hackhalo2.libhack.nbt.exceptions.NBTException;
import com.hackhalo2.libhack.nbt.stream.NBTInputStream;
import com.hackhalo2.libhack.nbt.stream.NBTOutputStream;
import com.hackhalo2.libhack.util.IOHandler;

public abstract class AbstractTag implements ITag {

	protected String name = "";
	protected ITagContainer parent;
	protected final byte id;

	protected AbstractTag(String name, byte id) {
		this.setName(name);
		this.id = id;
	}

	protected AbstractTag(NBTInputStream in, boolean anonymous, byte id) throws NBTException, IOException {
		if(in == null) throw new NBTException("The InputStream was null!");
		System.out.print("Stream remaining: "+in.available());

		if(!anonymous) {
			short nameSize = in.readShort();
			byte[] nameBytes = new byte[nameSize];

			in.readFully(nameBytes);
			this.setName(new String(nameBytes, IOHandler.UTF8));
		}

		this.id = id;
		System.out.println(", Read Tag "+TagType.valueOf(this.id)+" Name: "+this.name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public byte[] getNameAsBytes() {
		return this.name.getBytes(IOHandler.UTF8);
	}

	@Override
	public void setName(String name) {
		try {
			if(name != null) {
				if(this.parent != null) this.parent.removeTag(this);

				this.name = name;

				if(this.parent != null) {
					if(this.parent instanceof IAnonymousTagContainer)
						((IAnonymousTagContainer) this.parent).addTag(this);
					else
						((INamedTagContainer) this.parent).addTag(this);
				}
			}
		} catch(NBTException e) {
			System.err.println("Unable to set the name of this Tag!");
			e.printStackTrace();
		}
	}

	public void setParent(ITagContainer parent) {
		try {
			if (this.parent != null) this.parent.removeTag(this);
		} catch(NBTException e) {
			System.err.println("Unable to set "+parent.getName()+" as "+ this.getName()+"'s parent!");
			e.printStackTrace();
		}

		this.parent = parent;
	}

	public ITagContainer getParent() {
		return this.parent;
	}
	
	public boolean hasParent() {
		return (this.parent != null);
	}

	@Override
	public byte getID() {
		return this.id;
	}

	@Override
	public void writeNBT(NBTOutputStream outputStream, boolean anonymous) throws NBTException, IOException {
		if(!anonymous) {
			byte[] name = this.getNameAsBytes();

			outputStream.writeShort(name.length);

			outputStream.write(name);
		}
	}

}
