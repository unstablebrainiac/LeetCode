package companies.rockwellautomation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class HiddenText {

    private static Map<Integer, Character> lookupTable;

    public static void main(String[] args) {
        lookupTable = new HashMap<>();
        lookupTable.put(0,'n');
        lookupTable.put(1,'m');
        lookupTable.put(2,'a');
        lookupTable.put(3,'l');
        lookupTable.put(4,'c');
        lookupTable.put(5,'b');
        lookupTable.put(6,'j');
        lookupTable.put(7,'k');
        lookupTable.put(8,'i');
        lookupTable.put(9,'d');
        lookupTable.put(10,'e');
        lookupTable.put(11,'f');
        lookupTable.put(12,'h');
        lookupTable.put(13,'o');
        lookupTable.put(14,'q');
        lookupTable.put(15,'g');
        lookupTable.put(16,'r');
        lookupTable.put(17,'p');
        lookupTable.put(18,'w');
        lookupTable.put(19,'v');
        lookupTable.put(20,'u');
        lookupTable.put(21,'t');
        lookupTable.put(22,'z');
        lookupTable.put(23,'s');
        lookupTable.put(24,'y');
        lookupTable.put(25,'x');
        try {
            // Load the left and right images
            BufferedImage leftImage = ImageIO.read(new File("rockwellautomation/left.bmp"));
            BufferedImage rightImage = ImageIO.read(new File("rockwellautomation/right.bmp"));

            // Decode the hidden message
            String hiddenMessage = decodeHiddenMessage(leftImage, rightImage);

            // Display the solution string
            System.out.println("Solution: " + hiddenMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String decodeHiddenMessage(BufferedImage leftImage, BufferedImage rightImage) {
        StringBuilder solution = new StringBuilder();

        // Iterate through each row
        for (int y = 0; y < leftImage.getHeight(); y++) {

            boolean found = false;
            // Iterate through each column
            for (int x = 0; x < leftImage.getWidth(); x++) {
                // Get the RGB values of the left and right images
                int leftRGB = leftImage.getRGB(x, y);
                int rightRGB = rightImage.getRGB(x, y);

                // Extract the red, green, and blue components of the left and right images
                int leftRed = (leftRGB >> 16) & 0xff;
                int leftGreen = (leftRGB >> 8) & 0xff;
                int leftBlue = leftRGB & 0xff;

                int rightRed = (rightRGB >> 16) & 0xff;
                int rightGreen = (rightRGB >> 8) & 0xff;
                int rightBlue = rightRGB & 0xff;

                // if they are same
                if (leftRed == rightRed && leftGreen == rightGreen && leftBlue == rightBlue) {
                    if (found) {
                        break;
                    } else {
                        found = true;
                        continue;
                    }
                }

                if (found) {
                    solution.append(decodeLetter(leftRed, leftGreen, leftBlue, rightRed, rightGreen, rightBlue));
                }
            }
            solution.append("\n");
        }

        return solution.toString();
    }

    private static char decodeLetter(int leftRed, int leftGreen, int leftBlue, int rightRed, int rightGreen, int rightBlue) {
        // To decode the letters in each word, you will need the rgb color values for the pixel in that location in both images. Once you have these values, find the corresponding letter following these rules:
        //
        //If the red and green values are the same for both pixels, the letter is lowercase. Otherwise, it is uppercase.
        //The blue values of pixels from each image encode the letter information. Take the absolute value of the difference in blue values modulo 26 [i.e., abs(b_1 - b_2) % 26] and use the result to find the letter in the lookup table below. Make sure to respect the capitalization information from the red and green values.

        int letterNumber = Math.abs(leftBlue - rightBlue) % 26;
        char letter = lookupTable.get(letterNumber);

        if (leftRed != rightRed || leftGreen != rightGreen) {
            letter = Character.toUpperCase(letter);
        }

        return letter;
    }
}
