import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.border.TitledBorder;

public class Winner extends JFrame{
	private JPanel userPanel,oppoPanel,blank1Panel,midPanel,processPanel,buttonPanel,blank2Panel,statusPanel;
	private JLabel blank1L,blank2L,blank3L,blank4L,blank5L,blank6L,blank7L,blank8L,blank9L,blank10L,blank11L,blank12L,blank13L,blank14L,blank15L,blank16L;
	private JLabel u1L,u2L,u3L,u4L,u5L,u6L,u7L,u8L,u9L,u10L,u11L,u12L,u13L,u14L,u15L,u16L,u17L,u18L;
	private JLabel o1L,o2L,o3L,o4L,o5L,o6L,o7L,o8L,o9L,o10L,o11L,o12L,o13L,o14L,o15L,o16L,o17L,o18L;
	private JLabel statusL,userCardSelectedL;
	private JLabel us1,us2,us3,us4,us5,us6,us7,us8,us9,us10,us11,us12,us13,us14,us15,us16,us17,us18;
	private JLabel op1,op2,op3,op4,op5,op6,op7,op8,op9,op10,op11,op12,op13,op14,op15,op16,op17,op18;
	private JButton u1B,u2B,u3B,u4B,u5B,u6B,u7B,u8B,u9B,u10B,u11B,u12B,u13B,u14B,u15B,u16B,u17B,u18B;
	private JButton o1B,o2B,o3B,o4B,o5B,o6B,o7B,o8B,o9B,o10B,o11B,o12B,o13B,o14B,o15B,o16B,o17B,o18B;
	private JButton submitB,cancelB,foldB,doneB;
	private User1ButtonHandler u1bHandler;
	private User2ButtonHandler u2bHandler;
	private User3ButtonHandler u3bHandler;
	private User4ButtonHandler u4bHandler;
	private User5ButtonHandler u5bHandler;
	private User6ButtonHandler u6bHandler;
	private User7ButtonHandler u7bHandler;
	private User8ButtonHandler u8bHandler;
	private User9ButtonHandler u9bHandler;
	private User10ButtonHandler u10bHandler;
	private User11ButtonHandler u11bHandler;
	private User12ButtonHandler u12bHandler;
	private User13ButtonHandler u13bHandler;
	private User14ButtonHandler u14bHandler;
	private User15ButtonHandler u15bHandler;
	private User16ButtonHandler u16bHandler;
	private User17ButtonHandler u17bHandler;
	private User18ButtonHandler u18bHandler;
	private SubmitButtonHandler sbHandler;
	private CancelButtonHandler cbHandler;
	private FoldButtonHandler fbHandler;
	private DoneButtonHandler dbHandler;

	static public int submitList[]=new int[20];
	static public int oppoSubmitList[]=new int[20];
	private int userSubmitCard=0,userSubmittedCard=0;
	private int oppoSubmitCard=0,oppoSubmittedCard=0;
	private Image source;
	private ImageIcon cardPic=new ImageIcon();
	private String userCardSelected="Card Selected: ";
	private boolean doneValid=false;
	private boolean foldValid=false;
	static public boolean done=true;
	//false for oppo wins this turn, true for user wins this turn
	private int k=0,count=0;
	private int userCount=0,oppoCount=0;
	private boolean userWin=false,oppoWin=false;
	static public int oppoUnsubmitList[]=new int[25];
	private boolean fold=false;

	private static final int WIDTH=1300;
	private static final int HEIGHT=500;

