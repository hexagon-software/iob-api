package de.hexagonsoftware.iob.api;

import com.gacm.isleofberk.api.IOBMod;

public class API {
	public static final String VERSION = "0.1 Alpha";
	
	public IOBMod getIOB() { return IOBMod.get(); }
}
