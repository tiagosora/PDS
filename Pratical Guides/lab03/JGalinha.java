import java.util.ArrayList;

public class JGalinha implements JGaloInterface {

    private String player, result;
    private ArrayList<ArrayList<String>> grid;

    public JGalinha(String args[]){
        this.player = "X";
        this.result = "Jogo";
        if(args.length > 0)
            if(args[0].equals("X") || args[0].equals("O"))
                this.player =  args[0];
        this.grid = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            ArrayList<String> line = new ArrayList<>();
            for (int j = 0; j < 3; j++){
                line.add("N");
            }
            grid.add(line);
        }
    }

    @Override
    public char getActualPlayer() {
        return this.player.charAt(0);
    }

    @Override
    public boolean setJogada(int lin, int col) {
        this.grid.get(lin-1).set(col-1, this.player);
        if(this.player.equals("X")){
            this.player = "O";
            return true;
        } else if(this.player.equals("O")){
            this.player = "X";
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinished() {
        int ctr = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(!(this.grid.get(i).get(j).equals("N"))){
                    ctr +=1;
                }
            }
        }
        if (ctr == 9){
            this.result = "Empate";
            return true;
        }
        for (int i = 0; i < 3; i++){
            if( !(this.grid.get(0).get(i).equals("N")) &&
                this.grid.get(0).get(i).equals(this.grid.get(1).get(i)) && (this.grid.get(0).get(i).equals(this.grid.get(2).get(i)))){
                this.player = this.grid.get(0).get(i);
                return true;
            }
        }
        for (int i = 0; i < 3; i++){
            if( !(this.grid.get(i).get(0).equals("N")) &&
                this.grid.get(i).get(0).equals(this.grid.get(i).get(1)) && (this.grid.get(i).get(0).equals(this.grid.get(i).get(2)))){
                this.player = this.grid.get(i).get(0);
                return true;
            }
        }
        if( !(this.grid.get(0).get(0).equals("N")) &&
            this.grid.get(0).get(0).equals(this.grid.get(1).get(1)) && this.grid.get(0).get(0).equals(this.grid.get(2).get(2))){
            this.player = this.grid.get(0).get(0);
            return true;
        }
        if( !(this.grid.get(2).get(0).equals("N")) &&
            this.grid.get(2).get(0).equals(this.grid.get(1).get(1)) && this.grid.get(2).get(0).equals(this.grid.get(0).get(2))){
            this.player = this.grid.get(2).get(0);
            return true;
        }
        return false;
    }

    @Override
    public char checkResult() {
        if(this.result.equals("Empate")){
            return ' ';
        }
        return this.player.charAt(0);
    }
    
}
