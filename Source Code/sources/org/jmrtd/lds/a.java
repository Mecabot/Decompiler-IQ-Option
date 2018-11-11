package org.jmrtd.lds;

import android.support.v4.view.InputDeviceCompat;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jmrtd.lds.icao.COMFile;
import org.jmrtd.lds.icao.DG11File;
import org.jmrtd.lds.icao.DG12File;
import org.jmrtd.lds.icao.DG14File;
import org.jmrtd.lds.icao.DG15File;
import org.jmrtd.lds.icao.DG1File;
import org.jmrtd.lds.icao.DG2File;
import org.jmrtd.lds.icao.DG3File;
import org.jmrtd.lds.icao.DG4File;
import org.jmrtd.lds.icao.DG5File;
import org.jmrtd.lds.icao.DG6File;
import org.jmrtd.lds.icao.DG7File;

/* compiled from: LDSFileUtil */
public class a {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");

    public static AbstractLDSFile a(short s, InputStream inputStream) {
        switch (s) {
            case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                return new DG1File(inputStream);
            case (short) 258:
                return new DG2File(inputStream);
            case (short) 259:
                return new DG3File(inputStream);
            case (short) 260:
                return new DG4File(inputStream);
            case (short) 261:
                return new DG5File(inputStream);
            case (short) 262:
                return new DG6File(inputStream);
            case (short) 263:
                return new DG7File(inputStream);
            case (short) 264:
                throw new IllegalArgumentException("DG8 files are not yet supported");
            case (short) 265:
                throw new IllegalArgumentException("DG9 files are not yet supported");
            case (short) 266:
                throw new IllegalArgumentException("DG10 files are not yet supported");
            case (short) 267:
                return new DG11File(inputStream);
            case (short) 268:
                return new DG12File(inputStream);
            case (short) 269:
                throw new IllegalArgumentException("DG13 files are not yet supported");
            case (short) 270:
                return new DG14File(inputStream);
            case (short) 271:
                return new DG15File(inputStream);
            case (short) 272:
                throw new IllegalArgumentException("DG16 files are not yet supported");
            default:
                switch (s) {
                    case (short) 284:
                        return new CVCAFile(inputStream);
                    case (short) 285:
                        return new SODFile(inputStream);
                    case (short) 286:
                        return new COMFile(inputStream);
                    default:
                        InputStream bufferedInputStream = new BufferedInputStream(inputStream, 37);
                        try {
                            bufferedInputStream.mark(37);
                            return new CVCAFile(s, bufferedInputStream);
                        } catch (Throwable e) {
                            Logger logger = LOGGER;
                            Level level = Level.WARNING;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown file ");
                            stringBuilder.append(Integer.toHexString(s));
                            logger.log(level, stringBuilder.toString(), e);
                            bufferedInputStream.reset();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Unknown file ");
                            stringBuilder2.append(Integer.toHexString(s));
                            throw new NumberFormatException(stringBuilder2.toString());
                        }
                }
        }
    }

    public static short ms(int i) {
        switch (i) {
            case 96:
                return (short) 286;
            case 97:
                return (short) 257;
            case 99:
                return (short) 259;
            case 101:
                return (short) 261;
            case 102:
                return (short) 262;
            case 103:
                return (short) 263;
            case 104:
                return (short) 264;
            case 105:
                return (short) 265;
            case 106:
                return (short) 266;
            case 107:
                return (short) 267;
            case 108:
                return (short) 268;
            case 109:
                return (short) 269;
            case 110:
                return (short) 270;
            case 111:
                return (short) 271;
            case 112:
                return (short) 272;
            case 117:
                return (short) 258;
            case 118:
                return (short) 260;
            case 119:
                return (short) 285;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown tag ");
                stringBuilder.append(Integer.toHexString(i));
                throw new NumberFormatException(stringBuilder.toString());
        }
    }

    public static int mt(int i) {
        if (i == 97) {
            return 1;
        }
        if (i == 99) {
            return 3;
        }
        switch (i) {
            case 101:
                return 5;
            case 102:
                return 6;
            case 103:
                return 7;
            case 104:
                return 8;
            case 105:
                return 9;
            case 106:
                return 10;
            case 107:
                return 11;
            case 108:
                return 12;
            case 109:
                return 13;
            case 110:
                return 14;
            case 111:
                return 15;
            case 112:
                return 16;
            default:
                switch (i) {
                    case 117:
                        return 2;
                    case 118:
                        return 4;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown tag ");
                        stringBuilder.append(Integer.toHexString(i));
                        throw new NumberFormatException(stringBuilder.toString());
                }
        }
    }

    public static int mu(int i) {
        switch (i) {
            case 1:
                return 97;
            case 2:
                return 117;
            case 3:
                return 99;
            case 4:
                return 118;
            case 5:
                return 101;
            case 6:
                return 102;
            case 7:
                return 103;
            case 8:
                return 104;
            case 9:
                return 105;
            case 10:
                return 106;
            case 11:
                return 107;
            case 12:
                return 108;
            case 13:
                return 109;
            case 14:
                return 110;
            case 15:
                return 111;
            case 16:
                return 112;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown number ");
                stringBuilder.append(i);
                throw new NumberFormatException(stringBuilder.toString());
        }
    }

    public static short mv(int i) {
        switch (i) {
            case 1:
                return (short) 257;
            case 2:
                return (short) 258;
            case 3:
                return (short) 259;
            case 4:
                return (short) 260;
            case 5:
                return (short) 261;
            case 6:
                return (short) 262;
            case 7:
                return (short) 263;
            case 8:
                return (short) 264;
            case 9:
                return (short) 265;
            case 10:
                return (short) 266;
            case 11:
                return (short) 267;
            case 12:
                return (short) 268;
            case 13:
                return (short) 269;
            case 14:
                return (short) 270;
            case 15:
                return (short) 271;
            case 16:
                return (short) 272;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown number ");
                stringBuilder.append(i);
                throw new NumberFormatException(stringBuilder.toString());
        }
    }
}
