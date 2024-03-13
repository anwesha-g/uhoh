import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class TargetedAd {

    public static void main(String[] args) {
        System.out.println("Start");
        DataCollector dc = new DataCollector();
        dc.setData("socialMediaPosts.txt", "sentimentWords.txt");
        ArrayList<String> positiveUsers = new ArrayList<>();
        ArrayList<String> negativeUsers = new ArrayList<>();
        HashMap<String, String> sentimentWords = new HashMap<>();

        // Load sentiment words and their sentiment
        try {
            File file = new File("sentimentWords.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                if (parts.length == 2) {
                    sentimentWords.put(parts[0], parts[1]); // word, sentiment
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Analyze posts for sentiment
        String np;
        while (!(np = dc.getNextPost()).equals("NONE")) {
            boolean foundPositive = false;
            boolean foundNegative = false;

            for (String word : sentimentWords.keySet()) {
                if (np.toLowerCase().contains(word.toLowerCase())) {
                    if ("positive".equals(sentimentWords.get(word))) {
                        foundPositive = true;
                    } else if ("negative".equals(sentimentWords.get(word))) {
                        foundNegative = true;
                    }
                }
            }

            int index = np.indexOf(" ");
            String username = np.substring(0, index);
            if (foundPositive) {
                positiveUsers.add(username);
            }
            if (foundNegative) {
                negativeUsers.add(username);
            }
        }

        // Prepare advertisements based on sentiment
        String positiveAdContent = "Thank you for your positive feedback! Check out our new products!";
        String negativeAdContent = "We're sorry to hear about your experience. Here's a discount code for your next purchase.";

        // Assuming you have a method in DataCollector to prepare ads (you'll need to modify it to fit this context)
        dc.prepareAdvertisement("positiveAd.txt", positiveUsers, positiveAdContent);
        dc.prepareAdvertisement("negativeAd.txt", negativeUsers, negativeAdContent);

        System.out.println("Done");
    }
}

