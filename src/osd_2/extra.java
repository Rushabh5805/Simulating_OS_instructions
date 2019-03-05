package osd_2;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class extra {


//public class main_fun {
	
	public static void main(String args[]) {
		
		int ID, addr1,addr=0;
		String[] cmd; 
		int[] mem= {10,20,30,40,50,1000,60,70,80,90};
		int AC=0, mbr, E, PC=0;
		int mar;
		int pc=0;
		String xyz ="";
		
		//while (xyz[pc]!=null) {
		String s12="0 1 1002";
		cmd=s12.split("\\W+");
		ID=Integer.parseInt(cmd[0]);
		addr1=Integer.parseInt(cmd[2]);
		addr=modulo(addr1);
		int ins=Integer.parseInt(cmd[1]);
		switch(ins) {
		
				case 0://and
					if(ID==0) {
						mar=addr;
						mbr=mem[mar];
						AC=AC*mbr;
						System.out.println(AC);
					}
					else if(ID==1) {
						mar=mem[addr];
						mbr=mem[modulo(mar)];
						AC=AC*mbr;
						System.out.println(AC);
					}
					else {
						System.out.println("not valid instruction");
					}
					break;
		
				case 1://add
					if(ID==0) {
						mar=addr;
						mbr=mem[mar];
						AC=AC+mbr;
						System.out.println(AC);
					}
					else if(ID==1) {
						mar=mem[addr];
						mbr=mem[modulo(mar)];
						AC=AC+mbr;
						System.out.println(AC);
					}
					else {
						System.out.println("not valid instruction");
					}
					break;
				
				case 2://lda
					if(ID==0) {
						mar=addr;
						mbr=mem[mar];
						AC=mbr;
						System.out.println(AC);
					}
					else if(ID==1) {
						mar=mem[addr];
						mbr=mem[modulo(mar)];
						AC=mbr;
						System.out.println(AC);
					}
					else {
						System.out.println("not valid instruction");
					}
					break;
					
				case 3://STA
					if(ID==0) {
						mar=addr;
						mbr=AC;
						mem[mar]=mbr;
						System.out.println(mem[mar]);
					}
					else if(ID==1) {
						mar=mem[addr];
						mbr=AC;
						mem[modulo(mar)]=mbr;
						System.out.println(mem[modulo(mar)]);
					}
					else {
						System.out.println("not valid instruction");
					}
					break;
				case 4://BUN
					if(ID==0) {
						pc=addr;
						System.out.println(pc);
					}
					else if(ID==1) {
						pc=mem[modulo(addr)];
						System.out.println(pc);
					}
					else {
						System.out.println("not valid instruction");
					}
					break;
				/*case 5://BSA
					if(ID==0) {
						mar=addr;
						int r = pc+1;
						String s1="2 4 "+Integer.toString(r);
						xyz[addr]=s1;
						pc=mar;
						System.out.println("mar "+mar+" xyz "+xyz[addr]+" pc "+pc);
					}
					else if(ID==1) {
						
					}
					else {
						System.out.println("not valid instruction");
					}*/
		}
		//pc++;
		//System.out.println("Enter the instruction");
		//abc =sc.nextLine();
		}
		
	
	public static int modulo(int j) {
		int i=j%1000;
		return i;
		
	}
}

