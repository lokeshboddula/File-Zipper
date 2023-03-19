package GUI;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("File Zipper");
        this.setLocation(400, 200);
        compressButton = new JButton("select files to compress");
        compressButton.setBounds(30, 100, 200, 50);
        compressButton.addActionListener(this);

        decompressButton = new JButton("select files to decompress");
        decompressButton.setBounds(250, 100, 200, 50);
        decompressButton.addActionListener(this);


        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500, 300);
        this.getContentPane().setBackground(Color.decode("#413290"));
        Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/Hp/Downloads/12.png");
        this.setIconImage(icon);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Compressor.method(file);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }

        if(event.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
