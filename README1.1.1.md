This is a desktop blackjack game written in Java and packaged as a standalone Windows application. It uses my 
custom Blackjack Engine library to handle rules, scoring, and game flow; and a Swing-based UI for a simple, 
casino‑style experience - see the uiScreenshots folder for illustration. 

This project uses JDK 26, jpackage, and WiX Toolset 5.0.2 to generate a Windows installer. All artifacts for 
this application were compiled with JDK 26.0.1 and can be found in the dist directory. This project also has 
its own embedded JRE, so no external JRE is required. 

To install this application onto a Windows operating system, download the latest installer from the Releases 
section on this project's GitHub repository, run the installer, choose an installation directory, and then 
launch Blackjack from the Start Menu. The application can be uninstalled through the installer application or 
through Windows Settings.

Many thanks for playing! Good luck!

- kqfall1
- 10/05/2026, 8:02PM

v1.1.1 Change Log: 
- Fixed bugs that involved BlackjackEngine logic running on the EDT.
- Made the GUI layout dynamic to accommodate various possible display sizes. 
- Tweaked spacing, font sizes, component sizes, etc. 
- Changed the "File" menu to be named "Game". 
- Improved the UI/UX. 

- kqfall1
- 10/17/2026, 10:28PM