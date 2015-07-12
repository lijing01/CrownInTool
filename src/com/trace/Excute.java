package com.trace;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Excute extends javax.swing.JDialog implements ActionListener, WindowListener{

	private JPanel contentPane;
	private JButton centreButton;
	private JTextPane jText;

	public Excute() {
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		this.centreButton = new JButton(" Start ");
		this.jText = new JTextPane();
		this.contentPane.add(centreButton, BorderLayout.CENTER);
		this.contentPane.add(jText, BorderLayout.SOUTH);
		centreButton.addActionListener(this);

		this.setTitle("CrownIn");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Excute example = new Excute();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		FileTool fileTool = new FileTool();
		fileTool.deliverFile();
	
		String configPath = FileTool.getJarRootPath()+"\\config.json";
		
		String androidOriginalFileName =FileTool.getJarRootPath() + "\\"+ FileTool.filepath;
		
		jText.setText(FileTool.getJarRootPath()+ " " + configPath + " "+androidOriginalFileName);
	}
	

	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
