package text1;
//��������
import java.io.*;
import java.util.Set;
import java.util.TreeMap;
public class basecount {
	//������������
    static  public void count(String action,String thefile){
    	print(action,thefile,null);
     }
  //������������ 
    static public void count(String action1,String action2,String thefile){
    	if(thefile.endsWith(".c")){//����
    	 count(action1,thefile);
    	 count(action2,thefile);}
    	else//������������ļ���
    	{print(action1,action2,thefile);
    	}
    }
    //�����ĸ�����
    static public void count(String action1,String action2,String action3,String thefile){
    	if(action3.equals("-o")){
    		 print(action1,action2,thefile);
   	   }
    	else{
    		   count(action1,thefile);
    	   	   count(action2,thefile);
    	   	   count(action3,thefile);
    		
    	}
   }
    ////�����������
    static public void count(String action1,String action2,String sourcefile,String action3,String thefile){
    	count(action1,sourcefile,action3,thefile);
    	count(action2,sourcefile,action3,thefile);
    }
   //������������
    static public void count(String action1,String action2,String action3,String sourcefile,String action4,String thefile){
    		count(action1,sourcefile,action4,thefile);
    		count(action2,sourcefile,action4,thefile);
    		count(action3,sourcefile,action4,thefile);
    }
    //�����ַ�����
    public static void charcount(String thefile,String output){
 		int charcount=0;
 		String sfile=new String(thefile);
 		File file=new File(sfile);
 		if(file.exists()){
 			try{
 				FileInputStream fis=new FileInputStream(file);
 				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
 				BufferedReader br=new BufferedReader(isr);
 				String line=new String("");
 				StringBuffer sb=new StringBuffer();
 				while((line=br.readLine())!=null){
 					sb.append(line);
 					charcount+=line.length();
 				}
 				br.close();
 				isr.close();
 				fis.close();
 			}
 			catch(FileNotFoundException e){
 				e.printStackTrace();
 			}
 			catch(UnsupportedEncodingException e){
 				e.printStackTrace();
 			}
 			catch(IOException e){
 				e.printStackTrace();
 			}
 		}
 		try{
 			//��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
 			if(output==null)
 				output="result.txt";
            FileWriter writer = new FileWriter(output, true);
            char[] message=(thefile+", �ַ�����"+charcount+"\r\n").toCharArray();//����"\r\n"����"\n"
            writer.write(message);
 			writer.close();
 		}
 		catch(IOException e){
 			System.out.println("File read/write Error"+e);
 		}
     }
    //���㵥�ʸ���
    public static void wordcount(String thefile,String output){
		int wordcount=0;
		String sfile=new String(thefile);
		File file=new File(sfile);
		if(file.exists()){
			try{
				FileInputStream fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				String line=new String("");
				StringBuffer sb=new StringBuffer();
				TreeMap<String, Integer> map = new TreeMap<>(); 
				while((line=br.readLine())!=null){
 			        String[] split = line.split("\\s++|\\.|,|\\;|\\(|\\)|\\[|\\]|\\<|\\>|\\=|\\-|\\+|\\*|\\/|\\{|\\}");  
 			        for (int i = 0; i < split.length; i++) { 
// 			          ��ȡ��ÿһ������  
 			            Integer integer = map.get(split[i]);  
// 			          ������������map��û�У���ֵ1  
 			            if(null==integer){  
 			                map.put(split[i], 1);  
 			            }else{  
// 			              ����У���ԭ���ĸ����ϼ���һ  
 			                map.put(split[i], ++integer);  
 			            }  
 			        }  
 				}
// 		      ����������key��ȡ����Ӧ��value  
 		        Set<String> keySet = map.keySet();  
 		        for (String string : keySet)
 		        	if(!(string.equals("")))
 		        	wordcount+=map.get(string);
 	
				br.close();
				isr.close();
				fis.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		try{
			//��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			if(output==null)
				output="result.txt";
            FileWriter writer = new FileWriter(output, true);
            char[] message=(thefile+", ��������"+wordcount+"\r\n").toCharArray();//����"\r\n"����"\n"
            writer.write(message);
 			writer.close();
		}
		catch(IOException e){
			System.out.println("File read/write Error"+e);
		}
     }
    //��������
    public static void linecount(String thefile,String output){
    	int linecount=0;
		String sfile=new String(thefile);
		File file=new File(sfile);
		if(file.exists()){
			try{
				FileInputStream fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				String line=new String("");
				StringBuffer sb=new StringBuffer();
				while((line=br.readLine())!=null){
					linecount++;
					sb.append(line);
				}
				br.close();
				isr.close();
				fis.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		try{
			//��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			if(output==null)
				output="result.txt";
            FileWriter writer = new FileWriter(output, true);
            char[] message=(thefile+",   ������"+linecount+"\r\n").toCharArray();//����"\r\n"����"\n"
            writer.write(message);
 			writer.close();
		}
		catch(IOException e){
			System.out.println("File read/write Error"+e);
		}
    }
    //�����ָ���ļ����ļ�
    public static void print(String action1,String sourcefile,String thefile){
    	int linecount=0;
    	int charcount=0;
    	int wordcount=0;
		String sfile=new String(sourcefile);
		File file=new File(sfile);
		if(file.exists()){
			try{
				FileInputStream fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				String line=new String("");
				StringBuffer sb=new StringBuffer();
				 TreeMap<String, Integer> map = new TreeMap<>(); 
				while((line=br.readLine())!=null)
				{
					linecount++;
					sb.append(line);
					charcount+=line.length();

 			        String[] split = line.split("\\s++|\\.|,|\\;|\\(|\\)|\\[|\\]|\\<|\\>|\\=|\\-|\\+|\\*|\\/|\\{|\\}");  
 			        for (int i = 0; i < split.length; i++) { 
// 			          ��ȡ��ÿһ������  
 			            Integer integer = map.get(split[i]);  
// 			          ������������map��û�У���ֵ1  
 			            if(null==integer){  
 			                map.put(split[i], 1);  
 			            }else{  
// 			              ����У���ԭ���ĸ����ϼ���һ  
 			                map.put(split[i], ++integer);  
 			            }  
 			        }  
 				}
// 		      ����������key��ȡ����Ӧ��value  
 		        Set<String> keySet = map.keySet();  
 		        for (String string : keySet)
 		        	if(!(string.equals("")))
 		        	wordcount+=map.get(string);
				br.close();
				isr.close();
				fis.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		try{
			//��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			if(thefile==null)
				thefile="result.txt";
			FileWriter writer = new FileWriter(thefile, true);
            char[] message=null;
            if(action1.equals("-l"))
                  message=(sourcefile+",   ������"+linecount+"\r\n").toCharArray();//����"\r\n"����"\n"
            else if(action1.equals("-c"))
            	 message=(sourcefile+",   �ַ�����"+charcount+"\r\n").toCharArray();//����"\r\n"����"\n"
            else if(action1.equals("-w"))
            	 message=(sourcefile+",   ��������"+wordcount+"\r\n").toCharArray();//����"\r\n"����"\n"
            if(message!=null)  writer.write(message);
            else System.out.println("�޸ò���");
 			writer.close();
		}
		catch(IOException e){
			System.out.println("File read/write Error"+e);
		}
    }
}

