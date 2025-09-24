Set objShell = CreateObject("Wscript.Shell")

' Build the command (adjust the JAR name if needed)
cmd = "java -jar ""target\ChatBot-1.0-SNAPSHOT.jar"""

' Run hidden (0 = no console window, True = wait until finished)
objShell.Run cmd, 0, True
