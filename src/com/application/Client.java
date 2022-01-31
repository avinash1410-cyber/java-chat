package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {
    JPanel jpl;
    JTextField T1;
    JButton b1;
    static JTextArea T2;

    static Socket sktc;
    static DataOutputStream opc;
    static DataInputStream ipc;

    Client(){
        jpl=new JPanel();
        jpl.setLayout(null);
        jpl.setBackground(new Color(7,94,84));
        jpl.setBounds(0,0,320,80);


        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("com/application/Icons/arrow.jpg"));
        Image img2=img1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel L=new JLabel(img3);
        L.setBounds(5,5,30,20);
        jpl.add(L);
        L.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });



        ImageIcon img4=new ImageIcon(ClassLoader.getSystemResource("com/application/Icons/1.png"));
        Image img5=img4.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon img6=new ImageIcon(img5);
        JLabel L2=new JLabel(img6);
        L2.setBounds(45,5,60,40);

        add(L2);
        add(jpl);


        JLabel L3=new JLabel("Gaitonde");
        L3.setBounds(45,45,100,20);
        L3.setForeground(Color.WHITE);
        add(L3);
        add(jpl);

        JLabel L4=new JLabel("active");
        L4.setBounds(40,65,100,20);
        L4.setForeground(Color.WHITE);
        add(L4);
        add(jpl);



        ImageIcon img7=new ImageIcon(ClassLoader.getSystemResource("com/application/Icons/phone.png"));
        Image img8=img7.getImage().getScaledInstance(20,30,Image.SCALE_DEFAULT);
        ImageIcon img9=new ImageIcon(img8);
        JLabel L5=new JLabel(img9);
        L5.setBounds(150,35,100,20);
        L5.setForeground(Color.WHITE);
        add(L5);
        add(jpl);


        ImageIcon img10=new ImageIcon(ClassLoader.getSystemResource("com/application/Icons/video.png"));
        Image img11=img10.getImage().getScaledInstance(20,30,Image.SCALE_DEFAULT);
        ImageIcon img12=new ImageIcon(img11);
        JLabel L6=new JLabel(img12);
        L6.setBounds(190,35,100,20);
        L6.setForeground(Color.WHITE);
        add(L6);
        add(jpl);


        ImageIcon img13=new ImageIcon(ClassLoader.getSystemResource("com/application/Icons/3icon.png"));
        Image img14=img13.getImage().getScaledInstance(10,20,Image.SCALE_DEFAULT);
        ImageIcon img15=new ImageIcon(img14);
        JLabel L7=new JLabel(img15);
        L7.setBounds(240,35,100,20);
        L7.setForeground(Color.WHITE);
        add(L7);
        add(jpl);






        T1=new JTextField();
        b1=new JButton("Send");
        T1.setBounds(0,400,200,50);
        add(T1);

        b1.setBounds(210,400,90,50);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this::actionPerformed);
        add(b1);

        T2=new JTextArea();
        T2.setBounds(0,90,320,300);
        T2.setEditable(false);
        T2.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        T2.setLineWrap(true);
        T2.setWrapStyleWord(true);
        T2.setBackground(Color.CYAN);
        add(T2);


        setLayout(null);
        setSize(320,450);
        setLocation(10,100);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {


            String getText = T1.getText();
            T2.setText(T2.getText() + "\n\t\t" + getText);
            opc.writeUTF(getText);
            T1.setText("");

        }
        catch (Exception exception){

        }

    }




    public static void main(String[] args){
        new Client().setVisible(true);
        try{
sktc=new Socket("127.0.0.1",7001);
ipc=new DataInputStream(sktc.getInputStream());
opc=new DataOutputStream(sktc.getOutputStream());

String msg="";
msg=ipc.readUTF();
      T2.setText(T2.getText()+"\n"+msg);

        }
        catch (Exception e){

        }
    }


}
