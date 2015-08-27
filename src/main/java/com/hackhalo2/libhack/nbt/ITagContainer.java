package com.hackhalo2.libhack.nbt;

import com.hackhalo2.libhack.nbt.exceptions.NBTException;

public interface ITagContainer extends ITag {
	
	public void removeTag (ITag tag) throws NBTException;

}
