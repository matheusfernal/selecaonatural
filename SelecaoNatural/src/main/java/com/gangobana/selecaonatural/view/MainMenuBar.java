package com.gangobana.selecaonatural.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.gangobana.selecaonatural.presentationmodel.PrincipalPresentationModel;

public class MainMenuBar extends JMenuBar
{	
	private static final long serialVersionUID = -2748745781532905340L;

	private PrincipalPresentationModel pm;
	
	private JMenu acoesMenu;
	private JMenuItem calcularMenuItem;
	private JMenuItem resetarMenuItem;
	
	private JMenu ajuda;
	private JMenuItem sobre;
	
	public MainMenuBar(PrincipalPresentationModel pm)
	{
		this.pm = pm;
		
		createComponents();
	}

	private void createComponents()
	{
		calcularMenuItem = new JMenuItem("Calcular");
		calcularMenuItem.addActionListener(pm.getCalculaSelecaoNaturalActionListener());
		resetarMenuItem = new JMenuItem("Resetar Gerador de Aleatoriedade");
		resetarMenuItem.addActionListener(pm.getResetaGeradorAleatorioActionListener());
		acoesMenu = new JMenu("Ações");
		acoesMenu.setMnemonic('a');
		acoesMenu.add(calcularMenuItem);
		acoesMenu.add(resetarMenuItem);
		
		sobre = new JMenuItem("Sobre");
		sobre.addActionListener(pm.getAbrirSobreActionListener());
		ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('u');
		ajuda.add(sobre);
		
		this.add(acoesMenu);
		this.add(ajuda);
	}
}
