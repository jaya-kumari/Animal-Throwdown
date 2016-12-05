// Jaya Kumari
// Game.java
// This is my game called Animal Throwdown.
// The user navigates through the game using answer keys.
// There are further instructions on the actual Game.

// all code written inside main, unlike applet
// importing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner; // reads the text file
import java.io.File; // reads in the text file
import java.io.FileNotFoundException; // checks to see if tile was found
import java.io.PrintWriter; // outputs the text file
import java.io.IOException; // checks for problems with text file output
import java.io.*;
import javax.imageio.*; // because we're using pic files too


// no extending in JFrame because you set frame inside the class
public class Game implements KeyListener
{
	private JFrame frame;
	 private CardLayout cards;
	private Container c;
	// panel
	private DrawPanel1 panel1;
	 private DrawPanel2 panel2;
	private DrawPanel3 panel3;
	private DrawPanel4 panel4;
	private DrawPanel5 panel5;
	private DrawPanel6 panel6;
	 // Variables
	 int row2, col2;
	boolean up, down, left, right;
	 int currow, currcol;
	int paintcount;
	 private int[] cheesexco;
	 private int[] cheeseyco;
	 private  int[][] table;
	 private int[][] xco;
	private int[][] yco;
	 private int[] pigrow;
	 private int[] pigcol;
	private boolean[][] cheese;
	 private boolean[][] cheesepresent;
	 private int[] cheesecol;
	private int[]  cheeserow;
	 private boolean[][] pigpresent;
	 private boolean win;
	private boolean lose;
	 private boolean answerwin;
	 private boolean answerlose;
	 // images
	private Image pigbug, farmer, corn, goose, arrow, grass;
	 private String imageName1, imageName2, imageName3, imageName6, imageName7, imageName8;
	int random;
	private boolean leveleasy, levelmedium, levelhard;
	// create instance of JFrame globally
	 // JFrame frame;
	MyPanel canvas;
	 int firstx,endx;
	 int numbercorn;
	 // constructor method
	 public Game()
	 {
		answerwin = true;
		answerlose = true;
		leveleasy = levelmedium = levelhard = false;
		numbercorn = 0;
		// imagenames of pictures
		 imageName1 = "pig.jpg";
		imageName2 = "farmer.jpg";
		imageName3 = "corn.jpg";
		imageName6 = "goose.JPG";
		 imageName7 = "arrow.jpg";
		 imageName8 = "Grass.jpg";
		 random = (int)(Math.random() * 7 + 1);
		 win = false;
		 lose = false;
		 up = down = right = left = true;
		 paintcount = 0;
		 cheesexco = new int[6];
		 cheeseyco = new int[6];
		 cheeserow = new int[6];
		 cheesecol = new int[6];
		pigrow = new int[6];
		 pigcol = new int[6];
		 table = new int[10][10];
		 firstx = endx = 0;
		 xco = new int[10][10];
		 yco = new int[10][10];
		 cheesepresent = new boolean[10][10];
		 pigpresent = new boolean[10][10];
		 currcol = (int)(Math.random() * 9);
		 currow = (int)(Math.random() * 9);
		 for(int row = 0; row < 10; row++)
		 {
			 for(int col = 0; col < 10; col++)
			 {
				 cheesepresent[row][col] = false;
				 pigpresent[row][col] = false;
			 }
		 }
	 }
	 // main method - perks of a JFrame
	 public static void main (String [] args)
	{
		 Game practice = new Game();
		 practice.Run();
	}
	 public void Run()
	{
		// getimages
		 GetMyImage1();
		 GetMyImage2();
		 GetMyImage3();
		 GetMyImage6();
		 GetMyImage7();
		 GetMyImage8();
		 frame = new JFrame("Game.java by Jaya Kumari - Animal Throwdown");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(600,600);
		 frame.setResizable(false); // don't let user resize the JFrame
		  c = frame.getContentPane();
		 cards = new CardLayout();
		 c.setLayout(cards);

		 panel1 = new DrawPanel1();
		panel1.setBackground(Color.white);
		 c.add(panel1, "Panel 1");

		 panel2 = new DrawPanel2();
		 panel2.setBackground(Color.white);
		c.add(panel2, "Panel 2");

		 panel3 = new DrawPanel3();
		 panel3.setBackground(Color.white);
		c.add(panel3, "Panel 3");
		 canvas = new MyPanel();
		 canvas.addKeyListener(this);

		 frame.setVisible(true); // returns a boolean, do this in order to view JFrame
		 canvas.requestFocus();
		 panel4 = new DrawPanel4();
		 panel4. setBackground(Color.white);
		c.add(panel4, "Panel 4");
		 c.add(canvas, "MyPanel");

		 panel5 = new DrawPanel5();
		 panel5.setBackground(Color.white);
		 c.add(panel5, "Panel 5");

		panel6 = new DrawPanel6();
		panel6.setBackground(Color.white);
		c.add(panel6, "Panel 6");

	 }
	 // try catch blocks in methods to get images
	 // file input and output
	public void GetMyImage1()
	 {
		 try
		{
			pigbug = ImageIO.read(new File(imageName1));
			 // imageName because you need a string identifier
		}
		catch(IOException e)
		 {
			e.printStackTrace();
		}
	}
	 public void GetMyImage2()
	 {
		try
		{
			 farmer = ImageIO.read(new File(imageName2));
			 // imageName because you need a string identifier
		 }
		 catch(IOException e)
		 {
			e.printStackTrace();
		 }
	}
	public void GetMyImage3()
	 {
		 try
		{
			corn = ImageIO.read(new File(imageName3));
			 // imageName because you need a string identifier
		}
		catch(IOException e)
		 {
			e.printStackTrace();
		}
	}
	 public void GetMyImage6()
	 {
		try
		{
			 goose = ImageIO.read(new File(imageName6));
			 // imageName because you need a string identifier
		}
		 catch(IOException e)
		 {
			e.printStackTrace();
		 }
	}
	 public void GetMyImage7()
	 {
		 try
		{
			 arrow = ImageIO.read(new File(imageName7));
			 // imageName because you need a string identifier
		}
		 catch(IOException e)
		 {
			e.printStackTrace();
		 }
	}
	public void GetMyImage8()
	 {
		 try
		{
			 grass = ImageIO.read(new File(imageName8));
			 // imageName because you need a string identifier
		}
		 catch(IOException e)
		 {
			e.printStackTrace();
		 }
	}

