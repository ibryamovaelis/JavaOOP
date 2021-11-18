package word.transformations;

import word.TextModifier;
import word.TextTransform;

public class ToUpper implements TextTransform {

    @Override
    public void invokeOn(TextModifier text, int startIndex, int endIndex){
        if (startIndex > (text.getText().toString().length() - 1)
                || startIndex == endIndex) {
            return;
        }
        for (int i = startIndex; i < endIndex; i++) {
            text.getText().setCharAt(i, Character.toUpperCase(text.getText().charAt(i)));
        }
    }
}
