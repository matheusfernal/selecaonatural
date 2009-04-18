package com.gangobana.selecaonatural.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.apple.mrj.MRJAboutHandler;
import com.gangobana.selecaonatural.presentationmodel.PrincipalPresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class JanelaPrincipal extends JFrame implements MRJAboutHandler
{
	private static final long serialVersionUID = -6401536888255250902L;
	
	// Componentes da visão
	private JTextField fraseTextField;
	private JButton calcularBtn;
	private JTextArea logTextArea;
	private JLabel resultadoLabel;
	
	private PrincipalPresentationModel pm;
	
	public JanelaPrincipal(PrincipalPresentationModel pm)
	{
		super("Seleção Natural");
		
		this.pm = pm;
		
		createComponents();
		addListeners();
		buildLayout();
	}

	private void createComponents()
	{
		fraseTextField = BasicComponentFactory.createTextField(pm.getFraseValueModel(), false);
		fraseTextField.setColumns(30);
		
		logTextArea = BasicComponentFactory.createTextArea(pm.getLogValueModel(), false);
		logTextArea.setRows(7);
		logTextArea.setColumns(30);
		logTextArea.setEditable(false);
		logTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		
		resultadoLabel = BasicComponentFactory.createLabel(pm.getResultadoValueModel());
		
		calcularBtn = new JButton("Calcular");
	}

	private void addListeners()
	{
		calcularBtn.addActionListener(pm.getCalculaSelecaoNaturalActionListener());
	}

	private void buildLayout()
	{
		CellConstraints cc = new CellConstraints();
		
		FormLayout layout = new FormLayout(
			"fill:pref:grow", // Colunas
			"pref, 3dlu, pref, 3dlu, fill:pref:grow, 3dlu, pref, 5dlu, pref" // Linhas
		);
		
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		
		builder.addLabel("Digite uma frase:", cc.xy(1, 1));
		builder.add(fraseTextField, cc.xy(1, 3));
		builder.add(new JScrollPane(logTextArea), cc.xy(1, 5));
		builder.add(resultadoLabel, cc.xy(1, 7));
		builder.add(ButtonBarFactory.buildOKBar(calcularBtn), cc.xy(1, 9));
		
		this.setLayout(new BorderLayout());
		
		this.add(new MainMenuBar(pm), BorderLayout.NORTH);
		this.add(builder.getPanel(), BorderLayout.CENTER);
	}

	@Override
	public void handleAbout()
	{
		JFrame sobre = new Sobre();
		sobre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		sobre.setResizable(false);
		sobre.pack();
		sobre.setVisible(true);
	}
}