	 class MyPanel extends JPanel
	 {
		 MyPanel()
	{
		 setBackground(Color.green);
	 }
	 public void paintComponent(Graphics g)
	 {
		 super.paintComponent(g);
		 // split everything into methods to make program more clear\

		printGrid(g);

		  if(paintcount == 0)
		 {
			printCheese(g);
		 }
		else
		 {
			printCheeseAgain(g);
		 }
		 if(paintcount == 0)
		 {
			 printFirstpig(g);
		 }
		else
		 {
			 printpigAgain(g);
		 }
		 if(paintcount == 0)
		 {
			while(pigpresent[currow][currcol] == true ||
			 cheesepresent[currow][currcol] == true)
			 {
				 currow = (int)(Math.random() * 8 + 1);
				 currcol = (int)(Math.random() * 8 + 1);

			 }
			printFirstfarmer(g);
		 }
		// use booleans to determine which way to print
		// the farmer
		 else if(up == false)
		{
		 	printUpfarmer(g);
		 }
		else if(down == false)
		 {
			printDownfarmer(g);
		 }
		else if(left == false)
		 {
			printLeftfarmer(g);
		 }
		else if(right == false)
		 {
			printRightfarmer(g);
		 }
		paintcount++;
		 if (win)
		 {
		   printWin(g);
		}
		 if (lose)
		 {
		   printLose(g) ;
		 }
		  printDirections(g);
	 }
	 // old directions known just has histogram after
	 // it was too small for instructions
	 public void printDirections(Graphics g)
	{
		 g.setFont(new Font("Arial", Font.BOLD, 15));
		 g.setColor(Color.black);
		 // hard coded histogram!
		 if(numbercorn == 0)
		 {
			 g.setColor(Color.red);
			 g.setColor(Color.red);
			 g.fillRect(10,520,538,25);
			 g.setColor(Color.white);
			  g.drawString(" " + numbercorn + " crops collected", 10, 540);
		 }
		 if(numbercorn == 1)
		 {
			 g.setColor(Color.red);
			 g.setColor(Color.red);
			g.fillRect(10,520,538,25);
			 g.setColor(Color.blue);
			  g.fillRect(10,520,50, 25);
			 g.setColor(Color.white);
			  g.drawString(" " + numbercorn + " crop collected", 10, 540);
		 }
		 if(numbercorn == 2)
		 {
			 g.setColor(Color.red);
			 g.setColor(Color.red);
			g.fillRect(10,520,538,25);
			g.setColor(Color.blue);
			  g.fillRect(10,520, 100, 25);
			 g.setColor(Color.white);
			  g.drawString(" " + numbercorn + " crops collected", 10, 540);
		 }
		 if(numbercorn == 3)
		 {
			 g.setColor(Color.red);
			 g.setColor(Color.red);
			g.fillRect(10,520,538,25);
			 g.setColor(Color.blue);
			  g.fillRect(10,520, 200, 25);
			 g.setColor(Color.white);
			  g.drawString(" " + numbercorn + " crops collected", 10, 540);
		 }
		 if(numbercorn == 4)
		 {
			 g.setColor(Color.red);
			 g.setColor(Color.red);
			g.fillRect(10,520,538,25);
			 g.setColor(Color.blue);
			  g.fillRect(10,520, 330, 25);
			 g.setColor(Color.white);
			  g.drawString(" " + numbercorn + " crops collected", 10, 540);
		 }
		 if(numbercorn == 5)
		 {
			 g.setColor(Color.red);
			 g.setColor(Color.red);
			g.fillRect(10,520,538,25);
			 g.setColor(Color.blue);
			  g.fillRect(10,520, 440, 25);
			 g.setColor(Color.white);
			  g.drawString(" " + numbercorn + " crops collected", 10, 540);
		 }
		 if(numbercorn == 6)
		 {
			 g.setColor(Color.red);
			 g.setColor(Color.red);
			g.fillRect(10,520,538,25);
			 g.setColor(Color.blue);
			  g.fillRect(10,520, 538, 25);
			 g.setColor(Color.white);
			  g.drawString(" " + numbercorn + " crops collected", 10, 540);
		 }
	 }
	// vertical line
	public void printGrid(Graphics g)
	 {
		int rectx, recty;
		rectx = 10;
		recty = 10;
		 for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 10; col++)
			 {
				g.setColor(new Color(209, 200, 203));
				g.drawRect(rectx,recty,50,50);

				xco[row][col] = rectx;
				yco[row][col] = recty;
				 recty += 50;
			 }
		rectx += 50;
		 recty = 10;
		 g.drawImage(grass, 0, 0, 600, 600, this);
		}
	 }
	// method that prints when you win
	 public void printWin(Graphics g)
	 {
		 cards.show(c, "Panel 3");
	 }
	public void printLose(Graphics g)
	 {
		g.setColor(Color.red);
		 g.setFont(new Font("Arial", Font.BOLD, 50));
		 g.drawString("YOU LOSE!",150,250);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		 // GENERATE # To determine question #
		cards.show(c, "Panel 2");
	 }
	 public void printCheese(Graphics g)
	 {
		 int row1, col1;
		 boolean cheesedone = false;
		 for(int i = 0; i < 6; i++)
		 {
			cheesedone = false;
			 while (!cheesedone)
			 {
				row1 = (int)(Math.random() * 9);
				 col1 = (int)(Math.random() * 9);
				 if (cheesepresent[row1][col1])
				{ }
				else
				 {
					 g.setColor(Color.orange);

					 g.drawImage(corn,xco[row1][col1],yco[row1][col1], 35,35, this);
					 cheesexco[i] = xco[row1][col1];
					 cheeseyco[i]= yco[row1][col1];
					 cheesepresent[row1][col1] = true;
					 cheeserow[i] = row1;
					 cheesecol[i] = col1;
					 cheesedone = true;
				 }
			 }
		}
	}
	 public void printCheeseAgain(Graphics g)
	 {
		  int chrow;
		   int chcol;
		   boolean cheesefound = false;
		 for(int i = 0; i < 6; i++)
		 {
			 chrow = cheeserow[i];
			chcol = cheesecol[i];
			 if (cheesepresent[chrow][chcol])
			 {
				cheesefound = true;
				 g.setColor(Color.orange);
				 g.drawImage(corn,cheesexco[i] + 8,cheeseyco[i] +8, 35,35, this);
			 }
		}
		 if (cheesefound)
		 {}
		else
		 {
			 win = true;
			 printWin(g);
		 }
	 }
	 // print the pig - seperate method that i'll call
	public void printFirstpig(Graphics g)
	 {
		boolean pigdone = false;
		 for(int row = 0; row < 10; row++)
		  {
			 for(int col = 0; col < 10; col++)
			{
			 	pigpresent[row][col] = false;
			 }
		  }
		 for(int i = 0; i < 6; i++)
		 {
			 pigdone = false;
			 while (!pigdone)
			 {
				row2 = (int)(Math.random() * 9);
				 col2 = (int)(Math.random() * 9);
				 if (pigpresent[row2][col2])
				{}
				 else
				 {
					 g.setColor(Color.red);
					g.drawImage(pigbug,xco[row2][col2],yco[row2][col2],50, 50,this);
					pigrow[i] = row2;
					 pigcol[i]=  col2;
					 pigpresent[row2][col2] = true;
					pigdone = true;
				   }
			   }
		}

	}
	// print pig again
	// this is where the levels of playing comes into play
	 public void printpigAgain(Graphics g)
	 {
		 int rerow2, recol2;
		 int random;
		 int prevrow,prevcol;

		 System.out.println("pig array 3");
		  for(int i = 0; i < 6; i++)
		  {
			System.out.println(pigrow[i]);
			System.out.println(pigcol[i]);
			System.out.println("----");
		  }

		 System.out.println("loop begin");

		 for(int i = 0; i < 6; i++)
		 {

			 row2 = pigrow[i];
			 col2 = pigcol[i];

			 random = (int)(Math.random() * 3 + 1);

			// chain of if elses now
			// based on random number generated above
			// the  pig will be printed in a different row and col
			// also where it is is also incremented based off levels
			 if(random == 1)
			 {
				  System.out.println("random1");
				if (row2 < 9)
				{
					if(leveleasy)
					{
						row2++;
					}
					if(levelmedium)
					{
						row2+=2;
						if(row2 > 9)
					   {
							row2 -= 2;
						}
					}
					if(levelhard)
					{
						row2 = (int)(Math.random() * 8 + 1);
					}
			  else
			   {
				if(leveleasy)
					{
						row2--;
					}
					if(levelmedium)
					{
						row2-=2;
						if(row2 < 0)
					   {
							row2 += 2;
						}
					}
					if(levelhard)
					{
						row2 = (int)(Math.random() * 8 + 1);
					}
			 }

			}
		  }
			 else if(random == 2)
			{
				System.out.println("random2");
			 if (row2 > 0)
			  {
				if(leveleasy)
					{
						row2--;
					}
					if(levelmedium)
					{
						row2-=2;
						if(row2 < 0)
					   {
							row2 += 2;
						}
					}
					if(levelhard)
					{
						row2 = (int)(Math.random() * 8 + 1);
					}
			  }
			  else
			   {

					if(leveleasy)
					{
						row2++;
					}
					if(levelmedium)
					{
						row2+=2;
						if(row2 > 9)
					   {
							row2 -= 2;
						}
					}
					if(levelhard)
					{
						row2 = (int)(Math.random() * 8 + 1);
					}
				}
			  }
			 else if(random == 3)
			 {
				 System.out.println("random3");
				  if (col2 < 9)
				  {
					 if(leveleasy)
						{
							col2++;
						}
						if(levelmedium)
						{
							col2+=2;
							if(col2 > 9)
						   {
								col2 -= 2;
							}
						}
						if(levelhard)
						{
							col2 = (int)(Math.random() * 8 + 1);
						}
				  }
				  else
				   {
						if(leveleasy)
						{
							col2--;
						}
						if(levelmedium)
						{
							col2-=2;
							if(col2 < 0)
						   {
								col2 += 2;
							}
						}
						if(levelhard)
						{
							col2 = (int)(Math.random() * 8 + 1);
						}
					}
			 }
			else if(random == 4)
			 {
				 System.out.println("random4");
				 if (col2 > 0)
				  {
						if(leveleasy)
						{
							col2--;
						}
						if(levelmedium)
						{
							col2-=2;
							if(col2 < 0)
						   {
								col2 += 2;
							}
						}
						if(levelhard)
						{
							col2 = (int)(Math.random() * 8 + 1);
						}
				  }
				  else
				   {
					if(leveleasy)
						{
							col2++;
						}
						if(levelmedium)
						{
							col2+=2;
							if(col2 > 9)
						   {
								col2 -= 2;
							}

						}
						if(levelhard)
						{
							col2 = (int)(Math.random() * 8 + 1);
						}
					 }
			 }
			 // if pig present
			 while(pigpresent[row2][col2] == true)
			 {
				col2 = (int)(Math.random() * 8 + 1);
				row2 = (int)(Math.random() * 8 + 1);
			 }
			if(row2 >= 9)
			 {
				row2 = 0;
			 }
			else if(row2 <= 0)
			 {
				row2 = 9;
			 }
			if(col2 >= 9)
			 {
				col2 = 0;
			 }
			else if(col2 <= 0)
			 {
				col2 = 9;
			 }



			 g.setColor(Color.red);
			 g.drawImage(pigbug,xco[row2][col2],yco[row2][col2],50, 50,this);

			 prevrow = pigrow[i];
			 prevcol = pigcol[i] ;
			 pigpresent[prevrow][prevcol] = false;
			 pigrow[i] = row2;
			 pigcol[i] = col2;
			 pigpresent[row2][col2] = true;
			 if (row2 == currow && col2 == currcol)
			 {
				printLose(g);
				lose = true;
			 }
		}
	}
	 // print first farmer
	public void printFirstfarmer(Graphics g)
	 {
		 g.setColor(Color.blue);
		  g.drawImage(farmer,xco[currow][currcol],yco[currow][currcol], 50,50,this);
	 }
	 // print left farmer
	 public void printLeftfarmer(Graphics g)
	 {
		 g.setColor(Color.blue);
		 g.drawImage(farmer, xco[currow][currcol],yco[currow][currcol], 50,50,this);
	  }
	// print right farmer
	 public void printRightfarmer(Graphics g)
	 {
		g.setColor(Color.blue);
		 g.drawImage(farmer, xco[currow][currcol],yco[currow][currcol], 50,50,this);
	 }
	// print farmer going up -done!
	 public void printUpfarmer(Graphics g)
	 {
		g.setColor(Color.blue);
		 g.drawImage(farmer, xco[currow][currcol],yco[currow][currcol], 50,50,this);
	 }
	// print farmer going down - done!
	 public void printDownfarmer(Graphics g)
	 {
		 g.setColor(Color.blue);
		 g.drawImage(farmer, xco[currow][currcol],yco[currow][currcol], 50,50, this);
	 }
	}
	 // when user presses keys
	 public void keyPressed(KeyEvent e)
	{

		int value = e.getKeyCode();
		// to make farmer go down
		if(win || lose)
		 {
			if(value == KeyEvent.VK_R)
			 {
				win = false;
				lose = false;
				 paintcount =0;
				canvas.repaint();
			 }
		}
		 else
		{
			// down
			 if(value == KeyEvent.VK_DOWN )
			 {
				 if(currcol >= 9)
				 {
					currcol = 0;
				 }
				else
				 {
					right = left = up = down = true;
					 currcol++;
					 down = false;
				 }
				 if (cheesepresent[currow][currcol])
			   {
				   numbercorn++;
				   cheesepresent[currow][currcol] = false;
			   }
			   canvas.repaint();
			}
			 // to make farmer go up
			else if (value == KeyEvent.VK_UP)
			 {
				 if(currcol <= 0)
				{
					currcol = 9;
				 }
				 else
				{
					right = left = up = down = true;
				   currcol--;
				   up = false;
				 //canvas.repaint();
				 }
				 if (cheesepresent[currow][currcol])
				{
				   numbercorn++;
				   cheesepresent[currow][currcol] = false;
				}
			   canvas.repaint();
			 }
			 // to make farmer go right
			else if(value == KeyEvent.VK_RIGHT )
			 {
				 if(currow >= 9)
				{
					currow = 0;
				 }
				 else
				{
					right = left = up = down = true;
					 currow++;
					 right = false;
				 }
				 if (cheesepresent[currow][currcol])
			   {
				   numbercorn++;
				   cheesepresent[currow][currcol] = false;
			   }
			   canvas.repaint();
			}
			 // to make farmer go left - done!
			 else if(value == KeyEvent.VK_LEFT )
			{
				 if(currow <= 0)
				 {
					currow = 9;
				}
				 else
				 {
					right = left = up = down = true;
					currow--;
					 left = false;
					//canvas.repaint();
				}
				// if there is corn already
				if (cheesepresent[currow][currcol])
			   {
				   numbercorn++;
				   cheesepresent[currow][currcol] = false;
			   }
			   canvas.repaint();
			 }
			if(value != KeyEvent.VK_LEFT || value != KeyEvent.VK_RIGHT || value != KeyEvent.VK_UP || value != KeyEvent.VK_DOWN)
			{}
	 }
	}
	 // mandatory key methods
	public void keyReleased(KeyEvent e) {}
	 public void keyTyped(KeyEvent e) {}
	 // New Panel
	class DrawPanel1 extends JPanel
	 {
		private BottomPanel lower;
		JButton jump, move, up;
		 private int size;
		 JLabel message;

		 public DrawPanel1()
		 {
			 this.setLayout(new BorderLayout());
			 lower = new BottomPanel();
			this.add(lower, BorderLayout.SOUTH);
			 // east because we want it on the right side of the screen
		}
		public void paintComponent(Graphics g)
		 {
			super.paintComponent(g);
			JLabel message = new JLabel("Animal Throwdown");
			g.setColor(Color.blue);
			message.setFont(new Font("Arial",Font.BOLD,60));  // in a big bold font.
			this.add(message, BorderLayout.NORTH);
			g.drawImage(pigbug, 0, 300, 200, 200, this);
			 g.drawImage(farmer, 300,300, 200, 200, this);
			 g.drawImage(corn, 200, 150, 200, 200, this);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			 g.drawString("Your journey into the WILD WEST", 20,80);
			 g.drawString(" begins here!", 100,110);
		}
		// mandatory method for AdjustmentListener
		 class BottomPanel extends JPanel implements ActionListener
		{
			JButton jump, instruct;
			public BottomPanel()
			{
				 setBackground(Color.yellow);
				 jump = new JButton ("Start The Game");
				jump.addActionListener(this);
				 this.add(jump);
				 instruct = new JButton("Instructions");
				 instruct.addActionListener(this);
				this.add(instruct);
			 }
			public void actionPerformed(ActionEvent evt)
			 {
				String command = evt.getActionCommand();
				if(command.equals("Start The Game"))
				 {
					cards.show(c, "Panel 6");
					 canvas.requestFocus();
				}
				 else if(command.equals("Instructions"))
				{
					cards.show(c, "Panel 4");
					 canvas.requestFocus();
				}
			}
		 }
	 }
	// educational panel
	 // redirected to hre after you lose
	 class DrawPanel2 extends JPanel
	{
		 private InnerPanel inner1;
		 public DrawPanel2()
		{
			 this.setLayout(null);
			 setBackground(Color.gray);
			 // place another panel on gray
			inner1 = new InnerPanel();
			 inner1.setLocation(20,200);
			 inner1.setSize(400,400);
			inner1.setBackground(Color.white);
			 this.add(inner1);
		 }
		public void paintComponent(Graphics g)
		 {
			 super.paintComponent(g);
			g.setFont(new Font("Arial", Font.PLAIN, 15));
			 g.drawString("OH NO! You ran over one of your pigs! You called the animal doctor  but", 10, 15);
			 g.drawString("she is over at another farm. She sends over a doctor in training and", 10, 30);
			 g.drawString(" warns you that you are going to have to help her if you want your", 10, 45);
			 g.drawString("pigs to survive! Use the knowledge you learned in biology to save the pig!", 10, 60);
			 // write the questions here:
			  if(random == 1)
			{
				g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you which bones form an", 10, 110);
				 g.drawString("immovable joint?", 10, 130);
			 }
			 if(random == 2)
			{
				g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you which Which type of", 10, 110);
				 g.drawString("muscle tissue is found in the walls of blood vessels?", 10, 130);
			 }
			 if(random == 3)
			{
				 g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you What is the order of", 10, 110);
				 g.drawString("blood vessels as blood leaves the heart to flow through the", 10, 130);
				 g.drawString("pig?", 10, 150);
			 }
			if(random == 4)
			 {
				g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you what regulates the", 10, 110);
				 g.drawString("preparation for and reaction to stress?", 10, 130);
			 }
			if(random == 5)
			{
				g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you Oh shoot, I forgot the", 10, 110);
				 g.drawString("main function of the large intestine. What was it again?", 10, 130);
			 }
			if(random == 6)
			 {
				g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you what regulates the", 10, 110);
				 g.drawString("level of hormones?", 10, 130);
			 }
			 if(random == 7)
			{
				g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you I forgot where oxygen ", 10, 110);
				 g.drawString("diffuses.Oxygen diffuses from the ____________ because ", 10, 130);
				 g.drawString("there is more oxygen in an alveolus than the blood around it.", 10, 150);
			 }
			if(random == 8)
			{
				g.setFont(new Font("Arial", Font.BOLD, 20));
				 g.drawString("OH NO! The doctor in training forgot the answer to", 10, 90);
				 g.drawString("this question. She asks you What movement causes the", 10, 110);
				 g.drawString("movement of a nerve impulse along the length of a neuron?", 10, 130);
			 }
		 }
		 // QUESTIONS - HARD CODING
		class InnerPanel extends JPanel implements ActionListener
		 {
			// multiple choice - use a JRADIOBUTTON
			private JRadioButton answer1a, answer1b, answer1c, answer1d;
			 private ButtonGroup question1;

			// question 2
			 private JRadioButton answer2a, answer2b, answer2c, answer2d;
			private ButtonGroup question2;
			// question 3
			 private JRadioButton answer3a, answer3b, answer3c, answer3d;
			private ButtonGroup question3;
			// question 4
			 private JRadioButton answer4a, answer4b, answer4c, answer4d;
			private ButtonGroup question4;
			// question 5
			 private JRadioButton answer5a, answer5b, answer5c, answer5d;
			private ButtonGroup question5;
			// question 6
			 private JRadioButton answer6a, answer6b, answer6c, answer6d;
			private ButtonGroup question6;
			 // question 7
			private JRadioButton answer7a, answer7b, answer7c, answer7d;
			private ButtonGroup question7;
			 // question 8
			private JRadioButton answer8a, answer8b, answer8c, answer8d;
			private ButtonGroup question8;
			 //int random;
			public InnerPanel()
			 {
			// work the best when you use a grid layout
			 this.setLayout(new GridLayout(10,4));
			 question1 = new ButtonGroup();
			 // QUESION1
			answer1a = new JRadioButton("the bones of the skull");
			 question1.add(answer1a);
			answer1a.addActionListener(this);

			 answer1b = new JRadioButton("the bones of the elbow joint");
			 question1.add(answer1b);
			 answer1b.addActionListener(this);
			 answer1c = new JRadioButton("the ribs and vertebrae");
			 question1.add(answer1c);
			answer1c.addActionListener(this);
			 answer1d = new JRadioButton("the bones of the hip joint");
			 question1.add(answer1d);
			 answer1d.addActionListener(this);
			 // QUESTION2
			   question2 = new ButtonGroup();

			   answer2a = new JRadioButton("smooth muscle"); // CORRECT ANSWER
			   question2. add(answer2a);
			   answer2a.addActionListener(this);

			   answer2b = new JRadioButton("voluntary muscle");
			  question2.add(answer2b);
			   answer2b.addActionListener(this);

			   answer2c = new JRadioButton("striated muscle");
			   question2.add(answer2c);
			   answer2c.addActionListener(this);

			   answer2d = new JRadioButton("skeletal muscle");
			   question2.add(answer2d);
			   answer2d.addActionListener(this);
			   //QUESTION3
			   question3 = new ButtonGroup();

			   answer3a = new JRadioButton("arteries to capillaries to veins"); // CORRECT
			   question3. add(answer3a);
			   answer3a.addActionListener(this);

			   answer3b = new JRadioButton("capillaries to arteries to veins");
			   question3.add(answer3b);
			   answer3b.addActionListener(this);

			   answer3c = new JRadioButton("veins to capillaries to arteries");
			   question3.add(answer3c);
			   answer3c.addActionListener(this);

			   answer3d = new JRadioButton("arteries to veins to capillaries");
			   question3.add(answer3d);
			   answer3d.addActionListener(this);
			  //QUESTION 4.. AND SO FORTH
			  question4 = new ButtonGroup();

			   answer4a = new JRadioButton("pituitary gland");
			   question4. add(answer4a);
			   answer4a.addActionListener(this);

			   answer4b = new JRadioButton("pancreas");
			   question4.add(answer4b);
			   answer4b.addActionListener(this);

			   answer4c = new JRadioButton("thyroid gland");
			   question4.add(answer4c);
			   answer4c.addActionListener(this);

			   answer4d = new JRadioButton("adrenal gland"); // CORRECT
			   question4.add(answer4d);
			   answer4d.addActionListener(this);

			   question5 = new ButtonGroup();

			   answer5a = new JRadioButton("remove wastes from digested food");
			   question5. add(answer5a);
			   answer5a.addActionListener(this);

			   answer5b = new JRadioButton("absorb sugars from digested food");
			   question5.add(answer5b);
			   answer5b.addActionListener(this);

			   answer5c = new JRadioButton("absorb mineral from digested food");
			   question5.add(answer5c);
			   answer5c.addActionListener(this);

			   answer5d = new JRadioButton("remove water from digested food"); // CORRECT
			   question5.add(answer5d);
			   answer5d.addActionListener(this);

			  question6 = new ButtonGroup();

			   answer6a = new JRadioButton("feedback mechanisms"); // CORRECT
			   question6.add(answer6a);
			   answer6a.addActionListener(this);

			   answer6b = new JRadioButton("excretory system");
			   question6.add(answer6b);
			  answer6b.addActionListener(this);

			   answer6c = new JRadioButton("homeostasis");
			   question6.add(answer6c);
			   answer6c.addActionListener(this);

			   answer6d = new JRadioButton("nervous system");
			   question6.add(answer6d);
			   answer6d.addActionListener(this);

			  question7 = new ButtonGroup();

			   answer7a = new JRadioButton("alveolus into blood"); // CORRECT
			   question7.add(answer7a);
			   answer7a.addActionListener(this);

			   answer7b = new JRadioButton("arteries into the capillaries");
			   question7.add(answer7b);
			   answer7b.addActionListener(this);

			   answer7c = new JRadioButton("blood into the alveolus");
			   question7.add(answer7c);
			   answer7c.addActionListener(this);

			   answer7d = new JRadioButton("capillaries into veins");
			   question7.add(answer7d);
			   answer7d.addActionListener(this);

			  question8 = new ButtonGroup();

			   answer8a = new JRadioButton("sodium and potassium ion through the cell membrane"); // CORRECT
			   question8.add(answer8a);
			   answer8a.addActionListener(this);

			   answer8b = new JRadioButton("neurotransmitters through the cell membrane");
			   question8.add(answer8b);
			   answer8b.addActionListener(this);

			   answer8c = new JRadioButton("sodium and potassium ions along the cell membrane");
			   question8.add(answer8c);
			   answer8c.addActionListener(this);

			   answer8d = new JRadioButton("neurotransmitters along the cell membrane");
			   question8.add(answer8d);
			   answer8d.addActionListener(this);

			 // add different options obviously solely based off
			 // the random number that is generated
			 if(random == 1)
			 {
				this.add(answer1a);
				this.add(answer1b);
				 this.add(answer1c);
				this.add(answer1d);
			}
			 if(random == 2)
			 {
				this.add(answer2a);
				 this.add(answer2b);
				this.add(answer2c);
				 this.add(answer2d);
			 }
			if(random == 3)
			{
				 this.add(answer3a);
				 this.add(answer3b);
				this.add(answer3c);
				 this.add(answer3d);
			 }
			if(random == 4)
			{
				 this.add(answer4a);
				 this.add(answer4b);
				this.add(answer4c);
				 this.add(answer4d);
			 }
			if(random == 5)
			{
				 this.add(answer5a);
				 this.add(answer5b);
				this.add(answer5c);
				 this.add(answer5d);
			 }
			if(random == 6)
			{
				 this.add(answer6a);
				 this.add(answer6b);
				this.add(answer6c);
				 this.add(answer6d);
			 }
			if(random == 7)
			{
				 this.add(answer7a);
				 this.add(answer7b);
				this.add(answer7c);
				 this.add(answer7d);
			 }
			if(random == 8)
			{
				 this.add(answer8a);
				 this.add(answer8b);
				this.add(answer8c);
				 this.add(answer8d);
			 }
			 // add buttons to panel and button group
			 }
			public void actionPerformed(ActionEvent evt)
			{
				 String command = evt.getActionCommand();
				// picks up string identifier thats labeled on the button
				 if(command.equals("the bones of the skull") || command.equals("smooth muscle") || command.equals("arteries to capillaries to veins") || command.equals("adrenal gland") || command.equals("remove water from digested food") || command.equals("feedback mechanisms") || command.equals("alveolus into blood") || command.equals("sodium and potassium ion through the cell membrane"))
				{
					 cards.show(c, "Panel 3");
					 answerwin = true;
				 }
				 if(command.equals("the bones of the elbow joint") || command.equals("striated muscle") || command.equals("capillaries to arteries to veins") || command.equals("pituitary gland") || command.equals("remove wastes from digested food") || command.equals("excretory system") || command.equals("capillaries into veins") || command.equals("neurotransmitters through the cell membrane"))
				 {
					 cards.show(c, "Panel 3");
					 answerlose = false;
				 }
				 if(command.equals("the ribs and vertebrae") || command.equals("voluntary muscle") || command.equals("veins to capillaries to arteries") || command.equals("pancreas") || command.equals("absorb sugars from digested food") || command.equals("homeostasis") || command.equals("blood into the alveolus") || command.equals("sodium and potassium ions along the cell membrane"))
				{
					 cards.show(c, "Panel 3");
					 answerlose = false;
				 }
				 if(command.equals("the bones of the hip joint") || command.equals("skeletal muscle")|| command.equals("arteries to veins to capillaries") || command.equals("thyroid gland")|| command.equals("absorb mineral from digested food") || command.equals("nervous system") || command.equals("arteries into the capillaries") || command.equals("neurotransmitters along the cell membrane"))
				 {
					 cards.show(c, "Panel 3");
					answerlose = false;
				 }
			}
		}
	 }
	 // seperate win/lose panel to simplify things
	class DrawPanel3 extends JPanel
	 {
		 public DrawPanel3()
		{}
		 public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			 if(!answerlose)
			 {
				g.drawImage(goose, 10,10, 400, 300, this);
				 g.setColor(Color.red);
				 g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("INCORRECT!", 10, 340);
				 g.drawString(" SILLY GOOSE, YOU LOSE!!!", 10, 360);
				 g.drawString("RUN THIS GAME AGAIN TO WIN!", 10, 380);

			 }
				 else if(answerlose)
				 {
					g.setColor(Color.green);
					 g.setFont(new Font("Arial", Font.BOLD, 200));
					g.drawString("YOU", 10, 200);
					g.drawString("WIN!" , 10, 400);
				 }
		}
	 }
	 // instructions panel
	 class DrawPanel4 extends JPanel implements ActionListener//, AdjustmentListener
	 {
		 JButton go, proceed;
		 JTextArea quoteText;
		  public DrawPanel4()
		 {
			 this.setLayout(null);
			 go = new JButton ("BACK");
			go.addActionListener(this);
			go.setSize(200,200);
			go.setLocation(10,10);
			this.add(go);
			  proceed = new JButton("MOVE ON");
			 proceed.addActionListener(this);
			 proceed.setSize(200,200);
			 proceed.setLocation(220,10);
			 this.add(proceed);
		 }
		public void actionPerformed(ActionEvent evt)
		 {
			  String command = evt.getActionCommand();
			 if(command.equals("BACK"))
			 {
				 cards.show(c, "Panel 1");
			}
			if(command.equals("MOVE ON"))
			{
				cards.show(c, "Panel 5");
			}
		  }
		 public void paintComponent(Graphics g)
		  {
			  // JTEXTAREA
			  // USE IT TO PRINT INSTRUCTIONS
			 super.paintComponent(g);
			  g.setFont(new Font("Arial", Font.BOLD, 20));
			  quoteText = new JTextArea();
			   quoteText.setLineWrap(true); // let the sentence go to the next line
				quoteText.setSize(550,100); // set the size of the text box
				quoteText.setLocation(20,220);
				 quoteText.setEditable(false); // do not let the user edit the quote
				 quoteText.setText("Welcome to Animal Throwdown! Your journey into the WILD WEST begins here! Use your arrow keys to navigate through the crops. Be sure to avoid the pigs. If you step on them, you will have to answer a question to help the doctor save the pig's life. ");
				add(quoteText);
			   g.drawImage(arrow,0, 300, 400, 300, this);
		}
	   }

	class DrawPanel5 extends JPanel implements ActionListener
	{
		JButton home;
		public DrawPanel5()
		{
			 this.setLayout(new BorderLayout());
			 home = new JButton ("HOME");
			home.addActionListener(this);
			this.add(home, BorderLayout.EAST);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString("You are the farmer.", 10, 20);
			g.drawImage(farmer, 60, 60, 200, 200, this);
			g.drawString("You are trying to get all the crops!", 10, 280);
			g.drawImage(corn, 10, 300, 200, 200, this);
			g.drawString("You don't want to hit the pigs!", 300, 20);
			g.drawImage(pigbug, 300, 50, 200, 200, this);
			g.drawString("Answer a question if you hit a pig", 300, 270);
			g.drawString("Answer right - YOU WIN!", 300, 300);
			g.drawString("Answer wrong - YOU LOSE!", 300, 330);
			g.drawString("GOOD LUCK!", 300, 360);
		}
		public void actionPerformed(ActionEvent evt)
	 	{
			  String command = evt.getActionCommand();
			 if(command.equals("HOME"))
			 {
			 	cards.show(c, "Panel 1");
			 }
		}
	}
	// level deciding panel
	// easy - pigs can move only left or right or up or down from their spot
	// medium - they can move 2 spots left, right, up, or down
	// hard - THEY CAN BE ANYWHERE! VERY TOUGH LOGIC IF YOU WANT TO USE IT.
	class DrawPanel6 extends JPanel implements ActionListener
	{
		JButton easy, medium, hard;
		public DrawPanel6()
		{
			this.setLayout(null);

			 easy = new JButton ("EASY: pigs placed left/right/up/down");
			easy.addActionListener(this);
			easy.setLocation(0,0);
			easy.setSize(600,200);
			this.add(easy);

			medium = new JButton ("MEDIUM: pigs placed 2 spots left/right/up/down - more random");
			medium.addActionListener(this);
			medium.setLocation(0,200);
			medium.setSize(600,200);
			this.add(medium);

			hard = new JButton ("HARD: randomly placed pigs");
			hard.addActionListener(this);
			hard.setLocation(0,400);
			hard.setSize(600,200);
			this.add(hard);

		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
		}
		public void actionPerformed(ActionEvent evt)
	 	{
			  String command = evt.getActionCommand();
			 if(command.equals("EASY: pigs placed left/right/up/down"))
			 {
			 	cards.show(c, "MyPanel");
			 	leveleasy = true;
			 	canvas.requestFocus();
			 }
			 if(command.equals("MEDIUM: pigs placed 2 spots left/right/up/down - more random"))
			 {
			 	cards.show(c, "MyPanel");
			 	levelmedium = true;
			 	canvas.requestFocus();
			 }
			 if(command.equals("HARD: randomly placed pigs"))
			 {
			 	cards.show(c, "MyPanel");
			 	levelhard = true;
			 	canvas.requestFocus();
			 }
		}
	}
}
