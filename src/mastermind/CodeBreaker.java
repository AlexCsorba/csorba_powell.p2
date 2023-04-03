//@author Joe Meehean
package mastermind;


public interface CodeBreaker {


    public Code nextGuess();


    public void guessResults(Code guess, Code.Results results);


    public int possibleCodeCount();
}