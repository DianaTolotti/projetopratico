package br.com.diana.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoCSV {
	
	 public static void main(String[] args) {
		String csvArquivo = "C:\\Users\\Diana\\Desktop\\Techno\\GitHub\\cidades.csv";
		
		BufferedReader conteudoCSV = null;
		
		String linha = "";
		
		String csvSeparadorCampo = ",";
		
		
		/*String csvArquivo = "C:\\Users\\User\\Downloads\\QI\\_WEB-III\\WebService\\BaseDeDados\\Carros.csv";
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";
        
        ArrayList leituraCSV = new ArrayList();
            
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
                      
           while((linha = conteudoCSV.readLine()) != null) {
            
                String[] campo = linha.split(csvSeparadorCampo);
                
                    Carro car = new Carro(campo[0], campo[1], campo[2]);
                    leituraCSV.add(car);
                    //i++;
            }
        
        Gson formatoJson = new Gson();    
        
        return formatoJson.toJson(leituraCSV);*/
		
		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
			while ((linha = conteudoCSV.readLine()) != null) {
				String [] cidade = linha.split(csvSeparadorCampo);
				
				
				System.out.println(
						" [Id IBGE = " + cidade[0] +
						" UF = " + cidade[1] +
						" Nome = " + cidade[2] +
						" Capital = " + cidade[3] +
						" Longitude = " + cidade[4]+
						" Latitude = " + cidade[5]+
						" Nome s/ acentos = " + cidade[6]+
						" Nome Alternativo = " + cidade[7]+
						" Micro Região = " + cidade[8] +
						" Meso região = " + cidade[9] + "]");
			}
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado. \n"+e.getMessage());
		}catch (IOException e) {
			System.out.println("IO Erro: \n"+e.getMessage());
	 }finally {
		 if (conteudoCSV != null) {
			 try {
				 conteudoCSV.close();
			}catch (IOException e) {
				System.out.println("IO Erro: \n"+e.getMessage());
			}
		 }
	 }
}

}
