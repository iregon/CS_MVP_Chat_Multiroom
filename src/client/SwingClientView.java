package client;

import java.awt.BorderLayout;
import java.awt.Container;
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

import general.MvpViewAbstract;
import general.Presenter;

public class SwingClientView extends MvpViewAbstract<ClientPresenter> implements ClientView {
	
	private static final String WINDOW_NAME="Client";
	
	private ClientPresenter presenter;
	
	// GUI
	private JFrame frame;
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	
	private JSplitPane mainSplitpane;
	
	private JPanel messagesPanel;
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
		
		mainSplitpane = new JSplitPane();
		
		messagesPanel = new JPanel();
		messagesScrollPane = new JScrollPane();
		messagesLabel = new JLabel("Messaggi");
		messagesTextPane = new JTextPane();
		
		optionsSplitPane = new JSplitPane();
		optionsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		inputOptionsPanel = new JPanel();
		
		roomTextField = new JTextField();
		
		changeRoomButton = new JButton("Cambia stanza");
		
		sendMessagePanel = new JPanel();
		messageTextField = new JTextField(30);
		sendMessageButton = new JButton("Invia");
	}
	
	@Override
	public void appendMessage(String Message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Container co = frame.getContentPane();
		co.add(generateMainJPanel());
		
		frame.setBounds(100, 100, 664, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private JPanel generateMainJPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		frame.setJMenuBar(menuBar);
		menuBar.add(mnFile);
		
		mainSplitpane.setResizeWeight(1.0);
		mainSplitpane.setLeftComponent(messagesPanel);
		mainSplitpane.setRightComponent(optionsSplitPane);
		jp.add(mainSplitpane, BorderLayout.CENTER);
		
		messagesPanel.setLayout(new BorderLayout(0, 0));
		messagesPanel.add(messagesScrollPane);
		
		messagesScrollPane.setViewportView(messagesTextPane);
		messagesScrollPane.setColumnHeaderView(messagesLabel);
		
		optionsSplitPane.setResizeWeight(0.6);
		optionsSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		optionsSplitPane.setLeftComponent(optionsTabbedPane);
		optionsSplitPane.setRightComponent(inputOptionsPanel);
		
		inputOptionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		inputOptionsPanel.add(roomTextField);
		inputOptionsPanel.add(changeRoomButton);
		
		roomTextField.setColumns(20);
	
		sendMessagePanel.add(messageTextField);
		sendMessagePanel.add(sendMessageButton);
		
		jp.add(sendMessagePanel, BorderLayout.SOUTH);
		
		return jp;
	}
	

}
