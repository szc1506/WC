//����wc.exe -l file.c�Ŀ���̨���뷽��
package text1;
import java.io.*;
public class wc{
	public static void main(String[] args) {
		int len=args.length;
		String one,two,three,four,five,six,seven,eight,night;//�������
		if(len<=1)
			System.out.println("�밴�ո�ʽ����");
		else {
			if(len==2)
			{
				one=args[0];
				two=args[1];
				if(one.equals("-a"))
					try {
						//System.out.println("morrdate");
						extendedFun.moredata(two,null);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				else if(one.equals("-l")||one.equals("-c")||one.equals("-w"))
					basecount.count(one, two);
				else System.out.println("�޸ò���");
							
			}
			else if(len==3)
			{
				one=args[0];two=args[1];three=args[2];
				if(three.endsWith(".c")){
					if((one.equals("-l")||one.equals("-c")||one.equals("-w")&&(two.equals("-l")||two.equals("-c")||two.equals("-w"))))//�������ܴ����ļ�
					      basecount.count(one, two, three);
					else if(one.equals("-s")&&(two.equals("-l")||two.equals("-c")||two.equals("-w")||two.equals("-a")))//�ݹ鴦���ļ�����ͳ�Ƶ��ʡ��ַ����У�����������С�ע���кͿ���)
						     {  
						     String[] list={two,three};
						      extendedFun.allfile(list);
						     }
					else System.out.println("�����ʽ����");
			          }
               else if(three.endsWith(".txt")&&two.equals("-e")){//ͣ�ôʱ�,������
            	   	extendedFun.stopcount(one, three,null);
				}
				else System.out.println("�����ʽ����");
		}
			else if(len==4){
				one=args[0];two=args[1];three=args[2];four=args[3];
				if(four.endsWith(".c")){
						if((one.equals("-l")||one.endsWith("-c")||one.equals("-w"))&&(two.equals("-l")||two.equals("-c")||two.equals("-w"))
								&&(three.equals("-l")||three.equals("-c")||three.equals("-w")))//�������ܴ����ļ�
								basecount.count(one, two, three,four);
						else if(one.equals("-s")&&(two.equals("-l")||two.equals("-c")||two.equals("-w"))
									&&(three.equals("-l")||three.equals("-c")||three.equals("-w")))//�ݹ鴦���ļ�����ͳ�Ƶ��ʡ��ַ�����)
							{
									String[] list={two,three,four};
									extendedFun.allfile(list);
								}
							else System.out.println("�����ʽ����");
							}
					else if(two.endsWith(".c")&&three.equals("-o"))
					           basecount.count(one, two,three,four);
					else System.out.println("�밴����ȷ��ʽ����");
				
			}
			else if(len==9){
				one=args[0];two=args[1];three=args[2];four=args[3];five=args[4];six=args[5];seven=args[6];eight=args[7];night=args[8];
				if(one.equals("-s")&&two.equals("-a")&&(three.equals("-l")||three.equals("-c")||three.equals("-w"))
						&&(four.equals("-l")||four.equals("-c")||four.equals("-w"))&&six.equals("-e")&&eight.equals("-o"))
					{
							String[] list={two,three,four,five,six,seven,eight,night};
							extendedFun.allfile(list);
					}
				else System.out.println("�밴�ո�ʽ����");
			}
			else System.out.println("�밴�ո�ʽ����");
			
	}

	}
}