	public Winner() {
        setTitle("Winner");
		Container pane=getContentPane();
		pane.setLayout(new GridLayout(6,1));
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		userPanel=new JPanel(new GridLayout(1,1,1,1));
        oppoPanel=new JPanel(new GridLayout(1,1,1,1));
        midPanel=new JPanel(new GridLayout(1,3,0,0));
        processPanel=new JPanel(new GridLayout(1,1,0,0));
        statusPanel=new JPanel(new GridLayout(2,1,0,0));
        blank1Panel=new JPanel(new GridLayout(1,1,0,0));
        blank2Panel=new JPanel(new GridLayout(1,1,0,0));
        buttonPanel=new JPanel(new GridLayout(2,4,0,0));

        statusL=new JLabel("Game Start. Please select your cards in any valid format and press SUBMIT button.");
        userCardSelectedL=new JLabel();

        blank1L=new JLabel();
        blank2L=new JLabel();
        blank3L=new JLabel();
        blank4L=new JLabel();
        blank5L=new JLabel();
        blank6L=new JLabel();
        blank7L=new JLabel();
        blank8L=new JLabel();
        blank9L=new JLabel();
        blank10L=new JLabel();
        blank11L=new JLabel();
        blank12L=new JLabel();
        blank13L=new JLabel();
        blank14L=new JLabel();
        blank15L=new JLabel();
        blank16L=new JLabel();

        u1L=new JLabel();
        u2L=new JLabel();
        u3L=new JLabel();
        u4L=new JLabel();
        u5L=new JLabel();
        u6L=new JLabel();
        u7L=new JLabel();
        u8L=new JLabel();
        u9L=new JLabel();
        u10L=new JLabel();
        u11L=new JLabel();
        u12L=new JLabel();
        u13L=new JLabel();
        u14L=new JLabel();
        u15L=new JLabel();
        u16L=new JLabel();
        u17L=new JLabel();
        u18L=new JLabel();

        o1L=new JLabel();
        o2L=new JLabel();
        o3L=new JLabel();
        o4L=new JLabel();
        o5L=new JLabel();
        o6L=new JLabel();
        o7L=new JLabel();
        o8L=new JLabel();
        o9L=new JLabel();
        o10L=new JLabel();
        o11L=new JLabel();
        o12L=new JLabel();
        o13L=new JLabel();
        o14L=new JLabel();
        o15L=new JLabel();
        o16L=new JLabel();
        o17L=new JLabel();
        o18L=new JLabel();

        o1B=new JButton();
        o2B=new JButton();
        o3B=new JButton();
        o4B=new JButton();
        o5B=new JButton();
        o6B=new JButton();
        o7B=new JButton();
        o8B=new JButton();
        o9B=new JButton();
        o10B=new JButton();
        o11B=new JButton();
        o12B=new JButton();
        o13B=new JButton();
        o14B=new JButton();
        o15B=new JButton();
        o16B=new JButton();
        o17B=new JButton();
        o18B=new JButton();

        us1=new JLabel();
        us2=new JLabel();
        us3=new JLabel();
        us4=new JLabel();
        us5=new JLabel();
        us6=new JLabel();
        us7=new JLabel();
        us8=new JLabel();
        us9=new JLabel();
        us10=new JLabel();
        us11=new JLabel();
        us12=new JLabel();
        us13=new JLabel();
        us14=new JLabel();
        us15=new JLabel();
        us16=new JLabel();
        us17=new JLabel();
        us18=new JLabel();

        op1=new JLabel();
        op2=new JLabel();
        op3=new JLabel();
        op4=new JLabel();
        op5=new JLabel();
        op6=new JLabel();
        op7=new JLabel();
        op8=new JLabel();
        op9=new JLabel();
        op10=new JLabel();
        op11=new JLabel();
        op12=new JLabel();
        op13=new JLabel();
        op14=new JLabel();
        op15=new JLabel();
        op16=new JLabel();
        op17=new JLabel();
        op18=new JLabel();

        u1B=new JButton("");
		u1bHandler=new User1ButtonHandler();
		u1B.addActionListener(u1bHandler);

        u2B=new JButton("");
		u2bHandler=new User2ButtonHandler();
		u2B.addActionListener(u2bHandler);

        u3B=new JButton("");
		u3bHandler=new User3ButtonHandler();
		u3B.addActionListener(u3bHandler);

        u4B=new JButton("");
		u4bHandler=new User4ButtonHandler();
		u4B.addActionListener(u4bHandler);

        u5B=new JButton("");
		u5bHandler=new User5ButtonHandler();
		u5B.addActionListener(u5bHandler);

        u6B=new JButton("");
		u6bHandler=new User6ButtonHandler();
		u6B.addActionListener(u6bHandler);

        u7B=new JButton("");
		u7bHandler=new User7ButtonHandler();
		u7B.addActionListener(u7bHandler);

        u8B=new JButton("");
		u8bHandler=new User8ButtonHandler();
		u8B.addActionListener(u8bHandler);

        u9B=new JButton("");
		u9bHandler=new User9ButtonHandler();
		u9B.addActionListener(u9bHandler);

        u10B=new JButton("");
		u10bHandler=new User10ButtonHandler();
		u10B.addActionListener(u10bHandler);

        u11B=new JButton("");
		u11bHandler=new User11ButtonHandler();
		u11B.addActionListener(u11bHandler);

        u12B=new JButton("");
		u12bHandler=new User12ButtonHandler();
		u12B.addActionListener(u12bHandler);

        u13B=new JButton("");
		u13bHandler=new User13ButtonHandler();
		u13B.addActionListener(u13bHandler);

        u14B=new JButton("");
		u14bHandler=new User14ButtonHandler();
		u14B.addActionListener(u14bHandler);

        u15B=new JButton("");
		u15bHandler=new User15ButtonHandler();
		u15B.addActionListener(u15bHandler);

        u16B=new JButton("");
		u16bHandler=new User16ButtonHandler();
		u16B.addActionListener(u16bHandler);

        u17B=new JButton("");
		u17bHandler=new User17ButtonHandler();
		u17B.addActionListener(u17bHandler);

        u18B=new JButton("");
		u18bHandler=new User18ButtonHandler();
		u18B.addActionListener(u18bHandler);

		submitB=new JButton("SUBMIT");
		sbHandler=new SubmitButtonHandler();
		submitB.addActionListener(sbHandler);

		cancelB=new JButton("CANCEL");
		cbHandler=new CancelButtonHandler();
		cancelB.addActionListener(cbHandler);

		foldB=new JButton("FOLD");
		fbHandler=new FoldButtonHandler();
		foldB.addActionListener(fbHandler);

		doneB=new JButton("DONE");
		dbHandler=new DoneButtonHandler();
		doneB.addActionListener(dbHandler);

		pane.add(oppoPanel);
		pane.add(blank1Panel);
		pane.add(midPanel);
		pane.add(blank2Panel);
		pane.add(userPanel);
		pane.add(statusPanel);

		midPanel.add(blank5L);
		midPanel.add(processPanel);
		midPanel.add(buttonPanel);

		buttonPanel.add(blank8L);
		buttonPanel.add(submitB);
		buttonPanel.add(foldB);
		buttonPanel.add(blank9L);
		buttonPanel.add(blank10L);
		buttonPanel.add(cancelB);
		buttonPanel.add(doneB);

		userPanel.add(blank1L);
		userPanel.add(u1B);
		userPanel.add(u2B);
		userPanel.add(u3B);
		userPanel.add(u4B);
		userPanel.add(u5B);
		userPanel.add(u6B);
		userPanel.add(u7B);
		userPanel.add(u8B);
		userPanel.add(u9B);
		userPanel.add(u10B);
		userPanel.add(u11B);
		userPanel.add(u12B);
		userPanel.add(u13B);
		userPanel.add(u14B);
		userPanel.add(u15B);
		userPanel.add(u16B);
		userPanel.add(u17B);
		userPanel.add(u18B);
		userPanel.add(blank2L);

		oppoPanel.add(blank3L);
		oppoPanel.add(o1B);
		oppoPanel.add(o2B);
		oppoPanel.add(o3B);
		oppoPanel.add(o4B);
		oppoPanel.add(o5B);
		oppoPanel.add(o6B);
		oppoPanel.add(o7B);
		oppoPanel.add(o8B);
		oppoPanel.add(o9B);
		oppoPanel.add(o10B);
		oppoPanel.add(o11B);
		oppoPanel.add(o12B);
		oppoPanel.add(o13B);
		oppoPanel.add(o14B);
		oppoPanel.add(o15B);
		oppoPanel.add(o16B);
		oppoPanel.add(o17B);
		oppoPanel.add(o18B);
		oppoPanel.add(blank4L);

		statusPanel.add(statusL);
		statusPanel.add(userCardSelectedL);

		Card card=new Card();

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[1]));
		source=cardPic.getImage();
       	u1B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[2]));
		source=cardPic.getImage();
       	u2B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[3]));
		source=cardPic.getImage();
       	u3B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[4]));
		source=cardPic.getImage();
       	u4B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[5]));
		source=cardPic.getImage();
       	u5B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[6]));
		source=cardPic.getImage();
       	u6B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[7]));
		source=cardPic.getImage();
       	u7B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[8]));
		source=cardPic.getImage();
       	u8B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[9]));
		source=cardPic.getImage();
       	u9B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[10]));
		source=cardPic.getImage();
       	u10B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[11]));
		source=cardPic.getImage();
       	u11B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[12]));
		source=cardPic.getImage();
       	u12B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[13]));
		source=cardPic.getImage();
       	u13B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[14]));
		source=cardPic.getImage();
       	u14B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[15]));
		source=cardPic.getImage();
       	u15B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[16]));
		source=cardPic.getImage();
       	u16B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[17]));
		source=cardPic.getImage();
       	u17B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[18]));
		source=cardPic.getImage();
       	u18B.setIcon(new ImageIcon(source));

