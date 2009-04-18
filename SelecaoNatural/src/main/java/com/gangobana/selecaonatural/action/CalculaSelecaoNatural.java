package com.gangobana.selecaonatural.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jgoodies.binding.value.ValueModel;

public class CalculaSelecaoNatural implements ActionListener
{
    // Objeto que gerar� os valores aleat�rios
	private Random random;
	
	// A frase digitada pelo usu�rio
    private ValueModel frase;
    
    private ValueModel log;
    private ValueModel resultado;
    
    public CalculaSelecaoNatural(ValueModel frase, ValueModel log, ValueModel resultado, Random random)
    {
        this.frase = frase;
        this.log = log;
        this.resultado = resultado;
        this.random = random;
    }
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Limpa o log
		log.setValue("");
		
		// A frase digitada como uma String
		String frase = (String) this.frase.getValue();
		
		// Lista contendo os caracters da frase sem repeti��o
        List<Character> caracteresPossiveis = new ArrayList<Character>();
        
        // Preenche a lista de caracteres poss�veis
        for (int i = 0; i < frase.length(); i++)
        {
            if (!caracteresPossiveis.contains(frase.charAt(i)))
            {
                caracteresPossiveis.add(frase.charAt(i));
            }
        }
        
        /**
         * Cada posi��o do array encontrou corresponde a uma letra
         * da frase digitada pelo usu�rio. Caso o progrma tenha sorteado
         * corretamente a letra correspondente � posi��o i do array, seu valor ser�
         * true, caso contr�rio ser� false.
         */
        boolean[] encontrou = new boolean[frase.length()];
        
        char[] fraseRodada = new char[frase.length()];
        
        // Inicialmente nenhuma letra foi encontrada
        for (int i = 0; i < encontrou.length; i++)
        {
            encontrou[i] = false;
        }
        
        // Contador da quantidade de loops necess�rios para escrever a frase
        long contaLoop = 0;
        
        // Loop principal
        while (faltaEncontrarAlgum(encontrou))
        {
            // Percorre a frase
            for (int i = 0; i < encontrou.length; i++)
            {
                // Se o caractere ainda n�o foi encontrado
                if (!encontrou[i])
                {   
                    // Sorteia um caractere dentre os poss�veis
//                    int indiceSorteado = random.nextInt(caracteresPossiveis.size());
                	int indiceSorteado = random.nextInt(256);
                    //System.out.println(indiceSorteado);
//                    char sorteado = caracteresPossiveis.get(indiceSorteado);
                	char sorteado = (char) indiceSorteado;
                    
                    //Escreve no array fraseRodada
                    fraseRodada[i] = sorteado; 
                    
                    // Se o caractere sorteado casou com o caractere correspondente na frase...
                    if (sorteado == frase.charAt(i))
                    {
                        encontrou[i] = true;
                    }
                }                
            }
            
            imprimeFrase(fraseRodada);
            
            // Incrementa a quantidade de vezes que a frase foi percorrida
            contaLoop++;
        }
        
        //Seta o resultado
        resultado.setValue("A frase foi formada em " + contaLoop + " itera��es");
	}

    private void imprimeFrase(char[] fraseRodada)
	{
    	final StringBuffer textoLog = new StringBuffer(log.getValue().toString()); 
    	
		for (char c : fraseRodada)
		{
			textoLog.append(c);
		}
		textoLog.append('\n');
		log.setValue(textoLog.toString());
	}

	/**
     * Retorna true se ainda falta encontrar algum caractere da frase, ou false
     * se todos tiverem sido encontrados
     * 
     * Possibilidade de melhoria: Esse m�todo � O(n), onde n � o tamanho da frase,
     * para que o tempo de execu��o seja mais preciso, ele deveria ser O(1), pois
     * ele � executado a cada itera��o pela frase.
     * @param encontrou
     * @return true se ainda falta encontrar algum caractere da frase, ou false
     * se todos tiverem sido encontrados
     * 
     */
    private boolean faltaEncontrarAlgum(boolean[] encontrou)
    {
        for (boolean b : encontrou)
        {
            if (b == false)
            {
                // Ainda falta encontrar algum
                return true;
            }
        }
        
        // Todos foram encontrados
        return false;
    }
}
