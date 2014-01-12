import java.util.*;

public class Card {
	Random gen=new Random();

	private int userCard=0, oppoCard=0, userSuit=0, oppoSuit=0;

	private int userRecord[][]=new int[20][20];
	private int oppoRecord[][]=new int[20][20];

	private String suitList[]={"","Diamond","Club","Heart","Spade","Joker"};
	private String cardList[]={"","3","4","5","6","7","8","9","10","J","Q","K","A","2","14","15"};
	//For Suit: 1=Diamond   2=Club   3=Heart   4=Spade   5=(Joker)
	//For Card: 1=3   2=4   3=5   4=6   5=7   6=8   7=9   8=10   9=J   10=Q   11=K   12=A   13=2   14=Black Joker   15=Red Joker

	static public String userPic[]=new String[20];
	static public String oppoPic[]=new String[20];
	static public String user[]=new String[25];
	static public String oppo[]=new String[25];
	static public int userCard1[]=new int[25];
	static public int oppoCard1[]=new int[25];
	static public boolean oppoBeat=false;
	static public boolean userBeat=false;
	static public boolean userValid=false;
	static public boolean xxxyy=false;
	static public int userTotal=0;
	static public int total=0;
	static public int num1=0;
	static public int num2=0;
	static public int num3=0;
	static public int num4=0;
	static public boolean xxB10=false;



	public Card() {
		for(int place=1;place<=18;place++) {
			RandomGenUser();
			CheckRepeatUser(userSuit,userCard);
			RandomGenOppo();
			CheckRepeatOppo(oppoSuit,oppoCard);
		}

		int c=1;
		for(int a=1;a<=15;a++) {
			for(int b=1;b<=5;b++) {
				if(userRecord[b][a]==1) {
					if(b==5&&a==14)
						user[c]="Black Joker";
					else if(b==5&&a==15)
						user[c]="Red Joker";
					else
						user[c]=suitList[b]+" "+cardList[a];
					NameUserPic(c,b,a);
					userCard1[c]=a;
					c++;
				}
			}
		}
		c=1;
				for(int a=1;a<=15;a++) {
					for(int b=1;b<=5;b++) {
						if(oppoRecord[b][a]==1) {
							if(b==5&&a==14)
								oppo[c]="Black Joker";
							else if(b==5&&a==15)
								oppo[c]="Red Joker";
							else
								oppo[c]=suitList[b]+" "+cardList[a];
							NameOppoPic(c,b,a);
							oppoCard1[c]=a;
							c++;
						}
					}
		}

	}

	public void NameUserPic(int position,int suit,int card) {
			userPic[position]=suitList[suit]+cardList[card]+".PNG";
		}

	public void NameOppoPic(int position,int suit,int card) {
			oppoPic[position]=suitList[suit]+cardList[card]+".PNG";
		}

	public void RandomGenUser() {
		userCard=gen.nextInt(15)+1;
		if(userCard==14||userCard==15)
			userSuit=5;
		else
			userSuit=gen.nextInt(4)+1;
	}

	public void RandomGenOppo() {
		oppoCard=gen.nextInt(15)+1;
		if(oppoCard==14||oppoCard==15)
			oppoSuit=5;
		else
			oppoSuit=gen.nextInt(4)+1;
	}

	public void CheckRepeatUser(int suit,int card) {
		if(userRecord[suit][card]==1||oppoRecord[suit][card]==1) {
			RandomGenUser();
			CheckRepeatUser(userSuit,userCard);
		}else{
			userRecord[suit][card]=1;
		}
	}

	public void CheckRepeatOppo(int suit,int card) {
		if(userRecord[suit][card]==1||oppoRecord[suit][card]==1) {
			RandomGenOppo();
			CheckRepeatOppo(oppoSuit,oppoCard);
		}else{
			oppoRecord[suit][card]=1;
		}
	}

	public void CheckMax4() {
		int count=0;
		for(int d=1;d<=13;d++) {
			for(int e=1;e<=5;e++) {
				if(userRecord[e][d]==1)
					count++;
				if(oppoRecord[e][d]==1)
					count++;
			}
		}
		if(count==5) {
			RandomGenUser();
			CheckRepeatUser(userSuit,userCard);
			CheckMax4();
		}
	}

