package burp.JSBeautifier;

import burp.IContextMenuInvocation;

import java.io.PrintWriter;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class JSBeautifierManualMenu  extends AbstractAction{
	private burp.IBurpExtenderCallbacks mCallbacks;
	private final BeautifierPreferences beautifierPreferences;
	private IContextMenuInvocation invocation;
	private PrintWriter stdout;
	
	public JSBeautifierManualMenu(burp.IBurpExtenderCallbacks callbacks,IContextMenuInvocation invocation,PrintWriter stdout,BeautifierPreferences beautifierPreferences){
		super("Beautify This!");
		this.mCallbacks = callbacks;
		this.stdout = stdout;
		this.beautifierPreferences = beautifierPreferences;
		this.invocation = invocation;
		if(beautifierPreferences.isDebugMode()){
			stdout.println("Beautifier manual menu item has been loaded!");
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Loading the beautifier functions
		if(beautifierPreferences.isDebugMode()){
			stdout.println("You have just clicked on JSBeautifier!");
		}
		
		// Request Or Response?
		byte invocationContext = invocation.getInvocationContext();
		int msgType;
		if(invocationContext==invocation.CONTEXT_MESSAGE_EDITOR_REQUEST || invocationContext == invocation.CONTEXT_MESSAGE_VIEWER_REQUEST 
				|| invocationContext == invocation.CONTEXT_INTRUDER_PAYLOAD_POSITIONS){
			msgType = 1;
		}else if(invocationContext==invocation.CONTEXT_MESSAGE_EDITOR_RESPONSE || invocationContext == invocation.CONTEXT_MESSAGE_VIEWER_RESPONSE){
			msgType = 2;
		}else{
			// Ask a question - do you need Request or Response now?
			msgType = -1;
		}
		
		if(beautifierPreferences.isDebugMode()){
			stdout.println("msgType: " + msgType);
		}
		JSBeautifierFunctions jsBeautifierFunctions = new JSBeautifierFunctions(mCallbacks,beautifierPreferences);
		
		jsBeautifierFunctions.beautifyIt(invocation.getSelectedMessages(),false,msgType); // Manual mode
		
	}
	
	
}
