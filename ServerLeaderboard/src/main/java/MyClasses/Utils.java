package MyClasses;


import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Omer
 */
public class Utils {
    public static String[] names = {
            "Jack",
            "Baron",
            "Aimee",
            "Duke",
            "Chad",
            "Tatiana",
            "Lesley",
            "Freedom",
            "Liberty",
            "Barney",
            "Deimos",
            "Achilles",
            "Marcus",
            "Plato",
            "Pythagoras",
            "Lucifer"
    };
    
    public static final String WrapWithTag(String text, String tag) {
        return "<" + tag + ">" + text + "</" + tag + ">";
    }

    public static String serveNContestants(int n) {
        if(n > 150) {
            return WrapWithTag(Messages.MESSAGE_ERROR_TOO_MANY_CONTESTANTS, "h4");
        } else if(n <= 0) {
            return WrapWithTag(Messages.MESSAGE_ERROR_MUST_BE_ABOVE_ZERO, "h4");
        }
        
        String contestants = "";
        Random random = new Random();
        
        for(int i = 0; i < n; i++) {
            int randInt = random.nextInt(names.length);
            int score = random.nextInt(100);

            String scoreStyle = "style=\"";
            if("Lucifer".equals(names[randInt])) {
                score = 666;
            }

            // Changes the color of the points based
            // on how good they are
            if(score == 666) {
                scoreStyle += "color:#F03E3E;";
            }
            else if(score > 80) {
                scoreStyle += "color:#40C057;";
            }
            else if(score >= 61 && score < 81) {
                scoreStyle += "color:#FCC419;";
            }
            else if(score <= 60) {
                scoreStyle += "color:#FD7E14;";
            }

            scoreStyle += "\"";

            // Generates the style for a single contestant
            String listItemStyle = "style=\"margin: 1em; "
                    + "padding: 1em; "
                    + "background-color: #F8F9FA; "
                    + "border-radius: 1em; "
                    + "box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;"
                    + "color: #2C2E33;\"";

            contestants += "<div " + listItemStyle + ">";
            contestants += "<h3>" + names[randInt] + "</h3>";
            contestants += "<h3 " + scoreStyle + ">" + score + "</h3>";
            contestants += "</div>";
        }
        
        return contestants;
    }
}
