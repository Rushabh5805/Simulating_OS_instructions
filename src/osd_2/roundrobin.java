package osd_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;


public class roundrobin {
	public static void main(String args[]) {
		//boolean getin=true;
		int k=0,j=0;
		String line, temp;
		int i=0, a=0;
		String[] xyz1 = new String[20];
		String[] xyz2 = new String[20];
		String[] comb = new String[20];
			try {
	 			File file = new File("C:\\Users\\RUSHABH\\Desktop\\pcb1.txt");
	 			FileReader fileReader = new FileReader(file);
	 			BufferedReader bufferedReader = new BufferedReader(fileReader);
	 			File file1 = new File("C:\\Users\\RUSHABH\\Desktop\\pcb2.txt");
	 			FileReader fileReader1 = new FileReader(file1);
	 			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
	 			while ((line = bufferedReader.readLine()) != null) {
	 				xyz1[i]=line;
	 				i++;
	 			}
	 			while ((line = bufferedReader1.readLine()) != null) {
	 				xyz2[j]=line;
	 				j++;
	 			}
	 				} catch (IOException e) {
	 			e.printStackTrace();
	 		}int q=0, p=0,r=0;
			while (!xyz2[q].equals("end")||!xyz1[p].equals("end")) {
				if(k==0) {
						r++;
						comb[a]=xyz1[p];
						if (xyz1[p+1].equals("end")) {
							k=1;
							r=0;
						}
		 				p++;
		 				System.out.println("1 "+a+" "+j+" "+p+" "+comb[a]);
		 				a++;
		 				if(r==3) {
		 					r=0;
		 					k=1;
		 					//break;
		 				}
		  			}
	 			
	 			else if(k==1) {
	 					r++;
		 				comb[a]=xyz2[q];
		 				if (xyz2[q+1].equals("end")) {
							k=0;
							r=0;
						}
		 				q++;
		 				System.out.println("2 "+a+" "+j+" "+q+" "+comb[a]);
		 				a++;
		 				
		 				if(r==3) {
		 					r=0;
		 					k=0;
		 					//break;
		 				}
		  			
		 		}

			}
		
		int u = 0;
		while (comb[u]!=null) {
				System.out.println(comb[u]+" "+u);
				//System.out.println(xyz[i]);
				u++;
		}
		/*int v = 0;
		while (xyz2[v]!=null) {
				System.out.println(xyz2[v]+" "+v);
				//System.out.println(xyz[i]);
				v++;
		}*/
		/*int u =0;
		while (xyz[u]!=null) {
				System.out.println(xyz[u]);
				//System.out.println(xyz[i]);
				u++;
		}*/
		}
	}
		

