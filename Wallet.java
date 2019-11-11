import java.util.Scanner;
class Wallet{
	public static void main(String args[])
	{
		int wallet[];
		wallet=new int[10];
		for(int i=0;i<10;i++)
		{
			wallet[i]=0;
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your Id");
		int id=scan.nextInt();
		int flag=0;
		while(flag==0) {
		if(wallet[id-1]<=300)
		{
			System.out.println("There is not sufficient amount in the wallet to book a cab");
			System.out.println("Amount of money is: "+wallet[id-1]);
			System.out.println("Add money to your wallet");
			System.out.println("To leave the site type -1");
			int money=scan.nextInt();
			if(money==-1)
			{
				flag=-1;
			}
			else {
			wallet[id-1]+=money;
			}
		}
		else{
			flag=1;
		}
		}
		if(flag==1)
		System.out.println("Cab can be booked");
		else
		{
			System.out.println("Services no longer available");
		}
	}
}