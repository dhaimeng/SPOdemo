package tool;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * 根据sameAs结果搜索BTC返回HashMap
 */
public class searchBTC {
	private static ArrayList<String> key=new ArrayList<String>();	//等实体链接集合
	private static HashMap<String, ArrayList<String>> hm = new  HashMap<String, ArrayList<String>>();  //Source，triple集合
	public static void main(String[] args){
		// TODO Auto-generated method stub
//				String[] key={
//				"http://sws.geonames.org/4950395/",
//				"http://sw.opencyc.org/concept/Mx4rvVjVPZwpEbGdrcN5Y29ycA",
//				"http://www.wikidata.org/entity/Q956",
//				"http://dbpedia.org/resource/Beijing"
//				};
		key=CreateJson.GetEntity("D://Beijing.txt");
		hm=search(key);
		printMap1(hm);
	}
	
	public static HashMap search(ArrayList<String> key){	//搜索对应实体三元组
//		String pre="http://data.nytimes.com/20767311849320512541";
		Connection conn = null;
		String url = "jdbc:mysql://202.117.16.65:3306/btc2014?"
	               + "user=root&password=btc2014&useUnicode=true&characterEncoding=UTF8";
		String sql =null;
		PreparedStatement pstmt;
		ResultSet rset;
	
		try{
    	 	Class.forName("com.mysql.jdbc.Driver");
    	 	conn = DriverManager.getConnection(url);     
    	 	for(String i:key){
    	 		ArrayList<String> tri=new ArrayList<String>();
    	 		for(int j=1;j<=32;j++){
	   				 sql="SELECT * from btc"+j+" where Subject='<"+i+">'";
	   		         pstmt=(PreparedStatement) conn.prepareStatement(sql);
	   		         rset=pstmt.executeQuery();
	   		         String sb,predicate;
	   		         while (rset.next()){
//   			            sb=rset.getString("Predicate").toLowerCase()+" "+rset.getString("Object");
	   		        	 	sb=rset.getString("Predicate");
	   		        	 	predicate=sb.substring(1,sb.length()-1 );   			            
   			            if(!tri.contains(predicate)){
   			            	 tri.add(predicate);
   				   		} 
   		         	}	
    	 		}   	 		
    	 		hm.put(i, tri);
    	 	}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return hm;
	}
	public static void filter(){
		
	}
	public static void printMap1(HashMap<String,ArrayList<String>> hm){
		String wpath="D:\\Beijing100\\";	
		Object[] key =  hm.keySet().toArray();  
		for(int i = 0; i<key.length; i++)
		{  
			System.out.println(key[i]+" "+hm.get(key[i]).size());
			if(hm.get(key[i]).size()>0){
				String path=wpath+i+".txt";
				try{
					FileWriter fw = new FileWriter(path, false);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(key[i].toString());
					bw.newLine();
					Iterator it=hm.get(key[i]).iterator(); 
					while(it.hasNext()) { 
						bw.write(it.next().toString());
						bw.newLine();
//						System.out.println(key[i]+" "+it.next());
					}
					bw.flush(); 
					bw.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}			
		}
	}
	public static void printkey(String[] key){
		for(String i:key){
			System.out.println(i+"hahah");
		}
	}
	public static HashMap localRead(){
		return null;
		
	}
}