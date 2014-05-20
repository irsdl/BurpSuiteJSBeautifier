package burp;

import java.net.URL;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import burp.JSBeautifier.BeautifierPreferences;


public class BurpExtender implements IBurpExtender, IHttpListener, 
IExtensionStateListener, IContextMenuFactory
{
	public burp.IBurpExtenderCallbacks mCallbacks; // I will use this to keep the callbacks
	private PrintWriter stdout;
	private IExtensionHelpers helpers;
	private BeautifierPreferences beautifierPreferences;
	
	@Override
	public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
	{
        // keep a reference to our callbacks object
        this.mCallbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        mCallbacks.setExtensionName("JSBeautifier");
        beautifierPreferences = new BeautifierPreferences();
        // obtain our output stream
        stdout = new PrintWriter(mCallbacks.getStdout(), true);
        stdout.println("Loading... ");
        // register ourselves as an HTTP listener
        mCallbacks.registerHttpListener(this);
        
        // register ourselves as an extension state listener
        mCallbacks.registerExtensionStateListener(this);
        
        // add Beautifier to right-click menu
        callbacks.registerContextMenuFactory(this);
        
        // add JSBeautifier settings tab
        mCallbacks.addSuiteTab(new burp.customGUI.PreferencesEditor(mCallbacks, beautifierPreferences));
        
        
        
        
        try { 
       	 	Class.forName( "org.mozilla.javascript.tools.shell.Main" );
	   	} catch( ClassNotFoundException e ) {
	   		stdout.println("Fatal Error: Error in loading Rhino (js.jar) library.\r\nThis extension cannot work without this library.\r\n"
	   				+ "Please reload this extension after adding this library to the Java Environment section.");
	   		mCallbacks.unloadExtension();
	   		return;
	   	}
        
        try { 
        	 Class.forName( "org.fife.ui.rtextarea.RTextArea" );
    	} catch( ClassNotFoundException e ) {
    		stdout.println("Warning: Error in loading rsyntaxtextarea.jar library.\r\nThis extension may not work properly without this library.\r\n"
    				+ "Please reload this extension after adding this library to the Java Environment section.");
    	}     
        
        stdout.println("Done!");
        
	}


	@Override
	public void processHttpMessage(int toolFlag, boolean messageIsRequest,
			IHttpRequestResponse messageInfo) {
		// Loading automatic beautifier
		String toolName = mCallbacks.getToolName(toolFlag);
		toolName = toolName.toLowerCase();
		if (!messageIsRequest && ((toolName.indexOf("proxy") > -1  && beautifierPreferences.isAutomaticInProxy()) || beautifierPreferences.isAutomaticInAll())){
			try
			{
				URL uUrl = helpers.analyzeRequest(messageInfo).getUrl();
				
				if(beautifierPreferences.isDebugMode())
					stdout.println("Incoming URL: "+uUrl.toString());
				
				// Check for the scope if it is restricted to scope
				if (!beautifierPreferences.isRestrictedToScope() || mCallbacks.isInScope(uUrl))
				{
					
					IHttpRequestResponse[] newMessageInfo = new IHttpRequestResponse[1];
					newMessageInfo[0] = messageInfo;
					// Loading the beautifier functions
					burp.JSBeautifier.JSBeautifierFunctions jsBeautifierFunctions = new burp.JSBeautifier.JSBeautifierFunctions(mCallbacks,beautifierPreferences);
					
					if(beautifierPreferences.isDebugMode())
						stdout.println("Begin beautifying [In Scope]: "+uUrl.toString());
					
					jsBeautifierFunctions.beautifyIt(newMessageInfo,true,2); // Automatic mode
					
					if(beautifierPreferences.isDebugMode())
						stdout.println("End beautifying [In Scope]: "+uUrl.toString());
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}


    @Override
    public void extensionUnloaded()
    {
    	stdout.println("Unloading... "+beautifierPreferences.getAppInfo());
    }


	@Override
	public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        JMenuItem item = new JMenuItem(new burp.JSBeautifier.JSBeautifierManualMenu(mCallbacks, invocation, stdout,beautifierPreferences));
        menuItems.add(item);
        return menuItems;
	}

	public static void main(String [] args){
		System.out.println("You have built me! Thank you! You can play with the jar file now!");
	}
}

