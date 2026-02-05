/*
 * helloworld.java
 * Fun facts for 26 January (CLI, filterable)
 *
 * Compile: javac helloworld.java
 * Run:     java helloworld            # show all facts
 *          java helloworld india     # India-related facts
 */

public class helloworld {

    private static class Fact {
        final String tag;
        final String title;
        final String description;
        Fact(String tag, String title, String description) {
            this.tag = tag; this.title = title; this.description = description;
        }
    }

    private static final Fact[] FACTS = new Fact[] {
        new Fact("india", "Republic Day (India, 1950)",
                 "On 26 Jan 1950 the Constitution of India came into effect and India became a republic."),
        new Fact("india", "Purna Swaraj (1930)",
                 "Indian National Congress declared 26 Jan 1930 as Purna Swaraj (Complete Independence) day — later chosen for Republic Day."),
        new Fact("australia", "Australia Day (First Fleet, 1788)",
                 "Australia Day commemorates the arrival of the First Fleet at Port Jackson on 26 Jan 1788 (the day is also contested and discussed).") ,
        new Fact("international", "International Customs Day (1953)",
                 "International Customs Day is observed on 26 Jan to mark the founding of the Customs Cooperation Council in 1953 (now WCO)."),
        new Fact("misc", "Parade traditions",
                 "India's Republic Day features a grand parade in New Delhi with state tableaux, cultural performances and invited foreign dignitaries."),
        new Fact("misc", "Beating Retreat",
                 "In India the official Republic Day ceremonies conclude a few days later with the Beating Retreat ceremony (traditionally on Jan 29).")
    };

    public static void main(String[] args) {
        String filter = (args.length == 0) ? "all" : args[0].toLowerCase().trim();

        System.out.println("=====================================");
        System.out.println(" Amazing fun fact for the month of January 26");
        System.out.println("=====================================");
        System.out.println();

        int count = 0;
        for (Fact f : FACTS) {
            if (matchesFilter(f.tag, filter)) {
                count++;
                System.out.printf("%d. %s\n   %s\n\n", count, f.title, f.description);
            }
        }

        if (count == 0) {
            System.out.println("No facts found for filter: '" + filter + "'. Try: all, india, australia, international, misc");
        } else {
            System.out.printf("Displayed %d fact(s).\n", count);
        }

        System.out.println();
        System.out.println("Usage: java helloworld [all|india|australia|international|misc]");
    }

    private static boolean matchesFilter(String tag, String filter) {
        if ("all".equals(filter)) return true;
        return tag.equalsIgnoreCase(filter);
    }
}
