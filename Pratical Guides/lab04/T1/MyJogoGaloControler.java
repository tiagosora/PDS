public class MyJogoGaloControler implements JGaloInterface{

	private char P1, P2;
	private char[][] tictactoe;
	private int whoPlaying;
	private int countNumbPlays;



	//preciso de criar contrutor e implementar os métodos do interface

	public MyJogoGaloControler() {
		this.P1 = 'X';
		this.P2 = 'O';
		this.tictactoe = new char[3][3];
		this.whoPlaying = 1;
		this.countNumbPlays = 0;

	}

	@Override
	public char getActualPlayer(){
		
		if((whoPlaying % 2) == 0){
			return this.P2;
		}
		else{
			return this.P1;
		}

	}

	@Override
	public boolean setJogada(int lin, int col) {
        	lin--;
        	col--;
        	if (lin >= 0 && lin < 3 && col >= 0 && col < 3) {
        	    char ActualPlayer = getActualPlayer();
        	    this.tictactoe[lin][col] = ActualPlayer;
        	    this.whoPlaying++;
        	    this.countNumbPlays++;
        	    return true;
        	} 
        	else {
        	    return false;
        	}
    }

	@Override
	public boolean isFinished() {
        
		if (checkResult() != ' ' || this.countNumbPlays == 9) {
            return true;
        }
        else{
			return false;
		}
    }


	@Override
	public char checkResult(){
		for(int i = 0; i < 8; i++){
			String line = null;
			switch(i){
			case 0: 
				line = Character.toString(tictactoe[0][0]) + Character.toString(tictactoe[0][1]) + Character.toString(tictactoe[0][2]);
				break;
			case 1: 
				line = Character.toString(tictactoe[1][0]) + Character.toString(tictactoe[1][1]) + Character.toString(tictactoe[1][2]);
				break;
			case 2: 
				line = Character.toString(tictactoe[2][0]) + Character.toString(tictactoe[2][1]) + Character.toString(tictactoe[2][2]);
				break;
			case 3: 
				line = Character.toString(tictactoe[0][0]) + Character.toString(tictactoe[1][0]) + Character.toString(tictactoe[2][0]);
				break;
			case 4: 
				line = Character.toString(tictactoe[0][1]) + Character.toString(tictactoe[1][1]) + Character.toString(tictactoe[2][1]);
				break;
			case 5: 
				line = Character.toString(tictactoe[0][2]) + Character.toString(tictactoe[1][2]) + Character.toString(tictactoe[2][2]);
				break;
			case 6: 
				line = Character.toString(tictactoe[0][0]) + Character.toString(tictactoe[1][1]) + Character.toString(tictactoe[2][2]);
				break;
			case 7: 
				line = Character.toString(tictactoe[0][2]) + Character.toString(tictactoe[1][1]) + Character.toString(tictactoe[2][0]);
				break;
			}
			//For X winner
            if (line.equals("XXX")) {
                return this.P1;
            }
              
            // For O winner
            else if (line.equals("OOO")) {
                return this.P2;
            }
            
            else{
				continue;
			}
		}
		return ' ';

	}



}