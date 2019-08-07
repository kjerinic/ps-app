package konstante;

import java.io.Serializable;

public class StatusniKod implements Serializable {
    public static final int USPESNO = 1;
    public static final int NEUSPESNO = 2;
    public static final int OPET_LOGIN = 3;
    public static final int USPESNO_PRIJAVLJIVANJE = 4;
    public static final int NEUSPESNO_PRIJAVLJIVANJE = 5;
    public static final int SERVER_UGASEN = 6;
    public static final int SERVER_AKTIVAN = 7;
    public static final int SERVER_NEAKTIVAN = 8;
}
