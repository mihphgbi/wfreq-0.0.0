public class Cmd {
	public static String program = "wfreq";
	public static String author = "";

	public static void cmdUsage()
	{
		System.out.print(
"USAGE: " + program + " [options] [text]\n"
+"Print frequency of words in a text.\n\n"
+"options:\n"
+"-h\tprint usage and exit.\n"
+"-v\tprint version and exit.\n"
+"-f\toutput frequency (default option).\n\n"
+"text\tpathname of the input text.\n\n"
+"The program get the text from standard input if no text file is given.\n"
+"When only text pathname is given, print the frequency of words in the text.\n");
	}

	public static void cmdVersion()
	{
		System.out.print(program + " 0.0.0\n");
	}
}
