package com.hackhalo2.libhack.nbt;

import java.io.IOException;

import com.hackhalo2.libhack.nbt.exceptions.NBTException;
import com.hackhalo2.libhack.nbt.stream.NBTOutputStream;

public interface ITag {
	
	public String getName();
	
	public byte[] getNameAsBytes();
	
	public void setName(String name);
	
	public byte getID();
	
	public ITagContainer getParent();
	
	public void setParent(ITagContainer parent);
	
	public boolean hasParent();
	
	public void writeNBT(NBTOutputStream out, boolean anonymous) throws NBTException, IOException;

}
