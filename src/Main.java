import java.util.*;

public class Main {
	
	static String[] board;
	static String turn;
	
	static String checkWinner() 
	{
		for (int i = 0; i < 8; i++) {
			String line = null;
			
			switch (i) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2: 
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			
			//Para o X vencer
			if(line.equals("XXX")) {
				return "X";
			}
			//Para o O vencer
			else if(line.equals("OOO")) {
				return "O";
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if( Arrays.asList(board).contains(String.valueOf(i + 1))) {
				break;
			}
			else if(i == 8) {
				return "Empate";
			}
		}
		
		System.out.println(turn + "'é a vez; insira um número de slot para colocar" + turn + " em:");
		return null;
	}
	
	
	static void printBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " |" + board[1] + " | " + board[2] + " | ");
		System.out.println("| " + board[3] + " |" + board[4] + " | " + board[5] + " | ");
		System.out.println("| " + board[6] + " |" + board[7] + " | " + board[8] + " | ");
		System.out.println("|---|---|---|");
		
	}

	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		
		for (int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i + 1);
		}
		
		System.out.println("Bem vindo ao Tic Tac Toe 3x3.");
		printBoard();
		
		System.out.println(" X Jogara primeiro. Insira um número do slot para colocar X: ");
		
		while(winner == null) {
			int numInput;
			
			//manipulação de exceção.
			//numInput recebera informações de 1 a 9.
			//se não estiver no intervalo de 1 a 9
			//então será exibido um erro "Entrada invalida".
			
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Entrada invalida, digite novamente o valor do slot");
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Entrada invalida, digite novamente o valor do slot");
				continue;
			}
			
			
			//logica para decidir a sequencia das jogadas X e O
			if (board[numInput - 1].equals(String.valueOf(numInput))) {
				board[numInput - 1] = turn;
				if(turn.equals("X")) {
					turn = "O";
				}
				else {
					turn = "X";
				}
				
				printBoard();
				winner = checkWinner();
			
			}
			else {
				System.out.println("Slot já ocupo; digite novamente o número do slot");
			}
		}
		
		
		//Logica para empate
		
		if(winner.equalsIgnoreCase("Empate")) {
			System.out.println("Deu velha, obrigado por jogar");
			
		}
		else {
			System.out.println("Parabens! " + winner + "ganhou. Obrigado por jogar");
		}
		in.close();
	
	}
	
}
