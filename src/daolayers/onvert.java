package daolayers;

public class onvert {
String convert="";
int ccc[];
int conv;
	public int[] strTOhex(String str){
		for(int j=0;j<str.length();j++){
			conv=str.charAt(j);
			conv=conv+20;
			ccc[j]=conv;
			
		}
		return ccc;
	}
	
}
