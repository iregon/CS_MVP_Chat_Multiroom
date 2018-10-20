package server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import general.MvpViewAbstract;
import general.Presenter;
import utils.LogManager;

public class SwingServerView extends MvpViewAbstract<Presenter> implements ServerView {
	
	private static final String WINDOW_NAME = "Server";
	
	private JFrame frame;
	
	private JTabbedPane mainTabbedPane;
	
	private JPanel logsPanel;
	private JScrollPane logsScrollPane;
	private JTextPane logsTextPane;
	
	private JPanel optionsPanel;
	
	public SwingServerView() {
		frame = new JFrame(WINDOW_NAME);
	}

	@Override
	public void render() {
		Container co = frame.getContentPane();
		co.add(generateGUI());
		
		setFrameOptions();
	}
	
	public JPanel generateGUI() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		mainTabbedPane = createMainTabbedPane();	
		
		panel.add(mainTabbedPane);
		
		return panel;
	}
	
	private JPanel createLogsPanel() {
		JPanel panel = new JPanel();
		
		logsTextPane = new JTextPane();
		logsTextPane.setEditable(false);
		
		logsScrollPane = new JScrollPane(logsTextPane);
		
		panel.setLayout(new BorderLayout());
		panel.add(logsScrollPane, BorderLayout.CENTER);
		
		return panel;
	}
	
	private JTabbedPane createMainTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		logsPanel = createLogsPanel();
		
		optionsPanel = new JPanel();
		
		tabbedPane.addTab("Logs", logsPanel);
		tabbedPane.addTab("Options", optionsPanel);
		
		return tabbedPane;
	}
	
	public void setFrameOptions() {
		frame.setBounds(100, 100, 460, 500);
		frame.setSize(460, 500);
		frame.setMinimumSize(new Dimension(460, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void appendLog(String log) {
		appendToPane(log, Color.BLACK);
	}
	
	@Override
	public void appendLog(String log, Color color) {
		appendToPane(log, color);
	}
	
	private void appendToPane(String msg, Color color) {
		StyledDocument doc = logsTextPane.getStyledDocument();
		try {
			StyleContext sc = StyleContext.getDefaultStyleContext();
			AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
			doc.insertString(doc.getLength(), msg, aset);
		} catch (BadLocationException ble) {
			LogManager.getLogManager().appendErrorLogWithNewLine("Couldn't insert initial text into text pane");
		}
	}

}
