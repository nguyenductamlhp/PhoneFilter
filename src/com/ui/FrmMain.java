package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;

public class FrmMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 48609790088363563L;
	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtOutput;

	private class SelectFileActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			JFileChooser jFileChooser = new JFileChooser();
			int value = jFileChooser.showOpenDialog(null);
			if (value == JFileChooser.APPROVE_OPTION) {
				File f = jFileChooser.getSelectedFile();
				txtInput.setText(f.getAbsolutePath());
			}		
		}		
	}
	
	private class FilterPhoneActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			File fin = new File(txtInput.getText());
			File fout = new File(fin.getParentFile().getAbsolutePath() + "\\phone.txt");
			txtOutput.setText(fout.getAbsolutePath());
			
			FileInputStream fileInputStream;
			FileOutputStream fileOutputStream;
			
			try {
				fileInputStream = new FileInputStream(fin);
				BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
				
				fileOutputStream = new FileOutputStream(fout);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
				
				String lineIn;
				while ((lineIn = reader.readLine()) != null) {
					lineIn = lineIn.trim();
					String subLine[] = lineIn.split("[/,]");
					String lineOut = subLine[subLine.length - 1];
					lineOut = deleteSpace(lineOut);
					writer.write(lineOut + " \n");
					writer.flush();
				}
				
				reader.close();
				writer.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error read or write file");
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	private static String deleteSpace(String S) {
		String out = S.trim();
		out = out.replaceAll("[ ]", "");
		return out;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
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
	public FrmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(10, 20, 80, 20);
		contentPane.add(lblInput);
		
		txtInput = new JTextField();
		txtInput.setBounds(135, 20, 194, 20);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(10, 89, 80, 20);
		contentPane.add(lblOutput);
		
		txtOutput = new JTextField();
		txtOutput.setColumns(10);
		txtOutput.setBounds(135, 89, 260, 20);
		contentPane.add(txtOutput);
		
		JButton btnFilt = new JButton("Filt");
		btnFilt.addActionListener(new FilterPhoneActionListener());
		btnFilt.setBounds(158, 155, 89, 23);
		contentPane.add(btnFilt);
		
		JButton btnFile = new JButton("...");
		btnFile.addActionListener(new SelectFileActionListener());
		btnFile.setBounds(339, 19, 56, 23);
		contentPane.add(btnFile);
	}
}
