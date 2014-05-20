package burp.JSBeautifier;
import java.util.prefs.Preferences;

public class BeautifierPreferences {
	private Preferences prefs=Preferences.userRoot().node("JSBeautifier");
	private final double version = 1.3;
	private final String appName = "Burp Suite JSBeautifier";
	private final String author = "Soroush Dalili (@irsdl)";
	private final String authorLink = "https://secproject.com/";
	private final String projectLink = "https://github.com/irsdl/BurpSuiteJSBeautifier";

	private boolean isDebugMode;
	private boolean isAutomaticInProxy;
	private boolean isRestrictedToScope;
	private int indent_size;
	private String indent_char;
	private int max_preserve_newlines;
	private boolean keep_array_indentation;
	private boolean break_chained_methods;
	private boolean space_after_anon_function;
	private String indent_scripts;
	private String brace_style;
	private boolean space_before_conditional;
	private boolean detect_packers;
	private boolean unescape_strings;
	private int wrap_line_length;
	private boolean isBeautifyHeadersInManualMode;
	private boolean isAutomaticInAll;


	public synchronized double getVersion() {
		return version;
	}

	public synchronized String getProjectLink() {
		return projectLink;
	}
	public synchronized String getAppInfo() {
		return "Name: "+appName + " -Version: " + String.valueOf(version) + " -Source: " + projectLink + " -Author: " + author;
	}

	public synchronized boolean isDebugMode() {

		return isDebugMode;
	}


	public synchronized void setDebugMode(boolean isDebugMode) {
		prefs.putBoolean("isDebugMode", isDebugMode);
		this.isDebugMode = isDebugMode;
	}


	public synchronized boolean isAutomaticInProxy() {

		return isAutomaticInProxy;
	}


	public synchronized void setAutomaticInProxy(boolean isAutomaticInProxy) {
		prefs.putBoolean("isAutomaticInProxy", isAutomaticInProxy);
		this.isAutomaticInProxy = isAutomaticInProxy;
	}

	public synchronized boolean isRestrictedToScope() {

		return isRestrictedToScope;
	}


	public synchronized  void setRestrictedToScope(boolean isRestrictedToScope) {
		prefs.putBoolean("isRestrictedToScope", isRestrictedToScope);
		this.isRestrictedToScope = isRestrictedToScope;
	}

	public synchronized  int getIndent_size() {
		return indent_size;
	}


	public synchronized  void setIndent_size(int indent_size) {
		prefs.putInt("indent_size", indent_size);
		this.indent_size = indent_size;
	}


	public synchronized  String getIndent_char() {
		return indent_char;
	}


	public synchronized void setIndent_char(String indent_char) {
		prefs.put("indent_char", indent_char);
		this.indent_char = indent_char;
	}


	public synchronized int getMax_preserve_newlines() {

		return max_preserve_newlines;
	}


	public synchronized void setMax_preserve_newlines(int max_preserve_newlines) {
		prefs.putInt("max_preserve_newlines", max_preserve_newlines);
		this.max_preserve_newlines = max_preserve_newlines;
	}


	public synchronized boolean isPreserve_newlines() {
		return getMax_preserve_newlines()!=-1;
	}


	//	public synchronized void setPreserve_newlines(boolean preserve_newlines) {
	//		prefs.putBoolean("preserve_newlines", preserve_newlines);
	//	}


	public synchronized boolean isKeep_array_indentation() {

		return keep_array_indentation;
	}


	public synchronized void setKeep_array_indentation(
			boolean keep_array_indentation) {
		prefs.putBoolean("keep_array_indentation", keep_array_indentation);
		this.keep_array_indentation = keep_array_indentation;
	}


	public synchronized boolean isBreak_chained_methods() {

		return break_chained_methods;
	}


	public synchronized void setBreak_chained_methods(boolean break_chained_methods) {
		prefs.putBoolean("break_chained_methods", break_chained_methods);
		this.break_chained_methods = break_chained_methods;
	}


	public synchronized boolean isSpace_after_anon_function() {

		return space_after_anon_function;
	}


	public synchronized void setSpace_after_anon_function(
			boolean space_after_anon_function) {
		prefs.putBoolean("space_after_anon_function", space_after_anon_function);
		this.space_after_anon_function = space_after_anon_function;
	}


	public synchronized String getIndent_scripts() {

		return indent_scripts;
	}


