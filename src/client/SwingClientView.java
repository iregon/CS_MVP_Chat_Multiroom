package client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import general.MvpViewAbstract;

public class SwingClientView extends MvpViewAbstract<ClientPresenter> implements ClientView {
	
	private static final String WINDOW_NAME="Client";
	
	// GUI
	private JFrame frame;
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	
	private JSplitPane mainSplitpane;
	
	private JPanel chatPanel;
	private JScrollPane messagesScrollPane;
	private JLabel messagesLabel;
	private JTextPane messagesTextPane;
	
	private JSplitPane optionsSplitPane;
	private JTabbedPane optionsTabbedPane;
	private JPanel inputOptionsPanel;
	
	private JTextField roomTextField;
	private JButton changeRoomButton;
	
	private JTextField messageTextField;
	
	private JPanel sendMessagePanel;
	private JButton sendMessageButton;
	
	public SwingClientView() {
		frame = new JFrame(WINDOW_NAME);
		
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		
		
	}
	
	@Override
	public void appendMessage(String Message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Container co = frame.getContentPane();
		co.add(generateMainJPanel());
		
		frame.setBounds(100, 100, 800, 450);
		frame.setMinimumSize(new Dimension(800, 450));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private JPanel generateMainJPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		frame.setJMenuBar(menuBar);
		menuBar.add(mnFile);
		
		chatPanel = createChatPanel();
		
		optionsSplitPane = createOptionSplitPane();
		
		mainSplitpane = createMainSplitPane();
		mainPanel.add(mainSplitpane, BorderLayout.CENTER);
		
		sendMessagePanel = createSendMessagePanel();
		chatPanel.add(sendMessagePanel, BorderLayout.SOUTH);
		
		return mainPanel;
	}
	
	private JSplitPane createMainSplitPane() {
		JSplitPane splitPane = new JSplitPane();
		
		splitPane.setResizeWeight(0.6);
		splitPane.setLeftComponent(chatPanel);
		splitPane.setRightComponent(optionsSplitPane);
		
		return splitPane;
	}
	
	private JPanel createChatPanel() {
		JPanel panel = new JPanel();
		
		messagesScrollPane = new JScrollPane();
		messagesLabel = new JLabel("Messaggi");
		messagesTextPane = new JTextPane();
		
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(messagesScrollPane);
		
		messagesLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		messagesTextPane.setEditable(false);
		
		messagesScrollPane.setViewportView(messagesTextPane);
		messagesScrollPane.setColumnHeaderView(messagesLabel);
		
		return panel;
	}
	
	private JSplitPane createOptionSplitPane() {
		JSplitPane splitPane = new JSplitPane();
		
		optionsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		inputOptionsPanel = new JPanel();
		roomTextField = new JTextField();
		changeRoomButton = new JButton("Cambia stanza");
		
		splitPane.setResizeWeight(0.6);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(optionsTabbedPane);
		splitPane.setRightComponent(inputOptionsPanel);
		
		inputOptionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		inputOptionsPanel.add(roomTextField);
		inputOptionsPanel.add(changeRoomButton);
		
		roomTextField.setColumns(20);
		
		return splitPane;
	}
	
	private JPanel createSendMessagePanel() {
		JPanel panel = new JPanel();
		
		messageTextField = new JTextField(30);
		sendMessageButton = new JButton("Invia");
		
		panel.add(messageTextField);
		panel.add(sendMessageButton);
		
		return panel;
	}
}