	static public void UserCompare(int k,int count) {
		userBeat=false;

		if(count!=k&&Winner.done==false&&count!=4) {
			userBeat=false;
		}else if(count==k||count==4) {
		if(k==1) {
			for(int l=1;l<=18;l++) {
				if(Winner.oppoSubmitList[l]==2) {
					for(int m=1;m<=18;m++) {
						if(Winner.submitList[m]==1&&userCard1[m]>oppoCard1[l]) {
							userBeat=true;
							break;
						}
					}
				}
			}
		}
		if(k==2||k==3||k==4) {
			for(int f=1;f<=18;f++) {
				if(Winner.oppoSubmitList[f]==2) {
					for(int g=1;g<=18;g++) {
						if(Winner.submitList[g]==1) {
							if(userCard1[g]>oppoCard1[f]) {
								userBeat=true;
								break;
							}
						}
					}
				}
			}
		}
		if(k==5&&xxxyy==true) {
			int y=1,x=1;
			int oppoSubmit[]=new int[25];
			int userSubmit[]=new int[25];
			for(int a=1;a<=18;a++) {
				if(Winner.oppoSubmitList[a]==2) {
					oppoSubmit[y]=oppoCard1[a];
					y++;
				}
			}
			for(int b=1;b<=18;b++) {
				if(Winner.submitList[b]==1) {
					userSubmit[x]=userCard1[b];
					x++;
				}
			}
			count=0;
			for(int h=1;h<=y-1;h++) {
				if(oppoSubmit[h]==oppoSubmit[h+1]&&oppoSubmit[h]==oppoSubmit[h+2]) {
					int recordOppo=oppoSubmit[h];
					for(int i=1;i<=x-1;i++) {
						if(userSubmit[i]==userSubmit[i+1]&&userSubmit[i]==userSubmit[i+2]) {
							int recordUser=userSubmit[i];
							if(recordUser>recordOppo) {
								userBeat=true;
								break;
							}
						}
					}
				}
			}
		}
		if(k==5&&xxxyy==false||k>5) {
			for(int o=1;o<=18;o++) {
				if(Winner.oppoSubmitList[o]==2) {
					for(int p=18;p>=1;p--) {
						if(Winner.submitList[p]==1) {
							if(userCard1[p]>oppoCard1[o]) {
								userBeat=true;
								break;
							}
						}
					}
				}
			}
		}
		if(k!=4&&count==4) {
			userBeat=true;
		}
	}else if(Winner.done==true) {
		userBeat=true;
	}
	if(userBeat==false) {
		for(int n=1;n<=18;n++) {
			if(Winner.submitList[n]==1) {
				Winner.submitList[n]=0;
			}
		}
	}
	}//end of method

