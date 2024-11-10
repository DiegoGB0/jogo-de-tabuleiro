package jtProject;

import java.io.*;

public class Persistencia implements Serializable {
	private String idUser;
	private int enemyDown;
	private int qtdTiros;
	private int colisoes;
	private int mortes;
	private int movimentos;

	public Persistencia(String idUser, int enemyDown, int qtdTiros, int colisoes, int mortes, int movimentos) {
		this.idUser = idUser;
		this.enemyDown = enemyDown;
		this.qtdTiros = qtdTiros;
		this.colisoes = colisoes;
		this.mortes = mortes;
		this.movimentos = movimentos;
	}

	public String getIdUser() {
		return idUser;
	}

	public int getEnemyDown() {
		return enemyDown;
	}

	public int getQtdTiros() {
		return qtdTiros;
	}

	public int getColisoes() {
		return colisoes;
	}

	public int getMortes() {
		return mortes;
	}

	public int getMovimentos() {
		return movimentos;
	}

	public void salvarDados() {
		try {
			FileOutputStream fileOut = new FileOutputStream("dados.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(this);
			objectOut.close();
			fileOut.close();
			System.out.println("Dados salvos com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao salvar os dados: " + e.getMessage());
		}
	}

	public static Persistencia carregarDados() {
		Persistencia dados = null;
		try {
			FileInputStream fileIn = new FileInputStream("dados.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			dados = (Persistencia) objectIn.readObject();
			objectIn.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erro ao carregar os dados: " + e.getMessage());
		}
		return dados;
	}

	public void imprimirDados() {
		System.out.println("Dados do jogador:");
		System.out.println("ID do usuário: " + idUser);
		System.out.println("Inimigos abatidos: " + enemyDown);
		System.out.println("Quantidade de tiros: " + qtdTiros);
		System.out.println("Colisões: " + colisoes);
		System.out.println("Mortes: " + mortes);
		System.out.println("Movimentos realizados: " + movimentos);
		System.out.print('\n');
	}
}