import java.util.Map;

public class PagesInitializer {
    public static void initPagesOfYesterday(Map<String, String> pagesOfYesterday) {
        pagesOfYesterday.clear();

        TextReader textReader = new TextReader();

        pagesOfYesterday.put("http://index1.html", textReader.readText("src/main/resources/index1Yesterday.html"));
        pagesOfYesterday.put("http://index3.html", textReader.readText("src/main/resources/index3Yesterday_unchanged.html"));
        pagesOfYesterday.put("http://index4.html", textReader.readText("src/main/resources/index4Yesterday_deleted.html"));
    }

    public static void initPagesOfToday(Map<String, String> pagesOfToday) {
        pagesOfToday.clear();

        TextReader textReader = new TextReader();

        pagesOfToday.put("http://index1.html", textReader.readText("src/main/resources/index1Today_changed.html"));
        pagesOfToday.put("http://index2.html", textReader.readText("src/main/resources/index2Today_created.html"));
        pagesOfToday.put("http://index3.html", textReader.readText("src/main/resources/index3Today_unchanged.html"));
    }


}
