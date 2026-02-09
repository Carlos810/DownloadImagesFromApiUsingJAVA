package Utils;

public class devEnvironment {
    private final String  USER = "dbimagenes";
    private final String  PASS = "dbimagenes";
    private final String  LOCAL_DIRECTORY = "imagenes-api-descargada";
    private final String  URL_API = "https://picsum.photos/300/200";

    public String GetUrlApi(){ return URL_API; }
    public String GetDirectoryDownload(){ return LOCAL_DIRECTORY; }
    public String GetUserTesting(){return USER;};
    public String GetPassForTesting(){return PASS;};
}
