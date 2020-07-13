package de.hexagonsoftware.iob.api;

import com.gacm.isleofberk.IsleofBerk;

import de.hexagonsoftware.hul.minecraft.ResourceStorer;

public interface IIOBMod {
	IsleofBerk getIOB();
	ResourceStorer getResourceStorer();
}
