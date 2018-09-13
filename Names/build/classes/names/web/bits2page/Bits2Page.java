/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package names.web.bits2page;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import panels.Panel4T5Locator;

/**

 @author Mark Ferguson
 */
public class Bits2Page extends javax.swing.JPanel {

   //<editor-fold defaultstate="collapsed" desc="variables">
  //<editor-fold defaultstate="collapsed" desc="String about">
  private static final String about = "ABOUT\n"
    + "\n" + "<br/>"
    + "Programmed by Mark Ferguson	(maggot.iiss@sky.com)\n" + "<br/>" + "\n"
    + "https://github.com/MaggotIISS\n" + "<br/>"
    + "\n" + "<br/>"
    + "The Traveller game in all forms is owned by Far Future Enterprises. \n" + "<br/>"
    + "Copyright 1977 - 2018 Far Future Enterprises. \n" + "<br/>"
    + "\n" + "<br/>"
    + "Traveller is a registered trademark of Far Future Enterprises. \n" + "<br/>"
    + "Far Future permits web sites and fanzines for this game, provided \n" + "<br/>"
    + "it contains this notice, that Far Future is notified, and subject \n" + "<br/>"
    + "to a withdrawal of permission on 90 days notice. \n" + "<br/>"
    + "\n" + "<br/>"
    + "The contents of this site are for personal, non-commercial use only. \n" + "<br/>"
    + "\n" + "<br/>"
    + "Any use of Far Future Enterprises's copyrighted material or \n" + "<br/>"
    + "trademarks anywhere on this web site and its files should not \n" + "<br/>"
    + "be viewed as a challenge to those copyrights or trademarks. \n" + "<br/>"
    + "In addition, any program/articles/file on this site cannot be \n" + "<br/>"
    + "republished or distributed without the consent of \n" + "<br/>"
    + "the author who contributed it." + "<br/>";
  //</editor-fold>
  private static final String CRLF = "\n";
  private static String all = "";
  private static String drive = "C:";
  private static String path = "T5";
  private static String sector = "Vland";
  private static String subsector = "P Kakadan";
  private static String system = "2737 Kesali";
  private static String secdata = "";
  private static String uri = "";
  private static String[] files;
  private static JPanel jp;
  private static JFrame jf;
  private static BorderLayout bl;
  private static JComboBox<String> cb;
  private static String filename = "2737 Kesali";
  private static String text = "";
  private static int count = 0;
  private static File f, file;
  private String[] lines;
  private String line = "";
  private static String name = "";
  private String fname = "";
  private String start = "<!-- ";
  private String end = " -->";
  private static String startfolder;
  private String add = "";
  private String s = "";
  private File fil;
  private String[] strings = {".gif"};
  private String part;
  private String ext;
  private final static String FS = "/";
  private int pages = 0;
  static String hex;
  private static String[] kakadan = {"2531 Kiddinu", "2533 Aki", "2534 Zerapii", "2536 Linissa", "2539 Nunaat", "2540 Kalaalit", "2631 Kane", "2634 Wakarsat", "2636 Kakadan", "2637 Akon", "2640 Statia", "2732 Dnak'kritz", "2733 Jarmat", "2734 Rambant", "2737 Kesali", "2738 Tepmaa", "2739 Sg'aa", "2740 P'ginzh", "2831 Kiimzhal", "2832 Telkaa", "2836 Inushir", "2837 Piazza", "2839 Zombagu", "2931 Icuspin", "2932 Zanski", "2933 Kanat", "2934 Assazak", "2936 Elafdt", "2938 Punnari", "2939 Teralvar", "3031 New Salen", "3032 Matuyama", "3035 Zhanora", "3037 Raanbazziil", "3039 Gilnat Paz", "3131 Maamibrin", "3134 Toborit", "3135 Debekov", "3137 Alleman", "3138 Nasaa", "3140 Zana", "3231 Vanutappan", "3232 Tamayo", "3235 Debort", "3237 Zhannag", "3238 Lamiina", "3239 Lannazol"};
  private static String[] sallounn = {"1623 Fraynj"};
  private static String[] regina = {"1910 Regina", "2007 Roup", "2005 Feri", "1904 Boughene", "1705 Efate"};
  private static String[] jewell = {"1307 Lysen", "1106 Jewell"};
  private static String[] solomani = {"1827 Terra"};
  private static String[] district = {"1237 Collace"};
  private static String[] sword = {"1526 Biter"};
  private static String[] five = {"0534 Karin"};
  private static String[] core = {"2118 Capital"};
  private static String[][] campaigns = {kakadan, sallounn, regina, jewell, solomani, district, sword, five, core};
  private String[] folders = {
    "C:/T5/Vland/P Kakadan",
    "C:/T5/Gushemege/J Sallounn",
    "C:/T5/Spinward Marches/C Regina",
    "C:/T5/Spinward Marches/B Jewell",
    "C:/T5/Solomani Rim/K Sol",
    "C:/T5/Spinward Marches/N District 268",
    "C:/T5/Spinward Marches/J Sword Worlds",
    "C:/T5/Spinward Marches/M Five Sisters",
    "C:/T5/Core/G Core"
  };
  //</editor-fold>
  //C:\T5\Spinward Marches\C Regina\

