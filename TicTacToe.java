import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;




public class TicTacToe implements ActionListener {

	JFrame frame = new JFrame();
	JButton [][] button = new JButton[3][3];
	int [][] board = new int[3][3];
	final int BLANK = 0;
	final int x_MOVE = 1;
	final int o_MOVE = 1;
	final int x_TURN = 0;
	final int o_TURN = 1;
	int turn = x_TURN;
	int marks = 0; 
	int computerWin = 0;
	int playerWin = 0;
	int draw = 0;
	int howmanyPlayed = 0;
	Container center= new Container();
	JLabel xname = new JLabel ("Player wins:0");
	JLabel oname = new JLabel ("Computer wins:0");
	JLabel drawplay = new JLabel ("Draw:0");
	JLabel totalPlay = new JLabel ("Total Game Played:0");
	JButton xChangeName = new JButton ("Change x's Name");
	JButton oChangeName = new JButton ("Change O's Name");
	JTextField xChangeField = new JTextField();
	JTextField oChangeField = new JTextField();
	
	Container north = new Container();
	
	public TicTacToe(){
		frame.setSize(400,400);
		// Center grid container
		
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
	    for (int i = 0; i < button.length; i++){
	    	for (int j = 0; j < button[0].length; j++){
	    		button[j][i] = new JButton ();
	    		center.add(button[j][i]);
	    		button[j][i].addActionListener(this);
	    		board[j][i] = 0;
	    		/*button[j][i].setText(j+" "+i);*/
	    	}
	    	
	    }
	    frame.add(center, BorderLayout.CENTER);
	    //North container
	    north.setLayout(new GridLayout(4,2));
	    north.add(xname);
	    north.add(oname);
	    north.add(drawplay);
	    north.add(totalPlay);	    
	    north.add(xChangeName);
	    xChangeName.addActionListener(this);
	    north.add(oChangeName);
	    oChangeName.addActionListener(this);
	    north.add(xChangeField);
	    north.add(oChangeField);
	    
	    frame.add(north, BorderLayout.NORTH);
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		}
	
	public static void main(String[] args) {
		new TicTacToe();
		
		}


	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton current, computerCurrent;
		howmanyPlayed++;
		
		boolean gridButton = false;
		for (int i = 0; i < 3; i++){
	    	for (int j = 0; j < 3; j++){ 
	    		if (event.getSource().equals(button[j][i])){
	    			gridButton = true;
	    			current = button[j][i];
		    			if (board[j][i] == 0){
		    			if (turn == x_TURN){
		    				current.setText("X");
		    				marks ++;
		    				//System.out.println(marks);
		    				current.setEnabled(false);
		    				board[j][i]= x_MOVE;
		    				System.out.println("Board no" + board[j][i]);
		    				turn = o_TURN;
		    				boolean generated = true;
		    				int[] i_array = { 0, 1, 2};
		    				int[] j_array = { 0, 1, 2};
			    			while(generated){
			    				shuffleArray(i_array);
			    				shuffleArray(j_array);
				    			if (board[j_array[0]][i_array[0]] == 0){
				    				computerCurrent = button[j_array[0]][i_array[0]];
				    				generated = false;
				    				computerCurrent.setText("O");
				    				marks ++;
				    				computerCurrent.setEnabled(false);
				    				board[j_array[0]][i_array[0]]= x_MOVE;
				    				turn = x_TURN;
				    				System.out.println("True "+j_array[0]+" "+i_array[0]);
				    			}else{
				    				generated = true;
				    				System.out.println(j_array[0]+" "+i_array[0]);
				    			}
				    			
				    			//System.out.println(j_array[0]+' '+i_array[0]);
			    			}   				
		    				
		    			}

	    			}
	    		  }
	    		if (gridButton == false){
	    			if (event.getSource().equals(xChangeName) == true){
	    				xChangeField.setText("X Change");
	    			}
	    			else if (event.getSource().equals(oChangeName) == true){
	    				oChangeField.setText("O Change");
	    				
	    			}
	    			
	    		}
	    		}
	    	}
		
		
		if (marks >= 6) {
			if ( (button[0][0].getText()=="X" && button[0][1].getText()=="X" &&  button[0][2].getText()=="X") ||
				(button[1][0].getText()=="X" && button[1][1].getText()=="X" &&  button[1][2].getText()=="X") ||
				(button[2][0].getText()=="X" && button[2][1].getText()=="X" &&  button[2][2].getText()=="X") ||
				(button[0][0].getText()=="X" && button[1][0].getText()=="X" &&  button[2][0].getText()=="X") ||
				(button[0][1].getText()=="X" && button[1][1].getText()=="X" &&  button[2][1].getText()=="X") ||
				(button[0][2].getText()=="X" && button[1][2].getText()=="X" &&  button[2][2].getText()=="X") ||
				(button[0][0].getText()=="X" && button[1][1].getText()=="X" &&  button[2][2].getText()=="X") ||
				(button[0][2].getText()=="X" && button[1][1].getText()=="X" &&  button[2][0].getText()=="X")){
				
					playerWin++;
					xname.setText("Player win: "+playerWin);
					totalPlay.setText("Total Game Played: "+(playerWin+computerWin+draw));
					JOptionPane.showMessageDialog(null, "congratulations! " +   " You Won!");
					newgame();
					
					
				
			
			}
				
			else if ( (button[0][0].getText()=="O" && button[0][1].getText()=="O" &&  button[0][2].getText()=="O") ||
						(button[1][0].getText()=="O" && button[1][1].getText()=="O" &&  button[1][2].getText()=="O") ||
						(button[2][0].getText()=="O" && button[2][1].getText()=="O" &&  button[2][2].getText()=="O") ||
						(button[0][0].getText()=="O" && button[1][0].getText()=="O" &&  button[2][0].getText()=="O") ||
						(button[0][1].getText()=="O" && button[1][1].getText()=="O" &&  button[2][1].getText()=="O") ||
						(button[0][2].getText()=="O" && button[1][2].getText()=="O" &&  button[2][2].getText()=="O") ||
						(button[0][0].getText()=="O" && button[1][1].getText()=="O" &&  button[2][2].getText()=="O") ||
						(button[0][2].getText()=="O" && button[1][1].getText()=="O" &&  button[2][0].getText()=="O")){
	
					computerWin++;
					oname.setText("Computer win: "+computerWin);	
					totalPlay.setText("Total Game Played: "+(playerWin+computerWin+draw));
					JOptionPane.showMessageDialog(null, "Sorry! " +   " Computer Won!");
					newgame();
					
				}
			else if(marks >= 8){
				JOptionPane.showMessageDialog(null, "Sorry! " +   " It's a Draw!");				
				draw++;
				totalPlay.setText("Total Game Played: "+(playerWin+computerWin+draw));
				drawplay.setText("Draw: "+draw);
				newgame();				
			}
				
				
			}
				
				
		}		

	
	@SuppressWarnings("null")
	private void newgame(){
	    for (int i = 0; i < button.length; i++){
	    	for (int j = 0; j < button[0].length; j++){
	    		button[j][i].setEnabled(true);
	    		button[j][i].setText("");
	    		//board[j][i] = (Integer) null;
	    		
	    		marks = 0; 
	    		turn = x_TURN;
	    	}
	    	
	    }
	    board = new int[3][3];
	}
	
	  // Implementing Fisher–Yates shuffle
	  static void shuffleArray(int[] ar)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }	
}
