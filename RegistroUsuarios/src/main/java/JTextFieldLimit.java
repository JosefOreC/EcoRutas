import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
    private final int limit;

    public JTextFieldLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        //7
        if (str == null)
            //8
            return;

        //9
        if ((getLength() + str.length()) <= limit) {
            //10
            super.insertString(offset, str, attr);
        }
    }
}