  public static void main(String[] args) {
    //
    JPanel jp = new Bits2Page(args);
    JFrame jf = new JFrame();
    jf.setContentPane(jp);
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    jf.setSize(1200, 400);
    jf.setVisible(true);
    jButton1.doClick();
  }

  /**
   Creates new form Bits2Page2
   @param args
   */
  public Bits2Page(String[] args) {
    initComponents();
    if (args.length > 0) {
      jTextField1.setText(args[0]);
    }
    hex = jTextField3.getText();
    jLabel1.setText("<html><body>&Delta;</body><html>");
    startfolder = jTextField1.getText();
  }

  private void way2() throws IOException {
    jtask.setText("");

    startfolder = jTextField1.getText().replace("\\", "/").replace("//", "/").trim();
    jTextField1.setText(startfolder);
    f = new File(startfolder);
    part = startfolder.substring(startfolder.lastIndexOf('/') + 1);
    ext = ".html";
    String all = startfolder + ext;
    String[] files = f.list();
    savePage(all, startfolder);
    for (int i = 0; i < files.length; i++) {
      fil = new File(startfolder + "/" + files[i]);
      if ((isHexDir(files[i])) & (fil.isDirectory())) {
        f = new File(jTextField1.getText() + "/" + files[i] + ".html");
        savePage(f.toString(), startfolder);
        jtask.append(f.toString().replace("\\", "/") + CRLF);
      }
    }
    System.out.println("pages" + " = " + pages);
    indexSubsector(sector, subsector);
    System.out.println("count" + " = " + count);
    try {
      readSystem();
    } catch (IOException ex) {
      Logger.getLogger(Bits2Page.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void savePage(String filename, String dir) throws IOException {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "" + CRLF;
        //s += "" + " = " + "" + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="String page = ">
    String page = "<!DOCTYPE html>\n"
      + "<!--\n"
      + "-->\n"
      + "<html>\n"
      + "  <head>\n"
      + "    <title>TITLE</title>\n"
      + "    <meta charset=\"UTF-8\">\n"
      + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
      + "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
      + "    <script src=\"https://www.w3schools.com/lib/w3.js\"></script>\n"
      + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
      + "    <!-- traveller/TravellerScripts.js -->\n"
      + "<style>\n"
      + "body {\n"
      + "background-color: white;\n"
      + "color: black;\n"
      + "font-size: 8px;\n"
      + "</body>\n"
      + "</style>\n"
      + "    <script src=\"TravellerScripts.js\"></script>\n"
      + "  </head>\n"
      + "  <body>\n"
      //      + "    " + start + "FILENAME" + end
      + "\n"
      + "    REPLACEME\n"
      + "  </body>\n"
      + "</html>\n"
      + "\n"
      + "\n"
      + "ABOUT\n"
      + "\n"
      + "";
    //</editor-fold>

    jta1.setText(page);
    String tit = "";
    filename = filename.replace("\\", "/");
    if (fil == null) {
      String t = jTextField1.getText().substring(jTextField1.getText().lastIndexOf('/') + 1);
      tit = t;
    } else {
      tit = filename.substring(filename.lastIndexOf(FS) + 1, filename.lastIndexOf('.'));
    }

    jta1.setText(jta1.getText().replace("TITLE", tit));
    lines = jtask.getText().split(CRLF);
//    jta1.setText(jta1.getText().replace("REPLACEME", "REPLACEME"));

    jta1.setText(jta1.getText().replace("REPLACEME", getDirInfo(filename)));
    jta1.setText(jta1.getText().replace("FILENAME", filename));
    jta1.setText(jta1.getText().replace("ABOUT", about));
    System.out.println(filename);
    String in = jta1.getText();
    PrintWriter pw = new PrintWriter(new FileWriter(filename));
    pw.write("<!--" + filename + "-->\n");
    pw.println(in);
    pw.close();
    pages += 1;
    //("Spinward Marches", "C Regina");
  }

  private void indexSubsector(String Sec, String Sub) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "web.Bits2Page.Bits2Page.listSubsector()" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "" + CRLF;
        //s += "" + " = " + "" + CRLF;
        System.out.println(s);
      }
    }
    //</editor-fold>
    Path pathPath = Paths.get(drive, path, Sec, Sub);
    File filepath = pathPath.toFile();
    try {
      String[] sdirs = filepath.list();
      File f = new File("");
      for (int i = 0; i < sdirs.length; i++) {
        f = new File(pathPath + FS + sdirs[i]);
        //<editor-fold defaultstate="collapsed" desc="if (f.isDirectory())">
        if (f.isDirectory()) {
          System.out.println("" + " = " + f.toString());
          filepath = pathPath.toFile();
          File f2 = new File(pathPath + FS + sdirs[i] + FS + sdirs[i]);
          System.out.println("f2.toString()" + " = " + f2.toString());
          if (f2.isDirectory()) {
            try {
              String[] sdirs2 = f2.list();
              for (int j = 0; j < sdirs2.length; j++) {
                System.out.println("sdirs2[" + j + "]" + " = " + sdirs2[j]);
                filepath = new File(pathPath.toFile() + FS + sdirs2[j]);
                count += 1;
                System.out.println("  filepath" + " = " + filepath);
              }
            } catch (Exception e) {
              System.out.println("e" + " = " + e);
            } finally {
            }
          }
        }
        //</editor-fold>
      }
    } catch (Exception e) {
      System.out.println("e" + " = " + e);
    } finally {
    }
  }

