package com.jumio.commons.validation;

import android.support.v4.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;
import java.io.Serializable;
import java.net.IDN;
import java.util.Arrays;
import java.util.Locale;

public class DomainValidator implements Serializable {
    private static final String[] COUNTRY_CODE_TLDS = new String[]{"ac", "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "er", "es", "et", "eu", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "st", "su", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "uk", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "xn--3e0b707e", "xn--45brj9c", "xn--54b7fta0cc", "xn--80ao21a", "xn--90a3ac", "xn--90ais", "xn--clchc0ea0b2g2a9gcd", "xn--d1alf", "xn--e1a4c", "xn--fiqs8s", "xn--fiqz9s", "xn--fpcrj9c3d", "xn--fzc2c9e2c", "xn--gecrj9c", "xn--h2brj9c", "xn--j1amh", "xn--j6w193g", "xn--kprw13d", "xn--kpry57d", "xn--l1acc", "xn--lgbbat1ad8j", "xn--mgb9awbf", "xn--mgba3a4f16a", "xn--mgbaam7a8h", "xn--mgbayh7gpa", "xn--mgbbh1a71e", "xn--mgbc0a9azcg", "xn--mgberp4a5d4ar", "xn--mgbpl2fh", "xn--mgbtx2b", "xn--mgbx4cd0ab", "xn--mix891f", "xn--node", "xn--o3cw4h", "xn--ogbpf8fl", "xn--p1ai", "xn--pgbs0dh", "xn--qxam", "xn--s9brj9c", "xn--wgbh1c", "xn--wgbl6a", "xn--xkc2al3hye2a", "xn--xkc2dl3a5ee0h", "xn--y9a3aq", "xn--yfro4i67o", "xn--ygbi2ammx", "ye", "yt", "za", "zm", "zw"};
    private static final String DOMAIN_LABEL_REGEX = "\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?";
    private static final String DOMAIN_NAME_REGEX = "^(?:\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?\\.)+(\\p{Alpha}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?)\\.?$";
    private static final DomainValidator DOMAIN_VALIDATOR = new DomainValidator(false);
    private static final DomainValidator DOMAIN_VALIDATOR_WITH_LOCAL = new DomainValidator(true);
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String[] GENERIC_TLDS = new String[]{"aaa", "aarp", "abarth", "abb", "abbott", "abbvie", "abc", "able", "abogado", "abudhabi", "academy", "accenture", "accountant", "accountants", "aco", "active", "actor", "adac", "ads", "adult", "aeg", "aero", "aetna", "afamilycompany", "afl", "agakhan", "agency", "aig", "aigo", "airbus", "airforce", "airtel", "akdn", "alfaromeo", "alibaba", "alipay", "allfinanz", "allstate", "ally", "alsace", "alstom", "americanexpress", "americanfamily", "amex", "amfam", "amica", "amsterdam", "analytics", "android", "anquan", "anz", "aol", "apartments", "app", "apple", "aquarelle", "aramco", "archi", "army", "art", "arte", "asda", "asia", "associates", "athleta", "attorney", "auction", "audi", "audible", "audio", "auspost", "author", "auto", "autos", "avianca", "aws", "axa", "azure", "baby", "baidu", "banamex", "bananarepublic", "band", "bank", "bar", "barcelona", "barclaycard", "barclays", "barefoot", "bargains", "baseball", "basketball", "bauhaus", "bayern", "bbc", "bbt", "bbva", "bcg", "bcn", "beats", "beauty", "beer", "bentley", "berlin", "best", "bestbuy", "bet", "bharti", "bible", "bid", "bike", "bing", "bingo", "bio", "biz", "black", "blackfriday", "blanco", "blockbuster", "blog", "bloomberg", "blue", "bms", "bmw", "bnl", "bnpparibas", "boats", "boehringer", "bofa", "bom", "bond", "boo", "book", "booking", "boots", "bosch", "bostik", "boston", "bot", "boutique", "box", "bradesco", "bridgestone", "broadway", "broker", "brother", "brussels", "budapest", "bugatti", "build", "builders", "business", Order.BUY, "buzz", "bzh", "cab", "cafe", "cal", NotificationCompat.CATEGORY_CALL, "calvinklein", "cam", "camera", "camp", "cancerresearch", "canon", "capetown", "capital", "capitalone", "car", "caravan", "cards", "care", "career", "careers", "cars", "cartier", "casa", "case", "caseih", "cash", "casino", "cat", "catering", "catholic", "cba", "cbn", "cbre", "cbs", "ceb", "center", "ceo", "cern", "cfa", "cfd", "chanel", "channel", "chase", "chat", "cheap", "chintai", "chloe", "christmas", "chrome", "chrysler", "church", "cipriani", "circle", "cisco", "citadel", "citi", "citic", "city", "cityeats", "claims", "cleaning", "click", "clinic", "clinique", "clothing", "cloud", "club", "clubmed", "coach", "codes", "coffee", "college", "cologne", "com", "comcast", "commbank", "community", "company", "compare", "computer", "comsec", "condos", "construction", "consulting", "contact", "contractors", "cooking", "cookingchannel", "cool", "coop", "corsica", "country", b.COUPON, "coupons", "courses", "credit", "creditcard", "creditunion", "cricket", "crown", "crs", "cruise", "cruises", "csc", "cuisinella", "cymru", "cyou", "dabur", "dad", "dance", "data", "date", "dating", "datsun", "day", "dclk", "dds", "deal", "dealer", "deals", "degree", "delivery", "dell", "deloitte", "delta", "democrat", "dental", "dentist", "desi", "design", "dev", "dhl", "diamonds", "diet", "digital", "direct", "directory", "discount", "discover", "dish", "diy", "dnp", "docs", "doctor", "dodge", "dog", "doha", "domains", "dot", "download", "drive", "dtv", "dubai", "duck", "dunlop", "duns", "dupont", "durban", "dvag", "dvr", "earth", "eat", "eco", "edeka", "edu", "education", "email", "emerck", "energy", "engineer", "engineering", "enterprises", "epost", "epson", "equipment", "ericsson", "erni", "esq", "estate", "esurance", "eurovision", "eus", "events", "everbank", "exchange", "expert", "exposed", "express", "extraspace", "fage", "fail", "fairwinds", "faith", "family", "fan", "fans", "farm", "farmers", "fashion", "fast", "fedex", "feedback", "ferrari", "ferrero", "fiat", "fidelity", "fido", "film", "final", "finance", "financial", "fire", "firestone", "firmdale", "fish", "fishing", "fit", "fitness", "flickr", "flights", "flir", "florist", "flowers", "fly", "foo", "food", "foodnetwork", "football", "ford", "forex", "forsale", "forum", "foundation", "fox", "free", "fresenius", "frl", "frogans", "frontdoor", "frontier", "ftr", "fujitsu", "fujixerox", "fun", "fund", "furniture", "futbol", "fyi", "gal", "gallery", "gallo", "gallup", "game", "games", "gap", "garden", "gbiz", "gdn", "gea", "gent", "genting", "george", "ggee", "gift", "gifts", "gives", "giving", "glade", "glass", "gle", "global", "globo", "gmail", "gmbh", "gmo", "gmx", "godaddy", "gold", "goldpoint", "golf", "goo", "goodhands", "goodyear", "goog", "google", "gop", "got", "gov", "grainger", "graphics", "gratis", "green", "gripe", "group", "guardian", "gucci", "guge", "guide", "guitars", "guru", "hair", "hamburg", "hangout", "haus", "hbo", "hdfc", "hdfcbank", "health", "healthcare", "help", "helsinki", "here", "hermes", "hgtv", "hiphop", "hisamitsu", "hitachi", "hiv", "hkt", "hockey", "holdings", "holiday", "homedepot", "homegoods", "homes", "homesense", "honda", "honeywell", "horse", "hospital", "host", "hosting", "hot", "hoteles", "hotmail", "house", "how", "hsbc", "htc", "hughes", "hyatt", "hyundai", "ibm", "icbc", "ice", "icu", "ieee", "ifm", "ikano", "imamat", "imdb", "immo", "immobilien", "industries", "infiniti", "info", "ing", "ink", "institute", "insurance", "insure", "int", "intel", "international", "intuit", "investments", "ipiranga", "irish", "iselect", "ismaili", "ist", "istanbul", "itau", "itv", "iveco", "iwc", "jaguar", "java", "jcb", "jcp", "jeep", "jetzt", "jewelry", "jio", "jlc", "jll", "jmp", "jnj", "jobs", "joburg", "jot", "joy", "jpmorgan", "jprs", "juegos", "juniper", "kaufen", "kddi", "kerryhotels", "kerrylogistics", "kerryproperties", "kfh", "kia", "kim", "kinder", "kindle", "kitchen", "kiwi", "koeln", "komatsu", "kosher", "kpmg", "kpn", "krd", "kred", "kuokgroup", "kyoto", "lacaixa", "ladbrokes", "lamborghini", "lamer", "lancaster", "lancia", "lancome", "land", "landrover", "lanxess", "lasalle", "lat", "latino", "latrobe", "law", "lawyer", "lds", "lease", "leclerc", "lefrak", "legal", "lego", "lexus", "lgbt", "liaison", "lidl", "life", "lifeinsurance", "lifestyle", "lighting", "like", "lilly", "limited", "limo", "lincoln", "linde", "link", "lipsy", "live", "living", "lixil", "loan", "loans", "locker", "locus", "loft", "lol", "london", "lotte", "lotto", "love", "lpl", "lplfinancial", "ltd", "ltda", "lundbeck", "lupin", "luxe", "luxury", "macys", "madrid", "maif", "maison", "makeup", "man", "management", "mango", Order.MARKET, "marketing", "markets", "marriott", "marshalls", "maserati", "mattel", "mba", "mcd", "mcdonalds", "mckinsey", "med", "media", "meet", "melbourne", "meme", "memorial", "men", "menu", "meo", "metlife", "miami", "microsoft", "mil", "mini", "mint", "mit", "mitsubishi", "mlb", "mls", "mma", "mobi", "mobile", "mobily", "moda", "moe", "moi", "mom", "monash", "money", "monster", "montblanc", "mopar", "mormon", "mortgage", "moscow", "moto", "motorcycles", "mov", "movie", "movistar", "msd", "mtn", "mtpc", "mtr", "museum", "mutual", "nab", "nadex", "nagoya", "name", "nationwide", "natura", "navy", "nba", "nec", "net", "netbank", "netflix", "network", "neustar", "new", "newholland", "news", "next", "nextdirect", "nexus", "nfl", "ngo", "nhk", "nico", "nike", "nikon", "ninja", "nissan", "nissay", "nokia", "northwesternmutual", "norton", "now", "nowruz", "nowtv", "nra", "nrw", "ntt", "nyc", "obi", "observer", "off", "office", "okinawa", "olayan", "olayangroup", "oldnavy", "ollo", "omega", "one", "ong", "onl", "online", "onyourside", "ooo", Position.STATUS_OPEN, "oracle", "orange", "org", "organic", "orientexpress", "origins", "osaka", "otsuka", "ott", "ovh", "page", "pamperedchef", "panasonic", "panerai", "paris", "pars", "partners", "parts", "party", "passagens", "pay", "pccw", "pet", "pfizer", "pharmacy", "philips", "phone", "photo", "photography", "photos", "physio", "piaget", "pics", "pictet", "pictures", "pid", "pin", "ping", "pink", "pioneer", "pizza", "place", "play", "playstation", "plumbing", "plus", "pnc", "pohl", "poker", "politie", "porn", "post", "pramerica", "praxi", "press", "prime", "pro", "prod", "productions", "prof", "progressive", NotificationCompat.CATEGORY_PROMO, "properties", "property", "protection", "pru", "prudential", "pub", "pwc", "qpon", "quebec", "quest", "qvc", "racing", "radio", "raid", "read", "realestate", "realtor", "realty", "recipes", "red", "redstone", "redumbrella", "rehab", "reise", "reisen", "reit", "reliance", "ren", "rent", "rentals", "repair", "report", "republican", "rest", "restaurant", "review", "reviews", "rexroth", "rich", "richardli", "ricoh", "rightathome", "ril", "rio", "rip", "rmit", "rocher", "rocks", "rodeo", "rogers", "room", "rsvp", "ruhr", "run", "rwe", "ryukyu", "saarland", "safe", "safety", "sakura", "sale", "salon", "samsclub", "samsung", "sandvik", "sandvikcoromant", "sanofi", "sap", "sapo", "sarl", "sas", "save", "saxo", "sbi", "sbs", "sca", "scb", "schaeffler", "schmidt", "scholarships", "school", "schule", "schwarz", "science", "scjohnson", "scor", "scot", "seat", "secure", "security", "seek", "select", "sener", "services", "ses", "seven", "sew", "sex", "sexy", "sfr", "shangrila", "sharp", "shaw", "shell", "shia", "shiksha", "shoes", "shop", "shopping", "shouji", "show", "showtime", "shriram", "silk", "sina", "singles", "site", "ski", "skin", "sky", "skype", "sling", "smart", "smile", "sncf", "soccer", NotificationCompat.CATEGORY_SOCIAL, "softbank", "software", "sohu", "solar", "solutions", "song", "sony", "soy", "space", "spiegel", "spot", "spreadbetting", "srl", "srt", "stada", "staples", "star", "starhub", "statebank", "statefarm", "statoil", "stc", "stcgroup", "stockholm", "storage", "store", "stream", "studio", "study", "style", "sucks", "supplies", "supply", "support", "surf", "surgery", "suzuki", "swatch", "swiftcover", "swiss", "sydney", "symantec", "systems", "tab", "taipei", "talk", "taobao", "target", "tatamotors", "tatar", "tattoo", b.TAX, "taxi", "tci", "tdk", "team", "tech", "technology", "tel", "telecity", "telefonica", "temasek", "tennis", "teva", "thd", "theater", "theatre", "tiaa", "tickets", "tienda", "tiffany", "tips", "tires", "tirol", "tjmaxx", "tjx", "tkmaxx", "tmall", "today", "tokyo", "tools", "top", "toray", "toshiba", "total", "tours", "town", "toyota", "toys", Order.ORDER_EXECUTE_STATUS_PARTIALLY_FILLED, "trading", "training", "travel", "travelchannel", "travelers", "travelersinsurance", "trust", "trv", "tube", "tui", "tunes", "tushu", "tvs", "ubank", "ubs", "uconnect", "unicom", "university", "uno", "uol", "ups", "vacations", "vana", "vanguard", "vegas", "ventures", "verisign", "versicherung", "vet", "viajes", "video", "vig", "viking", "villas", "vin", "vip", "virgin", "visa", "vision", "vista", "vistaprint", "viva", "vivo", "vlaanderen", "vodka", "volkswagen", "volvo", "vote", "voting", "voto", "voyage", "vuelos", "wales", "walmart", "walter", "wang", "wanggou", "warman", "watch", "watches", "weather", "weatherchannel", "webcam", "weber", "website", "wed", "wedding", "weibo", "weir", "whoswho", "wien", "wiki", "williamhill", "win", "windows", "wine", "winners", "wme", "wolterskluwer", "woodside", "work", "works", "world", "wow", "wtc", "wtf", "xbox", "xerox", "xfinity", "xihuan", "xin", "xn--11b4c3d", "xn--1ck2e1b", "xn--1qqw23a", "xn--30rr7y", "xn--3bst00m", "xn--3ds443g", "xn--3oq18vl8pn36a", "xn--3pxu8k", "xn--42c2d9a", "xn--45q11c", "xn--4gbrim", "xn--55qw42g", "xn--55qx5d", "xn--5su34j936bgsg", "xn--5tzm5g", "xn--6frz82g", "xn--6qq986b3xl", "xn--80adxhks", "xn--80aqecdr1a", "xn--80asehdb", "xn--80aswg", "xn--8y0a063a", "xn--90ae", "xn--9dbq2a", "xn--9et52u", "xn--9krt00a", "xn--b4w605ferd", "xn--bck1b9a5dre4c", "xn--c1avg", "xn--c2br7g", "xn--cck2b3b", "xn--cg4bki", "xn--czr694b", "xn--czrs0t", "xn--czru2d", "xn--d1acj3b", "xn--eckvdtc9d", "xn--efvy88h", "xn--estv75g", "xn--fct429k", "xn--fhbei", "xn--fiq228c5hs", "xn--fiq64b", "xn--fjq720a", "xn--flw351e", "xn--fzys8d69uvgm", "xn--g2xx48c", "xn--gckr3f0f", "xn--gk3at1e", "xn--hxt814e", "xn--i1b6b1a6a2e", "xn--imr513n", "xn--io0a7i", "xn--j1aef", "xn--jlq61u9w7b", "xn--jvr189m", "xn--kcrx77d1x4a", "xn--kpu716f", "xn--kput3i", "xn--mgba3a3ejt", "xn--mgba7c0bbn0a", "xn--mgbab2bd", "xn--mgbb9fbpob", "xn--mgbca7dzdo", "xn--mgbi4ecexp", "xn--mgbt3dhd", "xn--mk1bu44c", "xn--mxtq1m", "xn--ngbc5azd", "xn--ngbe9e0a", "xn--nqv7f", "xn--nqv7fs00ema", "xn--nyqy26a", "xn--p1acf", "xn--pbt977c", "xn--pssy2u", "xn--q9jyb4c", "xn--qcka1pmc", "xn--rhqv96g", "xn--rovu88b", "xn--ses554g", "xn--t60b56a", "xn--tckwe", "xn--tiq49xqyj", "xn--unup4y", "xn--vermgensberater-ctb", "xn--vermgensberatung-pwb", "xn--vhquv", "xn--vuq861b", "xn--w4r85el8fhu5dnra", "xn--w4rs40l", "xn--xhq521b", "xn--zfr164b", "xperia", "xxx", "xyz", "yachts", "yahoo", "yamaxun", "yandex", "yodobashi", "yoga", "yokohama", "you", "youtube", "yun", "zappos", "zara", "zero", "zip", "zippo", "zone", "zuerich"};
    private static final String[] INFRASTRUCTURE_TLDS = new String[]{"arpa"};
    private static final String[] LOCAL_TLDS = new String[]{"localdomain", "localhost"};
    private static final int MAX_DOMAIN_LENGTH = 253;
    private static final String TOP_LABEL_REGEX = "\\p{Alpha}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?";
    private static volatile String[] countryCodeTLDsMinus = EMPTY_STRING_ARRAY;
    private static volatile String[] countryCodeTLDsPlus = EMPTY_STRING_ARRAY;
    private static volatile String[] genericTLDsMinus = EMPTY_STRING_ARRAY;
    private static volatile String[] genericTLDsPlus = EMPTY_STRING_ARRAY;
    private static boolean inUse = false;
    private static final long serialVersionUID = -4407125112880174009L;
    private final boolean allowLocal;
    private final RegexValidator domainRegex = new RegexValidator(DOMAIN_NAME_REGEX);
    private final RegexValidator hostnameRegex = new RegexValidator(DOMAIN_LABEL_REGEX);

    public enum ArrayType {
        GENERIC_PLUS,
        GENERIC_MINUS,
        COUNTRY_CODE_PLUS,
        COUNTRY_CODE_MINUS,
        GENERIC_RO,
        COUNTRY_CODE_RO,
        INFRASTRUCTURE_RO,
        LOCAL_RO
    }

    private static class IDNBUGHOLDER {
        private static final boolean IDN_TOASCII_PRESERVES_TRAILING_DOTS = keepsTrailingDot();

        private IDNBUGHOLDER() {
        }

        private static boolean keepsTrailingDot() {
            return "a.".equals(IDN.toASCII("a."));
        }
    }

    public static synchronized DomainValidator getInstance() {
        DomainValidator domainValidator;
        synchronized (DomainValidator.class) {
            inUse = true;
            domainValidator = DOMAIN_VALIDATOR;
        }
        return domainValidator;
    }

    public static synchronized DomainValidator getInstance(boolean z) {
        synchronized (DomainValidator.class) {
            inUse = true;
            DomainValidator domainValidator;
            if (z) {
                domainValidator = DOMAIN_VALIDATOR_WITH_LOCAL;
                return domainValidator;
            }
            domainValidator = DOMAIN_VALIDATOR;
            return domainValidator;
        }
    }

    private DomainValidator(boolean z) {
        this.allowLocal = z;
    }

    public boolean isValid(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        str = unicodeToASCII(str);
        if (str.length() > MAX_DOMAIN_LENGTH) {
            return false;
        }
        String[] match = this.domainRegex.match(str);
        if (match != null && match.length > 0) {
            return isValidTld(match[0]);
        }
        if (this.allowLocal && this.hostnameRegex.isValid(str)) {
            z = true;
        }
        return z;
    }

    final boolean isValidDomainSyntax(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        str = unicodeToASCII(str);
        if (str.length() > MAX_DOMAIN_LENGTH) {
            return false;
        }
        String[] match = this.domainRegex.match(str);
        if ((match != null && match.length > 0) || this.hostnameRegex.isValid(str)) {
            z = true;
        }
        return z;
    }

    public boolean isValidTld(String str) {
        str = unicodeToASCII(str);
        boolean z = true;
        if (this.allowLocal && isValidLocalTld(str)) {
            return true;
        }
        if (!(isValidInfrastructureTld(str) || isValidGenericTld(str) || isValidCountryCodeTld(str))) {
            z = false;
        }
        return z;
    }

    public boolean isValidInfrastructureTld(String str) {
        return arrayContains(INFRASTRUCTURE_TLDS, chompLeadingDot(unicodeToASCII(str).toLowerCase(Locale.ENGLISH)));
    }

    public boolean isValidGenericTld(String str) {
        str = chompLeadingDot(unicodeToASCII(str).toLowerCase(Locale.ENGLISH));
        return (arrayContains(GENERIC_TLDS, str) || arrayContains(genericTLDsPlus, str)) && !arrayContains(genericTLDsMinus, str);
    }

    public boolean isValidCountryCodeTld(String str) {
        str = chompLeadingDot(unicodeToASCII(str).toLowerCase(Locale.ENGLISH));
        return (arrayContains(COUNTRY_CODE_TLDS, str) || arrayContains(countryCodeTLDsPlus, str)) && !arrayContains(countryCodeTLDsMinus, str);
    }

    public boolean isValidLocalTld(String str) {
        return arrayContains(LOCAL_TLDS, chompLeadingDot(unicodeToASCII(str).toLowerCase(Locale.ENGLISH)));
    }

    private String chompLeadingDot(String str) {
        return str.startsWith(".") ? str.substring(1) : str;
    }

    static synchronized void clearTLDOverrides() {
        synchronized (DomainValidator.class) {
            inUse = false;
            countryCodeTLDsPlus = EMPTY_STRING_ARRAY;
            countryCodeTLDsMinus = EMPTY_STRING_ARRAY;
            genericTLDsPlus = EMPTY_STRING_ARRAY;
            genericTLDsMinus = EMPTY_STRING_ARRAY;
        }
    }

    public static synchronized void updateTLDOverride(ArrayType arrayType, String[] strArr) {
        synchronized (DomainValidator.class) {
            if (inUse) {
                throw new IllegalStateException("Can only invoke this method before calling getInstance");
            }
            String[] strArr2 = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                strArr2[i] = strArr[i].toLowerCase(Locale.ENGLISH);
            }
            Arrays.sort(strArr2);
            StringBuilder stringBuilder;
            switch (arrayType) {
                case COUNTRY_CODE_MINUS:
                    countryCodeTLDsMinus = strArr2;
                    break;
                case COUNTRY_CODE_PLUS:
                    countryCodeTLDsPlus = strArr2;
                    break;
                case GENERIC_MINUS:
                    genericTLDsMinus = strArr2;
                    break;
                case GENERIC_PLUS:
                    genericTLDsPlus = strArr2;
                    break;
                case COUNTRY_CODE_RO:
                case GENERIC_RO:
                case INFRASTRUCTURE_RO:
                case LOCAL_RO:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot update the table: ");
                    stringBuilder.append(arrayType);
                    throw new IllegalArgumentException(stringBuilder.toString());
                default:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected enum value: ");
                    stringBuilder.append(arrayType);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public static String[] getTLDEntries(ArrayType arrayType) {
        Object[] objArr;
        switch (arrayType) {
            case COUNTRY_CODE_MINUS:
                objArr = countryCodeTLDsMinus;
                break;
            case COUNTRY_CODE_PLUS:
                objArr = countryCodeTLDsPlus;
                break;
            case GENERIC_MINUS:
                objArr = genericTLDsMinus;
                break;
            case GENERIC_PLUS:
                objArr = genericTLDsPlus;
                break;
            case COUNTRY_CODE_RO:
                objArr = COUNTRY_CODE_TLDS;
                break;
            case GENERIC_RO:
                objArr = GENERIC_TLDS;
                break;
            case INFRASTRUCTURE_RO:
                objArr = INFRASTRUCTURE_TLDS;
                break;
            case LOCAL_RO:
                objArr = LOCAL_TLDS;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected enum value: ");
                stringBuilder.append(arrayType);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (String[]) Arrays.copyOf(objArr, objArr.length);
    }

    static String unicodeToASCII(String str) {
        if (isOnlyASCII(str)) {
            return str;
        }
        try {
            String toASCII = IDN.toASCII(str);
            if (IDNBUGHOLDER.IDN_TOASCII_PRESERVES_TRAILING_DOTS) {
                return toASCII;
            }
            int length = str.length();
            if (length == 0) {
                return str;
            }
            char charAt = str.charAt(length - 1);
            if (charAt != '.' && charAt != 12290 && charAt != 65294 && charAt != 65377) {
                return toASCII;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(toASCII);
            stringBuilder.append(".");
            return stringBuilder.toString();
        } catch (IllegalArgumentException unused) {
            return str;
        }
    }

    private static boolean isOnlyASCII(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    private static boolean arrayContains(String[] strArr, String str) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }
}
