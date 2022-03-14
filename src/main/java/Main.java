import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> pagesOfYesterday = new HashMap<>();
        Map<String, String> pagesOfToday = new HashMap<>();

        PagesInitializer.initPagesOfYesterday(pagesOfYesterday);
        PagesInitializer.initPagesOfToday(pagesOfToday);

        SecretaryEntrustedPages secretaryEntrustedPages = new SecretaryEntrustedPages(
                "Наталья Викторовна",
                pagesOfYesterday,
                pagesOfToday
        );

        MessageWriter.writePagesStatuses(secretaryEntrustedPages);

    }
}
