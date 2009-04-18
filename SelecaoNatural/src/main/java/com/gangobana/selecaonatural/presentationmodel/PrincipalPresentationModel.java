package com.gangobana.selecaonatural.presentationmodel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JFrame;

import com.gangobana.selecaonatural.action.CalculaSelecaoNatural;
import com.gangobana.selecaonatural.view.Sobre;
import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;

public class PrincipalPresentationModel extends PresentationModel<Object>
{
	private static final long serialVersionUID = -4285584064504014868L;
	
	private ValueModel fraseValueModel;
	private ValueModel logValueModel;
	private ValueModel resultadoValueModel;
	
	private Random random;
	
	public PrincipalPresentationModel(Object bean)
	{
		super(bean);
		
		fraseValueModel = new ValueHolder("");
		logValueModel = new ValueHolder("");
		resultadoValueModel = new ValueHolder(" ");
		
		random = new Random();
	}

	public ValueModel getFraseValueModel()
	{
		return fraseValueModel;
	}
	
	public ValueModel getLogValueModel()
	{
		return logValueModel;
	}
	
	public ValueModel getResultadoValueModel()
	{
		return resultadoValueModel;
	}
	
	public ActionListener getCalculaSelecaoNaturalActionListener()
	{
		return new CalculaSelecaoNatural(fraseValueModel, logValueModel, resultadoValueModel, random);
	}
	
	public ActionListener getResetaGeradorAleatorioActionListener()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				random.setSeed(Calendar.getInstance().getTimeInMillis());
			}
		};
	}
	
	public ActionListener getAbrirSobreActionListener()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFrame sobre = new Sobre();
				sobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				sobre.setResizable(false);
				sobre.pack();
				sobre.setVisible(true);
			}
		};
	}
}
