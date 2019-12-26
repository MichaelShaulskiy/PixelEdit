package me.interject.pixeledit;

/**
 * Created by mshau on 03.09.2016.
 */
public class VBMP {
	class VBMPHeaderTable {

	}

	/* actual file header */
	class VBPMHeader {
		private final int magic = 0xB16; /* BIG */
		private boolean zip;
		private VBMPHeaderTable headerTable;
	}

}
