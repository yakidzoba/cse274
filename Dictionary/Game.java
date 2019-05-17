import java.util.ArrayList;

public class Game {

	static DictionaryInterface<Board, Integer> boardList = new SortedArrayDictionary<>();
	static ArrayList<Board> list = new ArrayList<Board>();	
	// es stands for empty space
	// xORo true - X move
	// xorO false - O move
	public static void generateBoard(Board b, int es, boolean xORo) {
		
		if(es == 0) {
			return;
		}
		for (int i = 0; i < 9; i++) {
			//b = new Board();
			if(b.getBoard()[i].equals("-")) {
				b.getBoard()[i] = xORo == true ?"X":"O";
				boardList.add(b, getBestMove(b.toString()));
				//boardList.add(b, getBestMove(b.toString()));
				generateBoard(b, es-1, !xORo);
				b.getBoard()[i] = "-";
			}
		}
	}

	public static int getBestMove(String board) {

		return 0;
	}

	public static void main(String[] args) {
		Board b = new Board();
		generateBoard(b, 9, true);
		System.out.println(boardList.getSize());

	}
}


