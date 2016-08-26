package emicalc;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EmiCalculator_13742 
{

	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Calculate c=new Calculate();
		System.out.println("Enter The Principal Amount");
		double principal_amt=sc.nextDouble();
		System.out.println("Enter The Interest Rate");
		double interest_rate=sc.nextDouble();
		System.out.println("Enter The Number Of Payements You Want To Pay In An Year");
		int no_of_payments=sc.nextInt();
		System.out.println("Enter The Number Of Installments");
		int tenure=sc.nextInt();
		System.out.println("Enter The Residual Value");
		double Residual_Val=sc.nextDouble();
		System.out.println(c.calc_install_amt(principal_amt, interest_rate, no_of_payments, tenure, Residual_Val));
		System.out.println("The Total Repayment Schedule is as Follows:");
		c.repayment_schedule(1000,10,4,9,13);
		c.repayment_schedule_1(1000,10,4,9,0,7);
	}

}
class Calculate
{
	double arr[],Install_Amt;
	Scanner sc=new Scanner(System.in);
	public double calc_install_amt(double principal_amt,double interest_rate, int no_of_payments,int tenure,double Residual_Val)
	{
		double Install_Amt,P,i,RV;
		int t,n;
		P=principal_amt;
		i=interest_rate;
		t=no_of_payments;
		n=tenure;
		RV=Residual_Val;
		double Cal1,Val1,Val2;
		
		Cal1=(i/100)/(double)t;
		Val1=(P*Cal1)-((RV*Cal1)/Math.pow((1+Cal1),(double)n));
		Val2=(1-(1/Math.pow((1+Cal1),(double)n)));
		Install_Amt=Val1/Val2;

		return Install_Amt;
	}
	public void repayment_schedule(double principal_amt,double interest_rate, int no_of_payments,int tenure,double Residual_Val)
	{
		double P,i,RV;
		int t,n;
		P=principal_amt;
		i=interest_rate;
		
		t=no_of_payments;
		n=tenure;
		RV=Residual_Val;
		arr=new double[n];
		DecimalFormat df = new DecimalFormat("###.##");
		Install_Amt =calc_install_amt(P,i,t,n,RV);
		//Install_Amt=Math.round(Install_Amt*100.0)/100.0;
		i=i/100;
		double In,OPn,Pn,OPnn;
		OPn=P;
		for(int j=0;j<n;j++)
		{
		    In = OPn*(i)*(1/(double)t);
		   // In=Math.round(In*100.0)/100.0;
		    Pn = Install_Amt-In;
		    //Pn=Math.round(Pn*100.0)/100.0;
		    OPnn = OPn-Pn;
		   // OPnn=Math.round(OPnn*100.0)/100.0;
		    arr[j]=OPn;
			System.out.print((j+1)+"\t");
			System.out.print(df.format(OPn)+"\t");
			System.out.print(df.format(Pn)+"\t");
			System.out.print(df.format(In)+"\t");
			System.out.print(df.format(Install_Amt)+"\t");
			System.out.print(df.format(Math.abs(OPnn))+"\t");
			//System.out.print(OPnn+"\t");
			System.out.println();
			OPn=OPn-Pn;
			
		}
	}
		public void repayment_schedule_1(double principal_amt,double interest_rate, int no_of_payments,int tenure,double Residual_Val,int num)
		{
			double i;
			int t;
			
			i=interest_rate;
			i=i/100;
			
			t=no_of_payments;

			DecimalFormat df = new DecimalFormat("###.##");
		//	Install_Amt =calc_install_amt(P,i,t,n,RV);
			double In=0,OPn,Pn,OPnn;
			
			OPn=arr[num-1];
			In = OPn*(i)*(1/(double)t);
			Pn = Install_Amt-In;
			OPnn = OPn-Pn;
			System.out.print((num)+"\t");
			System.out.print(df.format(OPn)+"\t");
			System.out.print(df.format(Pn)+"\t");
			System.out.print(df.format(In)+"\t");
			System.out.print(df.format(Install_Amt)+"\t");
			System.out.print(df.format(Math.abs(OPnn))+"\t");
			
			
			
		}
		
	
}
