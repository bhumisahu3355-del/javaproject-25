import java.util.Scanner;

class Feedback {
    int rating;
     String comment;

    public Feedback(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}

class Analyzer {
    public static double calculateAverage(Feedback[] feedbacks) {
        int sum = 0;
        for (Feedback f : feedbacks) {
            sum += f.getRating();
        }
        return (double) sum / feedbacks.length;
    }

    public static String getSentiment(double avg) {
        int option = (int) Math.floor(avg);
        switch (option) {
            case 5:
                return "Excellent";
            case 4:
                return "Good";
            case 3:
                return "Average";
            default:
                return "Poor";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of feedbacks: ");
        int n = sc.nextInt();
        sc.nextLine();

        Feedback[] feedbacks = new Feedback[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter rating (1-5): ");
            int rating = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter comment: ");
            String comment = sc.nextLine();
            feedbacks[i] = new Feedback(rating, comment);
        }

        double avg = Analyzer.calculateAverage(feedbacks);
        String sentiment = Analyzer.getSentiment(avg);

        System.out.println("\nAverage Rating: " + avg);
        System.out.println("Customer Sentiment: " + sentiment);
        sc.close();
    }
}
