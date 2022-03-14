import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageWriter {
    public static void writePagesStatuses(SecretaryEntrustedPages secretaryEntrustedPages) {
        List<String> deletedPages = new ArrayList<>();
        List<String> createdPages = new ArrayList<>();
        List<String> changedPages = new ArrayList<>();
        Map<String, PageStatus> pagesStatuses = secretaryEntrustedPages.getPagesStatuses();

        pagesStatuses.forEach((key, value) -> {
            if (value == PageStatus.DELETED) {
                deletedPages.add(key);
            } else if (value == PageStatus.CREATED) {
                createdPages.add(key);
            } else if (value == PageStatus.CHANGED) {
                changedPages.add(key);
            }
        });

        String message = "Здравствуйте, дорогая " + secretaryEntrustedPages.getSecretaryName() + "\n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения: " + "\n" +
                "Исчезли следующие страницы: " + deletedPages + "\n" +
                "Появились следующие новые страницы: " + createdPages + "\n" +
                "Изменились следующие страницы: " + changedPages + "\n";

        System.out.println(message);
    }
}
