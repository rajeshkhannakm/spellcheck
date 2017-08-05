import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*<applet code = "Interface.class" width = 500 hight = 500></applet>*/

public class Interface extends Applet{
    TextField t1 = new TextField();
    TextField t2 = new TextField();

    public void init(){
        setLayout(null);

        Label l1 = new Label("Misspelled word");
        Label l2 = new Label("Corrected word");


        Button check = new Button("Check");

        l1.setBounds(20, 30, 100, 20);
        l2.setBounds(220, 30, 100, 20);
        t1.setBounds(20,50,150,20);
        t2.setBounds(220,50,150,20);
        check.setBounds(160,120, 70, 30);

        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(check);
    }
}
