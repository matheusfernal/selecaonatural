package com.gangobana.selecaonatural.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class Sobre extends JFrame
{
	private static final long serialVersionUID = -5523131903646003534L;
	
	private JLabel icone;
	private JLabel selecaoNatural;
	private JLabel versao;
	private JLabel desenvolvedor;
	private JLabel email;
	
	public Sobre()
	{
		createComponents();
		buildLayout();
	}
	
	private void createComponents()
	{
		icone = new JLabel();
		
		selecaoNatural = new JLabel("Seleção Natural", SwingConstants.CENTER);
		selecaoNatural.setFont(new Font("", Font.PLAIN, 20));
		
		versao = new JLabel("Versão 0.4 Beta", SwingConstants.CENTER);
		
		desenvolvedor = new JLabel("Desenvolvido por Matheus Andrade Fernal", SwingConstants.CENTER);
		
		email = new JLabel("matheusfernal@gmail.com", SwingConstants.CENTER);
		
	}

	private void buildLayout()
	{
		CellConstraints cc =new CellConstraints();
		
		FormLayout layout = new FormLayout(
			"pref",
			"center:pref, 10dlu, center:pref, 5dlu, center:pref, 5dlu, center:pref, center:pref"
		);
		
		DefaultFormBuilder builder = new DefaultFormBuilder (layout);
		builder.setDefaultDialogBorder();
		
		builder.add(icone, cc.xy(1, 1));
		builder.add(selecaoNatural, cc.xy(1, 3));
		builder.add(versao, cc.xy(1, 5));
		builder.add(desenvolvedor, cc.xy(1, 7));
		builder.add(email, cc.xy(1, 8));
		
		this.add(builder.getPanel());		
	}
}
