package jtProject;

import java.util.Random;

public class Inimigo {
	private static int x;
	private static int y;

	public Inimigo(int[][] tabuleiro, int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static void moveRandomly(int[][] tabuleiro) {
		Random rand = new Random();
		int direction = rand.nextInt(4);
		// LIMPA A POSIÇÃO ATUAL
		MovimentoDefault.deleteTrace(tabuleiro, x, y);

		switch (direction) {
		case 0:
			if (x > 0)
				x--; // MOVE PARA CIMA
			break;
		case 1:
			if (x < tabuleiro.length - 1)
				x++; // MOVE PARA BAIXO
			break;
		case 2:
			if (y > 0)
				y--; // MOVE PARA ESQUERDA
			break;
		case 3:
			if (y < tabuleiro[0].length - 1)
				y++; // MOVE PARA A DIREITA
			break;
		}

		if (tabuleiro[x][y] == 1) {
			System.out.println("Player abatido");
			MovimentoDefault.mortes++;
		} else if (tabuleiro[x][y] == 2) {
			MovimentoDefault.deleteTrace(tabuleiro, x, y);
			System.out.println("alvo atingido");
			Tiro.enemyDown++;
		}

		tabuleiro[x][y] = 3;

	}
}