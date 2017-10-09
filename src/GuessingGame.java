import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int thereferenceNumber;
	
	public void checkGuess(){
		String guessTxt= txtGuess.getText();
		String message= "";
		
		int guessedNumber= Integer.parseInt(guessTxt);
		
		if(guessedNumber>thereferenceNumber){
			message= guessedNumber + "Your guess was too high ";
			lblOutput.setText(message);
		}
		else if(guessedNumber<thereferenceNumber){
			message= guessedNumber + "Your guess was too low ";
			lblOutput.setText(message);
		}
		else{
			message= guessedNumber+ "your guess is right, you win, lets play again";
			lblOutput.setText(message);
			GenerateRandomNumber();
		}
		
	}
	
	public void GenerateRandomNumber(){
		thereferenceNumber=(int)(Math.random()*100+1);
	}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		
		JLabel lblGuessingGame = new JLabel(" Guessing Game");
		lblGuessingGame.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblGuessingGame.setBounds(6, 6, 438, 27);
		lblGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGuessingGame);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 53, 444, 70);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
		lblGuessANumber.setBounds(42, 26, 224, 16);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateRandomNumber();
			}
		});
		txtGuess.setBounds(308, 21, 101, 32);
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(135, 143, 117, 27);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess");
		lblOutput.setBackground(new Color(238, 238, 238));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(53, 190, 310, 16);
		getContentPane().add(lblOutput);
	}

	
	
	public static void main(String[] args) {
		
		GuessingGame thegame = new GuessingGame();
		thegame.GenerateRandomNumber();
		thegame.setSize(430, 330);
		thegame.setVisible(true);

	}
}
