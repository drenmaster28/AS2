package node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class userData {
	Chequing chequing;
	Saving saving;
	
	public userData(){
		
	}
	
	
	public ArrayList <Chequing> getChequing(String filename){
		//String filename = "./src/BANK_MEMBERS.csv";
		ArrayList <Chequing> list = new ArrayList <Chequing>();
		File f = new File(filename);
		
		try {
			
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				String data = sc.nextLine();
				String info [] = data.split(",");
				
				chequing = new Chequing(info[0],info[1],info[2]);
				list.add(chequing);
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList <Saving> getSaving(String filename){
//		String filename = "./src/BANK_MEMBERS.csv";
		ArrayList <Saving> list2 = new ArrayList <Saving>();
		File f = new File(filename);
		
		try {
			
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				String data = sc.nextLine();
				String info [] = data.split(",");
				
				saving = new Saving(info[0],info[1],info[2]);
				list2.add(saving);
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list2;
	}
	
//	public void setChequing(Chequing p) {
//		.add(p);
//	}
//	
//	public void setSaving(Saving s) {
//		list2.add(s);
//	}
//	
//	public Chequing getAccount(String username) {
//		Chequing dude = null;
//		for (int i = 0 ; i < list.size() ; i++) {
//			if (username.equals(list.get(i).getUsername())) {
//			dude = list.get(i);	
//			}
//		}
//		return dude;
//	}
//	
	
	public String genUser() {
		int size =chequing.getDob().length();
		String username = chequing.getfName().substring(0,1)+
					chequing.getlName()+chequing.getDob().substring(size-2);
		
		return username;
	}
	

	
	
}
