//Allocate drivers according to the highest rating
import java.util.Scanner;
class Allocating_Drivers {
	String Assign[]={"BPHC","Secunderabad_Railway_Station","Thumkunta","Airport","Parade_Ground","BPHC","Secunderabad_Railway_Station","Thumkunta","Airport","Parade_Ground"};
	int rating[]= {5,3,2,6,1,9,4,6,9,7};
	int searchDriver(String s,String[] Assign)
	{
		int temp[]=new int[10];
		int k=0;
		for(int i=0;i<10;i++)
		{
			if(Assign[i]==s)
			{
				temp[k]=i;
				k++;
			}
		}
		if(k>0)
		{
			int min=rating[temp[0]];
			int min2=temp[0];
			for(int i=1;i<k;i++)
			{
				if(min>rating[temp[i]])
				{
					min=rating[temp[i]];
					min2=temp[i];
				}
			}
			return min2;
		}
		else
		{
			return -1;
		}
	}
	public static void main(String args[]) {
		Scanner scn=new Scanner(System.in);
		String point[]={"BPHC","Secunderabad_Railway_Station","Thumkunta","Airport","Parade_Ground"};  
		String driver[]={"d1","d2","d3","d4","d5","d6","d7","d8","d9","d10"};
		int busy[];
		busy=new int[10];
		for(int i=0;i<10;i++)
		{
			busy[i]=0;
		}
		String s2=scn.nextLine();
	int flag=0,temp=-2;
	for(int i=0;i<5;i++) {
		String temp3=point[i];
		if(s2==temp3) {
			temp=searchDriver(s2);
			flag=1;
			break;
		}
	}
		if(flag==1)
		{
			if(temp==-1) {
			System.out.println("No driver available");
			}
			else
			{
				System.out.println("Driver "+driver[temp]+"is available");
			}
		}
		else
			System.out.println("Invalid location");
	}
}