	static public void OppoCompare(int k) {
		oppoBeat=false;
		int y=1,x=1;
		int count=1,count1=1,count2=1,count3=1,count4=1,count5=1;
		int oppoUnsubmit[]=new int[25];
		int userSubmit[]=new int[25];

		for(int a=1;a<=18;a++) {
			if(Winner.oppoSubmitList[a]==0) {
				oppoUnsubmit[y]=oppoCard1[a];
				y++;
			}
		}
		for(int b=1;b<=18;b++) {
			if(Winner.submitList[b]==2) {
				userSubmit[x]=userCard1[b];
				x++;
			}
		}
		CheckNumOfUserTotal();
		CheckNumOfTotal();

		if(k==1) {
			count1=1;
			boolean exist17=false,exist18=false;
			if(oppoUnsubmit[y-2]==14)
				exist17=true;
			if(exist17==false&&oppoUnsubmit[y-1]==14||oppoUnsubmit[y-1]==15)
				exist18=true;

			System.out.println(userTotal+" "+total+" "+exist17+" "+exist18);
			for(int c=1;c<=y-1;c++) {
				for(int d=1;d<=x-1;d++) {
					if(userTotal>=total-2&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]!=oppoUnsubmit[c+1]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]||userTotal<total-2&&userTotal>=total-4&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]) {
						for(int e=1;e<=18;e++) {
							if(oppoCard1[e]==oppoUnsubmit[c]&&count1<=1) {
								Winner.oppoSubmitList[e]=1;
								count1++;
							}
							if(count1==2) {
								oppoBeat=true;
								System.out.println("Case 1");
								break;
							}
						}
					}else if(userTotal<total-4&&oppoUnsubmit[c]>userSubmit[d]&&exist17==true) {
						Winner.oppoSubmitList[17]=1;
						exist17=false;
						oppoBeat=true;
						System.out.println("Case 2");
						break;
					}else if(userTotal<total-4&&oppoUnsubmit[c]>userSubmit[d]&&exist18==true) {
						Winner.oppoSubmitList[18]=1;
						exist18=false;
						oppoBeat=true;
						System.out.println("Case 3");
						break;
					}else if(userTotal<total-4&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]&&exist17==false&&exist18==false) {
						count1=1;
						for(int f=y-1;f>=1;f--) {
							if(oppoUnsubmit[f]!=oppoUnsubmit[f-1]&&oppoUnsubmit[f]!=oppoUnsubmit[f+1]) {
								int record=oppoUnsubmit[f];
								for(int g=18;g>=1;g--) {
									if(record==oppoCard1[g]) {
										Winner.oppoSubmitList[g]=1;
										count1++;
									}
									if(count1==2) {
										oppoBeat=true;
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		if(k==2||k==3||k==4) {
			count2=1;
			count3=1;
			count4=1;
			for(int c=1;c<=y-1;c++) {
				for(int d=1;d<=x-1;d++) {
					if(k==2&&userTotal>=total-2&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]!=oppoUnsubmit[c+2]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]&&oppoUnsubmit[c]!=14||k==2&&userTotal<total-2&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]) {
						for(int e=1;e<=18;e++) {
							if(oppoCard1[e]==oppoUnsubmit[c]&&count2<=2) {
								Winner.oppoSubmitList[e]=1;
								count2++;
							}
							if(count2==3) {
								oppoBeat=true;
								break;
							}
						}
					}else if(k==3&&userTotal>=total-2&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]==oppoUnsubmit[c+2]&&oppoUnsubmit[c]!=oppoUnsubmit[c+3]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]||k==3&&userTotal<total-2&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]==oppoUnsubmit[c+2]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]) {
						for(int e=1;e<=18;e++) {
							if(oppoCard1[e]==oppoUnsubmit[c]&&count3<=3) {
								Winner.oppoSubmitList[e]=1;
								count3++;
							}
							if(count3==4) {
								oppoBeat=true;
								break;
							}
						}
					}else if(k==4&&oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]==oppoUnsubmit[c+2]&&oppoUnsubmit[c]==oppoUnsubmit[c+3]) {
						for(int e=1;e<=18;e++) {
							if(oppoCard1[e]==oppoUnsubmit[c]&&count4<=4) {
								Winner.oppoSubmitList[e]=1;
								count4++;
							}
							if(count4==5) {
								oppoBeat=true;
								break;
							}
						}
					}
				}
			}
		}
		if(k==5&&xxxyy==true) {
			int record3=0;
			count2=1;
			count3=1;
			for(int p=1;p<=x-1;p++) {
				if(userSubmit[p]==userSubmit[p+1]&&userSubmit[p]==userSubmit[p+2]) {
					record3=userSubmit[p];
					break;
				}
			}
			for(int c=1;c<=y;c++) {
				for(int d=1;d<=x;d++) {
					if(userTotal>=total-2&&oppoUnsubmit[c]>record3&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]==oppoUnsubmit[c+2]&&oppoUnsubmit[c]!=oppoUnsubmit[c+3]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]||userTotal<total-2&&oppoUnsubmit[c]>record3&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]==oppoUnsubmit[c+2]&&oppoUnsubmit[c]!=oppoUnsubmit[c+3]&&oppoUnsubmit[c]!=oppoUnsubmit[c-1]) {
						for(int e=1;e<=18;e++) {
							if(oppoCard1[e]==oppoUnsubmit[c]&&count3<=3) {
								Winner.oppoSubmitList[e]=1;
								count3++;
							}
							if(count3==4) {
								for(int f=1;f<=y;f++) {
									if(userTotal>=total-2&&oppoUnsubmit[f]==oppoUnsubmit[f+1]&&oppoUnsubmit[f]!=oppoUnsubmit[f+2]&&oppoUnsubmit[f]!=oppoUnsubmit[f-1]&&oppoUnsubmit[f]!=14||userTotal<total-2&&oppoUnsubmit[f]==oppoUnsubmit[f+1]&&oppoUnsubmit[f]!=oppoUnsubmit[f+2]&&oppoUnsubmit[f]!=oppoUnsubmit[f-1]) {
										for(int h=1;h<=18;h++) {
											if(oppoCard1[h]==oppoUnsubmit[f]&&count2<=2) {
												Winner.oppoSubmitList[h]=1;
												count2++;
											}
											if(count2==3) {
												oppoBeat=true;
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(k==5&&xxxyy==false||k>5) {
			count5=1;
			count=1;
			for(int c=1;c<=y-1;c++) {
				if(oppoUnsubmit[c]>userSubmit[1]&&oppoUnsubmit[c]==oppoUnsubmit[c+1]-1) {
					System.out.println("c:"+(oppoUnsubmit[c]+2)+" c+1:"+(oppoUnsubmit[c+1]+2));
					for(int e=1;e<=18;e++) {
						if(oppoCard1[e]==oppoUnsubmit[c]&&count5<=k&&count==1) {
							Winner.oppoSubmitList[e]=1;
							System.out.println("oppoSubmitList["+e+"]=1 "+(oppoUnsubmit[c]+2));
							count++;
							count5++;
						}
						if(count5==k+1) {
							oppoBeat=true;
							break;
						}
					}
					count=1;
				}else if(count5!=k+1&&oppoUnsubmit[c]!=oppoUnsubmit[c+1]-1&&oppoUnsubmit[c]!=oppoUnsubmit[c+1]){
					count5=1;
					for(int f=1;f<=18;f++) {
						if(Winner.oppoSubmitList[f]==1) {
							Winner.oppoSubmitList[f]=0;
							System.out.println("CLEAR: +oppoSubmitList["+f+"]=0");
						}
					}
				}
			}
		}
		if(k!=1&&k!=2&&userTotal>=total-5&&oppoBeat==false||userTotal<total-5&&oppoBeat==false) {
			for(int c=1;c<=y-1;c++) {
				for(int d=1;d<=x-1;d++) {
					if(oppoUnsubmit[c]>userSubmit[d]&&oppoUnsubmit[c]==oppoUnsubmit[c+1]&&oppoUnsubmit[c]==oppoUnsubmit[c+2]&&oppoUnsubmit[c]==oppoUnsubmit[c+3]) {
						for(int e=1;e<=18;e++) {
							if(oppoCard1[e]==oppoUnsubmit[c]&&count4<=4) {
								Winner.oppoSubmitList[e]=1;
								count4++;
							}
							if(count4==5) {
								oppoBeat=true;
								break;
							}
						}
					}
				}
			}
		}
		if(oppoBeat==false) {
			for(int c=1;c<=18;c++) {
				if(Winner.oppoSubmitList[c]==1) {
					Winner.oppoSubmitList[c]=0;
				}
			}
		}
	}//end of method

	static public void CheckFormat()
	{
		userValid=false;
		int k=0; int a1=0; int a2=0; int a3=0; int a4=0; int a5=0;
		for (int h=1; h<=18; h++)
		{
			if(Winner.submitList[h]==1)
			k=k+1;
		}
		if (k==1)
		{
			userValid=true;
		}
		if (k==2)
		{
			for (int i=1; i<=18; i++)
			{
				if(Winner.submitList[i]==1)
				{
					a1=i;
					break;
				}
			}
			for (int j=a1+1; j<=18; j++)
			{
				if(Winner.submitList[j]==1)
				{
					a2=j;
					break;
				}
			}
			if (userCard1[a1]==userCard1[a2]||userCard1[a1]==14&&userCard1[a2]==15||userCard1[a1]==15&&userCard1[a2]==14)
			userValid=true;
			else
			userValid=false;
		}

		if (k==3)
		{
			for (int i=1; i<=18; i++)
			{
				if(Winner.submitList[i]==1)
				{
					a1=i;
					break;
				}
			}
			for (int j=a1+1; j<=18; j++)
			{
				if(Winner.submitList[j]==1)
				{
					a2=j;
					break;
				}
			}
			for (int l=a2+1; l<=18; l++)
			{
				if(Winner.submitList[l]==1)
				{
					a3=l;
					break;
				}
			}
			if (userCard1[a1]==userCard1[a2]&&userCard1[a3]==userCard1[a2])
			userValid=true;
			else
			userValid=false;
		}

		if (k==4)
		{
			for (int i=1; i<=18; i++)
			{
				if(Winner.submitList[i]==1)
				{
					a1=i;
					break;
				}
			}
			for (int j=a1+1; j<=18; j++)
			{
				if(Winner.submitList[j]==1)
				{
					a2=j;
					break;
				}
			}
			for (int l=a2+1; l<=18; l++)
			{
				if(Winner.submitList[l]==1)
				{
					a3=l;
					break;
				}
			}
			for (int y=a3+1; y<=18; y++)
			{
				if(Winner.submitList[y]==1)
				{
					a4=y;
					break;
				}
			}
			if (userCard1[a1]==userCard1[a2]&&userCard1[a3]==userCard1[a2]&&userCard1[a3]==userCard1[a4])
			userValid=true;
			else
			userValid=false;
		}

		if (k==5)
		{
			for (int i=1; i<=18; i++)
			{
				if(Winner.submitList[i]==1)
				{
					a1=i;
					break;
				}
			}
			for (int j=a1+1; j<=18; j++)
			{
				if(Winner.submitList[j]==1)
				{
					a2=j;
					break;
				}
			}
			for (int l=a2+1; l<=18; l++)
			{
				if(Winner.submitList[l]==1)
				{
					a3=l;
					break;
				}
			}
			for (int y=a3+1; y<=18; y++)
			{
				if(Winner.submitList[y]==1)
				{
					a4=y;
					break;
				}
			}
			for (int x=a4+1; x<=18; x++)
			{
				if(Winner.submitList[x]==1)
				{
					a5=x;
					break;
				}
			}
			if (userCard1[a1]==userCard1[a2]&&userCard1[a2]==userCard1[a3]&&userCard1[a4]==userCard1[a5]) {
				userValid=true;
				xxxyy=true;
			}else if (userCard1[a3]==userCard1[a4]&&userCard1[a4]==userCard1[a5]&&userCard1[a1]==userCard1[a2]) {
				userValid=true;
				xxxyy=true;
			}else if (userCard1[a5]==userCard1[a4]+1&&userCard1[a4]==userCard1[a3]+1&&userCard1[a3]==userCard1[a2]+1&&userCard1[a2]==userCard1[a1]+1) {
				userValid=true;
				xxxyy=false;
			}else
				userValid=false;
		}
		if (k>5)
		{
			int whichCard[]=new int[20];
			int j=1;
			for(int i=1; i<=18; i++)
			{
				if(Winner.submitList[i]==1)
				{
					whichCard[j]=i;
					j=j+1;

				}
			}
			int y=0;
			for (int a=k; a>1; a--)
			{
			if (userCard1[whichCard[a]]==userCard1[whichCard[a-1]]+1)
			y=y+1;
			}
			if (y==k-1)
			userValid=true;

		}
	}

	static public void CheckNumOfUserTotal()
	{
		userTotal=0;
		for (int a=1; a<=18; a++)
		{
			if (Winner.submitList[a]==0)
			{
				userTotal++;
			}
		}

	}

	static public void CheckNumOfTotal()
	{
		total=0;
		for (int a=1; a<=18; a++)
		{
			if (Winner.oppoSubmitList[a]==0)
			{
				total++;
			}
		}

	}

	static public void CheckNumOfXX()
	{
		CheckNumOfTotal();
		num2=0;
		for (int b=1; b<total-1; b++)
		{
			if (Winner.oppoUnsubmitList[b]==Winner.oppoUnsubmitList[b+1]&&Winner.oppoUnsubmitList[b]!=Winner.oppoUnsubmitList[b+2]&&Winner.oppoUnsubmitList[b]!=Winner.oppoUnsubmitList[b-1])
			{
				num2++;
			}
		}
		if (Winner.oppoUnsubmitList[total-1]==Winner.oppoUnsubmitList[total]&&Winner.oppoUnsubmitList[total-2]!=Winner.oppoUnsubmitList[total-1])
		num2++;

		if (num2>10)
		xxB10=true;
		else
		xxB10=false;
	}

	static public void CheckNumOfXXX()
	{
		CheckNumOfTotal();
		num3=0;
		for (int c=1; c<total-1; c++)
		{
			if (Winner.oppoUnsubmitList[c]==Winner.oppoUnsubmitList[c+1]&&Winner.oppoUnsubmitList[c]==Winner.oppoUnsubmitList[c+2]&&Winner.oppoUnsubmitList[c]!=Winner.oppoUnsubmitList[c+3]&&Winner.oppoUnsubmitList[c]!=Winner.oppoUnsubmitList[c-1])
			{
				num3++;
			}
		}
	}

    static public void CheckNumOfXXXX()
	{
		CheckNumOfTotal();
		num4=0;
		for (int c=1; c<total-1; c++)
		{
			if (Winner.oppoUnsubmitList[c]==Winner.oppoUnsubmitList[c+1]&&Winner.oppoUnsubmitList[c]==Winner.oppoUnsubmitList[c+2]&&Winner.oppoUnsubmitList[c]==Winner.oppoUnsubmitList[c+3]&&Winner.oppoUnsubmitList[c]!=Winner.oppoUnsubmitList[c-1])
			{
				num4++;
			}
		}
	}
	static public void CheckNumOfX()
	{
		CheckNumOfTotal();
		num1=0;
		CheckNumOfXX();
		CheckNumOfXXX();
		num1=total-num2-num3-num4;

	}






}




