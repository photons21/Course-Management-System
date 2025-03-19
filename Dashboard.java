package courseManagementSystem;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8990917446457470817L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable stdTable;
	private JTable instructorTable;
	private JTable courseTable;
	DbManager db;
	private JTable ctable;
	JLayeredPane layeredPane;
	JTextArea todoArea;
	JTextArea notifArea;
	private String userrole;
	JButton courseEditBtn;
	JButton moduleEditBtn;
	JButton editTeacherBtn;

	public Dashboard(DbManager db, String role, String name) {
		userrole = role;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/pics/titleIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 823);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(198, 139, 674, 608);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setLocation(-472, -49);
		dashboardPanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(dashboardPanel, "name_455849204305800");
		dashboardPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DASHBOARD");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 12, 136, 33);
		dashboardPanel.add(lblNewLabel_1);
		
		JPanel sp = new JPanel();
		sp.setBorder(UIManager.getBorder("DesktopIcon.border"));
		sp.setBounds(10, 62, 165, 130);
		dashboardPanel.add(sp);
		sp.setLayout(null);
		
		JLabel slbl = new JLabel("Student:");
		slbl.setForeground(new Color(0, 0, 0));
		slbl.setFont(new Font("Inter", Font.BOLD, 14));
		slbl.setBounds(52, 11, 74, 14);
		sp.add(slbl);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashStud.png")));
		lblNewLabel_7.setBounds(32, 29, 123, 94);
		sp.add(lblNewLabel_7);
		
		JPanel totIns = new JPanel();
		totIns.setForeground(new Color(0, 0, 0));
		totIns.setBorder(UIManager.getBorder("DesktopIcon.border"));
		totIns.setBounds(240, 62, 165, 130);
		dashboardPanel.add(totIns);
		totIns.setLayout(null);
		
		JLabel tlbl = new JLabel("Teacher:");
		tlbl.setForeground(new Color(0, 0, 0));
		tlbl.setFont(new Font("Inter", Font.BOLD, 14));
		tlbl.setBounds(52, 11, 77, 14);
		totIns.add(tlbl);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashTeach.png")));
		lblNewLabel_7_1.setBounds(32, 26, 123, 101);
		totIns.add(lblNewLabel_7_1);
		
		JPanel totCrs = new JPanel();
		totCrs.setBorder(UIManager.getBorder("DesktopIcon.border"));
		totCrs.setBounds(472, 62, 165, 130);
		dashboardPanel.add(totCrs);
		totCrs.setLayout(null);
		
		JLabel clbl = new JLabel("Course:");
		clbl.setFont(new Font("Inter", Font.BOLD, 14));
		clbl.setBounds(51, 11, 84, 14);
		totCrs.add(clbl);
		
		JLabel lblNewLabel_7_3 = new JLabel("");
		lblNewLabel_7_3.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashCourse.png")));
		lblNewLabel_7_3.setBounds(40, 33, 135, 94);
		totCrs.add(lblNewLabel_7_3);
		
		JLabel lblTodo = new JLabel("TO-DO");
		lblTodo.setBounds(98, 222, 69, 44);
		dashboardPanel.add(lblTodo);
		lblTodo.setForeground(new Color(0, 0, 0));
		lblTodo.setFont(new Font("Inter", Font.BOLD, 20));
		
		JLabel lblDashboard_1 = new JLabel("");
		lblDashboard_1.setBounds(167, 222, 24, 44);
		dashboardPanel.add(lblDashboard_1);
		lblDashboard_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/todoIcon.png")));
		
		JPanel todoPanel = new JPanel();
		todoPanel.setBounds(40, 260, 230, 311);
		dashboardPanel.add(todoPanel);
		todoPanel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		todoPanel.setBackground(new Color(255, 255, 255));
		todoPanel.setLayout(null);
		
		JLabel lblUsername2 = new JLabel("WELL DONE,");
		lblUsername2.setForeground(new Color(0, 0, 0));
		lblUsername2.setFont(new Font("Inter", Font.BOLD, 20));
		lblUsername2.setBounds(10, 21, 136, 34);
		todoPanel.add(lblUsername2);
		
		JLabel lblCompletedAllThe = new JLabel("all the tasks are completed");
		lblCompletedAllThe.setForeground(new Color(0, 0, 0));
		lblCompletedAllThe.setFont(new Font("Inter", Font.BOLD, 15));
		lblCompletedAllThe.setBounds(10, 57, 210, 19);
		todoPanel.add(lblCompletedAllThe);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/thumbsIcon.png")));
		lblNewLabel_2.setBounds(57, 149, 110, 117);
		todoPanel.add(lblNewLabel_2);
		
		JPanel todoPanel_1 = new JPanel();
		todoPanel_1.setLayout(null);
		todoPanel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		todoPanel_1.setBackground(Color.WHITE);
		todoPanel_1.setBounds(398, 262, 230, 311);
		dashboardPanel.add(todoPanel_1);
		
		JLabel lblNoNewNotfication = new JLabel("no new notfications");
		lblNoNewNotfication.setForeground(Color.BLACK);
		lblNoNewNotfication.setFont(new Font("Inter", Font.BOLD, 15));
		lblNoNewNotfication.setBounds(10, 57, 210, 19);
		todoPanel_1.add(lblNoNewNotfication);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/sleepingIcon.png")));
		lblNewLabel_2_1.setBounds(57, 149, 110, 117);
		todoPanel_1.add(lblNewLabel_2_1);
		
		JLabel lblRingring = new JLabel("Zzzzzzzz,");
		lblRingring.setForeground(Color.BLACK);
		lblRingring.setFont(new Font("Inter", Font.BOLD, 20));
		lblRingring.setBounds(10, 21, 119, 34);
		todoPanel_1.add(lblRingring);
		
		JLabel lblAlert = new JLabel("ALERT");
		lblAlert.setForeground(Color.BLACK);
		lblAlert.setFont(new Font("Inter", Font.BOLD, 20));
		lblAlert.setBounds(474, 222, 69, 44);
		dashboardPanel.add(lblAlert);
		
		JLabel lblDashboard_1_1 = new JLabel("");
		lblDashboard_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/sirenIcon.png")));
		lblDashboard_1_1.setBounds(541, 222, 24, 44);
		dashboardPanel.add(lblDashboard_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(10, 200, 654, 1);
		dashboardPanel.add(separator);
		
		JPanel coursesPanel = new JPanel();
		coursesPanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(coursesPanel, "name_455892295651400");
		coursesPanel.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("COURSES");
		lblNewLabel_1_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_3.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(10, 30, 102, 33);
		coursesPanel.add(lblNewLabel_1_3);
		
		java.sql.Statement stmt3;
		try {
            stmt3 = db.getConnection().createStatement();
            ResultSet rs = stmt3.executeQuery("SELECT course_ID,course_name FROM courses");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("CourseName");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("course_ID"),rs.getString("course_name")});
            }
            JScrollPane scrollPane_3 = new JScrollPane();
            scrollPane_3.setBounds(10, 111, 654, 125);
            scrollPane_3.setEnabled(false);
            coursesPanel.add(scrollPane_3);

            courseTable = new JTable(model);
            courseTable.setEnabled(false);
            scrollPane_3.setViewportView(courseTable);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		
		java.sql.Statement stmt4;
		try {
            stmt4 = db.getConnection().createStatement();
            ResultSet rs = stmt4.executeQuery("SELECT module_ID,module_name,module_type,course_ID FROM modules");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("module_ID");
            model.addColumn("module_name");
            model.addColumn("module_type");
            model.addColumn("course_ID");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("module_ID"),rs.getString("module_name"),rs.getString("module_type"),rs.getString("course_ID")});
            }
         
