package pl.droidsonroids.jspoon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jsoup.nodes.Element;
import pl.droidsonroids.jspoon.HtmlAdapter;

/**
 * Annotates a field to be mapped to a html element.
 *
 * A field annotated with this will receive the value corresponding to it's CSS
 * selector when the {@link HtmlAdapter#fromHtml(String)} is called.
 *
 * Can be applied to any field of the following types (or their primitive equivalents)
 * String
 * Float
 * Double
 * Integer
 * Long
 * Boolean
 * Date
 * BigDecimal
 * {@link Element}
 * Any class with default constructor
 * List of supported type
 *
 * It can also be used with a class, then you don't need to annotate every field inside it.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
public @interface Selector {
    String NO_VALUE = "NO_VALUE";

    /** @return Css query */
    String value();

    /** @return Attribute or property of selected field. "text" is default. Also "html"/"innerHtml" or "outerHtml" is supported. */
    String attr() default "";

    /** @return Regex for numbers and String, date format for Date. */
    String format() default NO_VALUE;

    /** @return Locale string, used for Date and Float */
    String locale() default NO_VALUE;

    /** @return Default String value if selected HTML element is empty */
    String defValue() default NO_VALUE;

    /** @return Index of found HTML element */
    int index() default 0;
}
