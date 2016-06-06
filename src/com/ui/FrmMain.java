package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.data.FilterService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FrmMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 48609790088363563L;
	private JPanel contentPane;
	private JTextField txtInput;

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
	
	private class ExportToNewActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			File fin = new File(txtInput.getText());
			File fout = new File(fin.getParentFile().getAbsolutePath() + "\\phone.txt");
			
			FilterService filterService = new FilterService();
			filterService.exportToFile(fin, fout);
		}
		
	}
	
	private class FixInsideActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			File fin = new File(txtInput.getText());
			FilterService filterService = new FilterService();
			filterService.fixInsideFile(fin);
		}
		
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
		
		JButton btnExportToNew = new JButton("Export to new file");
		btnExportToNew.addActionListener(new ExportToNewActionListener());
		btnExportToNew.setBounds(49, 111, 151, 23);
		contentPane.add(btnExportToNew);
		
		JButton btnFile = new JButton("...");
		btnFile.addActionListener(new SelectFileActionListener());
		btnFile.setBounds(339, 19, 56, 23);
		contentPane.add(btnFile);
		
		JButton btnFixInside = new JButton("Fix inside");
		btnFixInside.addActionListener(new FixInsideActionListener());
		btnFixInside.setBounds(259, 111, 136, 23);
		contentPane.add(btnFixInside);
	}
}
