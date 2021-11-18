package word;

public interface TextTransform {
    void invokeOn(TextModifier text, int startIndex, int endIndex);
}
