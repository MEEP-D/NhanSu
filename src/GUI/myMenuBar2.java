package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.controlHoverMenuBar;
import run.App;

public class myMenuBar2 extends JPanel{
	private int selected;

	private ArrayList<myPanelAnimation> listMenuItem;
	private Color colorTop;
	private Color colorBottom;
	private JLabel labelName;
	private JLabel labelChucVu;
	private myImageAvatar ima;
	public static final String titleMenu[] = {"Trang chủ","Tuyển dụng","Nhân viên","Hợp đồng","Phòng ban","Chấm công","Lương thưởng","Đánh giá","Tài khoản"};
	public static final String iconMenu1[] = {"home.png","recruitment.png","employee.png","contract.png","department.png","timesheets.png","salary.png","danhgia.png","account.png"};
	public static final String iconMenu2[] = {"home2.png","recruitment2.png","employee2.png","contract2.png","department2.png","timesheets2.png","salary2.png","danhgia2.png","account2.png"};
	
	public String titleMenuUse[] = {};
	public String iconMenu1Use[] = {};
	public String iconMenu2Use[] = {};
	public myMenuBar2(Color color1, Color color2) {
		this.colorTop = color1;
		this.colorBottom = color2;
		init();
	}
	
	protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
       
        g2.setColor(Color.white);
        g2.setPaint(new GradientPaint(0, 0, new Color(173, 216, 230), getWidth(), getHeight(), new Color(135, 206, 250)));
        g2.fillRect(0 , 0, getWidth(), getHeight());
        
    }
	
	public void init() {
		this.setLayout(new BorderLayout());
		
		JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
	    headerPanel.setOpaque(false);
		
		ima = new myImageAvatar();
		ima.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/user11.jpg")).getImage().getScaledInstance(60,60,Image.SCALE_AREA_AVERAGING)));
		ima.setBounds(80,30,60,60);
		ima.setBorderSize(2);
//		this.add(ima);
		
		JPanel userInfoPanel = new JPanel();
	    userInfoPanel.setLayout(new BorderLayout());
	    userInfoPanel.setOpaque(false);
		
//		JPanel panelName = new JPanel();
//		panelName.setLayout(new BorderLayout());
//		panelName.setBackground(new Color(0,0,0,0));
//		panelName.setBounds(8,90,195,30);
//		this.add(panelName);
//		labelName = new JLabel("Lê Quan Phát",JLabel.CENTER);
//		labelName.setFont(new Font("sansserif",1,14));
//		labelName.setForeground(new Color(0,0,0,160));
//		panelName.add(labelName,BorderLayout.CENTER);
//		
//		JPanel panelChucVu = new JPanel();
//		panelChucVu.setLayout(new BorderLayout());
//		panelChucVu.setBackground(new Color(0,0,0,0));
//		panelChucVu.setBounds(8,113,195,30);
//		this.add(panelChucVu);
//		labelChucVu = new JLabel("Tổng giám đốc công ty",JLabel.CENTER);
//		labelChucVu.setFont(new Font("sansserif",0,13));
//		labelChucVu.setForeground(new Color(0,0,0,160));
//		panelChucVu.add(labelChucVu,BorderLayout.CENTER);
//		
//		JPanel line = new JPanel();
//		line.setBackground(new Color(0,0,0,100));
//		line.setBounds(20,145,178,1);
//		this.add(line);
//		Font font = new Font("Arial",1,13);
	    
	    labelName = new JLabel("Lê Quan Phát", JLabel.LEFT);
	    labelName.setFont(new Font("sansserif", Font.BOLD, 14));
	    labelName.setForeground(new Color(0, 0, 0, 160));

	    labelChucVu = new JLabel("Tổng giám đốc công ty", JLabel.LEFT);
	    labelChucVu.setFont(new Font("sansserif", Font.PLAIN, 13));
	    labelChucVu.setForeground(new Color(0, 0, 0, 160));

	    userInfoPanel.add(labelName, BorderLayout.NORTH);
	    userInfoPanel.add(labelChucVu, BorderLayout.SOUTH);

	    headerPanel.add(ima);
	    headerPanel.add(userInfoPanel);

//	    this.add(headerPanel, BorderLayout.WEST);
		
		RENDER_MENU();

	}
	public void RENDER_MENU() {
	    listMenuItem = new ArrayList<>();
	    
	    JPanel menuContainer = new JPanel();
	    menuContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5)); // Hiển thị ngang
	    menuContainer.setOpaque(false);
	    menuContainer.setBounds(10, 165, 1320, 80); // Tăng chiều cao để chứa icon + text
	    
	    for (int i = 0; i < titleMenuUse.length; i++) {
	        myPanelAnimation panelItem = new myPanelAnimation();
	        panelItem.setLayout(new BoxLayout(panelItem, BoxLayout.Y_AXIS)); // Sắp xếp dọc
	        panelItem.setOpaque(false);
	        panelItem.setPreferredSize(new Dimension(110, 60)); // Kích thước item menu
	        panelItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

	        // Đặt icon và text
	        panelItem.setTitle(titleMenuUse[i]);
	        panelItem.add(Box.createRigidArea(new Dimension(0, 10)));
	        panelItem.setIconNormal(iconMenu1Use[i]);  // Sử dụng icon từ danh sách
	        panelItem.setIconSpecial(iconMenu2Use[i]);

	        listMenuItem.add(panelItem);
	        menuContainer.add(panelItem);
	    }

	    this.add(menuContainer, BorderLayout.CENTER);
	}

	public ArrayList<myPanelAnimation> getListMenuItem() {
		return this.listMenuItem;
	}
	public void my_repaint() {
		repaint();
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}

	public void draw(int index) {
		for(myPanelAnimation i : listMenuItem) {
			i.setColor(new Color(0,0,0,0));
			i.setColorText(new Color(0,0,0,160));
			i.useIconNormal();
		}
		listMenuItem.get(index).setColor(new Color(52, 152, 219,200));
		listMenuItem.get(index).setColorText(Color.white);
		listMenuItem.get(index).useIconSpecial();
		repaint();
	}
	
	public void addActionHover(App app) {
		selected = 0;
		for(int index=0;index<listMenuItem.size();index++) {
			listMenuItem.get(index).addMouseListener(new controlHoverMenuBar(app, listMenuItem.get(index), index, selected));
		}
	}
	public void changeAvatar(String file) {
		ima.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/"+file)).getImage().getScaledInstance(60,60,Image.SCALE_AREA_AVERAGING)));

	}
	public JLabel getLbName() {
		return this.labelName;
	}
	public JLabel getLbChucVu() {
		return this.labelChucVu;
	}
}
