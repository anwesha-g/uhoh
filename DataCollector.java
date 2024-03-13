import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataCollector {
    private ArrayList<String> socialMediaPosts;
    private ArrayList<String> targetWords;
    private Scanner sc;
    private int currentPost;
    private int currentTargetWord;

    public DataCollector() {
        socialMediaPosts = new ArrayList<String>();
        targetWords = new ArrayList<String>();
        currentPost = 0;
        currentTargetWord = 0;
    }

    public void setData(String socialMediaPostsFilename, String targetWordsFilename) {
        // Read in the social media posts
        try {
            sc = new Scanner(new File(socialMediaPostsFilename));
            while (sc.hasNextLine()) {
                String temp = sc.nextLine().trim();
                this.socialMediaPosts.add(temp);
            }
        } catch (FileNotFoundException e) { 
            System.out.println("Error reading or parsing socialMediaPosts\n" + e); 
        }

        // Read in the target words
        try {
            sc = new Scanner(new File(targetWordsFilename));
            while (sc.hasNextLine()) {
                this.targetWords.add(sc.nextLine().trim());
            }
        } catch (FileNotFoundException e) { 
            System.out.println("Error reading or parsing targetWords\n" + e); 
        }
    }

    public String getNextPost() {
        if (currentPost < socialMediaPosts.size()) {
            return socialMediaPosts.get(currentPost++);
        } else {
            return "NONE";
        }
    }

    public String getNextTargetWord() {
        if (currentTargetWord < targetWords.size()) {
            return targetWords.get(currentTargetWord++);
        } else {
            currentTargetWord = 0; // Reset for reuse (i have no idea whats goign on)
            return "NONE";
        }
    }

    // Modified prepareAdvertisement to include the message content AAAH fuck fuck 
    public void prepareAdvertisement(String filename, ArrayList<String> usernames, String message) {
        try {
            FileWriter fw = new FileWriter(filename, false); // false to overwrite
            fw.write(message + "\n\n"); // Ad message followed by two newlines for separation
            for (String username : usernames) {
                fw.write("@" + username + "\n"); // Prefix usernames with @ for clarity
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Could not write to file. " + e);
        }
    }

}
