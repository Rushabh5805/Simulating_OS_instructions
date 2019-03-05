package osd_2;

//import java.util.ArrayList;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main_fun {

	public static void main(String args[]) {

		int direct_indirect_bit, temp_address,address=0;
		String[] cmd; 
		int[] mem= {10,20,3,1007,50,1008,60,4,80,90};
		int AC=0, mbr, E=0;
		int f=0;
		int mar, instruction=0;
		int pc=0;
		String line;
		String[] file_data = new String[15];
		try {
			File file = new File("C:\\Users\\RUSHABH\\Desktop\\test.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int temp_file_pointer=0;
			while ((line = bufferedReader.readLine()) != null) {
				file_data[temp_file_pointer]=line;
				//System.out.println(xyz[i]);
				temp_file_pointer++;
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (!file_data[pc].toLowerCase().equals("end")) {
			//System.out.println(xyz[pc]);
			String s12=file_data[pc];
			cmd=s12.split("\\W+");
			System.out.print("pc "+pc+"\n");
			direct_indirect_bit=Integer.parseInt(cmd[0]);
			if (direct_indirect_bit==0) {
				temp_address=Integer.parseInt(cmd[2]);
				address=modulo(temp_address);
				instruction=Integer.parseInt(cmd[1]);}
			else if (direct_indirect_bit==1) {
				temp_address=Integer.parseInt(cmd[2]);
				address=modulo(temp_address);
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
					System.out.println("AC: "+AC);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=mem[modulo(mar)];
					AC=AC&mbr;
					f=0;
					System.out.println("AC: "+AC);
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
					System.out.println("AC: "+AC);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=mem[modulo(mar)];
					AC=AC+mbr;
					f=0;
					System.out.println("AC: "+AC);
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
					System.out.println("AC: "+AC);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=mem[modulo(mar)];
					AC=mbr;
					f=0;
					System.out.println("AC: "+AC);
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
					System.out.println("AT LOCATION:"+mar+" "+mem[mar]);
				}
				else if(direct_indirect_bit==1) {
					mar=mem[address];
					mbr=AC;
					mem[modulo(mar)]=mbr;
					f=0;
					System.out.println("AT LOCATION:"+modulo(mar)+" "+mem[modulo(mar)]);
				}
				else {
					System.out.println("not valid instruction");
				}
				break;
			case 4://BUN
				if(direct_indirect_bit==0) {
					pc=address-1;
					System.out.println("pc "+pc);
					f=0;
				}
				else if(direct_indirect_bit==1) {
					String s2=file_data[address];
					//System.out.println(s2);
					String[] s3=s2.split("\\W+");
					pc=modulo(Integer.parseInt(s3[2]));
					System.out.println("pc "+pc);
					f=0;
				}
				else {
					System.out.println("not valid instruction");
				}
				break;
			case 5://BSA
				if(direct_indirect_bit==0) {
					mar=address;
					int r = pc+2+1000;
					String s1="0 4 "+Integer.toString(r);
					file_data[mar]=s1;
					pc=mar;
					f=0;
					System.out.println(" pc "+pc);
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
				System.out.println(AC);
				break;
				//pc=pc-1;
			case 7400://CLE
				E=0;
			case 7200://CMA
				/*String binaryString = Integer.toBinaryString(AC);

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
					  AC = Integer.parseInt(temp, base);*/
				AC=~AC;
				System.out.println(AC);
				break;
				//pc=pc-1;
			case 7100://CME
				E=~E;
			case 7080://CIR
				AC=AC/2;
			case 7040://CIL
				AC=AC*2;
			case 7020://INC
				AC=AC+1;
			case 7010://SPA
				if(AC>0) {
					pc=pc+1;
				}
			case 7008://SNA
				if(AC<0) {
					pc=pc+1;
				}
			case 7004://SZA
				if(AC==0) {
					pc=pc+1;
				}
			case 7002://SZE
				if(E==0) {
					pc=pc+1;
				}
			case 7001://HLT
				System.exit(0);;
			}
			pc++;
			//System.out.println("Enter the instruction");
			//abc =sc.nextLine();
		}
		/*int u =0;
		while (xyz[u]!=null) {
				System.out.println(xyz[u]);
				//System.out.println(xyz[i]);
				u++;
			}*/

	}
	public static int modulo(int j) {
		int i=j%1000;
		return i;

	}
}