  private void loopit() throws IOException {
//    try {
//      loopit();
//
//    } catch (IOException ex) {
//      Logger.getLogger(Bits2Page.class
//        .getName()).log(Level.SEVERE, null, ex);
//    }
//    automate();
    for (int i = 0; i < folders.length; i++) {
      jTextField1.setText(folders[i]);
      //jButton1.doClick();
    }
  }

  private static void automate() {
    all = drive + FS + FS + path + FS + sector + FS + subsector + FS + system + FS + system;
    uri = "file:///" + all;
    for (int i = 0; i < campaigns.length; i++) {
      switch (i) {
        case 0: {
          sector = "Vland";
          subsector = "P Kakadan";
          break;
        }
        case 1: {
          sector = "Gushemege";
          subsector = "J Sallounn";
          break;
        }
        case 2: {
          sector = "Spinward Marches";
          subsector = "C Regina";
          break;
        }
        case 3: {
          sector = "Spinward Marches";
          subsector = "B Jewell";
          break;
        }
        case 4: {
          sector = "Solomani Rim";
          subsector = "K Sol";
          break;
        }
        case 5: {
          sector = "Spinward Marches";
          subsector = "N District 268";
          break;
        }
        case 6: {
          sector = "Spinward Marches";
          subsector = "J Sword Worlds";
          break;
        }
      }

      for (int j = 0; j < campaigns[i].length; j++) {
        system = campaigns[i][j];
        all = drive + FS + FS + path + FS + sector + FS + subsector + FS + system + FS + system;
        filename = all + FS + "Counters.html";
        gifs2Body(all);
        jTextField2.setText(sector);
        jTextField3.setText(system.substring(0, 4));
        jTextField4.setText(system.substring(5));

//        Panel4T5Locator.saveJtas(sector, subsector, system);
      }

    }
  }

