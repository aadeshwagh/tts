package ttsModule;

import com.voicerss.tts.*;

import java.io.FileOutputStream;

public class ConvertTts {
    String text;
    String fileName;
    public ConvertTts(String text, String fileName){
        this.text=text;
        this.fileName=fileName;
    }

    public void convert(){
        VoiceProvider tts = new VoiceProvider(System.getenv("TTS_API_KEY"));
        VoiceParameters params = new VoiceParameters(text, Languages.English_UnitedStates);
        params.setCodec(AudioCodec.WAV);
        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(1);

        byte[] voice;
        try {
            voice = tts.speech(params);
            FileOutputStream fos = new FileOutputStream(fileName+".mp3");
            fos.write(voice, 0, voice.length);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
