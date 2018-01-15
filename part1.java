
package project1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class part1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// definite 4 register
	private static int[] GDR = { 10, 20, 30, 40 };
	// in order to simulate addressing directly, use array to definite 3 index
	// register
	private static int[] IXR = {0, 32, 64, 2016};
	// use array to definite memory
	private static int[] memory = new int[2048];
	// Console Registers
	private static int[] CR = new int[29];
	// Condition Counter
	private static int[] CC = { 0, 0, 0, 0 };
	// definite some required parameters
	private static int R;
	private static int IX;
	private static int I;
	private static int Ad;
	private static int RX;
	private static int RY;
	private static int AL;
	private static int LR;
	private static int FR;
	private static int count;
	private static int DevID;
	private static int TrapCode;
	private static String op;
	private static int MAR;
	private static int MBR;
	private static int MEM;
	private static int MSR;
	private static BufferedReader br;
	private static String IR;
	private static String PC;
	private static int fh = 1;
	private int ir_lenth = 0;
	private static int cacheNumber = 16;
	private static int cacheCount = 1;
	private static int firstVector;
	private static int secondVector;
	private static String pText="";
	private static String BP;
	private static int counter = 0;
	private static int judge1 = 0;
	private static int judge2 = 0;
	// design user interface's parameters
	private JLabel MARlabel;
	private JLabel MBRlabel;
	private JLabel MEMlabel;
	private JLabel IRlabel;
	private JLabel PClabel;
	private JLabel MSRlabel;
	private JTextField MARtxt;
	private JTextField MBRtxt;
	private JTextField MEMtxt;
	private JTextField IRtxt;
	private JTextField PCtxt;
	private static JTextField MSRtxt;
	private JLabel GDRlabel;
	private JLabel IXlabel;
	private JLabel GDRlabel0;
	private JLabel GDRlabel1;
	private JLabel GDRlabel2;
	private JLabel GDRlabel3;
	private JLabel IXlabel1;
	private JLabel IXlabel2;
	private JLabel IXlabel3;
	private JTextField GDRtxt0;
	private JTextField GDRtxt1;
	private JTextField GDRtxt2;
	private JTextField GDRtxt3;
	private JTextField IXtxt1;
	private JTextField IXtxt2;
	private JTextField IXtxt3;
	private JButton runbutton;
	private JButton ssbutton;
	private JButton load1button;
	private JButton load2button;
	private JButton load3button;
	private JButton r0button;
	private JButton r1button;
	private JButton r2button;
	private JButton r3button;
	private JButton pcButton;
	private JButton memquery;
	private JButton memedit;
	private JLabel mar_op;
	private JLabel mem_op;
	private JTextField mar_edit;
	private JTextField mem_edit;
	private JLabel keyboardlabel;
	private static JTextField keyboardtxt;
	private JLabel printerlabel;
	private static JTextArea printertxt;
	private JLabel cachelabel;
	private JLabel ca1label;
	private JLabel ca2label;
	private JLabel ca3label;
	private JLabel ca4label;
	private JLabel ca5label;
	private JLabel ca6label;
	private JLabel ca7label;
	private JLabel ca8label;
	private JLabel ca9label;
	private JLabel ca10label;
	private JLabel ca11label;
	private JLabel ca12label;
	private JLabel ca13label;
	private JLabel ca14label;
	private JLabel ca15label;
	private JLabel ca16label;
	private JLabel cacheAddress1;
	private JLabel cacheValue1;
	private JLabel cacheAddress2;
	private JLabel cacheValue2;
	private static JTextField ca1_ad;
	private static JTextField ca1_va;
	private static JTextField ca2_ad;
	private static JTextField ca2_va;
	private static JTextField ca3_ad;
	private static JTextField ca3_va;
	private static JTextField ca4_ad;
	private static JTextField ca4_va;
	private static JTextField ca5_ad;
	private static JTextField ca5_va;
	private static JTextField ca6_ad;
	private static JTextField ca6_va;
	private static JTextField ca7_ad;
	private static JTextField ca7_va;
	private static JTextField ca8_ad;
	private static JTextField ca8_va;
	private static JTextField ca9_ad;
	private static JTextField ca9_va;
	private static JTextField ca10_ad;
	private static JTextField ca10_va;
	private static JTextField ca11_ad;
	private static JTextField ca11_va;
	private static JTextField ca12_ad;
	private static JTextField ca12_va;
	private static JTextField ca13_ad;
	private static JTextField ca13_va;
	private static JTextField ca14_ad;
	private static JTextField ca14_va;
	private static JTextField ca15_ad;
	private static JTextField ca15_va;
	private static JTextField ca16_ad;
	private static JTextField ca16_va;
	private JLabel CClabel0;
	private JLabel CClabel1;
	private JLabel CClabel2;
	private JLabel CClabel3;
	private JTextField CCtxt0;
	private JTextField CCtxt1;
	private JTextField CCtxt2;
	private JTextField CCtxt3;
	private JLabel predictlabel;
	private static JTextField jdtxt0;
	private static JTextField jdtxt1;
	private JLabel BPlabel;
	private static JTextField BPtxt;
	
	

	// achieve user interface
	public part1() {
		super();
		// frame = new JFrame("part1");
		setTitle("part1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1260, 820);
		setLayout(null);
		setResizable(false);
		// add button to UI
		runbutton = new JButton("RUN");
		runbutton.setBounds(30, 350, 100, 30);
		ssbutton = new JButton("SS");
		ssbutton.setBounds(150, 350, 100, 30);
		load1button = new JButton("LOAD1");
		load1button.setBounds(270, 350, 100, 30);
		load2button = new JButton("LOAD2");
		load2button.setBounds(390, 350, 100, 30);
		load3button = new JButton("LOAD3");
		load3button.setBounds(510, 350, 100, 30);
		// add label to UI
		GDRlabel = new JLabel("GDR");
		GDRlabel.setBounds(140, 5, 30, 30);
		IXlabel = new JLabel("IX");
		IXlabel.setBounds(140, 180, 30, 30);
		GDRlabel0 = new JLabel("0");
		GDRlabel0.setBounds(20, 30, 30, 30);
		GDRlabel1 = new JLabel("1");
		GDRlabel1.setBounds(20, 70, 30, 30);
		GDRlabel2 = new JLabel("2");
		GDRlabel2.setBounds(20, 110, 30, 30);
		GDRlabel3 = new JLabel("3");
		GDRlabel3.setBounds(20, 150, 30, 30);
		// add textfield to UI
		GDRtxt0 = new JTextField("");
		GDRtxt0.setBounds(50, 30, 200, 30);
		GDRtxt0.setEditable(true);
		GDRtxt1 = new JTextField("");
		GDRtxt1.setBounds(50, 70, 200, 30);
		GDRtxt1.setEditable(true);
		GDRtxt2 = new JTextField("");
		GDRtxt2.setBounds(50, 110, 200, 30);
		GDRtxt2.setEditable(true);
		GDRtxt3 = new JTextField("");
		GDRtxt3.setBounds(50, 150, 200, 30);
		GDRtxt3.setEditable(true);
		IXtxt1 = new JTextField("");
		IXtxt1.setBounds(50, 210, 200, 30);
		IXtxt1.setEditable(false);
		IXtxt2 = new JTextField("");
		IXtxt2.setBounds(50, 250, 200, 30);
		IXtxt2.setEditable(false);
		IXtxt3 = new JTextField("");
		IXtxt3.setBounds(50, 290, 200, 30);
		IXtxt3.setEditable(false);
		IXlabel1 = new JLabel("1");
		IXlabel1.setBounds(20, 210, 30, 30);
		IXlabel2 = new JLabel("2");
		IXlabel2.setBounds(20, 250, 30, 30);
		IXlabel3 = new JLabel("3");
		IXlabel3.setBounds(20, 290, 30, 30);

		MARlabel = new JLabel("MAR");
		MARlabel.setBounds(440, 5, 30, 30);
		MARtxt = new JTextField("");
		MARtxt.setBounds(350, 30, 200, 30);
		MARtxt.setEditable(false);
		MBRlabel = new JLabel("MBR");
		MBRlabel.setBounds(440, 60, 30, 30);
		MBRtxt = new JTextField("");
		MBRtxt.setBounds(350, 85, 200, 30);
		MBRtxt.setEditable(false);
		MEMlabel = new JLabel("MEM");
		MEMlabel.setBounds(440, 115, 30, 30);
		MEMtxt = new JTextField("");
		MEMtxt.setBounds(350, 140, 200, 30);
		MEMtxt.setEditable(false);
		IRlabel = new JLabel("IR");
		IRlabel.setBounds(450, 170, 30, 30);
		IRtxt = new JTextField("");
		IRtxt.setBounds(350, 195, 200, 30);
		IRtxt.setEditable(false);
		PClabel = new JLabel("PC");
		PClabel.setBounds(450, 225, 30, 30);
		PCtxt = new JTextField("");
		PCtxt.setBounds(350, 250, 200, 30);
		PCtxt.setEditable(true);
		mar_op = new JLabel("mar");
		mar_op.setBounds(350, 290, 30, 20);
		mem_op = new JLabel("mem");
		mem_op.setBounds(350, 320, 30, 20);
		mar_edit = new JTextField();
		mar_edit.setBounds(380, 290, 125, 20);
		mem_edit = new JTextField();
		mem_edit.setBounds(380, 320, 125, 20);
		memquery = new JButton("query");
		memquery.setBounds(510, 290, 40, 20);
		memquery.setMargin(new Insets(0, 0, 0, 0));
		memedit = new JButton("edit");
		memedit.setBounds(510, 320, 40, 20);
		memedit.setMargin(new Insets(0, 0, 0, 0));
		// add some buttons to UI
		r0button = new JButton("edit");
		r0button.setBounds(260, 30, 55, 30);
		r1button = new JButton("edit");
		r1button.setBounds(260, 70, 55, 30);
		r2button = new JButton("edit");
		r2button.setBounds(260, 110, 55, 30);
		r3button = new JButton("edit");
		r3button.setBounds(260, 150, 55, 30);
		pcButton = new JButton("edit");
		pcButton.setBounds(560, 250, 55, 30);
		keyboardlabel = new JLabel("Keyboard");
		keyboardlabel.setBounds(670, 5, 100, 30);
		keyboardtxt = new JTextField("");
		keyboardtxt.setBounds(600, 30, 200, 30);
		printerlabel = new JLabel("Printer");
		printerlabel.setBounds(1045, 5, 100, 30);
		printertxt = new JTextArea("");
		printertxt.setBounds(900, 30, 330, 740);
		printertxt.setEditable(false);
		MSRlabel = new JLabel("MSR");
		MSRlabel.setBounds(620, 90, 100, 30);
		CClabel0 = new JLabel("OVERFLOW");
		CClabel0.setBounds(620, 125, 100, 30);
		CClabel1 = new JLabel("UNDERFLOW");
		CClabel1.setBounds(620, 160, 100, 30);
		CClabel2 = new JLabel("DIVZERO");
		CClabel2.setBounds(620, 195, 100, 30);
		CClabel3 = new JLabel("EQUALORNOT");
		CClabel3.setBounds(620, 230, 100, 30);
		MSRtxt = new JTextField("");
		MSRtxt.setBounds(710, 90, 20, 30);
		MSRtxt.setEditable(false);
		CCtxt0 = new JTextField("");
		CCtxt0.setBounds(710, 125, 20, 30);
		CCtxt0.setEditable(false);
		CCtxt1 = new JTextField("");
		CCtxt1.setBounds(710, 160, 20, 30);
		CCtxt1.setEditable(false);
		CCtxt2 = new JTextField("");
		CCtxt2.setBounds(710, 195, 20, 30);
		CCtxt2.setEditable(false);
		CCtxt3 = new JTextField("");
		CCtxt3.setBounds(710, 230, 20, 30);
		CCtxt3.setEditable(false);
		
		cachelabel = new JLabel("Cache");
		cachelabel.setBounds(420, 380, 100, 30);
		cacheAddress1 = new JLabel("Address");
		cacheAddress1.setBounds(110, 390, 100, 30);
		cacheValue1 = new JLabel("Value");
		cacheValue1.setBounds(310, 390, 100, 30);
		cacheAddress2 = new JLabel("Address");
		cacheAddress2.setBounds(530, 390, 100, 30);
		cacheValue2 = new JLabel("Value");
		cacheValue2.setBounds(730, 390, 100, 30);
		ca1label = new JLabel("1");
		ca1label.setBounds(20, 420, 100, 30);
		ca2label = new JLabel("2");
		ca2label.setBounds(20, 460, 100, 30);
		ca3label = new JLabel("3");
		ca3label.setBounds(20, 500, 100, 30);
		ca4label = new JLabel("4");
		ca4label.setBounds(20, 540, 100, 30);
		ca5label = new JLabel("5");
		ca5label.setBounds(20, 580, 100, 30);
		ca6label = new JLabel("6");
		ca6label.setBounds(20, 620, 100, 30);
		ca7label = new JLabel("7");
		ca7label.setBounds(20, 660, 100, 30);
		ca8label = new JLabel("8");
		ca8label.setBounds(20, 700, 100, 30);
		ca9label = new JLabel("9");
		ca9label.setBounds(440, 420, 100, 30);
		ca10label = new JLabel("10");
		ca10label.setBounds(440, 460, 100, 30);
		ca11label = new JLabel("11");
		ca11label.setBounds(440, 500, 100, 30);
		ca12label = new JLabel("12");
		ca12label.setBounds(440, 540, 100, 30);
		ca13label = new JLabel("13");
		ca13label.setBounds(440, 580, 100, 30);
		ca14label = new JLabel("14");
		ca14label.setBounds(440, 620, 100, 30);
		ca15label = new JLabel("15");
		ca15label.setBounds(440, 660, 100, 30);
		ca16label = new JLabel("16");
		ca16label.setBounds(440, 700, 100, 30);
		ca1_ad = new JTextField("");
		ca1_ad.setBounds(40, 420, 180, 30);
		ca1_ad.setEditable(false);
		ca1_va = new JTextField("");
		ca1_va.setBounds(240, 420, 180, 30);
		ca1_va.setEditable(false);
		ca2_ad = new JTextField("");
		ca2_ad.setBounds(40, 460, 180, 30);
		ca2_ad.setEditable(false);
		ca2_va = new JTextField("");
		ca2_va.setBounds(240, 460, 180, 30);
		ca2_va.setEditable(false);
		ca3_ad = new JTextField("");
		ca3_ad.setBounds(40, 500, 180, 30);
		ca3_ad.setEditable(false);
		ca3_va = new JTextField("");
		ca3_va.setBounds(240, 500, 180, 30);
		ca3_va.setEditable(false);
		ca4_ad = new JTextField("");
		ca4_ad.setBounds(40, 540, 180, 30);
		ca4_ad.setEditable(false);
		ca4_va = new JTextField("");
		ca4_va.setBounds(240, 540, 180, 30);
		ca4_va.setEditable(false);
		ca5_ad = new JTextField("");
		ca5_ad.setBounds(40, 580, 180, 30);
		ca5_ad.setEditable(false);
		ca5_va = new JTextField("");
		ca5_va.setBounds(240, 580, 180, 30);
		ca5_va.setEditable(false);
		ca6_ad = new JTextField("");
		ca6_ad.setBounds(40, 620, 180, 30);
		ca6_ad.setEditable(false);
		ca6_va = new JTextField("");
		ca6_va.setBounds(240, 620, 180, 30);
		ca6_va.setEditable(false);
		ca7_ad = new JTextField("");
		ca7_ad.setBounds(40, 660, 180, 30);
		ca7_ad.setEditable(false);
		ca7_va = new JTextField("");
		ca7_va.setBounds(240, 660, 180, 30);
		ca7_va.setEditable(false);
		ca8_ad = new JTextField("");
		ca8_ad.setBounds(40, 700, 180, 30);
		ca8_ad.setEditable(false);
		ca8_va = new JTextField("");
		ca8_va.setBounds(240, 700, 180, 30);
		ca8_va.setEditable(false);
		ca9_ad = new JTextField("");
		ca9_ad.setBounds(460, 420, 180, 30);
		ca9_ad.setEditable(false);
		ca9_va = new JTextField("");
		ca9_va.setBounds(660, 420, 180, 30);
		ca9_va.setEditable(false);
		ca10_ad = new JTextField("");
		ca10_ad.setBounds(460, 460, 180, 30);
		ca10_ad.setEditable(false);
		ca10_va = new JTextField("");
		ca10_va.setBounds(660, 460, 180, 30);
		ca10_va.setEditable(false);
		ca11_ad = new JTextField("");
		ca11_ad.setBounds(460, 500, 180, 30);
		ca11_ad.setEditable(false);
		ca11_va = new JTextField("");
		ca11_va.setBounds(660, 500, 180, 30);
		ca11_va.setEditable(false);
		ca12_ad = new JTextField("");
		ca12_ad.setBounds(460, 540, 180, 30);
		ca12_ad.setEditable(false);
		ca12_va = new JTextField("");
		ca12_va.setBounds(660, 540, 180, 30);
		ca12_va.setEditable(false);
		ca13_ad = new JTextField("");
		ca13_ad.setBounds(460, 580, 180, 30);
		ca13_ad.setEditable(false);
		ca13_va = new JTextField("");
		ca13_va.setBounds(660, 580, 180, 30);
		ca13_va.setEditable(false);
		ca14_ad = new JTextField("");
		ca14_ad.setBounds(460, 620, 180, 30);
		ca14_ad.setEditable(false);
		ca14_va = new JTextField("");
		ca14_va.setBounds(660, 620, 180, 30);
		ca14_va.setEditable(false);
		ca15_ad = new JTextField("");
		ca15_ad.setBounds(460, 660, 180, 30);
		ca15_ad.setEditable(false);
		ca15_va = new JTextField("");
		ca15_va.setBounds(660, 660, 180, 30);
		ca15_va.setEditable(false);
		ca16_ad = new JTextField("");
		ca16_ad.setBounds(460, 700, 180, 30);
		ca16_ad.setEditable(false);
		ca16_va = new JTextField("");
		ca16_va.setBounds(660, 700, 180, 30);
		ca16_va.setEditable(false);
		
		predictlabel = new JLabel("prediction");
		predictlabel.setBounds(620, 265, 100, 30);
		jdtxt0 = new JTextField("");
		jdtxt0.setBounds(710, 265, 20, 30);
		jdtxt0.setEditable(false);
		jdtxt1 = new JTextField("");
		jdtxt1.setBounds(750, 265, 20, 30);
		jdtxt1.setEditable(false);
		BPlabel = new JLabel("BP");
		BPlabel.setBounds(700, 290, 100, 30);
		BPtxt = new JTextField("");
		BPtxt.setBounds(600, 315, 200, 30);
		BPtxt.setEditable(false);
		
		add(runbutton);
		add(ssbutton);
		add(load1button);
		add(load2button);
		add(load3button);
		add(GDRlabel);
		add(GDRlabel0);
		add(GDRlabel1);
		add(GDRlabel2);
		add(GDRlabel3);
		add(GDRtxt0);
		add(GDRtxt1);
		add(GDRtxt2);
		add(GDRtxt3);
		add(IXlabel);
		add(IXlabel1);
		add(IXlabel2);
		add(IXlabel3);
		add(IXtxt1);
		add(IXtxt2);
		add(IXtxt3);

		add(MARlabel);
		add(MARtxt);
		add(MBRlabel);
		add(MBRtxt);
		add(MEMlabel);
		add(MEMtxt);
		add(IRlabel);
		add(IRtxt);
		add(PClabel);
		add(PCtxt);
		add(r0button);
		add(r1button);
		add(r2button);
		add(r3button);
		add(pcButton);
		add(mar_op);
		add(mem_op);
		add(mar_edit);
		add(mem_edit);
		add(memquery);
		add(memedit);
		add(keyboardtxt);
		add(keyboardlabel);
		add(printertxt);
		add(printerlabel);
		add(CClabel0);
		add(CClabel1);
		add(CClabel2);
		add(CClabel3);
		add(CCtxt0);
		add(CCtxt1);
		add(CCtxt2);
		add(CCtxt3);
		add(MSRlabel);
		add(MSRtxt);
		
		add(cachelabel);
		add(cacheAddress1);
		add(cacheValue1);
		add(cacheAddress2);
		add(cacheValue2);
		add(ca1label);
		add(ca2label);
		add(ca3label);
		add(ca4label);
		add(ca5label);
		add(ca6label);
		add(ca7label);
		add(ca8label);
		add(ca9label);
		add(ca10label);
		add(ca11label);
		add(ca12label);
		add(ca13label);
		add(ca14label);
		add(ca15label);
		add(ca16label);
		add(ca1_ad);
		add(ca1_va);
		add(ca2_ad);
		add(ca2_va);
		add(ca3_ad);
		add(ca3_va);
		add(ca4_ad);
		add(ca4_va);
		add(ca5_ad);
		add(ca5_va);
		add(ca6_ad);
		add(ca6_va);
		add(ca7_ad);
		add(ca7_va);
		add(ca8_ad);
		add(ca8_va);
		add(ca9_ad);
		add(ca9_va);
		add(ca10_ad);
		add(ca10_va);
		add(ca11_ad);
		add(ca11_va);
		add(ca12_ad);
		add(ca12_va);
		add(ca13_ad);
		add(ca13_va);
		add(ca14_ad);
		add(ca14_va);
		add(ca15_ad);
		add(ca15_va);
		add(ca16_ad);
		add(ca16_va);
		
		add(predictlabel);
		add(BPtxt);
		add(BPlabel);
		add(jdtxt0);
		add(jdtxt1);
		
		runbutton.addActionListener(this);
		ssbutton.addActionListener(this);
		load1button.addActionListener(this);
		load2button.addActionListener(this);
		load3button.addActionListener(this);
		// add actionlistener to achieve function of UI
		// achieve function that textfield GDR0 can read the value
		r0button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GDR[0] = Integer.parseInt(GDRtxt0.getText(),2);
				JOptionPane.showMessageDialog(null, "change R0 to " + GDRtxt0.getText(), "attention",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// achieve function that textfield GDR1 can read the value
		r1button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GDR[1] = Integer.parseInt(GDRtxt1.getText(),2);
				JOptionPane.showMessageDialog(null, "change R1 to " + GDRtxt1.getText(), "attention",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// achieve function that textfield GDR2 can read the value
		r2button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GDR[2] = Integer.parseInt(GDRtxt2.getText(),2);
				JOptionPane.showMessageDialog(null, "change R2 to " + GDRtxt2.getText(), "attention",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// achieve function that textfield GDR3 can read the value
		r3button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GDR[3] = Integer.parseInt(GDRtxt3.getText(),2);
				JOptionPane.showMessageDialog(null, "change R3 to " + GDRtxt3.getText(), "attention",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// achieve function which can read the editable value
		memquery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mem_edit.setText(Fromat(Integer.toBinaryString(memory[Integer.parseInt(mar_edit.getText(), 2)]), 16));
			}
		});
		memedit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memory[Integer.parseInt(mar_edit.getText(), 2)] = Integer.parseInt(mem_edit.getText(), 2);
				JOptionPane.showMessageDialog(null, "change memroy " + mar_edit.getText() + " to " + mem_edit.getText(),
						"attention", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// achieve PC function
		pcButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PC = PCtxt.getText();
				JOptionPane.showMessageDialog(null, "change PC to " + PCtxt.getText(), "attention",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	// achieve function that excuse all the code
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == runbutton) {
			while (fh == 0) {
				// convert the value of memory to binary and assign the value to
				// IR
				IR = Fromat(Integer.toBinaryString(memory[Integer.parseInt(PC, 2)]), 16);
				getInCache(PC,IR);
				excuse(IR);
				
				for(int i = 0;i < 4;i++){
					if(GDR[i] >= 65536 && GDR[i] < 131072){
						CC[0] = 1;
					}
					else if(GDR[i] >= 131072 && GDR[i] < 196608){
						CC[1] = 1;
					}
				}
				// convert the value of GDR to binary and assign the value to
				// textfield
				GDRtxt0.setText(Fromat(Integer.toBinaryString(GDR[0]), 16));
				GDRtxt1.setText(Fromat(Integer.toBinaryString(GDR[1]), 16));
				GDRtxt2.setText(Fromat(Integer.toBinaryString(GDR[2]), 16));
				GDRtxt3.setText(Fromat(Integer.toBinaryString(GDR[3]), 16));
				IXtxt1.setText(Fromat(Integer.toBinaryString(IXR[1]), 16));
				IXtxt2.setText(Fromat(Integer.toBinaryString(IXR[2]), 16));
				IXtxt3.setText(Fromat(Integer.toBinaryString(IXR[3]), 16));
				MARtxt.setText(Fromat(Integer.toBinaryString(MAR), 16));
				MBRtxt.setText(Fromat(Integer.toBinaryString(MBR), 16));
				MEMtxt.setText(Fromat(Integer.toBinaryString(MEM), 16));
				CCtxt0.setText(Integer.toBinaryString(CC[0]));
				CCtxt1.setText(Integer.toBinaryString(CC[1]));
				CCtxt2.setText(Integer.toBinaryString(CC[2]));
				CCtxt3.setText(Integer.toBinaryString(CC[3]));

				IRtxt.setText(IR);
				PCtxt.setText(PC);
			}
			if (fh == 1) {
				JOptionPane.showMessageDialog(null, "opcode is over", "attention", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		// achieve function that achieve the code step by step
		if (e.getSource() == ssbutton) {
			// System.out.println(br.readLine());

			if (fh == 0) {
				IR = Fromat(Integer.toBinaryString(memory[Integer.parseInt(PC, 2)]), 16);
				getInCache(PC,IR);
				excuse(IR);
				
				for(int i = 0;i < 4;i++){
					if(GDR[i] >= 65536){
						JOptionPane.showMessageDialog(null, "Character overflow", "attention", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				// convert the value of GDR to binary and assign the value to
				// textfield
				GDRtxt0.setText(Fromat(Integer.toBinaryString(GDR[0]), 16));
				GDRtxt1.setText(Fromat(Integer.toBinaryString(GDR[1]), 16));
				GDRtxt2.setText(Fromat(Integer.toBinaryString(GDR[2]), 16));
				GDRtxt3.setText(Fromat(Integer.toBinaryString(GDR[3]), 16));
				IXtxt1.setText(Fromat(Integer.toBinaryString(IXR[1]), 16));
				IXtxt2.setText(Fromat(Integer.toBinaryString(IXR[2]), 16));
				IXtxt3.setText(Fromat(Integer.toBinaryString(IXR[3]), 16));
				MARtxt.setText(Fromat(Integer.toBinaryString(MAR), 16));
				MBRtxt.setText(Fromat(Integer.toBinaryString(MBR), 16));
				MEMtxt.setText(Fromat(Integer.toBinaryString(MEM), 16));
				CCtxt0.setText(Integer.toBinaryString(CC[0]));
				CCtxt1.setText(Integer.toBinaryString(CC[1]));
				CCtxt2.setText(Integer.toBinaryString(CC[2]));
				CCtxt3.setText(Integer.toBinaryString(CC[3]));
				IRtxt.setText(IR);
				PCtxt.setText(PC);
			} else if (fh == 1) {
				JOptionPane.showMessageDialog(null, "opcode is over", "attention", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		// achieve the function of load button to load code in text field
		if (e.getSource() == load1button) {
			File file = new File("src/code1.txt");
			String tmp;
			ir_lenth = 0;
			try {
				br = new BufferedReader(new FileReader(file));
				try {
					fh = 0;
					while ((tmp = br.readLine()) != null) {

						memory[ir_lenth] = Integer.parseInt(tmp, 2);
						ir_lenth++;

					}
					PC = "000000000000";

					JOptionPane.showMessageDialog(null, "Total ops:" + ir_lenth, "attention",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == load2button) {
			File file = new File("src/code2.txt");
			String tmp;
			ir_lenth = 0;
			try {
				br = new BufferedReader(new FileReader(file));
				try {
					fh = 0;
					while ((tmp = br.readLine()) != null) {

						memory[ir_lenth] = Integer.parseInt(tmp, 2);
						ir_lenth++;

					}
					PC = "000000000000";

					JOptionPane.showMessageDialog(null, "Total ops:" + ir_lenth, "attention",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == load3button) {
			File file = new File("src/code3.txt");
			String tmp;
			ir_lenth = 0;
			try {
				br = new BufferedReader(new FileReader(file));
				try {
					fh = 0;
					while ((tmp = br.readLine()) != null) {

						memory[ir_lenth] = Integer.parseInt(tmp, 2);
						ir_lenth++;

					}
					PC = "000000000000";

					JOptionPane.showMessageDialog(null, "Total ops:" + ir_lenth, "attention",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	// format parameters
	public static String Fromat(String s, int i) {
		String t = s;
		if(t.length() > i){
			t = t.substring(t.length()-16,t.length());
		}
		
		while (t.length() < i) {
			t = "0" + t;
		}

		return t;
	}
	
	/*public static int trans(String binary){
		 int x = 0;
	     for(char c: binary.toCharArray())
	          x = x * 2 + (c == '1' ? 1 : 0);
	     return x;
	}*/
	
	public static void getInCache(String address, String val){
		if(address.equals(ca1_ad.getText()) == false && address.equals(ca2_ad.getText()) == false
				&& address.equals(ca3_ad.getText()) == false
				&& address.equals(ca4_ad.getText()) == false
				&& address.equals(ca5_ad.getText()) == false
				&& address.equals(ca6_ad.getText()) == false
				&& address.equals(ca7_ad.getText()) == false
				&& address.equals(ca8_ad.getText()) == false
				&& address.equals(ca9_ad.getText()) == false
				&& address.equals(ca10_ad.getText()) == false
				&& address.equals(ca11_ad.getText()) == false
				&& address.equals(ca12_ad.getText()) == false
				&& address.equals(ca13_ad.getText()) == false
				&& address.equals(ca14_ad.getText()) == false
				&& address.equals(ca15_ad.getText()) == false
				&& address.equals(ca16_ad.getText()) == false){
			
			if(cacheCount == 1){
				ca1_ad.setText(address);
				ca1_va.setText(val);
			}
			else if(cacheCount == 2){
				ca2_ad.setText(address);
				ca2_va.setText(val);
			}
			else if(cacheCount == 3){
				ca3_ad.setText(address);
				ca3_va.setText(val);
			}
			else if(cacheCount == 4){
				ca4_ad.setText(address);
				ca4_va.setText(val);
			}
			else if(cacheCount == 5){
				ca5_ad.setText(address);
				ca5_va.setText(val);
			}
			else if(cacheCount == 6){
				ca6_ad.setText(address);
				ca6_va.setText(val);
			}
			else if(cacheCount == 7){
				ca7_ad.setText(address);
				ca7_va.setText(val);
			}
			else if(cacheCount == 8){
				ca8_ad.setText(address);
				ca8_va.setText(val);
			}
			else if(cacheCount == 9){
				ca9_ad.setText(address);
				ca9_va.setText(val);
			}
			else if(cacheCount == 10){
				ca10_ad.setText(address);
				ca10_va.setText(val);
			}
			else if(cacheCount == 11){
				ca11_ad.setText(address);
				ca11_va.setText(val);
			}
			else if(cacheCount == 12){
				ca12_ad.setText(address);
				ca12_va.setText(val);
			}
			else if(cacheCount == 13){
				ca13_ad.setText(address);
				ca13_va.setText(val);
			}
			else if(cacheCount == 14){
				ca14_ad.setText(address);
				ca14_va.setText(val);
			}
			else if(cacheCount == 15){
				ca15_ad.setText(address);
				ca15_va.setText(val);
			}
			else if(cacheCount == 16){
				ca16_ad.setText(address);
				ca16_va.setText(val);
			}
			
			if(cacheCount == cacheNumber){
				cacheCount = 1;
			}
			else
				cacheCount ++;
		}
			
	}

	// achieve function of excuse
	public static void excuse(String s) {
		op = s.substring(0, 6);
		R = Integer.parseInt(s.substring(6, 8), 2);
		IX = Integer.parseInt(s.substring(8, 10), 2);
		I = Integer.parseInt(s.substring(10, 11), 2);
		Ad = Integer.parseInt(s.substring(11, 16), 2);
		//System.out.println(Ad);
		fh = 0;
		RX = Integer.parseInt(s.substring(6, 8), 2);
		RY = Integer.parseInt(s.substring(8, 10), 2);
		AL = Integer.parseInt(s.substring(8, 9), 2);
		LR = Integer.parseInt(s.substring(9, 10), 2);
		count = Integer.parseInt(s.substring(12, 16), 2);
		DevID = Integer.parseInt(s.substring(11, 16), 2);
		TrapCode = Integer.parseInt(s.substring(12, 16), 2);
		FR = Integer.parseInt(s.substring(6, 8), 2);

		// achieve LDR code
		if (op.equals("000001")) {
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				GDR[R] = memory[MAR];
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				GDR[R] = memory[MAR];
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
		}
		// achieve STR code
		else if (op.equals("000010")) {
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				memory[MAR] = GDR[R];
				if(MAR >= 0 && MAR <= 5){
					trap(0);
				}
				else if(MAR > 2047){
					trap(3);
				}
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				memory[MAR] = GDR[R];
				if(MAR >= 0 && MAR <= 5){
					trap(0);
				}
				else if(MAR > 2047){
					trap(3);
				}
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
		}
		// achieve LDA code
		else if (op.equals("000011")) {
			if (I == 0) {
				MAR = Ad + IXR[IX];
				GDR[R] = MAR;
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);

			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				GDR[R] = memory[MAR];
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
		}
		// achieve LDX code
		else if (op.equals("101001")) {

			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				IXR[IX] = memory[MAR];
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);

			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				IXR[IX] = memory[MAR];
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
		}
		// achieve STX code
		else if (op.equals("101010")) {
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				memory[MAR] = IXR[IX];
				if(MAR >= 0 && MAR <= 5){
					trap(0);
				}
				else if(MAR > 2047){
					trap(3);
				}
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);

			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				memory[MAR] = IXR[IX];
				if(MAR >= 0 && MAR <= 5){
					trap(0);
				}
				else if(MAR > 2047){
					trap(3);
				}
				MBR = IXR[IX];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
		}
		// achieve AMR code
		else if (op.equals("000100")) {
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				GDR[R] = GDR[R] + memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);

			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				GDR[R] = GDR[R] + memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
		}
		// achieve SMR code
		else if (op.equals("000101")) {
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				GDR[R] = GDR[R] - memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);

			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				GDR[R] = GDR[R] - memory[MAR];
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
		}
		// achieve AIR code
		else if (op.equals("000110")) {
			GDR[R] = GDR[R] + Ad;
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve SIR code
		else if (op.equals("000111")) {
			GDR[R] = GDR[R] - Ad;
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve JZ code
		else if (op.equals("001010")) {
			counter ++;
			if(GDR[R] == 0){
				if (I == 0){
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);

				} else if (I == 1) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MAR = memory[MAR];
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);
				}
			}
			else{
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
			prediction();
		}
		// achieve JNE code
		else if (op.equals("001011")) {
			counter ++;
			if(GDR[R] != 0){
				if (I == 0) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);

				} else if (I == 1) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MAR = memory[MAR];
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);
				}
			}
			else{
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
			prediction();
		} 
		// achieve JCC code
		else if (op.equals("001100")) {
			counter ++;
			if(CC[0] == 1 || CC[1] == 1 || CC[2] == 1 || CC[3] == 1){
				if (I == 0) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);
				} else if (I == 1) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MAR = memory[MAR];
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);
				}
			}
			else{
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
			prediction();
		} 
		// achieve JMA code
		else if (op.equals("001101")) {
			counter ++;
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(MAR), 12);
			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(MAR), 12);	
			}
			prediction();
		} 
		// achieve JSR code
		else if (op.equals("001110")) {
			counter ++;
			GDR[3] = Integer.parseInt(PC,2) + 1;
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(MAR), 12);
			} else if (I == 1) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MBR = memory[MAR];
				MEM = memory[MAR];
				PC = Fromat(Integer.toBinaryString(MAR), 12);	
			}
			prediction();
		} 
		// achieve RFS code
		else if (op.equals("001111")) {
			counter ++;
			GDR[0] = Ad;
			PC = Fromat(Integer.toBinaryString(GDR[3]) ,12);
			prediction();
		}
		// achieve SOB code
		else if (op.equals("010000")) {
			counter ++;
			R = GDR[R]-1;
			if(GDR[R] > 0){
				if (I == 0) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);
				} else if (I == 1) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MAR = memory[MAR];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);	
				}
			}
			else{
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
			prediction();
		} 
		// achieve JGE code
		else if (op.equals("010001")) {
			counter ++;
			if(GDR[R] >= 0){
				if (I == 0) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);
				} else if (I == 1) {
					MAR = Ad + IXR[IX];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MAR = memory[MAR];
					getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
					MBR = memory[MAR];
					MEM = memory[MAR];
					PC = Fromat(Integer.toBinaryString(MAR), 12);	
				}
			}
			else{
				PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
			}
			prediction();
		} 
		// achieve MLT code
		else if (op.equals("010100")) {
			if(RX <= 2 && RX >= 0){
				String tem = Integer.toBinaryString(GDR[RX]*GDR[RY]);
				GDR[RX] = Integer.parseInt(Fromat(tem,34).substring(0, 18), 2);
				GDR[RX+1] = Integer.parseInt(Fromat(tem,34).substring(18, 34), 2);
			}
			else 
				JOptionPane.showMessageDialog(null, "Rx only can be set 0-2", "attention", JOptionPane.ERROR_MESSAGE);
			    PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve DVD code
		else if (op.equals("010101")) {
			if(RX <= 2 && RX >= 0){
				if(GDR[RY] == 0){
					CC[2] = 1;
				}
				else{
					GDR[RX] = GDR[RX]/GDR[RY];
					GDR[RX+1] = GDR[RX]%GDR[RY];
				}
			}
			else 
				JOptionPane.showMessageDialog(null, "Rx only can be set 0-2", "attention", JOptionPane.ERROR_MESSAGE);
			    PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve TRR code
		else if (op.equals("010110")) {
			if(GDR[RX] == GDR[RY]){
				CC[3] = 1;
			}
			else
				CC[3] = 0;
			
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve AND code
		else if (op.equals("010111")) {
			GDR[RX] = GDR[RX] & GDR[RY];
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve ORR code
		else if (op.equals("011000")) {
			GDR[RX] = GDR[RX] | GDR[RY];
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve NOT code
		else if (op.equals("011001")) {
			GDR[RX] = ~GDR[RX];
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve TRAP  code
		else if (op.equals("011110")) {
			MSR = TrapCode;
			MSRtxt.setText(Integer.toBinaryString(MSR));
			if(TrapCode == 0){
				JOptionPane.showMessageDialog(null, "Illegal Memory Address to Reserved Locations", "attention", JOptionPane.ERROR_MESSAGE);
				fh = 1;
			}
			else if(TrapCode == 1){
				JOptionPane.showMessageDialog(null, "Illegal TRAP code", "attention", JOptionPane.ERROR_MESSAGE);
				fh = 1;
			}
			else if(TrapCode == 2){
				JOptionPane.showMessageDialog(null, "Illegal Operation Code", "attention", JOptionPane.ERROR_MESSAGE);
				fh = 1;
			}
			else if(TrapCode == 3){
				JOptionPane.showMessageDialog(null, "Illegal Memory Address beyond 2048", "attention", JOptionPane.ERROR_MESSAGE);
				fh = 1;
			}
			else{
				trap(1);
			}
			
		}
		// achieve SRC code
		else if (op.equals("011111")) {
			if(count != 0){
				if(AL == 0){
					if(LR == 1){
						GDR[R] = GDR[R] << count;
					}	
					else if(LR == 0){
						GDR[R] = GDR[R] >> count;
					}
				}
				else if(AL == 1){
					if(LR == 1){
						/*String first;
						first = Fromat(Integer.toBinaryString(GDR[R]), 16).substring(0,1);
						GDR[R] = GDR[R] << count;
						StringBuilder sb = new StringBuilder(Fromat(Integer.toBinaryString(GDR[R]), 16));
						sb.replace(0, 1,first);
		 				GDR[R] = Integer.parseInt(sb,2);*/
						GDR[R] = GDR[R] << count;
					}	
					if(LR == 0){
						GDR[R] = GDR[R] >>> count;
					}
				}
			}
			
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve RRC code
		else if (op.equals("100000")) {
			if(AL == 1){
				String reverse ="";
				String old =  Fromat(Integer.toBinaryString(GDR[R]),16).substring(1, 16);
				String first = Fromat(Integer.toBinaryString(GDR[R]),16).substring(0,1);
				if(LR == 1){				
					for(int i = 0; i < count; i++){
						reverse = old.charAt(i)+reverse;
					}
					for(int j = 14; j > count-1; j--){
						reverse = old.charAt(j)+reverse ;
					}
				}
				else if(LR == 0){
					for(int i = 14; i > 14-count; i--){
						reverse = reverse + old.charAt(i);
					}
					for(int j = 0; j < 15-count; j++){
						reverse = reverse + old.charAt(j);
					}
				}
				reverse = first + reverse;
				GDR[R] = Integer.parseInt(reverse,2);
			}
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve IN code
		else if (op.equals("111101")) {
			if(DevID == 0){
				
				try {
					GDR[R] = Integer.valueOf(keyboardtxt.getText()).intValue();
				} catch (NumberFormatException e) {
					char[] strChar = keyboardtxt.getText().toCharArray();
					GDR[R] = Integer.valueOf(strChar[0]).intValue();
				}
				System.out.println(GDR[R]);
				//keyboardtxt.setText("");
			}
			else if(DevID == 1){
				GDR[R] = Integer.parseInt(printertxt.getText());
			}
			else if(DevID == 2){
				
			}
			else {
				GDR[R] = CR[DevID-3];
			}
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve OUT code
		else if (op.equals("111110")) {
			if(DevID == 0){
				keyboardtxt.setText(String.valueOf(GDR[R]));
			}
			
			else if(DevID == 1){
				if(GDR[R] >= 97 && GDR[R] <= 122 || GDR[R] == 32 || GDR[R] == 10){
					char word;
					word = (char)GDR[R];
					pText = pText+word;
				}
				else{
					pText = pText+String.valueOf(GDR[R]);
				}
				
				printertxt.setText(pText);
			}
			
			else if(DevID == 2){
				
			}
			else {
				CR[DevID-3] = GDR[R];
			}
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve CHK code
		else if (op.equals("111111")) {
			GDR[R] = DevID;
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve VADD code
		else if (op.equals("100011")) {
			if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				getInCache(Fromat(Integer.toBinaryString(MAR+1),12), Fromat(Integer.toBinaryString(memory[MAR+1]),16));
				MBR = memory[MAR];
				firstVector = MBR;
				secondVector = memory[MAR+1];
				MEM = memory[MAR];
				for(int i = 0; i < GDR[FR]; i++){
					memory[firstVector+i] = memory[firstVector+i] + memory[secondVector+i];
					getInCache(Fromat(Integer.toBinaryString(firstVector+i),12), Fromat(Integer.toBinaryString(memory[firstVector+i]),16));
					getInCache(Fromat(Integer.toBinaryString(secondVector+i),12), Fromat(Integer.toBinaryString(memory[secondVector+i]),16));
				}
				//System.out.println(memory[firstVector]);
				//System.out.println(memory[secondVector]);
			}
			else if(I == 1){
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				getInCache(Fromat(Integer.toBinaryString(MAR+1),12), Fromat(Integer.toBinaryString(memory[MAR+1]),16));
				MBR = memory[MAR];
				firstVector = MBR;
				secondVector = memory[MAR+1];
				MEM = memory[MAR];
				for(int i = 0; i < GDR[FR]; i++){
					memory[firstVector+i] = memory[firstVector+i] + memory[secondVector+i];
					getInCache(Fromat(Integer.toBinaryString(firstVector+i),12), Fromat(Integer.toBinaryString(memory[firstVector+i]),16));
					getInCache(Fromat(Integer.toBinaryString(secondVector+i),12), Fromat(Integer.toBinaryString(memory[secondVector+i]),16));
				}
			}
			PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
		}
		// achieve VSUB code
        else if (op.equals("100100")) {
        	if (I == 0) {
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				getInCache(Fromat(Integer.toBinaryString(MAR+1),12), Fromat(Integer.toBinaryString(memory[MAR+1]),16));
				MBR = memory[MAR];
				firstVector = MBR;
				secondVector = memory[MAR+1];
				MEM = memory[MAR];
				for(int i = 0; i < GDR[FR]; i++){
					memory[firstVector+i] = memory[firstVector+i] - memory[secondVector+i];
					getInCache(Fromat(Integer.toBinaryString(firstVector+i),12), Fromat(Integer.toBinaryString(memory[firstVector+i]),16));
					getInCache(Fromat(Integer.toBinaryString(secondVector+i),12), Fromat(Integer.toBinaryString(memory[secondVector+i]),16));
				}
				//System.out.println(memory[firstVector]);
				//System.out.println(memory[secondVector]);
			}
			else if(I == 1){
				MAR = Ad + IXR[IX];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				MAR = memory[MAR];
				getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
				getInCache(Fromat(Integer.toBinaryString(MAR+1),12), Fromat(Integer.toBinaryString(memory[MAR+1]),16));
				MBR = memory[MAR];
				firstVector = MBR;
				secondVector = memory[MAR+1];
				MEM = memory[MAR];
				for(int i = 0; i < GDR[FR]; i++){
					memory[firstVector+i] = memory[firstVector+i] - memory[secondVector+i];
					getInCache(Fromat(Integer.toBinaryString(firstVector+i),12), Fromat(Integer.toBinaryString(memory[firstVector+i]),16));
					getInCache(Fromat(Integer.toBinaryString(secondVector+i),12), Fromat(Integer.toBinaryString(memory[secondVector+i]),16));
				}
			}
        	PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
        	
		}
		// achieve FADD code
       /* else if (op.equals("100001")) {
        	if (I == 0) {
        		MAR = Ad + IXR[IX];
        		getInCache(Fromat(Integer.toBinaryString(MAR),12), Fromat(Integer.toBinaryString(memory[MAR]),16));
        		String str1 = Fromat(Integer.toBinaryString(memory[MAR]),16);
        		int s1 = Integer.parseInt(str1.substring(0,1),2);
        		int exponent1 = Integer.parseInt(str1.substring(1,8),2) - 63;
        		String mantissa1 = str1.substring(8,16);
        		float f1 = Float.parseFloat(mantissa1)/100000000+1;
        		
        		String str2 = Fromat(Integer.toBinaryString(GDR[R]),16);
        		int s2 = Integer.parseInt(str2.substring(0,1),2);
        		int exponent2 = Integer.parseInt(str2.substring(1,8),2) - 63;
        		int mantissa2 = Integer.parseInt(str2.substring(8,16),2);
        		float f2 = Float.parseFloat(mantissa1)/100000000+1;
        		
        		float float1 = 0;
        		float float2 = 0;
        		
        		if(exponent1>64 || exponent1<-63 || exponent2>64 || exponent2<-63){
        			CC[0] = 1;
        		}
        		else{
        			float num1 = (float) (Math.pow(10,(float)exponent1)*f1);
        			float num2 = (float) (Math.pow(10,(float)exponent2)*f2);
            		if(s1 == 0){
            			float1 = floatToDecimal(num1);
            		}
            		else{
            			float1 = -floatToDecimal(num1);
            		}
            		
            		if(s2 == 0){
            			float2 = floatToDecimal(num2);
            		}
            		else{
            			float2 = -floatToDecimal(num2);
            		}
            	
        		}
        		float sum = float1 + float2;
        		
        		GDR[R] = Integer.parseInt(floatToBinary(sum),2);
        	}
        	PC = Fromat(Integer.toBinaryString(Integer.parseInt(PC, 2) + 1), 12);
        }*/
		
		else {
			trap(2);
			//JOptionPane.showMessageDialog(null, "error in PC", "attention", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void trap(int code){
		memory[0] = Integer.parseInt("011110000000"+Fromat(Integer.toBinaryString(code),4),2);
		PC = Fromat(Integer.toBinaryString(0),12);
		memory[2] = Integer.parseInt(PC,2);
		
	}
	
	/*public static float floatToDecimal(float f){
		float decimal = 0;
		int integ = (int)f;
		String floa = String.valueOf((f - integ) * 32);
		int intpart = Integer.valueOf(String.valueOf(integ),2);
		float floatpart = 0;
		for(int i = 0; i<63 ;i++){
			floatpart = (float)(Math.pow(Float.parseFloat(floa.substring(i)),(float) -(i+1)))+floatpart;
		}
		decimal = intpart + floatpart;
		return decimal;
	}
	
	public static String floatToBinary(float f){
		String s;
		String exponent;
		String mantissa;
		
		if(f > 0){
			s = "0";
		}
		else {
			s = "1";
		}
		
		String intpart = Integer.toBinaryString((int)f);
		exponent = Fromat(Integer.toBinaryString(intpart.length()-1+63),7);
		
		float newfloat = (float) (f/(Math.pow(10, intpart.length()-1)));
		int floatpart = (int) ((newfloat-(int)newfloat) * Math.pow(10, 8));
		mantissa = Fromat(Integer.toBinaryString(floatpart),8);
		
		return s+exponent+mantissa;
		
	}*/
	
	public static void prediction(){
		String instruction = Fromat(Integer.toBinaryString(memory[Integer.parseInt(PC, 2)]), 16);
		if(counter == 1){
			BP = instruction;
		}
		else{
			if(judge1 == 0 && judge2 == 0){
				if(instruction.equals(BP) == false){
					BP = instruction;
				}
				else{
					judge2 = 1;
				}
			}
			else if(judge1 == 0 && judge2 == 1){
				if(instruction.equals(BP) == false){
					judge2 = 0;
				}
				else{
					judge1 = 1;
				}
			}
			else if(judge1 == 1 && judge2 == 1){
				if(instruction.equals(BP) == false){
					judge2 = 0;
				}
				else{
					IR = BP;
				}
			}
			else if(judge1 == 1 && judge2 == 0){
				if(instruction.equals(BP) == false){
					judge1 = 0;
				}
				else{
					IR = BP;
					judge2 = 1;
				}
			}
			
		}
		BPtxt.setText(BP);
		jdtxt0.setText(String.valueOf(judge1));
		jdtxt1.setText(String.valueOf(judge2));
	}

	public static void main(String args[]) throws FileNotFoundException {
		part1 p = new part1();
		p.setVisible(true);
		// set the value of memory
		for (int i = 0; i < 2048; i++) {
			memory[i] = i + 1;
		}
		System.out.println("please enter instruction:");
		System.out.println("end");

	}

}

