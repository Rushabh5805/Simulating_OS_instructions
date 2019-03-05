package osd_2;

public class pcb1 {
	int pc;
    int mar;
    int accumulator;
    int extendedBit;

    public pcb1() {
    }
    
    
    public pcb1(int pc, int mar, int accumulator, int extendedBit) {
        this.pc = pc;
        this.mar = mar;
        this.accumulator = accumulator;
        this.extendedBit = extendedBit;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public int getExtendedBit() {
        return extendedBit;
    }

    public void setExtendedBit(int extendedBit) {
        this.extendedBit = extendedBit;
    }
    
    
}
