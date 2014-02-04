Burp Suite JSBeautifier
=====================

Most of the websites compress their resources such as JS files in order to increase the loading speed. However, security testing and debugging a compressed resource is not an easy task. This is a Burp Suite open source extension which makes it possible to beautify most of the resources properly. Therefore, it will help the web application security researchers to view the compressed resources easier. It also helps them to have the decompressed versions of the resources (such as JS, CSS, HTML, XML, and so on) inside the browsers to debug them without any problem.

<b>Using the application:</b>

Step 0- (Downloading) Download ["jsbeautifier.jar"](jsbeautifier/jsbeautifier.jar) file and ["libs"](jsbeautifier/libs/) directory.

Step 1- (Adding Libraries) Now under "Extender" tab, click on the "Options" tab; in "Java Environment" section, click on "Select folder ..." button and select the "libs" folder that contains "js.jar" and "rsyntaxtextarea.jar".

Step 2- (Adding Extension) In Burp Suite, click on the "Extender" tab, then click on "Add" button and select "jsbeautifier.jar" file.

Step 3- (Testing Extension) Now you should be able to see "JSBeautifier Settings" tab in burp suite. You can also manually beautify requests/responses by using right click and selecting the "Beautify This!" option. If it cannot beautify anything, check your Burp Suite extension settings and make sure that you have added the requested libraries; Unload/Load the extension and try again.

<b>Features:</b>

- Works with the latest version of Burp Suite (tested on 1.5.21)
- Manual beautifying the requests/responses
- Automatic beautifying the responses in proxy
- Automatic beautifying the responses in all tabs
- Can support Burp suite scope
- Mimicking exact behaviour of JSBeautifier.org website by using Rhino library
- Supporting multiple file types (JS, CSS, HTML, and so on)
- Detecting packers and obfuscators (based on JSBeautifier.org)
- Syntax highlighter in the read-only editor by using Fifesoft RSyntaxTextArea library
- Open Source

<b>This extension is based on the following modules/libraries (included in repository):</b>

- JS files of http://jsbeautifier.org/ - Written by Einar Lielmanis, einar@jsbeautifier.org
- Rhino library - http://www.mozilla.org/rhino/
- Fifesoft RSyntaxTextArea library: http://fifesoft.com/rsyntaxtextarea/

<b>Limitations:</b>

- Limitations of jsbeautifier.org
- Only support UTF-8 for texts

<b>Reporting bugs:</b>

If you have found an issue, please use “Debug Mode” option and attach the extension's Output and Error files to your report. I may not be able to replicate the issue without having this information.

<b>Tested on:</b>

This extension has been tested on Burp Suite Pro v1.5.21 with Java v7ux.
If you are using an older version of Burp Suite, you may be able to use version 0.1a of this extension which is located at https://code.google.com/p/burp-suite-beautifier-extension/


<b>Some screenshots:</b>

![Settings Window](http://i.imgur.com/RZEdxXv.png)
![Right-Click Menu](http://i.imgur.com/vdyE6HJ.png)
![Syntax highlighter in read-only mode](http://i.imgur.com/1f87DjB.png)
