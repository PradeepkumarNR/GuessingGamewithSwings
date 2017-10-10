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
import java.awt.Dimension;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int thereferenceNumber;
	private int triesleft = 7;

	public void checkGuess() {
		String guessTxt = txtGuess.getText();
		String message = "";

		try {
			int guessedNumber = Integer.parseInt(guessTxt);
			triesleft--;

			if (guessedNumber > thereferenceNumber) {
				message = guessedNumber + "Your guess was too high " + "you have " + triesleft + "tries left";
				lblOutput.setText(message);
			} else if (guessedNumber < thereferenceNumber) {
				message = guessedNumber + "Your guess was too low " + "you have " + triesleft + "tries left";
				lblOutput.setText(message);
			} else {
				message = guessedNumber + "your guess is right, you win, lets play again";
				lblOutput.setText(message);
				GenerateRandomNumber();
			}
			if (triesleft <= 0) {
				javax.swing.JOptionPane.showConfirmDialog(null, "Sorry, you ran out of all tries, the number was "
						+ thereferenceNumber + "do you want to play again?");
				
				GenerateRandomNumber();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block

			lblOutput.setText("please enter a whole number between 1 to 100");
		} finally {
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	public void GenerateRandomNumber() {
		thereferenceNumber = (int) (Math.random() * 100 + 1);
		triesleft = 7;
	}

	public GuessingGame() {
		setTitle("Guessing Game ");
		getContentPane().setBackground(new Color(0, 153, 204));
		setBackground(new Color(51, 153, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		getContentPane().setLayout(null);

		JLabel lblGuessingGame = new JLabel(" Guessing Game");
		lblGuessingGame.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblGuessingGame.setBounds(6, 6, 438, 27);
		lblGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGuessingGame);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 255, 255));
		panel.setBounds(18, 60, 401, 55);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
		lblGuessANumber.setBounds(42, 26, 224, 16);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);

		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});

		txtGuess.setBounds(283, 15, 101, 32);
		panel.add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess");
		btnGuess.setBackground(new Color(153, 102, 51));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(135, 143, 117, 27);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above  you have 7 TRIES and click Guess");
		lblOutput.setBackground(new Color(238, 238, 238));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(42, 190, 364, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {

		GuessingGame thegame = new GuessingGame();
		thegame.GenerateRandomNumber();
		thegame.setSize(new Dimension(430, 330));
		thegame.setVisible(true);

	}

}
