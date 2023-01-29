package prime_numbers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrimenum;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField prime_num;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	static float sec;
	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(60);
        }
        long end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        sec = sec / 1000;
		
	}

	/**
	 * Create the frame.
	 */
	public mainFrame() {
		setTitle("GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(314, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblBufferSize = new JLabel("Buffer size");
		lblBufferSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBufferSize.setBounds(314, 48, 84, 14);
		contentPane.add(lblBufferSize);
		
		JLabel lblNewLabel_1_1 = new JLabel("Output file");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(314, 92, 84, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtPrimenum = new JTextField();
		txtPrimenum.setBounds(62, 10, 86, 20);
		contentPane.add(txtPrimenum);
		txtPrimenum.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(62, 47, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(62, 91, 86, 20);
		contentPane.add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(314, 212, 84, 22);
		contentPane.add(textArea);
		
		prime_num = new JTextField();
		prime_num.setBounds(312, 251, 86, 20);
		contentPane.add(prime_num);
		prime_num.setColumns(10);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(314, 287, 84, 22);
		contentPane.add(textArea_1_1);
		
		
		JButton btnNewButton = new JButton("Start produce");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bufferSize = Integer.parseInt(textField_1.getText());
				Buffer B = new Buffer(bufferSize);
				int n = Integer.parseInt(txtPrimenum.getText());
				Producer p = new Producer(B, n);
				String Filename = (textField_2.getText());
				Consumer c = new Consumer(B, Filename);
				
				Thread t1 = new Thread(p);
				Thread t2 = new Thread(c);
				t1.start();
				t2.start();
				
//				if(!t1.isAlive()) {
//					
//				}
				textArea.setText(String.valueOf(p.maxPrime));
				prime_num.setText(String.valueOf(p.numOfPrime));
			
				textArea_1_1.setText(String.valueOf(sec));
				
					
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(41, 137, 127, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("The largest prime number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(41, 213, 210, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("#of elements (prime number) generated");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(41, 253, 272, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Time elapsed since the start of processing");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(41, 291, 272, 14);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		
		
	}
}
