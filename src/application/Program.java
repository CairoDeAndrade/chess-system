package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printChessMatch(chessMatch);
				
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessposition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessposition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);	
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				System.out.println("Press 'ENTER' to try again.");
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Press 'ENTER' to try again.");
				sc.nextLine();
			}
		}
	}

}
