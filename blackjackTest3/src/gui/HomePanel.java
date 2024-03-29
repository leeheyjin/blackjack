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

		sendChat = new JButton("↑");
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

		ruleLabel = new JLabel("Check the Blackjack rule ↓", JLabel.CENTER);
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
			System.out.println("로그아웃" + out);
			mf.goMain();
		} else if (e.getSource().equals(writeChat) || e.getSource().equals(sendChat)) {
			String msg = "chat/" + writeChat.getText();
			clientSet.send(msg);
			writeChat.setText("");
		} else if (e.getSource().equals(ruleButton)) {
			addDialog();
		} else if (e.getSource().equals(refill)) {
			if (money == 0) {
				JOptionPane.showMessageDialog(null, "OK를 클릭하시면 50000원을 리필합니다.", "안내", 1);
				money += 50000;
				clientSet.setMoney(money);
				moneyView.setText("Money " + money);
			} else {
				JOptionPane.showMessageDialog(null, "보유 머니가 0원일 때만 리필이 가능합니다.", "경고", 1);
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

		JLabel ruleLabel = new JLabel("게임 규칙");
		ruleLabel.setFont(new Font("굴림", Font.BOLD, 15));
		ruleLabel.setBounds(325, 10, 70, 20);
		ruleDialog.add(ruleLabel);

		JLabel rule = new JLabel("<html><span style=\"font-size:13\">"
				+ "1. 먼저 베팅을 한다. 딜러가 자신을 포함한 참가자 전원에게 카드 두 장을 나누어주는데, <br>&nbsp;&nbsp;&nbsp;&nbsp;딜러의 카드 한 장은 상대에게 보이지 않는다.<br><br>"
				+ "2. 카드의 합이 딜러보다 먼저 21이 되거나 딜러의 합보다 21에 더 가깝게 되면 이기고, <br>&nbsp;&nbsp;&nbsp;&nbsp;카드를 더 받았는데 21을 초과하면 Bust된다.<br><br>"
				+ "3. 먼저 받은 카드 두 장의 합이 21에 못 미치면 Hit라고 말한 뒤 한 장씩 더 받을 수 있고 <br>&nbsp;&nbsp;&nbsp;&nbsp;멈추려면 Stand라고 말한다.<br><br>"
				+ "4. 딜러는 카드의 합이 16 이하면 무조건 한 장을 더 받아야 하고, 17 이상의 경우에는 멈추어야 한다. <br>&nbsp;&nbsp;&nbsp;&nbsp;딜러의 카드와 합이 같으면 비긴 것이 된다.<br><br>"
				+ "5. 에이스 카드는 1이나 11로 취급할 수 있고, 10, J, Q, K는 모두 10으로 계산한다.<br><br>"
				+ "6. 처음 받은 카드 두 장이 에이스와 10, J, Q, K 중 하나로 합이 21이 되면 Blackjack이 되고, <br>&nbsp;&nbsp;&nbsp;&nbsp;베팅한 금액의 두 배로 돈을 받는다.</span></html>");
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
						clientSet.send("접속자 목록");
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
