package fr.norsys.backend.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.norsys.backend.entity.Utilisateur;

public class UtilisateurUtil {

	public static int calculatePoints(int score1, int score2, int prediction1, int prediction2) {
		int points = 0;
		if (score1 == prediction1 && score2 == prediction2) {
			points = 3;
		} else if (prediction1 - prediction2 == score1 - score2) {
			points = 2;
		} else if (isWinner(score1, score2, prediction1, prediction2)
				|| isWinner(score2, score1, prediction2, prediction1)) {
			points = 1;
		}
		return points;
	}

	public static boolean isWinner(int score1, int score2, int prediction1, int prediction2) {
		return prediction1 > prediction2 && score1 > score2;
	}

	public static void sortListByScore(List<Utilisateur> utilisateurs) {
		Collections.sort(utilisateurs, new Comparator<Utilisateur>() {
			public int compare(Utilisateur utilisateur1, Utilisateur utilisateur2) {
				Integer score1 = new Integer(utilisateur1.getScore());
				Integer score2 = new Integer(utilisateur2.getScore());
				return score2.compareTo(score1);
			}
		});
	}

}
