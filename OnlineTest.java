import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	public OnlineTest() {

	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Who invented Java Programming?");
			radioButton[0].setText("Guido van Rossum");
			radioButton[1].setText(" James Gosling");
			radioButton[2].setText("Dennis Ritchie");
			radioButton[3].setText("Bjarne Stroustrup");
		}
		if (current == 1) {
			label.setText("Que2:  Which statement is true about Java?");
			radioButton[0].setText(" Java is a sequence-dependent programming language");
			radioButton[1].setText("Java is a code dependent programming language");
			radioButton[2].setText("Java is a platform-dependent programming language");
			radioButton[3].setText("Java is a platform independent programming language");
		}
		if (current == 2) {
			label.setText("Que3: Which component is used to compile, debug and execute the java programs?");
			radioButton[0].setText("JRE");
			radioButton[1].setText("JIT");
			radioButton[2].setText("JDK");
			radioButton[3].setText("JVM");
		}
		if (current == 3) {
			label.setText("Que4: Which one of the following is not a Java feature?");
			radioButton[0].setText("Object-oriented");
			radioButton[1].setText("Use of pointers");
			radioButton[2].setText("Portable");
			radioButton[3].setText("Dynamic and Extensible");
		}
		if (current == 4) {
			label.setText("Que5:  Which of these cannot be used for a variable name in Java?");
			radioButton[0].setText("identifier & keyword");
			radioButton[1].setText("identifier");
			radioButton[2].setText("keyword");
			radioButton[3].setText("none of the mentioned");
		}
		if (current == 5) {
			label.setText("Que6: What is the extension of java code files?");
			radioButton[0].setText(".js");
			radioButton[1].setText(".txt");
			radioButton[2].setText(".class");
			radioButton[3].setText(".java");
		}
		if (current == 6) {
			label.setText("Que7: Which of the following is not an OOPS concept in Java?");
			radioButton[0].setText("Polymorphism");
			radioButton[1].setText("Inheritance");
			radioButton[2].setText("Compilation");
			radioButton[3].setText("Encapsulation");
		}
		if (current == 7) {
			label.setText("Que8:  What is not the use of ???this??? keyword in Java?");
			radioButton[0].setText("Referring to the instance variable when a local variable has the same name");
			radioButton[1].setText("Passing itself to the method of the same class");
			radioButton[2].setText("Passing itself to another method");
			radioButton[3].setText("Calling another constructor in constructor chaining");
		}
		if (current == 8) {
			label.setText("Que9: Which of the following is a type of polymorphism in Java Programming?");
			radioButton[0].setText("Multiple polymorphism");
			radioButton[1].setText("Compile time polymorphism");
			radioButton[2].setText("Multilevel polymorphism");
			radioButton[3].setText("Execution time polymorphism");
		}
		if (current == 9) {
			label.setText("Que10: What is the extension of compiled java classes?");
			radioButton[0].setText(".txt");
			radioButton[1].setText(".js");
			radioButton[2].setText(".class");
			radioButton[3].setText(".java");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[3].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[1].isSelected());
		if (current == 9)
			return (radioButton[2].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}