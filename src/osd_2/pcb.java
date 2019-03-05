package osd_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class pcb {
	public static void main(String args[]) {
	boolean getin=true;
	int k=0,j=0;
	String line;
	int i=0;
	String[] xyz = new String[20];
	while(getin) {
		try {
 			File file = new File("C:\\Users\\RUSHABH\\Desktop\\pcb1.txt");
 			FileReader fileReader = new FileReader(file);
 			BufferedReader bufferedReader = new BufferedReader(fileReader);
 			File file1 = new File("C:\\Users\\RUSHABH\\Desktop\\pcb2.txt");
 			FileReader fileReader1 = new FileReader(file1);
 			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
 			RandomAccessFile f1 = new RandomAccessFile("C:\\Users\\RUSHABH\\Desktop\\pcb1.txt","r");
 			RandomAccessFile f2 = new RandomAccessFile("C:\\Users\\RUSHABH\\Desktop\\pcb2.txt","r");
 			
 			if(k==0) {
	 			while ((line = bufferedReader.readLine()) != null) {
	 				xyz[i]=line;
	 				System.out.println(i+" "+j+" "+xyz[i]);
	 				i++;
	 				j++;
	 				if(j==3) {
	 					j=0;
	 					k=1;
	 					break;
	 				}
	  			}
 			}
 			else if(k==1) {
	 			while ((line = bufferedReader1.readLine()) != null) {
	 				xyz[i]=line;
	 				System.out.println(i+" "+j+" "+xyz[i]);
	 				i++;
	 				j++;
	 				if(j==3) {
	 					j=0;
	 					k=0;
	 					break;
	 				}
	  			}
	 		}
	 		fileReader.close();
	 		fileReader1.close();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
	}
	/*int u =0;
	while (xyz[u]!=null) {
			System.out.println(xyz[u]);
			//System.out.println(xyz[i]);
			u++;
	}*/
	}
}
	
