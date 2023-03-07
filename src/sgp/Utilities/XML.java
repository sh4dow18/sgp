
package sgp.Utilities;

import java.io.IOException;

public class XML {
    private static XML instance;
    
    public XML() {
        instance = null;
    }
    public static XML get_instance() {
        if (instance == null) {
            instance = new XML();
        }
        return instance;
    }
    public boolean convert_pdf_to_xml(String file) {
        try {
	String[] pdf_to_xml_command = {"pdftohtml", "-c", "-xml", file + ".pdf", file};
	Runtime.getRuntime().exec(pdf_to_xml_command);
        } catch (IOException ioe) {
                return false;
        }
        return true;
    }
}
