package jtProject;

import java.io.Serializable;

public class Tiro extends MovimentoDefault implements Serializable {

	public static int enemyDown = 0;
	public static int qtdTiros = 0;

	public static int getEnemyDown() {
		return enemyDown;
	}

	public static int moveD(int[][] tabuleiro, int x, int y) {
		int yTiro = y + 3;
		qtdTiros++;

		if (yTiro < Jogo.sizeY) {

			// System.out.println(yTiro);
			if (tabuleiro[x][yTiro] == 3) {
				deleteTrace(tabuleiro, x, yTiro);
				System.out.println("alvo atingido");
				enemyDown++;
			}

			tabuleiro[x][yTiro] = 2;
		}

		return y;
	}

	public static int tiroLateralb(int[][] tabuleiro, int x, int y) {
		int xTiro = x + 2;
		qtdTiros++;

		if (xTiro < Jogo.sizeX) {

			if (tabuleiro[xTiro][y] == 3) {
				deleteTrace(tabuleiro, xTiro, y);
				System.out.println("alvo atingido");
				enemyDown++;
			}
			tabuleiro[xTiro][y] = 2;
		}
		return x;
	}

	public static int tiroLateralc(int[][] tabuleiro, int x, int y) {
		int xTiro = x - 2;
		qtdTiros++;

		if (xTiro >= 0) {
			if (tabuleiro[xTiro][y] == 3) {
				deleteTrace(tabuleiro, xTiro, y);
				System.out.println("Alvo atingido");
				enemyDown++;
			}
			tabuleiro[xTiro][y] = 2;
		}
		return x;
	}

	public static int getQtdTiros() {
		return qtdTiros;
	}
}
