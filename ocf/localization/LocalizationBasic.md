Localization (L10n) in Java allows your application to adapt to different languages and regions without code changes. This is managed primarily through Locales, Resource Bundles, and Formatters.
## 1. The Locale Class
A Locale object represents a specific geographical, political, or cultural region. It is typically defined by a language code (e.g., en for English) and a country code (e.g., US for United States).
```java
Locale usLocale = Locale.US;
Locale frLocale = new Locale("fr", "FR"); // French/France
```
## 2. Resource Bundles
Resource bundles store locale-specific text in .properties files.

* Naming Convention: basename_language_country.properties
* Example Files:
* Messages_en_US.properties -> greeting=Hello
   * Messages_fr_FR.properties -> greeting=Bonjour

Loading the Bundle:
```java
ResourceBundle bundle = ResourceBundle.getBundle("Messages", usLocale);
String msg = bundle.getString("greeting");
```
## 3. Formatting Numbers, Currency, and Percentages
The NumberFormat class handles the cultural differences in how numbers are displayed (e.g., using commas vs. dots).
```java
double amount = 1234.56;
// Currency
NumberFormat usd = NumberFormat.getCurrencyInstance(Locale.US);
System.out.println(usd.format(amount)); // $1,234.56

NumberFormat eur = NumberFormat.getCurrencyInstance(Locale.FRANCE);
System.out.println(eur.format(amount)); // 1 234,56 €
// Percentagedouble percent = 0.75;
NumberFormat pct = NumberFormat.getPercentInstance(Locale.FRANCE);
System.out.println(pct.format(percent)); // 75 %
```
## 4. Formatting Dates and Times
Use DateTimeFormatter with the localizedBy() method to format dates according to local customs.
```java
ZonedDateTime now = ZonedDateTime.now();

DateTimeFormatter formatter = DateTimeFormatter
    .ofLocalizedDateTime(FormatStyle.LONG)
    .localizedBy(Locale.FRANCE);

System.out.println(now.format(formatter)); // 10 avril 2026 à 20:38:00 HKT
```
## 5. Message Formatting (Placeholders)
The MessageFormat class allows you to inject dynamic data into localized strings, handling pluralization and variable positioning.
Properties file:
alert = On {0, date}, there were {1, number} files found.
Java code:
```java
String pattern = bundle.getString("alert");
MessageFormat mf = new MessageFormat(pattern, Locale.US);
Object[] args = { new Date(), 5 };
System.out.println(mf.format(args)); // On Apr 10, 2026, there were 5 files found.
```
## Summary of Best Practices

* Never Hardcode Strings: Always move user-facing text to resource bundles.
* Use the Right Locale: Use Locale.getDefault() for the user's system setting, but allow them to override it in the app settings.
* Avoid String Concatenation: Use MessageFormat for sentences with variables so translators can change the word order.
