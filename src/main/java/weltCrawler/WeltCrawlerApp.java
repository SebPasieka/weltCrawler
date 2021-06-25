package weltCrawler;

public class WeltCrawlerApp {
    public String run(String[] args) {
        int digit = Integer.parseInt(args[0]);
        if (digit > 10 || digit <= 0) {
            return "digit too high or low";
        } else {
            return new RandomNumberService().getRandomNumber(digit);
        }
    }
}
