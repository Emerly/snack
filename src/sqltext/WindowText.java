package sqltext;

import java.util.*;
import java.util.List;
import java.applet.*;import java.awt.*;
import javax.swing.*;import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
public class WindowText extends JFrame implements ActionListener{
    public static JTextField textA;
    static JTextArea textF;static JButton b1;
	static JButton b2;
     public static void main(String args[]){
    	 WindowText ex = new WindowText();
        ex.setSize(800,800);
        ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = ex.getContentPane();
        c.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        textA=new JTextField("",20);
        Font x = new Font("Serif",0,20);
        textA.setBackground(Color.white);
        textA.setFont(x);
        textF=new JTextArea("",8,20);
        textF.setBackground(Color.pink);
        textF.setFont(x);
        JScrollPane js = new JScrollPane(textF);
        textF.setEditable(false);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(textA);
        panel1.add(js);
        b1=new JButton("查询结果"); 
        b2=new JButton("重新开始");
        panel2.add(b1);
        panel2.add(b2);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        ex.setVisible(true);
        b1.addActionListener(ex); b2.addActionListener(ex);
        c.add(panel1);c.add(panel2);
    }
    /*private JPanel getGUI() {
    	JPanel p = new JPanel();
    	p.setLayout(new BorderLayout(5,5));
    	p.add(textA,"West"); p.add(textF,"West"); p.add(b1,"East");p.add(b2,"East");
		return p;
	}*/
	public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            String s=textA.getText();
            String st = s.substring(0, 7).trim();
            List<student> list = new ArrayList<student>();
            if (st.equals("select")) {
				list = selectdb.excutequery(s);
			} else {
				list = selectdb.excute(s);
			}
           //textF.setText(""+sum);
            textF.setText(result(list));
            writetofile(result(list));
        }
        else if(e.getSource()==b2){
            textA.setText(null);
            textF.setText(null);
        }
    }
    
    private void writetofile(String result){
    	String res = result;
    	String path = "d:/workplace/demo1.txt";
    	File file;
    	
    	file = new File(path);
    	if(!file.exists()){
    	try {
    	   file.createNewFile();
    	} catch (Exception e) {
    	     e.printStackTrace();
    	}}
    	
    	PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream(file, true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	out.println(res);
    	out.close();
	}
    	
	public static String result(List<student> s){
    	List<student> list = s;
    	String sum = "";
    	for (int i = 0; i < list.size(); i++) {
			sum = sum + list.get(i).toString() +"\n";
		}
    	return sum;
    	
    }
}
