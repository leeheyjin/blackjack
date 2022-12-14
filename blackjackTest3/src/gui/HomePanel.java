package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import client.ClientSet;

public class HomePanel extends JPanel implements ActionListener {
	public MainFrame mf;
	public ClientSet clientSet;

	private JPanel goBackPanel;
	private JButton goBack;

	private JPanel usersPanel;
	private JScrollPane onScroll;
	private JTextArea inList;

	private JPanel profilePanel;
	private JLabel id;
	private JLabel moneyView;
	private JButton refill;
	private String userId;
	private int money;

	private JPanel chatPanel;
	private JScrollPane chatScroll;
	private JTextArea showChat;
	private JTextField writeChat;
	private JButton sendChat;

	private JPanel ruleInfoPanel;
	private JButton ruleButton;
	private JDialog ruleDialog;
	private JLabel ruleLabel;
	private JButton okButton;

	private JPanel gameStartPanel;
	private JLabel playLabel;
	private JButton play;

	private boolean out;

	public HomePanel(MainFrame mf) {
		this.mf = mf;
		this.clientSet = ClientSet.getInstance();
		this.userId = clientSet.getUserID();
		this.money = clientSet.getMoney();
		initSetFrame();
	}

	private void initSetFrame() {
		setLayout(null);
		addBack();
		addChatting();
		addUser();
		inUpdate();
		addProfile();
		addRule();
		addStart();
		addListener();
		addChat(clientSet.getChat());
	}

	private void addBack() {
		goBackPanel = new JPanel();
		goBackPanel.setBounds(5, 0, 80, 40);

		goBack = new JButton("Return");
		goBack.setFont(new Font("times new roman", Font.BOLD, 15));
		goBack.setSize(80, 40);
		goBackPanel.add(goBack);

		add(goBackPanel);
	}

	private void addUser() {
		JLabel info = new JLabel("<Now Users>", JLabel.CENTER);
		info.setBorder(new LineBorder(Color.gray));
		info.setFont(new Font("times new roman", Font.BOLD, 20));
		info.setBounds(5, 40, 410, 50);

		usersPanel = new JPanel();
		usersPanel.setBounds(5, 90, 410, 255);
		usersPanel.setLayout(null);

		inList = new JTextArea();
		onScroll = new JScrollPane(inList);
		onScroll.setSize(410, 255);

		usersPanel.add(onScroll);

		add(info);
		add(usersPanel);
	}

	private void addProfile() {
		JLabel info = new JLabel("<Your Profile>", JLabel.CENTER);
		info.setBorder(new LineBorder(Color.gray));
		info.setFont(new Font("times new roman", Font.BOLD, 20));
		info.setBounds(5, 365, 410, 50);

		profilePanel = new JPanel();
		profilePanel.setBounds(5, 415, 410, 260);
		profilePanel.setLayout(null);
		profilePanel.setBorder(new LineBorder(Color.gray));

		id = new JLabel("ID        " + userId);
		id.setBounds(5, 0, 410, 30);
		id.setFont(new Font("times new roman", Font.BOLD, 20));
		profilePanel.add(id);

		moneyView = new JLabel("Money " + money);
		moneyView.setFont(new Font("times new roman", Font.BOLD, 20));
		moneyView.setBounds(5, 30, 410, 30);
		profilePanel.add(moneyView);

		JLabel guide = new JLabel("<html>Do you want to refill your money?<br> click Refill button.</html>");
		guide.setBounds(5, 100, 410, 60);
		guide.setFont(new Font("times new roman", Font.BOLD, 20));
		profilePanel.add(guide);

		refill = new JButton("Refill");
		refill.setBounds(0, 160, 410, 100);
		refill.setFont(new Font("times new roman", Font.BOLD, 20));
		profilePanel.add(refill);

		add(info);
		add(profilePanel);
	}

	private void addChatting() {
		JLabel info = new JLabel("<Chat>", JLabel.CENTER);
		info.setBorder(new LineBorder(Color.gray));
		info.setFont(new Font("times new roman", Font.BOLD, 20));
		info.setBounds(425, 40, 410, 50);

		chatPanel = new JPanel();
		chatPanel.setBounds(425, 90, 410, 585);
		chatPanel.setLayout(null);

		showChat = new JTextArea();
		chatScroll = new JScrollPane(showChat);
		chatScroll.setSize(410, 545);

		writeChat = new JTextField();
		writeChat.setColumns(10);
		writeChat.setBounds(0, 545, 330, 40);

		sendChat = new JButton("???");
		sendChat.setBounds(330, 545, 80, 40);

		chatPanel.add(chatScroll);
		chatPanel.add(writeChat);
		chatPanel.add(sendChat);

		add(info);
		add(chatPanel);
	}

	private void addRule() {
		JLabel info = new JLabel("<Rule>", JLabel.CENTER);
		info.setBorder(new LineBorder(Color.gray));
		info.setFont(new Font("times new roman", Font.BOLD, 20));
		info.setBounds(845, 40, 410, 50);

		ruleInfoPanel = new JPanel();
		ruleInfoPanel.setBounds(845, 90, 410, 145);
		ruleInfoPanel.setBorder(new LineBorder(Color.gray));
		ruleInfoPanel.setLayout(null);

		ruleLabel = new JLabel("Check the Blackjack rule ???", JLabel.CENTER);
		ruleLabel.setBounds(0, 0, 410, 30);
		ruleLabel.setFont(new Font("times new roman", Font.BOLD, 20));

		ruleButton = new JButton("Rule");
		ruleButton.setFont(new Font("times new roman", Font.BOLD, 20));
		ruleButton.setBounds(0, 45, 410, 100);

		ruleInfoPanel.add(ruleLabel);
		ruleInfoPanel.add(ruleButton);

		add(info);
		add(ruleInfoPanel);
	}

