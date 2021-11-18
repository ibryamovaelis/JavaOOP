package word.transformations;

import word.TextModifier;
import word.TextTransform;

public class Paste implements TextTransform {
    @Override
    public void invokeOn(TextModifier text, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            text.getText().insert(startIndex, text.getCut());
        } else if (startIndex <= text.getText().toString().length() - 1) {
            text.getText().replace(startIndex, endIndex, text.getCut());
        } else {
            text.setText(text.getText().append(text.getCut()));
        }
    }
}