//////////////////////////////////////////////////////////////////////////////////////////////
		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o1B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o2B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o3B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o4B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o5B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o6B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o7B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o8B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o9B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o10B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o11B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o12B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o13B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o14B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o15B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o16B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o17B.setIcon(new ImageIcon(source));

		cardPic=new ImageIcon(Winner.class.getResource("bg.PNG"));
		source=cardPic.getImage();
       	o18B.setIcon(new ImageIcon(source));




	}

	private class User1ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[1]==0) {
				submitList[1]=1;
				userCardSelected=userCardSelected+Card.user[1]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User2ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[2]==0) {
				submitList[2]=1;
				userCardSelected=userCardSelected+Card.user[2]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User3ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[3]==0) {
				submitList[3]=1;
				userCardSelected=userCardSelected+Card.user[3]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User4ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[4]==0) {
				submitList[4]=1;
				userCardSelected=userCardSelected+Card.user[4]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User5ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[5]==0) {
				submitList[5]=1;
				userCardSelected=userCardSelected+Card.user[5]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User6ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[6]==0) {
				submitList[6]=1;
				userCardSelected=userCardSelected+Card.user[6]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User7ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[7]==0) {
				submitList[7]=1;
				userCardSelected=userCardSelected+Card.user[7]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User8ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[8]==0) {
				submitList[8]=1;
				userCardSelected=userCardSelected+Card.user[8]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User9ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[9]==0) {
				submitList[9]=1;
				userCardSelected=userCardSelected+Card.user[9]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
			}
	}

	private class User10ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[10]==0) {
				submitList[10]=1;
				userCardSelected=userCardSelected+Card.user[10]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User11ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[11]==0) {
				submitList[11]=1;
				userCardSelected=userCardSelected+Card.user[11]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User12ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[12]==0) {
				submitList[12]=1;
				userCardSelected=userCardSelected+Card.user[12]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User13ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[13]==0) {
				submitList[13]=1;
				userCardSelected=userCardSelected+Card.user[13]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User14ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[14]==0) {
				submitList[14]=1;
				userCardSelected=userCardSelected+Card.user[14]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User15ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[15]==0) {
				submitList[15]=1;
				userCardSelected=userCardSelected+Card.user[15]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User16ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[16]==0) {
				submitList[16]=1;
				userCardSelected=userCardSelected+Card.user[16]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User17ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[17]==0) {
				submitList[17]=1;
				userCardSelected=userCardSelected+Card.user[17]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}

	private class User18ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(submitList[18]==0) {
				submitList[18]=1;
				userCardSelected=userCardSelected+Card.user[18]+", ";
				userCardSelectedL.setText(userCardSelected);
			}
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private class SubmitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			for(int a=1;a<=18;a++) {
				if (submitList[a]==1) {
					userSubmitCard++;
				}
			}
			processPanel.setSize(new Dimension(1,userSubmitCard));

			k=0;
			count=0;
			for (int h=1; h<=18; h++) {
				if(Winner.oppoSubmitList[h]==2) {
					k++;
				}
				if(Winner.submitList[h]==1) {
					count++;
				}
			}
			Card.CheckFormat();
			Card.UserCompare(k,count);

			if(Card.userValid==true&&Card.userBeat==true) {
				processPanel.remove(op1);
				processPanel.remove(op2);
				processPanel.remove(op3);
				processPanel.remove(op4);
				processPanel.remove(op5);
				processPanel.remove(op6);
				processPanel.remove(op7);
				processPanel.remove(op8);
				processPanel.remove(op9);
				processPanel.remove(op10);
				processPanel.remove(op11);
				processPanel.remove(op12);
				processPanel.remove(op13);
				processPanel.remove(op14);
				processPanel.remove(op15);
				processPanel.remove(op16);
				processPanel.remove(op17);
				processPanel.remove(op18);
				statusL.setText("VALID CHOICE");
				if (submitList[1]==1) {
					userPanel.remove(u1B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[1]));
					source=cardPic.getImage();
       				us1.setIcon(new ImageIcon(source));
					processPanel.add(us1);
					submitList[1]=2;
				}

				if (submitList[2]==1) {
					userPanel.remove(u2B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[2]));
					source=cardPic.getImage();
       				us2.setIcon(new ImageIcon(source));
					processPanel.add(us2);
					submitList[2]=2;
				}

				if (submitList[3]==1) {
					userPanel.remove(u3B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[3]));
					source=cardPic.getImage();
       				us3.setIcon(new ImageIcon(source));
					processPanel.add(us3);
					submitList[3]=2;
				}

				if (submitList[4]==1) {
					userPanel.remove(u4B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[4]));
					source=cardPic.getImage();
       				us4.setIcon(new ImageIcon(source));
					processPanel.add(us4);
					submitList[4]=2;
				}

				if (submitList[5]==1) {
					userPanel.remove(u5B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[5]));
					source=cardPic.getImage();
       				us5.setIcon(new ImageIcon(source));
					processPanel.add(us5);
					submitList[5]=2;
				}

				if (submitList[6]==1) {
					userPanel.remove(u6B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[6]));
					source=cardPic.getImage();
       				us6.setIcon(new ImageIcon(source));
					processPanel.add(us6);
					submitList[6]=2;

				}

				if (submitList[7]==1) {
					userPanel.remove(u7B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[7]));
					source=cardPic.getImage();
       				us7.setIcon(new ImageIcon(source));
					processPanel.add(us7);
					submitList[7]=2;
				}

				if (submitList[8]==1) {
					userPanel.remove(u8B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[8]));
					source=cardPic.getImage();
       				us8.setIcon(new ImageIcon(source));
					processPanel.add(us8);
					submitList[8]=2;
				}

				if (submitList[9]==1) {
					userPanel.remove(u9B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[9]));
					source=cardPic.getImage();
       				us9.setIcon(new ImageIcon(source));
					processPanel.add(us9);
					submitList[9]=2;
				}

				if (submitList[10]==1) {
					userPanel.remove(u10B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[10]));
					source=cardPic.getImage();
       				us10.setIcon(new ImageIcon(source));
					processPanel.add(us10);
					submitList[10]=2;
				}

				if (submitList[11]==1) {
					userPanel.remove(u11B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[11]));
					source=cardPic.getImage();
       				us11.setIcon(new ImageIcon(source));
					processPanel.add(us11);
					submitList[11]=2;
				}

				if (submitList[12]==1) {
					userPanel.remove(u12B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[12]));
					source=cardPic.getImage();
       				us12.setIcon(new ImageIcon(source));
					processPanel.add(us12);
					submitList[12]=2;
				}

				if (submitList[13]==1) {
					userPanel.remove(u13B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[13]));
					source=cardPic.getImage();
       				us13.setIcon(new ImageIcon(source));
					processPanel.add(us13);
					submitList[13]=2;
				}

				if (submitList[14]==1) {
					userPanel.remove(u14B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[14]));
					source=cardPic.getImage();
       				us14.setIcon(new ImageIcon(source));
					processPanel.add(us14);
					submitList[14]=2;
				}

				if (submitList[15]==1) {
					userPanel.remove(u15B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[15]));
					source=cardPic.getImage();
       				us15.setIcon(new ImageIcon(source));
					processPanel.add(us15);
					submitList[15]=2;
				}

				if (submitList[16]==1) {
					userPanel.remove(u16B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[16]));
					source=cardPic.getImage();
       				us16.setIcon(new ImageIcon(source));
					processPanel.add(us16);
					submitList[16]=2;
				}

				if (submitList[17]==1) {
					userPanel.remove(u17B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[17]));
					source=cardPic.getImage();
       				us17.setIcon(new ImageIcon(source));
					processPanel.add(us17);
					submitList[17]=2;
				}

				if (submitList[18]==1) {
					userPanel.remove(u18B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.userPic[18]));
					source=cardPic.getImage();
       				us18.setIcon(new ImageIcon(source));
					processPanel.add(us18);
					submitList[18]=2;
			}

				userSubmittedCard=0;
				for(int b=1;b<=18;b++) {
					if (submitList[b]==2||submitList[b]==3) {
						userSubmittedCard++;
					}
				}
				userPanel.add(blank1L);
				if(userSubmittedCard>=1)
					userPanel.add(u1L);
				if(userSubmittedCard>=3)
					userPanel.add(u2L);
				if(userSubmittedCard>=5)
					userPanel.add(u3L);
				if(userSubmittedCard>=7)
					userPanel.add(u4L);
				if(userSubmittedCard>=9)
					userPanel.add(u5L);
				if(userSubmittedCard>=11)
					userPanel.add(u6L);
				if(userSubmittedCard>=13)
					userPanel.add(u7L);
				if(userSubmittedCard>=15)
					userPanel.add(u8L);
				if(userSubmittedCard>=17)
					userPanel.add(u9L);
				setSize(1299,499);
				setSize(1300,500);

				if(submitList[1]==0||submitList[1]==1)
					userPanel.add(u1B);
				if(submitList[2]==0||submitList[2]==1)
					userPanel.add(u2B);
				if(submitList[3]==0||submitList[3]==1)
					userPanel.add(u3B);
				if(submitList[4]==0||submitList[4]==1)
					userPanel.add(u4B);
				if(submitList[5]==0||submitList[5]==1)
					userPanel.add(u5B);
				if(submitList[6]==0||submitList[6]==1)
					userPanel.add(u6B);
				if(submitList[7]==0||submitList[7]==1)
					userPanel.add(u7B);
				if(submitList[8]==0||submitList[8]==1)
					userPanel.add(u8B);
				if(submitList[9]==0||submitList[9]==1)
					userPanel.add(u9B);
				if(submitList[10]==0||submitList[10]==1)
					userPanel.add(u10B);
				if(submitList[11]==0||submitList[11]==1)
					userPanel.add(u11B);
				if(submitList[12]==0||submitList[12]==1)
					userPanel.add(u12B);
				if(submitList[13]==0||submitList[13]==1)
					userPanel.add(u13B);
				if(submitList[14]==0||submitList[14]==1)
					userPanel.add(u14B);
				if(submitList[15]==0||submitList[15]==1)
					userPanel.add(u15B);
				if(submitList[16]==0||submitList[16]==1)
					userPanel.add(u16B);
				if(submitList[17]==0||submitList[17]==1)
					userPanel.add(u17B);
				if(submitList[18]==0||submitList[18]==1)
					userPanel.add(u18B);

				if(userSubmittedCard>=2)
					userPanel.add(u10L);
				if(userSubmittedCard>=4)
					userPanel.add(u11L);
				if(userSubmittedCard>=6)
					userPanel.add(u12L);
				if(userSubmittedCard>=8)
					userPanel.add(u13L);
				if(userSubmittedCard>=10)
					userPanel.add(u14L);
				if(userSubmittedCard>=12)
					userPanel.add(u15L);
				if(userSubmittedCard>=14)
					userPanel.add(u16L);
				if(userSubmittedCard>=16)
					userPanel.add(u17L);
				if(userSubmittedCard>=18)
					userPanel.add(u18L);
				userPanel.add(blank2L);

					userCount=0;
					oppoCount=0;
					for(int d=1;d<=18;d++) {
						if(submitList[d]==0) {
							userCount++;
						}
						if(oppoSubmitList[d]==0) {
							oppoCount++;
						}
					}
					if(userCount==0) {
						userWin=true;
						oppoWin=false;
					}
					else if(oppoCount==0) {
						userWin=false;
						oppoWin=true;
					}

				k=0;
				count=0;
				for (int h=1; h<=18; h++) {
					if(Winner.submitList[h]==2) {
						k++;
					}
				}
				Card.CheckFormat();
				Card.userValid=false;
				Card.OppoCompare(k);

				if(Card.oppoBeat==true&&userWin==false) {
					statusL.setText("Opponent's turn. Please press DONE.");

					for(int c=1;c<=18;c++) {
						if(oppoSubmitList[c]==2) {
							oppoSubmitList[c]=3;
						}
					}

					userCardSelected="Card selected: ";
					userCardSelectedL.setText(userCardSelected);
					doneValid=true;
					done=false;
				}else if(Card.oppoBeat==false&&userWin==false&&oppoWin==false){
					statusL.setText("You win this turn. You can select any card in valid format to start the next turn. Please press DONE to clear this turn.");
					doneValid=true;
					done=true;
				}else if(userWin==true) {
					statusL.setText("YOU WIN!");
					buttonPanel.remove(submitB);
					buttonPanel.remove(cancelB);
					buttonPanel.remove(foldB);
					buttonPanel.remove(doneB);
if(oppoSubmitList[1]!=3) {
			cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[1]));
			source=cardPic.getImage();
       		o1B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[2]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[2]));
		source=cardPic.getImage();
       	o2B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[3]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[3]));
		source=cardPic.getImage();
       	o3B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[4]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[4]));
		source=cardPic.getImage();
       	o4B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[5]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[5]));
		source=cardPic.getImage();
       	o5B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[6]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[6]));
		source=cardPic.getImage();
       	o6B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[7]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[7]));
		source=cardPic.getImage();
       	o7B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[8]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[8]));
		source=cardPic.getImage();
       	o8B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[9]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[9]));
		source=cardPic.getImage();
       	o9B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[10]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[10]));
		source=cardPic.getImage();
       	o10B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[11]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[11]));
		source=cardPic.getImage();
       	o11B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[12]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[12]));
		source=cardPic.getImage();
       	o12B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[13]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[13]));
		source=cardPic.getImage();
       	o13B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[14]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[14]));
		source=cardPic.getImage();
       	o14B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[15]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[15]));
		source=cardPic.getImage();
       	o15B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[16]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[16]));
		source=cardPic.getImage();
       	o16B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[17]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[17]));
		source=cardPic.getImage();
       	o17B.setIcon(new ImageIcon(source));
}
if(oppoSubmitList[18]!=3) {
		cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[18]));
		source=cardPic.getImage();
       	o18B.setIcon(new ImageIcon(source));
}
				}

			}else if(Card.userValid==false&&doneValid==false||Card.userBeat==false&&doneValid==false) {
				doneValid=false;
				statusL.setText("INVALID CHOICE. Please press CANCEL to re-select your cards.");
				for(int c=1;c<=18;c++) {
					if(submitList[c]==1) {
						submitList[c]=0;
					}
				}
			}else if(doneValid==true) {
				statusL.setText("Please press DONE.");
			}else if(doneValid==true&&Card.userBeat==false) {
				statusL.setText("INVALID CHOICE. Please press CANCEL to re-select your cards.");
			}
				setSize(1299,499);
				setSize(1300,500);
