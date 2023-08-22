import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] tahta = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		tahtayaYaz(tahta);
		
		while (true) {
			oyuncuSirasi(tahta, scanner);
			if (oyunBitti(tahta)){
				break;
			}
			tahtayaYaz(tahta);
			
			bilgisayarSirasi(tahta);
			if (oyunBitti(tahta)){
				break;
			}
			tahtayaYaz(tahta);
		}
		scanner.close();
	}


	private static boolean oyunBitti(char[][] tahta) {
		
		if (kazanmaSarti(tahta, 'X')) {	
			tahtayaYaz(tahta);
			System.out.println("Oyuncu kazandı!");
			return true;
		}
		
		if (kazanmaSarti(tahta, 'O')) {	
			tahtayaYaz(tahta);
			System.out.println("Bilgisayar kazandı!");
			return true;
		}
		
		for (int i = 0; i < tahta.length; i++) {
			for (int j = 0; j < tahta[i].length; j++) {
				if (tahta[i][j] == ' ') {
					return false;
				}
			}
		}
		tahtayaYaz(tahta);
		System.out.println("Berabere bitti!");
		return true;
	}


	private static boolean kazanmaSarti(char[][] tahta, char symbol) {
		if ((tahta[0][0] == symbol && tahta [0][1] == symbol && tahta [0][2] == symbol) ||
			(tahta[1][0] == symbol && tahta [1][1] == symbol && tahta [1][2] == symbol) ||
			(tahta[2][0] == symbol && tahta [2][1] == symbol && tahta [2][2] == symbol) ||
			
			(tahta[0][0] == symbol && tahta [1][0] == symbol && tahta [2][0] == symbol) ||
			(tahta[0][1] == symbol && tahta [1][1] == symbol && tahta [2][1] == symbol) ||
			(tahta[0][2] == symbol && tahta [1][2] == symbol && tahta [2][2] == symbol) ||
			
			(tahta[0][0] == symbol && tahta [1][1] == symbol && tahta [2][2] == symbol) ||
			(tahta[0][2] == symbol && tahta [1][1] == symbol && tahta [2][0] == symbol) ) {
			return true;
		}
		return false;
	}


	private static void bilgisayarSirasi(char[][] tahta) {
		Random rand = new Random();
		int bilgisayarHaraketi;
		while (true) {
			bilgisayarHaraketi = rand.nextInt(9) + 1;
			if (gecerliHamle(tahta, Integer.toString(bilgisayarHaraketi))) {
				break;
			}
		}
		System.out.println("Bilgisayar secimi" + bilgisayarHaraketi);
		konumHaraketi(tahta, Integer.toString(bilgisayarHaraketi), 'O');
	}


	private static boolean gecerliHamle (char[][] tahta, String pozisyon) {
		switch(pozisyon) {
			case "1":
				return (tahta[0][0] == ' ');
			case "2":
				return (tahta[0][1] == ' ');
			case "3":
				return (tahta[0][2] == ' ');
			case "4":
				return (tahta[1][0] == ' ');
			case "5":
				return (tahta[1][1] == ' ');
			case "6":
				return (tahta[1][2] == ' ');
			case "7":
				return (tahta[2][0] == ' ');
			case "8":
				return (tahta[2][1] == ' ');
			case "9":
				return (tahta[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void oyuncuSirasi(char[][] tahta, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("1 ve 9 arasında oynamak istediğiniz konumu secin!");
			userInput = scanner.nextLine();
			if (gecerliHamle(tahta, userInput)){
				break;
			} else {
				System.out.println(userInput + " Geçerli bir haraket değil.");
			}
		}
		konumHaraketi(tahta, userInput, 'X');
	}


	private static void konumHaraketi(char[][] tahta, String position, char symbol) {
		switch(position) {
			case "1":
				tahta[0][0] = symbol;
				break;
			case "2":
				tahta[0][1] = symbol;
				break;
			case "3":
				tahta[0][2] = symbol;
				break;
			case "4":
				tahta[1][0] = symbol;
				break;
			case "5":
				tahta[1][1] = symbol;
				break;
			case "6":
				tahta[1][2] = symbol;
				break;
			case "7":
				tahta[2][0] = symbol;
				break;
			case "8":
				tahta[2][1] = symbol;
				break;
			case "9":
				tahta[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	
	
	private static void tahtayaYaz(char[][] tahta) {
		System.out.println(tahta[0][0] + "|" +  tahta[0][1] + "|" +  tahta[0][2] );
		System.out.println("-+-+-");
		System.out.println(tahta[1][0] + "|" +  tahta[1][1] + "|" +  tahta[1][2] );
		System.out.println("-+-+-");
		System.out.println(tahta[2][0] + "|" +  tahta[2][1] + "|" +  tahta[2][2] );
	}
	
}
  