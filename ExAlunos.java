package trabalhos;
import javax.swing.JOptionPane;

import java.text.DecimalFormat;
import java.util.Scanner;
public class ExAlunos {

	public static void main(String[] args) {
		
		try {
			Scanner tc = new Scanner(System.in);
			double rendimento = 0;
			float valorDigitado=0, saldo=0,valorAporte=0,totalAporte=0,totalInvestido;
			int opc=0,qntMeses=0, sair=0, escolhaAporte=0;  //Declarado as variaveis
			
			DecimalFormat arredonda = new DecimalFormat("#,##0.00");//metodo para formata??o dos valores
			while(opc==0) {				//While aqui serve para criar a op??o de encerrar o algoritmo
				System.out.println("\nDigite o valor");
				saldo=tc.nextFloat();
				totalInvestido=saldo;
				System.out.println("Digite a quantidade de meses");
				qntMeses=tc.nextInt();
				System.out.printf("Deseja colocar aporte?\n1-SIM\n2-NÃO");
				escolhaAporte = tc.nextInt();
				if(escolhaAporte==1) {
					System.out.printf("Digite o valor do aporte");
					valorAporte=tc.nextFloat();    //Caso o usuario escolha colocar um aporte todo mes, aqui sera solicitado o valor
				}
				for(int i=1;i<qntMeses+1;i++) {		//Dentro desse la?o de repeti??o sera calculado, Saldo eTotal do aporte 
					totalAporte+=valorAporte;
					rendimento=(1.07*saldo)/100;   //Realiza o calculo da porcentagem
					saldo+=valorAporte;
					saldo+=rendimento;
					System.out.printf("Saldo mes "+i +"\nR$"+arredonda.format(saldo)+"\n\n"); //Exibe o valor ja formatado
				}
				totalInvestido+=totalAporte;
				System.out.printf("Valor total final R$"+(arredonda.format(saldo)) + "\nValor total investido: R$ "+arredonda.format(totalInvestido)+"\n");
				System.out.printf("Total de juros recebido R$"+arredonda.format(saldo-totalInvestido));
				System.out.printf("\nDeseja SAIR? \n1-SIM \n2-NÃO\n");
				sair=tc.nextInt();
				if(sair==1) {  			//Faz valida??o para ver se o algoritmo reinicia ou finaliza
					opc=1;
					System.out.println("ENCERRANDO...");
				}
				
			}
			
			
		}
		
		catch (Exception e) {
			System.out.println("Deu erro");
		}

	}

}
