package osd_2;

public class SAMPLE {
	public static void main(String args[]) {
		//int ac=5;
		//ac=~ac;
	//	System.out.println(ac);
		String binaryString = Integer.toBinaryString(5);

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
		  int complement = Integer.parseInt(temp, base);
		  System.out.println(complement);


	}
}