System.out.println("\n\n=======================\nSUBMIT: ");
for(int i=1;i<=18;i++) {System.out.println("UserSubmitList["+i+"]: "+submitList[i]);}
System.out.println();
for(int j=1;j<=18;j++) {System.out.println("OppoSubmitList["+j+"]: "+oppoSubmitList[j]);}
System.out.println();
System.out.println("userValid: "+Card.userValid+"\nuserBeat: "+Card.userBeat+"\noppoBeat: "+Card.oppoBeat+"\ndoneValid: "+doneValid+"\ndone: "+done);
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private class CancelButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			userCardSelected="Card selected: ";
			userCardSelectedL.setText(userCardSelected);
			statusL.setText("Please select your cards, and press SUBMIT.");
			userSubmittedCard=0;
			for(int b=1;b<=18;b++) {
				if (submitList[b]==2||submitList[b]==3) {
					userSubmittedCard++;
				}
				if(submitList[b]==1) {
					submitList[b]=0;
				}
			}
			userPanel.add(blank1L);
			if(userSubmittedCard>=1)
				userPanel.add(u1L);
			if(userSubmittedCard>=3)
				userPanel.add(u2L);
			if(userSubmittedCard>=5)
				userPanel.add(u3L);
			if(userSubmittedCard>=7)
				userPanel.add(u4L);
			if(userSubmittedCard>=9)
				userPanel.add(u5L);
			if(userSubmittedCard>=11)
				userPanel.add(u6L);
			if(userSubmittedCard>=13)
				userPanel.add(u7L);
			if(userSubmittedCard>=15)
				userPanel.add(u8L);
			if(userSubmittedCard>=17)
				userPanel.add(u9L);

			if(submitList[1]==0||submitList[1]==1)
				userPanel.add(u1B);
			if(submitList[2]==0||submitList[2]==1)
				userPanel.add(u2B);
			if(submitList[3]==0||submitList[3]==1)
				userPanel.add(u3B);
			if(submitList[4]==0||submitList[4]==1)
				userPanel.add(u4B);
			if(submitList[5]==0||submitList[5]==1)
				userPanel.add(u5B);
			if(submitList[6]==0||submitList[6]==1)
				userPanel.add(u6B);
			if(submitList[7]==0||submitList[7]==1)
				userPanel.add(u7B);
			if(submitList[8]==0||submitList[8]==1)
				userPanel.add(u8B);
			if(submitList[9]==0||submitList[9]==1)
				userPanel.add(u9B);
			if(submitList[10]==0||submitList[10]==1)
				userPanel.add(u10B);
			if(submitList[11]==0||submitList[11]==1)
				userPanel.add(u11B);
			if(submitList[12]==0||submitList[12]==1)
				userPanel.add(u12B);
			if(submitList[13]==0||submitList[13]==1)
				userPanel.add(u13B);
			if(submitList[14]==0||submitList[14]==1)
				userPanel.add(u14B);
			if(submitList[15]==0||submitList[15]==1)
				userPanel.add(u15B);
			if(submitList[16]==0||submitList[16]==1)
				userPanel.add(u16B);
			if(submitList[17]==0||submitList[17]==1)
				userPanel.add(u17B);
			if(submitList[18]==0||submitList[18]==1)
				userPanel.add(u18B);

			if(userSubmittedCard>=2)
				userPanel.add(u10L);
			if(userSubmittedCard>=4)
				userPanel.add(u11L);
			if(userSubmittedCard>=6)
				userPanel.add(u12L);
			if(userSubmittedCard>=8)
				userPanel.add(u13L);
			if(userSubmittedCard>=10)
				userPanel.add(u14L);
			if(userSubmittedCard>=12)
				userPanel.add(u15L);
			if(userSubmittedCard>=14)
				userPanel.add(u16L);
			if(userSubmittedCard>=16)
				userPanel.add(u17L);
			if(userSubmittedCard>=18)
				userPanel.add(u18L);
			userPanel.add(blank2L);

			userSubmittedCard=0;

			setSize(1299,499);
			setSize(1300,500);
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private class FoldButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			oppoWin=false;
			if(foldValid==true&&done==false)
			{
				foldValid=false;
				processPanel.remove(op1);
				processPanel.remove(op2);
				processPanel.remove(op3);
				processPanel.remove(op4);
				processPanel.remove(op5);
				processPanel.remove(op6);
				processPanel.remove(op7);
				processPanel.remove(op8);
				processPanel.remove(op9);
				processPanel.remove(op10);
				processPanel.remove(op11);
				processPanel.remove(op12);
				processPanel.remove(op13);
				processPanel.remove(op14);
				processPanel.remove(op15);
				processPanel.remove(op16);
				processPanel.remove(op17);
				processPanel.remove(op18);
				statusL.setText("You have given up this turn. The opponent will now start a new turn. Please press DONE.");

				int y=1;
				for(int w=1;w<=18;w++) {
					if(oppoSubmitList[w]==2) {
						oppoSubmitList[w]=3;
					}
					if(oppoSubmitList[w]==0) {
						oppoUnsubmitList[y]=Card.oppoCard1[w];
						System.out.println("oppoUnsubmitList"+y+": "+oppoUnsubmitList[y]);
						y++;
					}
				}

				Card.CheckNumOfTotal();
				Card.CheckNumOfX();
				Card.CheckNumOfXX();
				Card.CheckNumOfXXX();
				Card.CheckNumOfXXXX();
				int total=Card.total;
				int num1=Card.num1;
				int num2=Card.num2;
				int num3=Card.num3;
				int num4=Card.num4;
				System.out.println("total="+total+"\nnum1="+num1+"\nnum2="+num2+"\nnum3="+num3+"\nnum4="+num4);

				int checkContinuity=1;
				int compare=0;
				int oppoContinuousList[]=new int[25];
				count=0;
				int x=1;
				int count1=1,count2=1,count3=1;
				if(num1>(total/2)) {
					for(int a=1;a<=17;a++) {
						if(oppoSubmitList[a]==0&&count==0) {
							compare=Card.oppoCard1[a];
							count++;
						}else if(oppoSubmitList[a]==0&&count!=0) {
							if(compare==Card.oppoCard1[a]-1) {
								checkContinuity++;
								oppoContinuousList[x]=Card.oppoCard1[a];
								compare=Card.oppoCard1[a];
								x++;
							}else if(compare!=Card.oppoCard1[a]-1&&compare!=Card.oppoCard1[a]&&a>6) {
								break;
							}else if(compare!=Card.oppoCard1[a]-1&&compare!=Card.oppoCard1[a]&&a<=6) {
								x=1;
								checkContinuity=1;
							}
						}
					}

					if(checkContinuity<5) {
						if(num3!=0&&num2==0) {
							for(int b=1;b<=y;b++) {
								if(oppoUnsubmitList[b]==oppoUnsubmitList[b+1]&&oppoUnsubmitList[b]==oppoUnsubmitList[b+2]&&oppoUnsubmitList[b]!=oppoUnsubmitList[b-1]) {
									for(int c=1;c<=18;c++) {
										if(Card.oppoCard1[c]==oppoUnsubmitList[b]&&count3<=3) {
											oppoSubmitList[c]=1;
											count3++;
										}
										if(count3==4) {
											Card.oppoBeat=true;
											break;
										}
									}
								}
							}
						}else if(num3!=0&&num2!=0) {
							for(int b=1;b<=y;b++) {
								if(oppoUnsubmitList[b]==oppoUnsubmitList[b+1]&&oppoUnsubmitList[b]==oppoUnsubmitList[b+2]&&oppoUnsubmitList[b]!=oppoUnsubmitList[b-1]) {
									for(int c=1;c<=18;c++) {
										if(Card.oppoCard1[c]==oppoUnsubmitList[b]&&count3<=3) {
											oppoSubmitList[c]=1;
											count3++;
										}
										if(count3==4) {
											for(int e=1;e<=y;e++) {
												if(oppoUnsubmitList[e]==oppoUnsubmitList[e+1]&&oppoUnsubmitList[e]!=oppoUnsubmitList[e+2]&&oppoUnsubmitList[e]!=oppoUnsubmitList[e-1]) {
													for(int d=1;d<=18;d++) {
														if(Card.oppoCard1[d]==oppoUnsubmitList[b]&&count2<=2) {
															oppoSubmitList[d]=1;
															count2++;
														}
														if(count2==3) {
															Card.oppoBeat=true;
															break;
														}
													}
												}
											}
										}
									}
								}
							}
						}else if(num3==0&&num2!=0) {
							count2=1;
							for(int b=1;b<=y;b++) {
								if(oppoUnsubmitList[b]==oppoUnsubmitList[b+1]) {
									for(int d=1;d<=18;d++) {
										if(Card.oppoCard1[d]==oppoUnsubmitList[b]&&count2<=2) {
											oppoSubmitList[d]=1;
											count2++;
										}
										if(count2==3) {
											Card.oppoBeat=true;
											break;
										}
									}
								}
							}
						}else if(num3==0&&num2==0) {
							for(int b=1;b<=18;b++) {
								if(oppoSubmitList[b]==0) {
									oppoSubmitList[b]=1;
									break;
								}
							}
						}
					}else if(checkContinuity>=5) {
						x=1;
						for(int d=1;d<=18;d++) {
							if(oppoSubmitList[d]==0&&Card.oppoCard1[d]==oppoContinuousList[x]) {
								oppoSubmitList[d]=1;
							}
						}
					}
				}else if(num1<=(total/2)) {
					if(num3!=0) {
						if(num3==num2||num3!=num2&&Card.xxB10==false) {
							for(int b=1;b<=y;b++) {
								if(oppoUnsubmitList[b]==oppoUnsubmitList[b+1]&&oppoUnsubmitList[b]==oppoUnsubmitList[b+2]&&oppoUnsubmitList[b]!=oppoUnsubmitList[b-1]) {
									for(int c=1;c<=18;c++) {
										if(Card.oppoCard1[c]==oppoUnsubmitList[b]&&count3<=3) {
											oppoSubmitList[c]=1;
											count3++;
										}
										if(count3==4) {
											Card.oppoBeat=true;
											break;
										}
									}
								}
								if(oppoUnsubmitList[b]==oppoUnsubmitList[b+1]&&oppoUnsubmitList[b]!=oppoUnsubmitList[b+2]&&oppoUnsubmitList[b]!=oppoUnsubmitList[b-1]) {
									for(int d=1;d<=18;d++) {
										if(Card.oppoCard1[d]==oppoUnsubmitList[b]&&count2<=2) {
											oppoSubmitList[d]=1;
											count2++;
										}
										if(count2==3) {
											Card.oppoBeat=true;
											break;
										}
									}
								}
							}
						}else if(num3!=num2&&Card.xxB10==true) {
							for(int b=1;b<=y;b++) {
								if(oppoUnsubmitList[b]==oppoUnsubmitList[b+1]&&oppoUnsubmitList[b]==oppoUnsubmitList[b+2]&&oppoUnsubmitList[b]!=oppoUnsubmitList[b-1]) {
									for(int c=1;c<=18;c++) {
										if(Card.oppoCard1[c]==oppoUnsubmitList[b]&&count3<=3) {
											oppoSubmitList[c]=1;
											count3++;
										}
										if(count3==4) {
											Card.oppoBeat=true;
											break;
										}
									}
								}
							}
						}
					}else if(num3==0&&num2!=0) {
						for(int b=1;b<=y;b++) {
							if(oppoUnsubmitList[b]==oppoUnsubmitList[b+1]&&oppoUnsubmitList[b]!=oppoUnsubmitList[b+2]&&oppoUnsubmitList[b]!=oppoUnsubmitList[	b-1]) {
								for(int d=1;d<=18;d++) {
									if(Card.oppoCard1[d]==oppoUnsubmitList[b]&&count2<=2) {
										oppoSubmitList[d]=1;
										count2++;
									}
									if(count2==3) {
										Card.oppoBeat=true;
										break;
									}
								}
							}
						}
					}else if(num3==0&&num2==0) {
						for(int b=1;b<=18;b++) {
							if(oppoSubmitList[b]==0) {
								oppoSubmitList[b]=1;
								break;
							}
						}
					}
				}
				doneValid=true;
				done=false;
				fold=true;
				setSize(1299,499);
				setSize(1300,500);
			}else {
				statusL.setText("You cannot use FOLD button now. Please press DONE.");
				fold=false;
			}
