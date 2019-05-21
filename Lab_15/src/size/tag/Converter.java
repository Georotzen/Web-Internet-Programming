package size.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Converter extends SimpleTagSupport {
	private int size;
	
	public Converter() {
		
	}

    public void setSize(int size) {
        this.size = size;
    }
	
    @Override
    public void doTag() throws JspException, IOException {
    	if (size < Math.pow(2, 10)) {
    		getJspContext().getOut().print(size + " B");
		}
		if (Math.pow(2, 10) <= size && size < Math.pow(2, 20)) {
			getJspContext().getOut().print(Math.round(size *  0.0009765625) + " KB");
		}
		if (size >= Math.pow(2, 20)) {
			getJspContext().getOut().print(Math.round(size * 0.00000095367432) + " MB");
		}
    }

	
}
