import java.util.Scanner;
/**
 * Name: Ryan Monaghan
 * ID: R00115129
 */
public class FinalVersion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bandMem;
		int days;
		int sessionNum=0;
		int paymentOption;
		
		String mainName;
		String email;
		String phoneNo;
		String startDate;
		String memberNames;
		String memberInstruments;
		String booking="";
		String paymentString= "";
		
		char choice;
		
		double rate=1;
		double musicianBill;
		double finalBill=0;
		double total= 0;
		double paymentLevy;
		
		final double RATEONE=260;
		final double RATETWO=240;
		final double RATETHREE=210;
		final double RATEFOUR=200;
		final double MUSCIAN_RATE=100;


		


		Scanner input = new Scanner(System.in);

		System.out.println("What is your name?");
			mainName= input.nextLine();
		
		System.out.println("What is your email address?");
			email= input.nextLine();
		
		System.out.println("What is your phone number?");
			phoneNo= input.nextLine();
		System.out.println("");

		System.out.println("What date are you looking to book the Studio (dd/mm/yyyy)?");
			startDate= input.next();
		System.out.println("");
		
		do{
			System.out.println("How many members are in your band? (8-Max)");
			while(!input.hasNextInt())
			{
				input.nextLine();
				System.out.println("Error, please use intergers between 1-8");
				System.out.println("How many members are in your band?");
				input.nextLine();
			}
			
			bandMem= input.nextInt();
			
		}while(bandMem<1 || bandMem>=9 );
			
		
			
				
		do{
			System.out.println("How many days are you looking to book the Studio?");
			while(!input.hasNextInt())
			{
				input.nextLine();
				System.out.println("Error, please use positive intergers.");
				System.out.println("How many days are you looking to book the Studio?");
				input.nextLine();
			}
			
			days= input.nextInt();
			input.nextLine();
		}while(days<=0);
		
		
		if (days==1)
		{
			rate=RATEONE;
		}
		else if (days>1 && days<=4)
		{
			rate=RATETWO*days;
		}
		else if (days>4 && days<=8)
		{
			rate=RATETHREE*days;
		}
		else if (days>=9)
		{
			rate=RATEFOUR*days;
		}

		for (int k=1;k<=bandMem; k++)
		{
			System.out.println("What is band member "+ k + " 's name?");
			memberNames= input.next();
			input.nextLine();
			System.out.println("What is "+memberNames + "'s instrument?");
			memberInstruments= input.next();
			input.nextLine();
			booking+=("\n"+ k + ":"+memberNames+" - "+ memberInstruments);
		} 	

		System.out.println("We can provide " +(8-bandMem ) + " session musicians, for a fee if needed.");
		System.out.println("Would you like to hire any musicians for your session? (Y or N)");
			choice= input.next().charAt(0);
		
		if(choice=='y' || choice=='Y')
		{
		
			do{
				System.out.println("How many session musicians would you like?");
				while(!input.hasNextInt())
				{
					input.nextLine();
					System.out.println("Error, please enter an interger.");
					System.out.println("How many session musicians are you looking to book?");
					input.nextLine();
				}
				
				sessionNum= input.nextInt();
				
				
				
			}while(sessionNum<=0);
			
			if (sessionNum+bandMem>8)
			{
				total=rate;
				System.out.println("Sorry, we can only accommodate a total of eight musicians in our studio at a time.");
					System.exit(0);
			}
			else if (sessionNum+bandMem<=8)
			{
				musicianBill = sessionNum*days*MUSCIAN_RATE;

				total=rate+musicianBill;
			}
		}
		
		else if (choice=='N' || choice=='n')
		{
			System.out.println("You have selected not to hire any musicians.");
				total=rate;
		}

		
		
		do{
			System.out.println("How would you like to pay?\n 1. Credit Card (5% levy).\n 2. Cash (5% Discount)\n 3. Cheque");
			while(!input.hasNextInt())
			{
				input.nextLine();
				System.out.println("Error, please use intergers between 1-3");
				System.out.println("How would you like to pay?\n 1. Credit Card (5% levy).\n 2. Cash (5% Discount)\n 3. Cheque");
				input.nextLine();
			}
			
			paymentOption= input.nextInt();
			input.nextLine();
		}while(paymentOption<1 || paymentOption>=4 );
	
		
		if(paymentOption==1)
		{
			paymentString= ("Credit Card");
			paymentLevy= total/100;
			paymentLevy= paymentLevy*5;
			
			finalBill= paymentLevy+total;	
		}

		else if(paymentOption==2)
		{
			paymentString= ("Cash");
			paymentLevy= total/100;
			paymentLevy= paymentLevy*5;

			finalBill= total-paymentLevy;
		}

		else if(paymentOption==3)
		{
			paymentString= ("Cheque");
			finalBill= total;	
		}
	
	
	System.out.println("Booking Application");
	System.out.println("-------------------");
	System.out.println("Requested by:"+mainName+"(Contact: "+email+" & "+phoneNo+")");
	System.out.println("");
	System.out.println("Date requested: "+startDate);
	System.out.println("");
	System.out.println("Band Members");
	System.out.println("-------------------------");
	System.out.println(booking);
	System.out.println("Includes "+sessionNum+" session musicians.");
	System.out.println("Payment will be " + "\u20AC"+ finalBill + " to be paid by "+ paymentString + ".");
		
	input.close();
}

}