	private void addStart() {
		JLabel info = new JLabel("<Game>", JLabel.CENTER);
		info.setBorder(new LineBorder(Color.gray));
		info.setFont(new Font("times new roman", Font.BOLD, 20));
		info.setBounds(845, 255, 410, 50);

		gameStartPanel = new JPanel();
		gameStartPanel.setBounds(845, 305, 410, 370);
		gameStartPanel.setBorder(new LineBorder(Color.gray));
		gameStartPanel.setLayout(null);

		playLabel = new JLabel("Do you want to start? click 'Start' button!", JLabel.CENTER);
		playLabel.setFont(new Font("times new roman", Font.BOLD, 20));
		playLabel.setBounds(0, 0, 410, 40);

		play = new JButton("Start!");
		play.setFont(new Font("times new roman", Font.BOLD, 20));
		play.setBounds(0, 100, 410, 185);

		gameStartPanel.add(playLabel);
		gameStartPanel.add(play);

		add(info);
		add(gameStartPanel);
	}

	private void addListener() {
		goBack.addActionListener(this);
		refill.addActionListener(this);
		sendChat.addActionListener(this);
		writeChat.addActionListener(this);
		ruleButton.addActionListener(this);
		play.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(play)) {
			out = true;
			mf.goGame();
		} else if (e.getSource().equals(goBack)) {
			out = true;
			clientSet.setChat("");
			String msg = "logout/";
			clientSet.send(msg);
			clientSet.setUserID(null);
			System.out.println("????????????" + out);
			mf.goMain();
		} else if (e.getSource().equals(writeChat) || e.getSource().equals(sendChat)) {
			String msg = "chat/" + writeChat.getText();
			clientSet.send(msg);
			writeChat.setText("");
		} else if (e.getSource().equals(ruleButton)) {
			addDialog();
		} else if (e.getSource().equals(refill)) {
			if (money == 0) {
				JOptionPane.showMessageDialog(null, "OK??? ??????????????? 50000?????? ???????????????.", "??????", 1);
				money += 50000;
				clientSet.setMoney(money);
				moneyView.setText("Money " + money);
			} else {
				JOptionPane.showMessageDialog(null, "?????? ????????? 0?????? ?????? ????????? ???????????????.", "??????", 1);
			}

		}
	}

	private void addDialog() {
		ruleDialog = new JDialog(mf, "Blackjack rule", true);
		ruleDialog.setLayout(null);
		ruleDialog.setSize(720, 405);
		ruleDialog.setLocationRelativeTo(null);
		ruleDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ruleDialog.setResizable(false);

		JPanel rulePanel = new JPanel();
		rulePanel.setBounds(0, 0, 720, 405);

		JLabel ruleLabel = new JLabel("?????? ??????");
		ruleLabel.setFont(new Font("??????", Font.BOLD, 15));
		ruleLabel.setBounds(325, 10, 70, 20);
		ruleDialog.add(ruleLabel);

		JLabel rule = new JLabel("<html><span style=\"font-size:13\">"
				+ "1. ?????? ????????? ??????. ????????? ????????? ????????? ????????? ???????????? ?????? ??? ?????? ??????????????????, <br>&nbsp;&nbsp;&nbsp;&nbsp;????????? ?????? ??? ?????? ???????????? ????????? ?????????.<br><br>"
				+ "2. ????????? ?????? ???????????? ?????? 21??? ????????? ????????? ????????? 21??? ??? ????????? ?????? ?????????, <br>&nbsp;&nbsp;&nbsp;&nbsp;????????? ??? ???????????? 21??? ???????????? Bust??????.<br><br>"
				+ "3. ?????? ?????? ?????? ??? ?????? ?????? 21??? ??? ????????? Hit?????? ?????? ??? ??? ?????? ??? ?????? ??? ?????? <br>&nbsp;&nbsp;&nbsp;&nbsp;???????????? Stand?????? ?????????.<br><br>"
				+ "4. ????????? ????????? ?????? 16 ????????? ????????? ??? ?????? ??? ????????? ??????, 17 ????????? ???????????? ???????????? ??????. <br>&nbsp;&nbsp;&nbsp;&nbsp;????????? ????????? ?????? ????????? ?????? ?????? ??????.<br><br>"
				+ "5. ????????? ????????? 1?????? 11??? ????????? ??? ??????, 10, J, Q, K??? ?????? 10?????? ????????????.<br><br>"
				+ "6. ?????? ?????? ?????? ??? ?????? ???????????? 10, J, Q, K ??? ????????? ?????? 21??? ?????? Blackjack??? ??????, <br>&nbsp;&nbsp;&nbsp;&nbsp;????????? ????????? ??? ?????? ?????? ?????????.</span></html>");
		rule.setBounds(60, 0, 720, 380);
		ruleDialog.add(rule);

		okButton = new JButton("OK");
		okButton.setFont(new Font("times new roman", Font.BOLD, 12));
		okButton.setBounds(580, 330, 80, 20);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ruleDialog.setVisible(false);
			}
		});

		ruleDialog.add(okButton);
		ruleDialog.add(rulePanel);
		ruleDialog.setVisible(true);
	}

	public void addChat(String chatList) {
		showChat.setText(chatList);
		showChat.setCaretPosition(showChat.getDocument().getLength());
	}

	private void inUpdate() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					out = false;
					while (!out) {
						clientSet.send("????????? ??????");
						inList.setText(clientSet.getWhosIn());
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public JTextArea getShowChat() {
		return showChat;
	}

	public void setShowChat(JTextArea showChat) {
		this.showChat = showChat;
	}

	public JTextArea getInList() {
		return inList;
	}

	public void setInList(String inList) {
		this.inList.setText(inList);
	}
}
