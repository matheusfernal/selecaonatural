package com.gangobana.selecaonatural;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.gangobana.selecaonatural.presentationmodel.PrincipalPresentationModel;
import com.gangobana.selecaonatural.view.JanelaPrincipal;

public class Main
{
	private static JFrame mainWindow;

	public static void main(String[] args)
	{
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (UnsupportedLookAndFeelException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		PrincipalPresentationModel pm = new PrincipalPresentationModel(null);

		mainWindow = new JanelaPrincipal(pm);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}

	public static JFrame getMainWindow()
	{
		return mainWindow;
	}
}
