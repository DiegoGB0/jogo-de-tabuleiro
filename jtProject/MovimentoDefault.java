package jtProject;

import java.io.Serializable;

public class MovimentoDefault implements Serializable {

	public static int colisoes = 0;
	public static int mortes = 0;
	public static int movimentos = 0;

	public static void deleteTrace(int[][] tab, int x, int y) {
		tab[x][y] = 0;
	}

	public static int moveD(int[][] tabuleiro, int x, int y) {
		deleteTrace(tabuleiro, x, y);
		y += 1;
		movimentos++;

		if (y >= Jogo.sizeY) {
			y = Jogo.sizeY - 1;
			tabuleiro[x][y] = 1;
		}

		else if (tabuleiro[x][y] == 2) {
			System.out.println("Colisão");
			colisoes++;
		} else if (tabuleiro[x][y] == 3) {
			System.out.println("Player abatido");
			mortes++;
		}

		else {
			tabuleiro[x][y] = 1;
		}
		return y;
	}

	public static int moveA(int[][] tabuleiro, int x, int y) {
		deleteTrace(tabuleiro, x, y);
		y -= 1;
		movimentos++;

		if (y < 0) {
			y = 0;
			tabuleiro[x][y] = 1;
		}

		else if (tabuleiro[x][y] == 2) {
			System.out.println("Colisão");
			colisoes++;
		} else if (tabuleiro[x][y] == 3) {
			System.out.println("Player abatido");
			mortes++;
		}

		else {
			tabuleiro[x][y] = 1;
		}
		return y;
	}

	public static int moveW(int[][] tabuleiro, int x, int y) {
		deleteTrace(tabuleiro, x, y);
		x -= 1;
		movimentos++;

		if (x < 0) {
			x = 0;
			tabuleiro[x][y] = 1;
		}

		else if (tabuleiro[x][y] == 2) {
			System.out.println("Colisão");
			colisoes++;
		} else if (tabuleiro[x][y] == 3) {
			System.out.println("Player abatido");
			mortes++;
		}

		else {
			tabuleiro[x][y] = 1;
		}
		return x;
	}

	public static int moveS(int[][] tabuleiro, int x, int y) {
		deleteTrace(tabuleiro, x, y);
		x += 1;
		movimentos++;

		if (x >= Jogo.sizeX) {
			x = Jogo.sizeX - 1;
			tabuleiro[x][y] = 1;
		}

		else if (tabuleiro[x][y] == 2) {
			System.out.println("Colisão");
			colisoes++;
		} else if (tabuleiro[x][y] == 3) {
			System.out.println("Player abatido");
			mortes++;
		}

		else {
			tabuleiro[x][y] = 1;
		}
		return x;
	}

	public static int getColisoes() {
		return colisoes;
	}

	public static int getMortes() {
		return mortes;
	}

	public static int getMovimentos() {
		return movimentos;
	}

	public static void infoPlayer() {
		System.out.print('\n');
		System.out.println("Pontuação do ultimo jogador:");
		System.out.print('\n');
		Persistencia dados = Persistencia.carregarDados();
		if (dados != null) {
			dados.imprimirDados();
		} else {
			System.out.println("Não há dados salvos.");
		}
	}

	public static void atualPlayer() {
		System.out.println("Sua pontuação:");
		System.out.print('\n');
		System.out.println("Dados do jogador:");
		System.out.println("ID do usuário: " + Jogo.idUser);
		System.out.println("Inimigos abatidos: " + Tiro.enemyDown);
		System.out.println("Quantidade de tiros: " + Tiro.qtdTiros);
		System.out.println("Colisões: " + colisoes);
		System.out.println("Mortes: " + mortes);
		System.out.println("Movimentos realizados: " + movimentos);
		System.out.print('\n');
	}

}
