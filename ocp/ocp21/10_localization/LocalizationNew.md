Localization (often abbreviated as **i18n**) in Java allows your application to support **multiple languages, regions, and cultural formats** (like dates, currency, numbers). Java provides powerful tools via `Locale`, `ResourceBundle`, and formatting classes.

Let’s go step by step.

---

# 1. **What is Localization?**

Localization means adapting your application to:

* Language (English, Chinese, French…)
* Region (US, UK, Japan…)
* Formatting rules (dates, currency, numbers)

👉 Example:

* US: `$1,234.56`
* Germany: `1.234,56 €`

---

# 2. **`Locale` (Core of Localization)**

A `Locale` represents a **specific language + region**.

### Create Locale

```java
import java.util.Locale;

// Language only
Locale locale1 = new Locale("en");

// Language + country
Locale locale2 = new Locale("en", "US");

// Predefined
Locale locale3 = Locale.FRANCE;
Locale locale4 = Locale.JAPAN;
```

---

# 3. **ResourceBundle (Multi-language Text)**

Used to store **localized messages** in property files.

---

## Step 1: Create Resource Files

```
messages.properties        (default)
messages_en_US.properties  (English - US)
messages_fr_FR.properties  (French)
```

### Example:

**messages_en_US.properties**

```properties
greeting=Hello
farewell=Goodbye
```

**messages_fr_FR.properties**

```properties
greeting=Bonjour
farewell=Au revoir
```

---

## Step 2: Load ResourceBundle

```java
import java.util.*;

Locale locale = Locale.FRANCE;
ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

System.out.println(bundle.getString("greeting")); // Bonjour
```

---

# 4. **Message Formatting (`MessageFormat`)**

Used to create **dynamic localized messages**.

```java
import java.text.MessageFormat;
import java.util.Locale;

String pattern = "Hello {0}, you have {1} messages";
MessageFormat mf = new MessageFormat(pattern, Locale.US);

String result = mf.format(new Object[]{"Alice", 5});
System.out.println(result);
```

---

## With ResourceBundle:

```properties
welcome=Hello {0}, today is {1}
```

```java
String pattern = bundle.getString("welcome");
MessageFormat mf = new MessageFormat(pattern, locale);

String msg = mf.format(new Object[]{"Alice", "Monday"});
```

---

# 5. **Date and Time Formatting**

### Using `DateTimeFormatter`

```java
import java.time.*;
import java.time.format.*;
import java.util.Locale;

LocalDate date = LocalDate.now();

DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.US);

System.out.println(date.format(formatter));
```

---

### Localized Styles

```java
DateTimeFormatter formatter =
    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                     .withLocale(Locale.FRANCE);

System.out.println(date.format(formatter));
```

👉 Output (France):

```
mardi 14 avril 2026
```

---

# 6. **Number Formatting**

### Using `NumberFormat`

```java
import java.text.NumberFormat;
import java.util.Locale;

double number = 1234567.89;

NumberFormat nf = NumberFormat.getInstance(Locale.US);
System.out.println(nf.format(number)); // 1,234,567.89

nf = NumberFormat.getInstance(Locale.GERMANY);
System.out.println(nf.format(number)); // 1.234.567,89
```

---

# 7. **Currency Formatting**

```java
NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
System.out.println(cf.format(1234.56)); // $1,234.56

cf = NumberFormat.getCurrencyInstance(Locale.JAPAN);
System.out.println(cf.format(1234.56)); // ￥1,235
```

---

# 8. **Percentage Formatting**

```java
NumberFormat pf = NumberFormat.getPercentInstance(Locale.US);
System.out.println(pf.format(0.75)); // 75%
```

---

# 9. **Parsing Values**

You can also convert formatted strings back to numbers.

```java
NumberFormat nf = NumberFormat.getInstance(Locale.US);

Number num = nf.parse("1,234.56");
System.out.println(num.doubleValue());
```

---

# 10. **Complete Example**

```java
import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.*;

public class LocalizationDemo {
    public static void main(String[] args) throws Exception {

        Locale locale = Locale.FRANCE;

        // ResourceBundle
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        System.out.println(bundle.getString("greeting"));

        // MessageFormat
        String pattern = "User {0} has {1} points";
        MessageFormat mf = new MessageFormat(pattern, locale);
        System.out.println(mf.format(new Object[]{"Alice", 100}));

        // Date
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                             .withLocale(locale);
        System.out.println(date.format(dtf));

        // Number
        NumberFormat nf = NumberFormat.getInstance(locale);
        System.out.println(nf.format(1234567.89));

        // Currency
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        System.out.println(cf.format(1234.56));

        // Percentage
        NumberFormat pf = NumberFormat.getPercentInstance(locale);
        System.out.println(pf.format(0.85));
    }
}
```

---

# 11. **Best Practices**

### ✅ Use `Locale` everywhere

* Don’t hardcode formats

### ✅ Externalize messages

* Always use `ResourceBundle`

### ✅ Use built-in formatters

* `NumberFormat`, `DateTimeFormatter`

### ❌ Avoid:

```java
"$" + amount   // wrong for localization
```

---

# 12. **Summary**

* `Locale` → defines region/language
* `ResourceBundle` → localized text
* `MessageFormat` → dynamic messages
* `DateTimeFormatter` → date/time formatting
* `NumberFormat` → numbers, currency, percentages

---

If you want, I can next explain:

* **how localization is implemented in Spring (MessageSource)**
* or **how to design multi-language applications (real-world architecture)**
