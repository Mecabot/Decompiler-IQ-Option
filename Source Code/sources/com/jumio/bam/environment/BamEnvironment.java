package com.jumio.bam.environment;

import android.content.Context;
import android.graphics.Typeface;
import com.jumio.core.environment.Environment;
import java.io.File;

public class BamEnvironment extends Environment {
    public static final String BUILD_VERSION = "JMSDK 2.10.0 (0-63)";
    public static final String OCR_VERSION = "1.102.0";
    public static final String OTF_OCRASTD = "94d996897f0200d38fa47a6dce468b6ed74357cd4df7520d319e794d439101e5";
    private static Typeface a;

    public static String getOCREngineSettingsPath(Context context) {
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine-full-server", "85734cf23a856f6e0cd3fdef6df318f9689024b24f2c7dbb0805262845c669de", ".xml");
        Environment.extractFile(context, BamEnvironment.class, "ocr/dictionaries/six_digits", "4089d6a775648628dc2488aecab49f3d1fd0adcd4683e0e891bf47f64fc21e98", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/dictionaries/sc_an_rules", "6f366db36c024868078647a56f90300e1cfd5dc4b685f62ffb4fdfe2f7020d8f", ".txt");
        Environment.extractFile(context, BamEnvironment.class, "ocr/dictionaries/surname", "9e1747493f14722e44af43c014bac4cd92cfa5696bd4b826aba36091ea80a7da", ".dict");
        Environment.extractFile(context, BamEnvironment.class, "ocr/dictionaries/name", "5fdc4542884401d9314f469cf5b63395bb2b2418dc489f695008aaddad62a81f", ".dict");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/refinder_config", "0cfb195f1d456f6d8f9665678c5f2cd0d8aa126fcc4d1eba46be47f6101b732f", ".json");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/recognizers/emb_nonemb_sel", "f7366d51aa3fe32280bf8f6ce4999c976d066dcbf5ca8027e544270772b4cedb", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/recognizers/smalldig_highlight", "5d4c9f818c66158f77e906daf975a5f708ab5b6028c449d6783912f82280e5df", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/recognizers/type", "ffb3dcf51fdbdd4f9082675ed80d3f57316ac3de80568a26d5f3d60aea22db41", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/recognizers/indent_dig_intpacked", "b97c8cf6ea95e672eb19dbd013b67fda21d5e6358dcb85d0029b450d51fcd00e", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/recognizers/smallsym_highlight", "0b92222352d276198cd097f8d8d55dbc13106a71413cc392d630226faa2d83b0", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/recognizers/bigdig_highlight", "5dbda788a30cbe26a347fc54b7ad00b8eb5f1f257dc83f3c077c28c3e5945914", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/recognizers/indent_sym", "388db1993b5be516917aa8ad17d840cfe8813089c2929286ac53d67346464053", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/CMakeLists", "9815e123e7f41b6d4b2012581e584166b2eeacf703cf355e98f934e26fbb7a57", ".txt");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/print-type", "dbd89dfb2a66be2a6e7b190686826672304c0e74978d58eeafe19ad09d92a37f", ".json");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ic-cfg/indent_card_config", "97e83fa105e175600cdf456c9e03a0a7eaee1f2c70e12aa5d0db3acc79e9c65f", ".json");
        Environment.extractFile(context, BamEnvironment.class, "ocr/retr_alphabet", "06f97848a282ffe17911b201d38ef6ac0b6023685343cc90ea3ea554fda07cc3", ".yaml");
        Environment.extractFile(context, BamEnvironment.class, "ocr/retr_sampling", "dfa5f286c1c82accc8a8c078d24ff341a8b6aea13aeb4192fa1b8066b19a6cd6", ".yaml");
        Environment.extractFile(context, BamEnvironment.class, "ocr/retriever_settings", "43c544cc79e29515da94dc68452d7f4ba4c454d3a669be9f44f741dc6dd7559b", ".json");
        Environment.extractFile(context, BamEnvironment.class, "ocr/retriever_settings_sym", "28522a041eaad3d0280feef2161ae1cbfb9b19d7c5568c377e8563d25005133b", ".json");
        Environment.extractFile(context, BamEnvironment.class, "ocr/card_detector/card_detection_engine", "9ef87da4d5737222a284baa8fdbe72c2805334b85a779fb3a5f68cc18420bc3f", ".xml");
        Environment.extractFile(context, BamEnvironment.class, "ocr/card_detector/fast_findcard_config", "839c941a7446898b3f2e655850e65d60d8e70d72ac394c36b4b4bf9093042682", ".xml");
        Environment.extractFile(context, BamEnvironment.class, "ocr/detectors/mc_41x25", "0416d4eff2a06908e91a9d87c3afa677e0a91d23d1bb2df35a793c8791c139e0", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/detectors/discover1b_117x21", "9339de5197978a0532ac9bc6e0554744f8872820259b9d98eed31586e93463d6", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/detectors/visa2_41x21", "daad5d6edd7bb6843e03a429de9e15d1ff7a9a7ef0134f50e433ef3d23e0b3f1", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/detectors/discover1a_101x19", "4a65667ff4cb870298ec64720fade973f941d10abbc94f2bc53dce1a936ef723", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/detectors/discover2_37x23", "503d347c45dca9131392050ae92991f085fd513c02084a3fb3ab54d2257ba0a3", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/detectors/visa1_41x21", "7ba21dc70458132f8ddb44249b8aa6179e23715a03f665d5b0f2ccf4f12ea522", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/detectors/dc_75x21", "f462bb8ecd8ce929a8ee0c173ef90b792dfccc14fda407af0131a30035a842e3", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/triadonaries/name.trigrams", "42fcd09c8e7bf52f2e69fa848bda237163a91a8d12e93f4492b654313c9e6fa5", ".trimpb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/retriever_settings_sym_1", "2fd6bc528c178441a011aa124299a5687730ec528521a9b1fbc43d62887258a5", ".json");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine-full-fast", "3abdb4f8ca3dc87599b47effcde0e340bc958729e4a4a8a748e39bb0df1a6ad5", ".xml");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/ump_sgm_recognizer_intpacked", "96c4d832ee8b146c04f147fd4108ae772e6edb315d5e64bf6c9d14ee92019c4a", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/double_sym_recognizer_intpacked", "3ec67fda5ec4d3730dcd851f866c26ee5125a351b6266c10c71c8125a968e62e", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smalldig_recognizer_3_packed", "6ee2961e7de00ade3643367ba23710ae37baafd0ac8d9b380ae0c173aa5680be", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smalldig_recognizer_packed", "5a5fba0843be9194c984b744073d29214a9be83409189b0fe2ff8d35eb753fb3", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/ump_symbols_recognizer_intpacked", "e2d1c1586be0706c1089cb24b95b48826636021af04fb76006edc528d875ee4d", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/bigdig_recognizer_packed", "f7740e9c316a5be4fe016c003ea808b101bc0e41c2a6eb0391d6c2922131bb07", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/cvv_digits_intpacked", "97bb3266b329f4798eabc36e5fb172baed57422a0d29ac52ab78413119992619", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smalldig_highlight", "5d4c9f818c66158f77e906daf975a5f708ab5b6028c449d6783912f82280e5df", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/bigdig_rescaler", "680bcfd891ccae2a6b73c8983acde7927a751b54d3a8673cb683d6f2459c368f", ".txt");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smallsymdig_recognizer_packed", "06e2218202253618eedf3ae1259a1878662162bfd1678e90d6453e00838fbc34", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smallsym_highlight", "0b92222352d276198cd097f8d8d55dbc13106a71413cc392d630226faa2d83b0", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smallsym_rescaler", "bc40364c970c1a6c9c579aa831bad258a8fb462209fbb0e79eb48986a4ef525f", ".txt");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/bigdig_highlight", "5dbda788a30cbe26a347fc54b7ad00b8eb5f1f257dc83f3c077c28c3e5945914", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smallsym_recognizer_intpacked", "2718664ee28bee92f41fd00977240eb0521b1057b2cd3e2cba15cb6c1cc5e547", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/ump_digits_recognizer_intpacked", "c99ab2d913d0f2cf49ced1da262345fde497477a90022c9536e96af32b7cb9d9", ".pb");
        Environment.extractFile(context, BamEnvironment.class, "ocr/ocrengine/smallsym_recognizer_fp_intpacked", "b7ee6e6d538325be9a81be7963497524a6d1325f6955ff5c84f91524656f1822", ".pb");
        return new File(Environment.getDataDirectory(context), "ocr/ocrengine-full-fast.xml").getAbsolutePath();
    }

    public static synchronized Typeface loadOcraFontTypeface(Context context) {
        Typeface typeface;
        synchronized (BamEnvironment.class) {
            if (a == null) {
                a = Typeface.createFromFile(Environment.extractFile(context, BamEnvironment.class, "ocrastd", OTF_OCRASTD, ".otf"));
            }
            typeface = a;
        }
        return typeface;
    }
}
