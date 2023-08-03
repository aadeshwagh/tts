import ttsModule.ConvertTts;

public class Main {
    public static void main(String[] args) {
        ConvertTts cnv = new ConvertTts("Hello, world!","test");
        cnv.convert();

    }
}