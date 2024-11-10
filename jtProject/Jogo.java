package jtProject;

import java.io.Serializable;
import java.util.Scanner;

public class Jogo implements Serializable {
	public static final int sizeX = 10;
	public static final int sizeY = 10;

	public static int vitorias = 0;
	public static String idUser;

	public static void solicitarNome() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o seu nome: ");
		idUser = input.nextLine();
	}

	public static void save() {
		Persistencia dados = new Persistencia(idUser, Tiro.getEnemyDown(), Tiro.getQtdTiros(),
				MovimentoDefault.getColisoes(), MovimentoDefault.getMortes(), MovimentoDefault.getMovimentos());
		dados.salvarDados();
	}

	public static void showMatrix(int[][] tabuleiro) {

		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				System.out.print(" " + tabuleiro[i][j] + " ");
			}
			System.out.print('\n');
		}
	}

	public static void main(String[] args) {
		Instrucoes.sowInfo();
		MovimentoDefault.infoPlayer();
		int[][] tabuleiro = new int[10][sizeX];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < sizeX; j++) {
				tabuleiro[i][j] = 0;

			}
		}

		int x = 1;
		int y = 1;
		tabuleiro[x][y] = 1;
		Inimigo inimigo = new Inimigo(tabuleiro, 5, 3);

		showMatrix(tabuleiro);
		String mov = "a";
		while (!"e".equals(mov)) {

			// VERIFICA SE O JOGADOR ATINGIU O LIMITE DE ABATES
			if (Tiro.getEnemyDown() >= 3) {
				System.out.println("Missão cumprida!");
				vitorias++;
				solicitarNome();
				MovimentoDefault.infoPlayer();
				MovimentoDefault.atualPlayer();
				save();
				break;
			}

			Scanner input = new Scanner(System.in);
			mov = input.nextLine();

			// EIXO Y
			if ("d".equals(mov)) {
				y = MovimentoDefault.moveD(tabuleiro, x, y);
			}

			else if ("a".equals(mov)) {
				y = MovimentoDefault.moveA(tabuleiro, x, y);
			}

			// EIXO X
			else if ("w".equals(mov)) {
				x = MovimentoDefault.moveW(tabuleiro, x, y);
			}

			else if ("s".equals(mov)) {
				x = MovimentoDefault.moveS(tabuleiro, x, y);
			}
			// TIRO
			else if ("t".equals(mov)) {
				Tiro.moveD(tabuleiro, x, y);
			}

			else if ("r".equals(mov)) {
				Tiro.tiroLateralb(tabuleiro, x, y);
			}

			else if ("y".equals(mov)) {
				Tiro.tiroLateralc(tabuleiro, x, y);
			}
			// EXT
			else if ("e".equals(mov)) {
				System.out.println("Programa finalizado");
				solicitarNome();
				MovimentoDefault.infoPlayer();
				MovimentoDefault.atualPlayer();
				save();
				continue;
			}

			else if ("i".equals(mov)) {
				Instrucoes.sowInfo();
			}

			else if ("h".equals(mov)) {
				MovimentoDefault.infoPlayer();
			}

			// QUALQUER OUTRO BOTÃO Q FOR ADICIONAR TEM Q SER ANTES DESSE BLOCO
			else {
				System.out.println("Entrada inválida");
			}
			Inimigo.moveRandomly(tabuleiro);

			showMatrix(tabuleiro);
		}

	}

}
