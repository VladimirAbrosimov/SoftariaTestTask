import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class SecretaryEntrustedPages {
    @Getter
    @Setter
    private String secretaryName;
    @Getter
    @Setter
    private Map<String, String> pagesOfYesterday;
    @Getter
    @Setter
    private Map<String, String> pagesOfToday;

    public Map<String, PageStatus> getPagesStatuses() {
        Map<String, PageStatus> pagesStatuses = new HashMap<>();

        List<String> URLS = new ArrayList<>();
        URLS.addAll(pagesOfYesterday.keySet());
        URLS.addAll(pagesOfToday.keySet());

        URLS.forEach(URL -> {
            pagesStatuses.put(URL, this.getPageStatus(URL));
        });

        return pagesStatuses;
    }

    private PageStatus getPageStatus(String URL) {
        if (this.isPageDeleted(URL)) {
            return PageStatus.DELETED;
        } else if (this.isPageCreated(URL)) {
            return PageStatus.CREATED;
        } else if (this.isPageChanged(URL)) {
            return PageStatus.CHANGED;
        }

        return PageStatus.UNCHANGED;
    }

    private boolean isPageDeleted(String URL) {
        boolean isPageExistToday = pagesOfToday.get(URL) != null;
        boolean isPageExistYesterday = pagesOfYesterday.get(URL) != null;

        return !isPageExistToday && isPageExistYesterday;
    }

    private boolean isPageCreated(String URL) {
        boolean isPageExistToday = pagesOfToday.get(URL) != null;
        boolean isPageExistYesterday = pagesOfYesterday.get(URL) != null;

        return isPageExistToday && !isPageExistYesterday;
    }

    private boolean isPageChanged(String URL) {
        String pageOfYesterday = this.pagesOfYesterday.get(URL);
        String pageOfToday = this.pagesOfToday.get(URL);

        if (pageOfYesterday == null || pageOfToday == null) {
            return false;
        }

        return !pageOfToday.equals(pageOfYesterday);
    }
}
