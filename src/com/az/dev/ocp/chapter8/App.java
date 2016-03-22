package com.az.dev.ocp.chapter8;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private Scanner userinput = new Scanner(System.in);

    public static void main(String[] args) {

        final App application = new App();

        application.dateAndCalendarTesting();

        application.moreDateAndCalendarTesting();

        application.typesOfDateFormats();

        application.dateFormatParsing();

        application.localeTest();

        application.defaultLocaleExample();

        application.numberFormatTest();

        application.anotherNumberFormatTest();

        application.formattingStringsUsingPrintf();

        application.searchStringPattern();

        application.searchForDigitsInString();

        application.searchForAnythingButWhiteSpace();

        application.boundaryMatching(); // BOUNDARY MATCHING...

        application.tokenizeUsingStringsSplit();
        
        application.customResourceBundleTest();
    }

    private void customResourceBundleTest () {
        System.out.println("CUSTOM RESOURCE BUNDLE TESTING\n");
        final MyResourceBundle_FR label = new MyResourceBundle_FR();
        System.out.println("Getting a value from a resource using 'hello' key\t:\t" + label.getObject("hello"));
        System.out.println("Getting a value from a resource using 'welcome' key\t:\t" + label.getString("welcome"));
        addSepparator();
    }
    
    @SuppressWarnings("deprecation")
    private void moreDateAndCalendarTesting() {
        System.out.println("MORE DATE AND CALENDAR TESTING...\n");
        final Date date = new Date();
        System.out.println("Get current date using date.getDate()\t\t:\t" + date.getDate());
        
        final Calendar calendar = Calendar.getInstance();
        final Date currentDate = calendar.getTime();
        System.out.println("Get current date using calendar.getTime()\t:\t" + currentDate);

        System.out.println("Get current date using new Date() object\t:\t" + date);
        System.out.println("Get current date using date.getTime()\t\t:\t" + date.getTime());
        
        addSepparator();
    }
    
    private void defaultLocaleExample() {
        System.out.println("CHANGING DEFAULT LOCALE\n");

        final Locale initial = Locale.getDefault();
        System.out.println("Initial Locale\t\t:\t" + initial);

        Locale.setDefault(Locale.GERMANY);
        System.out.println("Locale changed to\t:\t" + Locale.getDefault());

        Locale.setDefault(initial);
        System.out.println("Back to initial Locale\t:\t" + Locale.getDefault());
        addSepparator();
    }

    private void formattingStringsUsingPrintf() {
        System.out.println("FORMATTING STRINGS USING printf() METHOD\n");
        final int i1 = -123;
        final int i2 = 12345;
        System.out.printf("Using printf() and '1$(7d' on " + i1 + "\t\t:\t" +  ">%1$(7d< \n", i1);
        System.out.printf("Using printf() and '0,7d' on " + i2 + "\t\t:\t" + ">%0,7d< \n", i2);
        System.out.printf("Using printf() and '+-7d' on " + i2 + "\t\t:\t" + ">%+-7d< \n", i2); // display the second arg with - or plus depending on the value
        System.out.printf("Using printf() and '2$b + 1$5d' on " + i2 + "\t:\t" + ">%2$b + %1$5d< \n", i1, false);
        addSepparator();
    }

    private void tokenizeUsingStringsSplit() {
        System.out.println("TOKENIZE USING STRINGS split() METHOD\n");
        System.out.print("Enter source to tokenize\t:\t");
        final String source = userinput.nextLine();
        System.out.print("Enter delimiter\t\t\t:\t");
        final String pattern = userinput.nextLine();
        final String[] tokens = source.split(pattern);
        System.out.println("Count\t\t:\t" + tokens.length);
        for (String s : tokens) {
            System.out.println("Token\t\t:\t" + ">" + s + "<");
        }
        addSepparator();
    }

    private void boundaryMatching() {
        System.out.println("BOUNDARY MATCHING\n");
        
        final String text = "w2w w$ &#w2";
        final String patternString = "\\b";
        final Pattern pattern = Pattern.compile(patternString);
        final Matcher matcher = pattern.matcher(text);
        System.out.println("Source\t\t\t:\t" + text);
        System.out.println("Expression\t\t:\t" + matcher.pattern());
        System.out.print("Found at position\t:\t");
        
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }
        System.out.println("");
        addSepparator();    
    }

    private void searchForDigitsInString() {
        System.out.println("SEARCHING FOR DIGITS IN A STRING\n");
        final String text = "abc12h3jk4gf5f343dsdf3";
        final String patternString = "\\d";
        final Pattern pattern = Pattern.compile(patternString);
        final Matcher matcher = pattern.matcher(text);
        System.out.println("Source\t\t\t:\t" + text);
        System.out.println("Expression\t\t:\t" + matcher.pattern());
        System.out.print("Found at position\t:\t");
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }
        System.out.println("");
        addSepparator();
    }

    private void searchForAnythingButWhiteSpace() {
        System.out.println("SEARCH FOR ANYTHING BUT WHITESPACE\n");
        final String text = "Hel lo W      or ld";
        final String patternString = "\\S";
        final Pattern pattern = Pattern.compile(patternString);
        final Matcher matcher = pattern.matcher(text);
        System.out.println("Source\t\t\t:\t" + text);
        System.out.println("Expression\t\t:\t" + matcher.pattern());
        System.out.print("Found at position\t:\t");
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }

        System.out.println("");
        addSepparator();
    }

    private void searchStringPattern() {
        System.out.println("SEARCHING FOR STRING PATTERN\n");
        final String helloWorldString = "Hello World Hello World Hello World";
        final String patternString = "or";
        final Pattern pattern = Pattern.compile(patternString);
        final Matcher matcher = pattern.matcher(helloWorldString);
        System.out.println("Source\t\t\t:\t" + helloWorldString);
        System.out.println("Expression\t\t:\t" + matcher.pattern());
        System.out.print("Found at position\t:\t");
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }
        System.out.println("");
        addSepparator();
    }

    private void dateAndCalendarTesting() {
        System.out.println("DATE AND CALENDAR TESTING\n");
        
        final Date d1 = new Date(1_000_000_000_000L);
        System.out.println("Initial date\t\t\t:\t" + d1.toString());
        
        final Calendar c = Calendar.getInstance();
        c.setTime(d1);

        if (Calendar.MONDAY == c.getFirstDayOfWeek()) {
            System.out.println("First day of the week\t\t:\t" + c.getDisplayName(Calendar.DAY_OF_WEEK, 1, Locale.getDefault()));
            System.out.println("Day of the week is\t\t:\t" + c.get(Calendar.DAY_OF_WEEK));
            System.out.println("\nUsing calendar.add(Calendar.MONTH, 1) to add a Month to the date...");
            c.add(Calendar.MONTH, 1);
            final Date d2 = c.getTime();
            System.out.println("New date after adding a month\t:\t" + d2.toString());
        }
        
        System.out.println("\nUsing c.roll(Calendar.MONTH, 10) will add 10 months to the date, but it won't affect the year");
        c.roll(Calendar.MONTH, 10);
        System.out.println("Date after usingj roll() method\t:\t" + c.getTime());
        
        addSepparator();
    }

    private void typesOfDateFormats() {
        System.out.println("DateFormat TESTING\n");
        final Date date = new Date(1_000_000_000_000L);
        DateFormat[] dfa = new DateFormat[6];
        dfa[0] = DateFormat.getInstance();
        dfa[1] = DateFormat.getDateInstance();
        dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
        dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println("Default format\t\t:\t" + dfa[0].format(date));
        System.out.println("Default date format\t:\t" + dfa[1].format(date));
        System.out.println("SHORT date format\t:\t" + dfa[2].format(date));
        System.out.println("MEDIUM date format\t:\t" + dfa[3].format(date));
        System.out.println("LONG date format\t:\t" + dfa[4].format(date));
        System.out.println("FULL date format\t:\t" + dfa[5].format(date));
        
        addSepparator();
    }

    private void dateFormatParsing() {
        System.out.println("PARSING DateFormat\n");
        final Date date = new Date();
        System.out.println("Initial date\t\t\t:\t" + date.toString());

        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        final String dateString = dateFormat.format(date);
        System.out.println("String with SHORT format\t:\t" + dateString);

        try {
            final Date parsedDate = dateFormat.parse(dateString);
            System.out.println("Parsed back to date\t\t:\t" + parsedDate);
        } catch (final ParseException pe) {
            System.out.println("Parsing Exception occured");
        }
        
        addSepparator();
    }

    private void localeTest() {
        System.out.println("LOCALE TESTS\n");
        final Locale italianLocale = new Locale("it");
        final Locale brazilianLocale = new Locale("pt", "BR");

        final Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 02, 10);
        final Date date = calendar.getTime();
        
        System.out.println("Date without any formatting\t\t:\t" + date);

        final DateFormat currentLocaleDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Date with current locale format (NL)\t:\t" + currentLocaleDateFormat.format(date));

        final DateFormat italianDateFormat = DateFormat.getDateInstance(DateFormat.FULL, italianLocale);
        System.out.println("Formatted date to Italian locale\t:\t" + italianDateFormat.format(date));

        final DateFormat brazilianDateFormatWithCountryCode = DateFormat.getDateInstance(DateFormat.FULL, brazilianLocale);
        System.out.println("Brazilian locale with country cody\t:\t" + brazilianDateFormatWithCountryCode.format(date));
        System.out.println("Get the display country from locale\t:\t" + brazilianLocale.getDisplayCountry());
        System.out.println("Display country in it's own language\t:\t" + brazilianLocale.getDisplayCountry(brazilianLocale));
        System.out.println("'Portuguese' written in Italian \t:\t" + brazilianLocale.getDisplayLanguage(italianLocale));

        addSepparator();
    }

    private void numberFormatTest() {
        System.out.println("FORMATTING NUMBERS USING NumberFormat\n");
        final float floatNumber = 123.457f;
        final Locale usLocale = new Locale("en", "US");
        final NumberFormat[] numberFormat = new NumberFormat[4];

        Locale dutchLocale = new Locale("nl", "NL");
        Locale.setDefault(dutchLocale);
        
        numberFormat[0] = NumberFormat.getInstance();
        numberFormat[1] = NumberFormat.getInstance(usLocale);
        numberFormat[2] = NumberFormat.getCurrencyInstance();
        numberFormat[3] = NumberFormat.getCurrencyInstance(usLocale);

        System.out.println("A floating point number\t\t:\t" + floatNumber);
        System.out.println("Formatted with dutch locale\t:\t" + numberFormat[0].format(floatNumber));
        System.out.println("US locale with same number\t:\t" + numberFormat[1].format(floatNumber));
        System.out.println("Dutch locale with currency\t:\t" + numberFormat[2].format(floatNumber));
        System.out.println("US locale with currency\t\t:\t" + numberFormat[3].format(floatNumber));
        
        addSepparator();
    }

    private void anotherNumberFormatTest() {
        System.out.println("MORE NumberFormat TESTING\n");
        final float f1 = 123.456789f;
        final NumberFormat numberFormat = NumberFormat.getInstance();
        System.out.println("A floating point number\t\t\t\t:\t" + f1);
        System.out.println("Default maximum fractions on the number format\t:\t" + numberFormat.getMaximumFractionDigits());
        System.out.println("Format the number using default max factions\t:\t" + numberFormat.format(f1));
        numberFormat.setMaximumFractionDigits(2);
        System.out.println("Set the max fraction digits to 2 on the format\t:\t" + numberFormat.format(f1));

        try {
            System.out.println("Number before setParseIntegerOnly() method\t:\t" + numberFormat.parse("123,45678")); // using Netherlands locale
            numberFormat.setParseIntegerOnly(true);
            System.out.println("Number after setting this to true\t\t:\t" + numberFormat.parse("123,45678"));
        } catch (final ParseException pe) {
            System.out.println("Parsing encounterd an Exception");
        }
        addSepparator();
    }

    private void addSepparator() {
        System.out.println(
            "-----------------------------------------------------------------------------------------------------------------------");
    }

}
