package MobileTesting.Mobile;

public class NameCom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		  
		
		  
		  System.out.println(findJewelLength("G()()()()(al)"));;
			

	}
	
	public static String findJewelLength(String command) {
		
		String res=null;
		for(int i=0;i<command.length();i++) {
//			if(command.contains("G")) {
//				res=command.replace('G', 'G');
//				
//			} else if(command.contains("()")) {
//				res=command.replace("()", "o");
//				
//			} else if(command.contains("(al)")) {
//				res=command.replaceAll("(al)", "al");
//				
//			}
			
			if(command.contains("(al)")) {
				res=command.replace("(al)", "al");
			}
			if(command.contains("()")) {
				res=command.replace("()", "o");
			}
			
		}
		
		return res;
		
	}

}
