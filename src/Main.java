import ss4.Fan;
import ss4.QuadraticEquation;
import ss4.Speed;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        QuadraticEquation q = new QuadraticEquation(1, 2, 3);
//        q.getRoots();
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Speed.FAST,true,10,"yellow");
        fan1.toStringFan();
        fan2.toStringFan();
    }
}