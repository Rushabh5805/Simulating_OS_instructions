package osd_2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main_rr {

	public static void main(String args[]) {

		int direct_indirect_bit, temp_addr,address=0;
		String[] cmd; 
		int switching_flag=0,temp_f2_pointer=0;
		String line;
		int q=0, p=0,r=0, f=0;
		int temp_f1_pointer=0; 
		int[] mem= {10,20,3,4,50,6,60,70,80,90};
		int AC=0, mbr, E=0, PC=0;
		int mar = 0, instruction=0;
		int pc=0;
		pcb1 pcb11 = new pcb1(PC, mar, AC, E);
		pcb1 pcb22 = new pcb1(PC, mar, AC, E);
		//String line;
		String[] file1_data = new String[20];
		String[] file2_data = new String[20];
		String[] comb = new String[20];
		try {
			File file = new File("C:\\Users\\RUSHABH\\Desktop\\pcb1.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			File file1 = new File("C:\\Users\\RUSHABH\\Desktop\\pcb2.txt");
			FileReader fileReader1 = new FileReader(file1);
			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			while ((line = bufferedReader.readLine()) != null) {
				file1_data[temp_f1_pointer]=line;
				temp_f1_pointer++;
			}
			while ((line = bufferedReader1.readLine()) != null) {
				file2_data[temp_f2_pointer]=line;
				temp_f2_pointer++;
			}

			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//int k=0;
		while (!file2_data[q].equals("end")||!file1_data[p].equals("end")) {
			//System.out.println(xyz[pc]);
			if(switching_flag==0) {
				r++;
				comb[pc]=file1_data[p];
				System.out.println("Instruction of file1");
				if (file1_data[p+1].equals("end")) {
					switching_flag=1;
					r=0;
					pcb11.setPc(pc);
					pcb11.setAccumulator(AC);
					pcb11.setExtendedBit(E);
					pcb11.setMar(mar);
					PC = pcb22.getPc();
					mar = pcb22.getMar();
					E = pcb22.getExtendedBit();
					AC = pcb22.getAccumulator();
					System.out.println("End of file 1");
				}
				p++;
				if(r==3) {
					r=0;
					switching_flag=1;
					pcb11.setPc(pc);
					pcb11.setAccumulator(AC);
					pcb11.setExtendedBit(E);
					pcb11.setMar(mar);
					PC = pcb22.getPc();
					mar = pcb22.getMar();
					E = pcb22.getExtendedBit();
					AC = pcb22.getAccumulator();
					System.out.println("Switching to file 2");
				}
				
			}

			else if(switching_flag==1) {
				r++;
				comb[pc]=file2_data[q];
				System.out.println("Instruction of file2");
				if (file2_data[q+1].equals("end")) {
					switching_flag=0;
					r=0;
					pcb22.setPc(pc);
					pcb22.setAccumulator(AC);
					pcb22.setExtendedBit(E);
					pcb22.setMar(mar);
					PC = pcb11.getPc();
					mar = pcb11.getMar();
					E = pcb11.getExtendedBit();
					AC = pcb11.getAccumulator();
					System.out.println("End of file 2");
				}
				q++;
				if(r==3) {
					r=0;
					switching_flag=0;
					pcb22.setPc(pc);
					pcb22.setAccumulator(AC);
					pcb22.setExtendedBit(E);
					pcb22.setMar(mar);
					PC = pcb11.getPc();
					mar = pcb11.getMar();
					E = pcb11.getExtendedBit();
					AC = pcb11.getAccumulator();
					System.out.println("Switching to file 1");
				}
				
			}

			String s12=comb[pc];
			//a++;
			cmd=s12.split("\\W+");
			//System.out.print(pc+" ");
			direct_indirect_bit=Integer.parseInt(cmd[0]);
			if (direct_indirect_bit==0) {
				temp_addr=Integer.parseInt(cmd[2]);
				address=modulo(temp_addr);
				instruction=Integer.parseInt(cmd[1]);}
			else if (direct_indirect_bit==1) {
				temp_addr=Integer.parseInt(cmd[2]);
				address=modulo(temp_addr);
				instruction=Integer.parseInt(cmd[1]);}
			else {
				instruction=Integer.parseInt(cmd[0]);
			}
			switch(instruction) {

			case 0://and
				if(direct_indirect_bit==0) {
					mar=address;
					mbr=mem[mar];
					AC=AC&mbr;
					f=0;
					//System.out.println("AC: "+AC);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=mem[modulo(mar)];
					AC=AC&mbr;
					f=0;
					//System.out.println("AC: "+AC);
				}
				else {
					System.out.println("not valid instruction");
				}
				break;

			case 1://add
				if(direct_indirect_bit==0) {
					mar=address;
					mbr=mem[mar];
					AC=AC+mbr;
					f=0;
					//System.out.println("AC: "+AC);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=mem[modulo(mar)];
					AC=AC+mbr;
					f=0;
					//System.out.println("AC: "+AC);
				}
				else {
					System.out.println("not valid instruction");
				}
				break;

			case 2://lda
				if(direct_indirect_bit==0) {
					mar=address;
					mbr=mem[mar];
					AC=mbr;
					f=0;
					//System.out.println("AC: "+AC);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=mem[modulo(mar)];
					AC=mbr;
					f=0;
					//System.out.println("AC: "+AC);
				}
				else {
					System.out.println("not valid instruction");
				}
				break;

			case 3://STA
				if(direct_indirect_bit==0) {
					mar=address;
					mbr=AC;
					mem[mar]=mbr;
					f=0;
					//System.out.println("AT LOCATION:"+mar+" "+mem[mar]);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=AC;
					mem[modulo(mar)]=mbr;
					f=0;
					//System.out.println("AT LOCATION:"+modulo(mar)+" "+mem[modulo(mar)]);
				}
				else {
					System.out.println("not valid instruction");
				}
				break;
			case 4://BUN
				if(direct_indirect_bit==0) {
					pc=address-1;
					f=0;
					//System.out.println("pc "+pc);
				}
				else if(direct_indirect_bit==1) {
					String s2=comb[address];
					//System.out.println(s2);
					String[] s3=s2.split("\\W+");
					pc=modulo(Integer.parseInt(s3[2]));
					f=0;
					//System.out.println("pc "+pc);
				}
				else {
					System.out.println("not valid instruction");
				}
				break;
			case 5://BSA
				if(direct_indirect_bit==0) {
					mar=address;
					int t = pc+2+1000;
					String s1="0 4 "+Integer.toString(t);
					comb[mar]=s1;
					pc=mar;
					f=0;
					//System.out.println(" pc "+pc);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=AC;
					pc=mar;
					f=0;
				}
				else {
					System.out.println("not valid instruction");
				}
				break;
			case 6://ISZ
				mar=address;
				mbr=mem[mar];
				mbr+=1;
				mem[mar]=mbr;
				if(mbr==0) {
					pc+=1;
				}
				f=0;
			case 7800://CLA
				AC=0;
				//System.out.println(AC);
				break;
			case 7400://CLE
				E=0;
				break;
			case 7200://CMA
				String binaryString = Integer.toBinaryString(AC);

				String temp = "";
				for(char c: binaryString.toCharArray()){
					if(c == '1'){
						temp += "0";
					}
					else{
						temp += "1";
					}
				}
				int base = 2;
				AC = Integer.parseInt(temp, base);
				//System.out.println(AC);
				break;
				//pc=pc-1;
			case 7100://CME
				String binaryString1 = Integer.toBinaryString(E);

				String temp1 = "";
				for(char c: binaryString1.toCharArray()){
					if(c == '1'){
						temp1 += "0";
					}
					else{
						temp1 += "1";
					}
				}
				int base1 = 2;
				AC = Integer.parseInt(temp1, base1);
				//System.out.println(E);

				break;
			case 7080://CIR
				AC=AC/2;
				break;
			case 7040://CIL
				AC=AC*2;
				break;
			case 7020://INC
				AC=AC+1;
				break;
			case 7010://SPA
				if(AC>0) {
					pc=pc+1;
				}
				break;
			case 7008://SNA
				if(AC<0) {
					pc=pc+1;
				}
				break;
			case 7004://SZA
				if(AC==0) {
					pc=pc+1;
				}
				break;
			case 7002://SZE
				if(E==0) {
					pc=pc+1;
				}
				break;
			case 7001://HLT
				System.exit(0);
				break;
			}
			pc++;
			//System.out.println("pc "+pc);
		}

	}
	public static int modulo(int j) {
		int i=j%1000;
		return i;

	}
}
