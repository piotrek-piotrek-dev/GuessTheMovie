public class GameEngine {
    private Integer NUMBER_OF_TRIES = 10;
    private int numberOfTries = NUMBER_OF_TRIES;
    public int getNumberOfTries(){ return this.numberOfTries;}
    private String originalMovieTitle;
    private String guessedTitle="";
    private Boolean isComplete = false;

    public Boolean getIsComplete() {
        if(this.guessedTitle.contains("_")) return false;
        else return true;
    }

    public GameEngine(String title){
        this.originalMovieTitle = title;
        int i = this.originalMovieTitle.length();
        while((i-=1) >= 0) this.guessedTitle += "_";

        // for sake of time, we'll go with an prehistoric resolution.
        // TODO: update to use charsequence, .contains etc...
        // if(this.originalMovieTitle.contains(){
        //this.originalMovieTitleChars = this.originalMovieTitle.toCharArray();
    }

    public Boolean guessChar(char c){
        // for sake of time, we'll go with an prehistoric resolution.
        // TODO: update to use charsequence, .contains etc...
        // if(this.originalMovieTitle.contains(){
        //}

        Boolean ret = false;
        // really i;m not proud of this but since it's caveman coding...
        String tmp = "";
        for(int i = 0; this.originalMovieTitle.length() > i; i++){
            if(this.originalMovieTitle.charAt(i) == c){
                // we got an index...
                tmp += c;
                ret = true;
            }else if (this.guessedTitle.charAt(i) != '_')
                tmp += this.guessedTitle.charAt(i);
            else
                tmp += '_';
        }
        this.guessedTitle = tmp;
        if(!ret)
            this.numberOfTries--;
        return ret;
    }

    public String getStatus(){
        return "You are guessing: "+this.guessedTitle + "\n" +
                "you've guessed " + (NUMBER_OF_TRIES - this.numberOfTries) + " wrong\n" +
                "guess a letter: ";
    }


}
