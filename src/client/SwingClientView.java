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
	private JTextField newRoomTextField;
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
		
		JPanel chatPanel = createChatPanel();
		panel.add(chatPanel);
		
		JPanel sendMessagePanel = createSendMessagePanel();
		panel.add(sendMessagePanel, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private JPanel createChatPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane messagesScrollPane = new JScrollPane();
		messagesScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(messagesScrollPane);
		
		JTextPane messagesTextPane = new JTextPane();
		messagesTextPane.setBorder(new LineBorder(Color.GRAY));
		messagesTextPane.setEditable(false);
		messagesScrollPane.setViewportView(messagesTextPane);
		
		JLabel messagesLabel = new JLabel("Messaggi");
		messagesLabel.setBorder(new EmptyBorder(0, 5, 5, 5));
		messagesScrollPane.setColumnHeaderView(messagesLabel);
		
		return panel;
	}
	
	private JPanel createSendMessagePanel() {
		JPanel panel = new JPanel();
		
		messageTextField = new JTextField();
		panel.add(messageTextField);
		messageTextField.setColumns(30);
		
		JButton sendMessageButton = new JButton("Invia");
		sendMessageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				presenter.sendMessageRequest(messageTextField.getText());
			}
		});
		panel.add(sendMessageButton);
		
		return panel;
	}
	
	private JPanel createOptionPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel roomsPanel = createRoomsPanel();
		panel.add(roomsPanel, BorderLayout.CENTER);
		
		JTabbedPane roomsTabbedPane = createRoomsTabbedPane();
		roomsPanel.add(roomsTabbedPane);
		
		return panel;
	}
	
	private JTabbedPane createRoomsTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel usersListTabPanel = createUsersListTabPanel();
		tabbedPane.addTab("Utenti", null, usersListTabPanel, null);
		
		JPanel roomsListTabPanel = createRoomsListTabPanel();
		tabbedPane.addTab("Stanze", null, roomsListTabPanel, null);
		
		return tabbedPane;
	}
	
	private JPanel createRoomsPanel() {
		JPanel panel = new JPanel();
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		
		return panel;
	}	
	
	private JPanel createUsersListTabPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane usersTextPane = new JTextPane();
		usersTextPane.setEditable(false);
		panel.add(usersTextPane, BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel createRoomsListTabPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane roomsTextPane = new JTextPane();
		roomsTextPane.setEditable(false);
		panel.add(roomsTextPane, BorderLayout.CENTER);
		
		JPanel roomOptionsPanel = createRoomOptionsPanel();
		panel.add(roomOptionsPanel, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private JPanel createRoomOptionsPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel newRoomPanel = createNewRoomPanel();
		panel.add(newRoomPanel, BorderLayout.NORTH);
		
		JPanel changeRoomPanel = createChangeRoomPanel();
		panel.add(changeRoomPanel);
		
		return panel;
	}
	
	
	private JPanel createNewRoomPanel() {
		JPanel panel = new JPanel();
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		
		newRoomTextField = new JTextField(20);
		panel.add(newRoomTextField, BorderLayout.CENTER);
		
		JButton newRoomButton = createRoomPanelButton("Crea Stanza");
		newRoomButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(newRoomButton, BorderLayout.EAST);
		
		return panel;
	}
	
	private JPanel createChangeRoomPanel() {
		JPanel panel = new JPanel();
		
		panel.setBorder(new EmptyBorder(0, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		
		changeRoomTextField = new JTextField(20);
		panel.add(changeRoomTextField);
		
		JButton changeRoomButton = createRoomPanelButton("Cambia stanza");
		changeRoomButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(changeRoomButton, BorderLayout.EAST);
		
		return panel;
	}
	
	private JButton createRoomPanelButton(String name) {
		JButton button = new JButton(name);
		Dimension buttonSize = new Dimension(123, 23); 
		
		button.setPreferredSize(buttonSize);
		button.setMinimumSize(buttonSize);
		button.setMaximumSize(buttonSize);
		
		return button;
	}
	
//	class sendButtonActionListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
}
