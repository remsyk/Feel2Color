package com.example.i77ki.feel2color_test1;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by i77ki on 6/26/2018.
 */

public class String2Color {

	private static final String TAG = "String2Color Data";
	private static int red, green, blue, hue, saturation, brightness;

	@RequiresApi(api = Build.VERSION_CODES.O)
	private static int colorFeel(int  red, int green, int blue, float hue, float saturation, float brightness) {

		Color c = Color.valueOf(red, green, blue);
		float[] hsb = new float[3]; //RGBToHSV third argument is a float array, for the HSB
		hsb[0]=hue;
		hsb[1]=saturation;
		hsb[2]=brightness;
		c.RGBToHSV(red, green, blue, hsb);

		Log.v(TAG,c.toString());

		//Log.v(TAG,Integer.toString(c.toArgb()));

		return c.toArgb();
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	public static int wordColor(String userEnt, int length) {

		String[] joyful = { "Amused", "Buoyant", "Delighted", "Elated", "Ecstatic", "Glad", "Gleeful", "happy",
				"Jubilant", "Merry", "Mirthful", "Overjoyed", "Pleased", "Radiant", "Tickled", "excited", "sexy",
				"energetic", "playful", "creative", "aware", "daring", "fascinating", "stimulating", "extravagant",
				"delightful" };
		String[] sad = { "guilty", "ashamed", "depressed", "lonely", "bored", "sleepy", "bashful", "stupid",
				"miserable", "inadequate", "inferior", "apathetic", "blue", "dejected", "despair", "sad", "despondent",
				"disappointed", "gloomy", "grief", "heavy", "hopeless", "melancholy", "sorrow", "unhappy", "lonely",
				"nothing" };
		String[] peaceful = { "content", "thoughtful", "intimate", "loving", "trusting", "nurturing", "pensive",
				"relaxed", "responsive", "serene", "sentimental", "thankful", "blissful", "calm", "centered", "clear",
				"mellow", "quiet", "tranquil", "close", "friendly", "loving", "openhearted", "open", "tender", "enough",
				"understanding", "easy", "free", "interested", "receptive", "kind" };
		String[] powerful = { "faithful", "important", "hopeful", "appreciated", "respected", "proud", "confident",
				"intelligent", "worthwile", "valuable", "satisfied", "amazed", "awed", "uplifted", "optimisic", "went",
				"played", "won", "ran", "walked", "walk", "power", "strong", "openhearted", "play" };
		String[] scared = { "rejected", "confused", "helpless", "submissive", "insecure", "anxious", "bewildered",
				"discouraged", "insignificant", "weak", "foolish", "embarrassed", "dismay", "startled", "surprised",
				"horrified", "anxious", "edgy", "restless", "stress", "uneasy", "scared", "fright", "shock",
				"affraid" };
		String[] mad = { "hurt", "hostile", "angry", "rage", "hate", "critical", "jealous", "selfish", "frustrated",
				"furious", "irritated", "skeptical", "agitated", "troubled", "turmoil", "dislike", "distain", "scorn",
				"surly", "enraged", "hate", "vengeful", "distain", "ticked", "appalled" };

		for (int i = 0; i < length; i++) {
			green += countOccur(userEnt.toLowerCase(), scared[i].toLowerCase());
			blue += countOccur(userEnt.toLowerCase(), sad[i].toLowerCase());
			red += countOccur(userEnt.toLowerCase(), mad[i].toLowerCase());
			hue += countOccur(userEnt.toLowerCase(), peaceful[i].toLowerCase());
			saturation += countOccur(userEnt.toLowerCase(), powerful[i].toLowerCase());
			brightness += countOccur(userEnt.toLowerCase(), joyful[i].toLowerCase());
		}

		Log.v(TAG, userEnt);

		return colorFeel((red * 7), (green * 3), (blue * 6), (hue + 7), (saturation + 9), (brightness * 9)); //changed "*" to "+" for testing purposes
	}

	private static int countOccur(String entry, String toFind){
		int i = 0;
		Pattern p = Pattern.compile(toFind);
		Matcher m = p.matcher( entry );
		while (m.find()) {
			i++;
		}
		return i;
	}
}
