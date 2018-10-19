package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import general.MvpViewAbstract;

public class SwingClientView extends MvpViewAbstract<ClientPresenter> implements ClientView {
	
	private static final String WINDOW_NAME="Client";
	
	// GUI
	private JFrame frame;
	private JTextField messageTextField;
	private JTextField createRoomTextField;
	private JTextField changeRoomTextField;
	
	JPanel messagesPanel;
	JPanel optionsPanel;
	
	public SwingClientView() {
		frame = new JFrame(WINDOW_NAME);
	}
	
	@Override
	public void appendMessage(String Message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Container co = frame.getContentPane();
		co.add(generateGUI());
		
		setFrameOptions();
	}
	
	public void setFrameOptions() {
		frame.setBounds(100, 100, 800, 450);
		frame.setMinimumSize(new Dimension(800, 450));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private JPanel generateGUI() {
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		messagesPanel = createMessagesPanel();
		mainPanel.add(messagesPanel, BorderLayout.CENTER);
		
		optionsPanel = createOptionPanel();
		mainPanel.add(optionsPanel, BorderLayout.EAST);
		
		return mainPanel;
	}
	
	private JPanel createMessagesPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel chatPanel = new JPanel();
		panel.add(chatPanel);
		
		chatPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane messagesScrollPane = new JScrollPane();
		messagesScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		chatPanel.add(messagesScrollPane);
		
		JTextPane messagesTextPane = new JTextPane();
		messagesTextPane.setBorder(new LineBorder(Color.GRAY));
		messagesTextPane.setEditable(false);
		messagesScrollPane.setViewportView(messagesTextPane);
		
		JLabel messagesLabel = new JLabel("Messaggi");
		messagesLabel.setBorder(new EmptyBorder(0, 5, 5, 5));
		messagesScrollPane.setColumnHeaderView(messagesLabel);
		
		JPanel sendMessagePanel = new JPanel();
		panel.add(sendMessagePanel, BorderLayout.SOUTH);
		
		messageTextField = new JTextField();
		sendMessagePanel.add(messageTextField);
		messageTextField.setColumns(30);
		
		JButton sendMessageButton = new JButton("Invia");
		sendMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sendMessagePanel.add(sendMessageButton);
		
		return panel;
	}
	
	private JPanel createOptionPanel() {
		JPanel panel = new JPanel();
		
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel roomsPanel = new JPanel();
		roomsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(roomsPanel, BorderLayout.CENTER);
		roomsPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane roomsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		roomsPanel.add(roomsTabbedPane);
		
		JPanel usersListTabPanel = new JPanel();
		roomsTabbedPane.addTab("Utenti", null, usersListTabPanel, null);
		usersListTabPanel.setLayout(new BorderLayout(0, 0));
		
		JTextPane usersTextPane = new JTextPane();
		usersTextPane.setEditable(false);
		usersListTabPanel.add(usersTextPane, BorderLayout.CENTER);
		
		JPanel roomsListTabPanel = new JPanel();
		roomsTabbedPane.addTab("Stanze", null, roomsListTabPanel, null);
		roomsListTabPanel.setLayout(new BorderLayout(0, 0));
		
		JTextPane roomsTextPane = new JTextPane();
		roomsTextPane.setEditable(false);
		roomsListTabPanel.add(roomsTextPane, BorderLayout.CENTER);
		
		JPanel roomOptionsPanel = new JPanel();
		roomsListTabPanel.add(roomOptionsPanel, BorderLayout.SOUTH);
		roomOptionsPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel createRoomPanel = new JPanel();
		createRoomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		roomOptionsPanel.add(createRoomPanel, BorderLayout.NORTH);
		createRoomPanel.setLayout(new BorderLayout(0, 0));
		
		createRoomTextField = new JTextField(20);
		createRoomPanel.add(createRoomTextField, BorderLayout.CENTER);
		
		JButton createRoomButton = new JButton("Crea stanza");
		createRoomButton.setPreferredSize(new Dimension(103, 23));
		createRoomButton.setMinimumSize(new Dimension(103, 23));
		createRoomButton.setMaximumSize(new Dimension(103, 23));
		createRoomPanel.add(createRoomButton, BorderLayout.EAST);
		
		JPanel changeRoomPanel = new JPanel();
		changeRoomPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
		roomOptionsPanel.add(changeRoomPanel);
		changeRoomPanel.setLayout(new BorderLayout(0, 0));
		
		changeRoomTextField = new JTextField(20);
		changeRoomPanel.add(changeRoomTextField);
		
		JButton changeRoomButton = new JButton("Cambia stanza");
		changeRoomPanel.add(changeRoomButton, BorderLayout.EAST);
		
		return panel;
	}
}
