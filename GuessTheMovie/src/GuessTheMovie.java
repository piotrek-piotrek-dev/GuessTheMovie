import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheMovie {

    public static void main(String[] args) throws IOException {
        /*
        read a random title from txt file
        count # of letters, present it to user
        user inputs char of title. if it's in the title, reveal it's position(s)
        else
        -1pts (10 in total)

        output:
        display "_" as letters
        i.e. "you are guessing: _____"
        guess a letter: \n
        you have 10 guesses left

         */
        String filePath = "/Users/piotrek/Documents/Infoshare-academy/mini-project1-guess-the-movie/GuessTheMovie/movie-list.txt";
        //TODO: for crying out loud, wrap it with try...catch...!
        TitleBase tmp = new TitleBase(filePath);

        //TODO: make this better for memory with large files
        GameEngine gameEngine = new GameEngine(tmp.pickRandomTitle());
        String input;
        Boolean b = false;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(gameEngine.getNumberOfTries()>0 && gameEngine.getIsComplete()){
            System.out.println(gameEngine.getStatus());
            input = in.readLine();

            b = gameEngine.guessChar(input.charAt(0));
        }

    }

}
