package com.hackhalo2.libhack.nbt.tags;

import java.io.IOException;

import com.hackhalo2.libhack.nbt.exceptions.NBTException;
import com.hackhalo2.libhack.nbt.stream.NBTInputStream;
import com.hackhalo2.libhack.nbt.stream.NBTOutputStream;

public final class TagFloat extends AbstractTag {
	private float value;

	public TagFloat(String name) {
		super(name, TagType.FLOAT.getID());
	}
	
	public TagFloat(NBTInputStream in, boolean anonymous) throws NBTException, IOException {
		 super(in, anonymous, TagType.FLOAT.getID());
		 
		 this.value = in.readShort();
	}
	
	public float getValue() {
		return this.value;
	}
	
	public void setValue(float b) {
		this.value = b;
	}

	@Override
	public void writeNBT(NBTOutputStream out, boolean anonymous)
			throws NBTException, IOException {
		super.writeNBT(out, anonymous);
		
		out.writeFloat(this.value);
	}
}