	public synchronized void setIndent_scripts(String indent_scripts) {
		prefs.put("indent_scripts", indent_scripts);
		this.indent_scripts = indent_scripts;
	}


	public synchronized String getBrace_style() {

		return brace_style;
	}


	public synchronized void setBrace_style(String brace_style) {
		prefs.put("brace_style", brace_style);
		this.brace_style = brace_style;
	}


	public synchronized boolean isSpace_before_conditional() {

		return space_before_conditional;
	}


	public synchronized void setSpace_before_conditional(
			boolean space_before_conditional) {
		prefs.putBoolean("space_before_conditional", space_before_conditional);
		this.space_before_conditional = space_before_conditional;
	}


	public synchronized boolean isDetect_packers() {

		return detect_packers;
	}


	public synchronized void setDetect_packers(boolean detect_packers) {
		prefs.putBoolean("detect_packers", detect_packers);
		this.detect_packers = detect_packers;
	}


	public synchronized boolean isUnescape_strings() {

		return unescape_strings;
	}


	public synchronized void setUnescape_strings(boolean unescape_strings) {
		prefs.putBoolean("unescape_strings", unescape_strings);
		this.unescape_strings = unescape_strings;
	}


	public synchronized int getWrap_line_length() {

		return wrap_line_length;
	}


	public synchronized void setWrap_line_length(int wrap_line_length) {
		prefs.putInt("wrap_line_length", wrap_line_length);
		this.wrap_line_length = wrap_line_length;
	}

	public synchronized boolean isBeautifyHeadersInManualMode() {

		return isBeautifyHeadersInManualMode;
	}

	public void setBeautifyHeadersInManualMode(boolean isBeautifyHeadersInManualMode) {
		prefs.putBoolean("isBeautifyHeadersInManualMode", isBeautifyHeadersInManualMode);
		this.isBeautifyHeadersInManualMode = isBeautifyHeadersInManualMode;
	}

	public boolean isAutomaticInAll() {

		return isAutomaticInAll;
	}

	public void setAutomaticInAll(boolean isAutomaticInAll) {
		prefs.putBoolean("isAutomaticInAll", isAutomaticInAll);
		this.isAutomaticInAll = isAutomaticInAll;
	}

	public BeautifierPreferences(){
		isDebugMode = prefs.getBoolean("isDebugMode", false);
		isAutomaticInProxy =  prefs.getBoolean("isAutomaticInProxy", false);
		isRestrictedToScope = prefs.getBoolean("isRestrictedToScope", false);

		indent_size = prefs.getInt("indent_size", 1);

		if(getIndent_size()==1){
			indent_char= prefs.get("indent_char", "\\t");
		}else{
			indent_char= prefs.get("indent_char", " ");
		}

		max_preserve_newlines= prefs.getInt("max_preserve_newlines", 5);
		keep_array_indentation= prefs.getBoolean("keep_array_indentation", false);
		break_chained_methods= prefs.getBoolean("break_chained_methods", false);
		space_after_anon_function= prefs.getBoolean("space_after_anon_function", true);
		indent_scripts= prefs.get("indent_scripts", "nomral");
		brace_style= prefs.get("brace_style", "expand");
		space_before_conditional= prefs.getBoolean("space_before_conditional", false);
		detect_packers= prefs.getBoolean("detect_packers", true);
		unescape_strings= prefs.getBoolean("unescape_strings", false);
		wrap_line_length= prefs.getInt("wrap_line_length", 0);
		isBeautifyHeadersInManualMode= prefs.getBoolean("isBeautifyHeadersInManualMode", false);
		isAutomaticInAll= prefs.getBoolean("isAutomaticInAll", false);			
	}
	
	public void resetBeautifierPreferences(){
		setAutomaticInProxy(false);
		setRestrictedToScope(false);
		setAutomaticInAll(false);
		setBeautifyHeadersInManualMode(false);
		setDebugMode(false);
		setIndent_size(1);
		setIndent_char("\\t");
		setMax_preserve_newlines(5);
		//setPreserve_newlines(true);
		setKeep_array_indentation(false);
		setBreak_chained_methods(false);
		setSpace_after_anon_function(true);
		setIndent_scripts("normal");
		setBrace_style("expand");
		setSpace_before_conditional(false);
		setDetect_packers(true);
		setUnescape_strings(false);
		setWrap_line_length(0);
	}


}
