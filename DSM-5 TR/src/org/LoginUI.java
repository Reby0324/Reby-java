//UI
package org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userName;
	private JTextField passWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel.setBounds(104, 86, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_1.setBounds(104, 128, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		userName = new JTextField();
		userName.setBounds(160, 85, 149, 21);
		contentPane.add(userName);
		userName.setColumns(10);
		
		passWord = new JTextField();
		passWord.setBounds(160, 127, 149, 21);
		contentPane.add(passWord);
		passWord.setColumns(10);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取 userName,passWord-->getText
				 * 2.name , name-->equals
				 * 3.true--->LoginSuccess 
				 * 4.false--->LoginError
				 */
				
				String UserName=userName.getText().trim();
				String PassWord=passWord.getText().trim();
				if(userName.equals("name")&&PassWord.equals(1111))
				{
					LoginSuccess loginSuccess=new LoginSuccess();
					loginSuccess.setVisible(true);
					dispose();
				}
				else
				{
					LoginError loginError=new LoginError();
					loginError.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(178, 206, 87, 23);
		contentPane.add(btnNewButton);
		

	}
}
