package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJson {
	private static ArrayList<String> key=new ArrayList<String>();;
//	private static ArrayList<String> Source=new ArrayList<String>();;
	private static HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		key=GetEntity("D:\\Beijing.txt");
		hm=searchBTC.search(key);																												hm=searchBTC.search(key);
		Create("Beijing");
	}
	public static String test(String rpath,String keyword) {
		// TODO Auto-generated method stub
		key=GetEntity(rpath);
		hm=searchBTC.search(key);
		return Create(keyword);		
	}
	public static ArrayList<String> GetEntity(String rpath){
		ArrayList<String> key=new ArrayList<String>();
		try{
			FileReader fr = new FileReader(rpath);
			BufferedReader br = new BufferedReader(fr);
			String pre=br.readLine();
			String s;
			while(pre!=null){
//				s=ExtractSource(pre);
				key.add(pre);
//				Source.add(s);
				pre=br.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
	}

	public static String Extract(String pre,int flag){
		if(flag==0){
			String[] ns=pre.split("/");
			String s=ns[2];
	        return s;
		}else{
			String[] ns=pre.split("/");
			String s=ns[ns.length-1].replace(">", "");
	        return s;
		}
        		
	}
	public static String Create(String keyword){	
		String json = null;
		JSONArray ch=new JSONArray();	//用于给空数组和空对象值赋值
		JSONObject da = new JSONObject();
		try{
			JSONObject root = new JSONObject("{'name':'Beijing','id':0}");
			int[] length=new int[3];
			String[] depth_data=new String[3];
			length[0]=key.size();		//第二层对象个数
			depth_data[0]=keyword+"<br/>"+"<b>Source:</b>"+"<ul>";
			JSONArray ch1 =new JSONArray();				//第一层的孩子列表
			for(int i=0;i<length[0];i++){
				JSONObject root2 =new JSONObject();
				String sentity=Extract(key.get(i),0);		//第二层对象名称name值
				int id=10+i;
				root2.put("name",sentity).put("id",id);
				ArrayList<String> m=hm.get(key.get(i));		//获取第二层对应的第三层信息
				length[1]=m.size();		//第三层对象个数
					
				depth_data[1]=sentity+"<br/>"+"<b>Predicate:</b>"+"<ul>";
				JSONArray ch2 =new JSONArray();				//第二层的孩子列表
				for(int j=0;j<m.size();j++){	
					JSONObject root3 =new JSONObject();//对第三层信息处理，生成对象	
					String ppredicate=m.get(j);	
					String pname=Extract(m.get(j),1);

					root3.put("name", pname).put("id", id*10+j).put("children", ch).put("data", da);					
					ch2.put(root3);
					depth_data[1]+="<li>"+ppredicate+"</li>";
				}
				JSONObject data1 = new JSONObject();
				data1.put("relation",depth_data[1]);
				root2.put("children", ch2);
				root2.put("data",data1);
				depth_data[0]+="<li>"+sentity+"</li>";	
				ch1.put(root2);
			}
			JSONObject data0 = new JSONObject();
			data0.put("relation",depth_data[0]);
			root.put("children", ch1);
			root.put("data", data0);
			json=root.toString();
//			System.out.println(root);
//			Print(json)
		}catch (Exception e){
			e.printStackTrace();
		}
		return json;		
	}

}