  private void readSystem() throws FileNotFoundException, IOException {
    //load .sec file and locate system
    String drive = "C:";
    String T5 = "T5";
    String secfile = drive + FS + T5 + FS + "_SEC" + FS + sector + ".sec";
    secdata = "";
    System.out.println("secfile" + " = " + secfile);
    BufferedReader br = new BufferedReader(new FileReader(secfile));
    String line = "";
    String lines = "";
    String titled = "";
    String[] titles = null;
    String[] parts = null;
    int linenum = 0;
    int world1 = 0;
    while ((line = br.readLine()) != null) {
      lines += line + CRLF;
      secdata += line + CRLF;
      linenum += 1;
      if (line.startsWith("Hex")) {
//        System.out.println("linenum" + " = " + linenum);
        jtask.setText(line + CRLF);
        titled = line;
      }
      if (line.startsWith("----")) {
        world1 = linenum + 1;
        parts = line.split(" ");
        jtask.append(line + CRLF);
        titles = new String[parts.length];
      }
      if (line.startsWith(hex)) {
        jtask.append(line + CRLF);
        int start = 0;
        int end = 0;
        for (int i = 0; i < parts.length; i++) {
          System.out.println("i" + " = " + i);
          if (i < parts.length - 1) {
            end += parts[i].length() + 1;
          } else {
            end = line.length();
          }
          titles[i] = titled.substring(start, end);
//          System.out.println("start" + " = " + start);
//          System.out.println("end" + " = " + end);
//          System.out.println("parts[" + i + "]" + " = " + parts[i]);
//          System.out.println("titles[" + i + "]" + " = " + titles[i]);
//          System.out.println("");
          jtask.append(titled.substring(start, end).trim() + " = ");
          jtask.append(line.substring(start, end).trim() + CRLF);
          start = end;
        }
//        Panel4T5Locator.saveJtas(sector, subsector, system);
      }
    }
    br.close();
  }

