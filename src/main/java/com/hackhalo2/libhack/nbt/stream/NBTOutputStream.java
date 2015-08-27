package com.hackhalo2.libhack.nbt.stream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.badlogic.gdx.files.FileHandle;
import com.hackhalo2.libhack.nbt.ITag;
import com.hackhalo2.libhack.nbt.exceptions.NBTException;

public class NBTOutputStream extends DataOutputStream {

	public NBTOutputStream(FileHandle handle, boolean append) {
		super(new BufferedOutputStream(handle.write(append)));
	}
	
	public void writeNBT(ITag tag) throws NBTException, IOException {
		this.writeByte(tag.getID());
		
		tag.writeNBT(this, false);
	}

}
