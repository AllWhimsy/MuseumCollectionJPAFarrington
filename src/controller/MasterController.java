package controller;

import entities.CollectionItem;
import java.util.Scanner;

public class MasterController {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		String userResponse = "v";

		CollectionItem ci = new CollectionItem();

		while (!userResponse.equals("x")) {
			System.out.println(
					"Would you like to add(a), edit(e), delete(d), view(v), or exit(x) the museum collection?");
			userResponse = in.nextLine();

			if (userResponse.equals("a")) {

				CollectionItem c = getNewPiece();
				ci.insertPiece(c);

			}
			if (userResponse.equals("e")) {

				// ci.getAllPieces();
				CollectionItem c = editArt();
				ci.editPiece(c);
			}
			if (userResponse.equals("d")) {

				// ci.getAllPieces();
				CollectionItem c = deleteArt();
				ci.deletePiece(c);
			}
			if (userResponse.equals("v")) {
				ci.getAllPieces();
				
			}
		} 

	}

	private static CollectionItem getNewPiece() {

		String id = null;

		System.out.println("Enter the artist name: ");
		String pieceArtist = in.nextLine();

		System.out.println("Enter the piece title: ");
		String pieceTitle = in.nextLine();

		System.out.println("Enter the published year: ");
		String publishedYear = in.nextLine();

		System.out.println("Enter the materials used (e.g. oil on canvas): ");
		String materialsUsed = in.nextLine();

		System.out.println("Enter the museum location: ");
		String museumLocation = in.nextLine();

		CollectionItem c = new CollectionItem(id, pieceArtist, pieceTitle, publishedYear, materialsUsed,
				museumLocation);

		return c;
	}

	private static CollectionItem editArt() {

		System.out.println("Enter the id of the piece you wish to edit: ");
		String id = in.nextLine();

		System.out.println("Edit artist name: ");
		String pieceArtist = in.nextLine();

		System.out.println("Edit piece title: ");
		String pieceTitle = in.nextLine();

		System.out.println("Edit published year: ");
		String publishedYear = in.nextLine();

		System.out.println("Edit materials used (e.g. oil on canvas): ");
		String materialsUsed = in.nextLine();

		System.out.println("Edit the museum location: ");
		String museumLocation = in.nextLine();

		CollectionItem c = new CollectionItem(id, pieceArtist, pieceTitle, publishedYear, materialsUsed,
				museumLocation);
		return c;
	}

	private static CollectionItem deleteArt() {

		System.out.println("Enter the id of the piece that you wish to delete: ");
		String id = in.nextLine();

		String pieceArtist = null;
		String pieceTitle = null;
		String pubYear = null;
		String materialsUsed = null;
		String museumLocation = null;

		CollectionItem c = new CollectionItem(id, pieceArtist, pieceTitle, pubYear, materialsUsed, museumLocation);

		return c;

	}
}