  /**

   @param filename the value of filename
   */
  String getDirInfo(String filename) throws FileNotFoundException, IOException {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "web.Bits2Page.Bits2Page.getDirInfo()" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "" + CRLF;
        //s += "" + " = " + "" + CRLF;
        System.out.println(s);
      }
    }
    //</editor-fold>
    String ret = filename.substring(0, filename.length() - 5);
    String add = ret.substring(ret.lastIndexOf('/'));
    String all = ret + add + "/";
    File fi = new File(all);
    String out = all + "</br>" + CRLF;
    String ends = "";
    if (fi.exists()) {
      lines = fi.list();
      String part = null;
      for (int i = 0; i < lines.length; i++) {
        if (lines[i].contains(".")) {
          part = lines[i].substring(lines[i].lastIndexOf('.') + 1);
          if (!ends.contains(part)) {
            ends += part + CRLF;
          }
        }
      }

      String[] liness = ends.split(CRLF);
      for (int i = 0; i < liness.length; i++) {
        for (int j = 0; j < lines.length; j++) {
          if (lines[j].endsWith(liness[i])) {
            if (lines[j].contains(add.substring(1, 5))) {
              if (lines[j].endsWith(".gif")) {
                s = "file:///" + all + lines[j];
                out += "<a href='" + s + "'>" + lines[j].substring(0, lines[j].length() - 4) + "</a><br/>" + CRLF;
                out += "<img src='"
                  + "" + s + "' width='200' height='100' alt='" + s + "'/><br/>" + CRLF;
                s = s.replace(".gif", ".txt");
                File fil = new File(s.substring(8));
//                System.out.println("" + " = " + fil);
                if (fil.exists()) {
                  BufferedReader br = new BufferedReader(new FileReader(s.substring(8)));
                  String lc;
                  while ((lc = br.readLine()) != null) {
                    out += lc + "<br/>" + CRLF;
                  }
                }
              } else if (lines[j].endsWith(".txt")) {
                out += lines[j] + "<br/>" + CRLF;
              } else if (lines[j].endsWith(".html")) {
                out += lines[j] + "<br/>" + CRLF;
//              } else if (lines[j].endsWith(".t5c")) {
//                out += lines[j] + "<br/>" + CRLF;
//              } else if (lines[j].endsWith(".java")) {
//                out += lines[j] + "<br/>" + CRLF;
              }
            }
          }
        }
      }
    }
    return out;
  }

  /**
   This method is called from within the constructor to
   initialize the form.
   WARNING: Do NOT modify this code. The content of this method is
   always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JButton jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtask = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    jta1 = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jTextField3 = new javax.swing.JTextField();
    jTextField4 = new javax.swing.JTextField();
    jTextField5 = new javax.swing.JTextField();

    jButton2.setText("Loop");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("Auto");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton4.setText("Read");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    setPreferredSize(new java.awt.Dimension(1100, 303));
    setRequestFocusEnabled(false);

    jTextField1.setText("C:/T5/Spinward Marches/C Regina");
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1ActionPerformed(evt);
      }
    });

    jButton1.setText("Go");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jtask.setColumns(20);
    jtask.setRows(5);
    jScrollPane1.setViewportView(jtask);

    jta1.setColumns(20);
    jta1.setRows(5);
    jScrollPane2.setViewportView(jta1);

    jLabel1.setText("jLabel1");

    jTextField2.setText("Vland");
    jTextField2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField2ActionPerformed(evt);
      }
    });

    jTextField3.setText("2737");
    jTextField3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField3ActionPerformed(evt);
      }
    });

    jTextField4.setText("Kesali");
    jTextField4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField4ActionPerformed(evt);
      }
    });

    jTextField5.setText("P Kakadan");
    jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextField5MouseClicked(evt);
      }
    });
    jTextField5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField5ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
              .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5)
                .addGap(262, 262, 262)))
            .addComponent(jScrollPane2))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1)
            .addGap(745, 745, 745)))
        .addGap(12, 12, 12))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
//      way1();//show all in one page.  Copy into div on page
      way2();//show each folders worth and save as .html in startfolder

    } catch (IOException ex) {
      Logger.getLogger(Bits2Page.class
        .getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    startfolder = jTextField1.getText().trim().replace("\\", "/");
    try {
      way2();
    } catch (Exception e) {
      System.out.println("e" + " = " + e);
    }
  }//GEN-LAST:event_jTextField1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//    try {
//      loopit();
//
//    } catch (IOException ex) {
//      Logger.getLogger(Bits2Page.class
//        .getName()).log(Level.SEVERE, null, ex);
//    }
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//    automate();
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField4ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//    try {
//      readSystem();
//    } catch (IOException ex) {
//      Logger.getLogger(Bits2Page.class.getName()).log(Level.SEVERE, null, ex);
//    }
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField3ActionPerformed

  private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField2ActionPerformed

  private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
    jTextField5.setText(findSub(jTextField3.getText()));
    jTextField1.setText("C:/T5/" + jTextField2.getText() + "/" + jTextField5.getText());
  }//GEN-LAST:event_jTextField5ActionPerformed

  private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
    jTextField5.setText(findSub(jTextField3.getText()));
    jTextField1.setText("C:/T5/" + jTextField2.getText() + "/" + jTextField5.getText());
  }//GEN-LAST:event_jTextField5MouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JButton jButton1;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextField jTextField1;
  private static javax.swing.JTextField jTextField2;
  private static javax.swing.JTextField jTextField3;
  private static javax.swing.JTextField jTextField4;
  private javax.swing.JTextField jTextField5;
  private javax.swing.JTextArea jta1;
  private static javax.swing.JTextArea jtask;
  // End of variables declaration//GEN-END:variables

  private void check(String txt) {
//    System.out.println("folder" + " = " + txt);
//    jta1.append(start + txt + end + CRLF);
//    File fil = new File(txt);
//    String[] lin = fil.list();
//    try {
//      for (int i = 0; i < lin.length; i++) {
//        lin[i] = lin[i].replace("\\", "/");
//        if (lin[i].toLowerCase().contains(".gif")) {
//          //System.out.println("lin[" + i + "] = " + lin[i]);
//          jtask.append("  " + lin[i] + CRLF);
//          String s = lin[i].replace("\\", "/").trim();
//          add2Div(txt + FS + s);
//        } else {
//
//        }
//      }
//    } catch (Exception e) {
//      System.out.println("e" + " = " + e);
//    }
//    jta1.append("" + CRLF);
  }

  private void add2Div(String string) throws FileNotFoundException, IOException {
    string = string.replace("\\", "/").replace("//", "/").trim();
    //System.out.println("add2Div" + " = " + string);
    jta1.append("file://" + string + "<br/>" + CRLF);
    String sub = string.substring(string.lastIndexOf(FS) + 1);
    jta1.append("    <img src=\"file:///" + string + "\" width=\"200\" height=\"100\" alt=\"" + sub + "\"/>"
      + CRLF);

    String stringer = string.replace("gif", "txt");
    //System.out.println("" + " = " + stringer);
    File newone = new File(stringer);
    if (newone.exists()) {
//      System.out.println(stringer);
      File ff = new File(stringer);
      if (ff.exists()) {
        jta1.append("\t" + start + stringer + end + CRLF);
        BufferedReader br = new BufferedReader(new FileReader(stringer));
        String contents;
        while ((contents = br.readLine()) != null) {
          jta1.append(contents + "<br/>" + CRLF);
        }
        br.close();
      }
    }
  }

  private void loop(int i) throws IOException {
    if (i < folders.length) {
      jTextField1.setText(folders[i]);
      way2();
    }
  }

  private boolean isHexDir(String ffname) {
    boolean ok;
    if (" ".equals(ffname.substring(4, 5))) {
      ok = true;
    } else {
      ok = false;
    }
    return ok;
  }

  private static String gifs2Body(String finame) {
    String mid = "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
      + "    <link rel=\"stylesheet\" href=\"/w3.css\">\n"
      + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
      + "    <script src=\"jquery-3.2.1.min.js\"></script>\n"
      + "    <script src=\"https://www.w3schools.com/lib/w3.js\"></script>\n"
      + "";
    String start = "<!DOCTYPE html>\n"
      + "<!--\n"
      + "To change this license header, choose License Headers in Project Properties.\n"
      + "To change this template file, choose Tools | Templates\n"
      + "and open the template in the editor.\n"
      + "-->\n"
      + "<html>\n"
      + "  <head>\n"
      + "    <title>" + "Counters.html</title>\n"
      + "    <meta charset=\"UTF-8\">\n"
      + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
      + mid
      + "  </head>\n"
      + "  <body>\n"
      + "    <div>\n"
      + "";
    String end = "</div>\n</body>\n</html>\n";
    FileWriter fw = null;
    f = new File(finame);
    files = f.list();
    jtask.setText(start);
    try {
      for (String file : files) {
        if (file.endsWith(".gif")) {
          jtask.append("<div>\n<a href=\"file:///" + all + FS + file + "\">" + file.substring(0, file.lastIndexOf('.')) + "</a><br>\n");
          jtask.append("<img src=\"file:///" + all + FS + FS + file + "\">" + "<br>\n</div>\n");
        }
      }
    } catch (Exception e) {
      System.out.println("e" + " = " + e);
    } finally {
      jtask.append(end);
      text = jtask.getText();
      filename = all + FS + system.substring(0, 4) + "-Counters.html";
      System.out.println("filename" + " = " + filename);
      saveFile(filename, text);
    }
    return text;
  }

  private static void saveFile(String filename, String text) {
    File filenam = new File(filename);
    if (filenam.exists()) {
      try {
        FileWriter fw = new FileWriter(filename);
        fw.write("<!--" + filename + "-->\n");
        fw.write(text);
        fw.close();

      } catch (IOException ex) {
        Logger.getLogger(Bits2Page.class
          .getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  private String findSub(String text) {
    System.out.println("text" + " = " + text);
    int x = Integer.parseInt(text.substring(0, 2));
    int y = Integer.parseInt(text.substring(2, 4));
    int xx = 0;
    int yy = 0;
    if (x > 0 & x < 9) {
      xx = 0;
    } else if (x > 8 & x < 17) {
      xx = 1;
    } else if (x > 16 & x < 25) {
      xx = 2;
    } else if (x > 24 & x < 33) {
      xx = 3;
    }
    if (y > 0 & y < 11) {
      yy = 0;
    } else if (y > 10 & y < 21) {
      yy = 1;
    } else if (y > 20 & y < 31) {
      yy = 2;
    } else if (y > 30 & y < 41) {
      yy = 3;
    }

    char let = 'A';
    let += ((4 * xx) + yy);

    String start = "# Subsector "
      + let + ": ";
    String reply = "";
    lines = secdata.split(CRLF);

    String sub = null;
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].startsWith(start)) {
        reply = lines[i];
        sub = reply.substring(start.length() - 3).replace(":", "");
        System.out.println("lines[" + i + "]" + " = " + sub);
        break;
      }
    }
    jTextField5.setText("" + sub);
    return sub;
  }
}
/*
 Urls4Div()
 automate()
 gifs2Body(String folder)
 list4Div(String folder, String end)
 listPages(String sec, String sub)
 listSubsector(String sec, String sub)

 add2Div(String string)
 automate()
 check(String txt)
 getDirInfo(String fname)
 gifs2Body(String fname)
 indexSubsector(String sec, String sub)
 isHexDir(String finame)

 */