System.out.println("\n\n=======================\nFOLD: ");
for(int i=1;i<=18;i++) {System.out.println("UserSubmitList["+i+"]: "+submitList[i]);}
System.out.println();
for(int j=1;j<=18;j++) {System.out.println("OppoSubmitList["+j+"]: "+oppoSubmitList[j]);}
System.out.println();
System.out.println("userValid: "+Card.userValid+"\nuserBeat: "+Card.userBeat+"\noppoBeat: "+Card.oppoBeat+"\ndoneValid: "+doneValid+"\ndone: "+done);
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private class DoneButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			if(doneValid==true&&done==false) {
				statusL.setText("If you have bigger cards, please select them and press SUBMIT; If you want to end this turn, please press FOLD.");
				processPanel.remove(us1);
				processPanel.remove(us2);
				processPanel.remove(us3);
				processPanel.remove(us4);
				processPanel.remove(us5);
				processPanel.remove(us6);
				processPanel.remove(us7);
				processPanel.remove(us8);
				processPanel.remove(us9);
				processPanel.remove(us10);
				processPanel.remove(us11);
				processPanel.remove(us12);
				processPanel.remove(us13);
				processPanel.remove(us14);
				processPanel.remove(us15);
				processPanel.remove(us16);
				processPanel.remove(us17);
				processPanel.remove(us18);

				processPanel.remove(op1);
				processPanel.remove(op2);
				processPanel.remove(op3);
				processPanel.remove(op4);
				processPanel.remove(op5);
				processPanel.remove(op6);
				processPanel.remove(op7);
				processPanel.remove(op8);
				processPanel.remove(op9);
				processPanel.remove(op10);
				processPanel.remove(op11);
				processPanel.remove(op12);
				processPanel.remove(op13);
				processPanel.remove(op14);
				processPanel.remove(op15);
				processPanel.remove(op16);
				processPanel.remove(op17);
				processPanel.remove(op18);

				if (oppoSubmitList[1]==1) {
					oppoPanel.remove(o1B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[1]));
					source=cardPic.getImage();
       				op1.setIcon(new ImageIcon(source));
					processPanel.add(op1);
					oppoSubmitList[1]=2;
				}

				if (oppoSubmitList[2]==1) {
					oppoPanel.remove(o2B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[2]));
					source=cardPic.getImage();
       				op2.setIcon(new ImageIcon(source));
					processPanel.add(op2);
					oppoSubmitList[2]=2;
				}

				if (oppoSubmitList[3]==1) {
					oppoPanel.remove(o3B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[3]));
					source=cardPic.getImage();
       				op3.setIcon(new ImageIcon(source));
					processPanel.add(op3);
					oppoSubmitList[3]=2;
				}

				if (oppoSubmitList[4]==1) {
					oppoPanel.remove(o4B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[4]));
					source=cardPic.getImage();
       				op4.setIcon(new ImageIcon(source));
					processPanel.add(op4);
					oppoSubmitList[4]=2;
				}

				if (oppoSubmitList[5]==1) {
					oppoPanel.remove(o5B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[5]));
					source=cardPic.getImage();
       				op5.setIcon(new ImageIcon(source));
					processPanel.add(op5);
					oppoSubmitList[5]=2;
				}

				if (oppoSubmitList[6]==1) {
					oppoPanel.remove(o6B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[6]));
					source=cardPic.getImage();
       				op6.setIcon(new ImageIcon(source));
					processPanel.add(op6);
					oppoSubmitList[6]=2;

				}

				if (oppoSubmitList[7]==1) {
					oppoPanel.remove(o7B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[7]));
					source=cardPic.getImage();
       				op7.setIcon(new ImageIcon(source));
					processPanel.add(op7);
					oppoSubmitList[7]=2;
				}

				if (oppoSubmitList[8]==1) {
					oppoPanel.remove(o8B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[8]));
					source=cardPic.getImage();
       				op8.setIcon(new ImageIcon(source));
					processPanel.add(op8);
					oppoSubmitList[8]=2;
				}

				if (oppoSubmitList[9]==1) {
					oppoPanel.remove(o9B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[9]));
					source=cardPic.getImage();
       				op9.setIcon(new ImageIcon(source));
					processPanel.add(op9);
					oppoSubmitList[9]=2;
				}

				if (oppoSubmitList[10]==1) {
					oppoPanel.remove(o10B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[10]));
					source=cardPic.getImage();
       				op10.setIcon(new ImageIcon(source));
					processPanel.add(op10);
					oppoSubmitList[10]=2;
				}

				if (oppoSubmitList[11]==1) {
					oppoPanel.remove(o11B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[11]));
					source=cardPic.getImage();
       				op11.setIcon(new ImageIcon(source));
					processPanel.add(op11);
					oppoSubmitList[11]=2;
				}

				if (oppoSubmitList[12]==1) {
					oppoPanel.remove(o12B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[12]));
					source=cardPic.getImage();
       				op12.setIcon(new ImageIcon(source));
					processPanel.add(op12);
					oppoSubmitList[12]=2;
				}

				if (oppoSubmitList[13]==1) {
					oppoPanel.remove(o13B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[13]));
					source=cardPic.getImage();
       				op13.setIcon(new ImageIcon(source));
					processPanel.add(op13);
					oppoSubmitList[13]=2;
				}

				if (oppoSubmitList[14]==1) {
					oppoPanel.remove(o14B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[14]));
					source=cardPic.getImage();
       				op14.setIcon(new ImageIcon(source));
					processPanel.add(op14);
					oppoSubmitList[14]=2;
				}

				if (oppoSubmitList[15]==1) {
					oppoPanel.remove(o15B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[15]));
					source=cardPic.getImage();
       				op15.setIcon(new ImageIcon(source));
					processPanel.add(op15);
					oppoSubmitList[15]=2;
				}

				if (oppoSubmitList[16]==1) {
					oppoPanel.remove(o16B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[16]));
					source=cardPic.getImage();
       				op16.setIcon(new ImageIcon(source));
					processPanel.add(op16);
					oppoSubmitList[16]=2;
				}

				if (oppoSubmitList[17]==1) {
					oppoPanel.remove(o17B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[17]));
					source=cardPic.getImage();
       				op17.setIcon(new ImageIcon(source));
					processPanel.add(op17);
					oppoSubmitList[17]=2;
				}

				if (oppoSubmitList[18]==1) {
					oppoPanel.remove(o18B);
					cardPic=new ImageIcon(Winner.class.getResource(Card.oppoPic[18]));
					source=cardPic.getImage();
       				op18.setIcon(new ImageIcon(source));
					processPanel.add(op18);
					oppoSubmitList[18]=2;
				}
				setSize(1299,499);
				setSize(1300,500);

				oppoSubmittedCard=0;
				for(int b=1;b<=18;b++) {
					if (oppoSubmitList[b]==2||oppoSubmitList[b]==3) {
						oppoSubmittedCard++;
					}
				}
				oppoPanel.add(blank3L);
				if(oppoSubmittedCard>=1)
					oppoPanel.add(o1L);
				if(oppoSubmittedCard>=3)
					oppoPanel.add(o2L);
				if(oppoSubmittedCard>=5)
					oppoPanel.add(o3L);
				if(oppoSubmittedCard>=7)
					oppoPanel.add(o4L);
				if(oppoSubmittedCard>=9)
					oppoPanel.add(o5L);
				if(oppoSubmittedCard>=11)
					oppoPanel.add(o6L);
				if(oppoSubmittedCard>=13)
					oppoPanel.add(o7L);
				if(oppoSubmittedCard>=15)
					oppoPanel.add(o8L);
				if(oppoSubmittedCard>=17)
					oppoPanel.add(o9L);
				setSize(1299,499);
				setSize(1300,500);

				if(oppoSubmitList[1]==0||oppoSubmitList[1]==1)
					oppoPanel.add(o1B);
				if(oppoSubmitList[2]==0||oppoSubmitList[2]==1)
					oppoPanel.add(o2B);
				if(oppoSubmitList[3]==0||oppoSubmitList[3]==1)
					oppoPanel.add(o3B);
				if(oppoSubmitList[4]==0||oppoSubmitList[4]==1)
					oppoPanel.add(o4B);
				if(oppoSubmitList[5]==0||oppoSubmitList[5]==1)
					oppoPanel.add(o5B);
				if(oppoSubmitList[6]==0||oppoSubmitList[6]==1)
					oppoPanel.add(o6B);
				if(oppoSubmitList[7]==0||oppoSubmitList[7]==1)
					oppoPanel.add(o7B);
				if(oppoSubmitList[8]==0||oppoSubmitList[8]==1)
					oppoPanel.add(o8B);
				if(oppoSubmitList[9]==0||oppoSubmitList[9]==1)
					oppoPanel.add(o9B);
				if(oppoSubmitList[10]==0||oppoSubmitList[10]==1)
					oppoPanel.add(o10B);
				if(oppoSubmitList[11]==0||oppoSubmitList[11]==1)
					oppoPanel.add(o11B);
				if(oppoSubmitList[12]==0||oppoSubmitList[12]==1)
					oppoPanel.add(o12B);
				if(oppoSubmitList[13]==0||oppoSubmitList[13]==1)
					oppoPanel.add(o13B);
				if(oppoSubmitList[14]==0||oppoSubmitList[14]==1)
					oppoPanel.add(o14B);
				if(oppoSubmitList[15]==0||oppoSubmitList[15]==1)
					oppoPanel.add(o15B);
				if(oppoSubmitList[16]==0||oppoSubmitList[16]==1)
					oppoPanel.add(o16B);
				if(oppoSubmitList[17]==0||oppoSubmitList[17]==1)
					oppoPanel.add(o17B);
				if(oppoSubmitList[18]==0||oppoSubmitList[18]==1)
					oppoPanel.add(o18B);

				if(oppoSubmittedCard>=2)
					oppoPanel.add(o10L);
				if(oppoSubmittedCard>=4)
					oppoPanel.add(o11L);
				if(oppoSubmittedCard>=6)
					oppoPanel.add(o12L);
				if(oppoSubmittedCard>=8)
					oppoPanel.add(o13L);
				if(oppoSubmittedCard>=10)
					oppoPanel.add(o14L);
				if(oppoSubmittedCard>=12)
					oppoPanel.add(o15L);
				if(oppoSubmittedCard>=14)
					oppoPanel.add(o16L);
				if(oppoSubmittedCard>=16)
					oppoPanel.add(o17L);
				if(oppoSubmittedCard>=18)
					oppoPanel.add(o18L);
				oppoPanel.add(blank4L);

				foldValid=true;

				oppoWin=true;
				for(int d=1;d<=18;d++) {
					if(submitList[d]==2) {
						submitList[d]=3;
					}
				}
				for(int e=1;e<=18;e++) {
					if(oppoSubmitList[e]==0) {
						oppoWin=false;
					}
				}
				if(oppoWin==true) {
					statusL.setText("YOU LOSE!");
					buttonPanel.remove(submitB);
					buttonPanel.remove(cancelB);
					buttonPanel.remove(foldB);
					buttonPanel.remove(doneB);
				}
				fold=false;
				setSize(1299,499);
				setSize(1300,500);

			}else if(doneValid==false) {
				statusL.setText("You cannot use DONE button now. Please submit your cards first.");
			}else if(done==true&&doneValid==true) {
				processPanel.remove(us1);
				processPanel.remove(us2);
				processPanel.remove(us3);
				processPanel.remove(us4);
				processPanel.remove(us5);
				processPanel.remove(us6);
				processPanel.remove(us7);
				processPanel.remove(us8);
				processPanel.remove(us9);
				processPanel.remove(us10);
				processPanel.remove(us11);
				processPanel.remove(us12);
				processPanel.remove(us13);
				processPanel.remove(us14);
				processPanel.remove(us15);
				processPanel.remove(us16);
				processPanel.remove(us17);
				processPanel.remove(us18);
				processPanel.add(blank15L);

		 		userCardSelected="Card selected: ";
				userCardSelectedL.setText(userCardSelected);
				statusL.setText("Opponent folds. Please select your cards in any valid formats and press SUBMIT button.");
				for(int d=1;d<=18;d++) {
					if(submitList[d]==2) {
						submitList[d]=3;
					}
				}
				for(int c=1;c<=18;c++) {
					if(oppoSubmitList[c]==2) {
						oppoSubmitList[c]=3;
					}
				}

				setSize(1299,499);
				setSize(1300,500);
			}
System.out.println("\n\n=======================\nDONE: ");
for(int i=1;i<=18;i++) {System.out.println("UserSubmitList["+i+"]: "+submitList[i]);}
System.out.println();
for(int j=1;j<=18;j++) {System.out.println("OppoSubmitList["+j+"]: "+oppoSubmitList[j]);}
System.out.println();
System.out.println("userValid: "+Card.userValid+"\nuserBeat: "+Card.userBeat+"\noppoBeat: "+Card.oppoBeat+"\ndoneValid: "+doneValid+"\ndone: "+done);


		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[]args) {
		Winner game=new Winner();
	}
}