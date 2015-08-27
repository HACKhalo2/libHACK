package com.hackhalo2.libhack.nbt.stream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.badlogic.gdx.files.FileHandle;
import com.hackhalo2.libhack.nbt.ITag;
import com.hackhalo2.libhack.nbt.exceptions.NBTException;

public class NBTOutputStream extends DataOutputStream {
	
	/**
	 * Creates a new NBTOutputStream from a LibGDX {@link FileHandle}<br/>
	 * <b><i>This method relies on LibGDX Classes!</i></b>
	 * 
	 * @param handle The LibGDX FileHandle of the file to write to
	 * @param append append to the current file (<b>true</b>) or override (<b>false</b>)
	 */
	public NBTOutputStream(FileHandle handle, boolean append) {
		super(new BufferedOutputStream(handle.write(append)));
	}
	
	/**
	 * Wraps a BufferedOutputStream to accept writing NBT Tags
	 * @param out The BufferedOutputStream to write to
	 */
	public NBTOutputStream(BufferedOutputStream out) {
		super(out);
	}
	
	/**
	 * Writes the NBT Tag to the Stream
	 * @param tag The NBT Tag to write
	 * @throws NBTException
	 * @throws IOException
	 */
	public void writeNBT(ITag tag) throws NBTException, IOException {
		this.writeByte(tag.getID());
		
		tag.writeNBT(this, false);
	}

}
