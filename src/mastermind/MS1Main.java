package mastermind;

public class MS1Main {
    public static void main(String[] args)
    {
        Code code1 = new Code(args[0]);
        Code code2 = new Code(args[1]);
        Code.Results ms1Results = code1.compare(code2);
        System.out.println("Bulls: ");
        System.out.println(ms1Results.getBulls());
        System.out.println("\n");
        System.out.println("Cows: ");
        System.out.println(ms1Results.getCows());
        .
    }
}